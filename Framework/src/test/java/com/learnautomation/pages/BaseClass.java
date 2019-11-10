package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass
{
	public WebDriver driver;
	public ConfigDataProvider config= new ConfigDataProvider();
	public ExcelDataProvider excelData= new ExcelDataProvider();
    @BeforeClass
	public void setUp()
	{
		driver = BrowserFactory.startApplication(driver, config.getBrowserName(),config.getURL());
	}
    
    @AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
    @AfterMethod
    public void teardownMethod(ITestResult result){
    	
    	if(result.getStatus()==ITestResult.FAILURE){
    		
    		Helper.captureScreeshot(driver);
    	}
    }
}
