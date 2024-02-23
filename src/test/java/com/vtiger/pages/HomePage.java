package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Logout")
	WebElement lnk_Logout;
	
	
	public void clickLogout()
	{
		lnk_Logout.click();
	}
	
	public boolean verifyLogout()
	{
		return lnk_Logout.isDisplayed();
	}

}
