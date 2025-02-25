package base;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends BasePage {

	public HomePage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	@AndroidFindBy(id = "logo_view_base_image")
	WebElement logoImage;

	@AndroidFindBy(id = "logo_view_partner_image")
	WebElement partnerImage;

	@AndroidFindBy(className = "android.widget.ImageButton")
	WebElement hamburgerButton;

	public void tapHamburgerButton() {
		hamburgerButton.click();
	}

	public void viewHomeLogos() {
		Assert.assertTrue(logoImage.isDisplayed());
		Assert.assertTrue(partnerImage.isDisplayed());
	}
}
