@ClCrud @UpdateContact
Feature: Update Contact Feature

  Scenario: Update Contact
    Given prepare payload to update contact
    When send put request to update contact
    Then status code should be 200
    Then response body should contain created contact