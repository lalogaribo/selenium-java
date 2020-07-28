package com.nearsoft.tests;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected JavascriptExecutor js;

    @BeforeSuite
    public void driverSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDown() {
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        driver.close();
        driver.quit();
    }
}
