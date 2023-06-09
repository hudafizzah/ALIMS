package Asset.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Asset.dao.*;
import model.Asset;

@WebServlet("/ListAssetController")
public class ListAssetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AssetDao dao;
    public ListAssetController() {
        super();
        dao = new AssetDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("Asset", AssetDao.getAllAsset());
		RequestDispatcher view = request.getRequestDispatcher("ListAsset");
		view.forward(request, response);
	}

}
