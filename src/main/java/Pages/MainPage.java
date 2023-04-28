package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{

    private By authenticationLinkLocator = By.linkText("Form Authentication");

    public MainPage(WebDriver driver){super(driver);}

    public void startPage(){
        openUrl("https://the-internet.herokuapp.com/");
    }

    public LoginPage clickFormAuthenticationLink(){
        click(authenticationLinkLocator);
        return new LoginPage(driver);
    }

}
