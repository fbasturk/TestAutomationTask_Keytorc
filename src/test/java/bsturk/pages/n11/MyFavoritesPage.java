package bsturk.pages.n11;

import bsturk.tests.BaseTest;
import bsturk.utils.DriverFuncUtils;
import bsturk.utils.LogUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static bsturk.utils.AutomationProcess.WebTest_Automation_Task_Create_Page;
import static bsturk.utils.AutomationProcess.WebTest_Automation_Task_Page_Func;
import static java.lang.Thread.sleep;

public class MyFavoritesPage extends DriverFuncUtils {
    private int stepCount = 1;

    // Ürünlerin listesini belirten element adresini tanımlama
    By itemListElement = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[3]/div[1]/div[2]/ul/li");

    // Ürünün adını belirten element adresini tanımlama
    By productNameElement = By.cssSelector("div[class*='columnContent']");

    // Ürünü favorilerden silme butonunun element adresini tanımlama
    By productDeleteElement = By.className("deleteProFromFavorites");

    // Ürünün silindiği bilgisini veren element adresini tanımlama
    By warningButton = By.cssSelector("span[class='btn btnBlack confirm']");


    public MyFavoritesPage(WebDriver driver) {
        super(driver);
        WebTest_Automation_Task_Create_Page("MyFavoritesPage", BaseTest.WebTest.N11);
    }

    public void checkItemInFavorites(String favoriteItemName) {
        WebTest_Automation_Task_Page_Func(stepCount, "Checking the selected item added status to 'Favorites'");
        boolean isEqualsProductName = false;
        try {
            waitForPageLoad();
            List<WebElement> favoriteItemList = waitForElementsBy(itemListElement);


            for (WebElement element : favoriteItemList) {
                String productName = element.findElement(productNameElement).getAttribute("id");
                if (favoriteItemName.equals(productName)) {
                    isEqualsProductName = true;
                    break;
                }
            }
        } catch (Exception e) {
            errorMessage("Checking the selected item added status to 'Favorites'", e.getMessage());

        }

        Assert.assertTrue("Selected item is not added 'Favorites'", isEqualsProductName);
        stepCount++;
    }

    public void clickDeleteFavorite(String favoriteItemName) {
        WebTest_Automation_Task_Page_Func(stepCount, "Deleting the selected item from 'Favorites'");
        try {
            List<WebElement> favoriteItemList = waitForElementsBy(itemListElement);


            for (WebElement element : favoriteItemList) {
                String productName = element.findElement(productNameElement).getAttribute("id");
                if (favoriteItemName.equals(productName)) {
                    element.findElement(productDeleteElement).click();
                    break;
                }
            }
        } catch (Exception e) {
            errorMessage("Deleting the selected item from 'Favorites'", e.getMessage());

        }
        stepCount++;
    }

    public void closeDeleteInfo() {
        WebTest_Automation_Task_Page_Func(stepCount, "Clicking the 'OK' button for closing the popup");

        try {
            sleep(1000);
            waitWarningForElementBy(warningButton).click();
            sleep(1500);
        } catch (Exception e) {
            errorMessage("Clicking the 'OK' button for closing the popup", e.getMessage());
        }
        stepCount++;
    }

    public void checkDeletedItem(String favoriteItemName) {
        WebTest_Automation_Task_Page_Func(stepCount, "Checking the selected item deleted status from 'Favorites'");
        boolean isEqualsProductName = false;
        List<WebElement> favoriteItemList = null;

        try {
            waitForPageLoad();
            favoriteItemList = waitForElementsBy(itemListElement);
        } catch (Exception e) {
            // Hiç ürün bulunmuyor.
            isEqualsProductName = false;
        }

        try {
            if (favoriteItemList != null)
                for (WebElement element : favoriteItemList) {
                    String productName = element.findElement(productNameElement).getAttribute("id");
                    if (favoriteItemName.equals(productName)) {
                        isEqualsProductName = true;
                        break;
                    }
                }
        } catch (Exception e) {
            errorMessage("Checking the selected item deleted status from 'Favorites'", e.getMessage());
        }

        Assert.assertFalse("Selected item did not delete", isEqualsProductName);
        stepCount++;
    }
}
