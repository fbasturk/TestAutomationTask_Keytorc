package bsturk.tests;

import bsturk.pages.n11.*;
import org.openqa.selenium.WebDriver;

import static bsturk.utils.AutomationProcess.*;

public class N11Test {


    private WebDriver driver;
    private String favoriteProductID;

    N11Test(WebDriver driver) {
        WebTest_Automation_Task_Create_WebDriver(BaseTest.WebTest.N11);
        this.driver = driver;
    }


    public void homePageTest() {
        HomePage homePage = new HomePage(driver);

        homePage.goToPage();
        homePage.closeKVKKIfFirstOpen();
        homePage.checkOpenPage();
        homePage.clickLogin();

        WebTest_Automation_Task_Finish_Page("HomePage", BaseTest.WebTest.N11);
    }


    public void loginPageTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.setUserEmail();
        loginPage.setUserPassword();
        loginPage.clickLogin();


        WebTest_Automation_Task_Finish_Page("LoginPage", BaseTest.WebTest.N11);
    }

    public void homePageTestWithLogin() {
        HomePage homePage = new HomePage(driver);

        homePage.searchItem();
        homePage.clickSearch();

        WebTest_Automation_Task_Finish_Page("HomePageWithLogin", BaseTest.WebTest.N11);
    }

    public void searchPage() {
        SearchPage searchPage = new SearchPage(driver);

        searchPage.checkItemsInSearch();
        searchPage.scrollSecondPageButton();
        searchPage.clickTwoPage();
        searchPage.checkOpenSecondPage();
        searchPage.scrollItem();
        favoriteProductID = searchPage.clickAddFavorite();
        searchPage.closeInfoIfAdded();
        searchPage.scrollMyAccount();
        searchPage.clickMyWishList();

        WebTest_Automation_Task_Finish_Page("SearchPage", BaseTest.WebTest.N11);
    }

    public void myWishListPage() {
        MyWishListPage wishListPage = new MyWishListPage(driver);

        wishListPage.clickMyFavorites();

        WebTest_Automation_Task_Finish_Page("MyWishListPage", BaseTest.WebTest.N11);
    }

    public void myFavoritesPage() {
        MyFavoritesPage myFavoritesPage = new MyFavoritesPage(driver);

        myFavoritesPage.checkItemInFavorites(favoriteProductID);
        myFavoritesPage.clickDeleteFavorite(favoriteProductID);
        myFavoritesPage.closeDeleteInfo();
        myFavoritesPage.checkDeletedItem(favoriteProductID);

        WebTest_Automation_Task_Finish_Page("MyFavoritesPage", BaseTest.WebTest.N11);
    }


}
