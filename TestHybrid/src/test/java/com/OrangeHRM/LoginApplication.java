package com.OrangeHRM;
import org.testng.annotations.Test;

import com.OrangeHRM.Pages.LoginPagess;

import com.spg.BaseTest;
import com.spg.EvenUtils;
import com.spg.WebContants;

public class LoginApplication extends BaseTest{
	
	
	LoginPagess loginpages;
	EvenUtils   evenUtils;
	
	@Test
	public void LoginToTheApplication() {
		try {
			  
			loginpages=new LoginPagess(driver);
			evenUtils=new EvenUtils(driver);
			evenUtils.navigateToUrl(WebContants.OrangeHRM_url);
			String OrangeHRM_User = evenUtils.getData("OrangeHRM_UserName");
			String OrangeHRM_Pass = evenUtils.getData("OrangeHRM_Password");
			evenUtils.sendValue(loginpages.OrangeHRM_UserNameField, OrangeHRM_User);
			Thread.sleep(3000);
			evenUtils.sendValue(loginpages.OrangeHRM_PasswordField, OrangeHRM_Pass);
			Thread.sleep(3000);
			evenUtils.clickOnElement(loginpages.OrangeHRM_LoginButton, "Login Button");
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

}
