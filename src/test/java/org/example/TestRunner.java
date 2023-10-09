package org.example;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"StepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports/Cucumber.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
