<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar</title>
</head>
<h1>Editar Producto</h1>
<body>
	<div>
		<form:form action="/producto/modificar" method="post" modelAttribute="producto">
			<input type="hidden" name="_method" value="PUT">
			<form:hidden path="id"></form:hidden>
			<form:label path="nombre">Nombre</form:label>
			<form:input type="text" path="nombre"></form:input><br>
			
			<form:label path="precio">Precio</form:label>
			<form:input type="text" path="precio"></form:input><br>
			
			<form:label path="descripcion">Descripción</form:label>
			<form:input type="text" path="descripcion"></form:input><br>
					
			<input type="submit" value="Actualizar Producto">
		</form:form>
		<br>
	</div>
</body>
</html>