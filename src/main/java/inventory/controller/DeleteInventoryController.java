package inventory.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inventory.dao.InventoryDao;

@WebServlet("/DeleteInventoryController")
public class DeleteInventoryController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private InventoryDao inventoryDao;
	
	public DeleteInventoryController() {
        super();
        inventoryDao =new InventoryDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int inventoryId = Integer.parseInt(request.getParameter("deleteinventoryid"));
    	inventoryDao.deleteInventory(inventoryId);
    	RequestDispatcher view = request.getRequestDispatcher("manageInventory.jsp");
		view.forward(request, response);
    }
    
}
