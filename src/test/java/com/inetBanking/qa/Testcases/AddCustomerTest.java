package com.inetBanking.qa.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.qa.Base.TestBase;
import com.inetBanking.qa.pages.AddCustomerPage;
import com.inetBanking.qa.pages.LoginPage;

public class AddCustomerTest extends TestBase {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage login = new LoginPage(driver);
		login.SetUserName(UserName);
		login.SetPassword(Password);
		login.ClickSubmitBtn();
		logger.info("Login Successfull");
		Thread.sleep(3000);

		AddCustomerPage acp = new AddCustomerPage(driver);
		acp.clickAddNewCustomer();
		logger.info("Providing Customer details");
		acp.custName("naveen");
		acp.custgender("male");
		acp.custdob("10", "15", "1985");
		Thread.sleep(5000);
		acp.custaddress("INDIA");
		acp.custcity("HYD");
		acp.custstate("AP");
		acp.custpinno("500074");
		acp.custtelephoneno("9876543210");

		String email = randomestring() + "@gmail.com";
		acp.custemailid(email);
		acp.custpassword("abcdef");
		acp.custsubmit();
		
		Thread.sleep(5000);
		
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(result == true) {
			logger.info("test case passed....");
			Assert.assertTrue(true);
		}else {
			logger.info("test case failed....");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}


}
