package com.inetBanking.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ChromeDriver;
	
	// pageFactory Constructor
	public LoginPage(WebDriver driver) {
		ChromeDriver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(name = "uid")
	WebElement UserName;
	
	@FindBy(name = "password")
	WebElement Password;
	
	@FindBy(name = "btnLogin")
	WebElement LoginBtn;
	
	@FindBy(name = "btnReset")
	WebElement ResetBtn;
	
	@FindBy(linkText = "Log out")
	WebElement LogOut;
	
	// Actions:
	
	public void SetUserName(String username) {
		UserName.sendKeys(username);
		
	}
	
	public void SetPassword(String password) {
		Password.sendKeys(password);
	}
	
	public void ClickSubmitBtn() {
		LoginBtn.click();
		
	}
	
	public void ClickResetBtn() {
		ResetBtn.click();
	}
	
	public void LogOutLink() {
		LogOut.click();
	}
}
