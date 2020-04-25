package bsturk.pages.n11;

import bsturk.tests.BaseTest;
import bsturk.utils.DriverFuncUtils;
import bsturk.utils.LogUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static bsturk.utils.AutomationProcess.WebTest_Automation_Task_Create_Page;
import static bsturk.utils.AutomationProcess.WebTest_Automation_Task_Page_Func;

public class MyWishListPage extends DriverFuncUtils {

    private int stepCount = 1;

    // Favorilerim butonunun elemet adresini tanımlama
    By myFavoritesButton = By.cssSelector("a[href='https://www.n11.com/hesabim/favorilerim']");


    public MyWishListPage(WebDriver driver) {
        super(driver);
        WebTest_Automation_Task_Create_Page("MyWishListPage", BaseTest.WebTest.N11);
    }

    public void clickMyFavorites() {

        WebTest_Automation_Task_Page_Func(stepCount,"Clicking the 'My Favorites List'");

        try {
            waitForPageLoad();
            waitForElementBy(myFavoritesButton).click();

        } catch (Exception e) {
            errorMessage("Clicking the 'My Favorites List'", e.getMessage());
            
        }
        stepCount++;
    }
}
