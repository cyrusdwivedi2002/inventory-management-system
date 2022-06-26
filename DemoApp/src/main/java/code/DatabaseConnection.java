package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

  
// This class can be used to initialize the database connection
public class DatabaseConnection {
    public static Connection initializeDatabase()
        throws SQLException, ClassNotFoundException
    {
    	
        // Initialize all the information regarding
        // Database Connection
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql:// localhost:3306/lab6";
        // Database name to access
       //String dbName = "lab6";
        String dbUsername = "root";
        String dbPassword = "cyrussql@2002";
        
       
  
        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL,
                                                     dbUsername, 
                                                     dbPassword);
        return con;
    }
}
