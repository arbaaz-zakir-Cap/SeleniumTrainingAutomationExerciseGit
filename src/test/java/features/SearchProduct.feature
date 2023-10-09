Feature: Search Product
  Scenario: Navigate to automation exercise website
    When You have navigated to automationexercise.com
    Then Verify that home page is visible successfully

  Scenario: Navigate to 'Products' page
    Given user is on automation exercise home page
    When user clicks on 'products' button
    Then Verify user is navigated to ALL PRODUCTS page successfully

  Scenario: Search for a product
    When user enters product name in search input
    And clicks search button
    Then Verify 'SEARCHED PRODUCTS' is visible
    And Verify all the products related to search are visible