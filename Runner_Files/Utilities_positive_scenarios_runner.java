package Runner_Files;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "src\\main\\java\\Utilities_positive_scenarios\\Utilities_positive_scenaros.feature",
		glue= {"Utilities_positive_scenarios"},
		monochrome = true,publish = true)

public class Utilities_positive_scenarios_runner  extends AbstractTestNGCucumberTests{

}
