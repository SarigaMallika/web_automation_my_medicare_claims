package Runner_Files;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","pretty","html:target/html", "json:target/cucumber.json"}},
		features = "src\\main\\java\\My_medicare_claims_positive_scenario\\My_medicare_claims_positive_scenario.feature",
		glue= {"My_medicare_claims_positive_scenario"},
		monochrome = true,publish = true)
public class My_medicare_claims_positive_scenario extends AbstractTestNGCucumberTests{

}

