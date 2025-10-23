@ClCrud
Feature: add Contact features
  @AddContact
  Scenario: Add Contact
    Given prepare payload to create contact
    When send post request to create contact
    Then status code should be 201
    And response body should be contain created contact
