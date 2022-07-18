package Runnerclass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="@valid",features="src/test/resources/Featurefiles/login.feature",glue="Step_Definitions",plugin = {"pretty", "html:target/Login.html","junit:target/report.xml"})
public class LoginRunner extends AbstractTestNGCucumberTests {

}
