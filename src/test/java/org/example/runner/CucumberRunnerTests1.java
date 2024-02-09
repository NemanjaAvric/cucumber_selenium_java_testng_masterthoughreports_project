package org.example.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"src/test/resources/features"}, glue = {"org.example.step_definitions"},
        plugin = {"pretty", "json:target/test-output/json-report/cucumber.json"},
        dryRun = false,
        monochrome = true)
//  tags = "@P500",
//  name = "Item")

public class CucumberRunnerTests1 extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
