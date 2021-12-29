package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage
{ //Step-1 
	
	
	
	//Step-2 identify all elements in  the page and declare it
	     @FindBy(xpath="//span[@class='dvHeaderText']")
	     private WebElement contHeaderTxt;

	       
	     //Step-3 Initialize
	     public ContactInfoPage(WebDriver driver)
	     {  
	      PageFactory.initElements(driver,this);
	     }

        //getters 
		public String getContHeaderTxt() 
		{
			return (contHeaderTxt.getText());
		}




}
