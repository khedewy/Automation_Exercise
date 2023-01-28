import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetails;
import pages.ProductsPage;

public class AddReviewTest extends TestBase {
	HomePage home;
	ProductsPage page;
	ProductDetails details;

	@Test
	public void navigateToProducts() {
		home = new HomePage(driver);
		home.navigateToProductPage();
	}

	@Test(priority = 1)
	public void searchForProducts() {
		page = new ProductsPage(driver);
		driver.assertThat().element(page.getassertionLocator()).text().contains("All Products");
		page.searchForProducts("polo");
		driver.assertThat().element(page.getSearchAssertionLocator()).text().contains("Searched Products");
		page.navigateToProductDetails();
	}
	
	@Test(priority = 2)
	public void addReview() {
		details = new ProductDetails(driver);
		details.addReview("Mahmoud","MAHMOUD123@gmail.com","This a very good product");
		driver.assertThat().element(details.getReviewAssertionLocator()).text().contains("Thank you for your review.");
	}
}
