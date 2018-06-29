<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="estilos.css" rel="stylesheet" type="text/css" /> 
        <title>BBDD(CRUD) [EL + JDBC + DAO]</title>
    </head>
    <body>
        <div id="contenedor">
            <h2>BBDD(CRUD) [EL + JDBC + DAO]</h2>
            <div id="body">        
                <h3>LISTADO DE PAISES</h3>
                <table border="1">
                    <thead>
                        <tr>
                            <th>NOMBRE</th>
                            <th>CONTINENTE</th>
                            <th>REGION</th>
                            <th></th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="zapato" items="${zapatos}">
                            <tr>
                                <td>${zapato.nombre}</td>
                                <td>${zapato.categoria}</td>
                                <td>${zapato.precio}</td>
                                <td><a href="paises?operacion=detalle&cod=${zapato.precio}">Detalles</a></td>
                                <td><a href="paises?operacion=modificacion&cod=${zapato.precio}">Modificar</a></td>
                                <td><a href="paises?operacion=baja&cod=${zapato.precio}">Eliminar</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <p><a href="alta.jsp">Crear nuevo pais</a></p>

                <br/>
                <br/>
                <div id="listado"></div>
            </div>
        </div>
    </body>
</html>