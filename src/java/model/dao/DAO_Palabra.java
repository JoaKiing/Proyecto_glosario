/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.clases.Palabra;

/**
 *
 * @author JOAQUIN CABELLO
 */
public class DAO_Palabra extends Conexion implements DAO<Palabra> {

    public DAO_Palabra() throws ClassNotFoundException, SQLException {
        super("proyecto");
    }

    @Override
    public void create(Palabra ob) throws SQLException {
        ejecutar("INSERT INTO palabra VALUES(NULL,'" + ob.getNombre() + "','" + ob.getDescripcion() + "','" + ob.getEjemplo() + "','" + ob.getImagen() + "');");

    }

    @Override
    public List<Palabra> read() throws SQLException {
        ResultSet rs = ejecutar("SELECT * FROM palabra");
        List<Palabra> lista = new ArrayList<Palabra>();

        Palabra palabra;

        while (rs.next()) {
            palabra = new Palabra();

            palabra.setId(rs.getString(1));
            palabra.setNombre(rs.getString(2));
            palabra.setDescripcion(rs.getString(3));
            palabra.setEjemplo(rs.getString(4));
            palabra.setImagen(rs.getString(5));

            lista.add(palabra);
        }

        close();

        return lista;
    }

    public List<Palabra> readForName(String nombre, String idUser) throws SQLException {
        ResultSet rs;

        if (nombre.equalsIgnoreCase("")) {
            rs = ejecutar("SELECT 	palabra.id, palabra.nombre, palabra.descripcion, palabra.ejemplo \n"
                    + "FROM 	palabra, usuario, usuario_palabra \n"
                    + "WHERE 	(usuario_palabra.fk_palabra = palabra.id AND usuario_palabra.fk_usuario = usuario.id)\n"
                    + "AND 	usuario.id = " + idUser + "");
        } else {
            rs = ejecutar("SELECT 	palabra.id, palabra.nombre, palabra.descripcion, palabra.ejemplo \n"
                    + "FROM 	palabra, usuario, usuario_palabra \n"
                    + "WHERE 	palabra.nombre LIKE '" + nombre + "%' AND (usuario_palabra.fk_palabra = palabra.id AND usuario_palabra.fk_usuario = usuario.id)\n"
                    + "AND 	usuario.id = " + idUser + "");
        }

        List<Palabra> lista = new ArrayList<Palabra>();

        Palabra palabra;

        while (rs.next()) {
            palabra = new Palabra();

            palabra.setId(rs.getString(1));
            palabra.setNombre(rs.getString(2));
            palabra.setDescripcion(rs.getString(3));
            palabra.setEjemplo(rs.getString(4));

            lista.add(palabra);
        }

        close();

        return lista;
    }

    @Override
    public void update(Palabra ob) throws SQLException {
        ejecutar("UPDATE palabra SET nombre = '" + ob.getNombre() + "', descripcion = '" + ob.getDescripcion() + "', ejemplo = '" + ob.getEjemplo() + "' WHERE id = " + ob.getId() + "");
    }

    @Override
    public void delete(int id) throws SQLException {
        ejecutar("DELETE FROM palabra WHERE id = '" + id + "'");
    }

    public List<Palabra> palabras_porUsuario(int idUsuario) throws SQLException {
        ResultSet rs = ejecutar("SELECT 	palabra.id, palabra.nombre, palabra.descripcion, palabra.ejemplo \n"
                + "FROM 	palabra, usuario, usuario_palabra \n"
                + "WHERE 	(usuario_palabra.fk_palabra = palabra.id AND usuario_palabra.fk_usuario = usuario.id)\n"
                + "AND 	usuario.id = " + idUsuario + "");

        List<Palabra> lista = new ArrayList<Palabra>();

        Palabra palabra;

        while (rs.next()) {
            palabra = new Palabra();

            palabra.setId(rs.getString(1));
            palabra.setNombre(rs.getString(2));
            palabra.setDescripcion(rs.getString(3));
            palabra.setEjemplo(rs.getString(4));

            lista.add(palabra);
        }

        close();

        return lista;
    }

    public void createPalabraUsuario(int idUsuario, int idPalabra) throws SQLException {
        ResultSet rs = ejecutar("INSERT INTO usuario_palabra VALUES(NULL," + idUsuario + "," + idPalabra + ");");
    }

    public int ultimaPalabraAñadida() throws SQLException {
        int id = -1;
        ResultSet rs = ejecutar("SELECT MAX(id) FROM palabra");

        if (rs.next()) {
            id = rs.getInt(1);
        }

        return id;
    }

    public boolean existePalabra(String palabra, String idUser) throws SQLException {
        boolean existe = false;

        ResultSet rs = ejecutar("SELECT COUNT(*) FROM palabra, usuario, usuario_palabra WHERE (usuario_palabra.fk_palabra = palabra.id AND usuario_palabra.fk_usuario = usuario.id)\n"
                + "AND usuario.id = " + idUser + "\n"
                + "AND palabra.nombre LIKE '%" + palabra + "%' ");

        if (rs.next()) {
            if (rs.getInt(1) == 0) {
                existe = false;
            } else {
                existe = true;
            }
        }

        return existe;
    }

    public Palabra getPalabra(int id) throws SQLException {
        Palabra p = new Palabra();

        ResultSet rs = ejecutar("SELECT * FROM palabra WHERE id = " + id + "");
        if (rs.next()) {
            p.setId(rs.getString(1));
            p.setNombre(rs.getString(2));
            p.setDescripcion(rs.getString(3));
            p.setEjemplo(rs.getString(4));
            p.setImagen(rs.getString(5));
        }

        return p;
    }
}
