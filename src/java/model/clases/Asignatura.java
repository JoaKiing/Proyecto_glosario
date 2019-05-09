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
public class Asignatura {

    public String getNombre() {
        return nombre;
    }

    public Asignatura() {
    }

    public Asignatura(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    private String id;
    private String nombre;
    
}
