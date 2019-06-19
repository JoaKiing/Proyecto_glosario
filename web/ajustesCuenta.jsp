<%-- 
    Document   : ajustesCuenta
    Created on : 24-05-2019, 22:59:50
    Author     : JOAQUIN CABELLO
--%>

<%@page import="model.dao.DAO_Usuario"%>
<%@page import="model.clases.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String id = (String) request.getParameter("id");

    Usuario usu = new DAO_Usuario().getUsuarioPorId(id);
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajustes de cuenta</title>
    </head>
    <body>
        <%
            String direccion;
            
            if(usu.getTipo_fk().equals("1")){
                direccion = "inicioProfe.jsp";
            }else{
                direccion = "inicioAlumno.jsp";
            }
        %>
        
        <a href="<%= direccion %>">volver</a>
        <h1>Cambio de contraseña</h1>

        <div>
            <form action="cambiopass.do" method="POST">
                <p>Contraseña actual:   </p><input type="password" name="pass">
                <p>Contraseña nueva:    </p><input type="password" name="newpass">
                <p>Contraseña nueva:    </p><input type="password" name="newpass2">
                <input type="hidden" name="id" value="<%= id%>">
                <br>

                <input type="submit" value="Aceptar">
            </form>
        </div>


        <%
            if (session.getAttribute("mensaje") != null) {
                String mensaje = (String) session.getAttribute("mensaje");%>

        <h5><%= mensaje%></h5>

        <%}
            session.removeAttribute("mensaje");
        %>
    </body>
</html>
