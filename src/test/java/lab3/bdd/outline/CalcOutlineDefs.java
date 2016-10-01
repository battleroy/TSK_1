package lab3.bdd.outline;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lab2.pages.onlinecalculator.CalcPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;

public class CalcOutlineDefs {

    private WebDriver driver;

    private int firstArg;
    private int secondArg;
    private String sign;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://www.calculatoria.com/");
    }

    @When("^I enter (\\d+), (\\D) and (\\d+)$")
    public void iEnterArgSignAndArg(int arg1, String sign, int arg2) throws Throwable {
        firstArg = arg1;
        this.sign = sign;
        secondArg = arg2;
    }


    @Then("^I expect (\\d+)$")
    public void iExpectResult(int result) throws Throwable {

        CalcPage calcPage = new CalcPage(driver);

        calcPage.sendKey(Integer.toString(firstArg));
        calcPage.sendKey(sign);
        calcPage.sendKey(Integer.toString(secondArg));
        calcPage.sendEnter();

        assertEquals(calcPage.getResult(), Integer.toString(result));

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
