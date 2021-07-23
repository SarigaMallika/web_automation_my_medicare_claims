package Login_positive_scenarios;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_positive_scenarios extends Generic_function {
	public static boolean value;

	@Given("launch the URL")
	/*Browser launch*/
	public static void browser_launching() throws Exception  {
		try {
			Browser_Launch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("clicks on 'Login' button")
	public void login() throws Exception {
		try {
			click("welcome_login");
			browser_wait(12);

		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("login_positive_tc_001");
		}

	}
	@Then("check  the  'Phone number' field is prefixed with country code")
	/*TC 001 - Validate that the'Phone number' field is prefixed with '+1' country code*/
	public static void login_positive_tc_001() throws IOException   {
		try {

			value = driver.findElement(By.xpath(OR_reader( "plus_one"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("login_positive_tc_001");
		}
	}

	@When("clicks on 'Forgot password'")
	/*TC 002 - Validate that the user is able to click on the 'Forgot password?' link*/
	public static void login_positive_tc_002() throws IOException  {
		//		try {
		//			click("forgot_password_link");
		//			
		//			} catch (Exception e) {
		//				e.printStackTrace();
		//				takeScreenShot("login_positive_tc_002");
		//		}
	}
	@Then("navigated to Forgot password page")
	public void navigated_to_forgot_password_page() {
		//	try {
		//		browser_wait(12);
		//		value = driver.findElement(By.xpath(OR_reader( "forgot_password_title"))).isDisplayed();
		//		Assert.assertEquals(true,value);
		//	} catch (Exception e) {
		//		e.printStackTrace();
		//		takeScreenShot("login_positive_tc_002");
		//}

	}
	@When("clicks on 'Sign up'")
	/*TC 003 - Validate that the user is able click on the 'Sign up' link*/
	public static void login_positive_tc_003() throws IOException  {
		//       try {
		//			driver.navigate().back();
		//			click("sign_up_link");

		//			}  catch (Exception e) {
		//				e.printStackTrace();
		//				takeScreenShot("login_positive_tc_003");
		//		}
	}
	@Then("navigated to Sign up page")
	public void sign_up_page()  throws IOException {
		//       try {
		//   		browser_wait(12);
		//			value = driver.findElement(By.xpath(OR_reader("signup_first_name"))).isDisplayed();
		//			Assert.assertEquals(true,value);
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//			takeScreenShot("login_positive_tc_003");
		//		}

	}
	@Then("enters  the Password")
	/*TC 004 -  Validate that the user is able to enter  the Password in the Password field*/
	public static void login_positive_tc_004() throws IOException {
		try {
			//			driver.navigate().back();
			//			driver.findElement(By.xpath(OR_reader( "login_password"))).sendKeys(td_reader("login_password",5));
			driver.findElement(By.xpath(OR_reader( "login_password"))).sendKeys(td_reader("login_password",5));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("login_positive_tc_004");
		}
	}

	@When("enters valid phonenumber and password")
	/*TC 005 - Validate that the user is able to Login with valid data*/
	public static void login_positive_tc_005() throws IOException  {
		try {
			browser_refresh();
			driver.findElement(By.xpath(OR_reader( "login_phone_number"))).sendKeys(td_reader("login_phone_number",5));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",6));

		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("login_positive_tc_005");	
		}
	}
	@Then("clicks on 'login'")
	public void loginhome() throws Exception {
		try {
			click("login");
			browser_wait(12);		
			value = driver.findElement(By.xpath(OR_reader( "logout"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("login_positive_tc_005");
		}

	}

	@When("clicks on Logout")
	/*TC 006 - Validate that the user is navigated to 'Landing page' on clicking the 'Log out' option*/
	public static void login_positive_tc_006() throws IOException {
		try {
			click("logout");
			

		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("login_positive_tc_006");	
		}
	}
	@Then("navigated to Landing page")
	public static void landingpage() throws IOException {
		try {
			
			browser_wait(12);
			value = driver.findElement(By.xpath(OR_reader( "welcome_login"))).isDisplayed();
			Assert.assertEquals(true,value);
			System.out.println("login positive");
			//reportMemoryUsage();
			browser_close();

		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("login_positive_tc_006");	
		}
	}
}
