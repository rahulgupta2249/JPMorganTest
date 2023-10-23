package org.jpmorgan.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.jpmorgan.payload.CommentOnPostPayload;
import org.jpmorgan.payload.MakePostPayload;
import org.jpmorgan.payload.Payload;
import org.jpmorgan.utils.APIUtils;
import org.jpmorgan.utils.RestUtils;
import org.jpmorgan.constants.FrameworkConstants;
import org.jpmorgan.managers.FileReaderManager;
import org.jpmorgan.models.CommentOnPostDTO;
import org.jpmorgan.models.MakePostDTO;

import java.util.concurrent.TimeUnit;

public class Steps {

    private RequestSpecification requestSpecification;
    private Response response;

    @Given("the JSONPlaceholder API is available")
    public void the_json_placeholder_api_is_available() {
        // Write code here that turns the phrase above into concrete actions

         requestSpecification = RestAssured.given()
                .baseUri(FileReaderManager.getInstance().getConfigReader().getURL());
    }
    @When("a POST request is sent to {string} URI")
    public void a_post_request_is_sent_to_uri(String uri) {
        // Write code here that turns the phrase above into concrete actions
        Payload<MakePostDTO> payload = new MakePostPayload();
        MakePostDTO payloadFromPojo = payload.createPayloadFromDTO();
        response = RestUtils.performPost(requestSpecification, payloadFromPojo, uri);
    }

    @When("Commenting on Post request is sent to {string} URI")
    public void commentingOnPostRequestIsSentToURI(String uri) {
        Payload<CommentOnPostDTO> payload = new CommentOnPostPayload();
        CommentOnPostDTO payloadFromPojo1 = payload.createPayloadFromDTO();
         response = RestUtils.performPost(requestSpecification, payloadFromPojo1, uri);
    }
    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer statusCode) {
        // Write code here that turns the phrase above into concrete actions
        response
                .then()
                .statusCode(statusCode)
                .time(Matchers.lessThan(4L), TimeUnit.SECONDS);
    }
    @Then("the response body should contain a new post with the provided data")
    public void the_response_body_should_contain_a_new_post_with_the_provided_data() {
        // Write code here that turns the phrase above into concrete actions
        response
                .then()
                .body("id", Matchers.notNullValue());

    }

    @When("a GET request is sent to {string} URI")
    public void a_get_request_is_sent_to_uri(String uri) {

        response = RestUtils.retrieveUsersList(requestSpecification, uri);

    }
    @Then("the response body should retrieve the list of users with the provided data")
    public void the_response_body_should_retrieve_the_list_of_users_with_the_provided_data() {
        // Write code here that turns the phrase above into concrete actions
        String expectedJson = APIUtils.readJSONAndGetAsString(FrameworkConstants.getJSONFILEPATH());
        response
                .then()
                .body(Matchers.equalTo(expectedJson));
    }


}
