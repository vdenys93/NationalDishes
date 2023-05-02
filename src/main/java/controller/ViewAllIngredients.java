package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ingredient;

@WebServlet("/viewAllIngredients")
public class ViewAllIngredients extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IngredientHelper ingredientHelper = new IngredientHelper();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ingredient> allIngredients = ingredientHelper.showAllIngredients();
        request.setAttribute("allIngredients", allIngredients);

        if (allIngredients.isEmpty()) {
            request.setAttribute("allIngredients", " ");
        }

        getServletContext().getRequestDispatcher("/view-all-ingredients.jsp").forward(request, response);
    }
}
