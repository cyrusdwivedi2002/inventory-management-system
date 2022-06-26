package com.Inventory;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.io.FileWriter;
import java.sql.*;
  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
// Import Database Connection Class file
import code.DatabaseConnection;
  

@WebServlet("/ExportTable")
public class ExportServlet extends HttpServlet {
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
           
            		ResultSet res = null;
            int ch = Integer.valueOf(request.getParameter("table_name"));
            // Create a SQL query to insert data into demo table
            // demo table consists of two columns, so two '?' is used
            switch( ch) {
            case 1: 
            	String filename = "C:\\csvfiles\\Category.csv";
            	 FileWriter fw = new FileWriter(filename);
            	 res = stmt.executeQuery("select * from category"); 
            	  fw.append("Catg_id");
            	  fw.append(',');
            	  fw.append("catg_name");
            	  fw.append('\n');
            	while (res.next()) 
                {  
            		 fw.append(res.getString(1));
            		  fw.append(',');
            		  fw.append(res.getString(2));
            		  fw.append('\n');
                    
                      
                }  
            	out.println
            	   ("<b>You are Successfully Created Csv file.</b>");
            	 fw.flush();
             	  fw.close();
                break;
            case 2: 
            	String filename1 = "C:\\csvfiles\\cust_mobile.csv";
           	 FileWriter fw1 = new FileWriter(filename1);
            	 res = stmt.executeQuery("select * from cust_mobileno"); 
            	 fw1.append("cmobile_no");
           	  fw1.append(',');
           	  fw1.append("Cust_id");
           	  fw1.append('\n');
           	while (res.next()) 
               {  
           		 fw1.append(res.getString(1));
           		  fw1.append(',');
           		  fw1.append(res.getString(2));
           		  fw1.append('\n');
                   
                     
               }  
           	out.println
           	   ("<b>You are Successfully Created Csv file.</b>");
           	 fw1.flush();
           	  fw1.close();
               break;
            case 3: 
            	 filename1 = "C:\\csvfiles\\customer.csv";
              	  fw1 = new FileWriter(filename1);
               	 res = stmt.executeQuery("select * from customer"); 
               	 fw1.append("cust_id");
              	  fw1.append(',');
              	  fw1.append("cF_name");
              	fw1.append(',');
            	  fw1.append("cM_name");
            	  fw1.append(',');
              	  fw1.append("cL_name");
              	fw1.append(',');
            	  fw1.append("address");
            	  fw1.append(',');
              	  fw1.append("Staff_id");
              	  fw1.append('\n');
              	while (res.next()) 
                  {  
              		 fw1.append(res.getString(1));
              		  fw1.append(',');
              		  fw1.append(res.getString(2));
              		fw1.append(',');
            		  fw1.append(res.getString(3));
            		  fw1.append(',');
              		  fw1.append(res.getString(4));
              		fw1.append(',');
            		  fw1.append(res.getString(5));
            		  fw1.append(',');
              		  fw1.append(res.getString(6));
              		  fw1.append('\n');
                      
                        
                  }  
              	out.println
              	   ("<b>You are Successfully Created Csv file.</b>");
              	 fw1.flush();
              	  fw1.close();
              	  break;
            case 4:
            	filename1 = "C:\\csvfiles\\dependent.csv";
            	  fw1 = new FileWriter(filename1);
             	 res = stmt.executeQuery("select * from dependent"); 
             	 fw1.append("staff_id");
            	  fw1.append(',');
            	  fw1.append("name");
            	fw1.append(',');
          	  fw1.append("Sex");
          	  fw1.append(',');
            	  fw1.append("Relationship");
            	
            	  fw1.append('\n');
            	while (res.next()) 
                {  
            		 fw1.append(res.getString(1));
            		  fw1.append(',');
            		  fw1.append(res.getString(2));
            		fw1.append(',');
          		  fw1.append(res.getString(3));
          		  fw1.append(',');
            		  fw1.append(res.getString(4));
            		
            		  fw1.append('\n');
                    
                      
                }  
            	out.println
            	   ("<b>You are Successfully Created Csv file.</b>");
            	 fw1.flush();
            	  fw1.close();
            	  break;
            case 5:
            	filename1 = "C:\\csvfiles\\inventory.csv";
              	 fw1 = new FileWriter(filename1);
               	 res = stmt.executeQuery("select * from inventory"); 
               	 fw1.append("inv_id");
              	  fw1.append(',');
              	  fw1.append("inv_type");
              	  fw1.append('\n');
              	while (res.next()) 
                  {  
              		 fw1.append(res.getString(1));
              		  fw1.append(',');
              		  fw1.append(res.getString(2));
              		  fw1.append('\n');
                      
                        
                  }  
              	out.println
              	   ("<b>You are Successfully Created Csv file.</b>");
              	 fw1.flush();
              	  fw1.close();
                  break;
            case 6:
            	filename1 = "C:\\csvfiles\\o_detailsrel.csv";
             	 fw1 = new FileWriter(filename1);
              	 res = stmt.executeQuery("select * from o_detailsrel"); 
              	 fw1.append("order_id");
             	  fw1.append(',');
             	  fw1.append("orderd_id");
             	  fw1.append('\n');
             	while (res.next()) 
                 {  
             		 fw1.append(res.getString(1));
             		  fw1.append(',');
             		  fw1.append(res.getString(2));
             		  fw1.append('\n');
                     
                       
                 }  
             	out.println
             	   ("<b>You are Successfully Created Csv file.</b>");
             	 fw1.flush();
             	  fw1.close();
                 break;
            case 7:
            	filename1 = "C:\\csvfiles\\order_details.csv";
          	  fw1 = new FileWriter(filename1);
           	 res = stmt.executeQuery("select * from order_details"); 
           	 fw1.append("Orderd_id");
          	  fw1.append(',');
          	  fw1.append("price");
          	fw1.append(',');
        	  fw1.append("Quantity");
        	  fw1.append(',');
          	  fw1.append("Date_of_purc");
          	
          	  fw1.append('\n');
          	while (res.next()) 
              {  
          		 fw1.append(res.getString(1));
          		  fw1.append(',');
          		  fw1.append(res.getString(2));
          		fw1.append(',');
        		  fw1.append(res.getString(3));
        		  fw1.append(',');
          		  fw1.append(res.getString(4));
          		
          		  fw1.append('\n');
                  
                    
              }  
          	out.println
          	   ("<b>You are Successfully Created Csv file.</b>");
          	 fw1.flush();
          	  fw1.close();
          	  break;
            case 8:
            	filename1 = "C:\\csvfiles\\orderst.csv";
            	 fw1 = new FileWriter(filename1);
             	 res = stmt.executeQuery("select * from orderst"); 
             	 fw1.append("order_id");
            	  fw1.append(',');
            	  fw1.append("Cust_id");
            	  fw1.append('\n');
            	while (res.next()) 
                {  
            		 fw1.append(res.getString(1));
            		  fw1.append(',');
            		  fw1.append(res.getString(2));
            		  fw1.append('\n');
                    
                      
                }  
            	out.println
            	   ("<b>You are Successfully Created Csv file.</b>");
            	 fw1.flush();
            	  fw1.close();
                break;
            case 9:
            	filename1 = "C:\\csvfiles\\product.csv";
            	  fw1 = new FileWriter(filename1);
             	 res = stmt.executeQuery("select * from product"); 
             	 fw1.append("Prod_id");
            	  fw1.append(',');
            	  fw1.append("prod_desc");
            	fw1.append(',');
          	  fw1.append("prod_name");
          	  fw1.append(',');
            	  fw1.append("price");
            	fw1.append(',');
          	  fw1.append("inv_id");
          	  fw1.append(',');
            	  fw1.append("catg_id");
            	  fw1.append('\n');
            	while (res.next()) 
                {  
            		 fw1.append(res.getString(1));
            		  fw1.append(',');
            		  fw1.append(res.getString(2));
            		fw1.append(',');
          		  fw1.append(res.getString(3));
          		  fw1.append(',');
            		  fw1.append(res.getString(4));
            		fw1.append(',');
          		  fw1.append(res.getString(5));
          		  fw1.append(',');
            		  fw1.append(res.getString(6));
            		  fw1.append('\n');
                    
                      
                }  
            	out.println
            	   ("<b>You are Successfully Created Csv file.</b>");
            	 fw1.flush();
            	  fw1.close();
            	  break;
            case 10:
            	filename1 = "C:\\csvfiles\\shipment.csv";
            	  fw1 = new FileWriter(filename1);
             	 res = stmt.executeQuery("select * from shipment"); 
             	 fw1.append("Shipment_no");
            	  fw1.append(',');
            	  fw1.append("shipment_date");
            	fw1.append(',');
          	  fw1.append("Order_id");
          	  
            	
            	  fw1.append('\n');
            	while (res.next()) 
                {  
            		 fw1.append(res.getString(1));
            		  fw1.append(',');
            		  fw1.append(res.getString(2));
            		fw1.append(',');
          		  fw1.append(res.getString(3));
          		  
            
            		  fw1.append('\n');
                    
                      
                }  
            	out.println
            	   ("<b>You are Successfully Created Csv file.</b>");
            	 fw1.flush();
            	  fw1.close();
            	  break;
            case 11:
            	filename1 = "C:\\csvfiles\\Staff.csv";
          	  fw1 = new FileWriter(filename1);
           	 res = stmt.executeQuery("select * from staff"); 
           	 fw1.append("Staff_id");
          	  fw1.append(',');
          	  fw1.append("F_name");
          	fw1.append(',');
        	  fw1.append("M_name");
        	  fw1.append(',');
          	  fw1.append("L_name");
          	fw1.append(',');
        	  fw1.append("inv_id");
        	  fw1.append(',');
          	  fw1.append("Super_id");
          	  fw1.append('\n');
          	while (res.next()) 
              {  
          		 fw1.append(res.getString(1));
          		  fw1.append(',');
          		  fw1.append(res.getString(2));
          		fw1.append(',');
        		  fw1.append(res.getString(3));
        		  fw1.append(',');
          		  fw1.append(res.getString(4));
          		fw1.append(',');
        		  fw1.append(res.getString(5));
        		  fw1.append(',');
          		  fw1.append(res.getString(6));
          		  fw1.append('\n');
                  
                    
              }  
          	out.println
          	   ("<b>You are Successfully Created Csv file.</b>");
          	 fw1.flush();
          	  fw1.close();
          	  break;
            case 12:
            	filename1 = "C:\\csvfiles\\supp_contacts.csv";
           	 fw1 = new FileWriter(filename1);
            	 res = stmt.executeQuery("select * from supp_contacts"); 
            	 fw1.append("scontacts");
           	  fw1.append(',');
           	  fw1.append("Supplier_id");
           	  fw1.append('\n');
           	while (res.next()) 
               {  
           		 fw1.append(res.getString(1));
           		  fw1.append(',');
           		  fw1.append(res.getString(2));
           		  fw1.append('\n');
                   
                     
               }  
           	out.println
           	   ("<b>You are Successfully Created Csv file.</b>");
           	 fw1.flush();
           	  fw1.close();
               break;
             
            case 13:
            	filename1 = "C:\\csvfiles\\Supplier.csv";
            	  fw1 = new FileWriter(filename1);
             	 res = stmt.executeQuery("select * from supplier"); 
             	 fw1.append("Supp_id");
            	  fw1.append(',');
            	  fw1.append("Supp_name");
            	fw1.append(',');
          	  fw1.append("Supplier_type");
          	  fw1.append(',');
            	  fw1.append("Manufacturer_type");
            	fw1.append(',');
          	  fw1.append("Importer_type");
          	  fw1.append(',');
            	  fw1.append("Wholsaler_type");
            	  fw1.append('\n');
            	while (res.next()) 
                {  
            		 fw1.append(res.getString(1));
            		  fw1.append(',');
            		  fw1.append(res.getString(2));
            		fw1.append(',');
          		  fw1.append(res.getString(3));
          		  fw1.append(',');
            		  fw1.append(res.getString(4));
            		fw1.append(',');
          		  fw1.append(res.getString(5));
          		  fw1.append(',');
            		  fw1.append(res.getString(6));
            		  fw1.append('\n');
                    
                      
                }  
            	out.println
            	   ("<b>You are Successfully Created Csv file.</b>");
            	 fw1.flush();
            	  fw1.close();
            	  break;
            case 14:
            	filename1 = "C:\\csvfiles\\supplyrel.csv";
              	 fw1 = new FileWriter(filename1);
               	 res = stmt.executeQuery("select * from supplyrel"); 
               	 fw1.append("Prod_id");
              	  fw1.append(',');
              	  fw1.append("Supplier_id");
              	  fw1.append('\n');
              	while (res.next()) 
                  {  
              		 fw1.append(res.getString(1));
              		  fw1.append(',');
              		  fw1.append(res.getString(2));
              		  fw1.append('\n');
                      
                        
                  }  
              	out.println
              	   ("<b>You are Successfully Created Csv file.</b>");
              	 fw1.flush();
              	  fw1.close();
                  break;
            case 15:
            	filename1 = "C:\\csvfiles\\warranty.csv";
             	 fw1 = new FileWriter(filename1);
              	 res = stmt.executeQuery("select * from warranty"); 
              	 fw1.append("Warranty_id");
             	  fw1.append(',');
             	  fw1.append("Validity");
             	 fw1.append(',');
            	  fw1.append("Prod_id");
             	  fw1.append('\n');
             	while (res.next()) 
                 {  
             		 fw1.append(res.getString(1));
             		  fw1.append(',');
             		  fw1.append(res.getString(2));
             		 fw1.append(',');
            		  fw1.append(res.getString(3));
             		  fw1.append('\n');
                     
                       
                 }  
             	out.println
             	   ("<b>You are Successfully Created Csv file.</b>");
             	 fw1.flush();
             	  fw1.close();
                 break;
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

