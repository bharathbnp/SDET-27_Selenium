package com.crm.autodesk.genericLibrary;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * Class which has all driver utilities method
 * @author Bharath Vepanjeri
 *
 */
public class WebDriverUtility 
{

	
	/**
	 * It is used to wait until page is loaded before identifying any synchronized elements in DOM[HTML-Document]
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver)
	{
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
     
   
	/**
	 * It is used to wait until page is loaded before identifying any assynchronized[java script actions] elements in DOM[HTML-Document]
	 * @param driver
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver)
	{
	driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
	}
	
	
	
	/**
     * used to wait for element to be clickable in GUI , & check for specific element for every 500 milli seconds
     * @param driver
     * @param element
     */

	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	  /**
     * used to wait for element to be clickable in GUI , & check for specific element for every 500 milli seconds
     * @param driver
     * @param element
     * @param pollingTime in the form second
	 * @throws Throwable 
     */
	public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement element, int pollingTime) throws Throwable {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));	
	}
	
	   /**
	    * It is used to switch to any window based on window title
	    * @param driver
	    * @param partialWindowTitle
	    */
	 public void switchToWindow(WebDriver driver,String partialWindowTitle)
	 {
		 Set<String> set = driver.getWindowHandles();
		 Iterator<String> it=set.iterator();
		 while(it.hasNext())
		 {
			 String currentId=it.next();
			 driver.switchTo().window(currentId);
			 if(driver.getTitle().contains(partialWindowTitle))
			 {
				 break;
			 }
		 }
	 }
	
	 
	 /**
	  * It is used to switch to alert and click on the accept button
	  * @param driver
	  */
	 public void switchToAlertAndAccept(WebDriver driver)
	 {
		 driver.switchTo().alert().accept();
	 }
	 
	 /**
	  * It is used to switch to alert and click on the cancel button
	  * @param driver
	  */
	 public void switchToAlertAndCancel(WebDriver driver)
	 {
		 driver.switchTo().alert().dismiss();
	 }
	 
	 
	 /**
	  * It is used to switch to frames based on index value passed
	  * @param driver
	  * @param index
	  */
	public void switchToFrame(WebDriver driver,int index)
	{
	 	driver.switchTo().frame(index);
	}
	 
	 
	/**
	  * It is used to switch to frames based on id or name or attribute
	  * @param driver
	  * @param index
	  */
	public void switchToFrame(WebDriver driver,String id_name_attribute)
	{
	 	driver.switchTo().frame(id_name_attribute);
	}
	 
	 
	
	
	/**
	 * It is used to select the value from dropDown based on index passsed
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	
	/**
	 * It is used to select the value from dropDown based on text passed
	 * @param element
	 * @param text
	 */
	public void select(WebElement element,String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	
	/**
	 * It is used to place mouse cursor on the element passed
	 * @param driver
	 * @param element
	 */
	 public void mouseOverOnElement(WebDriver driver,WebElement element)
	 {
		 Actions act=new Actions(driver);
		 act.moveToElement(element).perform();
	 }
	
	 
	 /**
		 * It is used to right click on the element passed
		 * @param driver
		 * @param element
		 */
		 public void rightClick(WebDriver driver,WebElement element)
		 {
			 Actions act=new Actions(driver);
			 act.contextClick(element).perform();
		 }
	
		 
		 /**
		  * 	It is used to take screenshot and store the png file in screenshot folder with name passed.
		  * @param driver
		  * @param screenShotName
		  * @throws IOException
		  */
	   public void takeScreenshot(WebDriver driver,String screenShotName) throws IOException
	   {
		    TakesScreenshot tObj=(TakesScreenshot) driver;
		    File src= tObj.getScreenshotAs(OutputType.FILE);
		    File dest=new File("./screenshot/"+screenShotName+".png");
		     Files.copy(src, dest);
		     
	   }
	
	
	   /**
		 * It is used to scroll and handle disabled elements
		 * @param driver
		 * @param javaScript
		 */
		public void executeJavaScript(WebDriver driver , String javaScript) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript(javaScript);
		}
           
		/**
		 * used to wait for elemenet and click
		 * @param element
		 * @throws InterruptedException
		 */
		   public void waitAndClick(WebElement element) throws InterruptedException
		   {
			   int count = 0;
		       while(count<5) {
			    	   try {
			    	       element.click();
			    	       break;
			    	   }catch(Throwable e){
			    		   Thread.sleep(1000);
			    		   count++;
			    	   }
		       }
		   }

		
		
		
		
		
	
	
}
