package com.selenium.calculatortest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    WebDriverWait w;
    @Before
    public void openWebBrowser(){
        System.out.println("Before Test");
        //driver location
        System.setProperty("webdriver.chrome.driver", "F:\\K. Belajar JAVA\\3. Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        //page timeout
        w = new WebDriverWait(driver, Duration.ofSeconds(20));
        //open url https://greyli.github.io/calculator/
        driver.get("https://greyli.github.io/calculator/");
        //maximize the window
        driver.manage().window().maximize();
    }

    @After
    //close window browser
    public void closeWebBrowser(){
        driver.quit();
    }
}
