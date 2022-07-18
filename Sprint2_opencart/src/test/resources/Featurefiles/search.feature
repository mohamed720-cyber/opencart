@search
Feature: Search a product

  @validproduct
  Scenario: searching for a product and adding it into shopping cart
    Given The user have the name of product to search and enter details to be filtered
    When User enter the product name in the search box
    And User filters the product page and click seacrh button
    And User add the product to the shopping cart and click on shopping cart
    And Capture the details from shopping cart page and save it in excel file
    Then validate with valid and invalid product

  @invalidproduct
  Scenario: searching with invalid product details
    Given The invalid details read from excel file
    When user searched for invalid product
    And capture the error message
    Then validate the result
