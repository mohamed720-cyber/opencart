package Runnerforall;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
/*
 * this runner class for all the feature file
 */
@CucumberOptions(features= {"src/test/resources/Featurefiles/account_registration.feature","src/test/resources/Featurefiles/login.feature","src/test/resources/Featurefiles/search.feature"},glue="Step_Definitions",plugin = {"pretty", "html:target/finalreport.html"})
public class RunnerForAll_features extends AbstractTestNGCucumberTests {

}
