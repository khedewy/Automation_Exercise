import org.testng.annotations.Test;

import com.shaft.driver.SHAFT;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {
	HomePage page;
	ContactUsPage contact;
	SHAFT.TestData.JSON contactData;

	@Test
	public void navigateToContactUs() {
		page = new HomePage(driver);
		page.navigateToContactUsPage();
	}
	
	@Test(priority = 1)
	public void contactUs() {
		contactData = new SHAFT.TestData.JSON("contactUsData.json");
		contact = new ContactUsPage(driver);
		driver.assertThat().element(contact.getAssertThatUserIContactUsPageLocator()).text().contains("Get In Touch");
		contact.ContactUs(contactData.getTestData("name"),contactData.getTestData("email"),contactData.getTestData("subject"),contactData.getTestData("message"),contactData.getTestData("filePath"));
		driver.assertThat().element(contact.contactUsLocator()).text().contains("Success! Your details have been submitted successfully.");
		
	}
}
