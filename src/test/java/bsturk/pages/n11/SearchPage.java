package bsturk.pages.n11;

import bsturk.tests.BaseTest;
import bsturk.utils.DriverFuncUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static bsturk.utils.AutomationProcess.*;
import static java.lang.Thread.sleep;

public class SearchPage extends DriverFuncUtils {

    private int stepCount = 1;

    String twoPageLink = "https://www.n11.com/arama?q=samsung&pg=2";

    // Arama sonuçları element adresleri
    By searchResultArea = By.cssSelector("div[class='resultText ']");
    By resultText = By.tagName("strong");


    // Arama sonuclarında ikinci sayfaya gecme butonu element adresi
    By secondPageButton = By.cssSelector("a[href='https://www.n11.com/arama?q=samsung&pg=2']");

    // Arama sonucları sayfalarının liste elementleri adresleri
    By pageListElement = By.className("pagination");
    By activeElement = By.cssSelector("a[class='active ']");

    // Arama sonucu cıkan ogeleri iceren elementlerin adresleri
    By itemListElement = By.cssSelector("div[class='listView ']");
    By itemElement = By.tagName("li");
    By addFavoriteButton = By.xpath("/html/body/div[1]/div[3]/div/div/div[2]/section[1]/div[2]/ul/li[3]/div/div[1]/span");
    By productNameElement = By.xpath("/html/body/div[1]/div[3]/div/div/div[2]/section[1]/div[2]/ul/li[3]/div");

    // Ürün zaten favorilerime ekli uyarısı kapatmak icin buton elementi adresi
    By warningButton = By.cssSelector("span[class='btn btnBlack confirm']");

    //İstek listem butonu element adresi
    By myAccountButton = By.cssSelector("a[title='Hesabım']");
    By myWishListButton = By.cssSelector("a[title='Favorilerim / Listelerim']");


    public SearchPage(WebDriver driver) {
        super(driver);
        WebTest_Automation_Task_Create_Page("SearchPage", BaseTest.WebTest.N11);
    }

    public void checkItemsInSearch() {
        WebTest_Automation_Task_Page_Func(stepCount, "Checking is there a result for the searched item");

        try {
            waitForPageLoad();

            ScrollJSElement(searchResultArea);
            WebElement searchResultSizeElement = waitForElementBy(searchResultArea).findElement(resultText);

            Assert.assertNotEquals("There is no any result", "0", searchResultSizeElement.getText());
        } catch (Exception e) {
            errorMessage("Checking is there a result for the searched item", e.getMessage());
        }
        stepCount++;
    }

    public void scrollSecondPageButton() {
        WebTest_Automation_Task_Page_Func(stepCount, "Scrolling down to pages area");

        try {
            ScrollJSElement(secondPageButton);
        } catch (Exception e) {
            errorMessage("Scroll down to pages area", e.getMessage());

        }
        stepCount++;
    }

    public void clickTwoPage() {
        WebTest_Automation_Task_Page_Func(stepCount, "Clicking the 'Second Page' button");

        try {
            waitForElementBy(secondPageButton).click();
        } catch (Exception e) {
            errorMessage("Clicking the 'Second Page' button", e.getMessage());
        }
        stepCount++;
    }

    public void checkOpenSecondPage() {
        WebTest_Automation_Task_Page_Func(stepCount, "Checking the opening status of 'Second Page'");

        waitForPageLoad();

        Assert.assertEquals("Visited page is not 'Second Page'", twoPageLink, getPageLink());

        String isActivePage = "";
        try {
            isActivePage = waitForElementBy(pageListElement).findElement(activeElement).getText();

        } catch (Exception e) {
            errorMessage("Checking the opening status of 'Second Page'", e.getMessage());

        }
        Assert.assertEquals("Visited page is not 'Second Page'", "2", isActivePage);
        stepCount++;
    }

    public void scrollItem() {
        WebTest_Automation_Task_Page_Func(stepCount, "Scrolling down to reach list of items");

        try {
            ScrollJSElement(itemListElement);
        } catch (Exception e) {
            errorMessage("Scrolling down to reach list of items", e.getMessage());

        }
        stepCount++;
    }

    public String clickAddFavorite() {
        WebTest_Automation_Task_Page_Func(stepCount, "Adding the third item to 'My Favorites'");

        try {
            waitForElementBy(addFavoriteButton).click();
            //    itemList.get(2).findElement(addFavoriteButton).click();

            return waitForElementBy(productNameElement).getAttribute("id");

        } catch (Exception e) {
            errorMessage("Adding the third item to 'My Favorites'", e.getMessage());

            return "Error: Adding the third item to 'My Favorites'";

        } finally {
            stepCount++;
        }

    }

    public void closeInfoIfAdded() {
        WebTest_Automation_Task_Page_Func(stepCount,"Clicking the 'OK' button for closing the popup");

        try {
            sleep(1000);
            waitWarningForElementBy(warningButton).click();
            sleep(1500);
        } catch (Exception e) {
            WebTest_Automation_Task_Page_Bypass("Bypass the popup");
        }
        stepCount++;
    }

    public void scrollMyAccount() {
        WebTest_Automation_Task_Page_Func(stepCount,"Scrolling up to 'My Account' button");

        try {
            ScrollJSElement(myAccountButton);
        } catch (Exception e) {
            errorMessage("Scrolling up to 'My Account' button", e.getMessage());

        }
        stepCount++;
    }

    public void clickMyWishList() {
        WebTest_Automation_Task_Page_Func(stepCount,"Clicking the 'My Favorites / Lists' button");

        try {

            waitForElementBy(myAccountButton);
            hoverToClickElement(myAccountButton, myWishListButton);

        } catch (Exception e) {
            errorMessage("Clicking the 'My Favorites / Lists' button", e.getMessage());

        }
        stepCount++;
    }


}
