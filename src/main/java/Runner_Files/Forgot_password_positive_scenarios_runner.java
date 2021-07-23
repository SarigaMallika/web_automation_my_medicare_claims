package Runner_Files;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "src\\main\\java\\Forgot_password_positive_scenarios\\Forgot_password_positive_scenarios.feature",
		glue= {"Forgot_password_positive_scenarios"},
		monochrome = true,publish = true)
public class Forgot_password_positive_scenarios_runner extends AbstractTestNGCucumberTests {

}
