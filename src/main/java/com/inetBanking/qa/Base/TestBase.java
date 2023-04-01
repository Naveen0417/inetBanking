package com.inetBanking.qa.Base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.qa.utils.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	ReadConfig readconfig = new ReadConfig();

	public static WebDriver driver;
	public String Baseurl = readconfig.getApplicationUrl();
	public String UserName = readconfig.getUserName();
	public String Password = readconfig.getPassword();
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void Setup(String browserName) {
		logger = Logger.getLogger("Ebanking");
		PropertyConfigurator.configure("log4j.properties");
		if (browserName.equals("chrome")) {
		//	System.getProperty("webdriver.chrome.driver", readconfig.getChromeDriverPath());
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();			
			options.addArguments("headless");
			driver = new ChromeDriver(options);

		} else if (browserName.equals("firefox")) {
			FirefoxBinary firefoxBinary = new FirefoxBinary();
			firefoxBinary.addCommandLineOptions("--headless");
		//	System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxDriverPath());
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.setBinary(firefoxBinary);
			driver = new FirefoxDriver(options);
		}
		driver.get(Baseurl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger.info("url is opened");
	}

	@AfterClass
	public void TearDown() {
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	public String randomestring() {
		String genaratedString = RandomStringUtils.randomAlphabetic(5);
		return genaratedString;
	}

	public static String randomeNum() {
		String genaratedString2 = RandomStringUtils.randomNumeric(10);
		return genaratedString2;
	}
}
