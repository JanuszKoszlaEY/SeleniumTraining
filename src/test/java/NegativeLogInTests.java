import Pages.LoginPage;
import Pages.MainPage;
import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class NegativeLogInTests extends BaseTest {

	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1)
	public void negativeLogInTest(String username, String password, String expectedErrorMessage) {
		log.info("Starting negativeTest");

		// open main page
		MainPage mainPage = new MainPage(driver, log);
		mainPage.startPage();

		// Click on Form Authentication link
		LoginPage loginPage = mainPage.clickFormAuthenticationLink();

		// execute negative login
		loginPage.negativeLogIn(username, password);

		// wait for error message
		loginPage.waitForErrorMessage();
		String message = loginPage.getErrorMessageText();

		// Verification
		Assert.assertTrue(message.contains(expectedErrorMessage), "Message doesn't contain expected text.");
	}
}
