package Runner_Files;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "src\\main\\java\\Refer_a_friend_positive_scenarios\\Refer_a_friend_positive_scenarios.feature",
		glue= {"Refer_a_friend_positive_scenarios"},
		monochrome = true,publish = true)

public class Refer_a_friend_positive_scenarios_runner extends AbstractTestNGCucumberTests {

}
