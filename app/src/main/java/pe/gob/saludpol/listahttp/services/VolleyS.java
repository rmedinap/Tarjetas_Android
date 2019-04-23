package pe.gob.saludpol.listahttp.services;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyS {
    private static VolleyS singleton;
    private RequestQueue requestQueue;
    private static Context context;

    private VolleyS(Context context) {
        VolleyS.context = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized VolleyS getInstance(Context context) {
        if (singleton == null) {
            singleton = new VolleyS(context);
        }
        return singleton;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public  void addToRequestQueue(Request req) {
        getRequestQueue().add(req);
    }
}
