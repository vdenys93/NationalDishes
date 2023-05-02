<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Ingredient</title>
</head>
<body>
    <h1>Edit Ingredient</h1>
    <form action="editIngredient" method="post">
        <input type="hidden" name="id" value="${ingredient.id}" />
        Ingredient Name: <input type="text" name="ingredientName" value="${ingredient.ingredientName}" /><br />
        <input type="submit" value="Update Ingredient" />
    </form>
    <br />
    <a href="viewAllIngredientsServlet">View All Ingredients</a>
</body>
</html>
