package lab1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AvByTest {

    private ChromeDriver chromeDriver = new ChromeDriver();
    private String url = "http://av.by/";
    private int TIMEOUT = 6000;

    @Test
    public void test() {
        chromeDriver.get(url);
        clickByXPath(".//*[@id='submit_presearch']");
        clickByXPath(".//*[@id='brand_id_chosen']/a/span");
        clickByXPath(".//*[@id='brand_id_chosen']/div/ul/li[80]");
        clickByXPath(".//*[@id='model_id_chosen']/a/span");
        clickByXPath(".//*[@id='model_id_chosen']/div/ul/li[13]");
        clickByXPath(".//*[@id='send']");
    }

    private void clickByXPath(String XPath) {
        chromeDriver.findElementByXPath(XPath).click();
    }

    private void startup() {
        Configuration.browser = "chrome";

        open(url);
    }

    @Test
    public void golf() {
        startup();
        SelenideElement searchButton = $(By.xpath(".//*[@id='submit_presearch']"));
        SelenideElement brandDropdown = $(By.xpath(".//*[@id='brand_id_chosen']/a"));
        SelenideElement vwSelection = $(By.xpath(".//*[@id='brand_id_chosen']/div/ul/li[80]"));
        SelenideElement modelDropdown = $(By.xpath(".//*[@id='model_id_chosen']/a/span"));
        SelenideElement golfSelection = $(By.xpath(".//*[@id='model_id_chosen']/div/ul/li[13]"));
        SelenideElement regionFilter = $(By.xpath(".//*[@id='region_id_filter_chosen']/a/span"));
        SelenideElement minskRegionSelection = $(By.xpath(".//*[@id='region_id_filter_chosen']/div/ul/li[6]"));
        SelenideElement extendedSearchButton = $(By.xpath(".//*[@id='search_extend_link']"));
        SelenideElement inputMinimumDisplacement = $(By.xpath(".//*[@id='PublicPassengerFilter']/div/div[3]/div[1]/div/div[2]/div[1]/input"));
        SelenideElement startSearchButton = $(By.xpath(".//*[@id='PublicPassengerFilter']/div/div[9]/input[1]"));

        searchButton.click();
        brandDropdown.waitUntil(Condition.visible, TIMEOUT).click();
        vwSelection.waitUntil(Condition.visible, TIMEOUT).click();
        modelDropdown.waitUntil(Condition.visible, TIMEOUT).click();
        golfSelection.click();
        regionFilter.click();
        minskRegionSelection.click();
        extendedSearchButton.click();
        inputMinimumDisplacement.shouldBe(Condition.visible).setValue("1800");
        startSearchButton.click();

        brandDropdown.shouldBe(Condition.exactText("Volkswagen"));
        modelDropdown.shouldBe(Condition.exactText("Golf 2"));
    }

    @Test
    public void showAllBrands() {
        startup();
        SelenideElement showAllButton = $(By.xpath("html/body/div[3]/div[1]/main/div[3]/div[1]/div/p/a"));
        SelenideElement exclusiveLink = $(By.xpath("html/body/div[3]/div[1]/main/div[3]/div[1]/div/ul/li[94]/a/span"));

        showAllButton.waitUntil(Condition.visible, TIMEOUT).click();
        exclusiveLink.waitUntil(Condition.visible, TIMEOUT).shouldBe(Condition.exactText("Эксклюзив"));
    }

    @Test
    public void correctLogin() {
        startup();

        final String login = "тестер";
        final String email = "cnam.sux@gmail.com";
        final String pass = "tester228";

        SelenideElement loginLink = $(By.xpath("html/body/div[3]/div[1]/header/div/div[2]/div/p/a[1]"));
        SelenideElement loginInput= $(By.xpath(".//*[@id='login']"));
        SelenideElement passInput = $(By.xpath(".//*[@id='password']"));
        SelenideElement enterButton = $(By.xpath(".//*[@id='LoginForm']/div[3]/input"));
        SelenideElement nickLink = $(By.linkText(login));

        loginLink.click();
        loginInput.shouldBe(Condition.visible).setValue(email);
        loginInput.pressTab();
        passInput.sendKeys(pass);
        passInput.pressEnter();
        enterButton.click();
        nickLink.waitUntil(Condition.visible, TIMEOUT).shouldBe(Condition.exactText(login));

    }

    @Test
    public void incorrectLogin() {
        startup();

        final String email = "cam.sux@gmail.com";
        final String pass = "tester228";

        SelenideElement loginLink = $(By.xpath("html/body/div[3]/div[1]/header/div/div[2]/div/p/a[1]"));
        SelenideElement loginInput= $(By.xpath(".//*[@id='login']"));
        SelenideElement passInput = $(By.xpath(".//*[@id='password']"));
        SelenideElement errorLabel = $(By.xpath(".//*[@id='LoginForm']/div[3]/div/ul/li"));

        loginLink.click();
        loginInput.shouldBe(Condition.visible).setValue(email);
        passInput.sendKeys(pass);
        passInput.pressEnter();
        errorLabel.shouldBe(Condition.visible).shouldBe(Condition.exactText("Неверный логин или пароль"));
    }

    @Test
    public void logout() {
        correctLogin();

        SelenideElement logoutLink = $(By.xpath("html/body/div[2]/div[1]/header/div/div[2]/div/ul/li[3]/a/span"));
        logoutLink.shouldBe(Condition.visible).click();

        SelenideElement loginLink = $(By.xpath("html/body/div[3]/div[1]/header/div/div[2]/div/p/a[1]"));
        loginLink.shouldBe(Condition.visible).shouldBe(Condition.exactText("Войдите"));
    }

}
