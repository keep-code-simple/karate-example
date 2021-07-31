@e2e
Feature: brief description of what is being tested
  more lines of description if needed.

  Background:
    Given url 'https://reqres.in'
  # this section is optional !
  # steps here are executed before each Scenario in this file
  # variables defined here will be 'global' to all scenarios
  # and will be re-initialized before every scenario

  Scenario: Make POST and GET calls
    # Make a POST call
    Given path "/api/users"
    And request { "name": "morpheus", "job": "leader" }
    When method post
    Then status 201
    And match response contains { "name": "morpheus", "job": "leader", "id": "#string" }

    # Make a GET call on the based on the previous response
    Given path response.id
    When method get
   # Then status 200
    # Test fails at line number 22 as 'reqres.in api is not getting the data with id'
  @name=getUsers
  Scenario: Make JUST GET calls for Users
    # Make a GET call
    Given path "/api/users/2"
    When method get
    Then status 200

  Scenario: a different scenario
  # steps for this other scenario
    Given def color = 'red '
    And def num = 5
    Then assert color + num == 'red 5'
