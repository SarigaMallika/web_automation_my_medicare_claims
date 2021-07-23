package Runner_Files;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "src\\main\\java\\Signup_negative_scenarios\\Signup_negative_scenarios.feature",
		glue= {"Signup_negative_scenarios"},
		monochrome = true,publish = true)
public class Signup_negative_scenarios_runner extends AbstractTestNGCucumberTests {

}
