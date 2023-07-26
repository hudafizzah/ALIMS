package inventory.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Asset.dao.AssetDao;
import inventory.dao.InventoryDao;
import model.Asset;
import model.Inventory;

@WebServlet("/InventoryController")
public class InventoryController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private InventoryDao dao = new InventoryDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request,response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Inventory inventory = new Inventory();
		inventory.setId(Integer.parseInt(request.getParameter("InventoryID")));
		inventory.setModelName(request.getParameter("ModelName"));
		inventory.setManufacturer(request.getParameter("Manufacturer"));
		inventory.setTotalAssets(Integer.parseInt(request.getParameter("TotalAssets")));
		
		dao.addInventory(inventory);
	    System.out.println("Add Inventory!");
	    
	    response.sendRedirect("manageInventory.jsp");
		
	}
	
}
