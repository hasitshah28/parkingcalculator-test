package com.test.gammaportal.pages;

import com.test.gammaportal.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    // Scenario: 1

    @CacheLookup
    @FindBy(id = "ParkingLot")
    WebElement parkingLot;

    @CacheLookup
    @FindBy(id = "StartingDate")
    WebElement entryDate;

    @CacheLookup
    @FindBy(id = "StartingTime")
    WebElement entryTime;

    @CacheLookup
    @FindBy(xpath = "(//input[@name='StartingTimeAMPM'][1])")
    WebElement entryTimeAM;

    @CacheLookup
    @FindBy(id = "LeavingDate")
    WebElement leavingDate;

    @CacheLookup
    @FindBy(id = "LeavingTime")
    WebElement leavingTime;

    @CacheLookup
    @FindBy(xpath = "(//input[@name='LeavingTimeAMPM'][1])")
    WebElement leavingTimeAM;

    @CacheLookup
    @FindBy(xpath = "//input[@name='Submit']")
    WebElement clickCalculate;

    @CacheLookup
    @FindBy(xpath = "//b[contains(text(),'$ 18.00')]")
    WebElement getAmount;

    public void selectFromList() {
        selectByVisibleTextFromDropDown(parkingLot, "Valet Parking");
        log.info("Select parking lot " + parkingLot.toString());

    }

    public void sendTextToEntryDateAndTime() {
        driver.findElement(By.id("StartingDate")).clear();
        sendTextToElement(entryDate, "09/20/2023");
        driver.findElement(By.id("StartingTime")).clear();
        sendTextToElement(entryTime, "12.00");
        log.info("Select entry date " + entryDate.toString());
        log.info("Select entry time " + entryTime.toString());

    }

    public void clickOnEntryAM() {
        clickOnElement(entryTimeAM);
        log.info("Click on AM " + entryTimeAM.toString());


    }

    public void sendTextToLeavingDateAndTime() {
        driver.findElement(By.id("LeavingDate")).clear();
        sendTextToElement(leavingDate, "09/21/2023");
        driver.findElement(By.id("LeavingTime")).clear();
        sendTextToElement(leavingTime, "12.00");
        log.info("Select leaving date " + leavingDate.toString());
        log.info("Select leaving time " + leavingTime.toString());
    }

    public void clickOnLeavingAM() {
        clickOnElement(leavingTimeAM);
        log.info("Click on AM " + leavingTimeAM.toString());


    }

    public void clickOnCalculate() {
        clickOnElement(clickCalculate);
        log.info("Click on calculate " + clickCalculate.toString());


    }

    public void verifyAmountForValet() {
        String calculatedAmount = getTextFromElement(getAmount).replace(" ", "").substring(0, 3);
        WebElement extractedAmountElement = driver.findElement(By.xpath("//p[contains(text(),'$18 per day')]"));
        String extractedAmount = extractedAmountElement.getText().trim().substring(14, 17);


        Assert.assertEquals(extractedAmount, calculatedAmount);

        if (calculatedAmount.equals(extractedAmount)) {
            System.out.println("Scenario 1 Passed: Calculated amount matches the rate for Valet parking - " + calculatedAmount);
        } else {
            System.out.println("Scenario 1 Failed: Calculated amount does not match the rate for Valet parking.");
        }
    }


    // Scenario: 2

    @CacheLookup
    @FindBy(id = "ParkingLot")
    WebElement chooseEconomyLot;

    @CacheLookup
    @FindBy(id = "StartingDate")
    WebElement entryEconomyDate;

    @CacheLookup
    @FindBy(id = "StartingTime")
    WebElement entryEconomyTime;

    @CacheLookup
    @FindBy(xpath = "(//input[@name='StartingTimeAMPM'][1])")
    WebElement entryTimeEconomyAM;

    @CacheLookup
    @FindBy(id = "LeavingDate")
    WebElement leavingEconomyDate;

    @CacheLookup
    @FindBy(id = "LeavingTime")
    WebElement leavingEconomyTime;

    @CacheLookup
    @FindBy(xpath = "(//input[@name='LeavingTimeAMPM'][1])")
    WebElement leavingTimeEconomyAM;

    @CacheLookup
    @FindBy(xpath = "//input[@name='Submit']")
    WebElement clickOnEconomyCalculate;

    @CacheLookup
    @FindBy(xpath = "//b[@xpath='1']")
    WebElement amountForEconomy;

    public void selectFromDropdown() {
        driver.findElement(By.id("ParkingLot"));
        selectByVisibleTextFromDropDown(chooseEconomyLot, "Economy Parking");
        log.info("Select parking lot: " + chooseEconomyLot.toString());
    }

    public void sendTextToEntryEconomyDateAndTime() {
        driver.findElement(By.id("StartingDate")).clear();
        sendTextToElement(entryEconomyDate, "09/21/2023");
        driver.findElement(By.id("StartingTime")).clear();
        sendTextToElement(entryEconomyTime, "04:30");
        log.info("Enter entry date  " + entryEconomyDate.toString());
        log.info("Enter entry time " + entryEconomyTime.toString());
    }


    public void clickOnEntryEconomyAM() {
        clickOnElement(entryTimeEconomyAM);
        log.info("Click on AM " + entryTimeEconomyAM.toString());

    }

    public void sendTextToLeavingEconomyDateAndTime() {
        driver.findElement(By.id("LeavingDate")).clear();
        sendTextToElement(leavingEconomyDate, "09/21/2023");
        driver.findElement(By.id("LeavingTime")).clear();
        sendTextToElement(leavingEconomyTime, "09:00");
        log.info("Enter leaving date  " + leavingEconomyDate.toString());
        log.info("Enter leaving time " + leavingEconomyTime.toString());
    }


    public void clickOnLeavingEconomyAM() {
        clickOnElement(leavingTimeEconomyAM);
        log.info("Click on AM " + leavingTimeEconomyAM.toString());



    }

    public void clickOnEconomyCalculate() {
        clickOnElement(clickOnEconomyCalculate);
        log.info("Click on calculate " + clickOnEconomyCalculate.toString());

    }

    public void verifyAmountForEconomy() {

        String expactedAmount = "$ 9.00";
        WebElement extractedAmountElement = driver.findElement(By.xpath("//b[contains(text(),'$ 10.00')]"));
        String extractedAmount = extractedAmountElement.getText();
        Assert.assertEquals(extractedAmount, expactedAmount, "Scenario 2 Failed: Calculated amount does not match the rate for Economy parking");


        if (expactedAmount.equals(extractedAmount)) {
            System.out.println("Scenario 2 Passed: Calculated amount matches the rate for Economy parking - " + expactedAmount);
        } else {
            System.out.println("Scenario 2 Failed: Calculated amount does not match the rate for Economy parking.");
        }
    }


//    Scenario:3

    @CacheLookup
    @FindBy(id = "ParkingLot")
    WebElement chooseShortTermParking;

    @CacheLookup
    @FindBy(id = "StartingDate")
    WebElement enterShortTermDate;

    @CacheLookup
    @FindBy(id = "StartingTime")
    WebElement enterShortTermTime;

    @CacheLookup
    @FindBy(xpath = "(//input[@name='StartingTimeAMPM'][1])")
    WebElement enterShortTermAM;

    @CacheLookup
    @FindBy(id = "LeavingDate")
    WebElement enterLeavingShortTermDate;

    @CacheLookup
    @FindBy(id = "LeavingTime")
    WebElement enterLeavingShortTermTime;

    @CacheLookup
    @FindBy(xpath = "(//input[@name='LeavingTimeAMPM'][1])")
    WebElement enterLeavingShortTermAM;

    @CacheLookup
    @FindBy(xpath = "//input[@name='Submit']")
    WebElement clickCalculateForShortTerm;

    @CacheLookup
    @FindBy(xpath = "//b[contains(text(),'$ 15.00')]")
    WebElement amountForShortTerm;

    public void selectShortTermParkingFromDropdown() {
        driver.findElement(By.id("ParkingLot"));
        selectByVisibleTextFromDropDown(chooseShortTermParking, "Short-Term Parking");
        log.info("Select parking lot " + chooseShortTermParking.toString());

    }

    public void sendTextToEntryShortTermDateAndTime() {
        driver.findElement(By.id("StartingDate")).clear();
        sendTextToElement(enterShortTermDate, "09/21/2023");
        driver.findElement(By.id("StartingTime")).clear();
        sendTextToElement(enterShortTermTime, "12:00");
        log.info("Enter starting date " + enterShortTermDate.toString());
        log.info("Enter starting time " + enterShortTermTime.toString());


    }


    public void clickOnEntryShortTermAM() {
        clickOnElement(enterShortTermAM);
        log.info("Click on AM" + enterShortTermAM.toString());

    }
    public void sendTextToLeavingShortTermDateAndTime() {
        driver.findElement(By.id("LeavingDate")).clear();
        sendTextToElement(enterLeavingShortTermDate, "09/21/2023");
        driver.findElement(By.id("LeavingTime")).clear();
        sendTextToElement(enterLeavingShortTermTime, "07:30");
        log.info("Enter leaving date " + enterLeavingShortTermDate.toString());
        log.info("Enter leaving time " + enterLeavingShortTermTime.toString());

    }

    public void clickOnLeavingShortTermAM() {
        clickOnElement(enterLeavingShortTermAM);
        log.info("Click on AM " + enterLeavingShortTermAM.toString());

    }

    public void clickOnShortTermCalculate() {
        clickOnElement(clickCalculateForShortTerm);
        log.info("Click on calculate " + clickCalculateForShortTerm.toString());

    }

    public void verifyAmountForShortTerm() {
        String calculatedAmount = getTextFromElement(amountForShortTerm);
        WebElement extractedAmountElement = driver.findElement(By.xpath("//b[contains(text(),'$ 15.00')]"));
        String extractedAmount = extractedAmountElement.getText();
        Assert.assertEquals(extractedAmount, calculatedAmount);


        if (calculatedAmount.equals(extractedAmount)) {
            System.out.println("Scenario 3 Passed: Calculated amount matches the rate for Short-Term parking - " + calculatedAmount);
        } else {
            System.out.println("Scenario 3 Failed: Calculated amount does not match the rate for Short-Term parking.");
        }
    }
}





