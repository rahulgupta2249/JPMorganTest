package org.jpmorgan.constants;

import lombok.Getter;
import org.jpmorgan.utils.ReportUtils;

/**
 * Defined a constant class to read the path of test data
 */
public final class FrameworkConstants {

    private static  final String BASEPATH = System.getProperty("user.dir") +"/src/test/resources/";

    private static @Getter final String CONFIGFILEPATH = BASEPATH + "config/Configuration.properties";

    private static @Getter final String JSONFILEPATH = BASEPATH + "jsons/ListOfUsers.json";
    @Getter
    private static final String EXTENT_REPORT_PATH = System.getProperty("user.dir") + "/extent-test-output/";

    @Getter
    private static final String REPORT_PATH = EXTENT_REPORT_PATH + ReportUtils.createReportNameWithTimeStamp();

}
