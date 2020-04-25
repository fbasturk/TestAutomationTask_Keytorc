package bsturk.tests;

import bsturk.utils.CreateDriverUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import bsturk.utils.AutomationProcess;
import org.openqa.selenium.WebDriver;

import static bsturk.utils.AutomationProcess.*;

public class BaseTest {
    public enum WebTest {

        N11("N11");

        private String testName;

        private WebTest(String testName) {
            this.testName = testName;
        }

        public String getTestName() {
            return testName;
        }
    }

    private WebDriver driver;
    private long startTime;
    private String webDriverTypeName;

    @Before
    public void baseTest() {
        AutomationProcess.WebTest_Automation_Task_Start();
    }


    @Test
    public void N11FirefoxTest() {
        WebTest_Automation_Task_Start_Browser(CreateDriverUtil.WebDriverType.FIREFOX.getDriverName());
        this.driver = CreateDriverUtil.CreateDriver(CreateDriverUtil.WebDriverType.FIREFOX);
        this.driver.manage().window().maximize();
        this.webDriverTypeName =CreateDriverUtil.WebDriverType.FIREFOX.getDriverName();
        this.startTime = System.currentTimeMillis();
        n11TestFunc( driver);
    }

    private void n11TestFunc( WebDriver driver) {
        WebTest_Automation_Task_Start_N11Test(webDriverTypeName, WebTest.N11);

        N11Test n11Test = new N11Test( driver);

        WebTest_Automation_Task_TestStart(WebTest.N11);

        WebTest_Automation_Task_Test(1, "HomePage", WebTest.N11);
        n11Test.homePageTest();

        WebTest_Automation_Task_Test(2, "LoginPage", WebTest.N11);
        n11Test.loginPageTest();

        WebTest_Automation_Task_Test(3, "HomePageWithLogin", WebTest.N11);
        n11Test.homePageTestWithLogin();

        WebTest_Automation_Task_Test(4, "SearchPage", WebTest.N11);
        n11Test.searchPage();

        WebTest_Automation_Task_Test(5, "WishListPage", WebTest.N11);
        n11Test.myWishListPage();

        WebTest_Automation_Task_Test(6, "MyFavoritesPage", WebTest.N11);
        n11Test.myFavoritesPage();

    }

    @After()
    public void tearDown() {
        if (driver != null)
            driver.quit();

        long testTime = System.currentTimeMillis() - startTime;
        WebTest_Automation_Task_Finish_Browser(testTime, webDriverTypeName);
    }

}
