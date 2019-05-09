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
public class Sigla {

    public Sigla() {
    }

    public Sigla(String id, String nombre, String definicion, String fk_asignatura) {
        this.id = id;
        this.nombre = nombre;
        this.definicion = definicion;
        this.fk_asignatura = fk_asignatura;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDefinicion() {
        return definicion;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }

    public String getFk_asignatura() {
        return fk_asignatura;
    }

    public void setFk_asignatura(String fk_asignatura) {
        this.fk_asignatura = fk_asignatura;
    }
    private String id;
    private String nombre;
    private String definicion;
    private String fk_asignatura;
    
}
