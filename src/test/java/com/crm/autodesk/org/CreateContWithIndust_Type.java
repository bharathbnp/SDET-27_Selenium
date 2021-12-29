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

import com.crm.autodesk.genericLibrary.ExcelUtility;
import com.crm.autodesk.genericLibrary.FileUtility;
import com.crm.autodesk.genericLibrary.JavaUtility;
import com.crm.autodesk.genericLibrary.WebDriverUtility;

public class CreateContWithIndust_Type 
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
		
		//login
		driver.manage().window().maximize();
		wLib.waitForPageToLoad(driver);
		driver.get(url);
		
		
		 
		 
		//create organisation
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(passcode);
		driver.findElement(By.id("submitButton")).click();
        driver.findElement(By.xpath("//a[text()='Organizations']")).click();
        driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
        driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
        wLib.select(driver.findElement(By.xpath("//select[@name='industry']")), indName);
        wLib.select(driver.findElement(By.xpath("//select[@name='accounttype']")),typeName);
	       
     //verification
       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        if(driver.findElement(By.id("mouseArea_Industry")).getText().equals(indName) &&  driver.findElement(By.id("mouseArea_Type")).getText().equals(typeName))
        {
        	System.out.println("Pass: Both industry and type is correct");
        }
 
        
        
        //logout
        wLib.mouseOverOnElement(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
        driver.findElement(By.xpath("//a[text()='Sign Out']")).click();		
        driver.quit();        	
	}
}