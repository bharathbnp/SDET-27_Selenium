package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericLibrary.WebDriverUtility;

public class HomePage extends WebDriverUtility
{ 

   
	//Step-2 identify all elements in  the page and declare it
	@FindBy(linkText = "Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;
	
	@FindBy(linkText = "Documents")
	private WebElement documentsLnk;
	
	@FindBy(linkText = "Email")
	private WebElement emailLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutLnk;
	
	
	//Step-3 Initialize
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	
	//getters
	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}


	public WebElement getContactsLnk() {
		return contactsLnk;
	}


	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}


	public WebElement getDocumentsLnk() {
		return documentsLnk;
	}


	public WebElement getEmailLnk() {
		return emailLnk;
	}


	public WebElement getAdminImg() {
		return adminImg;
	}


	
	
	
	//business library
	public void clickOnOrganizationModule()
	{
		organizationLnk.click();
	}
	
	public void clickOnContactsModule()
	{
		contactsLnk.click();
	}
	
	
	public void signOut(WebDriver driver)
	{
		mouseOverOnElement(driver,adminImg);
		signoutLnk.click();
	}
	
	
}
