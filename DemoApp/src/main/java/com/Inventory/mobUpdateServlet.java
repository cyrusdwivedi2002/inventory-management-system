package com.Inventory;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.*;
  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
// Import Database Connection Class file
import code.DatabaseConnection;
  

@WebServlet("/UpdateCustmob")
public class mobUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
  
    protected void doPost(HttpServletRequest request, 
HttpServletResponse response)
        throws ServletException, IOException
        
    {
    	
        try {
        	PrintWriter out = response.getWriter();
        	 
        	response.setContentType("text/html");  
            out.println("<html><body>"); 
            // Initialize the database
            Connection con = DatabaseConnection.initializeDatabase();
            Statement stmt = con.createStatement();
            		//ResultSet res = null;
            int ch = Integer.valueOf(request.getParameter("mobno"));
            // Create a SQL query to insert data into demo table
            // demo table consists of two columns, so two '?' is used
            String old = request.getParameter("old_value");
            String new_v = request.getParameter("new_value");
            
            switch( ch) {
            case 1:
            
            	 String sql = "UPDATE cust_mobileno SET cmobile_no = '"+new_v+"'  where Cust_id='"+old+"'";
            	 stmt.executeUpdate(sql);	 
            	 
            	 out.println( "row(s) updated");
            	 break;
            case 2:
            	 sql = "UPDATE cust_mobileno SET Cust_id = '"+new_v+"'  where Cust_id='"+old+"'";
           	 stmt.executeUpdate(sql);	 
           	 
           	 out.println( "row(s) updated");
           	 break;
            	
            }
            }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
