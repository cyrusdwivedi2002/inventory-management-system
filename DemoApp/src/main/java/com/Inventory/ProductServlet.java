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
  

@WebServlet("/Insert7Data")
public class ProductServlet extends HttpServlet {
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
                   .prepareStatement("insert into product values(?,?,?,?,?,?)");
  
            // For the first parameter,
            // get the data using request object
            // sets the data to st pointer
            
            st.setString(1,request.getParameter("pid"));
  
            // Same for second parameter
            
            st.setString(2,request.getParameter("pdesc"));
st.setString(3,request.getParameter("pname"));
st.setInt(4,Integer.valueOf(request.getParameter("price")));
st.setString(5,request.getParameter("invid"));
st.setString(6,request.getParameter("catgid"));
            
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
