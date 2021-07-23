package Runner_Files;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "src\\main\\java\\Second_opinion_dashboard_positive_scenarios\\Second_opinion_dashboard_positive_scenarios.feature",
		glue= {"Second_opinion_dashboard_positive_scenarios"},
		monochrome = true,publish = true)
public class Second_opinion_dashboard_positive_scenarios_runner extends AbstractTestNGCucumberTests {

}
