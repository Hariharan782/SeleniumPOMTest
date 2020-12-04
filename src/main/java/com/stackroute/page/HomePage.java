package com.stackroute.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver = null;
	
	@FindBy(id = "txtUsername")
	private WebElement userName;
	
	@FindBy(id = "txtPassword")
	private WebElement pwd;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[2]/div[2]/form/div[5]/input")
	private WebElement btnLogin;
	
	public HomePage() {	
	}

	public HomePage(WebDriver driver, WebElement userName, WebElement pwd) {
		this.driver = driver;
		this.userName = userName;
		this.pwd = pwd;
		PageFactory.initElements(driver, this);
	}
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	public void inputUserName(String userName) {
		this.userName.sendKeys(userName);
	}
	
	public void inputPassword(String password) {
		this.pwd.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public HomePage validateLogin(String uName, String password) {
		inputUserName(uName);
		inputPassword(password);
		clickLogin();
		return this;
	}
	
	public HomePage invalidLogin(String uName, String password) {
		inputUserName(uName);
		inputPassword(password);
		clickLogin();
		return this;
	}
}
