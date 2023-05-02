package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ingredient;


@WebServlet("/deleteIngredient")
public class DeleteIngredient extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IngredientHelper ingredientHelper = new IngredientHelper();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Ingredient ingredient = ingredientHelper.searchForIngredientById(id);
        ingredientHelper.deleteIngredient(ingredient);
        getServletContext().getRequestDispatcher("/viewAllIngredientsServlet").forward(request, response);
    }
}
