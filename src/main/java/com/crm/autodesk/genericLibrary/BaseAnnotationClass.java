package com.crm.autodesk.genericLibrary;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.comcast.objectrepositoryUtility.HomePage;
import com.crm.comcast.objectrepositoryUtility.Login;

public class BaseAnnotationClass {
    /* create object to libraries*/
	public FileUtility fLib = new FileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public ExcelUtility eLib = new ExcelUtility();
	//public DataBaseUtilities dLib = new DataBaseUtilities();
	public WebDriver driver = null;
	public static  WebDriver sdriver = null;
    
    @BeforeSuite
    public void config_BS() throws Throwable 
    {
    	System.out.println("===================Conntact to DB=================");
    	
    }
    
  //  @Parameters("BROWSER")
    @BeforeClass
    public void config_BC() throws Throwable {
		/* read common data from Properties File*/
		 String BROWSER = fLib.getPropertyKeyValue("browser");
    	
         /* launch the Browser */ 
	    	System.out.println("======launch the BROWSER===========");

         if(BROWSER.equals("chrome")) {
               driver = new ChromeDriver();
         }else if(BROWSER.equals("firefox")){
        	   driver = new FirefoxDriver();
         }else if(BROWSER.equals("ie")){
        	  driver = new InternetExplorerDriver();
        }else {
        	 driver = new ChromeDriver();
        }
         
         sdriver = driver;
         
         wLib.waitForPageToLoad(driver);
         

    }
    
    @BeforeMethod
    public void config_BM() throws Throwable{
        /* step 1 : login to APP */ 
        System.out.println("===login===");
		 String URL = fLib.getPropertyKeyValue("url");
		 String USERNAME = fLib.getPropertyKeyValue("username");
		 String PASSWORD = fLib.getPropertyKeyValue("password");
        Login lp = new Login(driver);
        lp.loginToApp(URL, USERNAME, PASSWORD);
    }
    
    @AfterMethod
    public void config_AM() {
    	  System.out.println("===logout===");
	    /* step 5 : logout */ 
    	HomePage hp = new HomePage(driver);
	     hp.signOut();
    	
    }
	
	@AfterClass
	public void config_AC() {

    	System.out.println("======close the BROWSER===========");

		driver.quit();
	}
	
	   @AfterSuite
	
	    public void config_AS() throws Throwable
	   {
	    	System.out.println("===================close DB connaction=================");
        
	    }

	  

}
