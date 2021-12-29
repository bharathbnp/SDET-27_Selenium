package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage 
{

	//Step-2 identify all elements in  the page and declare it
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContactLookUp;
	   
	//Step-3 Initialize
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
       //getters
	 public WebElement getCreateContactLookUp() 
	 {
		return createContactLookUp;
	}


	//business library
	public void clickOnCreateContact()
	{
		createContactLookUp.click();
	}
	
	
	
	
}
