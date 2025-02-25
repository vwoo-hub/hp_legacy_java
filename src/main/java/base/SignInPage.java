package base;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignInPage extends BasePage {

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Email\")")
	private WebElement emailTextField;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Password\")")
	private WebElement passwordTextField;

	@AndroidFindBy(id = "next_button")
	private WebElement nextButton;

	public SignInPage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

		this.initialViews = Arrays.asList(emailTextField, passwordTextField, nextButton);
	}

	public void typeEmailTextField(String email) {
		emailTextField.sendKeys(email);
	}

	public void typePasswordTextField(String password) {
		passwordTextField.sendKeys(password);
	}

	public void tapNextButton() {
		nextButton.click();
	}
}
