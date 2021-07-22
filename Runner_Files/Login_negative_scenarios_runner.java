package Runner_Files;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "src\\main\\java\\Login_negative_scenarios\\Login_negative_scenarios.feature",
		glue= {"Login_negative_scenarios"},
		monochrome = true,publish = true)


public class Login_negative_scenarios_runner extends AbstractTestNGCucumberTests {	
}

