<%-- 
    Document   : inicioAlumno
    Created on : 01-05-2019, 20:00:04
    Author     : JOAQUIN CABELLO
--%>

<%@page import="model.clases.Palabra"%>
<%@page import="java.util.List"%>
<%@page import="model.dao.DAO_Sigla"%>
<%@page import="model.dao.DAO_Palabra"%>
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

    DAO_Sigla d_s = new DAO_Sigla();
    DAO_Palabra d_p = new DAO_Palabra();

    List<Palabra> listaPalabra = d_p.palabras_porUsuario(Integer.parseInt(usu.getId()));
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <body>
        <div>
            <ul>
                <li><a href="ajustesCuenta.jsp">Ajustes de cuenta</a></li>
                <li><a href="index.jsp">Cerrar Session</a></li>
            </ul>
        </div>

        <h1>Bienvenida(o) <%= usu.getNombre()%></h1>


        <div>
            <h4>Agregar Palabra</h4>
            <form action="agregarPalabra.do" method="POST">
                Palabra: <input type="text" name="nomPalabra" required> <br>
                Significado: <input type="text" name="descipcion" required> <br>
                Ejemplo: <input type="text" name="ejemplo" required> <br><br>
                <input type="hidden" name="idUsuario" value="<%= usu.getId() %>">

                <input type="submit" value="Agregar">
            </form>
        </div>
        <br>
        <br>

    <h2>Mi Glosario</h2>
    <div>
        <table border="1">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    <th>Ejemplo</th>
                    <th>Modificar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <% for (Palabra p : listaPalabra) {%>
                <tr>
                    <td><%= p.getNombre()%></td>
                    <td><%= p.getDescripcion()%></td>
                    <td><%= p.getEjemplo()%></td>
                    <td>Modificar</td>
                    <td>
                        <form action="confirmarEliminacion.jsp" method="POST">
                            <input type="hidden" name="idPalabra" value="<%= p.getId() %>">
                            <input type="submit" value="Eliminar">
                        </form>
                    </td>
                </tr>

                <%}%>
            </tbody>
        </table>

    </div>

</html>
