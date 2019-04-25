package pe.gob.saludpol.listadb.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import pe.gob.saludpol.listadb.R;
import pe.gob.saludpol.listadb.model.Person;

public class CustomersDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Customers.db";
    public static final int DATABASE_VERSION = 1;
    private List<Person> items = new ArrayList<>();

    public CustomersDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS CLIENTE (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre VARCHAR(120)," +
                "dni VARCHAR(8)," +
                "edad INTEGER," +
                "biografia VARCHAR(240)," +
                "idfoto INTEGER)");

        CargaInicial(db);
    }

    private void CargaInicial(SQLiteDatabase db) {
        items.add(new Person("Juan Perez", "40404040", 35,
                "Arquitecto de interiores",
                R.drawable.face01, 0));
        items.add(new Person("Marcos Perales", "30245211", 32,
                "Ingeniero de Sistemas con mas de 15 aÃ±os en el sector pÃºblico y provado",
                R.drawable.face02, 0));
        items.add(new Person("Rosa Vargas", "45672111", 22,
                "Ingeniero civil con especialidad en Hidrologia",
                R.drawable.face03, 0));
        items.add(new Person("Carmen Soto", "20345533", 40,
                "Licenciado en derecho con especialidad en familias",
                R.drawable.face04, 0));

        for(Person p: items){
            db.insert("CLIENTE", null, p.toContentValues());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void savePerson(Person p){
        SQLiteDatabase db = getWritableDatabase();
        db.insert("CLIENTE", null, p.toContentValues());
    }



    public List<Person> getClientes(){
        List<Person> lista = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query("CLIENTE",
                null,       //Columnas a listar
                null,       //Columnas en clausula WHERE
                null,   //Valores de las columnas de la clausula WHERE
                null,       //Group by - columnas
                null,       // CondiciÃ³n de agrupamiento
                "nombre");  //Ordenamiento
        while(c.moveToNext()){
            lista.add(new Person(
                    c.getString(1),     //Nombre
                    c.getString(2),     //DNI
                    c.getInt(3),        //Edad
                    c.getString(4),     //Biografia
                    c.getInt(5),        //ID Foto
                    c.getInt(0)         //ID
            ));
        }
        return lista;
    }

}
