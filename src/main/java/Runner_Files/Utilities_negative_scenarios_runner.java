package Runner_Files;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "src\\main\\java\\Utilities_negative_scenarios\\Utilities_negative_scenarios.feature",
		glue= {"Utilities_negative_scenarios"},
		monochrome = true,publish = true)

public class Utilities_negative_scenarios_runner extends AbstractTestNGCucumberTests {

}
