<%-- 
    Document   : confirmarEliminacion
    Created on : 05-05-2019, 1:21:29
    Author     : JOAQUIN CABELLO
--%>

<%@page import="model.clases.Palabra"%>
<%@page import="model.dao.DAO_Palabra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%

    String idPalabra = request.getParameter("idPalabra");

    DAO_Palabra d_p = new DAO_Palabra();
    
    Palabra p = d_p.getPalabra(Integer.parseInt(idPalabra));
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Palabra</title>
    </head>
    <body>
        <h1>¿Desea Eliminar?</h1>
        
        <div>
            Palabra: <%= p.getNombre() %> <br>
            Signiificado: <%= p.getDescripcion() %><br>
            Ejemplo: <%= p.getEjemplo()%><br>
        </div>
        
        <form action="eliminarPalabra.do" method="POST">
            <input type="hidden" name="id" value="<%= p.getId() %>">
            <input type="submit" value="SI">
        </form>
        
        <form action="inicioAlumno.jsp" method="POST">
            <input type="submit" value="NO">
        </form>
    </body>
</html>
