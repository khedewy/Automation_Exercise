import org.testng.annotations.Test;

import com.shaft.driver.SHAFT;

import pages.HomePage2;

public class SubscribtionTest extends TestBase {
	HomePage2 home2;
	SHAFT.TestData.JSON subscribeData;

	@Test
	public void subscribe() {
		subscribeData = new SHAFT.TestData.JSON("subscribtionData.json");
		home2 = new HomePage2(driver);
		home2.userCanSubscribe(subscribeData.getTestData("email"));
		driver.assertThat().element(home2.getSubscribeAssertionLocator()).text().contains("Subscription");
	}
}
