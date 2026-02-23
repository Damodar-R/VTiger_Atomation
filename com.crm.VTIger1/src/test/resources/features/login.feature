@LoginTest
Feature: Login functionality
@ValidLogin
Scenario: Valid login
  Given user is on login page
  When user enters credentials from Excel
  And clicks on login button
  Then user should navigate to home page