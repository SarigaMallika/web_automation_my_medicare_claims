package Runner_Files;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "src\\main\\java\\Signup_positive_scenarios\\Signup_positive_scenarios.feature",
		glue= {"Signup_positive_scenarios"},
		monochrome = true,publish = true)
public class Signup_positive_scenarios_runner extends AbstractTestNGCucumberTests {

}
