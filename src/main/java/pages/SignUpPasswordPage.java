package pages;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUpPasswordPage extends BasePage {

	@AndroidFindBy(id = "headerTextView")
	WebElement titleLabel;

	@AndroidFindBy(id = "subHeaderTextView")
	WebElement descriptionLabel;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.plumewifi.plume.dogfood:id/pwd_edit_key_icon\"]")
	WebElement passwordIcon;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enter Password\")")
	WebElement passwordTextField;

	@AndroidFindBy(id = "text_input_end_icon")
	WebElement showHideButton;

	@AndroidFindBy(id = "pwd_edit_stength_indicator")
	WebElement passwordStrengthLabel;

	@AndroidFindBy(id = "nextButton")
	WebElement nextButton;
	
	public SignUpPasswordPage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

		this.initialViews = Arrays.asList(titleLabel, descriptionLabel, passwordIcon, passwordTextField, showHideButton,
				passwordStrengthLabel, nextButton);
	}

	public void typePasswordTextField(String password) {
		passwordTextField.sendKeys(password);
	}

	public void tapShowHideButton() {
		showHideButton.click();
	}

	public void tapNextButton() {
		nextButton.click();
	}
}
