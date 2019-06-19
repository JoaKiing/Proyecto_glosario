<%-- 
    Document   : agregarAlumnos
    Created on : 11-05-2019, 23:15:54
    Author     : JOAQUIN CABELLO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Alumno</title>
    </head>
    <body>
        <h1>Agregar Alumno</h1>
        <form action="agregarAlumno.do" method="POST">
            <input type="text" name="rut" placeholder="RUT SIN PUNTOS y CON GUION" required>
            <input type="text" name="nombre" placeholder="Nombre Completo" required>

            <input type="submit" value="Agregar">
        </form>

        <%
            if (session.getAttribute("mensaje") != null) {
                String mensaje = (String) session.getAttribute("mensaje");%>
                
                
                <h5><%= mensaje %></h5>
                
            <%}
            session.removeAttribute("mensaje");
            %>
    </body>
</html>
