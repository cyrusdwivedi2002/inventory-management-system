package com.Inventory;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
// Import Database Connection Class file
import code.DatabaseConnection;
  

@WebServlet("/InsertData")
public class InvServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
  
    protected void doPost(HttpServletRequest request, 
HttpServletResponse response)
        throws ServletException, IOException
        
    {
    	
        try {
  
            // Initialize the database
            Connection con = DatabaseConnection.initializeDatabase();
  
            // Create a SQL query to insert data into demo table
            // demo table consists of two columns, so two '?' is used
            PreparedStatement st = con
                   .prepareStatement("insert into inventory values(?,?)");
  
            // For the first parameter,
            // get the data using request object
            // sets the data to st pointer
            String name = request.getParameter("inv_id");
            String name1 = request.getParameter("inv_type");
            System.out.println(name+" "+name1);
            
            st.setString(1,request.getParameter("inv_id"));
  
            // Same for second parameter
            
            st.setString(2,request.getParameter("inv_type"));
            
            // Execute the insert command using executeUpdate()
            // to make changes in database
           
            st.executeUpdate();
  
            // Close all the connections
            st.close();
            con.close();
  
            // Get a writer pointer 
            // to display the successful result
            PrintWriter out = response.getWriter();
            out.println("<html><body><b>Successfully Inserted"
                        + "</b></body></html>");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}