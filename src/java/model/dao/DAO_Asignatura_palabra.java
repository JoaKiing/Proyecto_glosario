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
import model.clases.Asignatura_palabra;


/**
 *
 * @author JOAQUIN CABELLO
 */
public class DAO_Asignatura_palabra extends Conexion implements DAO<Asignatura_palabra>{

    public DAO_Asignatura_palabra() throws ClassNotFoundException, SQLException {
        super("proyecto");
    }

    @Override
    public void create(Asignatura_palabra ob) throws SQLException {
        ejecutar("INSERT INTO asignatura VALUES(NULL,'"+ob.getFk_palabra()+"','"+ob.getFk_asignatura()+"');");
    }

    @Override
    public List<Asignatura_palabra> read() throws SQLException {
        ResultSet rs = ejecutar("SELECT * FROM asignatura_palabra");
        List<Asignatura_palabra> lista = new ArrayList<Asignatura_palabra>();
        
        Asignatura_palabra asignatura_palabra;
        
        while(rs.next()){
            asignatura_palabra = new Asignatura_palabra();
            
            asignatura_palabra.setId(rs.getString(1));
            asignatura_palabra.setFk_palabra(rs.getString(2));
            asignatura_palabra.setFk_asignatura(rs.getString(3));
                      
            lista.add(asignatura_palabra);
        }
        
        close();
        
        return lista;
    }

    @Override
    public void update(Asignatura_palabra ob) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws SQLException {
        ejecutar("DELETE * FROM asignatura_palabra WHERE id = '"+id+"'");
    }
    
}
