package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
tags="@smoke", 
features = {"src/test/resources/Feature"}, 
glue = {"com.stepDefinitions"},
plugin ={"pretty","html:target/htmlreport.html"})


public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}

