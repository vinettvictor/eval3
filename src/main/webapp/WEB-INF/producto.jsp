<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Producto</title>
</head>
<h1>Crear Producto</h1>
<body>
	<div>
		<form:form action="/producto/crear" method="post" modelAttribute="producto">
			<form:label path="nombre">Nombre</form:label>
			<form:input type="text" path="nombre"></form:input><br>
					
			<form:label path="precio">Precio</form:label>
			<form:input type="number" path="precio"></form:input><br>
			
			<form:label path="descripcion">Descripción</form:label>
			<form:input type="text" path="descripcion"></form:input><br>
		
			<input type="submit" value="Agregar Producto">
		</form:form>
		<br>
		<h1>Lista de Productos</h1>
		<hr>
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Descripción</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="producto" items="${lista_productos}" >
					<tr>
						<td><c:out value="${producto.id}"></c:out></td>
						<td><c:out value="${producto.nombre}"></c:out></td>
						<td><c:out value="${producto.precio}"></c:out></td>
						<td><c:out value="${producto.descripcion}"></c:out></td>
						<td>
						<a href="/producto/actualizar/${producto.id}">Editar</a>						
						<form action="/producto/eliminar/${producto.id}" method="get">
							<input type="hidden" name="_method" value="delete">
							<input type="submit" value="Eliminar">
						</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr>
	</div>
</body>
</html>