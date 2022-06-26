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
  

@WebServlet("/ViewTable")
public class ViewServlet extends HttpServlet {
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
            		ResultSet res = null;
            int ch = Integer.valueOf(request.getParameter("table_name"));
            // Create a SQL query to insert data into demo table
            // demo table consists of two columns, so two '?' is used
            switch( ch) {
            case 1: 
            	 res = stmt.executeQuery("select * from category"); 
            	out.println("<table border=1 width=50% height=50%>"); 
            	out.println("<tr><th>Catg_id</th><th>catg_name</th><tr>");
            	while (res.next()) 
                {  
                    String n = res.getString("Catg_id");  
                    String nm = res.getString("catg_name");  
                    out.println("<tr><td>" + n + "</td><td>" + nm + "</td></tr>");   
                }  
                out.println("</table>");  
                out.println("</html></body>"); 
                break;
            case 2: 
            	 res = stmt.executeQuery("select * from cust_mobileno"); 
            	out.println("<table border=1 width=50% height=50%>"); 
            	out.println("<tr><th>cmobile_no</th><th>cust_id</th><tr>");
            	while (res.next()) 
                {  
                    int n = res.getInt("cmobile_no");  
                    String nm = res.getString("Cust_id");  
                    out.println("<tr><td>" + n + "</td><td>" + nm + "</td></tr>");   
                }  
                out.println("</table>");  
                out.println("</html></body>"); 
                break;
            case 3: 
           	 res = stmt.executeQuery("select * from customer"); 
           	out.println("<table border=1 width=50% height=50%>"); 
           	out.println("<tr><th>cust_id</th><th>cFname</th><th>cMname</th><th>cLname</th><th>Address</th><th>Staff_id</th><tr>");
           	while (res.next()) 
               {  
                    
                   String nm = res.getString("Cust_id"); 
                   String nm1 = res.getString("cF_name");
                   String nm2 = res.getString("cM_name");
                   String nm3 = res.getString("cL_name");
                   String nm4 = res.getString("address");
                   String nm5 = res.getString("Staff_id");
                   out.println("<tr><td>" + nm + "</td><td>" + nm1 + "</td><td>" + nm2 + "</td><td>" + nm3 + "</td><td>" + nm4 + "</td><td>" + nm5 + "</td></tr>");   
               }  
               out.println("</table>");  
               out.println("</html></body>"); 
               break;
            case 4:
            	res = stmt.executeQuery("select * from dependent"); 
               	out.println("<table border=1 width=50% height=50%>"); 
               	out.println("<tr><th>Staff_id</th><th>Name</th><th>Sex</th><th>Relationship</th><tr>");
               	while (res.next()) 
                   {  
                        
                       String nm = res.getString("Staff_id"); 
                       String nm1 = res.getString("Name");
                       String nm2 = res.getString("Sex");
                       String nm3 = res.getString("Relationship");
     
                       out.println("<tr><td>" + nm + "</td><td>" + nm1 + "</td><td>" + nm2 + "</td><td>" + nm3 + "</td></tr>");   
                   }  
                   out.println("</table>");  
                   out.println("</html></body>"); 
                   break;
            case 5:
            	 res = stmt.executeQuery("select * from inventory"); 
             	out.println("<table border=1 width=50% height=50%>"); 
             	out.println("<tr><th>Inv_id</th><th>Inv_type</th><tr>");
             	while (res.next()) 
                 {  
                       
                     String nm = res.getString("inv_id"); 
                     String nm1 = res.getString("inv_type");
                     out.println("<tr><td>" + nm + "</td><td>" + nm1 + "</td></tr>");   
                 }  
                 out.println("</table>");  
                 out.println("</html></body>"); 
                 break;
            case 6:
            	res = stmt.executeQuery("select * from o_detailsrel"); 
             	out.println("<table border=1 width=50% height=50%>"); 
             	out.println("<tr><th>order_id</th><th>orderd_id</th><tr>");
             	while (res.next()) 
                 {  
                       
                     String nm = res.getString("order_id"); 
                     String nm1 = res.getString("orderd_id");
                     out.println("<tr><td>" + nm + "</td><td>" + nm1 + "</td></tr>");   
                 }  
                 out.println("</table>");  
                 out.println("</html></body>"); 
                 break;
          /*  case 7:
            	res = stmt.executeQuery("select * from order_details"); 
               	out.println("<table border=1 width=50% height=50%>"); 
               	out.println("<tr><th>Orderd_id</th><th>price</th><th>quantity</th><th>date_of_purchase</th><tr>");
               	while (res.next()) 
                   {  
                        
                       String nm = res.getString("Orderd_id"); 
                       int nm1 = res.getInt("price");
                       int nm2 = res.getInt("quantity");
                       String nm3 = res.getString("date_of_purchase");
     
                       out.println("<tr><td>" + nm + "</td><td>" + nm1 + "</td><td>" + nm2 + "</td><td>" + nm3 + "</td></tr>");   
                   }  
                   out.println("</table>");  
                   out.println("</html></body>"); 
                   break;*/
            case 7:
            	res = stmt.executeQuery("select * from orderst"); 
             	out.println("<table border=1 width=50% height=50%>"); 
             	out.println("<tr><th>Order_id</th><th>Cust_id</th><tr>");
             	while (res.next()) 
                 {  
                       
                     String nm = res.getString("Order_id"); 
                     String nm1 = res.getString("Cust_id");
                     out.println("<tr><td>" + nm + "</td><td>" + nm1 + "</td></tr>");   
                 }  
                 out.println("</table>");  
                 out.println("</html></body>"); 
                 break;
            case 8:
            	res = stmt.executeQuery("select * from product"); 
               	out.println("<table border=1 width=50% height=50%>"); 
               	out.println("<tr><th>Prod_id</th><th>prod_desc</th><th>prod_name</th><th>price</th><th>Inv_id</th><th>Catg_id</th><tr>");
               	while (res.next()) 
                   {  
                        
                       String nm = res.getString("Prod_id"); 
                       String nm1 = res.getString("prod_desc");
                       String nm2 = res.getString("prod_name");
                       int nm3 = res.getInt("price");
                       String nm4 = res.getString("Inv_id");
                       String nm5 = res.getString("Catg_id");
                       out.println("<tr><td>" + nm + "</td><td>" + nm1 + "</td><td>" + nm2 + "</td><td>" + nm3 + "</td><td>" + nm4 + "</td><td>" + nm5 + "</td></tr>");   
                   }  
                   out.println("</table>");  
                   out.println("</html></body>"); 
                   break;
          /*  case 10:
            	res = stmt.executeQuery("select * from shipment"); 
               	out.println("<table border=1 width=50% height=50%>"); 
               	out.println("<tr><th>Shipment_no</th><th>Shipment_date</th><th>Order_id</th><tr>");
               	while (res.next()) 
                   {  
                        
                       int nm = res.getInt("Shipment_no"); 
                       String nm1 = res.getString("Shipment_date");
                       String nm2 = res.getString("Order_id");
                       
     
                       out.println("<tr><td>" + nm + "</td><td>" + nm1 + "</td><td>" + nm2 + "</td></tr>");   
                   }  
                   out.println("</table>");  
                   out.println("</html></body>"); 
                   break;*/
            case 9:
            	res = stmt.executeQuery("select * from staff"); 
               	out.println("<table border=1 width=50% height=50%>"); 
               	out.println("<tr><th>Staff_id</th><th>Fname</th><th>Mname</th><th>Lname</th><th>inv_id</th><th>Super_id</th><tr>");
               	while (res.next()) 
                   {  
                        
                       String nm = res.getString("Staff_id"); 
                       String nm1 = res.getString("F_name");
                       String nm2 = res.getString("M_name");
                       String nm3 = res.getString("L_name");
                       String nm4 = res.getString("inv_id");
                       String nm5 = res.getString("Super_id");
                       out.println("<tr><td>" + nm + "</td><td>" + nm1 + "</td><td>" + nm2 + "</td><td>" + nm3 + "</td><td>" + nm4 + "</td><td>" + nm5 + "</td></tr>");   
                   }  
                   out.println("</table>");  
                   out.println("</html></body>"); 
                   break;
            case 10:
            	res = stmt.executeQuery("select * from supp_contacts"); 
            	out.println("<table border=1 width=50% height=50%>"); 
            	out.println("<tr><th>scontacts</th><th>Supplier_id</th><tr>");
            	while (res.next()) 
                {  
                    int n = res.getInt("scontacts");  
                    String nm = res.getString("Supplier_id");  
                    out.println("<tr><td>" + n + "</td><td>" + nm + "</td></tr>");   
                }  
                out.println("</table>");  
                out.println("</html></body>"); 
                break;
            case 11:
            	res = stmt.executeQuery("select * from supplier"); 
               	out.println("<table border=1 width=50% height=50%>"); 
               	out.println("<tr><th>Supp_id</th><th>Supp_name</th><th>Supplier_type</th><th>Manufacturer_type</th><th>Importer_type</th><th>Wholsaler_type</th><tr>");
               	while (res.next()) 
                   {  
                        
                       String nm = res.getString("Supp_id"); 
                       String nm1 = res.getString("Supp_name");
                       String nm2 = res.getString("Supplier_type");
                       String nm3 = res.getString("Manufacturer_type");
                       String nm4 = res.getString("Importer_type");
                       String nm5 = res.getString("Wholsaler_type");
                       out.println("<tr><td>" + nm + "</td><td>" + nm1 + "</td><td>" + nm2 + "</td><td>" + nm3 + "</td><td>" + nm4 + "</td><td>" + nm5 + "</td></tr>");   
                   }  
                   out.println("</table>");  
                   out.println("</html></body>"); 
                   break;
            case 12:
            	res = stmt.executeQuery("select * from supplyrel"); 
             	out.println("<table border=1 width=50% height=50%>"); 
             	out.println("<tr><th>Prod_id</th><th>Supplier_id</th><tr>");
             	while (res.next()) 
                 {  
                       
                     String nm = res.getString("Prod_id"); 
                     String nm1 = res.getString("Supplier_id");
                     out.println("<tr><td>" + nm + "</td><td>" + nm1 + "</td></tr>");   
                 }  
                 out.println("</table>");  
                 out.println("</html></body>"); 
                 break;
           /* case 15:
            	res = stmt.executeQuery("select * from warranty"); 
               	out.println("<table border=1 width=50% height=50%>"); 
               	out.println("<tr><th>Warranty_id</th><th>validity</th><th>Prod_id</th><tr>");
               	while (res.next()) 
                   {  
                        
                       String nm = res.getString("Warranty_id"); 
                       String nm1 = res.getString("validity");
                       String nm2 = res.getString("Prod_id");
                       
     
                       out.println("<tr><td>" + nm + "</td><td>" + nm1 + "</td><td>" + nm2 + "</td></tr>");   
                   }  
                   out.println("</table>");  
                   out.println("</html></body>"); 
                   break;*/
            }
            
            
  
            // For the first parameter,
            // get the data using request object
            // sets the data to st pointer
            
            
  
     
          //  st.executeQuery();
  
            // Close all the connections
           // st.close();
            con.close();
  
            // Get a writer pointer 
            // to display the successful result
           
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
