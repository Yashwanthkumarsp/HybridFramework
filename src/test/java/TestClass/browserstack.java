package TestClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class browserstack {

    // 🔹 Step 1: BrowserStack credentials
    public static final String USERNAME = "yashwanth_cI8jeL";
    public static final String AUTOMATE_KEY = "eHhjAnZw9v8MisX2Dyaa";
    public static final String HUB_URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void testOnBrowserStack() throws MalformedURLException {

        // 🔹 Step 2: Browser options (ChromeOptions is now W3C-compliant)
        FirefoxOptions options = new FirefoxOptions();

        // 🔹 Step 3: Define BrowserStack-specific capabilities using "bstack:options"
        HashMap<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("os", "Windows");
        bstackOptions.put("osVersion", "11");
        bstackOptions.put("projectName", "Hybrid Automation Framework");
        bstackOptions.put("buildName", "Build_01");
        bstackOptions.put("sessionName", "BrowserStack Login Test"); // test name in dashboard
        bstackOptions.put("local", "false");
        bstackOptions.put("seleniumVersion", "4.23.0");

        // 🔹 Step 4: Attach BrowserStack options to browser options
        options.setCapability("bstack:options", bstackOptions);

        // 🔹 Step 5: Initialize the RemoteWebDriver
        WebDriver driver = new RemoteWebDriver(new URL(HUB_URL), options);

        // 🔹 Step 6: Test steps
        driver.get("https://www.facebook.com/");
        System.out.println("Page Title is: " + driver.getTitle());

        // 🔹 Step 7: Close session
        driver.quit();
    }
}
