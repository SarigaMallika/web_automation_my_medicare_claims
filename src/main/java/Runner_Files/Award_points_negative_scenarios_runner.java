package Runner_Files;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "src\\main\\java\\Award_points_negative_scenarios\\Award_points_negative_scenarios.feature",
		glue= {"Award_points_negative_scenarios"},
		monochrome = true,publish = true)
public class Award_points_negative_scenarios_runner extends AbstractTestNGCucumberTests{

}
