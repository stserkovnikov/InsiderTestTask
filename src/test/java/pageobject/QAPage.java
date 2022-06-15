package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QAPage extends BasePage {
    public QAPage(WebDriver driver) {
        super(driver);
    }

    public OpenPositionsPage openPositionsPage() {
        driver.findElement(By.xpath("//a[text()='See all QA jobs']")).click();
        return new OpenPositionsPage(driver);
    }
}
