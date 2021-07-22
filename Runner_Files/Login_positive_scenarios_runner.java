package Runner_Files;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "src\\main\\java\\Login_positive_scenarios\\Login_positive_scenarios.feature",
		glue= {"Login_positive_scenarios"},
		monochrome = true,publish = true)
public class Login_positive_scenarios_runner extends AbstractTestNGCucumberTests {

}
