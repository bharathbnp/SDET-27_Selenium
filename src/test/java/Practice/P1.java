package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.mysql.cj.jdbc.Driver;

public class P1
{
    public static void main(String[] args) throws SQLException
    {
	    
    	Date date=new Date();
		 String dateAndTime = date.toString();
		 System.out.println(dateAndTime);
		  
		 String YYYY=dateAndTime.split(" ")[5];
		 String MM=dateAndTime.split(" ")[2];
		 int DD=date.getMonth()+1;
		 
		 String finalDateWithFormat=YYYY+"-"+MM+"-"+DD;
		System.out.println(finalDateWithFormat);
	}



}
