package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DishList;



/**
 * Servlet implementation class editItemServlet
 */
@WebServlet("/editItemServlet")
public class editItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DishListHelper dao = new DishListHelper();
		
		String country = request.getParameter("country");
		String dishName = request.getParameter("name");
		String dishDescription = request.getParameter("description");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
				
		DishList itemToUpdate = dao.searchForItemById(tempId);
		itemToUpdate.setCountry(country);
		itemToUpdate.setDishName(dishName);
		itemToUpdate.setDishDescription(dishDescription);
				
		dao.updateItem(itemToUpdate);

		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);


	}

}