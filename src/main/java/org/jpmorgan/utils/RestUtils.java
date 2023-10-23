package org.jpmorgan.utils;

import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.jpmorgan.reporting.ExtentLogger;

import java.util.Map;

/**
 * This class is to interact with Rest Services using Rest Assured Library.
 * Logging the Request & Response Details in Extent Report
 * Creating a common Request Specification & Response Specification
 */
public class RestUtils {

    static void printRequestDetailsInReport(RequestSpecification requestSpecification) {

        QueryableRequestSpecification query = SpecificationQuerier.query(requestSpecification);

        ExtentLogger.info("End Point is: " + query.getBaseUri());
        ExtentLogger.info("Request Method is: " + query.getMethod());
        ExtentLogger.info("Rest Parameters are :" + query.getPathParams());
        ExtentLogger.info("Headers are: ");

        ExtentLogger.logDetailsInTabularFormat(query.getHeaders().asList());
        ExtentLogger.info("Request Body is: ");
        ExtentLogger.logDetailsInJsonFormat(query.getBody());

    }

    static void printRequestDetailsInReportWithoutHeaders(RequestSpecification requestSpecification) {

        QueryableRequestSpecification query = SpecificationQuerier.query(requestSpecification);

        ExtentLogger.info("End Point is: " + query.getBaseUri());
        ExtentLogger.info("Request Method is: " + query.getMethod());
        ExtentLogger.info("Request Body is: ");
        ExtentLogger.logDetailsInJsonFormat(query.getBody());

    }

    static void printRequestDetailsInReportWithoutBody(RequestSpecification requestSpecification) {

        QueryableRequestSpecification query = SpecificationQuerier.query(requestSpecification);

        ExtentLogger.info("End Point is: " + query.getBaseUri());
        ExtentLogger.info("Request Method is: " + query.getMethod());
        ExtentLogger.info("Rest Parameters are :" + query.getPathParams());
        ExtentLogger.info("Headers are: ");

        ExtentLogger.logDetailsInTabularFormat(query.getHeaders().asList());

    }

    static void printResponseDetailsInReport(Response response) {


        ExtentLogger.info("Response Status Code is: " + response.getStatusCode());
        ExtentLogger.info("Response Status Line is: " + response.getStatusLine());
        ExtentLogger.info("Response Headers are: ");
        ExtentLogger.logDetailsInTabularFormat(response.getHeaders().asList());
        ExtentLogger.info("Response Body is :");
        ExtentLogger.logDetailsInJsonFormat(response.getBody().prettyPrint());
    }

    static void printResponseDetailsInReportWithoutHeaders(Response response) {


        ExtentLogger.info("Response Status Code is: " + response.getStatusCode());
        ExtentLogger.info("Response Status Line is: " + response.getStatusLine());

        ExtentLogger.info("Response Body is :");
        ExtentLogger.logDetailsInJsonFormat(response.getBody().prettyPrint());
    }

    static void printResponseDetailsInReportWithOutBody(Response response) {


        ExtentLogger.info("Response Status Code is: " + response.getStatusCode());
        ExtentLogger.info("Response Status Line is: " + response.getStatusLine());
        ExtentLogger.info("Response Headers are: ");
        ExtentLogger.logDetailsInTabularFormat(response.getHeaders().asList());

    }

    //Creating method to perform a POST Operation.
    public static Response performPost(RequestSpecification requestSpecification, Object requestPayload, Map<String, String> headers, String uri) {

        Response response = requestSpecification
                .headers(headers)
                .body(requestPayload)
                .when()
                .post(uri);
        printRequestDetailsInReport(requestSpecification);
        printResponseDetailsInReport(response);
        return response;
    }

    public static Response performPost(RequestSpecification requestSpecification, Object requestPayload, String uri) {

        Response response = requestSpecification
                .body(requestPayload)
                .when()
                .post(uri);
        printRequestDetailsInReportWithoutHeaders(requestSpecification);
        printResponseDetailsInReportWithoutHeaders(response);
        return response;
    }

    public static Response retrieveUsersList(RequestSpecification requestSpecification, String uri) {

        Response response = requestSpecification.when()
                .get(uri);

        printRequestDetailsInReportWithoutBody(requestSpecification);
        printResponseDetailsInReportWithOutBody(response);
        return response;

    }


}
