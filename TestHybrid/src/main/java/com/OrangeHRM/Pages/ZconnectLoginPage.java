package com.OrangeHRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZconnectLoginPage {
	
	public ZconnectLoginPage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		@FindBy (xpath ="//input[@id='email']")
		public WebElement Zconnect_UserNameField;
		
		@FindBy (xpath ="//input[@id='password']")
		public WebElement Zconnect_PasswordField;
		
		@FindBy (xpath ="//button[@id='sign-in-btn']")
		public WebElement Zconnect_LoginButton;
	
		
		
		
		

}
