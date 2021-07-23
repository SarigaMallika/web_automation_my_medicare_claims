package Landing_welcome_positive_scenarios;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Landing_welcome_positive_scenarios extends Generic_function {
	static boolean value;
    static int s;
	
	/*Browser opens and enter URL*/
	@Given("launch the URL")
	public static void browser_launching() throws IOException, InterruptedException {
		Browser_Launch();
		s= Dataiter();		
	}
	
	/*TC_001 Verify that user is navigated to the Welcome page */
	@Then("navigated to Welcome page")
	public static void landing_welcome_positive_tc_001() throws IOException {
		try {
			value = driver.findElement(By.xpath(OR_reader("welcome_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Landing_welcome_positive_tc_001");
		}
	}
	
	/*TC_002 Validate that the  user is able to click on 'Login' button and navigated to login page*/
	@When("clicks on the 'Login' button")
	public static void landing_welcome_positive_tc_002() throws IOException {
		try {
			click("welcome_login");
			
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Landing_welcome_positive_tc_002");
		}
	}
	@Then("navigate to Login page")
	public void login_page() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader( "login_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Landing_welcome_positive_tc_002");
		}
		
	}

	/*TC_003 Validate that the user is able to click on 'Sign Up' button and navigate to 'Sign Up' page*/
	@When("clicks on  'Sign Up' button")
	public static void landing_welcome_positive_tc_003() throws IOException {
		try {
			driver.navigate().to(getURL());
			click("welcome_signup");
			
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Landing_welcome_positive_tc_003");
		}
	}
	@Then("navigate to Sign up page")
	public void navigate_to_sign_up_page() throws Exception {
		try {
			browser_wait(12);
			value = driver.findElement(By.xpath(OR_reader( "signup_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			System.out.println("landing positive");
			browser_close();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Landing_welcome_positive_tc_003");
		}
		
	}

}
