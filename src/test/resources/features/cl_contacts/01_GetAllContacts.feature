@ClCrud
Feature: Get All Contacts Feature
  @AddContact
  Scenario: Get All Contacts
    When send the get request to get all contact
    Then status code should be 200
    And response body should be contain contact body

