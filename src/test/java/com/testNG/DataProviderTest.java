package com.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest 
{

	
	@Test(dataProvider = "getData")
	public void dataProviderTest(String series,String platform)
	{
		System.out.println("Web Series :"+series+" "+"Platform : "+platform);
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr=new Object[3][2];
		
		objArr[0][0]="Game Of Thrones";
		objArr[0][1]="HBO";
		
		objArr[1][0]="Peaky Blinders";
	    objArr[1][1]="BBC";
	    
	    objArr[2][0]="Money Heist";
	    objArr[2][1]="Netflix";
	    
	    return objArr;
	}
}
