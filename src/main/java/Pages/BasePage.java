package Pages;

import Utilities.PropertyManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class BasePage {
    public WebDriver driver;
    public Logger log;
    public String baseURL = PropertyManager.getInstance().getURL();
    BasePage(WebDriver driver, Logger log){
        this.driver = driver;
        this.log = log;
    }
    public void openUrl(){
        driver.get(baseURL);
    }
    public void openUrl(String url){
        driver.get(url);
    }

    protected WebElement find(By locator)
    {
        waitForVisibilityOf(locator, 5);
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

    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    protected void scrollToElement(By locator){
        log.info("Scrolling to element");
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        waitForVisibilityOf(locator,2);

    }
    protected void scrollToBottom() {
        log.info("Scrolling to the bottom of the page");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void switchToWindowWithTitle(String expectedTitle) {
        // Switching to new window
        String firstWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> windowsIterator = allWindows.iterator();

        while (windowsIterator.hasNext()) {
            String windowHandle = windowsIterator.next().toString();
            if (!windowHandle.equals(firstWindow)) {
                driver.switchTo().window(windowHandle);
                if (getCurrentPageTitle().equals(expectedTitle)) {
                    break;
                }
            }
        }
    }

    protected void switchToFrame(By frameLocator) {
        driver.switchTo().frame(find(frameLocator));
    }

    protected void performDragAndDrop(By from, By to) {
        // Actions action = new Actions(driver);
        // action.dragAndDrop(find(from), find(to)).build().perform();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(
                "function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                        + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n"
                        + "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                        + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n"
                        + "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                        + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                        + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                        + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n"
                        + "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                        + "var dragStartEvent =createEvent('dragstart');\n"
                        + "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n"
                        + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                        + "var dragEndEvent = createEvent('dragend');\n"
                        + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                        + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                        + "simulateHTML5DragAndDrop(source,destination);",
                find(from), find(to));
    }
    protected void hoverOverElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
    protected Alert switchToAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }


    public String getCurrentPageSource() {
        return driver.getPageSource();
    }

    private void waitFor(ExpectedCondition<WebElement> condition, Duration timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : Duration.ofSeconds(30);
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(timeOutInSeconds)
            .pollingEvery(Duration.ofSeconds(1))
            .until(condition);



    }

    protected void waitForAlert(Integer... timeOutInSeconds) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null))
            .pollingEvery(Duration.ofSeconds(1))
            .until(ExpectedConditions.alertIsPresent());

    }

    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {

        try {
            waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                    Duration.ofSeconds((timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null)));

        } catch (StaleElementReferenceException e) {
        }

    }

}
