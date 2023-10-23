package org.jpmorgan.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = "src/test/resources/features", glue = "org.jpmorgan.stepdefinitions",
        monochrome = true,
        plugin = {"html:target/cucumber-html.html", "json:target/cucumber-json.json"}
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
