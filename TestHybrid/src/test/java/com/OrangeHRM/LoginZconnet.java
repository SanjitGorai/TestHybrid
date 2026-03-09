package com.OrangeHRM;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.OrangeHRM.Pages.ZconnectLoginPage;
import com.spg.BaseTest;
import com.spg.EvenUtils;
import com.spg.WebContants;

public class LoginZconnet extends BaseTest{
	
	EvenUtils eveUtils;
	ZconnectLoginPage zlogin;
	@Test
	public void loginTotheZconnect() throws Exception {

		eveUtils=new EvenUtils(driver);
		zlogin=new ZconnectLoginPage(driver);
		
		eveUtils.navigateToUrl(WebContants.Zconnect_url);
	
		String username = eveUtils.getData("Zconnect_Usertname");
		String password = eveUtils.getData("Zconnect_Password");
		System.out.println(username  +"  "+password );
		eveUtils.sendValue(zlogin.Zconnect_UserNameField, username);
		eveUtils.sendValue(zlogin.Zconnect_PasswordField, password);
		eveUtils.clickOnElement(zlogin.Zconnect_LoginButton, "Zconnect Login button");
		
	}
	
	

}
