package bsturk.pages.n11;

import bsturk.tests.BaseTest;
import bsturk.utils.DriverFuncUtils;
import bsturk.utils.LogUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static bsturk.utils.AutomationProcess.WebTest_Automation_Task_Create_Page;
import static bsturk.utils.AutomationProcess.WebTest_Automation_Task_Page_Func;
import static java.lang.Thread.sleep;

public class LoginPage extends DriverFuncUtils {
    private int stepCount=1;

    // Mail ve şifre alanının element adresini tanımlama
    By emailArea = By.id("email");
    By passwordArea = By.id("password");

    // Login butonunun element adresini tanımlama
    By loginButton = By.id("loginButton");

    public LoginPage(WebDriver driver) {
        super(driver);
        WebTest_Automation_Task_Create_Page("LoginPage", BaseTest.WebTest.N11);
    }

    public void setUserEmail() {
        WebTest_Automation_Task_Page_Func(stepCount,"Email address is writing to email area");

        try {
            waitForPageLoad();
            waitForElementBy(emailArea).clear();
            waitForElementBy(emailArea).sendKeys("furkan.testautomation@gmail.com");

        } catch (Exception e) {
            errorMessage("Email address is writing to email area", e.getMessage());
            
        }
        stepCount++;
    }

    public void setUserPassword() {
        WebTest_Automation_Task_Page_Func(stepCount,"Password is writing to password area");

        try {
            waitForElementBy(passwordArea).clear();
            waitForElementBy(passwordArea).sendKeys("12345678f");

        } catch (Exception e) {
            errorMessage("Password is writing to password area", e.getMessage());
            
        }
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
}
