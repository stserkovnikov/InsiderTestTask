package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class LeverApplicationPage extends BasePage {
    public LeverApplicationPage(WebDriver driver) {
        super(driver);
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

    public boolean isApplyButtonExist() {
        return driver.findElement(By.xpath("//a[text()='Apply for this job']")).isDisplayed();
    }
}
