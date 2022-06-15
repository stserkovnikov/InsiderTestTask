package tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void initWebdriver() {
        String browser = System.getProperty("browser");
        if (browser == null) {
            browser = "chrome";
        } else {
            browser = browser.toLowerCase();
        }
        if ("firefox".equals(browser)) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void cleanUp(ITestResult result) {
        try {
            takeAScreenshotOnFail(result);
        } catch (RuntimeException e) {
            System.out.println("Something wrong in tear down process");
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    private void takeAScreenshotOnFail(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);
                try {
                    Path path = Paths.get(".//target//Screenshots//");
                    Files.createDirectories(path);
                    FileHandler.copy(source, new File(path + "//" + result.getName() + ".png"));
                    System.out.println("Screenshot taken");
                } catch (IOException e) {
                    System.out.println("IO exception:" + e.getMessage());
                }
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }
}
