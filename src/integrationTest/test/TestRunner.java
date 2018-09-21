package integrationTest.test;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/resources/Feature",
		glue={"src/integrationTest/stepDefinition"}
		//monochrome=true,
		//tags={"@tc1","@tc2"}
		)

public class TestRunner {
	
}
