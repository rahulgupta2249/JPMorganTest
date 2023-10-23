package org.jpmorgan.stepdefinitions;

import io.cucumber.java.*;
import org.jpmorgan.reporting.ExtentLogger;
import org.jpmorgan.reporting.ExtentReport;

public class Hooks {

    @Before
    public void beforeEachScenario(Scenario scenario) {

        ExtentReport.createTest(scenario.getName());
        ExtentLogger.info("SCENARIO NAME: " + scenario.getName());
    }

    @After
    public void afterEachScenario(Scenario scenario) {

        if (scenario.getStatus().name().equalsIgnoreCase("PASSED")) {
            ExtentLogger.pass(scenario.getName() + " is passed");
        } else if (scenario.isFailed()) {
            ExtentLogger.fail(scenario.getName() + " is failed");


        }
    }

    @BeforeAll
    public static void setUp() {
        ExtentReport.setUp();
    }

    @AfterAll
    public static void tearDown() {
        ExtentReport.tearDown();
    }
}
