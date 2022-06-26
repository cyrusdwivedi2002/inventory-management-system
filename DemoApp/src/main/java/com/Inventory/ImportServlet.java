package com.Inventory;


import java.io.IOException;
//import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileWriter;
//import java.sql.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.PreparedStatement;
  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
// Import Database Connection Class file
import code.DatabaseConnection;
  

@WebServlet("/ImportTable")
public class ImportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
  
    protected void doPost(HttpServletRequest request, 
HttpServletResponse response)
        throws ServletException, IOException
        
    {
    	
        try {
        	PrintWriter out = response.getWriter();
        	
        	
        	  
            // Initialize the database
            Connection con = DatabaseConnection.initializeDatabase();
          //  Statement stmt = con.createStatement();
           
            		//ResultSet res = null;
            int ch = Integer.valueOf(request.getParameter("table_name"));
            // Create a SQL query to insert data into demo table
            // demo table consists of two columns, so two '?' is used
            String filename = request.getParameter("file_path");
            switch( ch) {
            case 1: 
            	
            	String sql="insert into category(catg_id,catg_name) values(?,?)";
            	PreparedStatement statement=con.prepareStatement(sql);
            	BufferedReader lineReader=new BufferedReader(new FileReader(filename));
            	String lineText=null;
            	lineReader.readLine();
                while ((lineText=lineReader.readLine())!=null){
                    String[] data=lineText.split(",");
                    String catg_id=data[0];
                    String catg_name=data[1];
                    
                    System.out.println(catg_id+ " "+ catg_name);
                    
                    statement.setString(1,catg_id);
                    statement.setString(2,catg_name);
                    
                    statement.executeUpdate();
                }
                    lineReader.close();
                    statement.executeBatch();
                    
            	out.println
            	   ("<b>You Successfully Imported.</b>");
            	 
                break;
            case 2: 
            	sql="insert into cust_mobileno(cmobile_no,Cust_id) values(?,?)";
            	statement=con.prepareStatement(sql);
            	lineReader=new BufferedReader(new FileReader(filename));
            	lineText=null;
            	lineReader.readLine();
                while ((lineText=lineReader.readLine())!=null){
                    String[] data=lineText.split(",");
                    String cmobile_no=data[0];
                    String Cust_id=data[1];
                    
                    //System.out.println(catg_id+ " "+ catg_name);
                    
                    statement.setString(1,cmobile_no);
                    statement.setString(2,Cust_id);
                    
                    statement.executeUpdate();
                }
                    lineReader.close();
                    statement.executeBatch();
                    
            	out.println
            	   ("<b>You Successfully Imported.</b>");
               break;
            case 3: 
            	sql="insert into customer(Cust_id,cF_name,cM_name,cL_name,address,Staff_id) values(?,?,?,?,?,?)";
            	statement=con.prepareStatement(sql);
            	lineReader=new BufferedReader(new FileReader(filename));
            	lineText=null;
            	lineReader.readLine();
                while ((lineText=lineReader.readLine())!=null){
                    String[] data=lineText.split(",");
                    String Cust_id=data[0];
                    String cF_name=data[1];
                    String cM_name=data[2];
                    String cL_name=data[3];
                    String address=data[4];
                    String Staff_id=data[5];
                    
                    
                    //System.out.println(catg_id+ " "+ catg_name);
                    
                    statement.setString(1,Cust_id);
                    statement.setString(2,cF_name);
                    statement.setString(3,cM_name);
                    statement.setString(4,cL_name);
                    statement.setString(5,address);
                    statement.setString(6,Staff_id);
                    
                    statement.executeUpdate();
                }
                    lineReader.close();
                    statement.executeBatch();
                    
            	out.println
            	   ("<b>You Successfully Imported.</b>");
              	  break;
            case 4:
            	sql="insert into dependent(Staff_id,Name,Sex,Relationship) values(?,?,?,?)";
            	statement=con.prepareStatement(sql);
            	lineReader=new BufferedReader(new FileReader(filename));
            	lineText=null;
            	lineReader.readLine();
                while ((lineText=lineReader.readLine())!=null){
                    String[] data=lineText.split(",");
                    String Staff_id=data[0];
                    String Name=data[1];
                    String Sex=data[2];
                    String Relationship=data[3];
                    
                    
                    
                    //System.out.println(catg_id+ " "+ catg_name);
                    
                    statement.setString(1,Staff_id);
                    statement.setString(2,Name);
                    statement.setString(3,Sex);
                    statement.setString(4,Relationship);
                    
                    
                    statement.executeUpdate();
                }
                    lineReader.close();
                    statement.executeBatch();
                    
            	out.println
            	   ("<b>You Successfully Imported.</b>");
            	  break;
            case 5:
            	sql="insert into inventory(inv_id,inv_type) values(?,?)";
            	statement=con.prepareStatement(sql);
            	lineReader=new BufferedReader(new FileReader(filename));
            	lineText=null;
            	lineReader.readLine();
                while ((lineText=lineReader.readLine())!=null){
                    String[] data=lineText.split(",");
                    String inv_id=data[0];
                    String inv_type=data[1];
                    
                    //System.out.println(catg_id+ " "+ catg_name);
                    
                    statement.setString(1,inv_id);
                    statement.setString(2,inv_type);
                    
                    statement.executeUpdate();
                }
                    lineReader.close();
                    statement.executeBatch();
                    
            	out.println
            	   ("<b>You Successfully Imported.</b>");
                  break;
            case 6:
            	sql="insert into o_detailsrel(order_id,Orderd_id) values(?,?)";
            	statement=con.prepareStatement(sql);
            	lineReader=new BufferedReader(new FileReader(filename));
            	lineText=null;
            	lineReader.readLine();
                while ((lineText=lineReader.readLine())!=null){
                    String[] data=lineText.split(",");
                    String order_id=data[0];
                    String Orderd_id=data[1];
                    
                    //System.out.println(catg_id+ " "+ catg_name);
                    
                    statement.setString(1,order_id);
                    statement.setString(2,Orderd_id);
                    
                    statement.executeUpdate();
                }
                    lineReader.close();
                    statement.executeBatch();
                    
            	out.println
            	   ("<b>You Successfully Imported.</b>");
                 break;
            case 7:
            	sql="insert into order_details(Orderd_id,price,quantity,date_of_purchase) values(?,?,?,?)";
            	statement=con.prepareStatement(sql);
            	lineReader=new BufferedReader(new FileReader(filename));
            	lineText=null;
            	lineReader.readLine();
                while ((lineText=lineReader.readLine())!=null){
                    String[] data=lineText.split(",");
                    String Orderd_id=data[0];
                    String price=data[1];
                    String quantity=data[2];
                    String date_of_purchase=data[3];
                    
                    
                    
                    //System.out.println(catg_id+ " "+ catg_name);
                    
                    statement.setString(1,Orderd_id);
                    statement.setString(2,price);
                    statement.setString(3,quantity);
                    statement.setString(4,date_of_purchase);
                    
                    
                    statement.executeUpdate();
                }
                    lineReader.close();
                    statement.executeBatch();
                    
            	out.println
            	   ("<b>You Successfully Imported.</b>");
          	  break;
            case 8:
            	sql="insert into orderst(Order_id,Cust_id) values(?,?)";
            	statement=con.prepareStatement(sql);
            	lineReader=new BufferedReader(new FileReader(filename));
            	lineText=null;
            	lineReader.readLine();
                while ((lineText=lineReader.readLine())!=null){
                    String[] data=lineText.split(",");
                    String Order_id=data[0];
                    String Cust_id=data[1];
                    
                    //System.out.println(catg_id+ " "+ catg_name);
                    
                    statement.setString(1,Order_id);
                    statement.setString(2,Cust_id);
                    
                    statement.executeUpdate();
                }
                    lineReader.close();
                    statement.executeBatch();
                    
            	out.println
            	   ("<b>You Successfully Imported.</b>");
                break;
            case 9:
            	sql="insert into product(Prod_id,prod_desc,prod_name,price,inv_id,Catg_id) values(?,?,?,?,?,?)";
            	statement=con.prepareStatement(sql);
            	lineReader=new BufferedReader(new FileReader(filename));
            	lineText=null;
            	lineReader.readLine();
                while ((lineText=lineReader.readLine())!=null){
                    String[] data=lineText.split(",");
                    String Prod_id=data[0];
                    String prod_desc=data[1];
                    String prod_name=data[2];
                    String price=data[3];
                    String inv_id=data[4];
                    String Catg_id=data[5];
                    
                    
                    //System.out.println(catg_id+ " "+ catg_name);
                    
                    statement.setString(1,Prod_id);
                    statement.setString(2,prod_desc);
                    statement.setString(3,prod_name);
                    statement.setString(4,price);
                    statement.setString(5,inv_id);
                    statement.setString(6,Catg_id);
                    
                    statement.executeUpdate();
                }
                    lineReader.close();
                    statement.executeBatch();
                    
            	out.println
            	   ("<b>You Successfully Imported.</b>");
            	  break;
            case 10:
            	sql="insert into shipment(Shipment_no,Shipment_date,Order_id) values(?,?,?,?,?,?)";
            	statement=con.prepareStatement(sql);
            	lineReader=new BufferedReader(new FileReader(filename));
            	lineText=null;
            	lineReader.readLine();
                while ((lineText=lineReader.readLine())!=null){
                    String[] data=lineText.split(",");
                    String Shipment_no=data[0];
                    String Shipment_date=data[1];
                    String Order_id=data[2];
                    
                    
                    
                    //System.out.println(catg_id+ " "+ catg_name);
                    
                    statement.setString(1,Shipment_no);
                    statement.setString(2,Shipment_date);
                    statement.setString(3,Order_id);
                    
                    
                    statement.executeUpdate();
                }
                    lineReader.close();
                    statement.executeBatch();
                    
            	out.println
            	   ("<b>You Successfully Imported.</b>");
            	  break;
            case 11:
            	sql="insert into Staff(Staff_id,F_name,M_name,L_name,inv_id,Super_id) values(?,?,?,?,?,?)";
            	statement=con.prepareStatement(sql);
            	lineReader=new BufferedReader(new FileReader(filename));
            	lineText=null;
            	lineReader.readLine();
                while ((lineText=lineReader.readLine())!=null){
                    String[] data=lineText.split(",");
                    String Staff_id=data[0];
                    String F_name=data[1];
                    String M_name=data[2];
                    String L_name=data[3];
                    String inv_id=data[4];
                    String Super_id=data[5];
                    
                    
                    //System.out.println(catg_id+ " "+ catg_name);
                    
                    statement.setString(1,Staff_id);
                    statement.setString(2,F_name);
                    statement.setString(3,M_name);
                    statement.setString(4,L_name);
                    statement.setString(5,inv_id);
                    statement.setString(6,Super_id);
                    
                    statement.executeUpdate();
                }
                    lineReader.close();
                    statement.executeBatch();
                    
            	out.println
            	   ("<b>You Successfully Imported.</b>");
          	  break;
            case 12:
            	sql="insert into supp_contacts(scontacts,Supplier_id) values(?,?)";
            	statement=con.prepareStatement(sql);
            	lineReader=new BufferedReader(new FileReader(filename));
            	lineText=null;
            	lineReader.readLine();
                while ((lineText=lineReader.readLine())!=null){
                    String[] data=lineText.split(",");
                    String scontacts=data[0];
                    String Supplier_id=data[1];
                   
                    
                    
                    //System.out.println(catg_id+ " "+ catg_name);
                    
                    statement.setString(1,scontacts);
                    statement.setString(2,Supplier_id);
                   
                    
                    statement.executeUpdate();
                }
                    lineReader.close();
                    statement.executeBatch();
                    
            	out.println
            	   ("<b>You Successfully Imported.</b>");
               break;
             
            case 13:
            	sql="insert into supplier(Supp_id,Supp_name,Supplier_type,Manufacturer_type,Importer_type,Wholsaler_type) values(?,?,?,?,?,?)";
            	statement=con.prepareStatement(sql);
            	lineReader=new BufferedReader(new FileReader(filename));
            	lineText=null;
            	lineReader.readLine();
                while ((lineText=lineReader.readLine())!=null){
                    String[] data=lineText.split(",");
                    String Supp_id=data[0];
                    String Supp_name=data[1];
                    String Supplier_type=data[2];
                    String Manufacturer_type=data[3];
                    String Importer_type=data[4];
                    String Wholsaler_type=data[5];
                    
                    
                    //System.out.println(catg_id+ " "+ catg_name);
                    
                    statement.setString(1,Supp_id);
                    statement.setString(2,Supp_name);
                    statement.setString(3,Supplier_type);
                    statement.setString(4,Manufacturer_type);
                    statement.setString(5,Importer_type);
                    statement.setString(6,Wholsaler_type);
                    
                    statement.executeUpdate();
                }
                    lineReader.close();
                    statement.executeBatch();
                    
            	out.println
            	   ("<b>You Successfully Imported.</b>");
            	  break;
            case 14:
            	sql="insert into supplyrel(Prod_id,Supplier_id) values(?,?)";
            	statement=con.prepareStatement(sql);
            	lineReader=new BufferedReader(new FileReader(filename));
            	lineText=null;
            	lineReader.readLine();
                while ((lineText=lineReader.readLine())!=null){
                    String[] data=lineText.split(",");
                    String Prod_id=data[0];
                    String Supplier_id=data[1];
                   
                    
                    
                    //System.out.println(catg_id+ " "+ catg_name);
                    
                    statement.setString(1,Prod_id);
                    statement.setString(2,Supplier_id);
                   
                    
                    statement.executeUpdate();
                }
                    lineReader.close();
                    statement.executeBatch();
                    
            	out.println
            	   ("<b>You Successfully Imported.</b>");
                  break;
            case 15:
            	sql="insert into warranty(Warranty_id,validity,Prod_id) values(?,?,?)";
            	statement=con.prepareStatement(sql);
            	lineReader=new BufferedReader(new FileReader(filename));
            	lineText=null;
            	lineReader.readLine();
                while ((lineText=lineReader.readLine())!=null){
                    String[] data=lineText.split(",");
                    String Warranty_id=data[0];
                    String validity=data[1];
                    String Prod_id=data[2];
                    
                    
                    //System.out.println(catg_id+ " "+ catg_name);
                    
                    statement.setString(1,Warranty_id);
                    statement.setString(2,validity);
                    statement.setString(3,Prod_id);
                   
                    
                    statement.executeUpdate();
                }
                    lineReader.close();
                    statement.executeBatch();
                    
            	out.println
            	   ("<b>You Successfully Imported.</b>");
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
        

    




