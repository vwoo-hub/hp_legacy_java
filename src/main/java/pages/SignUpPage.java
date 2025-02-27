package pages;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUpPage extends BasePage {

	@AndroidFindBy(id = "headerTextView")
	private WebElement titleLabel;

	@AndroidFindBy(id = "subHeaderTextView")
	private WebElement descriptionLabel;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.plumewifi.plume.dogfood:id/nameLayout\"]/android.widget.ImageView")
	private WebElement profileIcon;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Name\")")
	private WebElement nameTextField;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.plumewifi.plume.dogfood:id/emailLayout\"]/android.widget.ImageView")
	private WebElement emailIcon;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Email\")")
	private WebElement emailTextField;

	@AndroidFindBy(id = "nextButton")
	private WebElement nextButton;

	public SignUpPage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

		this.initialViews = Arrays.asList(titleLabel, descriptionLabel, profileIcon, nameTextField, emailIcon,
				emailTextField, nextButton);
	}

	public void typeNameTextField(String name) {
		nameTextField.sendKeys(name);
	}

	public void typeEmailTextField(String email) {
		emailTextField.sendKeys(email);
	}

	public void tapNextButton() {
		nextButton.click();
	}
}
