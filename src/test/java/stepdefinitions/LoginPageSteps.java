package stepdefinitions;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
public class LoginPageSteps {
	
	private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
	private String title;
	
	@Given("user is on login page")
	public void user_is_on_login_page() throws InterruptedException {
	   DriverFactory.getDriver().get("http://www.seleniumbymahesh.com/HMS/index.php");
	   Thread.sleep(2000);
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title=loginPage.getLoginPageTitle();
		System.out.println("Login page title is"+title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String ExpectedTitleName) {
		Assert.assertTrue(title.contains(ExpectedTitleName)); 
	}

	@Then("reset button should be displayed")
	public void reset_button_should_be_displayed() {
		Assert.assertTrue(loginPage.isResetButtonExists());
	}

	@When("user enters username {string}")
	public void user_enters_username(String name) {
		loginPage.enterUserName(name);
	}

	@When("user enters password {string}")
	public void user_enters_password(String pass) {
		loginPage.enterPassword(pass);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	}

	@Then("user gets the title of the master page")
	public void user_gets_the_title_of_the_master_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
