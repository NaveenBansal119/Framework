package com.learnautomation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//Hello
public class BrowserFactory
{
	

	public static WebDriver startApplication(WebDriver driver, String browserName, String appUrl)
	{
		if (browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Driver/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "value");
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "value");
			driver = new InternetExplorerDriver();
		} else
		{
			System.out.println("We dont support this browser.");
		}
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(appUrl);
		driver.manage().window().maximize();
		return driver;
	}

	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
}
