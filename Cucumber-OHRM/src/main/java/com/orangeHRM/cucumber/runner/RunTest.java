package com.orangeHRM.cucumber.runner;


/* import org.junit.runner.RunWith;

import io.cucumber.testng.CucumberOptions;


@RunWith(Cucumber.class)
	
	@CucumberOptions(
		    features = "src/main/java/features",
		    glue = {"steps", "hooks"},       
		    monochrome = true,
		    	    plugin = {"pretty","html:target/cucumber-reports/cucumber.html"},
		    tags = "@Smoke or @Regression"   
		)
		public class RunTest {
		   
		}*/
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/main/java/com/orangeHRM/cucumber/features",
    glue = {"com.orangeHRM.cucumber.steps", "com.orangeHRM.cucumber.hooks"},
    monochrome = true,
    plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"},
    tags = "@Smoke or @Regression"
)
public class RunTest extends AbstractTestNGCucumberTests {

}
