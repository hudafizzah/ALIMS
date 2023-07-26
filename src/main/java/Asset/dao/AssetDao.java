package Asset.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectionDB.ConnectionManager;
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
			ps = con.prepareStatement("INSERT INTO Asset (AssetID,asset_datepurchase, inventoryid, StaffID)VALUES(?,?,?,?)");
			ps.setInt(1, AssetID);
			ps.setDate(2, asset_datepurchase);
			ps.setInt(3,inventoryid);
			ps.setInt(4,StaffID);
			
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
	public static List<Asset> getAllAsset(int staffId) {
		List<Asset> asset = new ArrayList<Asset>();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			st = con.createStatement();
			String sql = "SELECT assetid, asset_datepurchase, modelname, manufacturer, asset.inventoryid, staffid "
					+ "	FROM asset JOIN inventory on inventory.inventoryid = asset.inventoryid "
					+ "	Where StaffID="+staffId+" ORDER BY AssetID;";
			
			//execute query
			rs = st.executeQuery(sql);
			while(rs.next()) {		//process result
				
				Asset a = new Asset();
				a.setAssetID(rs.getInt(1));
				a.setModelname(rs.getString(3));
				a.setAsset_datepurchase(rs.getDate(2));
				a.setManufacturer(rs.getString(4));
				a.setInventoryid(rs.getInt(5));
				a.setStaffID(rs.getInt(6));
				
			
				asset.add(a);
			}
			
			//close connection
			con.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return asset;
	}
	
	//get all Asset
	public static List<Asset> getAllAssetsList() {
		List<Asset> asset = new ArrayList<Asset>();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			st = con.createStatement();
			String sql = "SELECT assetid, asset_datepurchase, modelname, manufacturer, asset.inventoryid, staffid "
					+ "	FROM asset JOIN inventory on inventory.inventoryid = asset.inventoryid "
					+ " ORDER BY AssetID;";
			
			//execute query
			rs = st.executeQuery(sql);
			while(rs.next()) {		//process result
				
				Asset a = new Asset();
				a.setAssetID(rs.getInt(1));
				a.setModelname(rs.getString(3));
				a.setAsset_datepurchase(rs.getDate(2));
				a.setManufacturer(rs.getString(4));
				a.setInventoryid(rs.getInt(5));
				a.setStaffID(rs.getInt(6));
				
			
				asset.add(a);
			}
			
			//close connection
			con.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return asset;
	}
	
	
	//get outdated Asset
	public static List<Asset> getOutdatedAsset(int staffId) {
		List<Asset> asset = new ArrayList<Asset>();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			st = con.createStatement();
			String sql = "SELECT assetid, asset_datepurchase, modelname, manufacturer, asset.inventoryid, staffid "
					+ "	FROM asset JOIN inventory on inventory.inventoryid = asset.inventoryid"
					+ " WHERE StaffID = " + staffId + " AND asset_datepurchase "
					+ "<= date_trunc('year', current_date) - interval '4 years' ORDER BY AssetID";
			
			//execute query
			rs = st.executeQuery(sql);
			while(rs.next()) {		//process result
				
				Asset a = new Asset();
				a.setAssetID(rs.getInt("assetid"));
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
				a.setAsset_datepurchase(rs.getDate("asset_datepurchase"));
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
	public static void deleteAsset (int AssetID) {
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
	
	public static List<Integer> getInventoryIds(){
		
		List<Integer> ids = new ArrayList<>();
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("select inventoryid from inventory;");
			
			//execute query
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				ids.add(result.getInt(1));
			}
			
			System.out.println("Succesfull update");
			
			//close connection
			con.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ids;
		
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
			ps = con.prepareStatement("UPDATE Asset SET asset_datepurchase=?, inventoryid=? where assetid=?;");
			
			ps.setDate(1, asset_datepurchase);
			ps.setInt(2,inventoryid);
			ps.setInt(3, AssetID);
			
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
