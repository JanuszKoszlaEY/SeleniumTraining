import Pages.AlertsPage;
import Pages.MainPage;
import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class AlertsTests extends BaseTest {

	@Test
	public void jsAlertTest() {
		SoftAssert softAssert = new SoftAssert();

		// open main page
		MainPage welcomePage = new MainPage(driver, log);
		welcomePage.startPage();

		// Click on JavaScript Alerts link
		AlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();

		// Click JS Alert button
		alertsPage.openJSAlert();
		// Get alert text
		String alertMessage = alertsPage.getAlertText();

		// Click OK button
		alertsPage.acceptAlert();

		// Get Results text
		String result = alertsPage.getResultText();

		// Verifications
		// 1 - Alert text is expected
		softAssert.assertTrue(alertMessage.equals("I am a JS Alert"),
				"Alert message is not expected. \nShould be 'I am a JS Alert', but it is '" + alertMessage + "'");

		// 2 - Result text is expected
		softAssert.assertTrue(result.equals("You successfully clicked an alert"),
				"result is not expected. \nShould be 'You successfully clicked an alert', but it is '" + result + "'");
		softAssert.assertAll();
	}

	@Test
	public void jsDismissTest() {
		SoftAssert softAssert = new SoftAssert();

		// open main page
		MainPage welcomePage = new MainPage(driver, log);
		welcomePage.startPage();

		// Click on JavaScript Alerts link
		AlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();

		// Click JS Confirm button
		alertsPage.openJSConfirm();

		// Get alert text
		String alertMessage = alertsPage.getAlertText();

		// Click Cancel button
		alertsPage.dismissAlert();

		// Get Results text
		String result = alertsPage.getResultText();

		// Verifications
		// 1 - Alert text is expected
		softAssert.assertTrue(alertMessage.equals("I am a JS Confirm"),
				"Alert message is not expected. \nShould be 'I am a JS Confirm', but it is '" + alertMessage + "'");

		// 2 - Result text is expected
		softAssert.assertTrue(result.equals("You clicked: Cancel"),
				"result is not expected. \nShould be 'You clicked: Cancel', but it is '" + result + "'");
		softAssert.assertAll();
	}

	@Test
	public void jsPromptTest() {
		SoftAssert softAssert = new SoftAssert();

		// open main page
		MainPage welcomePage = new MainPage(driver, log);
		welcomePage.startPage();

		// Click on JavaScript Alerts link
		AlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();

		// Click JS Prompt button
		alertsPage.openJSPrompt();

		// Get alert text
		String alertMessage = alertsPage.getAlertText() + "[FAIL]";

		// Type text into alert
		alertsPage.typeTextIntoAlert("Hello Alert, it's Me here");

		// Get Results text
		String result = alertsPage.getResultText() + "[FAIL]";

		// Verifications
		// 1 - Alert text is expected
		softAssert.assertTrue(alertMessage.equals("I am a JS prompt"),
				"Alert message is not expected. \nShould be 'I am a JS prompt', but it is '" + alertMessage + "'");

		// 2 - Result text is expected
		softAssert.assertTrue(result.equals("You entered: Hello Alert, it's Me here"),
				"result is not expected. \nShould be 'You entered: Hello Alert, its Me here', but it is '" + result
						+ "'");
		softAssert.assertAll();
	}
}
