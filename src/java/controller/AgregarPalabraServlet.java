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
import model.clases.Palabra;
import model.dao.DAO_Palabra;

/**
 *
 * @author JOAQUIN CABELLO
 */
@WebServlet(name = "AgregarPalabraServlet", urlPatterns = {"/agregarPalabra.do"})
public class AgregarPalabraServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String palabra = request.getParameter("nomPalabra");
        String significado = request.getParameter("descipcion");
        String ejemplo = request.getParameter("ejemplo");
        String idUsuario = request.getParameter("idUsuario");

        Palabra p = new Palabra();
        p.setNombre(palabra);
        p.setDescripcion(significado);
        p.setEjemplo(ejemplo);

        try {
            DAO_Palabra d_p = new DAO_Palabra();

            if (d_p.existePalabra(palabra) == false) {
                d_p.create(p);
                int idPalabra = d_p.ultimaPalabraAñadida();

                d_p.createPalabraUsuario(Integer.parseInt(idUsuario), idPalabra);
            }else{
                //response.sendError(12, "error de ingreso, palabra ya existe");
                request.getRequestDispatcher("inicioAlumno.jsp").forward(request, response);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AgregarPalabraServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.getRequestDispatcher("inicioAlumno.jsp").forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
