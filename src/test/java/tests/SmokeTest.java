package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.*;

public class SmokeTest extends BaseTest {

    @Test
    public void CheckQAJobs() {
        String position = "Quality Assurance";
        String location = "Istanbul, Turkey";

        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.checkTitle());

        homePage.AcceptAllCookies();
        CareersPage careersPage = homePage.openCareersPage();
        Assert.assertTrue(careersPage.checkTitle());
        Assert.assertTrue(careersPage.isLocationsSectionExist());
        Assert.assertTrue(careersPage.isLifeAtInsiderSectionExist());

        careersPage.clickSeeAllTeamsButton();
        QAPage qaPage = careersPage.openQATeam();

        OpenPositionsPage openPositionsPage = qaPage.openPositionsPage();
        openPositionsPage.selectLocation(location);
        openPositionsPage.checkQAPositionsAndLocations(position, location);
        LeverApplicationPage leverApplicationPage = openPositionsPage.applyFirstPosition();
        Assert.assertTrue(leverApplicationPage.isApplyButtonExist());
    }

    @Test
    public void specialTestForFail() {
        HomePage homePage = new HomePage(getDriver());
        homePage.doSomethingForFail();
    }

}
