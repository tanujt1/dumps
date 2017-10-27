package specs;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/specs/Billing.feature"
		,glue={"src/test.Steps/"}
		)

public class TestRunner {

}
