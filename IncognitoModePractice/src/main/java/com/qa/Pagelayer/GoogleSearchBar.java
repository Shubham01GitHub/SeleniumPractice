package com.qa.Pagelayer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;

public class GoogleSearchBar extends TestBase {
	//Declaration
	@FindBy(xpath="//input[@name='q']")
	private WebElement txtbox_Search;
	
	//Initialization
	public GoogleSearchBar() 
	{
		PageFactory.initElements(driver,this);
	}
	
	//Action Methods or Usage
	public void enterSearchContent(String searchContent) 
	{
		txtbox_Search.click();
		txtbox_Search.sendKeys(searchContent);
		txtbox_Search.sendKeys(Keys.ENTER);
	}
	
}
