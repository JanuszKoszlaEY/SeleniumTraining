import Pages.LoginPage;
import Pages.MainPage;
import base.BaseTest;
import org.testng.annotations.Test;


public class LoginCopyTest extends BaseTest {

    @Test(priority = 2)
    public void loginTest() {
        MainPage mainPage = new MainPage(driver, log);
        mainPage.startPage();
        log.info("IncludedPage started");
        mainPage.clickFormAuthenticationLink();

        LoginPage loginPage = new LoginPage(driver, log);
        loginPage.Login("tomsmith", "SuperSecretPassword!");
        // Assert

    }

    @Test(priority = 2, groups = {"g1"})
    public void includedLoginTest() {
        MainPage mainPage = new MainPage(driver, log);
        mainPage.startPage();
        log.info("Included Page started");
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