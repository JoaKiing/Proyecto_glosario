<%-- 
    Document   : alumno
    Created on : 11-05-2019, 23:45:43
    Author     : JOAQUIN CABELLO
--%>

<%@page import="java.util.List"%>
<%@page import="model.clases.Palabra"%>
<%@page import="model.dao.DAO_Palabra"%>
<%@page import="model.dao.DAO_Sigla"%>
<%@page import="model.dao.DAO_Usuario"%>
<%@page import="model.clases.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Usuario alumno = new Usuario();
    Usuario profe = new Usuario();
    String idPalabra = "null";

    try {
        if (request.getParameter("id") != null) {
            alumno = new DAO_Usuario().getUsuarioPorId(request.getParameter("id"));
        } else if (session.getAttribute("idAlumno") != null) {
            alumno = new DAO_Usuario().getUsuarioPorId(String.valueOf(session.getAttribute("idAlumno")));
        }
    } catch (Exception e) {
        System.out.println("Viejo! no entro a ninguno de los 2 if del alumno");
    }

    try {
        if (request.getParameter("idProfe") != null) {
            profe = new DAO_Usuario().getUsuarioPorId(request.getParameter("idProfe"));
        } else if (session.getAttribute("idProfe") != null) {
            profe = new DAO_Usuario().getUsuarioPorId(String.valueOf(session.getAttribute("idProfe")));
        }
    } catch (Exception e) {
        System.out.println("Viejo! no entro a ninguno de los 2 if del profe");
    }

    
    // este if es para ver si viene el id de una palabra para el modificar
    if (request.getParameter("idPalabraM") != null) {
        idPalabra = request.getParameter("idPalabraM");
    }

    DAO_Sigla d_s = new DAO_Sigla();
    DAO_Palabra d_p = new DAO_Palabra();

    List<Palabra> listaPalabra = d_p.palabras_porUsuario(Integer.parseInt(alumno.getId()));
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil Alumno</title>
    </head>
    <body>
        <h1>Profe: <%= profe.getId()%></h1>
        <h1>Alumno: <%= alumno.getId()%></h1>
        <h1>Palabra: <%= idPalabra%></h1>

        <a href="inicioProfe.jsp">Volver</a><br>

        <h1>Perfil Alumno <%= alumno.getNombre()%></h1>
        <h2>Datos</h2>
        <div style="background-color: aliceblue">
            Nombre: <%= alumno.getNombre()%><br><br>
            Run: <%= alumno.getRun()%>
        </div>


        <div id="buscarPalabra">
        </div>

        <br>
        <h2>Listado de Palabra de <%= alumno.getNombre()%></h2>

        <div style="background-color: lavender">
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
                            if (p.getId().equals(idPalabra)) {%>
                    <tr>
                <form action="modificar.do" method="POST">
                    <td><input type="text" name="nombre" value="<%= p.getNombre()%>" required></td>
                    <td><input type="text" name="descripcion" value="<%= p.getDescripcion()%>" required></td>
                    <td><input type="text" name="ejemplo" value="<%= p.getEjemplo()%>" required></td>

                    <input type="hidden" name="idPalabraMod" value="<%= p.getId()%>">
                    <input type="hidden" name="idUsuario" value="<%= profe.getId()%>">
                    <input type="hidden" name="idAlumno" value="<%= alumno.getId()%>">

                    <td><input type="submit" value="Aceptar"></td>
                    <td>Eliminar</td>
                    </tr>
                </form>
                </tr>
                <%} else {%>
                <tr>
                    <td><%= p.getNombre()%></td>
                    <td><%= p.getDescripcion()%></td>
                    <td><%= p.getEjemplo()%></td>
                    <td>
                        <form action="alumno.jsp" method="POST">
                            <input type="hidden" name="id" value="<%= alumno.getId()%>">
                            <input type="hidden" name="idProfe" value="<%= profe.getId()%>">
                            <input type="hidden" name="idPalabraM" value="<%= p.getId()%>">
                            <input type="submit" value="Modificar">
                        </form>
                    </td>
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
