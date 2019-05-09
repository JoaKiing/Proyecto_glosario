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
import model.dao.DAO_Palabra;

/**
 *
 * @author JOAQUIN CABELLO
 */
@WebServlet(name = "EliminarPalabraServlet", urlPatterns = {"/eliminarPalabra.do"})
public class EliminarPalabraServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        
        try {
            DAO_Palabra d_p = new DAO_Palabra();
            
            d_p.delete(Integer.parseInt(id));
            
            request.getRequestDispatcher("inicioAlumno.jsp").forward(request, response);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EliminarPalabraServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
