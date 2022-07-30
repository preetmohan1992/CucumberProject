package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//tags= {"@LoginFeature"},
		features= "src/test/java/features", // path of the feature file
		glue="test/java/stepDefinitions", // path of the step definition file
		dryRun= true, // to check the mapping is proper between feature files and step definition file 
		monochrome= true, // to display the console output in readable format
		//strict = true, // check if any step is not defined in the step definition file
		plugin= {"pretty", "html:test-output"}
		//tags = {"@Sanity"}
		
		)


public class NewTestRunner 

{
	
}
