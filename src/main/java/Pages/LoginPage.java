package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By buttonLocator = By.xpath("//button[@type='submit']");


    public void Login(String username,String password){
        type(username,usernameLocator);
        type(password,passwordLocator);
        click(buttonLocator);

    }
}
