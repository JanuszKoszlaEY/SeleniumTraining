package Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{

    private By authenticationLinkLocator = By.linkText("Form Authentication");

    private By editorLinkLocator = By.linkText("WYSIWYG Editor");

    private By checkboxesLinkLocator = By.linkText("Checkboxes");
    private By dropdownLinkLocator = By.linkText("Dropdown");
    private By javaScriptAlertsLinkLocator = By.linkText("JavaScript Alerts");
    private By multipleWindowsLinkLocator = By.linkText("Multiple Windows");


    public MainPage(WebDriver driver, Logger log){super(driver,log);}

    public void startPage(){
        openUrl();
//        openUrl("https://the-internet.herokuapp.com/");
    }

    public void scrollToEditorLocator(){
        log.info("Scroll to editor locator");
        super.scrollToElement(editorLinkLocator);
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

    public CheckboxesPage clickCheckboxesLink() {
        log.info("Clicking Checkboxes link on Welcome Page");
        click(checkboxesLinkLocator);
        return new CheckboxesPage(driver, log);
    }

    public DropdownPage clickDropdownLink() {
        log.info("Clicking Dropdown link on Welcome Page");
        click(dropdownLinkLocator);
        return new DropdownPage(driver, log);
    }

    public AlertsPage clickJavaScriptAlertsLink() {
        log.info("Clicking JavaScript Alerts link on Welcome Page");
        click(javaScriptAlertsLinkLocator);
        return new AlertsPage(driver, log);
    }

    public WindowsPage clickMultipleWindowsLink() {
        log.info("Clicking Multiple Windows link on Welcome Page");
        click(multipleWindowsLinkLocator);
        return new WindowsPage(driver, log);
    }

}
