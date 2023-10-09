Feature: Verify Subscription in Home Page
  Scenario: Navigate to automation exercise website
    When User have navigated to automationexercise.com home page for subscription
    Then Verify that home page is visible successfully for subscription

  Scenario: Scroll down to the bottom of the page
    When You scroll down to footer
    Then Verify text subscription

  Scenario: input email in subscription box
    When User enters email in subscription box
    Then click arrow button
    And Verify success message You have been successfully subscribed! is visible
