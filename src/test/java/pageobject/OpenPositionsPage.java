package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class OpenPositionsPage extends BasePage {
    public OpenPositionsPage(WebDriver driver) {
        super(driver);
    }

    public void selectLocation(String text) {
        waitForJQueryLoad();
        String elementLocator = String.format("//ul[@id='select2-filter-by-location-results']//li[text()='%s']", text);
        String menuLocator = "select2-filter-by-location-container";
        WebElement menu = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(menuLocator)));

        menu.click();
        driver.findElement(By.xpath(elementLocator)).click();
        waitForJQueryLoad();
    }

    public void checkQAPositionsAndLocations(String position, String location) {
        List<WebElement> jobList = driver.findElements(By.xpath("//div[@id='jobs-list']"));

        for (WebElement element : jobList) {
            String actualPosition = element.findElement(By.xpath("//span[contains(@class, 'position-department')]")).getText();
            Assert.assertEquals(actualPosition, position);
        }

        for (WebElement element : jobList) {
            String actualLocation = element.findElement(By.xpath("//div[contains(@class, 'position-location')]")).getText();
            Assert.assertEquals(actualLocation, location);
        }
    }

    public LeverApplicationPage applyFirstPosition() {
        driver.findElement(By.xpath("//div[@id='jobs-list']//a[text()='Apply Now']")).click();
        return new LeverApplicationPage(driver);
    }

}
