package com.inetBanking.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public ReadConfig() {
		File src = new File("./src//main//resources//configurations//config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}
	}
	
	public String getApplicationUrl() {
		String url = prop.getProperty("Baseurl");
		return url;
	}
	
	public String getUserName() {
		String username = prop.getProperty("UserName");
		return username;
	}
	
	public String getPassword() {
		String password = prop.getProperty("Password");
		return password;
	}
	
	public String getChromeDriverPath() {
		String chromePath = prop.getProperty("chromePath");
		return chromePath;
	}
	
	public String getFirefoxDriverPath() {
		String firefoxPath = prop.getProperty("firefoxPath");
		return firefoxPath;
	}
}
