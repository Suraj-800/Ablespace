package pageobjectpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver; // Use protected to allow access in subclasses
    private String browser;

    // Constructor that accepts WebDriver
    public BasePage(WebDriver driver) {
        this.driver = driver; // Initialize the driver passed from subclasses
        PageFactory.initElements(driver, this); // Initialize web elements
    }

    // Constructor that initializes the browser
    public BasePage(String browser) {
        this.browser = browser; // Assign the browser name directly
        this.driver = initializeBrowser(this.browser.toLowerCase()); // Pass it to the method
        PageFactory.initElements(driver, this); // Initialize web elements
    }


    public WebDriver initializeBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-web-security");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);
        }
        // Other browser setups...

        driver.manage().window().maximize();
        return driver;
    }


    // Method to navigate to a URL
    public void navigateToUrl(String url) {
        driver.get(url);
    }

    // Method to close the browser
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Getter for driver (if needed in subclasses)
    public WebDriver getDriver() {
        return driver;
    }
}

