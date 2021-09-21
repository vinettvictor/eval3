<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Home</title>

                <!--Boostrap Css-->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
            </head>

            <body>
                <div class="container">
                    <ul class="nav">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/producto">Crear Producto</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/logout">Cerra Sesion</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled">Ventas</a>
                        </li>
                    </ul>

                </div>

                <h1 align="center">Bienvenidos a Tu Sesion</h1>
                <br>
                <h1>Lista de Productos</h1>
                <hr>
                <form:form action="/home" method="get" modelAttribute="usuario">
                    <label for="productos">Seleccione Productos:</label><br>
                    <select name="productos" multiple>
					<c:forEach var="producto" items="${lista_productos}" >
						<option value="<c:out value="${producto.id}"></c:out>"> <c:out value="${producto.nombre}"></c:out> <c:out value="${producto.precio}"></c:out></option>
					</c:forEach>
					</select>
                    <br>

                    <input type="submit" value="Crear Persona">
                </form:form>
                <hr>
                </div>

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>


            </body>

            </html>