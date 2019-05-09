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
import model.clases.Sigla;
import model.clases.Usuario;

/**
 *
 * @author JOAQUIN CABELLO
 */
public class DAO_Sigla extends Conexion implements DAO<Sigla>{

    public DAO_Sigla() throws ClassNotFoundException, SQLException {
        super("proyecto");
    }

    @Override
    public void create(Sigla ob) throws SQLException {
        ejecutar("INSERT INTO asignatura VALUES(NULL,'"+ob.getNombre()+"','"+ob.getDefinicion()+"','"+ob.getFk_asignatura()+"');");

    }

    @Override
    public List<Sigla> read() throws SQLException {
        ResultSet rs = ejecutar("SELECT * FROM sigla");
        List<Sigla> lista = new ArrayList<Sigla>();
        
        Sigla sigla;
        
        while(rs.next()){
            sigla = new Sigla();
            
            sigla.setId(rs.getString(1));
            sigla.setNombre(rs.getString(2));
            sigla.setDefinicion(rs.getString(3));
            sigla.setFk_asignatura(rs.getString(4));
            
            lista.add(sigla);
        }
        
        close();
        
        return lista;
    }

    @Override
    public void update(Sigla ob) throws SQLException {
            ejecutar("UPDATE usuario SET nombre = '"+ob.getNombre()+"', definicion = '"+ob.getDefinicion()+"'");
    }

    @Override
    public void delete(int id) throws SQLException {
        ejecutar("DELETE * FROM sigla WHERE id = '"+id+"'");
    }
    
    
    
}
