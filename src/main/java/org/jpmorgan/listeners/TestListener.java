package org.jpmorgan.listeners;

import org.jpmorgan.reporting.ExtentLogger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {


    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getThrowable().getMessage());


        String stackTrace = Arrays.toString(result.getThrowable().getStackTrace());
        stackTrace =  stackTrace.replaceAll(",","<br>");

        String detailsMsg = "<details>\n" +
                "  <summary> Click to see here:- </summary>\n" +
                stackTrace + " \n" +
                "</details>";
        ExtentLogger.logExceptionDetails(detailsMsg);

    }
}
