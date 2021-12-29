package com.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider2Test 
{

	
	@Test(dataProvider = "getData")
	public void dataProviderTest(String name,String hero,String director)
	{
		
		System.out.println("Movie Name: "+name+" Lead: "+hero+" Director: "+director);
	}
	
	@DataProvider
	public Object[][] getData()
	{
        
		Object[][] objArr=new Object[5][3];
		
		
		objArr[0][0]="Pushpa";
	    objArr[0][1]="Allu Arjun";
	    objArr[0][2]="Sukumar";
	    
	    objArr[1][0]="Radhe Shyam";
	    objArr[1][1]="Prabhas";
        objArr[1][2]="Radha Krishna Kumar";
		
        objArr[2][0]="RRR";
	    objArr[2][1]="RC+NTR";
        objArr[2][2]="Rajamouli";	
		
         objArr[3][0]="Shyam Singha Roy";
		 objArr[3][1]="Nani";
         objArr[3][2]="Rahul";	 
		
       objArr[4][0]="Bheemla";
	   objArr[4][1]="PK";
       objArr[4][2]="Sagar";
		return objArr;
	}
	
}
