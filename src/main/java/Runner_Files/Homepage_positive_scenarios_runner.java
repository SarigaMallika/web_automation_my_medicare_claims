package Runner_Files;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "src\\main\\java\\Homepage_positive_scenarios\\Homepage_positive_scenarios.feature",
		glue= {"Homepage_positive_scenarios"},
		monochrome = true,publish = true)

public class Homepage_positive_scenarios_runner extends AbstractTestNGCucumberTests {

}
