package RunnerCare;

import org.junit.*;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber"},
        features = {"src/main/resources"},
        glue= {"functionDef"}
        
        ) 

public class RunnerControl {

	
	
}
