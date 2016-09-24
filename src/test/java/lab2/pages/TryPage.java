package lab2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TryPage extends BasePage {

    By downloadButton = By.xpath("html/body/div[3]/div/div/div[2]/p[1]/a");
    By fileNameLabel = By.xpath("html/body/div[3]/div/div/div[2]/p[2]/b");

    public TryPage(WebDriver driver) {
        super(driver);
    }

    public String getDownloadButtonText() {
        return driver.findElement(downloadButton).getText();
    }

    public String getFileName() {
        return driver.findElement(fileNameLabel).getText();
    }
}
