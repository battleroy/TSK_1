package lab3.bdd.raw;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lab2.pages.onlinecalculator.CalcPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;

public class CalcStepDefs {

    private WebDriver driver;

    private int firstArg;
    private int secondArg;
    private String sign;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://www.calculatoria.com/");
    }

    @Given("^First arg is (\\d+)$")
    public void firstArgIs(int first) {
        firstArg = first;
    }

    @Given("^Second arg is (\\d+)$")
    public void secondArgIs(int second) {
        secondArg = second;
    }

    @When("^Sign is '(\\D)'$")
    public void signIs(String sign) {
        this.sign = sign;
    }

    @Then("^Result is (\\d+)$")
    public void resultIs(int result) throws Throwable {
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
