<%-- 
    Document   : inicio
    Created on : 01-05-2019, 19:03:52
    Author     : JOAQUIN CABELLO
--%>

<%@page import="model.clases.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    if (session.getAttribute("usuario") == null) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    } else {
        Usuario usu = (Usuario) session.getAttribute("usuario");

    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio Administradr</title>
    </head>
    <body>
        <h1>Inicio Administrador</h1>
        
    </body>
</html>
