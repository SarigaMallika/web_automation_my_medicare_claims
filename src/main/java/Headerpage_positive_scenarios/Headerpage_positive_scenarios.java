package Headerpage_positive_scenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Headerpage_positive_scenarios extends Generic_function {
	public static boolean value;
	
	@Given("Launch the browser")
	/*Browser launch*/
	public static void browser_launching () throws Exception {
		try {
				Browser_Launch();
			} catch (IOException e) {
				 e.getMessage();
			}
			}
	
	/*TC 001 - Validate that the  'mpowered health’ logo  should be present in the header*/
	@When("Navigated to welcome screen")
	public void welcome_screen() throws IOException {
		click("welcome_login");
		browser_wait(10);
	}
	@Then("Check the mpowered health logo in the header")
	public static void header_positive_tc_001() throws IOException {
		try {

			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",6));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",7));
			click("login");
			 browser_wait(5);
			value = driver.findElement(By.xpath(OR_reader("header_logo"))).isDisplayed();
			Assert.assertEquals(true,value);
			} catch (Exception e) {
			e.getMessage();
			takeScreenShot("header_positive_tc_001");
		}
		
	}
	
	/*TC 002 -Validate that the user is navigated to the help page on clicking 'Help' icon*/

	@When("Click on Help icon")
	public void click_help_icon() throws IOException {
		click("help");
		browser_wait(5);
	}
	@Then("Verify navigation to the help page")
	public static void header_positive_tc_002() throws IOException {
		try {
			value = driver.findElement(By.xpath(OR_reader( "header_frequently_asked"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_back();
		} catch (Exception e) {
			e.getMessage();
			takeScreenShot("header_positive_tc_002");
		} 
	}

	/*TC 003 -Validate that the user is navigated to the Landing page on clicking 'Log out' icon*/
	@When("Click on Log out icon")
	public void click_logout_icon() throws IOException {
		browser_wait(5);
		click("logout");
		browser_wait(5);
	}
	@Then("Verify navigation to the Landing  page")
	public static void header_positive_tc_003() throws IOException {
		try {
			value = driver.findElement(By.xpath(OR_reader( "welcome_login"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.getMessage();
			takeScreenShot("header_positive_tc_003");
		}		
	}
	
	/*TC 004 -Validate that the user is navigated to the alerts page on clicking 'Your alerts' icon*/


	@When("Click on Your alerts icon")
	public void click_alerts_icon() throws IOException {
		browser_wait(5);
		click("header_alerts");
		browser_wait(5);
	}
	@Then("Verify navigation to the alerts page")
	public static void header_positive_tc_004() throws IOException {
		try {
			value = driver.findElement(By.xpath(OR_reader("alerts_header"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.getMessage();
			takeScreenShot("header_positive_tc_004");
		}
	}

	/*TC 005 -Validate that user is able to click on the 'Drop down' tab*/

	@When("Click on Drop down tab")
	public void click_dropDown() throws IOException {
		click("header_menu");
		browser_wait(5);
	}
	@Then("Verify the drop down options")
	public static void header_positive_tc_005() throws IOException {
		try {
			value = driver.findElement(By.xpath(OR_reader( "header_profile"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.getMessage();
			takeScreenShot("header_positive_tc_005");
		} 
	}
	
	/*TC 006 -Validate that the user is navigated to the  profile page on clicking 'Your profile' tab*/

	@When("Click on  Your profile")
	public void click_your_profile() throws IOException {
		click("header_profile");
		browser_wait(5);
	}
	@Then("Verify navigation to the profile page.")
	public static void header_positive_tc_006() throws IOException {
	    try {
			value = driver.findElement(By.xpath(OR_reader("your_profile_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.getMessage();
			takeScreenShot("header_positive_tc_006");
		}
	}

	/*TC 007 -Validate that the user is navigated to the ratings dashboard page on clicking 'Your ratings' tab*/
	@Then("Click on  Your ratings")
	public void clickOnYourRatings() throws IOException {
		click("header_menu");
		browser_wait(5);
		click("header_ratings");
		browser_wait(5);
	}
	@Then("Verify navigation to the ratings dashboard page.")
	public static void header_positive_tc_007() throws IOException {
		try {
			value = driver.findElement(By.xpath(OR_reader( "your_ratings_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.getMessage();
			takeScreenShot("header_positive_tc_007");
		}		
	}

	/*TC 008 -Validate that the user is navigated to the 'Feedback Port'   page  on clicking 'Feedback'*/
	@Then("Click on  Feedback")
	public void click_feedback() throws IOException {
		click("header_menu");
		browser_wait(5);
		click("header_feedback");
		browser_wait(5);
	}
	@Then("Verify the navigation to the Feedback Port.")
	 public static void header_positive_tc_008() throws IOException {
		try {
			browser_handle();
	        value = driver.findElement(By.xpath(OR_reader("your_feedback_title"))).isDisplayed();
	    	Assert.assertEquals(true,value);
	    	browser_close();
	        browser_switch();
	     } catch (Exception e) {
	    	 e.getMessage();
			takeScreenShot("header_positive_tc_008");
		}
	}
	
	/*TC 009 -Validate that the user is navigated to the Contact Us   page  on clicking Contact us */

	@Then("Click on  Contact Us")
	public void click_contactUs() throws IOException {
		click("header_menu");
		browser_wait(5);
		click("header_contact");
		browser_wait(5);
	}
	@Then("Verify the navigation to the Contact Us.")
	public static void header_positive_tc_009() throws IOException {
		try {
			browser_handle();
	        value = driver.findElement(By.xpath(OR_reader( "contact_form"))).isDisplayed();
	    	Assert.assertEquals(true,value);
	    	browser_close();
	        browser_switch();
		} catch (Exception e) {
			e.getMessage();
			takeScreenShot("header_positive_tc_009");
		}  
	}

	/*TC 010 -Validate that the user is able to see Privacy Policy dialogue box on clicking on the 'Privacy Policy' */
	@When("Click on  Privacy Policy")
	public void click_privacy_policy() throws IOException {
		click("header_menu");
		browser_wait(5);
		click("header_privacy");
		browser_wait(5);
	}
	@Then("Verify the dialogue box on privacy page")
	public static void header_positive_tc_010() throws IOException {
		try {
			value = driver.findElement(By.xpath(OR_reader("privacy_ok"))).isDisplayed();
	    	Assert.assertEquals(true,value);
	    	click("privacy_ok");
		} catch (Exception e) {
			e.getMessage();
			takeScreenShot("header_positive_tc_010");
		}		 
	}
   
	/*TC 011 - Validate that the user is able to see Terms & Conditions dialogue box on clicking on the 'Terms & Conditions' */

	@When("click on  Terms & Conditions")
	public void click_terms_conditions() throws IOException {
		click("header_menu");
		browser_wait(5);
		click("header_terms");
		browser_wait(5);
	}
	@Then("Verify the dialogue box on Terms and condition page")
	public static void header_positive_tc_011() throws IOException {
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		try {
			value = driver.findElement(By.xpath(OR_reader( "terms_ok"))).isDisplayed();
	    	Assert.assertEquals(true,value);
	    	click("terms_ok");
	    	System.out.println("header positive");
	    	driverquit();
		} catch (Exception e) {
			e.getMessage();
			takeScreenShot("header_positive_tc_011");
		}   
	}

}