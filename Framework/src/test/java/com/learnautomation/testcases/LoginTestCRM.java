package com.learnautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.ExcelDataProvider;

public class LoginTestCRM extends BaseClass
{  
	@Test
	public void loginApp() throws Exception
	{   logger = report.createTest("Login  Functionality");
		logger.info("Starting the test Execution");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginToCRM(excelData.getStringData("Login", 0, 0),excelData.getStringData("Login", 0, 1));
		//Assert.assertEquals(true, false);
		logger.info("Ending the test Execution");
	}
}
