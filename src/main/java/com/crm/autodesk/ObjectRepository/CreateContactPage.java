package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericLibrary.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility
{

	//Step-2 identify all elements in  the page and declare it
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastnameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactModLnK;
	
	
	@FindBy(id="search_txt")
	private WebElement orgSearchEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orgNameLookup;
	  
	@FindBy(xpath="//span[@class='dvHeaderText']")
    private WebElement contHeaderTxt;
	
	
	//Step-3 Initialize
	public CreateContactPage(WebDriver driver)
	{
     PageFactory.initElements(driver, this);
	}
	 
	//Step-3 Initialize
	
	
	
	
		
	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getContactModLnK() {
		return contactModLnK;
	}

	public WebElement getOrgNameLookup() {
		return orgNameLookup;
	}

	public void setContHeaderTxt(WebElement contHeaderTxt) {
		this.contHeaderTxt = contHeaderTxt;
	}

	
	public WebElement getOrgSearchEdt() {
		return orgSearchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

		//business library
		public void createContact(String lastname)
		{
			lastnameEdt.sendKeys(lastname);
			saveBtn.click();
		}
	public String getContHeaderTxt() 
	{
		return (contHeaderTxt.getText());
	}
	
	public void createContactWithOrg(String orgName,String lastname,WebDriver driver)
	{
		lastnameEdt.sendKeys(lastname);
		orgNameLookup.click();
		switchToWindow(driver, "Accounts");
		orgSearchEdt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.linkText(orgName)).click();
		switchToWindow(driver,"Contacts");
		saveBtn.click();
	} 
	
	public void clickOnEmail(WebDriver driver)
	{
		mouseOverOnElement(driver, contactModLnK);
		contactModLnK.click();
	}
}
