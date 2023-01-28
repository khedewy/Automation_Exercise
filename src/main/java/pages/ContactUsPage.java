package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class ContactUsPage {
	private SHAFT.GUI.WebDriver driver;

	public ContactUsPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	private By contacUsPageAssertion = By.xpath("//h2[text()='Get In Touch']");

	public String assertThatUserIContactUsPage() {
		return driver.element().getText(contacUsPageAssertion);
	}

	public By getAssertThatUserIContactUsPageLocator() {
		return contacUsPageAssertion;
	}

	private By nameTxt = By.xpath("//input[@name='name']");
	private By emailTxt = By.xpath("//input[@name='email']");
	private By subjectTxt = By.xpath("//input[@name='subject']");
	private By messageTxt = By.id("message");
	private By uploadFile = By.name("upload_file");
	private By submitBtn = By.xpath("//input[@name='submit']");
	private By contactAssertionMessage = By.xpath("//div[@class='status alert alert-success']");

	public void ContactUs(String name, String email, String subject, String message, String file) {
		driver.element().type(nameTxt, name);
		driver.element().type(emailTxt, email);
		driver.element().type(subjectTxt, subject);
		driver.element().type(messageTxt, message);
		driver.element().typeFileLocationForUpload(uploadFile, file);
		driver.element().scrollToElement(submitBtn).click(submitBtn);
		driver.element().performAlertAction().acceptAlert();
	}

	public String getContactAssertionMessage() {
		return driver.element().getText(contactAssertionMessage);
	}

	public By contactUsLocator() {
		return contactAssertionMessage;
	}

}
