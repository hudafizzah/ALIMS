package Application.controller;
import java.sql.Date;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Application.dao.ApplicationDao;
import Asset.dao.AssetDao;
import model.Application;
import model.Asset;

@WebServlet("/UpdateApplication")
public class UpdateApplicationController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ApplicationDao applicationDao;
    public UpdateApplicationController() {
        super();
        applicationDao =new ApplicationDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request,response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ApplicationDao dao = new ApplicationDao();
		Application application = dao.getApplicationById(Integer.parseInt(request.getParameter("appid")));
	    application.setPurpose(request.getParameter("purpose"));
	    application.setTotal_asset(Integer.parseInt(request.getParameter("total_asset")));
	    application.setDatereturned(Date.valueOf(request.getParameter("datereturned")));
	    application.setStartdateloan(Date.valueOf(request.getParameter("startdateloan")));
	   
	    int assetId = Integer.parseInt(request.getParameter("appmodelid"));
	    application.setAsset_status("Loan");
	    application.setAssetid(assetId);

	    applicationDao.updateApplication(application);
	    System.out.println("Update Application!");
	    
	    response.sendRedirect("ListApprovedApplication.jsp");
		
	}
    
}
