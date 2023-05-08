import Pages.LoginPage;
import Pages.MainPage;
import base.BaseTest;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test(groups = { "functest"})
    public void loginTest(){
        MainPage mainPage = new MainPage(driver,log);
        mainPage.startPage();
        log.info("Page started");
        mainPage.clickFormAuthenticationLink();

        LoginPage loginPage = new LoginPage(driver,log);
        loginPage.Login("tomsmith","SuperSecretPassword!");
        // Assert

    }
}
