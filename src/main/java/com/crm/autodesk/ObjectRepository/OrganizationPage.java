package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage 
{

	
	////Step-2 identify all elements in  the page and declare it
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgLookup;
	
	
	//Step-3 Initialize
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getCreateOrgLookup() {
		return createOrgLookup;
	}

	//business library
	public void clickOnCreateOrg()
	{
		createOrgLookup.click();
	}
	
	
	
}
