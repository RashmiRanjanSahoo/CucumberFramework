package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	//By Locators
 private By username=By.name("username");
 private By password=By.name("password");
 private By submitButton= By.name("submit");
 private By ResetButton = By.name("resetttttt");
 
 //Constructor
 
 public LoginPage(WebDriver driver) {
	 this.driver=driver;
 }
 
 //page Actions
 public String getLoginPageTitle() {
	 return driver.getTitle();
 }
	
 public boolean isResetButtonExists() {
	 return driver.findElement(ResetButton).isDisplayed();
 }
 
 public void enterUserName(String name) {
	 driver.findElement(username).sendKeys(name);
 }
 
 public void enterPassword(String pass) {
	 driver.findElement(password).sendKeys(pass);
 }
 
 public void clickOnLogin() {
	 driver.findElement(submitButton).click();
 }
 
 public RegistrationPage doLogin(String name,String pass) {
	 driver.findElement(username).sendKeys(name);
	 driver.findElement(password).sendKeys(pass);
	 driver.findElement(submitButton).click();
	 
	 return new RegistrationPage(driver);
 }
}
