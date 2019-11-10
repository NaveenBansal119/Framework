package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage
{    WebDriver driver;


	public LoginPage(WebDriver ldriver){
		
		this.driver= ldriver;
	}
	@FindBy(xpath="//ul[@class='rd-navbar-nav']/a") WebElement loginButton;
	@FindBy(name="email") WebElement emailBox;
	@FindBy(name="password") WebElement passwordBox;
	
	public void loginToCRM(String email, String password) throws Exception{
		
		loginButton.click();
		Thread.sleep(3000);
		emailBox.sendKeys(email);
		passwordBox.sendKeys(password);
	}
}
