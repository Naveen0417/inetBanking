package com.inetBanking.qa.Testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.qa.Base.TestBase;
import com.inetBanking.qa.pages.LoginPage;
import com.inetBanking.qa.utils.XLUtils;

public class TC_LoginDDT extends TestBase {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws IOException, InterruptedException {

		LoginPage login = new LoginPage(driver);

		login.SetUserName(user);
		logger.info("Entered username");
		login.SetPassword(pwd);
		logger.info("Entered password");
		login.ClickSubmitBtn();
		logger.info("clicked on login button");
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}else {
			Assert.assertTrue(true);
			logger.info("login Passsed");			
			login.LogOutLink();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}

	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/main/java/com/inetBanking/qa/TestData/loginData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colnum = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colnum];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colnum; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
}
