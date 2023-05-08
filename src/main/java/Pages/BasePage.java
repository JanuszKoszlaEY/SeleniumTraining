package Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public abstract class BasePage {
    public WebDriver driver;
    public Logger log;

    BasePage(WebDriver driver, Logger log){
        this.driver = driver;
        this.log = log;
    }
    public void openUrl(String url){
        driver.get(url);
    }

    protected WebElement find(By locator)
    {
        return driver.findElement(locator);
    }

    protected void click(By locator) {
        waitForVisibilityOf(locator, 5);
        find(locator).click();
    }

    protected void type(String text, By locator) {
        waitForVisibilityOf(locator, 5);
        find(locator).sendKeys(text);
    }


    private void waitFor(ExpectedCondition<WebElement> condition, Duration timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : Duration.ofSeconds(30);
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(timeOutInSeconds)
            .pollingEvery(Duration.ofSeconds(1))
            .until(condition);



    }

    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {

        try {
            waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                    Duration.ofDays((timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null)));

        } catch (StaleElementReferenceException e) {
        }

    }

    public void scrollToBottom() {
        log.info("Scrolling to the bottom of the page");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    protected void switchToFrame(By frameLocator) {
        driver.switchTo().frame(find(frameLocator));
    }

}
