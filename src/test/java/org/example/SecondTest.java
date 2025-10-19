package org.example;

import org.ObjectRepository.CreditCardPayment;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.ReUsableMethods;

import java.util.logging.Logger;

public class SecondTest extends BaseClass {
    ReUsableMethods reUsableMethods;
    private final Logger log = Logger.getLogger(String.valueOf(SecondTest.class));
    CreditCardPayment creditCardPayment;
    @BeforeClass
    public void conf()
    {

        log.info("Before Method started");
        reUsableMethods= new ReUsableMethods(driver);
    }

    @Test(dataProvider="getData")
    public void testTextBox(String fn,String ln,String emailId)
    {
        driver.findElement(By.id("fn")).sendKeys(fn);
        driver.findElement(By.id("ln")).sendKeys(ln);
        driver.findElement(By.id("email")).sendKeys(emailId);
        log.info("first name provided:"+fn);
        log.info("last name provided:"+ln);
        log.info("email name provided:"+emailId);
        reUsableMethods.takeScreenshot("login");
        driver.findElement(By.id("buy")).click();
        log.info("buy button is clicked");
        Actions act = new Actions(driver);
        act.moveToElement( driver.findElement(By.id("buy"))).click().build().perform();
        reUsableMethods.takeScreenshot("buy");
        String orderNumberText=driver.findElement(By.id("ordernumber")).getText();
        if(orderNumberText !=null && !orderNumberText.equals(""))
        {
            Assert.assertTrue(true);
            log.info("order Number:"+orderNumberText);
        }

    }

    @Test
    public void verifyCreditCardPayment()
    {
        creditCardPayment= PageFactory.initElements(driver,CreditCardPayment.class);
        creditCardPayment.doPayment("456789","2019","312");
        reUsableMethods.takeScreenshot("creditCardPayment");
    }
    @AfterClass
    public void tear()
    {
        log.info("After Method started");
        if(driver !=null){
        driver.quit();}
    }

//    @DataProvider(name="getData")
//    public Object[] getData()
//    {
//        Object [] obj = {"firstName","lastname","email"};
//        return obj;
//    }

    @DataProvider(name = "getData")
    public Object[][] getData() {
        // A DataProvider must return a two-dimensional array of objects (Object[][])
        // if the Test method has multiple parameters.
        return new Object[][]{
                {"firstNameValue1", "lastNameValue1", "email1@example.com"},
                {"firstNameValue2", "lastNameValue2", "email2@example.com"}
        };
    }

}
