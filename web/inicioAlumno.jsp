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

    String idPalabra = "null";

    // este if es para ver si viene el id de una palabra para el modificar
    if (request.getParameter("id") != null) {
        idPalabra = request.getParameter("id");
    }

    //if para ver si viene sesion con el nombre usuario
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

        <script src="js/jquery-3.3.1.min.js"></script>
    </head>
    <body>
        <div>
            <ul>
                <li>
                    <form action="ajustesCuenta.jsp" method="POST">
                        <input type="hidden" name="id" value="<%= usu.getId()%>">
                        <input type="submit" value="Ajustes de cuenta">
                    </form>
                </li>
                <li><a href="index.jsp">Cerrar Session</a></li>
            </ul>
        </div>

        <h1>Bienvenida(o) <%= usu.getNombre()%></h1>


        <div>
            <h4>Agregar Palabra</h4>
            <form action="agregarPalabra.do" method="POST">
                <p>Palabra:</p><input type="text" name="nomPalabra" required>
                <p>Significado:</p><input type="text" name="descipcion" required>
                <p>Ejemplo:</p><input type="text" name="ejemplo" required>
                <br>
                <input type="hidden" name="idUsuario" value="<%= usu.getId()%>">

                <input type="submit" value="Agregar">
            </form>
        </div>
        <br>
        <br>

        <h2>Mi Glosario</h2>

        <div>
            <p>Buscar Palabra: </p>
            <input type="text" id="Nombrepalabra">

        </div>


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
                    <% for (Palabra p : listaPalabra) {
                            if (p.getId().equals(idPalabra)) {
                    %>
                    <tr>
                <form action="modificar.do" method="POST">
                    <td><input type="text" name="nombre" value="<%= p.getNombre()%>" required></td>
                    <td><input type="text" name="descripcion" value="<%= p.getDescripcion()%>" required></td>
                    <td><input type="text" name="ejemplo" value="<%= p.getEjemplo()%>" required></td>

                    <input type="hidden" name="idPalabraMod" value="<%= p.getId()%>">
                    <input type="hidden" name="idUsuario" value="<%= usu.getId()%>">

                    <td><input type="submit" value="Aceptar"></td>
                    <td>Eliminar</td>
                    </tr>
                </form>
                <% } else {%>
                <tr>
                    <td><%= p.getNombre()%></td>
                    <td><%= p.getDescripcion()%></td>
                    <td><%= p.getEjemplo()%></td>
                    <td><a href="inicioAlumno.jsp?id=<%= p.getId()%>" style="color: brown">Modificar</a></td>
                    <td>
                        <form action="confirmarEliminacion.jsp" method="POST">
                            <input type="hidden" name="idPalabra" value="<%= p.getId()%>">
                            <input type="submit" value="Eliminar">
                        </form>
                    </td>
                </tr>

                <%}
                    }%>
                </tbody>
            </table>

        </div>

    </body>
</html>
