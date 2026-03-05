package com.spg;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest extends ReportUtils  {
	
	public RemoteWebDriver driver;
	
	
	@BeforeSuite
	public void intializationReportConfig() {
		intializedReport();
	}
	
	/* Report starting */
	@BeforeClass
	 public void startReport() {
		createReport(this.getClass().getSimpleName());
	}
	 
	/* for Open The browser */
	@BeforeMethod
	public void lunchWeb() {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		if(WebContants.browser.contains("chrome")) {
			driver=new ChromeDriver();
		}
		else if(WebContants.browser.contains("edge")) {
			driver=new EdgeDriver();
		}
		else if(WebContants.browser.contains("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			throw new IllegalArgumentException("Invalid browser type: "+WebContants.browser);
		}
		
	}
	/* for Close all browser */
	
	 @AfterMethod 
	 public void KillBrowser() {
		 driver.quit(); 
		 }
	 
	 /* Report stop */
	@AfterSuite
	public void KillReport() {
		report.flush();
	}
	

}
