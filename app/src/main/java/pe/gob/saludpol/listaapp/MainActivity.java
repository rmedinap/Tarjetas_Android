package pe.gob.saludpol.listaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pe.gob.saludpol.listaapp.adapter.PersonAdapter;
import pe.gob.saludpol.listaapp.model.Person;

public class MainActivity extends AppCompatActivity {

    private List<Person> lista;
    private RecyclerView reciclador;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creando la lista de elementos para mostrar en el RecyclerView
        lista = new ArrayList<>();
        FillPerson();

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

    private void FillPerson() {
        lista.add(new Person("Juan Perez", "10405857", 22,"Ingeniero de Sistema, con 5 años de experiencia", R.drawable.face02));
        lista.add(new Person("Anita Lavado", "34125857", 53,"Administradora de empresas, con 25 años de experiencia", R.drawable.face03));
        lista.add(new Person("Benito Muñoz", "48675857", 32,"M{usico profesional, con especialidad en musica barroca", R.drawable.face04));
        lista.add(new Person("Otto Orosco", "34643576", 52,"M{usico profesional, con especialidad en musica barroca", R.drawable.face07));

    }

}
