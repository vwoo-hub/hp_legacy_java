package pages;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUpVerificationPage extends BasePage {

	@AndroidFindBy(id = "headerTextView")
	WebElement titleLabel;

	@AndroidFindBy(id = "subHeaderTextView")
	WebElement descriptionLabel;

	@AndroidFindBy(id = "iconVerifyEmail")
	WebElement emailIcon;

	@AndroidFindBy(id = "badgePopup")
	WebElement badgeIcon;

	@AndroidFindBy(id = "resendEmailButton")
	WebElement resendVerificationEmailButton;

	@AndroidFindBy(id = "openMailButton")
	WebElement openMailAppButton;

	public SignUpVerificationPage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

		this.initialViews = Arrays.asList(titleLabel, descriptionLabel, emailIcon, badgeIcon,
				resendVerificationEmailButton, openMailAppButton);
	}

	public void tapResendVerificationEmailButton() {
		resendVerificationEmailButton.click();
	}

	public void tapOpenMailAppButton() {
		openMailAppButton.click();
	}
}
