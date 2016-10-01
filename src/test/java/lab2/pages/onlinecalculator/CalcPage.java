package lab2.pages.onlinecalculator;

import lab2.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalcPage extends BasePage {

    By resultInput = By.xpath(".//*[@id='ocalc']/tbody/tr[2]/td/div/input");

    public CalcPage(WebDriver driver) {
        super(driver);
    }

    public void sendKey(String key) {
        driver.findElement(By.linkText(key)).click();
    }

    public void sendEnter() {
        sendKey("=");
    }

    public String getResult() {
        return driver.findElement(resultInput).getAttribute("value");
    }

}
