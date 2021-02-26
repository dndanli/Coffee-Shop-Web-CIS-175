/**
 * @author Daniel De Lima - dcdelima
 * CIS 175 - Spring 2021
 * Feb 25, 2021
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CoffeeBeanOrder;

/**
 * Servlet implementation class EditOrderServlet
 */
@WebServlet("/editOrderServlet")
public class EditOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOrderServlet() {
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
		doGet(request, response);
		CoffeeBeanOrderHelper dao = new CoffeeBeanOrderHelper();
		String beanName = request.getParameter("beanName");
		int quantity = Integer.parseInt(request.getParameter("orderQuantity"));
		int packagesInStock = Integer.parseInt(request.getParameter("packagesStock"));
		String supplierName = request.getParameter("supplierName");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		CoffeeBeanOrder orderToUpdate = dao.searchForOrderByID(tempId);
		orderToUpdate.setBeanName(beanName);
		orderToUpdate.setQuantityToOrder(quantity);
		orderToUpdate.setPackagesInStock(packagesInStock);
		orderToUpdate.setSupplier(supplierName);
		
		dao.updateOrder(orderToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllOrdersServlet").forward(request, response);
	}

}
