<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="ISO-8859-1">
                <title>Producto</title>
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
                            <a class="nav-link" href="/home">Volver</a>
                        </li>
                    </ul>

                </div>


                <div>
                    <h1>Crear Producto</h1>
                    <hr>
                    <form:form action="/producto/crear" method="post" modelAttribute="producto">
                        <form:label path="nombre">Nombre</form:label>
                        <form:input type="text" path="nombre"></form:input><br>

                        <form:label path="precio">Precio</form:label>
                        <form:input type="number" path="precio"></form:input><br>

                        <form:label path="descripcion">Descripci�n</form:label>
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
                                <th>Descripci�n</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="producto" items="${lista_productos}">
                                <tr>
                                    <td>
                                        <c:out value="${producto.id}"></c:out>
                                    </td>
                                    <td>
                                        <c:out value="${producto.nombre}"></c:out>
                                    </td>
                                    <td>
                                        <c:out value="${producto.precio}"></c:out>
                                    </td>
                                    <td>
                                        <c:out value="${producto.descripcion}"></c:out>
                                    </td>
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
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

            </body>

            </html>