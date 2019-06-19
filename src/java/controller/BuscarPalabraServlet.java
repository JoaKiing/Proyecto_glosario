package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(urlPatterns = {"/buscar.do"})
public class BuscarPalabraServlet extends HttpServlet {

    private Gson gson;
    private DAO_Palabra d_p;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            gson = new Gson();
            d_p = new DAO_Palabra();
            
            String palabra = request.getParameter("palabra");
            
            List<Palabra> listaPalabras = d_p.readForName(palabra, "2");
            
            Type listType = new TypeToken<List<Palabra>>() {}.getType();
            String jsonResponse = gson.toJson(listaPalabras,listType);
            
            response.getWriter().println(jsonResponse);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BuscarPalabraServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
