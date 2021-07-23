package Runner_Files;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "src\\main\\java\\Circles_negative_scenarios\\Circles_negative_scenarios.feature",
		glue= {"Circles_negative_scenarios"},
		monochrome = true,publish = true)

public class Circles_negative_scenarios_runner extends AbstractTestNGCucumberTests {

}
