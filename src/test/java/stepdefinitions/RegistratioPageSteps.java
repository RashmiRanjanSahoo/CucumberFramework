package stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.LoginPage;
import com.pages.RegistrationPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistratioPageSteps {
	
	private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
	private RegistrationPage registrationPage;
	private String header;
	
	@Given("User is already logged in to the application")
	public void user_is_already_logged_in_to_the_application(DataTable credTable) {
	    List<Map<String, String>> credList = credTable.asMaps();
	    String name = credList.get(0).get("username");
	    String pass = credList.get(0).get("password");
	    
	    DriverFactory.getDriver().get("http://www.seleniumbymahesh.com/HMS/index.php");
	    registrationPage=loginPage.doLogin(name, pass);
	}

	@Given("User is on the registration page")
	public void user_is_on_the_registration_page() {
		registrationPage.clickOnRegistration();
		String title=registrationPage.getRegistrationPageTitle();
		System.out.println("The title of the page is"+title);
	}

	@When("user gets the header of the page")
	public void user_gets_the_header_of_the_page() {
		header=registrationPage.getHeader();
		System.out.println("Header of the page is"+header);
	   
	}

	@Then("Header should be {string}")
	public void header_should_be(String ExpectedHeader) {
		Assert.assertTrue(header.contains(ExpectedHeader));
	}

	@Then("user get all the options of patient category")
	public void user_get_all_the_options_of_patient_category(DataTable catTable) {
	    List<String> ExpectedPatCatList=catTable.asList();
	    System.out.println("Expected Patient category List"+ExpectedPatCatList);
	    List<String> ActualPatCatList = registrationPage.getPatientCatOptions();
	    System.out.println("Actual Patient category List"+ActualPatCatList);
	    Assert.assertTrue(ExpectedPatCatList.contains(ActualPatCatList));
	}

	@Then("patient category count should be {int}")
	public void patient_category_count_should_be(int expectedCount) {
	    int actualCount=registrationPage.getPatientCatOptCount();
	    Assert.assertTrue(expectedCount==actualCount);
	}
}
