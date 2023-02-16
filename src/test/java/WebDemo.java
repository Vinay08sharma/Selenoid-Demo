import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.HashMap;

public class WebDemo {

    WebDriver driver;
    @Test
    public void startBrowser() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems

        options.setCapability("selenoid:options", new HashMap<String, Object>() {{

            /* How to enable video recording */
            put("enableVNC", true);
            put("enableVideo", true);
        }});

        options.setCapability("browserVersion", "91.0.b");
        driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), options);


        driver.get("https://google.com");
        System.out.println(driver.getTitle());

        driver.findElement(By.name("q")).sendKeys("selenoid");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        System.out.println(driver.getTitle());
        Thread.sleep(10000);
        driver.quit();
    }
}
