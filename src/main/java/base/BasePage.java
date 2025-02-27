package base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {

	protected AppiumDriver driver;
	protected List<WebElement> initialViews;
	public static final int DEFAULT_TIMEOUT = 5;

	public BasePage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), driver);
	}
	
	public void waitForPage() {
		waitForPage(DEFAULT_TIMEOUT);
	}

	public void waitForPage(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

		for (WebElement element : initialViews) {
			try {
				wait.until(ExpectedConditions.visibilityOf(element));
			} catch (Exception e) {
				throw new RuntimeException("Element " + element + " not displayed within initialViews");
			}
		}
	}
}