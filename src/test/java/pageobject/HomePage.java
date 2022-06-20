package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final By moreButton = By.xpath("//span[text()='More']");
    private final By careersButton = By.xpath("//h5[text()='Careers']");

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get("https://useinsider.com/");
    }

    public CareersPage openCareersPage() {
        driver.findElement(moreButton).click();
        driver.findElement(careersButton).click();
        return new CareersPage(driver);
    }

    public boolean checkTitle() {
        return getTitle().contains("Insider");
    }

    public void doSomethingForFail() {
        driver.findElement(By.xpath("//div[text()='we cannot find this']")).click();
    }

}
