package org.jpmorgan.reporting;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import java.util.List;


public final class ExtentLogger {

    private ExtentLogger() {

    }

    public static void pass(String message) {
        ExtentReportManager.getExtentTest().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
    }

    public static void fail(String message) {
        ExtentReportManager.getExtentTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
    }

    public static void info(String message) {
        ExtentReportManager.getExtentTest().info(MarkupHelper.createLabel(message, ExtentColor.BLUE));
    }

    public static void logExceptionDetails(String message) {
        ExtentReportManager.getExtentTest().fail(message);
    }

    public static void logDetailsInJsonFormat(String json) {
        ExtentReportManager.getExtentTest().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }

    public static <T> void logDetailsInTabularFormat(List<T> headers) {

        String[][] strings = headers.stream().map(str -> new String[]{}).toArray(String[][]::new);
        ExtentReportManager.getExtentTest().info(MarkupHelper.createTable(strings));
    }


}
