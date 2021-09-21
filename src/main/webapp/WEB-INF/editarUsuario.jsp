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
<h1>Editar Usuario</h1>
<body>
	<div>
		<form:form action="/usuario/modificar" method="post" modelAttribute="usuario">
			<input type="hidden" name="_method" value="PUT">
			<form:hidden path="id"></form:hidden>
			<form:label path="rut">Rut</form:label>
			<form:input type="text" path="rut"></form:input><br>
			
			<form:label path="nombre">Nombre</form:label>
			<form:input type="text" path="nombre"></form:input><br>
			
			<form:label path="apellido">Apellido</form:label>
			<form:input type="text" path="apellido"></form:input><br>
			
			<form:label path="email">Correo</form:label>
			<form:input type="text" path="email"></form:input><br>
			
			<form:label path="password">Ingrese Contraseña Nueva</form:label>
			<form:input type="text" path="password"></form:input><br>
			
			<input type="submit" value="Actualizar Datos">
		</form:form>
		<br>
	</div>
</body>
</html>