package Asset.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import connectionDB.*;
import model.Asset;

public class AssetDao {
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement st = null;
	static ResultSet rs = null;
	
	private int AssetID;
	private Date asset_datepurchase;
	private String modelname;
	private String manufacturer;
	private int inventoryid;
	private int StaffID;
	
	
	//add asset
	public void addAsset (Asset a) {
		AssetID = a.getAssetID();
		modelname = a.getModelname();
		asset_datepurchase = a.getAsset_datepurchase();
		manufacturer = a.getManufacturer();
		inventoryid= a.getInventoryid();
		StaffID = a.getStaffID();
		
		try {
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("INSERT INTO Asset (AssetID, modelname,asset_datepurchase, manufacturer, inventoryid, StaffID)VALUES(Asset_sequence.nextval,?,?,?,?,?,?)");
			ps.setInt(1, AssetID);
			ps.setString(2, modelname);
			ps.setDate(3, asset_datepurchase);
			ps.setString(4,manufacturer);
			ps.setInt(5,inventoryid);
			ps.setInt(6,StaffID);
			
			//execute query
			ps.executeUpdate();
			System.out.println("Successfuly inserted");
			
			//close connection
			con.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//get all Asset
	public static List<Asset> getAllAsset() {
		List<Asset> asset = new ArrayList<Asset>();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			st = con.createStatement();
			String sql = "SELECT * FROM Asset ORDER BY AssetID";
			
			//execute query
			rs = st.executeQuery(sql);
			
			while(rs.next()) {		//process result
				Asset a = new Asset();
				a.setAssetID(rs.getInt("productID"));
				a.setModelname(rs.getString("modelname"));
				a.setAsset_datepurchase(rs.getDate("asset_datepurchase"));
				a.setManufacturer(rs.getString("manufacturer"));
				a.setInventoryid(rs.getInt("inventoryid"));
				a.setStaffID(rs.getInt("StaffID"));
				
			
				asset.add(a);
			}
			
			//close connection
			con.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return asset;
	}	
	
	//get asset by asset id
	public static Asset getAssetById(int AssetID) {
		Asset a = new Asset ();
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps= con.prepareStatement("SELECT * FROM Asset WHERE AssetID=?");
			ps.setInt(1, AssetID);
			
			//execute query
			rs = ps.executeQuery();
			if(rs.next()) {
				
				a.setAssetID(rs.getInt("AssetID"));
				a.setModelname(rs.getString("modelname"));
				a.setAsset_datepurchase(rs.getDate("asset_datepurchase"));
				a.setManufacturer(rs.getString("manufacturer"));
				a.setInventoryid(rs.getInt("inventoryid"));
				a.setStaffID(rs.getInt("StaffID"));
				
			}
			
			//close connection
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return a;
	}
		
	//delete asset
	public void deleteAsset (int AssetID) {
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("DELETE FROM ASSET WHERE AssetID=?");
			ps.setInt(1, AssetID);
			
			//execute query
			ps.executeUpdate();
			
			//close connection
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//update asset
	public void updateAsset (Asset a) {
		AssetID = a.getAssetID();
		modelname = a.getModelname();
		asset_datepurchase = a.getAsset_datepurchase();
		manufacturer = a.getManufacturer();
		inventoryid= a.getInventoryid();
		StaffID = a.getStaffID();
		
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("UPDATE Asset SET AssetID=?, modelname=?, asset_datepurchase=?, manufacturer=?, inventoryid=?, StaffID=?");
			
			ps.setInt(1, AssetID);
			ps.setString(2, modelname);
			ps.setDate(3, asset_datepurchase);
			ps.setString(4,manufacturer);
			ps.setInt(5,inventoryid);
			ps.setInt(6,StaffID);
			
			//execute query
			ps.executeUpdate();
			
			System.out.println("Succesfull update");
			
			//close connection
			con.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
