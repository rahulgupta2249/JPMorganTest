package org.jpmorgan.reporting;


import com.aventstack.extentreports.ExtentTest;


public final class ExtentReportManager {

    private ExtentReportManager() {
    }

    private static final ThreadLocal<ExtentTest> atm = new ThreadLocal<>();

    static void setExtentTest(ExtentTest extentTest) {
        atm.set(extentTest);
    }

    static ExtentTest getExtentTest() {
        return atm.get();
    }

    static void removeExtentTest() {
        atm.remove();
    }
}
