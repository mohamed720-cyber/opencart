@register
Feature: New account registration

  @validregister
  Scenario: Resgistering for a new account using valid user data
    Given The user should have registration details to be filled
    When User clicks on My Account and  select the register option
    And User fill the mandatory details in the registration page
    And User click on continue button and capture the result
    Then Validate the confirmation message in the account page

  @invalidregister
  Scenario: Resgistering for a new account using invalid user data
    Given The user should enter invalid data
    When User clicks on my account and select register option
    And User needs to fill the registration details
    And click continue and capture the result
    Then validate the confirmation of the registration.
