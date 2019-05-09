/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.clases;

/**
 *
 * @author JOAQUIN CABELLO
 */
public class Asignatura_palabra {

    public Asignatura_palabra(String fk_asignatura, String fk_palabra, String id) {
        this.fk_asignatura = fk_asignatura;
        this.fk_palabra = fk_palabra;
        this.id = id;
    }

    public Asignatura_palabra() {
    }
    
    

    public String getFk_asignatura() {
        return fk_asignatura;
    }

    public void setFk_asignatura(String fk_asignatura) {
        this.fk_asignatura = fk_asignatura;
    }

    public String getFk_palabra() {
        return fk_palabra;
    }

    public void setFk_palabra(String fk_palabra) {
        this.fk_palabra = fk_palabra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    private String fk_asignatura;
    private String fk_palabra;
    private String id;
}
