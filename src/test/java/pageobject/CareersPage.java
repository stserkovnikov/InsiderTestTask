package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareersPage extends BasePage {
    private final By seeAllTeamsButton = By.xpath("//a[text()='See all teams']");
    private final By qaButton = By.xpath("//h3[text()='Quality Assurance']");

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkTitle() {
        return getTitle().equals("Insider Careers");
    }

    public boolean isLocationsSectionExist() {
        return driver.findElement(By.id("career-our-location")).isDisplayed();
    }

    public boolean isLifeAtInsiderSectionExist() {
        return driver.findElement(By.xpath("//section[@data-element_type='section']//h2[text()='Life at Insider']"))
                .isDisplayed();
    }

    public void clickSeeAllTeamsButton() {
        ScrollToElementIntoMiddle(driver.findElement(seeAllTeamsButton));
        driver.findElement(seeAllTeamsButton).click();
    }


    public QAPage openQATeam() {
        ScrollToElementIntoMiddle(driver.findElement(qaButton));
        driver.findElement(qaButton).click();
        return new QAPage(driver);
    }
}
