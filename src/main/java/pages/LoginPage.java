package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class LoginPage {
	private SHAFT.GUI.WebDriver driver;

	public LoginPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}
	
	private By emailTxt = By.xpath("//input[@placeholder='Email Address' and @data-qa='login-email']");
	private By passwordTxt = By.xpath("//input[@data-qa='login-password']");
	private By logBtn = By.xpath("//button[@data-qa='login-button']");
	
	public void Login(String email, String password) {
		driver.element().type(emailTxt, email);
		driver.element().type(passwordTxt, password);
		driver.element().click(logBtn);
	}

}
