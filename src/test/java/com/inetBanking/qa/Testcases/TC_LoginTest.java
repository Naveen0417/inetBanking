package com.inetBanking.qa.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.qa.Base.TestBase;
import com.inetBanking.qa.pages.LoginPage;

public class TC_LoginTest extends TestBase {

	@Test
	public void loginTest() throws IOException {

		

		LoginPage login = new LoginPage(driver);

		login.SetUserName(UserName);
		logger.info("Entered username");
		login.SetPassword(Password);
		logger.info("Entered password");
		login.ClickSubmitBtn();
		logger.info("clicked on login button");

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("login Test passed");
		} else {
			captureScreen( driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("login Test failed");
		}
	}
}
