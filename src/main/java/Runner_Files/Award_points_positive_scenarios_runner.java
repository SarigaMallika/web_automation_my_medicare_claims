package Runner_Files;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "src\\main\\java\\Award_points_positive_scenarios\\Award_points_positive_scenarios.feature",
		glue= {"Award_points_positive_scenarios"},
		monochrome = true,publish = true)

public class Award_points_positive_scenarios_runner extends AbstractTestNGCucumberTests {
}