package lab2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewsPage extends BasePage {

    By fiveMillionsLabel = By.xpath("html/body/div[3]/div/div/div[1]/div/div[1]/b");
    By manualLink = By.xpath("html/body/div[3]/div/div/div[4]/div[2]/a[2]");

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public String getFiveMillionsText() {
        return driver.findElement(fiveMillionsLabel).getText();
    }

    public String getManualLinkText() {
        return driver.findElement(manualLink).getText();
    }
}
