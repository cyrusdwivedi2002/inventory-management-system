package com.Inventory;

import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.PreparedStatement;

import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
// Import Database Connection Class file
import code.DatabaseConnection;
  

@WebServlet("/Del12Data")
public class DelSRelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, 
HttpServletResponse response)
        throws ServletException, IOException
        
    {
    	
        try {
  
            // Initialize the database
            Connection con = DatabaseConnection.initializeDatabase();
            PrintWriter out = response.getWriter();
            Statement statement = null;
            
            String id = request.getParameter("pid");
            statement = con.createStatement(); 
            // Create a SQL query to insert data into demo table
            // demo table consists of two columns, so two '?' is used
            int result = statement.executeUpdate("delete from supplyrel where Prod_id='"+id+"'");
            out.println(result +"row(s) deleted");
             // For the first parameter,
             // get the data using request object
             // sets the data to st pointer
           //  String name = request.getParameter("inv_id");
             //String name1 = request.getParameter("inv_type");
            // System.out.println(name+" "+name1);
             
            
   
  
            // For the first parameter,
            // get the data using request object
            // sets the data to st pointer
           
          
  
            // Close all the connections
            
            con.close();
  
            // Get a writer pointer 
            // to display the successful result
           
 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
