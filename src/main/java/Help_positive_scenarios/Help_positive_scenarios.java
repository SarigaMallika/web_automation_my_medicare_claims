package Help_positive_scenarios;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Help_positive_scenarios extends Generic_function{
	public static boolean value;

	/*Browser launch*/
	@Given("launch the URL")
	public void browser_launching() throws Exception {
		try {
			Browser_Launch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*TC 001 - Validate that the  'Frequently asked questions’ title  should be present in  Help page*/
	@When("clicks on 'Help' tab")
	public void help_positive_tc_001() throws Exception {
		try {
			click("welcome_login");
			browser_wait(5);
			driver.findElement(By.xpath(OR_reader( "login_phone_number"))).sendKeys(td_reader("login_phone_number",9));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",5));
			click("login");
			//Thread.sleep(2000); 
			browser_wait(50);
			value = driver.findElement(By.xpath(OR_reader("header_logo"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_wait(5);
			click("help");
			browser_wait(5);
			value = driver.findElement(By.xpath(OR_reader("header_frequently_asked"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_tc_001");
		}		
	}

	@Then("verify the  Frequently asked questions title")
	public void check_title() throws Exception {
		try {
			browser_wait(5);
			click("help");
			browser_wait(50);
			value = driver.findElement(By.xpath(OR_reader("header_frequently_asked"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_tc_001");
		}

	}
	/*TC 002 - Validate that the 'Second Opinions' title  should be present  and able to see description , when user click on Second Opinions title */
	@When("clicks on Second Opinions title")
	public void help_positive_tc_002() throws Exception {
		try {
			browser_wait(50);
			value = driver.findElement(By.xpath(OR_reader("help_secondassert"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_tc_002");
		}
	}
	@Then("verify the Second Opinions description is displayed")
	public void secondopinions_displayed() throws Exception {
		try {
			browser_wait(10);
			click("help_secondassert");
			//Thread.sleep(1000);
			browser_wait(50);
			value = driver.findElement(By.xpath(OR_reader( "help_secondabout"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_tc_002");
		}
	}
	/*TC 003 - Validate that the 'Award Points' title  should be present  and able to see description , when user click on Award Points title  */
	@When("clicks on Award Points title")
	public void help_positive_tc_003() throws Exception {
		try {
			browser_wait(50);
			value = driver.findElement(By.xpath(OR_reader("help_awardpoints"))).isDisplayed();
			Assert.assertEquals(true,value);

		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_tc_003");
		}		 
	}
	@Then("verify the Award Points description is displayed")
	public void awardspoints_displayed() throws Exception {
		try {
			browser_wait(50);
			click("help_awardpoints");
			browser_wait(40);
			value = driver.findElement(By.xpath(OR_reader("help_awardpointsabout"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_tc_003");
		}
	}


	/*TC 004 - Validate that the 'Referral' title  should be present  and able to see description , when user click on Referral title   */
	@When("clicks on Referral title")
	public void help_positive_tc_004() throws Exception {
		try {
			browser_wait(50);
			value = driver.findElement(By.xpath(OR_reader("help_referralassert"))).isDisplayed();
			Assert.assertEquals(true,value);

		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_tc_004");
		}		
	}

	@Then("verify the Referral description is displayed")
	public void referral_displayed() throws Exception {
		try {
			browser_wait(40);
			click("help_referralassert");
			browser_wait(50);
			value = driver.findElement(By.xpath(OR_reader("help_referralabout"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_tc_004");
		}
	}
	/*TC 005 - Validate that the 'Profile' title  should be present  and able to see description , when user click on Profile title  */
	@When("clicks on Profile title")
	public void help_positive_tc_005() throws Exception {
		try {
			browser_wait(50);
			value = driver.findElement(By.xpath(OR_reader( "help_profileassert"))).isDisplayed();
			Assert.assertEquals(true,value);

		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_tc_005");
		}		
	}

	@Then("verify the Profile description is displayed")
	public void profile_displayed() throws Exception {
		try {
			browser_wait(10);
			click("help_profileassert");
			browser_wait(50);
			value = driver.findElement(By.xpath(OR_reader("help_profileabout"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_tc_005");
		}
	}
	/*TC 006 - Validate that the 'Payments' title  should be present  and able to see description , when user click on Payments title  */
	@When("clicks on Payments  title")
	public void help_positive_tc_006() throws Exception {
		try {
			browser_wait(10);
			scrolldown();
			value = driver.findElement(By.xpath(OR_reader("help_paymentassert"))).isDisplayed();
			Assert.assertEquals(true,value);

		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_tc_006");
		}		
	}
	@Then("verify the Payments description is displayed")
	public void payments_displayed() throws Exception {
		try {
			browser_wait(30);
			click("help_paymentassert");
			browser_wait(90);
			value = driver.findElement(By.xpath(OR_reader( "help_paymentabout"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_tc_006");
		}
	}
	/*TC 007 - Validate that the 'Add coverage' title  should be present  and able to see description , when user click on Add coverage title   */
	@When("clicks on Add coverage  title")
	public void help_positive_tc_007() throws Exception {
		try {
			browser_wait(30);
			value = driver.findElement(By.xpath(OR_reader( "help_coverageassert"))).isDisplayed();
			Assert.assertEquals(true,value);

		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_tc_007");
		}	
	}
	@Then("verify the Add coverage description is displayed")
	public void addcoverage_displayed() throws Exception {
		try {
			browser_wait(20);
			click("help_coverageassert");
			browser_wait(50);
			value = driver.findElement(By.xpath(OR_reader( "help_coverageabout"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("logout");
			System.out.println("Help positive");
			driverquit();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_tc_007");
		}
	}
}