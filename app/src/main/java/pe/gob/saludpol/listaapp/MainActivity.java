package pe.gob.saludpol.listaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        lista = new ArrayList<>();
        FillPerson();
    }

    private void FillPerson() {
        lista.add(new Person("Juan Perez", "10405857", 22,"Ingeniero de Sistema, con 5 años de experiencia", R.drawable.face02));
        lista.add(new Person("Anita Lavado", "34125857", 53,"Administradora de empresas, con 25 años de experiencia", R.drawable.face03));
        lista.add(new Person("Benito Muñoz", "48675857", 32,"M{usico profesional, con especialidad en musica barroca", R.drawable.face04));

    }

}
