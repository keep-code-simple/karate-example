@e2e
Feature: Users

  Background:
    Given url 'https://reqres.in'

  Scenario: Make JUST GET calls for Users
    # Make a GET call
    Given path "/api/users/2"
    When method get
    Then status 200

  Scenario: Make POST and GET calls
    # Make a POST call
    Given path "/api/users"
    And request { "name": "morpheus", "job": "leader" }
    When method post
    Then status 201
    And match response contains { "name": "morpheus", "job": "leader", "id": "#string" }