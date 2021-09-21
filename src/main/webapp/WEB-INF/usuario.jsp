<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
</head>
<h1>Registro de Usuario</h1>
<body>
	<div>
		<form:form action="/usuario/crear" method="post" modelAttribute="usuario">
			<form:label path="rut">Rut</form:label>
			<form:input type="text" path="rut"></form:input><br>
					
			<form:label path="nombre">Nombre</form:label>
			<form:input type="text" path="nombre"></form:input><br>
			
			<form:label path="apellido">Apellido</form:label>
			<form:input type="text" path="apellido"></form:input><br>
			
			<form:label path="email">Email</form:label>
			<form:input type="text" path="email"></form:input><br>
			
			<form:label path="password">Contraseña</form:label>
			<form:input type="password" path="password"></form:input><br>
			
			
			<input type="submit" value="Crear Usuario">
		</form:form>
		
		<h1>Lista de Usuarios</h1>
		<hr>
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Rut</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>email</th>
					<th>Password Hasheada</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="usuario" items="${lista_usuarios}" >
					<tr>
						<td><c:out value="${usuario.id}"></c:out></td>
						<td><c:out value="${usuario.rut}"></c:out></td>
						<td><c:out value="${usuario.nombre}"></c:out></td>
						<td><c:out value="${usuario.apellido}"></c:out></td>
						<td><c:out value="${usuario.email}"></c:out></td>
						<td><c:out value="${usuario.password}"></c:out></td>
						<td> 
							<a href="/usuario/actualizar/${usuario.id}">Editar</a>
							
							<form action="/usuario/eliminar/${usuario.id}" method="get">
								<input type="hidden" name="_method" value="delete">
								<input type="submit" value="Eliminar">
							</form>

						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr>
		<br>
	</div>
</body>
</html>