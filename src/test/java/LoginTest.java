import Pages.LoginPage;
import Pages.MainPage;
import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.startPage();
        mainPage.clickFormAuthenticationLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("tomsmith","SuperSecretPassword!");

    }
}
