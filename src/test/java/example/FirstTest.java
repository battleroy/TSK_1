package example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstTest {

    //TODO: 5 TESTOV SDELAT S PROVERKAMI

    private ChromeDriver chromeDriver = new ChromeDriver();
    private String url = "http://av.by/";

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

    @Test
    public void userCanLoginByUsername() {
        Configuration.browser = "chrome";
        open(url);
        $(By.xpath(".//*[@id='submit_presearch']")).click();
        $(By.xpath(".//*[@id='brand_id_chosen']/a/span")).shouldBe(Condition.visible);
        $(By.xpath(".//*[@id='brand_id_chosen']/a/span")).click();
        $(By.xpath(".//*[@id='brand_id_chosen']/div/ul/li[80]")).click();
        $(By.xpath(".//*[@id='model_id_chosen']/a/span")).click();
        $(By.xpath(".//*[@id='model_id_chosen']/div/ul/li[13]")).click();
        $(By.xpath(".//*[@id='region_id_filter_chosen']/a/span")).click();
        $(By.xpath(".//*[@id='region_id_filter_chosen']/div/ul/li[6]")).click();
        $(By.xpath(".//*[@id='search_extend_link']")).click();
        $(By.xpath(".//*[@id='PublicPassengerFilter']/div/div[3]/div[1]/div/div[2]/div[1]/input")).setValue("1800");
        $(".//*[@id='PublicPassengerFilter']/div/div[9]/input[1]").click();
    }



}
