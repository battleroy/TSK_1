package lab9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

@Test
public class BrowserstackTester {

    public static final String USERNAME = "yauhenichasavits1";
    public static final String AUTOMATE_KEY = "Jrjorwtga6xxxhRyyQuz";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public void runStack() throws Exception {
        List<Map<String, String>> configs = getStack();

        if (configs != null) {

            for (Map<String, String> config : configs) {

                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("browser", config.get("browser"));
                caps.setCapability("browser_version", config.get("browser_version"));
                caps.setCapability("os", config.get("os"));
                caps.setCapability("os_version", config.get("os_version"));
                caps.setCapability("browserstack.debug", "true");
                WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

                tutbyTest(driver);

                driver.quit();
            }

        }
    }

    private void tutbyTest(WebDriver driver) {
        driver.get("https://www.tut.by/");

        WebElement searchBar = driver.findElement(By.xpath(".//*[@id='search_from_str']"));
        searchBar.click();
        searchBar.sendKeys("big russian boss torrent");

        WebElement searchButton = driver.findElement(By.xpath(".//*[@id='search']/div/div[1]/input[2]"));
        searchButton.click();

        WebElement firstLink = driver.findElement(By.xpath("html/body/div[3]/div/div[2]/div[2]/div/div[2]/ol/li[1]/p[2]"));
        assertTrue(firstLink.getText().contains("Big Russian Bo$$"));
    }


    private List<Map<String, String>> getStack() {

        try {
            BufferedReader br = new BufferedReader(new FileReader("browserstack.csv"));

            List<Map<String, String>> result = new ArrayList<Map<String, String>>();

            String line = null;
            while ((line = br.readLine()) != null) {
                String[] items = line.split(",");

                Map<String, String> browserConfig = new HashMap<String, String>();

                browserConfig.put("browser", items[0]);
                browserConfig.put("browser_version", items[1]);
                browserConfig.put("os", items[2]);
                browserConfig.put("os_version", items[3]);

                result.add(browserConfig);
            }

            return result;

        } catch (Exception e) {
            return null;
        }

    }

}
