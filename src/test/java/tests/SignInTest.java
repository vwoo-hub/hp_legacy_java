package tests;

import base.BaseTest;
import base.HomePage;
import base.SignInPage;
import pages.LandingPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {

	private LandingPage landingPage;
	private SignInPage signInPage;
	private HomePage homePage;

	@BeforeMethod
	public void initPages() {
		landingPage = new LandingPage(driver);
		signInPage = new SignInPage(driver);
		homePage = new HomePage(driver);
	}

	@Test
	public void whenValidCredentialsThenLogInSuccessfully() throws InterruptedException {
		landingPage.waitForPage(5);
		landingPage.tapLogInButton();

		signInPage.waitForPage(5);
		signInPage.typeEmailTextField("vwoo+hp@plume.com");
		signInPage.typePasswordTextField("plumewifi1");
		signInPage.tapNextButton();

		homePage.waitForPage(5);
	}
}
