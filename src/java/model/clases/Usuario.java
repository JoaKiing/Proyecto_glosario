package model.clases;
public class Usuario {

    public String getId() {
        return id;
    }

    public Usuario(String id, String run, String pass, String nombre, String tipo_fk) {
        this.id = id;
        this.run = run;
        this.pass = pass;
        this.nombre = nombre;
        this.tipo_fk = tipo_fk;
    }

    public Usuario() {
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_fk() {
        return tipo_fk;
    }

    public void setTipo_fk(String tipo_fk) {
        this.tipo_fk = tipo_fk;
    }
    
    private String id;
    private String run;
    private String pass;
    private String nombre;
    private String tipo_fk;
    
}
