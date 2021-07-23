package Forgot_password_negative_scenarios;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.*;

public class Forgot_password_negative_scenarios extends Generic_function {
	public static String str;
	
	/* Browser  is launching , navigating to Landing Welcome Page  */
	@Given("Launch the URL")
	public static void browser_open() throws IOException {
		try{		
			Browser_Launch();
		}catch (Exception e) {
			e.printStackTrace();
		}	 
	}
	@When("Phone number field is blank")
	public void phonenumber_blank() throws IOException {
		driver.findElement(By.xpath(OR_reader("welcome_login"))).click();
		driver.findElement(By.xpath(OR_reader("forgot_password_link"))).click();
		driver.findElement(By.xpath(OR_reader("forgot_password_phone_no"))).click();
		driver.findElement(By.xpath(OR_reader("send_reset_link1"))).click();
		str= driver.findElement(By.xpath(OR_reader("phone_number_blank_valid_msg"))).getText();
	}
	/*TC_001 Validate that the user get the validation message when Phone number field is blank */
	@Then("Validate the error message when phone number is blank")
	public void forgot_password_negative_tc_001() throws IOException  {
		try {
			Assert.assertEquals(str,td_reader("forgot_password_phone_msg"));
			browser_wait(12);
			browser_refresh();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("forgot_password_negative_tc_001");
		}
	}

	/* TC_002 Validate that the user get the validation message on entering less than ten digit phone number */
	@When ("Enter less than ten digit phone number")
	public void enter_less_digits() throws IOException {
		driver.findElement(By.xpath(OR_reader("forgot_password_phone_no"))).sendKeys(td_reader("forgot_password_phone_no",0));
		driver.findElement(By.xpath(OR_reader("send_reset_link"))).click();
		str= driver.findElement(By.xpath(OR_reader("phone_number_valid_msg"))).getText();
		Assert.assertEquals(str,td_reader("forgot_less_ten_msg"));
	}
	@Then("Validate the error message for less than ten digits")
	public void forgot_password_negative_tc_002() throws IOException {
		try {
			browser_wait(12);	
			browser_refresh();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("forgot_password_negative_tc_002");
		}
	}

	/* TC_003 Validate that the user get the validation message on entering more than ten digit phone number */
	@When ("Enter more than ten digit phone number")
	public void enter_more_digits() throws IOException {
		driver.findElement(By.xpath(OR_reader( "forgot_password_phone_no"))).sendKeys(td_reader("forgot_password_phone_no",1));
		driver.findElement(By.xpath(OR_reader("send_reset_link"))).click();
		str= driver.findElement(By.xpath(OR_reader("phone_number_valid_msg"))).getText();
		Assert.assertEquals(str,td_reader("forgot_less_ten_msg"));
	}
	@Then("Validate the error message for more than ten digits")
	public void forgot_password_negative_tc_003() throws IOException {
		try {
			browser_wait(12);
			browser_refresh();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("forgot_password_negative_tc_003");
		}
	}
	
	/* TC_004 Validate that the Send Reset Link button is disabled when Phone number field is blank */
	@When("Reset Link button is disabled")
	public void forgot_password_negative_tc_004() throws IOException {
		try {
			Assert.assertEquals(driver.findElement(By.xpath(OR_reader("send_reset_link"))).isEnabled(),true);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("forgot_password_negative_tc_004");
		}		
	}

	/* TC_005 Validate that the user should able to get a validation message on entering non registered phone number in the phone number field */
	@Then("validate Phone number field is blank")
	public void forgot_password_negative_tc_005() throws IOException {
		try {
			driver.findElement(By.xpath(OR_reader("forgot_password_phone_no"))).sendKeys(td_reader("forgot_password_phone_no",2));
			driver.findElement(By.xpath(OR_reader("send_reset_link"))).click();
			str= driver.findElement(By.xpath(OR_reader("forgot_password_phoneno_exist_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("forgot_phone_no_exist_msg"));
			System.out.println("forgot negative");
			browser_close();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("forgot_password_negative_tc_005");
		}
	}


}

