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
//        DesiredCapabilities capability = new DesiredCapabilities();
//        capability.setBrowserName("chrome");
//        capability.setVersion("109.0");
//        capability.setCapability("enableVNC", true);
//        capability.setCapability("enableVideo", true);
//        capability.setCapability("videoName", "test_video.mp4");
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

        options.setCapability("browserVersion", "109.0");
        driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), options);


        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        Thread.sleep(10000);
        driver.quit();
    }
}
