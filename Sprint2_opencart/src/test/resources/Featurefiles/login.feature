@login
Feature: Login to the account
  @valid
  Scenario: Login with valid login credentials
    Given The user should be in home page
    When User opened the login page
    And User entered email "<email>" and password "<pass>"
    And capture the result of authentication
    Then authenticate the credentials and verify authentication is sucessful "<message>"
    Then close browser valid
    Examples:
    |email|pass|message|
    |asif10@gmail.com|asif@123|authentication successful|
    
    
  @invalid
  Scenario: Login with invalid login credentials
    Given The user should be in home page for invalid
    When User opened the Login Page
    And User entered invalid email "<email>" and password "<pass>"
    And capture the result for authentication
    Then authenticate the credentials verify authentication "<message>"
    Then close browser invalid
    Examples:
    |email|pass|message|
    |wrongemails|wrongpass3|authentication failed|

