package Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver, Logger log) {
        super(driver,log);
    }
    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By buttonLocator = By.xpath("//button[@type='submit']");

    private By errorMessageLocator = By.id("flash");

    public void Login(String username,String password){
        type(username,usernameLocator);
        type(password,passwordLocator);
        click(buttonLocator);


    }

    public void negativeLogIn(String username, String password) {
        log.info("Executing Negative LogIn with username [" + username + "] and password [" + password + "]");
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(buttonLocator);
//        return new SecureAreaPage(driver, log);
    }
    public void waitForErrorMessage() {
        waitForVisibilityOf(errorMessageLocator, 5);
    }

    public String getErrorMessageText() {
        return find(errorMessageLocator).getText();
    }
}
