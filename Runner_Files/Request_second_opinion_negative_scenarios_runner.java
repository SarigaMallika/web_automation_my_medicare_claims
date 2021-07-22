package Runner_Files;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "src\\main\\java\\Request_second_opinion_negative_scenarios\\Request_second_opinion_negative_scenarios.feature",
		glue= {"Request_second_opinion_negative_scenarios"},
		monochrome = true,publish = true)

public class Request_second_opinion_negative_scenarios_runner extends AbstractTestNGCucumberTests  {

}
