package com.rmgyantra.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class GetTheDataFromDataBase 
{

	public static void main(String[] args) throws Throwable 
	{
		
		 Connection connect=null;
		 try {
			// Register the database
		     Driver driver = new Driver();
		     DriverManager.registerDriver(driver);
		
	     	//Establish the connection with database
		      connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		     
		   
		     //Issue the statement
		     Statement statement = connect.createStatement();//implementation provided by mysql
		     
		     //Execute Queries
		     ResultSet data = statement.executeQuery("select * from studentinfo");
		     
		     while(data.next())
		     {
		    	 System.out.println(data.getString(1)+"\t"+data.getString(2)+"\t"+data.getString(3)+"\t"+data.getString(4));
		     }

		} finally {
			connect.close();
		}
		    
		     //close the database
		 
	}

}
