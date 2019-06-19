<%-- 
    Document   : inicio
    Created on : 01-05-2019, 19:03:52
    Author     : JOAQUIN CABELLO
--%>

<%@page import="java.util.List"%>
<%@page import="model.dao.DAO_Usuario"%>
<%@page import="model.clases.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    Usuario usu = new Usuario();

    if (session.getAttribute("usuario") == null) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    } else {
        usu = (Usuario) session.getAttribute("usuario");
    }
    
    DAO_Usuario d_u = new DAO_Usuario();
    
    List<Usuario> lista = d_u.readAlumnos();
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio Profesor</title>
    </head>
    <body>
        <div>
            <ul>
                <li>
                    <form action="ajustesCuenta.jsp" method="POST">
                        <input type="hidden" name="id" value="<%= usu.getId() %>">
                        <input type="submit" value="Ajustes de cuenta">
                    </form>
                </li>
                <li><a href="index.jsp">Cerrar Session</a></li>
                <li><a href="alumnos.jsp">Alumnos Inscritos</a></li>
                <li><a href="agregarAlumnos.jsp">Agregar Alumnos</a></li>
            </ul>
        </div>
        
        <h1>Bienvenido <%= usu.getNombre()%></h1>
        
        <div>
            <h3>Listado de Alumnos</h3>
            
            <div id="Buscar">
                
            </div>
            
            <table border="1">
                <thead>
                    <tr>
                        <th>Run</th>
                        <th>Nombre</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Usuario u : lista) {%>
                    <tr>
                        <td><%= u.getRun() %></td>
                        <td>
                            <form action="alumno.jsp" method="POST">
                                <input type="hidden" name="id" value="<%= u.getId() %>">
                                <input type="hidden" name="idProfe" value="<%= usu.getId() %>">
                                <input type="submit" value="<%= u.getNombre() %>">
                            </form>
                        </td>
                    </tr>
                    
                    <%}%>
                </tbody>
            </table>

            
        </div>
        
    </body>
</html>
