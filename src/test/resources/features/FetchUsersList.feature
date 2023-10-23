Feature: Verify that users are able to fetch users successfully
  Description: The purpose of this feature to verify the retrieving the users successfully

  Background: Verify API is available
    Given the JSONPlaceholder API is available

  Scenario: Successfully retrieving the list of users
    When a GET request is sent to "/users" URI
    Then the response status code should be 200
    And the response body should retrieve the list of users with the provided data

  Scenario: Retrieving Users on Wrong URI
    When a GET request is sent to "/userss" URI
    Then the response status code should be 404