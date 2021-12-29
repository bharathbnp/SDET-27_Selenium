package com.crm.autodesk.org;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.autodesk.ObjectRepository.OrganizationPage;
import com.crm.autodesk.genericLibrary.ExcelUtility;
import com.crm.autodesk.genericLibrary.FileUtility;
import com.crm.autodesk.genericLibrary.JavaUtility;
import com.crm.autodesk.genericLibrary.WebDriverUtility;

public class CreateOrgWithIndust_Type 
{

	public static void main(String[] args) throws Exception 
	{
		
		
		 /*
         * Create Object of genericLib
         */
	 
	    ExcelUtility eLib=new ExcelUtility();
	    FileUtility  fLib=new FileUtility();
	    JavaUtility  jLib=new JavaUtility();
	 WebDriverUtility wLib=new WebDriverUtility();
		
		
		
               WebDriver driver ;
		
		    //read data from property file
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		 String browser=fLib.getPropertyKeyValue("browser");
         String url=fLib.getPropertyKeyValue("url");
         String username=fLib.getPropertyKeyValue("username");
         String passcode=fLib.getPropertyKeyValue("password");
         
               //read data from excel	
			      int randNum=jLib.getRandomNum();
			     String orgName=eLib.getDataFromExcel("Sheet1",1,0)+randNum;
	              String indName=eLib.getDataFromExcel("Sheet1",1,2);
	          	 String typeName=eLib.getDataFromExcel("Sheet1",1,3);
	         	         
	         
	         
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		
		else if(browser.equals("firefox"))		
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equals("internetexplorer"))
		{
			driver =new InternetExplorerDriver();
		}
		else
		{
			driver=new ChromeDriver();
			
		}
		
		//launch browser
				driver.manage().window().maximize();
				wLib.waitForPageToLoad(driver);
				driver.get(url);
				
				//login
				LoginPage lp=new LoginPage(driver);
				lp.login(username,passcode);
				
			
				//create organisation
				HomePage hp=new HomePage(driver);
		        hp.clickOnOrganizationModule();
		         
		        OrganizationPage op=new OrganizationPage(driver);
		        op.clickOnCreateOrg();
		        
		        CreateOrganizationPage cop=new CreateOrganizationPage(driver);
				 cop.createOrganizationWithInd_Type(orgName, indName, typeName);
        
	       
     //verification
				 OrganizationInfoPage oip=new OrganizationInfoPage(driver);
				 
       
        if(oip.getIndTxt().equals(indName))
        {
        	System.out.println("Pass:Industry is correctly selected");
        }
        else
        {
        	System.out.println("Fail:Industry is not selected");
        }
        
        if(oip.getTypeTxt().equals(typeName))
        {
        	System.out.println("Pass:Type is correctly selected");
        }
        else
        {
        	System.out.println("Fail:Type is not selected");
        }
        //logout
        hp.signOut(driver);
        driver.quit();        	
	}
}