<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html >
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="dish.css">
<title >Edit page</title>
</head>
<body >
<form class="container"  action = "editItemServlet" method="post">
Country: <input type ="text" name = "country" value= "${itemToEdit.country}"> <br />
Dish Name: <input type = "text" name = "name" value= "${itemToEdit.dishName}"><br />
Dish Description: <input type = "text" name = "description" value= "${itemToEdit.dishDescription}"><br />
<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value="Save Edited Item">
</form>

</body>
</html>