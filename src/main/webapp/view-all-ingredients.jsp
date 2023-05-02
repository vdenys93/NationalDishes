<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View All Ingredients</title>
</head>
<body>
    <h1>All Ingredients</h1>
    <table border="1">
        <tr>
            <th>Ingredient ID</th>
            <th>Ingredient Name</th>
            <th>Dish ID</th>
            <th>Dish Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="ingredient" items="${allIngredients}">
            <tr>
                <td>${ingredient.id}</td>
                <td>${ingredient.ingredientName}</td>
                <td>${ingredient.dishList.id}</td>
                <td>${ingredient.dishList.dishName}</td>
                <td>
                    <a href="editIngredient?id=${ingredient.id}">Edit</a> |
                    <a href="deleteIngredient?id=${ingredient.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br />
    <a class="center" href="index.html">Go back to main screen</a>
    <br />
    <br />
    <a href="add-ingredient.jsp">Add new ingredient</a>
</body>
</html>
