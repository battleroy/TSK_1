package lab3.ddt;


import lab2.pages.onlinecalculator.CalcPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.FileAssert.fail;

public class TestNGDDT {

    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @DataProvider
    public Object[][] addTestData() {
        return new Object[][] {
                new Object[] {"3","+","4", "7"},
                new Object[] {"5", "-", "4","1"},
                new Object[] {"1", "×", "4","4"},
                new Object[] {"8","÷", "4", "2"},
        };
    }

    @BeforeTest
    public void setUp() {
        // Create a new instance of the Firefox driver
        driver = new ChromeDriver();
        driver.get("http://www.calculatoria.com/");
    }

    @Test(dataProvider = "addTestData")
    public void testCalculator(String arg1, String sign, String arg2, String result) {
        try {
            CalcPage calcPage = new CalcPage(driver);

            calcPage.sendKey(arg1);
            calcPage.sendKey(sign);
            calcPage.sendKey(arg2);
            calcPage.sendEnter();

            assertEquals(calcPage.getResult(), result);

        } catch (Error e) {
            //Capture and append Exceptions/Errors
            verificationErrors.append(e.toString() + "\n");
        }
    }



    @AfterTest
    public void tearDown() {
        //Close the browser
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
