package TheBeginningOfAUTOMATION;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstSimpleTest {
    WebDriver driver;
    Logger logger;

    @Test
    public void test() {
        WebDriver driver;
        Logger logger;
        //automatyczne znajdowanie webdrivera
        logger = LogManager.getLogger("LOGGER");
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();

        // poniższą linijkę możemy odkomentować, jeśli chcemy , by test wykonał się bez widocznej grafiki
        //       chromeOptions.addArguments("--headless");

        //Wystartuj webdriver typu chrome, ustaw implicit wait i maxwindow
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();
        logger.info("gggg");
        //wystartuj stronę
        driver.get("https://www.saucedemo.com/");

        FluentWait wait = new FluentWait<>(driver);
        wait.pollingEvery(Duration.ofSeconds(1))
                .withTimeout(Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));

        //Zaloguj i sprawdź czy zalogowanie się powiodło
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        logger.info("ggggsdfsdfsdfsdfggggsdfsdfsdfsdfggggsdfsdfsdfsdfggggsdfsdfsdfsdfggggsdfsdfsdfsdfggggsdfsdfsdfsdfggggsdfsdfsdfsdfggggsdfsdfsdfsdfggggsdfsdfsdfsdfggggsdfsdfsdfsdf");
        Assert.assertTrue(driver.findElement(By.className("app_logo")).getText().contains("Swag Labs"));
        driver.quit();
    }
}