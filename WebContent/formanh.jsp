<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>ShuLuca Shop</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/shop-homepage.css" rel="stylesheet">

</head>

<body>
	<form style="text-align: center;" action="Zapateria">
		<h1>Insertar una zapatilla</h1>
		<label>Nombre</label> <input type="text" placeholder="nombre" name="nombre"/> <br />
		<label>Marca</label><input type="text" placeholder="marca" name ="marca" /> <br />
		<label>Color</label> <input type="text" placeholder="color" name ="color"/> <br />
		<label>Talla</label> <input type="text" placeholder="talla" name="talla"/><br />
		<label>Precio</label> <input type="text" placeholder="precio" name="precio" /> <br />
		<label>URL</label> <input type="text" placeholder="URL" name="url" /><br /> 
		<label>Nombre Categoria</label>
		<select name="categoria">
			<c:forEach var="categoria" items="${categorias}">
				<option value="${categoria.id}">${categoria.nombre}</option>
			</c:forEach>
		</select>
		
		<br/>
		<input type="hidden" name="page" value="insertar">
		
		<input type="submit" value="enviar" >

	</form>
	<input >
</body>

</html>