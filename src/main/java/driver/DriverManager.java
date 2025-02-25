package driver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverManager {

	public static AppiumDriver driver;

	public static void main(String[] args) throws MalformedURLException {
		startDriver();
	}

	public static void startDriver() throws MalformedURLException {
		String androidPathName = "/Users/vwoo/PycharmProjects/hp_legacy/build/legacy.apk";

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Android");
		options.setPlatformName("Android");
		options.setAutomationName("UIAutomator2");
		options.setNewCommandTimeout(Duration.ofSeconds(300));
		options.setApp(androidPathName);
		options.setAutoGrantPermissions(true);

		URL appiumServerUrl = null;
		try {
			appiumServerUrl = URI.create("http://127.0.0.1:4723").toURL();
		} catch (IllegalArgumentException e) {
			System.err.println("invalid URL: " + e.getMessage());
			return;
		}
		driver = new AndroidDriver(appiumServerUrl, options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		System.out.println("driver initialized");
	}

	public static AppiumDriver getDriver() {
		if (driver == null) {
			throw new IllegalStateException("driver not initialized");
		}
		return driver;
	}

	public static void stopDriver() {
		driver.quit();
	}
}
