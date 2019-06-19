/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
@WebServlet(name = "AgregarAlumnoServlet", urlPatterns = {"/agregarAlumno.do"})
public class AgregarAlumnoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Usuario u = new Usuario();
        u.setNombre(request.getParameter("nombre"));
        u.setRun(request.getParameter("rut"));
        u.setPass(request.getParameter("rut"));
        u.setTipo_fk("2");
        
        try {
            DAO_Usuario d_u = new DAO_Usuario();
            HttpSession sesion = request.getSession();
            
            if(d_u.existeUsuarioPorRut(u.getRun()) == false){
                d_u.create(u);
                sesion.setAttribute("mensaje", "Alumno agregado con existo");
            }else{
                sesion.setAttribute("mensaje", "Rut de alumno ingresado ya existe en la base de datos del sistema");
            }
            
            request.getRequestDispatcher("agregarAlumnos.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AgregarAlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
