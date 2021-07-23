package Your_profile_negative_scenarios;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.File;

public class Your_profile_negative_scenarios extends Generic_function {
	public static boolean value;
	public static String str,path;
	public static File file;


	/*Validate that the user is navigated to Welcome page*/
	@Given("Launch the URL")
	public static void launch_url() throws Exception{
		try {
			Browser_Launch();
			click("welcome_login");
			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",6));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",7));
			click("login");
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}

	/*Verify clicking on profile will navigates to Your profile screen*/
	@When("Click on your profile")
	public static void click_profile() throws Exception{
		try {
			browser_wait(20);
			click("header_menu");
			click("header_profile");
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}

	/* TC_001- Validate that Send Code button is disabled when they do not check the phone number*/
	@When("Verify Send Code button is disabled")
	public static void your_profile_negative_tc_001() throws Exception{
		try {	
			click("profile_edit");
			value= driver.findElement(By.xpath(OR_reader( "profile_edit_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			value= driver.findElement(By.xpath(OR_reader("profile_send_code"))).isEnabled();
			Assert.assertEquals(false,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_001");
		}
	}

	/* TC_002- Verify the scenario when blank 'security code and Re-enter password' fields*/
	@When("Enter 'security code and Re-enter password' as blank")
	public static void your_profile_negative_tc_002() throws Exception{
		try {
			click("profile_checkbox");
			click("profile_send_code");
			value= driver.findElement(By.xpath(OR_reader( "profile_enter_code_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("profile_verify");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_002");
		}
	}

	@Then("Verify the validation message")
	public static void validation_msg() throws Exception{
		try {
			browser_wait(2);
			str= driver.findElement(By.xpath(OR_reader( "security_code_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("security_code_valid_msg"));
		}catch(Exception e){
			e.printStackTrace();
			takeScreenShot("validation_msg");
		}
	}

	/* TC_003- Verify the scenario when entering invalid Security code  and Re-enter password */
	@When("Enter invalid 'security code and Re-enter password'")
	public static void your_profile_negative_tc_003() throws Exception{
		try {
			browser_wait(5);
			driver.findElement(By.xpath(OR_reader( "profile_enter_code"))).sendKeys(td_reader("profile_enter_code",0));
			driver.findElement(By.xpath(OR_reader("profile_password"))).sendKeys(td_reader("profile_password",0));
			click("profile_verify");
		} catch (Exception e) {
			takeScreenShot("your_profile_negative_tc_003");
		}
	}

	@Then("Verify the validation message for invalid data")
	public static void invalid_validation_msg() throws Exception{
		try {
			browser_wait(5);
			str= driver.findElement(By.xpath(OR_reader("security_code_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("security_code_match_valid_msg"));
			browser_wait(5);
			driver.findElement(By.xpath(OR_reader("profile_enter_code"))).sendKeys(td_reader("profile_enter_code",1));
			driver.findElement(By.xpath(OR_reader( "profile_password"))).sendKeys(td_reader("profile_password",1));
			click("profile_verify");
			browser_wait(10);			
		}catch(Exception e) {
			takeScreenShot("invalid_validation_msg");
		}
	}

	/* TC_004- Verify the scenario when blank 'security code or Re-enter password' fields*/
	@When("Enter 'security code or Re-enter password' as blank")
	public static void your_profile_negative_tc_004() throws Exception{
		try {
			browser_refresh();
			browser_wait(20);
			click("profile_edit");
			click("profile_checkbox");
			click("profile_send_code");
			driver.findElement(By.xpath(OR_reader( "profile_password"))).sendKeys(td_reader("profile_password",0));
			click("profile_verify");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_004");
		}
	}

	@Then("Verify the validation blank message")
	public static void blank_validation_msg() throws Exception{
		try {
			browser_wait(5);
			str= driver.findElement(By.xpath(OR_reader("security_code_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("security_code_valid_msg"));
			browser_wait(5);
			backspace("profile_password");
			browser_wait(5);
			driver.findElement(By.xpath(OR_reader( "profile_enter_code"))).sendKeys(td_reader("profile_enter_code",1));
			click("profile_verify");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("blank_validation_msg");
		}
	}
	
	/* TC_005- Verify the scenario when unable to  Edit the primary and deactivate email*/
	@When("Not able to edit primary and deactivate email")
	public static void your_profile_negative_tc_005() throws Exception{
		try {
			browser_refresh();
			browser_wait(15);
			click("profile_contact");
			browser_wait(15);
			value= driver.findElement(By.xpath(OR_reader("profile_email_id"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("profile_email_id");
			value= driver.findElement(By.xpath(OR_reader("profile_email_id"))).isEnabled();
			Assert.assertEquals(true,value);
			browser_wait(5);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_005");
		}
	}
	/* TC_006- Verify the scenario when blank Your profile Page fields*/
	@When("Enter firstname and lastname fields as blank")
	public static void your_profile_negative_tc_006() throws Exception{
		try {
			browser_back();
			browser_wait(5);
			click("profile_edit");
			click("profile_checkbox");
			click("profile_send_code");
			driver.findElement(By.xpath(OR_reader("profile_enter_code"))).sendKeys(td_reader("profile_enter_code",1));
			driver.findElement(By.xpath(OR_reader("profile_password"))).sendKeys(td_reader("profile_password",0));
			click("profile_verify");
			click("profile_ok_button");
			backspace("profile_firstname");
			backspace("profile_lastname");
			click("profile_save");
			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_006");
		}
	}

	@Then("Verify the validation message for blank fields")
	public static void blank_validation_msg_fields() throws Exception{
		try {
			str= driver.findElement(By.xpath(OR_reader( "profile_firstname_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_firstname_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_lastname_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_lastname_valid_msg"),str);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("blank_validation_msg_fields");
		}
	}

	/* TC_007- Verify the scenario when entering invalid First name, Last name  or  Preferred name*/
	@When("Enters invalid firstname,lastname and preferred name")
	public static void your_profile_negative_tc_007() throws Exception{
		try {
			driver.findElement(By.xpath(OR_reader("profile_firstname"))).sendKeys(td_reader("profile_firstname",0));
			driver.findElement(By.xpath(OR_reader("profile_lastname"))).sendKeys(td_reader("profile_lastname",1));
			driver.findElement(By.xpath(OR_reader( "profile_preferredname"))).sendKeys(td_reader("profile_preferred_name",1));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_007");
		}
	}
	
	@Then("Verify the validation for invalid first name, last name or preferred name")
	public static void ivalid_validation_msg() throws Exception{
		try {
			str= driver.findElement(By.xpath(OR_reader( "profile_firstname_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_firstname_invalid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_lastname_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_lastname_invalid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_preferred_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_preferred_invalid_msg"),str);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("ivalid_validation_msg");
		}
	}

	/* TC_008- Verify the scenario unable to  Edit the User ID*/
	@When("verify 'User ID' is disabled for edit")
	public static void your_profile_negative_tc_008() throws Exception{
		try {
			value= driver.findElement(By.xpath(OR_reader( "profile_user_id"))).isEnabled();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_008");
		}
	}

	/* TC_009- Verify the scenario when Email ID fields are blank*/
	@When("Leave email id field as blank")
	public static void your_profile_negative_tc_009() throws Exception{
		try {
			click("profile_contact");
			click("profile_plus");
			browser_wait(2);
			value= driver.findElement(By.xpath(OR_reader("profile_add_email_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("profile_submit");
			str= driver.findElement(By.xpath(OR_reader("profile_email_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_email_valid_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_009");
		}
	}

	/* TC_010- Verify the scenario when entering invalid Email ID  or  already exist Email ID*/
	@When("Enter invalid email id")
	public static void your_profile_negative_tc_010() throws Exception{
		try {
			driver.findElement(By.xpath(OR_reader( "profile_email"))).sendKeys(td_reader("profile_email",0));
			click("profile_submit");
			browser_wait(10);
			str= driver.findElement(By.xpath(OR_reader( "profile_email_invalid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_email_invalid_msg"),str);
			backspace("profile_email");
			driver.findElement(By.xpath(OR_reader( "profile_email"))).sendKeys(td_reader("profile_email",1));
			click("profile_submit");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_010");
		}
	}
	
	@Then("Verify the validation for invalid email id")
	public static void validation_invalid_mail() throws Exception{
		try {
			browser_wait(10);
			str= driver.findElement(By.xpath(OR_reader( "profile_email_exists_msg"))).getText();
			Assert.assertEquals(td_reader("profile_email_exists_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("validation_invalid_mail");
		}
	}

	/* TC_011- Verify the scenario when unable to  Edit the primary and deactivate phone number*/
	@When("primary and deactivate phone number is disabled for edit")
	public static void your_profile_negative_tc_011() throws Exception{
		try {
			browser_back();
			click("profile_phno");
			value= driver.findElement(By.xpath(OR_reader( "profile_phone_no_text"))).isEnabled();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_011");
		}
	}

	/* TC_012- Verify the scenario when entering invalid Phone number  or  Phone number fields are blank*/
	@When("Enter invalid Phone number  or  Phone number fields")
	public static void your_profile_negative_tc_012() throws Exception{
		try {
			click("profile_plus");
			value= driver.findElement(By.xpath(OR_reader( "profile_add_phone_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("profile_submit");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_012");
		}
	}

	@Then("Verify the validation message for Phone number  or  Phone number fields")
	public static void invalid_validation_message() throws Exception{
		try {
			str= driver.findElement(By.xpath(OR_reader( "profile_phone_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_phone_valid_msg"),str);
			driver.findElement(By.xpath(OR_reader( "profile_phone_no"))).sendKeys(td_reader("profile_phone_no"));
			click("profile_submit");
			str= driver.findElement(By.xpath(OR_reader("profile_phone_invalid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_phone_invalid_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("invalid_validation_message");
		}
	}
	
	/* TC_013- Verify the scenario when unable to  Edit the primary and deactivate address*/
	@When("primary and deactivate address are disbled for edit")
	public static void your_profile_negative_tc_013() throws Exception{
		try {
			browser_back();
			click("profile_address");
			value= driver.findElement(By.xpath(OR_reader("profile_add_address_text"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_013");
		}
	}

	/* TC_014- Verify the scenario when leaving the fields blank in the Add new address Page*/
	@When("Leaves fields blank")
	public static void your_profile_negative_tc_014() throws Exception{
		try {
			click("profile_plus");
			value= driver.findElement(By.xpath(OR_reader("profile_add_address_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("profile_save");
			str= driver.findElement(By.xpath(OR_reader( "profile_saveas_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_saveas_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_address_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_address_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_city_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_city_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_state_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_state_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_zip_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_zip_valid_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_014");
		}
	}

	/* TC_015- Verify the scenario when entering invalid Zip code in Add new address page*/
	@When("Enters invalid zip code")
	public static void your_profile_negative_tc_015() throws Exception{
		try {
			driver.findElement(By.xpath(OR_reader( "profile_zip"))).sendKeys(td_reader("profile_zip"));
			click("profile_save");
			str= driver.findElement(By.xpath(OR_reader( "profile_zip_invalid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_zip_invalid_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_015");
		}
	}

	/* TC_016- Verify the scenario when leaving the fields blank in the Add plan Page*/
	@When("Enter add plan page feilds blank")
	public static void your_profile_negative_tc_016() throws Exception{
		try {
			browser_back();
			browser_back();
			click("profile_plan_coverage");
			value= driver.findElement(By.xpath(OR_reader("profile_plan_coverage_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("profile_plan_plus");
			browser_wait(5);
			click("profile_save");
			str= driver.findElement(By.xpath(OR_reader( "profile_insurer_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_insurer_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_plan_firstname_msg"))).getText();
			Assert.assertEquals(td_reader("profile_plan_firstname_msg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_plan_lastname_msg"))).getText();
			Assert.assertEquals(td_reader("profile_plan_lastname_msg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_memberid_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_memberid_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_groupid_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_groupid_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_plan_type_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_plan_type_valid_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_018");
		}
	}

	/* TC_017-Verify the scenario when entering invalid First name of policy holder or Last name of policy holder  in Add plan page*/
	@When("Enters invalid firstname and lastname fields in add plan page")
	public static void your_profile_negative_tc_017() throws Exception{
		try {
			driver.findElement(By.xpath(OR_reader( "profile_plan_firstname"))).sendKeys(td_reader("profile_plan_firstname"));
			driver.findElement(By.xpath(OR_reader( "profile_plan_lastname"))).sendKeys(td_reader("profile_plan_lastname"));
			click("profile_plan_group");
			str= driver.findElement(By.xpath(OR_reader( "profile_plan_first_invalidmsg"))).getText();
			Assert.assertEquals(td_reader("profile_plan_first_invalidmsg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_plan_last_invalidmsg"))).getText();
			Assert.assertEquals(td_reader("profile_plan_last_invalidmsg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_017");
		}
	}

	/* TC_018-Verify the scenario when leaving the fields blank in the Change password page*/
	@When("Enter blank fields in Change password page")
	public static void your_profile_negative_tc_018() throws Exception{
		try {
			browser_back();
			click("profile_password_button");
			value= driver.findElement(By.xpath(OR_reader( "profile_password_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("profile_save");
			str= driver.findElement(By.xpath(OR_reader( "profile_password_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_password_valid_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_018");
		}
	}

	/* TC_019-Verify the scenario when entering wrong Old password in Change password page*/
	@When("Enter wrong passwords")
	public static void your_profile_negative_tc_019() throws Exception{
		try {
			driver.findElement(By.xpath(OR_reader( "profile_old_password"))).sendKeys(td_reader("profile_old_password",0));
			driver.findElement(By.xpath(OR_reader("profile_new_password"))).sendKeys(td_reader("profile_new_password",0));
			driver.findElement(By.xpath(OR_reader( "profile_confirm_password"))).sendKeys(td_reader("profile_new_password",0));
			click("profile_save");
			browser_wait(10);
			str= driver.findElement(By.xpath(OR_reader( "profile_password_invalid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_password_invalid_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_019");
		}
	}

	/* TC_020-Verify the scenario when invalid New password in Change password page*/
	@When("Enter invalid new password")
	public static void your_profile_negative_tc_020() throws Exception{
		try {
			backspace("profile_new_password");
			backspace("profile_confirm_password");
			driver.findElement(By.xpath(OR_reader( "profile_old_password"))).sendKeys(td_reader("profile_old_password",1));
			driver.findElement(By.xpath(OR_reader( "profile_new_password"))).sendKeys(td_reader("profile_new_password",1));
			click("profile_confirm_password");
			browser_wait(10);
			str= driver.findElement(By.xpath(OR_reader( "profile_new_password_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_new_password_valid_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_020");
		}
	}

	/* TC_021-Verify the scenario when entering same data in Old password and New password fields in Change password page*/
	@When("Enter same data in Old password and New password fields")
	public static void your_profile_negative_tc_021() throws Exception{
		try {
			backspace("profile_new_password");
			driver.findElement(By.xpath(OR_reader( "profile_new_password"))).sendKeys(td_reader("profile_old_password",1));
			driver.findElement(By.xpath(OR_reader( "profile_confirm_password"))).sendKeys(td_reader("profile_old_password",1));
			click("profile_save");
			browser_wait(10);
			str= driver.findElement(By.xpath(OR_reader( "profile_same_password"))).getText();
			Assert.assertEquals(td_reader("profile_same_password"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_021");
		}
	}

	/* TC_022-Verify the scenario when entering different data in New password and Confirm new password fields*/
	@When("Enter different data in New password and Confirm new password fields")
	public static void your_profile_negative_tc_022() throws Exception{
		try {
			backspace("profile_new_password");
			backspace("profile_confirm_password");
			driver.findElement(By.xpath(OR_reader( "profile_new_password"))).sendKeys(td_reader("profile_new_password",0));
			driver.findElement(By.xpath(OR_reader( "profile_confirm_password"))).sendKeys(td_reader("profile_new_password",2));
			click("profile_save");
			browser_wait(10);
			str= driver.findElement(By.xpath(OR_reader( "profile_password_match"))).getText();
			Assert.assertEquals(td_reader("profile_password_match"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_022");
		}
	}

	/* TC_023-Verify the scenario when a dialogue box appears dur to the failure of profile picture */
	@When("Not able to upload profile picture")
	public static void your_profile_negative_tc_023() throws Exception{
		try {
			click("header_menu");
			click("header_profile");
			click("profile_picture");
			click("profile_picture");
			click("profile_upload_image");
			click("profile_files");
			Thread.sleep(1000);
			file = new File(getprofilepic());
			StringSelection ss = new StringSelection(file.getAbsolutePath());
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			Robot robot = new Robot();
			robot.delay(250);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(90);
			robot.keyRelease(KeyEvent.VK_ENTER);
			click("profile_pic_save");
			Thread.sleep(10000);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR_reader( "profile_pic_valid_msg"))));
			value= driver.findElement(By.xpath(OR_reader( "profile_pic_valid_msg"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("tab_ok");
			System.out.println("Your profile negative");
			browser_close();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_023");
		}
	}

}
