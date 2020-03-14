package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper
{
	public static String captureScreeshot(WebDriver driver)
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destPath = "./Screenshots/"+getCurrentDateTime()+"Login.png";
		
		try
		{
			FileHandler.copy(src, new File(destPath));
			
			System.out.println("Screenshot captured sucessfully");
			return destPath;
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			System.out.println("Unable to capture screenhsot " + e.getMessage());
		}
		return destPath;
	}

	public static String getCurrentDateTime()
	{
		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentdate = new Date();
		return customformat.format(currentdate);
	}
}
