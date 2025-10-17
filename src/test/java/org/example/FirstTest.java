package org.example;

import org.ObjectRepository.PractisePage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ReUsableMethods;

public class FirstTest extends BaseClass {
    protected static final Logger logger= LogManager.getLogger(FirstTest.class);
    PractisePage  practisePage=PageFactory.initElements(driver,PractisePage.class);
    ReUsableMethods reUsableMethods;
    @Test(dataProvider="getData")
    public void testRadioButton(String name)
    {
//        String name="radio1";
        practisePage=PageFactory.initElements(driver,PractisePage.class);
        reUsableMethods =new ReUsableMethods(driver);
        practisePage.selectRadioButton(name);
        logger.info("radio button:"+name +" is selected");
        reUsableMethods.takeScreenshot(name);
    }

    @DataProvider(name="getData")
    public Object[] getData()
    {
        Object[] obj= {"radio1","radio2","radio3"};
        return obj;
    }
}
