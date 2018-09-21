package integrationTest.test;

<<<<<<< HEAD
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/resources/Feature",
		glue={"src/integrationTest/stepDefinition"}
		//monochrome=true,
		//tags={"@tc1","@tc2"}
=======
import cucumber.api.CucumberOptions;

@CucumberOptions(
		features="src/resources/Feature",
		glue={"com.RBS.AutomationPactice.src.integrationTest.stepDefinition"},
		monochrome=true,
		tags={"@tc1","@tc2"}
>>>>>>> 5300c7dfb5ef923bff582fb43e688eca870f776d
		)

public class TestRunner {
	
}
