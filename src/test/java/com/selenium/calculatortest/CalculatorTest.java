package com.selenium.calculatortest;

import com.selenium.calculator.CalculatorPageObject;
import com.selenium.calculator.CalculatorPageObject.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.selenium.calculator.CalculatorPageObject.*;

public class CalculatorTest extends BaseTest{
    CalculatorPageObject calculator;
    static int number =13;

    @Test
    public void testCalculator() {
        // initialized object for the page
        calculator = new CalculatorPageObject(driver);

        // verify text in the page available
        Assert.assertTrue(calculator.isDisplayed());
        String expectedTitle = "Grey Li";
        Assert.assertEquals(expectedTitle, calculator.getTitle());

        //verify maximum digits allowed on the screen
        calculator.maxChar(two, number);
        calculator.clickOperator(clearAll);

        //verify delete and clear function
        List<WebElement> listElementNumber = new ArrayList<>(
                Arrays.asList(one, two, three, four, five, six, seven, eight, nine));
        for (WebElement element : listElementNumber) {
            calculator.clickNumber(element);
        }
        for(int i = 0; i<3; i++){
            calculator.clickOperator(delete);
        }
        Assert.assertEquals("123456", calculator.getText(subScreen));
        calculator.clickOperator(clearAll);
        Assert.assertEquals("0", calculator.getText(mainScreen));
        Assert.assertEquals("", calculator.getText(subScreen));

        //verify addition function using integer
        calculator.clickNumber(one).clickNumber(two).clickOperator(plus).clickNumber(three).clickNumber(four)
                .clickOperator(equals);
        int expectedResultPlus = 12+34;
        Assert.assertEquals(String.valueOf(expectedResultPlus), calculator.getText(subScreen));
        calculator.clickOperator(clearAll);

        //verify substraction function using integer
        calculator.clickNumber(five).clickNumber(six).clickOperator(minus).clickNumber(seven).clickOperator(equals);
        int expectedResultMinus = 56-7;
        Assert.assertEquals(String.valueOf(expectedResultMinus), calculator.getText(subScreen));
        calculator.clickOperator(clearAll);

        //verify multiply function using integer
        calculator.clickNumber(eight).clickOperator(times).clickNumber(nine).clickOperator(equals);
        int expectedResultMultipy = 8*9;
        Assert.assertEquals(String.valueOf(expectedResultMultipy), calculator.getText(subScreen));
        calculator.clickOperator(clearAll);

        //verify devides function using integer
        calculator.clickNumber(one).clickNumber(zero).clickOperator(devidedBy).clickNumber(two).clickOperator(equals);
        int expectedResultDevided = 10/2;
        Assert.assertEquals(String.valueOf(expectedResultDevided), calculator.getText(subScreen));
        calculator.clickOperator(clearAll);

        //verify devides function with 0 = infinity
        try{
            calculator.clickNumber(one).clickOperator(devidedBy).clickNumber(zero).clickOperator(equals);
            int expectedInfinity = 1/0;
        } catch (ArithmeticException e){
            String error = e.getMessage().replace("/ by zero", "Infinity");
            Assert.assertEquals(error, calculator.getText(subScreen));
            Assert.assertEquals(error, calculator.getText(mainScreen));
        }
        calculator.clickOperator(clearAll);

        //verify multiply double number
        calculator.floatCalculation(1,two,7,two,times);
        double expectedDoubleResult = 0.02 * 0.00000002;
        Assert.assertEquals(
                String.valueOf(expectedDoubleResult).replace(".0","").toLowerCase(),
                calculator.getText(subScreen));
        calculator.clickOperator(clearAll);

    }
}
