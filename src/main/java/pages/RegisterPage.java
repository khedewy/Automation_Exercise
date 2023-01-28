package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class RegisterPage {
	private SHAFT.GUI.WebDriver driver;
	public RegisterPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}
	
	
	// register first step locators 
	private By nameTxt = By.xpath("//input[@data-qa='signup-name']");
	private By emailTxt = By.xpath("//input[@data-qa='signup-email']");
	private By signUpButton = By.xpath("//button[@data-qa='signup-button']");
	private By assertionMessage = By.xpath("//h2[text()='New User Signup!']");
	
	public String getassertionMessage() {
		return driver.element().getText(assertionMessage);
	}
	
	public By getAssertionLocator() {
		return assertionMessage;
	}
	
	public void completeFirstStepOfRegister(String name, String email) {
		driver.element().type(nameTxt, name);
		driver.element().type(emailTxt, email);
		driver.element().click(signUpButton);
	}
	
	// second step locators 
	
	private By genderButoon = By.id("id_gender1");
	private By passwordTxt = By.id("password");
	private By days = By.id("days");
	private By months = By.id("months");
	private By years = By.id("years");
	//private By newsLetters = By.id("newsletter");
	private By firstNameTxt = By.id("first_name");
	private By lastNameTxt = By.id("last_name");
	private By companyTxt = By.id("company");
	private By address1Txt = By.id("address1");
	private By address2Txt = By.id("address2");
	private By countrys = By.id("country");
	private By stateTxt = By.id("state");
	private By cityTxt = By.id("city");
	private By zipCodeTxt = By.id("zipcode");
	private By mobileNumber = By.id("mobile_number");
	private By createAccountBtn = By.xpath("//button[@data-qa='create-account']");
	private By createAccountAssertion = By.xpath("//b[text()='Account Created!']");
	private By continueBtn = By.xpath("//a[@data-qa='continue-button']");
	
	public void completeRegisterData(String password, int day, String month, int year, String firstName, String lastName,
			String company, String address1, String address2, String country, String state,
			String city, int zipcode, int mobileNim) {
		
		driver.element().click(genderButoon);
		driver.element().type(passwordTxt, password);
		driver.element().select(days, String.valueOf(day));
		driver.element().select(months, month);
		driver.element().select(years, String.valueOf(year));
		//driver.element().click(newsLetters);
		driver.element().type(firstNameTxt, firstName);
		driver.element().type(lastNameTxt, lastName);
		driver.element().type(companyTxt,company);
		driver.element().type(address1Txt, city);
		driver.element().type(address2Txt, address2);
		driver.element().select(countrys, country);
		driver.element().type(stateTxt, state);
		driver.element().type(cityTxt, city);
		driver.element().type(zipCodeTxt, String.valueOf(zipcode));
		driver.element().type(mobileNumber, String.valueOf(mobileNim));
		driver.element().click(createAccountBtn);
	}
	
	public String getCreateAccountAssertionMessage() {
		return driver.element().getText(createAccountAssertion);
	}
	
	public By getCreateAccountLocators() {
		return createAccountAssertion;
	}
	
	public void clickContinueBtn() {
		driver.element().click(continueBtn);
	}

}
