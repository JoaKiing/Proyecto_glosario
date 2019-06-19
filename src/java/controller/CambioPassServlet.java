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
import model.dao.DAO_Usuario;

/**
 *
 * @author JOAQUIN CABELLO
 */
@WebServlet(name = "CambioPassServlet", urlPatterns = {"/cambiopass.do"})
public class CambioPassServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            HttpSession sesion = request.getSession();
            
            if(request.getParameter("newpass").equals(request.getParameter("newpass2"))){
                
                boolean cambioExitoso = new DAO_Usuario().cambioPass(request.getParameter("id"), request.getParameter("pass"), request.getParameter("newpass"));
                
                if(cambioExitoso == true){
                    sesion.setAttribute("mensaje", "Cambio de contraseña exitoso!!");
                    request.getRequestDispatcher("ajustesCuenta.jsp").forward(request, response);
                }else{
                    sesion.setAttribute("mensaje", "Error al ingresar contraseña, Intente nuevamente");
                    request.getRequestDispatcher("ajustesCuenta.jsp").forward(request, response);
                }
            }else{
                sesion.setAttribute("mensaje", "Contraseñas nuevas no coinciden, intente nuevamente");
                request.getRequestDispatcher("ajustesCuenta.jsp").forward(request, response);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CambioPassServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CambioPassServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
