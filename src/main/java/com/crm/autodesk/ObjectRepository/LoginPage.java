package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{//Step 1 Xreate one pom class for every web page

	
	
	//Step-2 identify all elements in  the page and declare it
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
    @FindBy(id="submitButton")
    private WebElement loginBtn;
	
    
  //Step-3 Initialize
    public LoginPage(WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
    	
    }

    
    //getters
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
    
    
	//business libraries 
	
	 public void login(String username,String password)
	 {
		 usernameEdt.sendKeys(username);
		 passwordEdt.sendKeys(password);
		 loginBtn.click();
	 }
	
	
}
