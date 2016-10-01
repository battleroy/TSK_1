package lab3.bdd.raw;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lab2.pages.unitconverters.ConvertPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;

public class ConvertStepDefs {

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

    @Given("^Mode is '(\\D+)'$")
    public void modeIs(String mode) {
        this.mode = mode;
    }

    @Given("^From unit is '(\\D+)'$")
    public void fromUnitIsCentimeter(String from) {
        this.from = from;
    }

    @Given("^To unit is '(\\D+)'$")
    public void toUnitIsMeter(String to) {
        this.to = to;
    }


    @When("^From value is (\\d+)$")
    public void fromValueIs(int fromValue) {
        this.fromValue = fromValue;
    }

    @Then("^To value should be ([-+]?[0-9]*\\.?[0-9]*)$")
    public void toValueShouldBe(double toValue) {

        ConvertPage page = new ConvertPage(driver);

        page.setMode(mode);
        page.setFromUnit(from);
        page.setToUnit(to);
        page.inputFromValue(Integer.toString(fromValue));

        assertEquals(page.getConvertResult(), toValue);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
