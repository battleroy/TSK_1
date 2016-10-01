package lab2.runner;

import lab2.pages.inviter.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InviterTest {

    private WebDriver driver;
    private String url = "http://inviter.by";

    private MainPage startup() {
        driver = new ChromeDriver();
        driver.get(url);
        return new MainPage(driver);
    }

    @Test
    public void testMainPage() {
        MainPage mainPage = startup();

        Assert.assertEquals(mainPage.getLoginLinkText(), "Войти");
        Assert.assertEquals(mainPage.getNewsLinkText(), "Новости");
        Assert.assertEquals(mainPage.getCommentsLinkText(), "Отзывы");
        Assert.assertEquals(mainPage.getTryButtonText(), "Попробовать");

        driver.quit();
    }

    @Test
    public void testMainToLoginPage() {
        MainPage mainPage = startup();
        LoginPage loginPage = mainPage.goToLogin();

        Assert.assertEquals(loginPage.getForgotLinkText(), "Forgot your password?");
        Assert.assertEquals(loginPage.getPasswordLabelText(), "Password");

        driver.quit();
    }

    @Test
    public void testMainToTryPage() {
        MainPage mainPage = startup();
        TryPage tryPage = mainPage.goToTry();

        Assert.assertEquals(tryPage.getDownloadButtonText(), "Скачать");
        Assert.assertEquals(tryPage.getFileName(), "inviter_1_1_1.msi");

        driver.quit();
    }

    @Test
    public void testMainToCommentsPage() {
        MainPage mainPage = startup();
        CommentsPage commentsPage = mainPage.goToComments();

        Assert.assertEquals(commentsPage.getHelpLinkText(), "Помощь");

        driver.quit();
    }

    @Test
    public void testMainToNewsPage() {
        MainPage mainPage = startup();
        NewsPage newsPage = mainPage.goToNews();

        Assert.assertEquals(newsPage.getFiveMillionsText(), "5 миллионов приглашений! 300 человек!");
        Assert.assertEquals(newsPage.getManualLinkText(), "инструкция");

        driver.quit();
    }

}
