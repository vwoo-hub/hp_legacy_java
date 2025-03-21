package pages;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends BasePage {

	@AndroidFindBy(id = "logo_view_base_image")
	WebElement logoImage;

	@AndroidFindBy(id = "logo_view_partner_image")
	WebElement partnerImage;

	@AndroidFindBy(className = "android.widget.ImageButton")
	WebElement hamburgerButton;

	public HomePage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

		this.initialViews = Arrays.asList(logoImage, partnerImage, hamburgerButton);
	}

	public void tapHamburgerButton() {
		hamburgerButton.click();
	}
}
