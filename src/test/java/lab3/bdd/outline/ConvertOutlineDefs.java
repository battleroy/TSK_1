package lab3.bdd.outline;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lab2.pages.unitconverters.ConvertPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;

public class ConvertOutlineDefs {

    private WebDriver driver;

    private String mode;
    private String from;
    private String to;
    private int fromValue;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://www.unitconverters.net/");
    }

    @Given("^Convert mode is '(\\D+)'$")
    public void modeIsMode(String mode) throws Throwable {
        this.mode = mode;
    }

    @Given("^Source unit is '(\\D+)'$")
    public void fromUnitIsFrom(String source) {
        this.from = source;
    }

    @Given("^Target unit is '(\\D+)'$")
    public void targetUnitIsTo(String target) {
        this.to = target;
    }

    @When("^Convert from value is (\\d+)")
    public void iEnterFromValue(int fromValue) throws Throwable {
        this.fromValue = fromValue;
    }

    @Then("^I expect result to be ([-+]?[0-9]*\\.?[0-9]*)$")
    public void iExpectResultToBeResult(double result) throws Throwable {
        ConvertPage page = new ConvertPage(driver);

        page.setMode(mode);
        page.setFromUnit(from);
        page.setToUnit(to);
        page.inputFromValue(Integer.toString(fromValue));

        assertEquals(page.getConvertResult(), result);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
