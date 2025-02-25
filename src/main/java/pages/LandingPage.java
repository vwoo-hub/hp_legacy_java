package pages;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LandingPage extends BasePage {

	@AndroidFindBy(id = "splash_sign_in")
	private WebElement logInButton;

	@AndroidFindBy(id = "splash_setup")
	private WebElement setUpPlumeButton;

	public LandingPage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

		this.initialViews = Arrays.asList(logInButton, setUpPlumeButton);
	}

	public void tapLogInButton() {
		logInButton.click();
	}

	public void tapSetUpPlumeButton() {
		setUpPlumeButton.click();
	}

}