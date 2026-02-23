@Createcontact
Feature: contact created functionality
@NewContact
Scenario: contact created
  Given user is on home page
  When user enters contact details from Excel
  Then user should navigate to contact page