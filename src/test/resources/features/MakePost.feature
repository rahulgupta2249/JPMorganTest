Feature: Verify that users are able to make Posts successfully
  Description: The purpose of this feature to verify making Posts successfully

  Scenario: Successful Post Creation
    Given the JSONPlaceholder API is available
    When a POST request is sent to "/posts" URI
    Then the response status code should be 201
    And the response body should contain a new post with the provided data


    Scenario: Post Creation using Wrong URI
      Given the JSONPlaceholder API is available
      When a POST request is sent to "/pfdjbfs" URI
      Then the response status code should be 4044