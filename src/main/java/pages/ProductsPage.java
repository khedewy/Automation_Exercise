package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class ProductsPage {
	private SHAFT.GUI.WebDriver driver;

	public ProductsPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	// assert that user in the product page
	private By allProductAssertion = By.xpath("//h2[text()='All Products']");

	public String getAssertionMessage() {
		return driver.element().getText(allProductAssertion);
	}

	public By getassertionLocator() {
		return allProductAssertion;
	}
	
	// user search for products
	
	private By searchBox = By.id("search_product");
	private By submitSearch = By.id("submit_search");
	private By searchAssertion = By.xpath("//h2[text()='Searched Products']");
	private By viewProducts = By.xpath("//a[text()='View Product']");
	
	
	public void searchForProducts(String product) {
		driver.element().type(searchBox,product);
		driver.element().click(submitSearch);
	}
	
	public String getSearchAssertionMessage() {
		return driver.element().getText(searchAssertion);
	}
	
	public By getSearchAssertionLocator() {
		return searchAssertion;
	}
	
	public ProductDetails navigateToProductDetails() {
		driver.element().click(viewProducts);
		return new ProductDetails(driver);
	}
	
	
}
