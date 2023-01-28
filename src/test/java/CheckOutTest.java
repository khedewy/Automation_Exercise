import org.testng.annotations.Test;

import com.shaft.driver.SHAFT;

import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetails;
import pages.ProductsPage;

public class CheckOutTest extends TestBase {
	HomePage home;
	LoginPage log;
	ProductsPage page;
	ProductDetails details;
	CheckOutPage check;
	SHAFT.TestData.JSON registerdata;
	SHAFT.TestData.JSON proceedData;

	@Test
	public void login() {
		home = new HomePage(driver);
		home.navigateToLoginPage();
		log = new LoginPage(driver);
		registerdata = new SHAFT.TestData.JSON("registerData.json");
		log.Login(registerdata.getTestData("email"), registerdata.getTestData("password"));
		home = new HomePage(driver);
		driver.assertThat().element(home.getLogOutAssertionLocator()).text().contains(" Logout");
	}

	@Test(priority = 1)
	public void navigateToProducts() {
		home = new HomePage(driver);
		home.navigateToProductPage();
	}

	@Test(priority = 2)
	public void searchForProduct() {
		page = new ProductsPage(driver);
		driver.assertThat().element(page.getassertionLocator()).text().contains("All Products");
		page.searchForProducts("polo");
		driver.assertThat().element(page.getSearchAssertionLocator()).text().contains("Searched Products");
		page.navigateToProductDetails();
	}

	@Test(priority = 3)
	public void addToCart() {
		details = new ProductDetails(driver);
		details.addFirstProductToCart();
		driver.assertThat().element(details.getAddToCartAssertionLocator()).text().contains("Premium Polo T-Shirts");
	}

	@Test(priority = 4)
	public void navigateToProceedCheckOut() {
		check = new CheckOutPage(driver);
		check.navigateToProceedCehckOut();
	}

	@Test(priority = 5)
	public void navigateToPayment() {
		check = new CheckOutPage(driver);
		check.navigateToPaymentMethode();
	}

	@Test(priority = 6)
	public void completeProceed() {
		proceedData = new SHAFT.TestData.JSON("proceedCheckoutData.json");
		check = new CheckOutPage(driver);
		check.completeProceedCheckOut(proceedData.getTestData("name"),
				Integer.parseInt(proceedData.getTestData("cardNumber")),
				Integer.parseInt(proceedData.getTestData("cvcNumber")), proceedData.getTestData("month"),
				Integer.parseInt(proceedData.getTestData("year")));

		driver.assertThat().element(check.getProceedAssertionLocator()).text()
				.contains("Congratulations! Your order has been confirmed!");
	}

}
