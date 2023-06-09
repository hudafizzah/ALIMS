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

@WebServlet("/AddAssetController")
public class AddAssetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AssetDao dao;
     
    public AddAssetController() {
        super();
        dao = new AssetDao();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    Asset a = new Asset();
	    
	    a.setAssetID(Integer.parseInt(request.getParameter("AssetID")));
	    a.setAsset_datepurchase(Date.valueOf(request.getParameter("asset_datepurchase")));
	    a.setModelname(request.getParameter("modelname"));
	   a.setManufacturer(request.getParameter("manufacturer"));
	   a.setInventoryid(Integer.parseInt(request.getParameter("inventoryid")));
	   a.setStaffID(Integer.parseInt(request.getParameter("StaffID")));
	    
	    dao.addAsset(a);
	    
	    request.setAttribute("Asset", AssetDao.getAllAsset());
	    RequestDispatcher view = request.getRequestDispatcher("ListAsset.jsp");
	    view.forward(request, response);
	}

}
