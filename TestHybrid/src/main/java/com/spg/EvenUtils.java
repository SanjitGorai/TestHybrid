package com.spg;


import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class EvenUtils {
	 
	RemoteWebDriver driver;
	ReportUtils reportUtils=new ReportUtils();
	 
	public EvenUtils(RemoteWebDriver driver) {
		this.driver=driver;
	}
	
	public void clickOnElement(WebElement ele) {
		reportUtils=new ReportUtils();
		try {
			ele.click();
		//	reportUtils.logStatus("INFO", "User is able to click on ");
		}catch(Exception e) {
		//	reportUtils.logStatus("Warning", "User  unable to click on ");
		}
	} 
		public void sendValue(WebElement ele,String element) {
			try {
				ele.sendKeys(element);
				reportUtils.logStatus("INFO", "user is successfully enter the data --> "+element);
			} catch (Exception e) {
				reportUtils.logStatus("WARNING", "user is not successfully enter the data --> "+element);
				
				e.printStackTrace();
			}
		}
		
		/* Enter the Url
		 * @author Sanjit
		 */
		public void navigateToUrl(String url) {
			
			try {
				driver.get(url);
				reportUtils.logStatus("INFO", "user is successfully Navigate to --> "+url);
			} catch (Exception e) {
				reportUtils.logStatus("WARNING", "user is not successfully Navigate to "+url);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public void navigateToCurrentUrl() {
			try {				
				String url =driver.getCurrentUrl();
				Thread.sleep(3000);
				reportUtils.logStatus("INFO", "After Loged in user is  redirected to --> "+url);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		public boolean waitUntillElementIsPresent(WebElement ele,int i,String text ) {
			try {
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(i));
				wait.until(ExpectedConditions.visibilityOf(ele));
				reportUtils.logStatus("INFO", "user is able to locate "+text);
				return true;
			}catch (Exception e) {
				reportUtils.logStatus("WARNING", "user unable to locate "+text);
				return false;
			}
		}
		
		public boolean waitUntillElementIsVisible(WebElement ele,int i) {
			try {
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(i));
				wait.until(ExpectedConditions.visibilityOf(ele));
				return true;
			}catch (Exception e) {
				return false;
			}
		}
		
		public boolean waitUntillElementIsDisplayed(WebElement ele,int i) {
			boolean flag = false;
			try {
				Thread.sleep(2000);
				flag = ele.isDisplayed();
			}catch (Exception e) {
				
			}
			return flag;
		}
		
	
	public String getScreenShot(String TestName) throws Exception {
		File sre=driver.getScreenshotAs(OutputType.FILE);
		String fileName=System.getProperty("user.dir")+"ScreenShots"+TestName+".png";
		File dest=new File(fileName);
		FileUtils.copyFile(sre, dest);	
		return fileName;
	} 
	
	public String getScreenShotBase64() throws Exception {
		String sre=driver.getScreenshotAs(OutputType.BASE64);
		return sre;
	}
	
	public void switchToFrame(WebElement ele) {  
	    try {
	    	Thread.sleep(3000);
	        driver.switchTo().frame(ele);
	       // reportUtils.logStastus("INFO", "user is successfully switched to the frame ");
	    } catch (Exception e) {
	    	 reportUtils.logStatus("WARNING", "An error occurred while switching to the frame "+e.getMessage());
	        
	    }
	}
	

	

	public String getData(String value) throws Exception {
		FileInputStream fs=new FileInputStream("C:\\Users\\Sanjit\\eclipse-workspace\\TestHybrid\\crediantial.properties");
		Properties p=new Properties();
		p.load(fs);
		return p.getProperty(value);
		
		
	}
	
	public String getOTP(String value) throws Exception {
		FileInputStream fs=new FileInputStream("C:\\Users\\Sanjit\\eclipse-workspace\\SpinmatchAndCricaza\\src\\test\\resources\\OTPReceived\\OTP.properties");
		Properties p=new Properties();
		p.load(fs);
		return p.getProperty(value);
		
		
	}
	
	public String getDataRandom(String value,String fileName) throws Exception {
		FileInputStream fs=new FileInputStream("C:\\Users\\Sanjit\\eclipse-workspace\\SpinmatchAndCricaza\\"+fileName+".properties");
		Properties p=new Properties();
		p.load(fs);
		return p.getProperty(value);
		
		
	}
	public void mouseHover(WebElement ele) {
		Actions action = new Actions(driver);
		try {
			action.moveToElement(ele).perform();
		} catch (Exception e) {
			action.moveToElement(ele).perform();
		}
	}
	public Set<String> getSessionID() {
		Set<String> session=driver.getWindowHandles();
		return session;
	}

	public void windowHandle(String session) {
		driver.switchTo().window(session);
	}
	
	public String getDataFromexcel(int i,int j)throws Exception {
		DataFormatter dataformat=new DataFormatter();
		FileInputStream fis=new FileInputStream("C:\\Users\\Sanjit\\eclipse-workspace\\SpinmatchAndCricaza\\data\\SpinMatchLoginCred.xlsx");
		XSSFWorkbook wb =new XSSFWorkbook(fis);
		XSSFSheet sheetAt = wb.getSheet("sheet1");			
		String s = dataformat.formatCellValue(sheetAt.getRow(i).getCell(j));
		return s;
	}
	public void clickOnElement(WebElement ele,String text) {
		reportUtils=new ReportUtils();
		
		try {
			//driver.executeScript("arguments[0].click();", ele);
			ele.click();
			reportUtils.logStatus("INFO", "User is able to click on "+text);
		}catch(Exception e) {
			reportUtils.logStatus("WARNING", "User unable to click on "+text);
			try {
				reportUtils.logStatusWarning(getScreenShotBase64());
			}catch (Exception e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}
		}
	}
	public String fetchText(WebElement ele) {
		return (String) driver.executeScript("return arguments[0].innerText;", ele);
	}
	
	
	public void clickOnElementUsingjavaScriptExecuterLog(WebElement ele,String text) {
		reportUtils=new ReportUtils();
		
		try {
			driver.executeScript("arguments[0].click();", ele);
		//	ele.click();
			reportUtils.logStatus("INFO", "User is able to click on "+text);
		}catch(Exception e) {
			reportUtils.logStatus("WARNING", "User unable to click on "+text);
			try {
				reportUtils.logStatusWarning(getScreenShotBase64());
			}catch (Exception e1) {
				// TODO: handle exception
				//e1.printStackTrace();
			}
		}
	}
	public String getTitle() {
		return driver.getTitle();

	}
	
	
	
	public void ScrollIntoView(WebElement element) {
		
		 driver.executeScript("arguments[0].scrollIntoView(true);", element);
	    }
	
	}

