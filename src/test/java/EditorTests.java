import Pages.EditorPage;
import Pages.MainPage;
import base.BaseTest;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditorTests extends BaseTest {


	@Test
	public void defaultEditorValueTest() {


		// open main page
		MainPage mainPage = new MainPage(driver, log);
		mainPage.startPage();
		
		// Scroll to the bottom

		mainPage.scrollToBottom();


		// Click on WYSIWYG Editor link
		EditorPage editorPage = mainPage.clickWYSIWYGEditorLink();

		// Get default editor text
		String editorText = editorPage.getEditorText();

		// Verification that new page contains expected text in source
		Assert.assertTrue(editorText.equals("Your content goes here."),
				"Editor default text is not expected. It is: " + editorText);
	}
}
