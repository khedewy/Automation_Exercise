package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class HomePage2 {
	private SHAFT.GUI.WebDriver driver;

	public HomePage2(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	private By subscribtionBox = By.id("susbscribe_email");
	private By sbmitBtn = By.id("subscribe");
	private By subscribeAssertion = By.xpath("//h2[text()='Subscription']");

	public void userCanSubscribe(String email) {
		driver.element().scrollToElement(subscribtionBox).type(subscribtionBox, email);
		driver.element().click(sbmitBtn);
	}

	public String getSubscribeAssertionMessage() {
		return driver.element().getText(subscribeAssertion);
	}

	public By getSubscribeAssertionLocator() {
		return subscribeAssertion;
	}

}
