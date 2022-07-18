package Runnerclass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
/*
 * this is the runner class for search feature file.
 */
@CucumberOptions(tags="@search",features="src/test/resources/Featurefiles/search.feature",glue="Step_Definitions",plugin = {"pretty", "html:target/Search.html"})
public class Search_Runner extends AbstractTestNGCucumberTests {

}
