<%-- 
    Document   : index
    Created on : 01-05-2019, 19:02:50
    Author     : JOAQUIN CABELLO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>PODOLOGIA</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
    </head>
    <body>
        <div>
            <center>
                <h1>Inicio Sesion</h1>
                <form action="iniciar.do"  method="POST">
                    <input type  ="text" name="rut" placeholder="Rut User" id="usuario" required>
                    <br>
                    <br>
                    <input type ="password" name="pass" placeholder="Contraseña" id="pass" required>
                    <br>
                    <br>
                    <input type ="submit" value="Iniciar">
                </form>
            </center>
        </div>

    </body>
</html>
