package com.rmgyantra.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataIntoDataBase 
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
            Statement statement = connect.createStatement();

            //Write queries
int result=statement.executeUpdate("insert into studentinfo(fname,lname,address) value ('bharath','nayak','odisha')");
if(result==1)
{
	  System.out.println("Pass: Success");
}

		} finally {
			  connect.close();
		}
	// close the connection

   }
}
