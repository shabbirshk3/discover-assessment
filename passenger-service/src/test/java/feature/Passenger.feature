Feature: Test POST method

  Scenario: Add Passenger record
    Given I set POST passenger service api endpoint
    When I set request header
    And Send a POST HTTP request
    Then I receive valid response
   
    Examples: 
       passengerId | passengerName  |  passengerAge 
       101         | john           |  28 