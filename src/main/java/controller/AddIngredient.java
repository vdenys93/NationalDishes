package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DishList;
import model.Ingredient;

@WebServlet("/addIngredient")
public class AddIngredient extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DishListHelper dishListHelper = new DishListHelper();
    private IngredientHelper ingredientHelper = new IngredientHelper();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ingredientName = request.getParameter("ingredientName");
        String dishName = request.getParameter("dishName");

        List<DishList> dishes = dishListHelper.searchForItemByName(dishName);
        if (!dishes.isEmpty()) {
            DishList dishList = dishes.get(0); // Use the first dish with the given name
            Ingredient ingredient = new Ingredient(ingredientName, dishList);
            ingredientHelper.insertIngredient(ingredient);
            getServletContext().getRequestDispatcher("/index.html").forward(request, response);
        } else {
            // Handle the case when there is no dish with the given name
            request.setAttribute("errorMessage", "Dish not found");
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
