package com.test.gammaportal.TestSuite;

import com.test.gammaportal.pages.HomePage;
import com.test.gammaportal.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ParkingTests extends BaseTest {

    HomePage homePage = new HomePage();

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
    }


    /**
     * Scenario 1)
     * Using the Valet parking lot, set today as the entry date & time and tomorrow as
     * the exit giving a full 24 hour window (you can attempt to use the DatePicker).
     * Verify the calculated amount is what is reflected in the rates table
     * (Please extract the value from the rates table rather than hard coding)
     */

    @Test(groups = {"regression"})
    public void scenario1() {
        homePage.selectFromList();
        homePage.sendTextToEntryDateAndTime();
        homePage.clickOnEntryAM();
        homePage.sendTextToLeavingDateAndTime();
        homePage.clickOnLeavingAM();
        homePage.clickOnCalculate();
        homePage.verifyAmountForValet();
    }

    /**
     * Scenario 2)
     * Select Economy parking lot from the drop down, put today as the
     * entry and exit date (you can attempt to use the DatePicker) but
     * change the time to reflect 4.5 hours, verify the calculated amount is
     * what is reflected in the rates table
     * (Please extract the value from the rates table rather than hard coding)
     */

    @Test(groups = {"regression"})
    public void scenario2() {
        homePage.selectFromDropdown();
        homePage.sendTextToEntryEconomyDateAndTime();
        homePage.clickOnEntryEconomyAM();
        homePage.sendTextToLeavingEconomyDateAndTime();
        homePage.clickOnLeavingEconomyAM();
        homePage.clickOnEconomyCalculate();
        homePage.verifyAmountForEconomy();
    }


    /**
     * Scenario 3)
     * Select Short-Term (hourly) Parking lot from the drop down, put
     * today as the entry and exit date (you can attempt to use the DatePicker)
     * but change the time to reflect 7.5 hours. Using the information in the rates table,
     * calculate what the expected value should be and validate the cost
     */

    @Test(groups = {"regression"})
    public void scenario3() {
       homePage.selectShortTermParkingFromDropdown();
       homePage.sendTextToEntryShortTermDateAndTime();
       homePage.clickOnEntryShortTermAM();
       homePage.sendTextToLeavingShortTermDateAndTime();
       homePage.clickOnLeavingShortTermAM();
       homePage.clickOnShortTermCalculate();
       homePage.verifyAmountForShortTerm();

    }
}
