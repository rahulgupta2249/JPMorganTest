package org.jpmorgan.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.jpmorgan.constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


public final class ExtentReport {

    private ExtentReport() {

    }

    public static ExtentReports extent;
    private static ExtentTest extentTest;

    public static void setUp() {
        if (Objects.isNull(extent)) {

            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(new File(FrameworkConstants.getREPORT_PATH()));

            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("JP Morgan Automation Report");
            spark.config().setReportName("JSON Place Holder API Request");
            extent.attachReporter(spark);
        }

    }

    public static void tearDown() {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        ExtentReportManager.removeExtentTest();

        try {
            Desktop.getDesktop().browse(new File(FrameworkConstants.getREPORT_PATH()).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createTest(String testName) {
        if (Objects.isNull(ExtentReportManager.getExtentTest())) {
            extentTest = extent.createTest(testName);
            ExtentReportManager.setExtentTest(extentTest);
        }
    }


}
