package com.test.gammaportal.steps;

import com.test.gammaportal.pages.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ParkingCalculatorSteps {
    @Given("^I am on the parking cost calculator homepage$")
    public void iAmOnTheParkingCostCalculatorHomepage() {
    }

    @When("^I select Valet Parking from the Choose a Lot dropdown$")
    public void iSelectValetParkingFromTheChooseALotDropdown() {
        new HomePage().selectFromList();
    }

    @And("^I set the entry date and time to Today and (\\d+):(\\d+) AM$")
    public void iSetTheEntryDateAndTimeToTodayAndAM(int arg0, int arg1) {
        new HomePage().sendTextToEntryDateAndTime();
        new HomePage().clickOnEntryAM();
    }

    @And("^I set the exit date and time to Tomorrow' and (\\d+):(\\d+) AM$")
    public void iSetTheExitDateAndTimeToTomorrowAndAM(int arg0, int arg1) {
        new HomePage().sendTextToLeavingDateAndTime();
        new HomePage().clickOnLeavingAM();
    }

    @And("^I click on calculate button$")
    public void iClickOnCalculateButton() {
        new HomePage().clickOnCalculate();
    }

    @Then("^I should see the calculated amount matching the rate from the parking rates table$")
    public void iShouldSeeTheCalculatedAmountMatchingTheRateFromTheParkingRatesTable() {
        new HomePage().verifyAmountForValet();
    }

    @When("^I select Economy Parking from the Choose a Lot dropdown$")
    public void iSelectEconomyParkingFromTheChooseALotDropdown() {
        new HomePage().selectFromDropdown();
    }

    @And("^I set entry date and time to Today and (\\d+):(\\d+) AM$")
    public void iSetEntryDateAndTimeToTodayAndAM(int arg0, int arg1) {
        new HomePage().sendTextToEntryEconomyDateAndTime();
        new HomePage().clickOnEntryEconomyAM();
    }

    @And("^I set exit date and time to Today and (\\d+):(\\d+) AM$")
    public void iSetExitDateAndTimeToTodayAndAM(int arg0, int arg1) {
        new HomePage().sendTextToLeavingEconomyDateAndTime();
        new HomePage().clickOnLeavingEconomyAM();
    }

    @And("^I click on the calculate button$")
    public void iClickOnTheCalculateButton() {
        new HomePage().clickOnEconomyCalculate();
    }

    @Then("^I should see calculated amount matching the rate from the parking rates table$")
    public void iShouldSeeCalculatedAmountMatchingTheRateFromTheParkingRatesTable() {
        new HomePage().verifyAmountForEconomy();
    }

    @When("^I select Short-Term \\(Hourly\\) Parking from the Choose a Lot dropdown$")
    public void iSelectShortTermHourlyParkingFromTheChooseALotDropdown() {
        new HomePage().selectShortTermParkingFromDropdown();

    }

    @And("^I also set the entry date and time to Today and (\\d+):(\\d+) AM$")
    public void iAlsoSetTheEntryDateAndTimeToTodayAndAM(int arg0, int arg1) {
        new HomePage().sendTextToEntryShortTermDateAndTime();
        new HomePage().clickOnEntryShortTermAM();
    }

    @And("^I also set the exit date and time to Today and (\\d+):(\\d+) AM$")
    public void iAlsoSetTheExitDateAndTimeToTodayAndAM(int arg0, int arg1) {
        new HomePage().sendTextToLeavingShortTermDateAndTime();
        new HomePage().clickOnLeavingShortTermAM();
    }

    @And("^I click on a calculate button$")
    public void iClickOnACalculateButton() {
        new HomePage().clickOnShortTermCalculate();
    }

    @Then("^I should be able to see the calculated amount matching the rate from the parking rates table$")
    public void iShouldBeAbleToSeeTheCalculatedAmountMatchingTheRateFromTheParkingRatesTable() {
        new HomePage().verifyAmountForShortTerm();
    }
}
