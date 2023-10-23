package org.jpmorgan.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ReportUtils {

    private ReportUtils() {
    }

    public static String createReportNameWithTimeStamp() {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = dateTimeFormatter.format(localDateTime);
        formattedDateTime = "Test Report " + formattedDateTime + ".html";
        return formattedDateTime;

    }
}
