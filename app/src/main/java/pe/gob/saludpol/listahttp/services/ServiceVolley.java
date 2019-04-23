package pe.gob.saludpol.listahttp.services;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import java.util.List;

import pe.gob.saludpol.listahttp.adapter.PersonAdapter;
import pe.gob.saludpol.listahttp.model.Cliente;
import pe.gob.saludpol.listahttp.model.Person;

public class ServiceVolley {

    private String urlWebSite;
    private Context context;
    private final String TAG = "LOG_APP";
    private ProgressDialog progressDialog;

    public ServiceVolley(Context context){
        this.context = context;
        urlWebSite = "http://demos.hypergis.pe/php/";
    }

    private void onPreStartConnection(String pMensaje) {
        progressDialog = ProgressDialog.show(this.context, pMensaje, "por favor espere...");
    }

    private void onConnectionFinished() {
        progressDialog.dismiss();
    }

    private void onConnectionFailed(String error) {
        progressDialog.dismiss();
        String msgError = "Ha ocurrido un error de conexión. Por favor, vuelva a ingresar luego!";
        Toast.makeText(context, msgError, Toast.LENGTH_SHORT).show();
    }

    public void getClientes(final List<Person> httpList,
                            final RecyclerView httpRecycler) {
        String pURL = urlWebSite + "wsCliente.php?num=10&format=json";
        StringRequest jsArrayRequest = new StringRequest(Request.Method.GET,
                pURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Respuesta Volley:" + response);

                Gson gson = new Gson();
                Cliente cliente = gson.fromJson(response, Cliente.class);

                for(int i = 0; i<cliente.getClientes().length; i++){
                    Person item = cliente.getClientes()[i];
                    httpList.add(item);
                }

                PersonAdapter httpAdapter = new PersonAdapter(httpList);
                httpRecycler.setAdapter(httpAdapter);
                onConnectionFinished();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error:" + error.getMessage());
                onConnectionFailed(error.getMessage());
            }
        });

        onPreStartConnection("Descargando");
        VolleyS.getInstance(this.context).addToRequestQueue(jsArrayRequest);
    }
}
