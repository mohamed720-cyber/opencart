package Runnerclass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
/*
 * this is the runner class for account registration feature file
 */
@CucumberOptions(tags="@register",features="src/test/resources/Featurefiles/account_registration.feature",glue="Step_Definitions",plugin = {"pretty", "html:target/registration.html"})
public class RegisterRunner extends AbstractTestNGCucumberTests {

}
