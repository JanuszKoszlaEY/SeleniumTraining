import Pages.BasePage;
import Pages.CheckboxesPage;
import Pages.MainPage;
import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTests extends BaseTest {

	@Test
	public void selectingTwoCheckboxesTest() {
		log.info("Starting selectingTwoCheckboxesTest");

		// open main page
		MainPage mainPage = new MainPage(driver, log);
		mainPage.startPage();

		// Click on Checkboxes link
		CheckboxesPage checkboxesPage = mainPage.clickCheckboxesLink();

		// Select All Checkboxes
		checkboxesPage.selectAllCheckboxes();

		// Verify all checkboxes are checked
		Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(), "Not all checkboxes are checked");

	}
}
