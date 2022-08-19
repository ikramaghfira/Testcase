package com.selenium.calculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPageObject {
    private String expectedText = "reach digit limit";
    @FindBy(id = "clearButton")
    public static WebElement clearAll;
    @FindBy(id = "deleteButton")
    public static WebElement delete;
    @FindBy(xpath = "//div[1]/button[last()-1]")
    public static WebElement devidedBy;
    @FindBy(xpath = "//div[1]/button[last()]")
    public static WebElement times;
    @FindBy(xpath = "//div[2]/button[last()-3]")
    public static WebElement seven;
    @FindBy(xpath = "//div[2]/button[last()-2]")
    public static WebElement eight;
    @FindBy(xpath = "//div[2]/button[last()-1]")
    public static WebElement nine;
    @FindBy(xpath = "//div[2]/button[last()]")
    public static WebElement minus;
    @FindBy(xpath = "//div[3]/button[last()-3]")
    public static WebElement four;
    @FindBy(xpath = "//div[3]/button[last()-2]")
    public static WebElement five;
    @FindBy(xpath = "//div[3]/button[last()-1]")
    public static WebElement six;
    @FindBy(xpath = "//div[3]/button[last()]")
    public static WebElement plus;
    @FindBy(xpath = "//div[4]/button[last()-3]")
    public static WebElement one;
    @FindBy(xpath = "//div[4]/button[last()-2]")
    public static WebElement two;
    @FindBy(xpath = "//div[4]/button[last()-1]")
    public static WebElement three;
    @FindBy(id = "resultButton")
    public static WebElement equals;
    @FindBy(xpath = "//div[5]/button[1]")
    public static WebElement zero;
    @FindBy(xpath = "//div[5]/button[last()]")
    public static WebElement dot;
    @FindBy(xpath = "//footer/a[1]")
    public static WebElement title;
    @FindBy(id = "output")
    public static WebElement mainScreen;
    @FindBy(id = "output2")
    public static WebElement subScreen;

    public CalculatorPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //method to check maximum digits allowed on the screen
    public void maxChar(WebElement text, int num) {
        boolean check = false;
        for (int i = 0; i <= num; i++) {
            if (subScreen.getText().equalsIgnoreCase(expectedText)) {
                if (getText(mainScreen).equals("0")) {
                    check = true;
                }
            } else {
                text.click();
            }
        }
    }

    //method for double type number calculation
    public void floatCalculation(int numZero, WebElement firstNum, int numZero2, WebElement secNum,
                                 WebElement operator) {
        clickNumber(zero).clickNumber(dot);
        for (int i = 0; i < numZero; i++) {
            clickNumber(zero);
        }
        clickNumber(firstNum).clickOperator(operator).clickNumber(zero).clickNumber(dot);
        for (int i = 0; i < numZero2; i++) {
            clickNumber(zero);
        }
        clickNumber(secNum).clickOperator(equals);
    }

    public String getText(WebElement screenElement) {
        return screenElement.getText();
    }

    public boolean isDisplayed() {
        return title.isDisplayed();
    }

    public String getTitle() {
        return title.getText();
    }

    public CalculatorPageObject clickNumber(WebElement numElement) {
        numElement.click();
        return this;
    }

    public CalculatorPageObject clickOperator(WebElement opElement) {
        opElement.click();
        return this;
    }
}

