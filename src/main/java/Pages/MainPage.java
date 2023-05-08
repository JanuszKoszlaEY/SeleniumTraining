package Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{

    private By authenticationLinkLocator = By.linkText("Form Authentication");

    private By editorLinkLocator = By.linkText("WYSIWYG Editor");

    public MainPage(WebDriver driver, Logger log){super(driver,log);}

    public void startPage(){
        openUrl("https://the-internet.herokuapp.com/");
    }

    public LoginPage clickFormAuthenticationLink(){
        click(authenticationLinkLocator);
        return new LoginPage(driver,log);
    }
    public EditorPage clickWYSIWYGEditorLink() {
        log.info("Clicking WYSIWYG Editor link on Welcome Page");
        click(editorLinkLocator);


        return new EditorPage(driver, log);


    }

}
