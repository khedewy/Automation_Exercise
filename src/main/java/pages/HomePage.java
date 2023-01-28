package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class HomePage {
	private SHAFT.GUI.WebDriver driver;

	public HomePage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	private By signUpBtn = By.xpath("//a[text()=' Signup / Login']");

	public RegisterPage navigateToRegisterPage() {
		driver.element().click(signUpBtn);
		return new RegisterPage(driver);
	}

	private By productsButton = By.xpath("//a[text()=' Products']");

	public ProductsPage navigateToProductPage() {
		driver.element().click(productsButton);
		return new ProductsPage(driver);
	}

	private By contactUBtn = By.xpath("//a[text()=' Contact us']");

	public ContactUsPage navigateToContactUsPage() {
		driver.element().click(contactUBtn);
		return new ContactUsPage(driver);
	}

	private By logOutBtn = By.xpath("//a[text()=' Logout']");
	private By loginBtn = By.xpath("//a[text()=' Signup / Login']");

	public void logOut() {
		driver.element().click(logOutBtn);
	}

	public LoginPage navigateToLoginPage() {
		driver.element().click(loginBtn);
		return new LoginPage(driver);
	}

	public String logOutAssertion() {
		return driver.element().getText(logOutBtn);
	}

	public By getLogOutAssertionLocator() {
		return logOutBtn;
	}

}
