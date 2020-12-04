package com.stackroute.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
	private static final String CHROME = "chrome";
	private static final String FIREFOX = "firefox";
	
	public WebDriverFactory() {	
	}

	public static WebDriver getDriverInstance(String browserName) {
		WebDriver webDriver = null;
		String chromePath = System.getProperty("user.dir") + "/lib/chromedriver.exe";
		String firefoxPath = System.getProperty("user.dir") + "/lib/geckodriver.exe";
		
		if(CHROME.equalsIgnoreCase(browserName)) {
			System.setProperty("webdriver.chrome.driver", chromePath);
			webDriver = new ChromeDriver();
		} else if(FIREFOX.equalsIgnoreCase(browserName)) {
			System.setProperty("webdriver.gecko.driver", firefoxPath);
			webDriver = new FirefoxDriver();
		}
		return webDriver;
	}
}
