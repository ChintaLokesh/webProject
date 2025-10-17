package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

    WebDriver driver;
    @BeforeTest
    public void configure()
    {
        driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}
