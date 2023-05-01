package AppHooks;

import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApplicationHooks {
 private DriverFactory driverFactory;
 private WebDriver driver;
 private ConfigReader configReader;
 Properties prop;
 
 @Before(value="@Skip_Scenario",order=0)
 public void skipScenario(io.cucumber.java.Scenario scenario) {
	 System.out.println("Skipped scenario is"+scenario.getName());
	 Assume.assumeTrue(false);
	 
 }
 
 @Before(order=1)
 public void getProperty() {
	 configReader = new ConfigReader();
	 prop=configReader.initprop();
	 
 }
 @Before(order=2)
 public void launchBrowser() {
	 String browsername=prop.getProperty("browser");
	 driverFactory=new DriverFactory();
	 driver=driverFactory.init_driver(browsername);
	
 }
 
 @After(order=0)
 public void quitBrowser() {
	 driver.quit();
 }
 
 @After(order=1)
 public void tearDown(io.cucumber.java.Scenario scenario) {
	 if(scenario.isFailed()) {
		 //Take screenshot
		 String screenshotName=scenario.getName().replaceAll(" ", "_");
		 TakesScreenshot ts=(TakesScreenshot)driver;
		 byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		 scenario.attach(src, "image/png", screenshotName);
	 }
	 
 }
 
}
