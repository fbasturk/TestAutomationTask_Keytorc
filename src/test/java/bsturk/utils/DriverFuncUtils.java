package bsturk.utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.function.Function;

public class DriverFuncUtils {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private WebDriverWait driverWarningWait;

    public DriverFuncUtils(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, 30);
        this.driverWarningWait = new WebDriverWait(driver, 5);
    }

    public void GoPage(String link) {
        driver.get(link);
    }

    public String getPageLink() {
        return driver.getCurrentUrl();
    }

    public WebElement waitWarningForElementBy(By cssSelector) {
        return driverWarningWait.until(ExpectedConditions.visibilityOfElementLocated(cssSelector));

    }

    public WebElement waitForElementBy(By cssSelector) {
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(cssSelector));

    }

    public List<WebElement> waitForElementsBy(By cssSelector) {
        return driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cssSelector));
    }

    public WebElement waitForElement(WebElement element) {
        return driverWait.until(ExpectedConditions.visibilityOf(element));

    }

    public WebElement elementBy(By cssSelector) {
        return driver.findElement(cssSelector);
    }

    public List<WebElement> elementsBy(By cssSelector) {
        return driver.findElements(cssSelector);
    }

    public void ScrollJSElement(By cssSelector) {
        WebElement element = driver.findElement(cssSelector);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollEventElement(String selector) {
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.executeScript("document.querySelector(\"" + selector + "\").scrollTop= 500");
    }

    public void hoverToClickElement(By hoverSelector, By clickSelector) {
        Actions action = new Actions(driver);
        WebElement hoverElement = driver.findElement(hoverSelector);
        WebElement clickElement = driver.findElement(clickSelector);
        action.moveToElement(hoverElement).moveToElement(clickElement).click().build().perform();
    }

    public void moveToClickElement(By cssSelector) {
        WebElement element = driver.findElement(cssSelector);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    public void JSClickElement(By cssSelector) {
        WebElement element = driver.findElement(cssSelector);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void waitForPageLoad() {

        driverWait.until(driver -> {
            LogUtil.otherInfo(" Current Window State       : "
                    + ((JavascriptExecutor) driver).executeScript("return document.readyState"));
            return String
                    .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                    .equals("complete");
        });
    }

    public void errorMessage(String message, String exceptionMessage) {
        LogUtil.error(message, exceptionMessage);
        Assert.fail(message);
    }


    public void Quit() {
        driver.quit();
    }


}
