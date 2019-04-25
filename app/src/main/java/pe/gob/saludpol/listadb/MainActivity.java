package pe.gob.saludpol.listadb;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import pe.gob.saludpol.listadb.adapter.PersonAdapter;
import pe.gob.saludpol.listadb.database.CustomersDBHelper;
import pe.gob.saludpol.listadb.model.Person;

public class MainActivity extends AppCompatActivity {

    private List<Person> lista;
    private RecyclerView reciclador;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private FloatingActionButton btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creando la lista de elementos para mostrar en el RecyclerView
        lista = new ArrayList<>();
        FillPerson();

        btnAgregar = (FloatingActionButton)findViewById(R.id.btnGuardar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NuevoCliente();
            }
        });

        //Asignamos la variable reciclador
        reciclador = findViewById(R.id.reciclador);
        reciclador.setHasFixedSize(true);

        //Creando un contenedor del tipo LinearLayout para el RecyclerView
        lManager = new LinearLayoutManager(this);
        reciclador.setLayoutManager(lManager);

        //Asignando el adaptador al RecycleView
        adapter = new PersonAdapter(lista);
        reciclador.setAdapter(adapter);
    }

    private void NuevoCliente() {
        Intent act = new Intent(this, NewActivity.class);
        startActivity(act);
    }

    private void FillPerson() {
        CustomersDBHelper db = new CustomersDBHelper(this);
        lista = db.getClientes();
    }

}
