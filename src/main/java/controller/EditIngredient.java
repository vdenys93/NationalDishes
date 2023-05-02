package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ingredient;

@WebServlet("/editIngredient")
public class EditIngredient extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IngredientHelper ingredientHelper = new IngredientHelper();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Ingredient ingredient = ingredientHelper.searchForIngredientById(id);
        request.setAttribute("ingredient", ingredient);
        getServletContext().getRequestDispatcher("/edit-ingredient.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String ingredientName = request.getParameter("ingredientName");

        Ingredient ingredient = ingredientHelper.searchForIngredientById(id);
        ingredient.setIngredientName(ingredientName);

        ingredientHelper.updateIngredient(ingredient);
        getServletContext().getRequestDispatcher("/viewAllIngredientsServlet").forward(request, response);
    }
}
