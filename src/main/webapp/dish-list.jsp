<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html >
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="dish.css">
<title>Dish List</title>
</head>
<body>
<form class="container" method = "post" action = "navigationServlet">
<table>
<c:forEach items="${requestScope.allItems}" var="currentitem">
<tr>
   <td><input type="radio" name="id" value="${currentitem.id}"></td>
   <td>${currentitem.country}</td>
   <td>${currentitem.dishName}</td>
   <td>${currentitem.dishDescription}</td>
   </tr>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type="submit" value = "add" name = "doThisToItem">
</form>


</body>
</html>