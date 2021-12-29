package com.crm.autodesk.genericLibrary;


import java.util.Date;
import java.util.Random;

/**
 * Class which has all java utilities method
 * @author Bharath Vepanjeri
 *
 */
public class JavaUtility
{
  
	
	/**
	 * It is used to generate random numbers
	 * @return Returns random number in integer form
	 */
	public int getRandomNum()
	{       
		Random rand=new Random();
		int randNum=rand.nextInt(10000);
		return randNum;
	}
	
	
	/**
	 * It return system date and time in IST format
	 * @return
	 */
	public String getSystemDateAndTime()
	{
		Date date=new Date();
	   return date.toString();
		
	}
	
	/**
	 * It is used to get system date with YYYY-MM-DD format
	 * @return It return date in string form
	 */
	public String getSystemDateWithFormat()
	{
		Date date=new Date();
		 String dateAndTime = date.toString();
		 System.out.println(dateAndTime);
		  
		 String YYYY=dateAndTime.split(" ")[5];
		 String MM=dateAndTime.split(" ")[2];
		 int DD=date.getMonth()+1;
		 
		 String finalDateWithFormat=YYYY+"-"+MM+"-"+DD;
			return 	 finalDateWithFormat;
	}
	
	
}
