package Asset.Controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Asset.dao.*;
import model.Asset;

@WebServlet("/UpdateAssetController")
public class UpdateAssetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private AssetDao dao;
  
    public UpdateAssetController() {
        super();
        dao = new AssetDao();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 int AssetID = Integer.parseInt(request.getParameter("AssetID"));
	 request.setAttribute("a", AssetDao.getAssetById(AssetID));
	 RequestDispatcher view = request.getRequestDispatcher("UpdateAsset.jsp");
	 view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Asset a = new Asset ();
		a.setAssetID(Integer.parseInt(request.getParameter("AssetID")));
		a.setModelname(request.getParameter("modelname"));
		a.setAsset_datepurchase(Date.valueOf(request.getParameter("StaffID")));
		a.setManufacturer(request.getParameter("manufacturer"));
		a.setInventoryid(Integer.parseInt(request.getParameter("inventoryid")));
		a.setStaffID(Integer.parseInt(request.getParameter("StaffID")));
		
		dao.updateAsset(a);
		
		request.setAttribute("Asset", AssetDao.getAllAsset());
		RequestDispatcher View = 	request.getRequestDispatcher("ListAsset.jsp");
		View.forward(request, response);
	}

}
