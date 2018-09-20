package integrationTest.test;

import cucumber.api.CucumberOptions;

@CucumberOptions(
		features="src/resources/Feature",
		glue={"com.RBS.AutomationPactice.src.integrationTest.stepDefinition"},
		monochrome=true,
		tags={"@tc1","@tc2"}
		)

public class TestRunner {
	
}
