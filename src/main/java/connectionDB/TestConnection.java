package connectionDB;
import java.sql.*;

public class TestConnection {

	public static void main(String[] args) {
	    
	    try {
	      
	    	System.out.println("Starting Conenction!");
	      Connection connection = ConnectionManager.getConnection();
	      System.out.println("Created Connection");
	      if(connection != null)
	        System.out.println("Connection success!");
	      else 
	        System.out.println("Connection failed.");
	      
	      DatabaseMetaData metadata = connection.getMetaData();
          ResultSet resultSet = metadata.getTables(null, null, "%", null);
          
          while (resultSet.next()) {
              String tableName = resultSet.getString("TABLE_NAME");
              System.out.println(tableName);
          }
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    
	    
	    
	  }
}
