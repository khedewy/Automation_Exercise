package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class ProductDetails {
	private SHAFT.GUI.WebDriver driver;

	public ProductDetails(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	// Add Product to cart
	private By addToCartBtn = By.xpath("//button[@class='btn btn-default cart']");
	private By viewCart = By.linkText("View Cart");
	private By addToCartAssertion = By.xpath("//a[text()='Premium Polo T-Shirts']");

	public void addFirstProductToCart() {
		driver.element().click(addToCartBtn);
		driver.element().click(viewCart);
	}

	public String getAssertionMessage() {
		return driver.element().getText(addToCartAssertion);
	}

	public By getAddToCartAssertionLocator() {
		return addToCartAssertion;
	}

	// add review to a product

	private By nameTxt = By.id("name");
	private By emailTxt = By.id("email");
	private By messageTxt = By.id("review");
	private By submitReview = By.id("button-review");
	private By reviewAssertion = By.id("review-section");

	public void addReview(String name, String email, String message) {
		driver.element().type(nameTxt, name);
		driver.element().type(emailTxt, email);
		driver.element().type(messageTxt, message);
		driver.element().click(submitReview);
	}

	public String getReviewAssertionMessage() {
		return driver.element().getText(reviewAssertion);
	}

	public By getReviewAssertionLocator() {
		return reviewAssertion;
	}

}
