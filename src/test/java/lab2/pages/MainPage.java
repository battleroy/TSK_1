package lab2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    By loginLink = By.xpath("html/body/div[2]/nav/div[2]/ul/li[6]/a");
    By newsLink = By.xpath("html/body/div[2]/nav/div[2]/ul/li[3]/a");
    By commentsLink = By.xpath("html/body/div[2]/nav/div[2]/ul/li[4]/a");
    By tryButton = By.xpath("html/body/div[3]/div/div/div[1]/a");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLogin() {
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }

    public TryPage goToTry() {
        driver.findElement(tryButton).click();
        return new TryPage(driver);
    }

    public CommentsPage goToComments() {
        driver.findElement(commentsLink).click();
        return new CommentsPage(driver);
    }

    public NewsPage goToNews() {
        driver.findElement(newsLink).click();
        return new NewsPage(driver);
    }

    public String getLoginLinkText() {
        return driver.findElement(loginLink).getText();
    }

    public String getNewsLinkText() {
        return driver.findElement(newsLink).getText();
    }

    public String getCommentsLinkText() {
        return driver.findElement(commentsLink).getText();
    }

    public String getTryButtonText() {
        return driver.findElement(tryButton).getText();
    }
}
