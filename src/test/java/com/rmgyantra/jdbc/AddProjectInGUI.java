package com.rmgyantra.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class AddProjectInGUI 
{
	public static void main(String[] args) throws InterruptedException, Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 //Open the server and create project 
		  driver.get("http://localhost:8084/");
		  driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		  driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		  driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		  driver.findElement(By.xpath("//a[text()='Projects']")).click();
		  driver.findElement(By.xpath("(//i[@class='material-icons'])[1]")).click();
		  driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("Bharath Vepanjeri");
		  driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Deepak Adarsh");
		  Select s=new Select(driver.findElement(By.xpath("(//select[@name='status'])[2]")));
	
		  s.selectByIndex(3);
		 driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		 //verify the data in database
		 
		 String exceptedName="Bharath Vepanjeri";
		 Connection connect=null;
		 try {
			 Driver driver2=new Driver();
			 DriverManager.registerDriver(driver2);//register
			  connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			              Statement statement = connect.createStatement();
			              ResultSet result = statement.executeQuery("select * from project");         
			                     for(int i=0;i<=3;i++)
			                     {
			                    	 result.next();
			                     }
			                      String actualName=result.getString(4);
			                      if(actualName.equals(exceptedName))
			                      {
			                    	  System.out.println("pass:data is present");
			                      }
			                      else
			                      {
			                    	  System.out.println("fail: data is not present");
		
			                      }
			                      }
		 
		 
		 finally
        {
			                    	  driver.quit();
			                  		connect.close();
		}
		 
		
	}
}
