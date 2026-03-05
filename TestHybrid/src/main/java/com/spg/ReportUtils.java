package com.spg;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ReportUtils {
	
	public static ExtentSparkReporter reporter;
	public static ExtentReports report;
	public static ExtentTest test;
	
	public void intializedReport() {
		String reportPath = "C:\\Project_Report\\WEB";
		createFolder(reportPath);
		reporter=new ExtentSparkReporter(reportPath+"Today_Report"+WebContants.browser+RandomDate()+".html");
		reporter.config().setDocumentTitle("Extent_Report");
		report=new ExtentReports();
		report.attachReporter(reporter);
		report.flush();
	}
	private void createFolder(String folderPath) {
		File f = new File(folderPath);
		if(!f.exists()) {
			f.mkdirs();
		}

	} 
	
	private String RandomDate() {
		 LocalDateTime currentDateTime = LocalDateTime.now();

	        // Define the format for date and time
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

	        // Format the current date and time
	        String formattedDateTime = currentDateTime.format(formatter);
	        return formattedDateTime;
	}
	
	public void createReport(String className) {
		test=report.createTest(className);
	}
	
	public void logStatus(String status,String useCase) {
	//	BaseTest baseTest=new BaseTest();
		if(status.contains("INFO")) {
			test.info(MarkupHelper.createLabel(useCase, ExtentColor.BLUE));
		}
		else if(status.contains("PASS")) {
			test.pass(MarkupHelper.createLabel(useCase, ExtentColor.GREEN));
		}
		else if(status.contains("FAIL")) {
			test.fail(MarkupHelper.createLabel(useCase, ExtentColor.RED));
		}
		else if(status.contains("WARNING")) {
			test.warning(MarkupHelper.createLabel(useCase, ExtentColor.YELLOW));
		}
	}
	
	public void logStatusFailed(String filePath) {
		test.fail("warning",MediaEntityBuilder.createScreenCaptureFromPath(filePath).build());

	}
	
	public void logStatusWarning(String filePath) {
		test.warning("warning",MediaEntityBuilder.createScreenCaptureFromBase64String(filePath).build());

	}
	
	public void logStatusWarningBase(String filePath) {
		test.warning("warning").addScreenCaptureFromBase64String(filePath);

	}
	public void logStatusInfo(String useCase) {
		test.info(MarkupHelper.createLabel(useCase, ExtentColor.BLUE));

	}
	
	public void addScreenShot(String tests) {
		test.addScreenCaptureFromPath(tests);
	}
}
