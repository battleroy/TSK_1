package lab3.bdd.dataTable;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import javafx.beans.binding.IntegerBinding;
import lab2.pages.onlinecalculator.CalcPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CalcDataTableDefs {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://www.calculatoria.com/");
    }

    @When("^I enter arguments and sign I expect appropriate result$")
    public void iEnterArgumentsAndSignIExpectAppropriateResult(DataTable dataTable) throws Throwable {

        List<List<String>> data = dataTable.raw();

        CalcPage calcPage = new CalcPage(driver);

        for (int row = 1; row < dataTable.getGherkinRows().size(); ++row) {
            String arg1 = data.get(row).get(0);
            String sign = data.get(row).get(1);
            String arg2 = data.get(row).get(2);
            String result = data.get(row).get(3);

            calcPage.sendKey(arg1);
            calcPage.sendKey(sign);
            calcPage.sendKey(arg2);
            calcPage.sendEnter();

            assertEquals(calcPage.getResult(), result);
        }

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
