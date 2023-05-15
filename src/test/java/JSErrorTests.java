import Pages.BasePage;
import Pages.JSErrorPage;
import Utilities.Utilities;
import base.BaseTest;

import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class JSErrorTests extends BaseTest {

	@Test
	public void jsErrorTest() {
		log.info("Starting jsErrorTest");
		SoftAssert softAssert = new SoftAssert();

		// Open JSErrorPage
		JSErrorPage jSErrorPage = new JSErrorPage(driver, log);
		jSErrorPage.openPage();

		// Get logs
		Utilities util = new Utilities();
		List<LogEntry> logs = util.getBrowserLogs(driver);

		// Verifying there are no JavaScript errors in console
		for (LogEntry logEntry : logs) {
			if (logEntry.getLevel().toString().equals("SEVERE")) {
				softAssert.fail("Severe error: " + logEntry.getMessage());
			}
		}
		softAssert.assertAll();
	}
}
