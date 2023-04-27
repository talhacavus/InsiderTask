package com.insider.methods;

import com.insider.driver.DriverBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.logging.Logger;

import static com.insider.driver.DriverBase.driver;

public class Methods {
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;
    Logger logger;

    public Methods() {

        driver = DriverBase.driver;
        wait = new FluentWait<WebDriver>(driver);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        jsdriver = (JavascriptExecutor) driver;
    }

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(By by) {
        findElement(by).click();
    }

    public void waitBySeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isElementVisible(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public void isDisplayed(By by){

        findElement(by).isDisplayed();
    }

    public void scrollWithAction(By by) {

        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollLittleBitUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-250)");
    }

    public List<WebElement> findElements(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElements(by);
    }


    public Select getSelect(By by) {
        return new Select(findElement(by));
    }

    public void scrollWithAction(WebElement el) {
        Actions actions = new Actions(driver);
        actions.moveToElement(el).build().perform();
    }

    public void cookies(){

        driver.manage().getCookies();
        driver.manage().deleteAllCookies();
    }

    public void clickRandom() {
        Random rnd = new Random();
        List<WebElement> pproducts = findElements(By.cssSelector(".cover"));
        WebElement rndProduct = pproducts.get(rnd.nextInt(pproducts.size()));
        scrollWithAction(rndProduct);
        rndProduct.click();

    }

    public void selectByText(By by, String text) {
        getSelect(by).selectByVisibleText(text);
    }

    public String getAttribute(By by, String attributeName) {
        return findElement(by).getAttribute(attributeName);
    }


    public String getText(By by) {
        return findElement(by).getText();

    }

    public void switchTab() {

        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
            }
        }

    }

    public void selectByValue(By by, String text) {
        getSelect(by).selectByValue(text);
    }

}
