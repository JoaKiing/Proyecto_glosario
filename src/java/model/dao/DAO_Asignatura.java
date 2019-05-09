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
import model.clases.Asignatura;

/**
 *
 * @author JOAQUIN CABELLO
 */
public class DAO_Asignatura extends Conexion implements DAO<Asignatura>{

    public DAO_Asignatura() throws ClassNotFoundException, SQLException {
        super("proyecto");
    }

    @Override
    public void create(Asignatura ob) throws SQLException {
        ejecutar("INSERT INTO asignatura VALUES(NULL,'"+ob.getNombre()+"');");
        
    }

    @Override
    public List<Asignatura> read() throws SQLException {
        ResultSet rs = ejecutar("SELECT * FROM asignatura");
        List<Asignatura> lista = new ArrayList<Asignatura>();
        
        Asignatura asignatura;
        
        while(rs.next()){
            asignatura = new Asignatura();
            
            asignatura.setId(rs.getString(1));
            asignatura.setNombre(rs.getString(2));
            
            lista.add(asignatura);
        }
        
        close();
        
        return lista;
    }

    @Override
    public void update(Asignatura ob) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws SQLException {
        ejecutar("DELETE * FROM Asignatura WHERE id = '"+id+"'");
    }

    
    
}
