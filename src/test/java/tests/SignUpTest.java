package tests;

import base.BaseTest;
import pages.HomePage;
import pages.LandingPage;
import pages.SignInPage;
import pages.SignUpPage;
import pages.SignUpPasswordPage;
import pages.SignUpVerificationPage;
import pages.TermsAndConditionsPage;
import utils.EmailGenerator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

	private LandingPage landingPage;
	private SignInPage signInPage;
	private HomePage homePage;
	private TermsAndConditionsPage termsAndConditionsPage;
	private SignUpPage signUpPage;
	private SignUpPasswordPage signUpPasswordPage;
	private SignUpVerificationPage signUpVerificationPage;

	@BeforeMethod
	public void initPages() {
		landingPage = new LandingPage(driver);
		signInPage = new SignInPage(driver);
		homePage = new HomePage(driver);
		termsAndConditionsPage = new TermsAndConditionsPage(driver);
		signUpPage = new SignUpPage(driver);
		signUpPasswordPage = new SignUpPasswordPage(driver);
		signUpVerificationPage = new SignUpVerificationPage(driver);
	}

	@Test
	public void whenValidCredentialsThenLogInSuccessfully() throws InterruptedException {
		landingPage.waitForPage();
		landingPage.tapSetUpPlumeButton();

		termsAndConditionsPage.waitForPage();
		termsAndConditionsPage.tapAcceptButton();

		signUpPage.waitForPage();
		signUpPage.typeNameTextField("vwoo test");
		signUpPage.typeEmailTextField(EmailGenerator.generateEmail());
		signUpPage.tapNextButton();

		signUpPasswordPage.waitForPage();
		signUpPasswordPage.typePasswordTextField("password123");
		signUpPasswordPage.tapNextButton();

		signUpVerificationPage.waitForPage();
		signUpVerificationPage.tapResendVerificationEmailButton();
	}
}
