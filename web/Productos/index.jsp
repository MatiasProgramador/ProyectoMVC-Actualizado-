<%-- 
    Document   : index
    Created on : 18-07-2021, 21:50:25
    Author     : anais
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="estilos/Style.css">
        <title>Almacen</title>
    </head>
    <body>
        <div class="container">
        <h1>Productos</h1>
        <br>
        <table border="1" width="80%">
            <thead>
                <tr>
                    <th>Codigo</th>
                     <th>Nombre</th>
                      <th>Precio</th>
                       <th>Existencia</th>
                        <th></th>
                        <th></th>
                      
                </tr>
            </thead>
            <tbody>
                <c:forEach var="producto" items="${lista}">
                    <tr>
                        <td><c:out value="${producto.codigo}"/></td>
                        <td><c:out value="${producto.nombre}"/></td>
                        <td><c:out value="${producto.precio}"/></td>
                        <td><c:out value="${producto.existencia}"/></td>
                        <td><a href="productosController?accion=modificar&id=<c:out value="${producto.id}"/>">Modificar</td>
                        <td><a href="productosController?accion=eliminar&id=<c:out value="${producto.id}"/>">Elimnar</td>
                    </tr>
                    
                    
                </c:forEach>
            </tbody>
        </table>
        <br>
        <br>
        <center><a href="productosController?accion=nuevo" class="boton">Nuevo Registro</a></center>
        </div>
    </body>
</html>
