package com.rmgyantra.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class AddProjectInDataBase 
{

	 public static void main(String[] args) throws Throwable
	 {
		 Connection connect=null;
		 try {
			 Driver driver = new Driver();	      
		       DriverManager.registerDriver(driver);
		       connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		         Statement statement = connect.createStatement();
		int res=statement.executeUpdate("insert into project (project_id ,created_by ,created_on ,project_name, status,team_size) value ('TY_PROJ_007','Adarsh Deepak','16/12/2021','Bharath','Completed',5)");
		    String excpectedName="Bharath Vepanjeri";
		    
		    
		                           ResultSet result = statement.executeQuery("select * from project");
		                           while(result.next()) 
		                           {
		                           if(result.getString(4).equals(excpectedName))
		                           {
		                        	   System.out.println("Pass:data is present");
		                           }
		                           }     
			
		       } 
		 finally 
		    {
			connect.close();		
			}            
	}
	
	 
	
	
	
	
	
	
	
	
}
