<%-- 
    Document   : nuevo
    Created on : 18-07-2021, 21:52:03
    Author     : anais
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="estilos/Style.css">
        <title>Almacen</title>
    </head>
    <body>
        <h2>Nuevo Registro</h2>
 <div class="container3">
        <form action="productosController?accion=insertar" method="POST" autocomplete="off">
            <p>
               codigo: 
               <input id="codigo" name="codigo" type="text"/>     
            </p>
            <p>
               nombre: 
               <input id="nombre" name="nombre" type="text"/>     
            </p>
            <p>
               precio: 
               <input id="precio" name="precio" type="text"/>     
            </p>
            <p>
               existencia: 
               <input id="existencia" name="existencia" type="text"/>     
            </p>
            
            <button id="guardar" name="guardar" type="submit">Guardar</button>
        </form>
 </div>
    </body>
</html>
