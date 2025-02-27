package pages;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TermsAndConditionsPage extends BasePage {
	
	@AndroidFindBy(id = "webView")
	WebElement webView;
	
	@AndroidFindBy(id = "acceptButton")
	WebElement acceptButton;
	
	@AndroidFindBy(id = "cancelButton")
	WebElement cancelButton;
	
	public TermsAndConditionsPage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
		
		this.initialViews = Arrays.asList(webView, acceptButton, cancelButton);
	}

	public void tapAcceptButton() {
		acceptButton.click();
	}
	
	public void tapCancelButton() {
		cancelButton.click();
	}
}
