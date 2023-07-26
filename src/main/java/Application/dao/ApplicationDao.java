package Application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Application;
import connectionDB.ConnectionManager;

public class ApplicationDao {

	private Connection con;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;

    public void addApplication(Application a) {
        try {
            con = ConnectionManager.getConnection();

            //create statement
            ps = con.prepareStatement("INSERT INTO application_loan (appid, status_app, purpose, total_asset, datereturned, startdateloan, asset_status, AssetID, StaffID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, a.getAppid());
            ps.setString(2, a.getStatus_app());
            ps.setString(3, a.getPurpose());
            ps.setInt(4, a.getTotal_asset());
            ps.setDate(5, a.getDatereturned());
            ps.setDate(6, a.getStartdateloan());
            ps.setString(7, a.getAsset_status());
            ps.setInt(8, a.getAssetid());
            ps.setInt(9, a.getStaffid());

            //execute query
            ps.executeUpdate();
            System.out.println("Successfully inserted");

            //close connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	//get all Application
    public List<Application> getAllApplications() {
    	
        List<Application> applications = new ArrayList<>();

        try {
        	//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			st = con.createStatement();
			String sql = "SELECT appid, modelname, status_app, purpose, total_asset, startdateloan, datereturned, asset_status, application_loan.staffid, application_loan.assetid"
					+ "	FROM application_loan join asset on application_loan.assetid = asset.assetid "
					+ "	join inventory on asset.inventoryid = inventory.inventoryid order by appid asc";
			
			//execute query
            rs = st.executeQuery(sql);

            while (rs.next()) {		//process result
                applications.add(getApplication(rs));
            }

            //close connection
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

        return applications;
    }
    
	//get all Application
    public List<Application> getAllApplicationsByStaff(int staffId) {
    	
        List<Application> applications = new ArrayList<>();

        try {
        	//call getConnection() method
			con = ConnectionManager.getConnection();
			
			String sql = "SELECT appid, modelname, status_app, purpose, total_asset, startdateloan, datereturned, asset_status, application_loan.staffid, application_loan.assetid"
					+ "	FROM application_loan join asset on application_loan.assetid = asset.assetid "
					+ "	join inventory on asset.inventoryid = inventory.inventoryid where application_loan.staffid="+staffId+" order by appid asc";
			
			//create statement
			st = con.createStatement();
			
			//execute query
            rs = st.executeQuery(sql);

            while (rs.next()) {		//process result
                applications.add(getApplication(rs));
            }

            //close connection
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

        return applications;
    }
    
    //get asset by asset id
    public Application getApplicationById(int ApplicationID) {
        Application a = null;
        try {
        	//call getConnection method
			con = ConnectionManager.getConnection();
			
			String sql = "SELECT appid, modelname, status_app, purpose, total_asset, startdateloan, datereturned, asset_status, application_loan.staffid, application_loan.assetid"
					+ "	FROM application_loan join asset on application_loan.assetid = asset.assetid "
					+ "	join inventory on asset.inventoryid = inventory.inventoryid where appid=? order by appid asc";
			//create statement
            ps = con.prepareStatement(sql);
            ps.setInt(1, ApplicationID);

            //execute query
            rs = ps.executeQuery();
            if (rs.next()) {
                a = getApplication(rs);
            }

            //close connection
			con.close();
			
        } catch (Exception e) {
            e.printStackTrace();
        }

        return a;
    }

    public void updateApplicationStatus(int applicationId, String status) {
    	
        try {
        	//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
            ps = con.prepareStatement("UPDATE application_loan SET status_app = ? WHERE appid = ?");
            ps.setString(1, status);
            ps.setInt(2, applicationId);
            ps.executeUpdate();

            //close connection
			con.close();
			
            // reducing quantity.
            Application app = this.getApplicationById(applicationId);
            int quantity = app.getTotal_asset();
            int assetid = app.getAssetid();
            
            con = ConnectionManager.getConnection();
			
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery("select inventoryid from asset where assetid = " + assetid + ";");
            if (result.next()) {
            
	            int inventoryId = result.getInt(1);
	            statement.execute("update inventory SET totalassets = totalassets - " + quantity + 
	            		" where inventoryid = " + inventoryId + ";");
	            System.out.println("Quantity is updated.");
	            
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // update application
    public void updateApplication(Application a) {
        try {
        	//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
            ps = con.prepareStatement("UPDATE application_loan SET status_app = ?, purpose = ?, total_asset = ?, datereturned = ?, startdateloan = ?, asset_status = ?, AssetID = ?, StaffID = ? WHERE AppID = ?");
            ps.setString(1, a.getStatus_app());
            ps.setString(2, a.getPurpose());
            ps.setInt(3, a.getTotal_asset());
            ps.setDate(4, a.getDatereturned());
            ps.setDate(5, a.getStartdateloan());
            ps.setString(6, a.getAsset_status());
            ps.setInt(7, a.getAssetid());
            ps.setInt(8, a.getStaffid());
            ps.setInt(9, a.getAppid());
            
            //execute query
            ps.executeUpdate();
            
            System.out.println("Successfully update");

            //close connection
            con.close();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // delete application
    public void deleteApplication(int ApplicationID) {
        try {
        	//call getConnection method
			con = ConnectionManager.getConnection();
						
			//create statement
            ps = con.prepareStatement("DELETE FROM application_loan WHERE AppID = ?");
            ps.setInt(1, ApplicationID);
            
            //execute query
            ps.executeUpdate();

            //close connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private Application getApplication(ResultSet rs) throws SQLException {
    	Application a = new Application();
        a.setAppid(rs.getInt("AppID"));
        a.setStatus_app(rs.getString("status_app"));
        a.setPurpose(rs.getString("purpose"));
        a.setTotal_asset(rs.getInt("total_asset"));
        a.setModelName(rs.getString("modelname"));
        a.setDatereturned(rs.getDate("datereturned"));
        a.setStartdateloan(rs.getDate("startdateloan"));
        a.setAsset_status(rs.getString("asset_status"));
        a.setAssetid(rs.getInt("AssetID"));
        a.setStaffid(rs.getInt("StaffID"));
        return a;
    }    
    
}
