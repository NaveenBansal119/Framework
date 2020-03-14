package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass
{
	public WebDriver driver;
	public ConfigDataProvider config= new ConfigDataProvider();
	public ExcelDataProvider excelData= new ExcelDataProvider();
	public ExtentTest logger;
	public ExtentReports report;
	@BeforeSuite
	public void setupSuite(){
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/ExtentReport.html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}
    @Parameters("browser")
	@BeforeClass
	public void setUp(String browser)
	{
//		driver = BrowserFactory.startApplication(driver, config.getBrowserName(),config.getURL());
    	driver = BrowserFactory.startApplication(driver, browser,config.getURL());
	}
    
    @AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
		System.out.println("I am in Teardown Method");
	}
    @AfterMethod
    public void teardownMethod(ITestResult result) throws Exception{
    	
    	if(result.getStatus()==ITestResult.FAILURE){
    		
    		//Helper.captureScreeshot(driver);
    		
    		logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreeshot(driver)).build());
    	}
    	
    	report.flush();
    }
}
