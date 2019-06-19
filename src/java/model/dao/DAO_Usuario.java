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
import model.clases.Usuario;

/**
 *
 * @author JOAQUIN CABELLO
 */
public class DAO_Usuario extends Conexion implements DAO<Usuario>{

    public DAO_Usuario() throws ClassNotFoundException, SQLException {
        super("proyecto");
    }

    @Override
    public void create(Usuario ob) throws SQLException {
        ejecutar("INSERT INTO usuario VALUES(NULL,'"+ob.getRun()+"','"+ob.getPass()+"','"+ob.getNombre()+"','"+ob.getTipo_fk()+"');");
    }

    @Override
    public List<Usuario> read() throws SQLException {
        ResultSet rs = ejecutar("SELECT * FROM usuario");
        List<Usuario> lista = new ArrayList<Usuario>();
        
        Usuario usuario;
        
        while(rs.next()){
            usuario = new Usuario();
            
            usuario.setId(rs.getString(1));
            usuario.setRun(rs.getString(2));
            usuario.setPass(rs.getString(3));
            usuario.setNombre(rs.getString(4));
            usuario.setTipo_fk(rs.getString(5));
            
            lista.add(usuario);
        }
        
        close();
        
        return lista;
    }
    
    public List<Usuario> readAlumnos() throws SQLException {
        ResultSet rs = ejecutar("SELECT id, nombre, run FROM usuario WHERE tipo_fk = 2");
        List<Usuario> lista = new ArrayList<Usuario>();
        
        Usuario usuario;
        
        while(rs.next()){
            usuario = new Usuario();
            
            usuario.setId(rs.getString(1));
            usuario.setNombre(rs.getString(2));
            usuario.setRun(rs.getString(3));
            
            lista.add(usuario);
        }
        
        close();
        
        return lista;
    }
    
    @Override
    public void update(Usuario ob) throws SQLException {
        ejecutar("UPDATE usuario SET pass = '"+ob.getPass()+"'");
    }

    @Override
    public void delete(int id) throws SQLException {
        ejecutar("DELETE * FROM usuario WHERE id = '"+id+"'");
    }
    
    public boolean existeUser(String rut, String pass) throws SQLException{
        boolean existe = false;
        ResultSet rs = ejecutar("SELECT COUNT(*) FROM usuario WHERE run = '"+rut+"' AND pass = '"+pass+"'");
        
        if(rs.next()){
            if(rs.getInt(1) == 1){
                existe = true;
                return existe;
            }
        }
        
        return existe;
    }
    
    public Usuario getUsuario(String rut, String pass) throws SQLException{
        Usuario u = new Usuario();
        ResultSet rs = ejecutar("SELECT * FROM usuario WHERE run = '"+rut+"' AND pass = '"+pass+"'");
        
        if(rs.next()){
            u.setId(rs.getString(1));
            u.setRun(rs.getString(2));
            u.setNombre(rs.getString(4));
            u.setTipo_fk(rs.getString(5));
        }
        
        return u;
    }
    
    public Usuario getUsuarioPorId(String id) throws SQLException{
        Usuario u = new Usuario();
        ResultSet rs = ejecutar("SELECT id,nombre,run,tipo_fk FROM usuario WHERE id = "+id+"");
        
        if(rs.next()){
            u.setId(rs.getString(1));
            u.setNombre(rs.getString(2));
            u.setRun(rs.getString(3));
            u.setTipo_fk(rs.getString(4));
        }
        
        return u;
    }
    
    public boolean existeUsuarioPorRut(String rut) throws SQLException{
        boolean existe = true;
        ResultSet rs = ejecutar("SELECT COUNT(*) FROM usuario WHERE run = '"+rut+"'");
        
        if(rs.next()){
            if(rs.getInt(1) == 0){
                existe = false;
            }else{
                existe = true;
            }
        }
        
        return existe;
    }
    
    public boolean cambioPass(String id, String pass, String newpass) throws SQLException{
        boolean existePass = false;
        
        ResultSet rs = ejecutar("SELECT COUNT(*) FROM usuario WHERE id = "+id+" AND pass = '"+pass+"'");
        
        if(rs.next()){
            if(rs.getInt(1) == 0){
                existePass = false;
            }else{
                existePass = true;
                rs = ejecutar("UPDATE usuario SET pass = '"+newpass+"' WHERE id = "+id+"");
            }
        }
        
        return existePass;
    }

}
