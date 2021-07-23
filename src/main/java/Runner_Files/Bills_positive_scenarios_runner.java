package Runner_Files;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "src\\main\\java\\Bills_positive_scenarios\\Bills_positive_scenarios.feature",
		glue= {"Bills_positive_scenarios"},
		monochrome = true,publish = true)

public class Bills_positive_scenarios_runner extends AbstractTestNGCucumberTests  {

}
