<%-- 
    Document   : index
    Created on : 25-08-2019, 21:32:05
    Author     : anais
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="estilos/Style.css">
        <title>Inicio</title>
    </head>
     <body>  
         <div class="container4"> 
           <center><h1>Ingreso Usuario</h1></center>           
            <form action="login" method="post">
                <center><h3>Nombre:</h3></center> 
                <center><input type="text" placeholder="Ingresar Usuario" name="user" required></center> 
                 <center><h3>Constraseña:</h3></center> 
                <center><input type="password" placeholder="Ingresar Contraseña" name="pass" required></center> 
                <center><input type="checkbox" name="recordar" value="si"> Recordar</center> 
                <br>
                <center><input type="submit" value="Ingresar"></center>
            </form>
            </div> 
    </body>
</html>
