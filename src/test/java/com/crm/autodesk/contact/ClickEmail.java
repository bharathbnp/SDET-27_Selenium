package com.crm.autodesk.contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.genericLibrary.ExcelUtility;
import com.crm.autodesk.genericLibrary.FileUtility;
import com.crm.autodesk.genericLibrary.JavaUtility;
import com.crm.autodesk.genericLibrary.WebDriverUtility;

public class ClickEmail {

	public static void main(String[] args) throws IOException 
	{
		   
		 /*
         * Create Object of genericLib
         */
	 
	    ExcelUtility eLib=new ExcelUtility();
	    FileUtility  fLib=new FileUtility();
	    JavaUtility  jLib=new JavaUtility();
	 WebDriverUtility wLib=new WebDriverUtility();
		
		
		
		
	 System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver=null;
		 String browser=fLib.getPropertyKeyValue("browser");
         String url=fLib.getPropertyKeyValue("url");
         String username=fLib.getPropertyKeyValue("username");
         String passcode=fLib.getPropertyKeyValue("password");
		 
		 if(browser.equals("chrome"))
		 {
			 driver=new ChromeDriver();
		 }
		 
		 else if(browser.equals("firefox"))
		 {
		 driver=new FirefoxDriver();
		 }
		 else
		 {
	           driver=new InternetExplorerDriver();	 
		 }
		 

	    //login
		 driver.manage().window().maximize();
		 wLib.waitForPageToLoad(driver);
		 driver.get(url);
		    
		 LoginPage lp=new LoginPage(driver);
		 lp.login(username, passcode);
		 CreateContactPage ccp=new CreateContactPage(driver);
		 ccp.clickOnEmail(driver);
		 
		 //click on email
		 driver.findElement(By.id("8")).click();
		wLib.mouseOverOnElement(driver,driver.findElement(By.xpath("//input[@value='Send Mail']")));
		driver.findElement(By.xpath("//input[@value='Send Mail']")).click();
	    driver.findElement(By.xpath("//input[@value='83']")).click();
    	wLib.mouseOverOnElement(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));		   
	        HomePage hp=new HomePage(driver);
	        hp.signOut(driver);
	}

}
