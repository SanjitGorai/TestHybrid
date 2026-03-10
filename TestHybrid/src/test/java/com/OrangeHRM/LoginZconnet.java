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

		EvenUtils	eveUtils= new EvenUtils(driver);
		ZconnectLoginPage zlogin=new ZconnectLoginPage(driver);
		eveUtils.navigateToUrl(WebContants.Zconnect_url);
		String username = eveUtils.getData("Zconnect_Username");
		String password = eveUtils.getData("Zconnect_Password");
		System.out.println(username  +"  "+password );
		eveUtils.sendValue(zlogin.Zconnect_UserNameField, username);
		eveUtils.sendValue(zlogin.Zconnect_PasswordField, password);
		eveUtils.clickOnElement(zlogin.Zconnect_LoginButton, "Z connect login button" );
		
	}
	
	public void LogintoUrja() {
		eveUtils.na
	}

}
