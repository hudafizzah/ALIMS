package Asset.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Asset.dao.AssetDao;

@WebServlet("/DeleteAssetController")
public class DeleteAssetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteAssetController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int assetId = Integer.parseInt(request.getParameter("deleteassetid"));
    	AssetDao.deleteAsset(assetId);
    	RequestDispatcher view = request.getRequestDispatcher("ListAsset.jsp");
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
