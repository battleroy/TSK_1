package lab2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommentsPage extends BasePage {

    By helpLink = By.xpath("html/body/div[2]/nav/div[2]/ul/li[5]/a");

    public CommentsPage(WebDriver driver) {
        super(driver);
    }

    public String getHelpLinkText() {
        return driver.findElement(helpLink).getText();
    }
}
