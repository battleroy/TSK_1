package lab2.pages.unitconverters;

import lab2.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.DoubleClickAction;
import org.openqa.selenium.support.ui.Select;

public class ConvertPage extends BasePage {

    By fromInput = By.xpath(".//*[@id='content']/table[1]/tbody/tr[2]/td[1]/input");
    By toInput = By.xpath(".//*[@id='content']/table[1]/tbody/tr[2]/td[2]/input");
    By fromSelect = By.xpath(".//*[@id='calFrom']");
    By toSelect = By.xpath(".//*[@id='calTo']");

    public ConvertPage(WebDriver driver) {
        super(driver);
    }

    public void setMode(String mode) {
        driver.findElement(By.linkText(mode)).click();
    }

    public void setFromUnit(String from) {
        Select select = new Select(driver.findElement(fromSelect));
        select.selectByVisibleText(from);
    }

    public void setToUnit(String to) {
        Select select = new Select(driver.findElement(toSelect));
        select.selectByVisibleText(to);
    }

    public void inputFromValue(String value) {
        driver.findElement(fromInput).sendKeys(value);
    }

    public double getConvertResult() {
        return Double.parseDouble(driver.findElement(toInput).getAttribute("value"));
    }
}
