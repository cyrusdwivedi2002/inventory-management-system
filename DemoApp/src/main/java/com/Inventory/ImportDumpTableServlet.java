package com.Inventory;


import java.io.IOException;
//import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileWriter;
//import java.sql.*;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
// Import Database Connection Class file
import code.DatabaseConnection;
  

@WebServlet("/ImportDumpTable")
public class ImportDumpTableServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
  
    protected void doPost(HttpServletRequest request, 
HttpServletResponse response)
        throws ServletException, IOException
        
    {
    	
        try {
        	PrintWriter out = response.getWriter();
        	
        	
        	  
            // Initialize the database
            Connection con = DatabaseConnection.initializeDatabase();
            
           Statement stmt = con.createStatement();
           
            		//ResultSet res = null;
            int ch = Integer.valueOf(request.getParameter("table_name"));
            // Create a SQL query to insert data into demo table
            // demo table consists of two columns, so two '?' is used
            //String filename = request.getParameter("file_path");
            switch( ch) {
            case 1: 
            	
            	String sql = "load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Data/csvfiles/Category.csv' into table category fields terminated by ',' lines terminated by '\n' ignore 1 lines";
                
            stmt.execute(sql);
                    
            	out.println
            	   ("<b>You Successfully Imported.</b>");
            	 
                break;
            
            case 2:
            	 sql = "load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Data/csvfiles/cust_mobileno.csv' into table cust_mobileno fields terminated by ',' ENCLOSED BY '\"' lines terminated by '\n' ignore 1 lines";
                
                stmt.execute(sql);
                        
                	out.println
                	   ("<b>You Successfully Imported.</b>");
                	 
                    break;
            case 3:
            	 sql = "load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Data/csvfiles/customer.csv' into table customer fields terminated by ',' lines terminated by '\n' ignore 1 lines";
                 
                 stmt.execute(sql);
                         
                 	out.println
                 	   ("<b>You Successfully Imported.</b>");
                 	 
                     break;
            case 4:
            	 sql = "load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Data/csvfiles/dependent.csv' into table dependent fields terminated by ',' lines terminated by '\n' ignore 1 lines";
                 
                 stmt.execute(sql);
                         
                 	out.println
                 	   ("<b>You Successfully Imported.</b>");
                 	 
                     break;
            case 5:
            	 sql = "load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Data/csvfiles/inventory.csv' into table inventory fields terminated by ',' lines terminated by '\n' ignore 1 lines(inv_id,inv_type)";
                 
                 stmt.execute(sql);
                         
                 	out.println
                 	   ("<b>You Successfully Imported.</b>");
                 	 
                     break;
            case 6:
                     sql = "load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Data/csvfiles/o_detailsrel.csv' into table o_detailsrel fields terminated by ',' lines terminated by '\n' ignore 1 lines";
                     
                     stmt.execute(sql);
                             
                     	out.println
                     	   ("<b>You Successfully Imported.</b>");
                     	 
                         break;
            case 7:
            	sql = "load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Data/csvfiles/orderst.csv' into table orderst fields terminated by ',' lines terminated by '\n' ignore 1 lines";
                
                stmt.execute(sql);
                        
                	out.println
                	   ("<b>You Successfully Imported.</b>");
                	 
                    break;
                    
            case 8:
            	sql = "load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Data/csvfiles/product.csv' into table product fields terminated by ',' lines terminated by '\n' ignore 1 lines";
                
                stmt.execute(sql);
                        
                	out.println
                	   ("<b>You Successfully Imported.</b>");
                	 
                    break;
            case 9:
            	sql = "load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Data/csvfiles/staff.csv' into table staff fields terminated by ',' lines terminated by '\r\n' ignore 1 ROWS";
                
                stmt.execute(sql);
                        
                	out.println
                	   ("<b>You Successfully Imported.</b>");
                	 
                    break;
            case 10:
            	sql = "load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Data/csvfiles/supp_contacts.csv' into table supp_contacts fields terminated by ',' lines terminated by '\n' ignore 1 lines";
                
                stmt.execute(sql);
                        
                	out.println
                	   ("<b>You Successfully Imported.</b>");
                	 
                    break;
            case 11:
            	sql = "load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Data/csvfiles/Book1.csv' into table supplier fields terminated by ',' lines terminated by '\n' ignore 1 lines";
                
                stmt.execute(sql);
                        
                	out.println
                	   ("<b>You Successfully Imported.</b>");
                	 
                    break;
            case 12:
            	sql = "load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Data/csvfiles/supply_rel.csv' into table supplyrel fields terminated by ',' lines terminated by '\n' ignore 1 lines";
                
                stmt.execute(sql);
                        
                	out.println
                	   ("<b>You Successfully Imported.</b>");
                	 
                    break;
            }
        }
            

        
        catch (Exception e) {
            e.printStackTrace();
        }
   }
}
    
