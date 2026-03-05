package com.OrangeHRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagess {
	
	public LoginPagess(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath ="//input[@placeholder='Username']")
	public WebElement OrangeHRM_UserNameField;
	
	@FindBy (xpath ="//input[@placeholder='Password']")
	public WebElement OrangeHRM_PasswordField;
	
	
	@FindBy (xpath ="//button[@type='submit']")
	public WebElement OrangeHRM_LoginButton;
	

}
