package com.stackroute.page;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.stackroute.browser.WebDriverFactory;


public class HomePageTest {
	
	private static WebDriver driver = null;
	private static HomePage homePage = null;
	private static String curDir = System.getProperty("user.dir");
	
	@BeforeClass
	public static void setup() throws IOException {
		Properties properties = new Properties();
		FileReader file = new FileReader(curDir + "/src/test/recourses/application.properties");
		properties.load(file);
		
		driver = WebDriverFactory.getDriverInstance(properties.getProperty("browser.name"));
		driver.manage().window().maximize();
		driver.get("site.url");
		
		homePage = new HomePage(driver);
	}
	
	@AfterClass
	public static void close() {
		driver.close();
	}
	
	@Test
	public void test01() {
		HomePage nextPage = homePage.validateLogin("admin", "admin");
		String expectedTitle = "OrangeHRM";
		String actualTitle = nextPage.getTitle();
		
		Assert.assertEquals("Not correct page", expectedTitle, actualTitle);
	}
}
