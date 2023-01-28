package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class CheckOutPage {
	private SHAFT.GUI.WebDriver driver;

	public CheckOutPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	// first step
	private By proceedCheckOutBtn = By.xpath("//a[text()='Proceed To Checkout']");

	public void navigateToProceedCehckOut() {
		driver.element().scrollToElement(proceedCheckOutBtn).click(proceedCheckOutBtn);
	}

	// second step

	private By placeOrderBtn = By.xpath("//a[text()='Place Order']");

	public void navigateToPaymentMethode() {
		driver.element().scrollToElement(placeOrderBtn).click(placeOrderBtn);
	}

	// third step

	private By nameOfCard = By.xpath("//input[@name='name_on_card']");
	private By cardNumber = By.xpath("//input[@name='card_number']");
	private By cvcNumber = By.xpath("//input[@name='cvc']");
	private By expiryMonth = By.xpath("//input[@name='expiry_month']");
	private By expiryYear = By.xpath("//input[@name='expiry_year']");
	private By submitOrder = By.id("submit");
	private By assertionMessage = By.xpath("//p[text()='Congratulations! Your order has been confirmed!']");

	public void completeProceedCheckOut(String name, int CNumber, int cvc, String month, int year) {
		driver.element().type(nameOfCard, name);
		driver.element().type(cardNumber, String.valueOf(CNumber));
		driver.element().type(cvcNumber, String.valueOf(cvc));
		driver.element().type(expiryMonth, month);
		driver.element().type(expiryYear, String.valueOf(year));
		driver.element().click(submitOrder);
	}

	public String proceedAssertion() {
		return driver.element().getText(assertionMessage);
	}

	public By getProceedAssertionLocator() {
		return assertionMessage;
	}

}
