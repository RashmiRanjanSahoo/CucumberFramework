package com.qa.factory;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
 public WebDriver driver;
 public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
 
 /**
	 * This method is used to initialize the thradlocal driver on the basis of given
	 * browser
	 * 
	 * @param browser
	 * @return this will return tldriver.
	 */
  public WebDriver init_driver(String browser) {
	  System.out.println("Browser value is "+browser);
	  if(browser.equals("chrome")) {
		  //tlDriver= (ThreadLocal<WebDriver>) WebDriverManager.chromedriver().create();
		  tlDriver.set(WebDriverManager.chromedriver().create());
	  }
	  else if(browser.equals("firefox")){
		  tlDriver= (ThreadLocal<WebDriver>) WebDriverManager.firefoxdriver().create();
	  }
	  else if(browser.equals("safari")){
		  tlDriver= (ThreadLocal<WebDriver>) WebDriverManager.safaridriver().create();
	  }
	  else
		  System.out.println("Please pass the correctg browser value"+browser);
	  
	  getDriver().manage().deleteAllCookies();
	  getDriver().manage().window().maximize();
	  return getDriver();
  }
  
  /**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
  
  public static WebDriver getDriver() {
	  return tlDriver.get();
  }
}
