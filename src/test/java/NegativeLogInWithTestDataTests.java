import Pages.LoginPage;
import Pages.MainPage;
import Utilities.CsvDataProviders;
import testData.TestData;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;


public class NegativeLogInWithTestDataTests extends BaseTest {

	@Test(dataProvider = "data", dataProviderClass = TestData.class)
	public void negativeLogInTest(int number, String username, String password, String expectedErrorMessage) {
		log.info("Starting negativeTest Number " + number);

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

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void secondNegativeLogInTest(Map<String,String> testData) {
		log.info("Starting negativeTest Number " + testData.get("number"));

		// open main page
		MainPage mainPage = new MainPage(driver, log);
		mainPage.startPage();

		// Click on Form Authentication link
		LoginPage loginPage = mainPage.clickFormAuthenticationLink();

		// execute negative login
		loginPage.negativeLogIn(testData.get("username"), testData.get("password"));

		// wait for error message
		loginPage.waitForErrorMessage();
		String message = loginPage.getErrorMessageText();

		// Verification
		Assert.assertTrue(message.contains(testData.get("expectedErrorMessage")), "Message doesn't contain expected text.");
	}

}
