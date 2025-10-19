package org.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCardPayment implements Payment {

    WebDriver driver;
    @FindBy(id="cc")
    private WebElement cc;
    @FindBy(id="year")
    private WebElement year;
    @FindBy(id="cvv")
    private WebElement cvv;

    @FindBy(id="buy")
    private WebElement buy;
    public CreditCardPayment(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @Override
    public void doPayment(String cc1, String year1, String cvv1) {
        cc.sendKeys(cc1);
        year.sendKeys(year1);
        cvv.sendKeys(cvv1);
        buy.click();

    }


}
