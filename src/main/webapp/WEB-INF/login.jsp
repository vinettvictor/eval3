<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Pagina de Login</title>
</head>
<body>
    <h1>Login</h1>
    <form method="post" action="/ingresar">
        <p>
            <label for="email">Email</label>
            <input type="text" id="email" name="email"/>
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </p>
        <a href="/usuario"> Registrarse</a> 
        <input type="submit" value="Login!"/> 
    </form>  
</body>
</html>