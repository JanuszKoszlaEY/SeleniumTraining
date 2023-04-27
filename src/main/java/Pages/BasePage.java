package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;

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
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(condition);
    }

    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        Duration.ofDays((timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null)));
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }

}
