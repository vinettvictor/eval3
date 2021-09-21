<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8" />
                <title>Registro</title>

                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

            </head>

            <body>

                <body>
                    <div class="container">
                        <ul class="nav">
                            <!--Permite volver atras, a la ventana home-->
                            <li class="nav-item">
                                <a class="nav-link" href="/">Volver al Login</a>
                            </li>
                        </ul>
                    </div>

                    <div>
                        <h1>Registro de Usuario</h1>
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

                        <h1>Lista de Usuarios Registrados</h1>
                        <hr>
                        <table>
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Rut</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>email</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="usuario" items="${lista_usuarios}">
                                    <tr>
                                        <td>
                                            <c:out value="${usuario.id}"></c:out>
                                        </td>
                                        <td>
                                            <c:out value="${usuario.rut}"></c:out>
                                        </td>
                                        <td>
                                            <c:out value="${usuario.nombre}"></c:out>
                                        </td>
                                        <td>
                                            <c:out value="${usuario.apellido}"></c:out>
                                        </td>
                                        <td>
                                            <c:out value="${usuario.email}"></c:out>
                                        </td>
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
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

                </body>

            </html>