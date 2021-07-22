package Runner_Files;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "src\\main\\java\\Landing_welcome_positive_scenarios\\Landing_welcome_positive_scenarios.feature",
		glue= {"Landing_welcome_positive_scenarios"},
		monochrome = true,publish = true)
public class Landing_welcome_positive_scenarios_runner extends AbstractTestNGCucumberTests{

}
