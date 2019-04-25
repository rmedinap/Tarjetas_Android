package pe.gob.saludpol.listadb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.gob.saludpol.listadb.database.CustomersDBHelper;
import pe.gob.saludpol.listadb.model.Person;


public class NewActivity extends AppCompatActivity {
    private EditText txtNombre;
    private EditText txtDNI;
    private EditText txtEdad;
    private EditText txtBiografia;
    private Spinner spnFoto;
    private Button btnGuardar;

    private List<String> arrAvatarTexto = new ArrayList<>();
    private List<Integer> arrAvatarResource = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtDNI = (EditText) findViewById(R.id.txtDNI);
        txtEdad = (EditText) findViewById(R.id.txtEdad);
        txtBiografia = (EditText) findViewById(R.id.txtBiografia);
        spnFoto = (Spinner) findViewById(R.id.spnFoto);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);

        //Data para el Spinner
        arrAvatarTexto.add("Face 01");
        arrAvatarTexto.add("Face 02");
        arrAvatarTexto.add("Face 03");
        arrAvatarTexto.add("Face 04");

        arrAvatarResource.add(R.drawable.face01);
        arrAvatarResource.add(R.drawable.face02);
        arrAvatarResource.add(R.drawable.face03);
        arrAvatarResource.add(R.drawable.face04);

        //Adaptador para el spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrAvatarTexto);
        spnFoto.setAdapter(dataAdapter);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GuardarPersona();
            }
        });

    }

    private void GuardarPersona() {
        if(txtNombre.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingrese su nombre", Toast.LENGTH_SHORT).show();
            return;
        }
        if(txtDNI.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingrese su DNI", Toast.LENGTH_SHORT).show();
            return;
        }
        if(txtEdad.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingrese su edad", Toast.LENGTH_SHORT).show();
            return;
        }
        if(txtBiografia.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingrese su biografia", Toast.LENGTH_SHORT).show();
            return;
        }

        String vNombre = txtNombre.getText().toString();
        String vDNI = txtDNI.getText().toString();
        int vEdad = Integer.parseInt(txtEdad.getText().toString());
        String vBiografia = txtBiografia.getText().toString();

        int selectedItem = spnFoto.getSelectedItemPosition();
        int vIdFoto = arrAvatarResource.get(selectedItem);
        Person item = new Person(vNombre,vDNI,vEdad,vBiografia,vIdFoto);

        CustomersDBHelper db = new CustomersDBHelper(this);
        db.savePerson(item);
        LimpiarFormulario();
        Toast.makeText(this, "Registro guardado satisfactoriamente!", Toast.LENGTH_SHORT).show();
    }

    private void LimpiarFormulario() {
        txtNombre.setText("");
        txtDNI.setText("");
        txtEdad.setText("");
        txtBiografia.setText("");
        spnFoto.setSelection(0);
    }

}
