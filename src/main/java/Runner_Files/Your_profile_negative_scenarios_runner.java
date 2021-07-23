package Runner_Files;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "src\\main\\java\\Your_profile_negative_scenarios\\Your_profile_negative_scenarios.feature",
		glue= {"Your_profile_negative_scenarios"},
		monochrome = true,publish = true)
public class Your_profile_negative_scenarios_runner extends AbstractTestNGCucumberTests  {

}
