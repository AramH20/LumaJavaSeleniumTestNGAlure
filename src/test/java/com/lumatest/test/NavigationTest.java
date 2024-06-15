package com.lumatest.test;

import com.lumatest.base.BaseTest;
import com.lumatest.data.TestData;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test(
            description = "TC-O1 Open Base URL",
            groups = {"Smoke", "Regression"},
            testName = "NAVIGATION | Open Base URL"
    )
    @Story("Navigation")
    @Severity(SeverityLevel.BLOCKER)
    @Description("To werity that the last URL and title of the application are correct")
    @Link(TestData.BASE_URL)
    public void testOpenBaseURL(){
        Allure.step("Setup expected results");
        final String expectedURL = TestData.BASE_URL + "/";
        final String expectedTitle = TestData.BASE_TITLE;

        Allure.step("Open BaseURL");
        getDriver().get(TestData.BASE_URL);

        Allure.step("Collect actual URL abd actual Title");
        final String actualURL = getDriver().getCurrentUrl();
        final String actualTitle = getDriver().getTitle();

        Allure.step("Verify actual URL as expected");
        Assert.assertEquals(actualURL, expectedURL);
        Allure.step("Verify actual Title as expected");
        Assert.assertEquals(actualTitle, expectedTitle);
    }


    @Test(  groups = {"Smoke", "Regression"},
            dataProvider = "navigationData",
            dataProviderClass = TestData.class,
            description = "TC-02 Top Menu Navigation",
            testName = "NAVIGATION | Navigation To Top Menu"
    )
    @Story("Navigation")
    @Severity(SeverityLevel.CRITICAL)
    @Description("To verify that the top menu navigation on the website functions correctly by ensuring that " +
            "clicking on menu items directs the user to the expected URL with the expected title.")
    @Link(TestData.BASE_URL)
    public void testNavigationMenu(String baseURL, By navbarMenu, String expectedURL, String expectedTitle){
        Allure.step("Open Base URL");
        getDriver().get(baseURL);

        Allure.step("Click on" + navbarMenu.toString());
        getDriver().findElement(navbarMenu).click();

        Allure.step("Colect actualURL, actualTitle");
        final String actualURL = getDriver().getCurrentUrl();
        final String actualTitle = getDriver().getTitle();

        Allure.step("Verify actualURL as expected");
        Assert.assertEquals(actualURL, expectedURL);
        Allure.step("Verify actualTitle as expected");
        Assert.assertEquals(actualTitle, expectedTitle);
    }


}
