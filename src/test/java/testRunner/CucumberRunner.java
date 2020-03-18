package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue={"StepDefinition"},
        plugin = { 
        				"pretty" ,"html:target/cucumber-reports"
        				,"json:target/cucumber-report/cucumber.json"},
//        plugin = { "usage" },
//        tags = {"@P2"},
        strict = true,
       monochrome = true
)

public class CucumberRunner {
   

}