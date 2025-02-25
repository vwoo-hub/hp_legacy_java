package base;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import driver.DriverManager;
import io.appium.java_client.AppiumDriver;

public class BaseTest {
	protected AppiumDriver driver;
	
	@BeforeClass
	public void setUp() {
		try {
			DriverManager.startDriver();
			driver = DriverManager.getDriver(); 
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    @AfterClass
    public void tearDown() {
        DriverManager.stopDriver();
    }
	
}
