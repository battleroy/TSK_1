package lab2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    By passwordLabel = By.xpath(".//*[@id='box']/div/div[2]");
    By forgotLink = By.xpath(".//*[@id='quick_forgot']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getPasswordLabelText() {
        return driver.findElement(passwordLabel).getText();
    }

    public String getForgotLinkText() {
        return driver.findElement(forgotLink).getText();
    }
}
