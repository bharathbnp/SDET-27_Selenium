package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericLibrary.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility
{

	
	//Step-2 identify all elements in  the page and declare it
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="industry")
	private WebElement indDropDown;
		
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	
	//Step-3 Initialize
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
	
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}



	public WebElement getSaveBtn() {
		return saveBtn;
	}


	//business library
	public void createOrganization(String username)
	{
		orgNameEdt.sendKeys(username);
		saveBtn.click();
	}
	
	public void createOrganizationWithInd_Type(String username,String industry,String type)
	{
		orgNameEdt.sendKeys(username);
		select(indDropDown, industry);
		select(typeDropDown, type);
		saveBtn.click();
	}
	
	
}
