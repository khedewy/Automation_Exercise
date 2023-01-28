import org.testng.annotations.Test;

import com.shaft.driver.SHAFT;

import io.qameta.allure.Description;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest extends TestBase {
	HomePage home;
	RegisterPage register;
	SHAFT.TestData.JSON registerdata;

	@Description("user navigates to register page")
	@Test
	public void NavigateToRegister() {
		home = new HomePage(driver);
		home.navigateToRegisterPage();
	}

	@Description("user enter his name and email")
	@Test(priority = 1)
	public void userEnterHisNameAndEmail() {
		registerdata = new SHAFT.TestData.JSON("registerData.json");
		register = new RegisterPage(driver);
		register.completeFirstStepOfRegister(registerdata.getTestData("name"), registerdata.getTestData("email"));
		driver.assertThat().element(register.getAssertionLocator()).text().contains("New User Signup!");
	}
	
	@Description("user completes filling his data")
	@Test(priority = 2)
	public void userFillHisData() {
		register = new RegisterPage(driver);
		register.completeRegisterData(registerdata.getTestData("password"),
				Integer.parseInt(registerdata.getTestData("day")), registerdata.getTestData("month"),
				Integer.parseInt(registerdata.getTestData("year")), registerdata.getTestData("firstName"),
				registerdata.getTestData("lastName"), registerdata.getTestData("company"),
				registerdata.getTestData("address1"), registerdata.getTestData("address2"),
				registerdata.getTestData("country"), registerdata.getTestData("state"),
				registerdata.getTestData("city"), Integer.parseInt(registerdata.getTestData("zip")),
				Integer.parseInt(registerdata.getTestData("mobNumber")));
		driver.assertThat().element(register.getCreateAccountLocators()).text().contains("Account Created!");

	}
}
