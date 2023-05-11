import Pages.LoginPage;
import Pages.MainPage;
import base.BaseTest;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test(priority = 2)
    public void loginTest() {
        MainPage mainPage = new MainPage(driver, log);
        mainPage.startPage();
        log.info("Page started");
        mainPage.clickFormAuthenticationLink();

        LoginPage loginPage = new LoginPage(driver, log);
        loginPage.Login("tomsmith", "SuperSecretPassword!");
        takeScreenshot("PageLoggedIn");
        // Assert

    }

    @Test(priority = 2, groups = {"g1"})
    public void fakeLoginTest() {
        MainPage mainPage = new MainPage(driver, log);
        mainPage.startPage();
        log.info("Fake Page started");
        mainPage.clickFormAuthenticationLink();

        LoginPage loginPage = new LoginPage(driver, log);
        loginPage.Login("tomsmith", "SuperSecretPassword!");
        // Assert

    }

    @Test(priority = 1, groups = {"g1"})
    public void fakeLoginPriority1Test() {
        MainPage mainPage = new MainPage(driver, log);
        mainPage.startPage();
        log.info("Fake Page started");
        mainPage.clickFormAuthenticationLink();

        LoginPage loginPage = new LoginPage(driver, log);
        loginPage.Login("tomsmith", "SuperSecretPassword!");
        // Assert

    }

}