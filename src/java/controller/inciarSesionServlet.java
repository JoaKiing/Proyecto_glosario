package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.clases.Usuario;
import model.dao.DAO_Usuario;

/**
 *
 * @author JOAQUIN CABELLO
 */
@WebServlet(urlPatterns = {"/iniciar.do"})
public class inciarSesionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String rut = request.getParameter("rut");
        String pass = request.getParameter("pass");
        
        try {
            DAO_Usuario d_u = new DAO_Usuario();
            
            if(d_u.existeUser(rut, pass) == true){
                Usuario u = d_u.getUsuario(rut, pass);
                HttpSession sesion = request.getSession();

                sesion.setAttribute("usuario", u);
                System.out.println(u.getId() +"-"+ u.getNombre() +"-"+u.getRun() +"-"+ u.getTipo_fk());
                
                if(u.getTipo_fk().equals("1")){
                    request.getRequestDispatcher("inicioAdmin.jsp").forward(request, response);
                }else{
                    request.getRequestDispatcher("inicioAlumno.jsp").forward(request, response);
                }
            }else{
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(inciarSesionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
