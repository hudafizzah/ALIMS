package inventory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectionDB.ConnectionManager;
import model.Application;
import model.Inventory;

public class InventoryDao {

	private Connection con;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    
    public void addInventory(Inventory a) {
        try {
            con = ConnectionManager.getConnection();

            //create statement
            ps = con.prepareStatement("INSERT INTO public.inventory(inventoryid, modelname, manufacturer, totalassets) VALUES (?, ?, ?, ?);");
            ps.setInt(1, a.getId());
            ps.setString(2, a.getModelName());
            ps.setString(3, a.getManufacturer());
            ps.setInt(4, a.getTotalAssets());

            //execute query
            ps.executeUpdate();
            System.out.println("Successfully inserted");

            //close connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //get all inventories
    public List<Inventory> getAllInventories() {
    	
        List<Inventory> list = new ArrayList<>();

        try {
        	//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			st = con.createStatement();
			String sql = "SELECT * FROM inventory";
			
			//execute query
            rs = st.executeQuery(sql);

            while (rs.next()) {		//process result
            	list.add(new Inventory(rs.getInt(1), rs.getString(2),
            			rs.getString(3), rs.getInt(4)));
            }

            //close connection
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

        return list;
    }
	
    public void deleteInventory(int id) {
        try {
        	//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
            ps = con.prepareStatement("DELETE FROM inventory WHERE inventoryid = ?");
            ps.setInt(1, id);
            
            //execute query
            ps.executeUpdate();

            //close connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
