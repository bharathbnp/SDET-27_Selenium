package com.crm.autodesk.contact;

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

import com.crm.autodesk.ObjectRepository.ContactInfoPage;
import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.genericLibrary.ExcelUtility;
import com.crm.autodesk.genericLibrary.FileUtility;
import com.crm.autodesk.genericLibrary.JavaUtility;
import com.crm.autodesk.genericLibrary.WebDriverUtility;

public class CreateContact 
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
		 
			System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");

		 WebDriver driver;
		 String browser=fLib.getPropertyKeyValue("browser");
         String url=fLib.getPropertyKeyValue("url");
         String username=fLib.getPropertyKeyValue("username");
         String passcode=fLib.getPropertyKeyValue("password");
         
        
		 int randNum=jLib.getRandomNum();
		 String lastname=eLib.getDataFromExcel("Sheet1",1,1)+randNum;
		
		
		 
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
			lp.login(username,passcode);
			
		 HomePage hp=new HomePage(driver);
	        hp.clickOnContactsModule();
		

		//create contact
	        ContactsPage cp=new ContactsPage(driver);
	        cp.clickOnCreateContact();
	        
	        CreateContactPage ccp=new CreateContactPage(driver);
	        ccp.createContact(lastname);
	        
	      //verification
	        ContactInfoPage cip=new ContactInfoPage(driver);
	        String Actua_Contact = cip.getContHeaderTxt();
			 if(Actua_Contact.contains(lastname))
			 {
				 System.out.println("Pass:Data is present");
			 }
			 else
			 {
			 System.err.println("Fail:data is not present");
			 }
	        
			//logout
			  hp.signOut(driver);	 
		driver.quit(); 
	 }	
	
}
