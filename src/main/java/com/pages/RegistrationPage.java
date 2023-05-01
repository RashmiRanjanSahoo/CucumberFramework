package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
 private WebDriver driver;
 private By Header=By.tagName("h2");
 private By Pateint_Reg_Page=By.xpath("//a[text()='Registration']");
 private By patient_cat_option=By.xpath("//select[@name='PATIENT_CAT']/option");
 private By patient_cat=By.xpath("//select[@name='PATIENT_CAT']");
  
 public RegistrationPage(WebDriver driver) {
	this.driver=driver;
}
 
 public void clickOnRegistration() {
	 driver.findElement(Pateint_Reg_Page).click();
 }
 public String getRegistrationPageTitle() {
	 return driver.getTitle();
 }
 
 public String getHeader() {
	 return driver.findElement(Header).getText();
 }
 
 public int getPatientCatOptCount() {
	 return driver.findElements(patient_cat_option).size()-1;
 }
 
 public ArrayList<String> getPatientCatOptions() {
	 ArrayList<String> opts=new ArrayList<String>();
	 List<WebElement> cat = driver.findElements(patient_cat);
	 for(WebElement e:cat) {
		 opts.add(e.getText());
	 }
	 return opts;
 }
 
 
}
