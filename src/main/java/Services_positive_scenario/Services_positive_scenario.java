package Services_positive_scenario;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Services_positive_scenario extends Generic_function {
	static boolean value;

	/*Browser Launch*/ 	
	@Given("Open the Browser")
	public void services_page_positive_tc_001() throws IOException {
		try {
			Browser_Launch();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("servicepage_positive_tc_001");
		}
	}

	/*TC_001 Validate that the user is able to login with valid credentials*/
	@When("clicks on the 'Login' button")
	public void click_login_button() throws IOException {
		try {
			click("welcome_login");
			driver.findElement(By.xpath(OR_reader( "login_phone_number"))).sendKeys(td_reader("login_phone_number",6));
			driver.findElement(By.xpath(OR_reader( "login_password"))).sendKeys(td_reader("login_password",7));
			click("login");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("click_login_button");
		}
	}

	@Then("Navigate to the login page")
	public void navigate_login() throws IOException {
		try {
			browser_wait(5);
			value = driver.findElement(By.xpath(OR_reader( "logout"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("navigate_login");
		}
	}

	/*TC_002  Validate that the user is able to click on the Services tab */	
	@When("clicks on the 'Services' tab")
	public static void services_page_positive_tc_002() throws IOException{
		try {
			click("services");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			takeScreenShot("servicepage_positive_tc_002");
		}
	}

	@Then("Navigate to the Services pages")
	public static void navigate_services() throws IOException{
		try {
			value = driver.findElement(By.xpath(OR_reader("logout"))).isDisplayed();
			Assert.assertEquals(true,value);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			takeScreenShot("navigate_services");
		}
	}

	/*TC_003 Validate that the user is able to click on the grid tiles*/
	@When("click on all the grid tiles")
	public void services_page_positive_tc_003() throws IOException {
		try {
			grid_tile(OR_reader("grid_path")); 
			value = driver.findElement(By.xpath(OR_reader( "logout"))).isDisplayed();
			Assert.assertEquals(true,value);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			takeScreenShot("servicepage_positive_tc_003");
		}
		System.out.println("services positive");
		browser_close();
	}
}