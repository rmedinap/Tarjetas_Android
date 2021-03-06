package pe.gob.saludpol.listahttp.model;

public class Person {
    private String nombre;
    private String dni;
    private int edad;
    private String biografia;
    private int idfoto;
    private String fotourl;
    private String codigo;

    public Person(String nombre, String dni, int edad, String biografia, int idfoto) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.biografia = biografia;
        this.idfoto = idfoto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public int getIdfoto() {
        return idfoto;
    }

    public void setIdfoto(int idfoto) {
        this.idfoto = idfoto;
    }

    public String getFotourl() {
        return fotourl;
    }

    public void setFotourl(String fotourl) {
        this.fotourl = fotourl;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
