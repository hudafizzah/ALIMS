package Application.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Application.dao.ApplicationDao;
import Asset.dao.AssetDao;
import model.Application;
import model.Asset;

@WebServlet("/CreateApplicationController")
public class CreateApplicationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationDao applicationDao;
    public CreateApplicationController() {
    super();
    applicationDao =new ApplicationDao();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("Get");
    	doPost(request,response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Application application = new Application();
		
		application.setAppid(Integer.parseInt(request.getParameter("appid")));
		application.setStatus_app("Pending");
	    application.setPurpose(request.getParameter("purpose"));
	    application.setTotal_asset(Integer.parseInt(request.getParameter("total_asset")));
	    application.setDatereturned(Date.valueOf(request.getParameter("datereturned")));
	    application.setStartdateloan(Date.valueOf(request.getParameter("startdateloan")));
	   
	    int assetId = Integer.parseInt(request.getParameter("appmodelid"));
	    
	    Asset asset = AssetDao.getAssetById(assetId);
	    application.setAsset_status("Loan");
	    application.setAssetid(assetId);
	    
	    application.setStaffid(Integer.parseInt(request.getParameter("StaffID")));

	    applicationDao.addApplication(application);
	    System.out.println("Add Application!");
	    
	    response.sendRedirect("MyApplication.jsp");
		
	}
    
}


