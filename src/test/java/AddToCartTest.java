import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetails;
import pages.ProductsPage;

public class AddToCartTest extends TestBase {
	HomePage home;
	ProductsPage page;
	ProductDetails details;

	@Test
	public void navigateToProducts() {
		home = new HomePage(driver);
		home.navigateToProductPage();
	}

	@Test(priority = 1)
	public void searchForProduct() {
		page = new ProductsPage(driver);
		driver.assertThat().element(page.getassertionLocator()).text().contains("All Products");
		page.searchForProducts("polo");
		driver.assertThat().element(page.getSearchAssertionLocator()).text().contains("Searched Products");
		page.navigateToProductDetails();
	}

	@Test(priority = 2)
	public void addToCart() {
		details = new ProductDetails(driver);
		details.addFirstProductToCart();
		driver.assertThat().element(details.getAddToCartAssertionLocator()).text().contains("Premium Polo T-Shirts");

	}
	

}
