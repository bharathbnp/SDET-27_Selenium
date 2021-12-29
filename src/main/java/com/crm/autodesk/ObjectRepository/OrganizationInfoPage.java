package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage 
{

	
	//Step-2 identify all elements in  the page and declare it
     @FindBy(xpath="//span[@class='dvHeaderText']")
     private WebElement orgHeaderTxt;

       
     @FindBy(id="mouseArea_Industry")
 	private WebElement indTextInfo;
       
     @FindBy(id="mouseArea_Type")
  	private WebElement typeTextInfo;
     
     
     
     
     
     public OrganizationInfoPage(WebDriver driver)
     {  
      PageFactory.initElements(driver,this);
     }


	public String getOrgHeaderTxt() 
	{
		return (orgHeaderTxt.getText());
	 }
     
	public String getIndTxt() 
 	{
 		return (indTextInfo.getText());
 	}

 	public String getTypeTxt() 
 	{
 		return (typeTextInfo.getText());
 	}

}
