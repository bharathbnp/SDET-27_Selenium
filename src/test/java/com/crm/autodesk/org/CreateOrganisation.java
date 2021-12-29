package com.crm.autodesk.org;

import java.io.FileInputStream;
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
import org.openqa.selenium.interactions.Actions;

import com.crm.autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.autodesk.ObjectRepository.OrganizationPage;
import com.crm.autodesk.genericLibrary.ExcelUtility;
import com.crm.autodesk.genericLibrary.FileUtility;
import com.crm.autodesk.genericLibrary.JavaUtility;
import com.crm.autodesk.genericLibrary.WebDriverUtility;

public class CreateOrganisation 
{

	public static void main(String[] args) throws Exception 
	{
		
		WebDriver driver ;
		
		 /*
         * Create Object of genericLib
         */
	 
	    ExcelUtility eLib=new ExcelUtility();
	    FileUtility  fLib=new FileUtility();
	    JavaUtility  jLib=new JavaUtility();
	    WebDriverUtility wLib=new WebDriverUtility();
		
		//read data from property file
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		
	         String browser=fLib.getPropertyKeyValue("browser");
	         String url=fLib.getPropertyKeyValue("url");
	         String username=fLib.getPropertyKeyValue("username");
	         String passcode=fLib.getPropertyKeyValue("password");
	  		
	         int randNum=jLib.getRandomNum();
	         String orgName=eLib.getDataFromExcel("Sheet1", 1, 0)+randNum;
			
	         
	         
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
		 cop.createOrganization(orgName);
		 
		 
		 //verification
		 OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		   String ActualOrgName = oip.getOrgHeaderTxt();
		 
		   if(ActualOrgName.contains(orgName))
		   {
			   System.out.println(orgName);
			   System.out.println("Organization is created successfully");
		   }
		  
		   
		 //logout  	
		hp.signOut(driver);
		driver.quit();
		
}
}