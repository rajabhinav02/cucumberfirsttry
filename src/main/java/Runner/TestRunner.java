package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;

//import org.junit.runner.RunWith;

import io.cucumber.testng.CucumberOptions;
 

//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features= "C:\\Users\\Punam\\eclipse-workspace\\cucumberfirst\\src\\main\\java\\feature", 
		glue= {"StepDefinitions"},
		//plugin= {"pretty","html:test-output"},
		dryRun=true,
		strict=true,
		monochrome=true
		)
public class TestRunner extends AbstractTestNGCucumberTests  {


	
}
