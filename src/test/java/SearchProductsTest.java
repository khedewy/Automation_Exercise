import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductsPage;

public class SearchProductsTest extends TestBase {
	HomePage home;
	ProductsPage page;

	@Test
	public void searchForProduct() {
		home = new HomePage(driver);
		home.navigateToProductPage();
		page = new ProductsPage(driver);
		driver.assertThat().element(page.getassertionLocator()).text().contains("All Products");
		page.searchForProducts("polo");
		driver.assertThat().element(page.getSearchAssertionLocator()).text().contains("Searched Products");
	}
}
