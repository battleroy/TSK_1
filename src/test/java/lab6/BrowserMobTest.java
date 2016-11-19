package lab6;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Test
public class BrowserMobTest {

    private static final String START_URL = "http://tunein.com/";

    BrowserMobProxy proxy;
    WebDriver webDriver;

    @BeforeTest
    public void startup() {
        proxy = new BrowserMobProxyServer();
        proxy.start();

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(CapabilityType.PROXY, ClientUtil.createSeleniumProxy(proxy));

        webDriver = new FirefoxDriver(capabilities);
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);

        webDriver.get(START_URL);
    }

    public void testMusic() {

        WebElement element = webDriver.findElement(By.xpath(".//*[@id='mainNav']/li[2]/a"));

        proxy.newHar("TuneIN Music");

        element.click();

        Har har = proxy.getHar();

        try {
            File file = new File("./tuneinMusic.har");
            file.createNewFile();
            har.writeTo(new FileOutputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void testLocal() {

        WebElement element = webDriver.findElement(By.xpath(".//*[@id='mainNav']/li[1]/a"));

        proxy.newHar("TuneIN Local");

        element.click();

        Har har = proxy.getHar();

        try {
            File file = new File("./tuneinLocal.har");
            file.createNewFile();
            har.writeTo(new FileOutputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @AfterTest
    public void cleanup() {
        proxy.stop();
        webDriver.close();
    }
}
