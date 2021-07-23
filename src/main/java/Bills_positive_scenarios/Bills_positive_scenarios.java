package Bills_positive_scenarios;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Bills_positive_scenarios extends Generic_function{
	public static boolean value;
	public static String str,text,driver_name;
	public static WebElement from,to;

	/*Validate that the user is navigated to Welcome page*/
    @Given("Launch the URL")
	public void browser_launching() throws Exception {
		try {
			Browser_Launch();
			browser_wait(12);
			click("welcome_login");
			browser_wait(12);
			driver.findElement(By.xpath(OR_reader( "login_phone_number"))).sendKeys(td_reader("login_phone_number",6));
			driver.findElement(By.xpath(OR_reader( "login_password"))).sendKeys(td_reader("login_password",7));
			click("login");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("browser launching");
		}
	}

	/*TC 001 -Validate navigation to bills page*/
	@When("Click on 'Bills'")
	public void bills_positive_tc_001() throws Exception {
		try {
			browser_wait(20);
			click("services");
			click("bills_title_services");
		} catch (IOException e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_tc_001");
		}
	}
    
	@Then("Verify user navigated to bills page")
	public void navigate_to_bills() throws Exception {
		try {
			browser_wait(20);
			value = driver.findElement(By.xpath(OR_reader("bills_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (IOException e) {
			e.printStackTrace();
			takeScreenShot("navigate_to_bills");
		}
	}
	
	/*TC 002 - Verify the scenario to view Total bills due*/
	@When("'Total bills due' visible on the page")
	public void bills_positive_tc_002() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("bills_due_amount"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_negative_tc_002");
		}	
	}
	
	@And("'Amount' visible on the page")
	public void amount_visible() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("bills_due_amount_dollar"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("amount_visible");
		}	
	}

	/*TC 003 - Validate by selecting Newest option from the dropdown*/
	@When("Click on dropdown")
	public void bills_positive_tc_003() throws Exception {
		try {
			click("bills_dropdown");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_tc_003");
		}	
	}
	
	@Then("Select 'Newest'")
	public void select_newest() throws Exception {
		try {
			text = td_reader("bills_dropdown_option");
			drop_down(OR_reader( "bills_dropdown_box"),text);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("select_newest");
		}	
	}
	
	/*TC 004 - Validate view bills as two sections*/
	@When("Click on 'Due' section")
	public void bills_positive_tc_004() throws Exception {
		try {
			click_javascript("bills_due_section");
			value = driver.findElement(By.xpath(OR_reader( "bills_due_message"))).isDisplayed();
			Assert.assertEquals(true,value);
			click_javascript("bills_paid_section");
			value = driver.findElement(By.xpath(OR_reader( "bills_paid_message"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_tc_004");
		}	
	}
	
	@And("Click on 'Paid' section")
	public void click_paid_section() throws Exception {
		try {
			click_javascript("bills_paid_section");
			value = driver.findElement(By.xpath(OR_reader( "bills_paid_message"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("click_paid_section");
		}	
	}
	
	/*TC 005 - Validate slide the grid below the Bills page title.*/
	@When("Slide through 'Total bills due'")
	public void bills_positive_tc_005() throws Exception {
		try {
			from = driver.findElement(By.xpath(OR_reader( "bills_carousel_from")));
			to = driver.findElement(By.xpath(OR_reader( "bills_carousel_to")));
			driver_name = browser_name();
			if(driver_name.equals("geck"))
			{
				firefox_slide(from);
			}
			else{
				chrome_edge_slide(from,to);
			}
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_tc_005");
		}
	}

	@Then("Validate  'Your expenses' grid is visible")
	public void your_expense_grid() throws Exception {
		try {
			browser_wait(30);
			value = driver.findElement(By.xpath(OR_reader( "bills_carousel_to"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_expense_grid");
		}
	}
	
	/*TC 006 - Validate'Pay a Bill' button*/
	@When("Click on 'Pay a Bill' button")
	public void bills_positive_tc_006() throws Exception {
		try {
			click("bills_pay_a_bill_button");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_tc_006");
		}	
	}
	
	@Then("Validate navigation to bill due section")
	public void validation_bills_due_section() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader( "bills_due_message"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("validation_bills_due_section");
		}	
	}

	/*TC 007 - Validate Explore Services button*/
	@When("Click on 'Explore Services' button")
	public void bills_positive_tc_007() throws Exception {
		try {
			from = driver.findElement(By.xpath(OR_reader( "bills_carousel_from")));
			to = driver.findElement(By.xpath(OR_reader( "bills_carousel_to")));
			driver_name = browser_name();
			if(driver_name.equals("geck"))
			{
				firefox_slide(from);
			}
			else{
				chrome_edge_slide(from, to);
			}
			click("bills_explore_services_button");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_tc_007");
		}	
	}
	
	@Then("Validate navigation to Services dashboard")
	public void navigation_service_page() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("services_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("navigation_service_page");
		}	
	}

	/*TC 008 - Validate that the user will get validation message when expense is $0*/
	@When("Shows validation message 'you have no expenditures yet'")
	public void bills_positive_tc_008() throws Exception {
		try {
			click("services");
			click("bills_title_services");
			from = driver.findElement(By.xpath(OR_reader("bills_carousel_from")));
			to = driver.findElement(By.xpath(OR_reader("bills_carousel_to")));
			driver_name = browser_name();
			if(driver_name.equals("geck"))
			{
				firefox_slide(from);
			}
			else{
				chrome_edge_slide(from, to);
			}
			str= driver.findElement(By.xpath(OR_reader("bills_zero_expenditure_msg"))).getText();
			Assert.assertEquals(str,td_reader("bills_zero_expenditure_msg"));
			value = driver.findElement(By.xpath(OR_reader( "bills_zero_expenditure_img"))).isDisplayed();
			Assert.assertEquals(true,value);
			System.out.println("Bills positive");
			browser_close();
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_tc_008");
		}	
	}
}
