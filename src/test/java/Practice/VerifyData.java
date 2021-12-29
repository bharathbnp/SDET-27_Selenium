package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VerifyData 
{
     public static void main(String[] args) throws Throwable 
     {
	Connection connect=null;
    	String expectedData="mahatma";
    	 try {
    		// Register the database
    	     Driver driver = new Driver();
    	     DriverManager.registerDriver(driver);
    	
         	//Establish the connection with database
    	    connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
    	     
    	     
    	     //Issue the statement
    	     Statement statement = connect.createStatement();
    	     
    	     //Execute Queries
    	     ResultSet data = statement.executeQuery("select * from studentinfo");
    	     
    	     while(data.next())
    	     {
    	    	 if(data.getString(2).equals(expectedData)) 
    	    	 {
    	    	 System.out.println("Pass: Data is present");	 
    	    	 }
    	     }
			
		} catch (Exception e) {
			e.getStackTrace();
		}
    	 finally
    	 {
    		connect.close();
    	 }
    	
   	}
}
