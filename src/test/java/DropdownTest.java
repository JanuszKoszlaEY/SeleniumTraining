import Pages.DropdownPage;
import Pages.MainPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends BaseTest {
	
	@Test
	public void optionTwoTest() {
		log.info("Starting optionTwoTest");

		// open main page
		MainPage welcomePage = new MainPage(driver, log);
		welcomePage.startPage();

		// Click on Dropdown link
		DropdownPage dropdownPage = welcomePage.clickDropdownLink();

		// Select Option 2
		dropdownPage.selectOption(2);

		// Verify Option 2 is selected
		String selectedOption = dropdownPage.getSelectedOption();
		Assert.assertTrue(selectedOption.equals("Option 2"),
				"Option 2 is not selected. Instead selected - " + selectedOption);
	}
}
