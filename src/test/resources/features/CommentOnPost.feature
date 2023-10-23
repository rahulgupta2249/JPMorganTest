Feature: Verify that users are able to make comment on Posts successfully
  Description: The purpose of this feature to verify commenting on Posts successfully

  Background: Verify API is available
    Given the JSONPlaceholder API is available

  Scenario Outline: Successful Commenting on Posts Creation
    When Commenting on Post request is sent to "/posts/<userid>/comments" URI
    Then the response status code should be 201
    And the response body should contain a new post with the provided data
Examples:
    |userid|
    |1 |

  Scenario Outline: Posting Comments on Wrong URI
    When Commenting on Post request is sent to "/posts/<userid>/commffdgdents" URI
    Then the response status code should be 404
    Examples:
      |userid|
      |1 |