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
import model.clases.Palabra;
import model.clases.Usuario;
import model.dao.DAO_Palabra;
import model.dao.DAO_Usuario;

/**
 *
 * @author JOAQUIN CABELLO
 */
@WebServlet(name = "ModificarPalabraServlet", urlPatterns = {"/modificar.do"})
public class ModificarPalabraServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idUsuario = request.getParameter("idUsuario");

        Palabra p = new Palabra();

        p.setId(request.getParameter("idPalabraMod"));
        p.setNombre(request.getParameter("nombre"));
        p.setDescripcion(request.getParameter("descripcion"));
        p.setEjemplo(request.getParameter("ejemplo"));

        HttpSession sesion = request.getSession();

        try {
            if (new DAO_Usuario().getUsuarioPorId(idUsuario).getTipo_fk().equals("1")) {
                String idAlumno = request.getParameter("idAlumno");
                
                sesion.setAttribute("idAlumno", idAlumno);
                sesion.setAttribute("idProfe", idUsuario);
                
                new DAO_Palabra().update(p);

                request.getRequestDispatcher("alumno.jsp").forward(request, response);
            } else {
                new DAO_Palabra().update(p);
                request.getRequestDispatcher("inicioAlumno.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ModificarPalabraServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
