import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.shaft.driver.SHAFT;

public class TestBase {
public static SHAFT.GUI.WebDriver driver;
	
	@BeforeClass
	public void setDriver() {
		driver = new SHAFT.GUI.WebDriver();
		driver.browser().navigateToURL("https://automationexercise.com/");
	}
	
	@AfterClass
	public void closeDriver() {
		driver.quit();
	}

}
