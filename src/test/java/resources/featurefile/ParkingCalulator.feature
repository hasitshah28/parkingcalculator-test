Feature: Parking Calculator

  @smoke
  Scenario: Calculate parking fee for Valet parking
    Given I am on the parking cost calculator homepage
    When I select Valet Parking from the Choose a Lot dropdown
    And I set the entry date and time to Today and 12:00 AM
    And I set the exit date and time to Tomorrow' and 12:00 AM
    And I click on calculate button
    Then I should see the calculated amount matching the rate from the parking rates table

  @smoke
  Scenario: Calculate parking fee for Economy parking
    Given I am on the parking cost calculator homepage
    When I select Economy Parking from the Choose a Lot dropdown
    And I set entry date and time to Today and 04:30 AM
    And I set exit date and time to Today and 09:00 AM
    And I click on the calculate button
    Then I should see calculated amount matching the rate from the parking rates table

  @smoke
  Scenario: Calculate parking fee for Short-Term (hourly) parking
    Given I am on the parking cost calculator homepage
    When I select Short-Term (Hourly) Parking from the Choose a Lot dropdown
    And I also set the entry date and time to Today and 12:00 AM
    And I also set the exit date and time to Today and 07:30 AM
    And I click on a calculate button
    Then I should be able to see the calculated amount matching the rate from the parking rates table




