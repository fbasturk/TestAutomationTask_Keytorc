package bsturk.pages.n11;

import bsturk.tests.BaseTest;
import bsturk.utils.DriverFuncUtils;
import bsturk.utils.LogUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static bsturk.utils.AutomationProcess.*;

public class HomePage extends DriverFuncUtils {
    private int stepCount=1;
    private String homePageLink = "https://www.n11.com/";

    // Gizlilik politikası uyarısı onaylama butonu element adresini tanımlama
    By warningButton = By.cssSelector("span[class='btn btnBlack']");

    // Login butonu element adresini tanımlama
    By loginButton = By.className("btnSignIn");

    // Arama yapmak icin yazı alanı ve arama butonu element adresini tanımlama
    By searchArea = By.id("searchData");
    By searchButton = By.cssSelector("span[class='icon iconSearch']");


    public HomePage(WebDriver driver) {
        super(driver);
        WebTest_Automation_Task_Create_Page("HomePage", BaseTest.WebTest.N11);
    }

    public void goToPage() {
        WebTest_Automation_Task_Page_Func(stepCount,"Visiting 'Homepage'");
        try {
            GoPage(homePageLink);
        } catch (Exception e) {
            errorMessage("'Homepage' visiting", e.getMessage());
        }
        stepCount++;
    }

    public void closeKVKKIfFirstOpen() {
        WebTest_Automation_Task_Page_Func(stepCount,"Clicking the 'OK' button for closing GDPR popup");

        try {
            waitForPageLoad();
            waitWarningForElementBy(warningButton).click();
        } catch (Exception e) {
            WebTest_Automation_Task_Page_Bypass("Bypass the GDPR popup");
        }
        stepCount++;
    }

    public void checkOpenPage() {
        WebTest_Automation_Task_Page_Func(stepCount,"Checking 'Homepage' visit");

        Assert.assertEquals("Visited page is not 'Homepage'", homePageLink, getPageLink());
        stepCount++;
    }

    public void clickLogin() {
        WebTest_Automation_Task_Page_Func(stepCount,"Clicking the 'Login' button");

        try {
            waitForElementBy(loginButton).click();
        } catch (Exception e) {
            errorMessage("Clicking the 'Login' button", e.getMessage());

        }
        stepCount++;
    }

    public void searchItem() {
        WebTest_Automation_Task_Page_Func(stepCount,"The given item 'samsung' is writing to search bar.");

        try {
            waitForPageLoad();
            waitForElementBy(searchArea).clear();
            waitForElementBy(searchArea).sendKeys("samsung");
        } catch (Exception e) {
            errorMessage("The given item 'samsung' is writing to search bar.", e.getMessage());

        }
        stepCount++;
    }

    public void clickSearch() {
        WebTest_Automation_Task_Page_Func(stepCount,"Clicking the 'Search' button");

        try {
            waitForElementBy(searchButton).click();
        } catch (Exception e) {
            errorMessage("Clicking the 'Search' button", e.getMessage());

        }
        stepCount++;
    }
}
