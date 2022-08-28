package com.spotify.methods;
import com.spotify.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class Methods{

    private static final Logger logger= LogManager.getLogger(Methods.class);

    // document.querySelector("button[data-testid='login-button']")
    // by.toString() == > findElementWait(by).getText() ile degistirildi

    WebDriver driver;
    FluentWait<WebDriver> fluentWait;
    JavascriptExecutor jsDriver;

    public Methods(){
        this.driver = Driver.driver;
        jsDriver = (JavascriptExecutor) driver;
        fluentWait = setFluentWait(15);
    }

    public FluentWait<WebDriver> setFluentWait(long timeout){

        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class);
    }

    public WebElement findElementWait(By by){
        return fluentWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void clickElement(By by){
        findElementWait(by).click();
        logger.info(by.toString()+ " elementine tiklandi");
    }
    public void clear(By by){

        logger.info(by.toString() + " elementin text'i temizlendi");
    }

    public void clickElementJs(By by){
        WebElement webElement = findElementWait(by);
        jsDriver.executeScript("arguments[0].click();", webElement);

    }

    public void sendKeys(By by, String text){
        findElementWait(by).sendKeys(text);
        logger.info(findElementWait(by).getText() + " elementine " + text +" text'i yazdirildi"); // by.toString()
    }

    public Select getSelect(By by){
        return new Select(findElementWait(by));
    }

    public void selectByValue(By by, String value){

        getSelect(by).selectByValue(value);
    }

    public String getText(By by){
        return findElementWait(by).getText();
    }

    public String getAttribute(By by, String attribute){
        return findElementWait(by).getAttribute(attribute);
    }

    public void hoverElement(By by){
        WebElement element = findElementWait(by);
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        logger.info(findElementWait(by).getText() + " elementine hover islemi yapildi");
    }

    public String getValue(By by){
        WebElement webElement = findElementWait(by);
        return jsDriver.executeAsyncScript("return arguments[0].value;",webElement).toString();
    }

    public void scrollElementCenter(By by){
        WebElement webElement = findElementWait(by);
        jsDriver.executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});",
                webElement);

        logger.info(by.toString() + " scrollelement center");
    }

    public void scrollElement(By by){
        WebElement webElement = findElementWait(by);
        jsDriver.executeScript("arguments[0].scrollIntoView()", webElement);
        logger.info(findElementWait(by).getText() + " scroll element");

    }

    public void scrollElementIfNeeded(By by){
        WebElement webElement = findElementWait(by);
        jsDriver.executeScript("arguments[0].scrollIntoViewIfNeeded()", webElement);
        logger.info(findElementWait(by).getText() + " scroll element if needed");
    }

    public boolean isElementVisible(By by, long timeout){
        try {
            setFluentWait(timeout).until(ExpectedConditions.visibilityOfElementLocated(by));
            logger.info(findElementWait(by).getText() + " ture");
            return true;
        }catch (Exception e){
            logger.info(findElementWait(by).getText() + " false");
            logger.error(e.getMessage());
            return false;
        }
    }
    public boolean isElementClickable(By by, long timeout){
        try {
            setFluentWait(timeout).until(ExpectedConditions.elementToBeClickable(by));
            logger.info(findElementWait(by).getText() + " element is clickable");
            return true;
        }catch (Exception e){
            logger.info(findElementWait(by).getText() + " element is not clickable");
            logger.error(e.getMessage());
            return false;
        }
    }

    public void waitBySeconds(long seconds){
        waitByMilliSeconds(1000*seconds);
        logger.info(seconds + " saniye beklendi");
    }
    public void waitByMilliSeconds(long milliSeconds){
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (milliSeconds % 1000 != 0)
            logger.info(milliSeconds + " milisaniye beklendi");
    }

    public void rightClick(By by){
        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(by);
        actions.contextClick(elementLocator).perform();
    }
}
