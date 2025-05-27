package tutorialNinja.register;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import experiment.CommonUtils;
import pages.AccountPage;
import pages.AcountSuccessPage;
import pages.LandingPage;
import pages.NewsletterPage;
import pages.RegisterPage;

public class Register extends Base {

	WebDriver driver;
	Properties prop;
	RegisterPage registerPage;
	LandingPage landingPage;
	AcountSuccessPage acountSuccessPage;
	AccountPage accountPage;
	NewsletterPage newsletterPage;

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@BeforeMethod
	public void setUp() {

		driver = openBrowserAndApplication();
		prop = CommonUtils.loadProperties();
		landingPage = new LandingPage(driver); // LandingPage landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccount();
		// driver.findElement(By.xpath("//span[text()='My Account']")).click();

		registerPage = landingPage.selectRegisterOption();
		// driver.findElement(By.linkText("Register")).click();

	}

	@Test(priority = 1)
	public void verifyRegistering() {
		registerPage.enterFirstName(prop.getProperty("firstName")); // driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName")); // driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
		registerPage.enterEmail(CommonUtils.generateBrandNewEmail()); // driver.findElement(By.id("input-email")).sendKeys(CommonUtils.generateBrandNewEmail());
		registerPage.enterTelephone(prop.getProperty("telephone")); // driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("password")); // driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("password"));
		registerPage.enterConfirmPassword(prop.getProperty("password")); // driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("password"));
		registerPage.selectPrivacyPolicy(); // driver.findElement(By.name("agree")).click();
		acountSuccessPage = registerPage.clickOnContinueButton(); // driver.findElement(By.xpath("//input[@type='submit']")).click();
		acountSuccessPage.isUserLogedIn(); // Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());

		String expectedHeading = "Your Account Has Been Created!";
		// Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(),
		// expectedHeading);
		Assert.assertEquals(acountSuccessPage.getPageHeading(), expectedHeading);

		accountPage = acountSuccessPage.clickContinueButton(); // driver.findElement(By.xpath("//div[@class='buttons']//a")).click();

		Assert.assertTrue(accountPage.didWeNavigateToAccountPage()); // Assert.assertTrue(driver.findElement(By.linkText("Edit
																		// your account information")).isDisplayed());
	}

	@Test(priority = 2)
	public void verifyRegisterAccountWithAllFields() {
		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(CommonUtils.generateBrandNewEmail());
		registerPage.enterTelephone(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("password"));
		registerPage.enterConfirmPassword(prop.getProperty("password"));
		registerPage.yesNewsLatterOption(); // driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		registerPage.selectPrivacyPolicy();
		acountSuccessPage = registerPage.clickOnContinueButton();
		acountSuccessPage.isUserLogedIn();
		Assert.assertTrue(acountSuccessPage.didWeNavigateToAccountSuccessPage()); // Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());

		String expectedProperDetailsOne = "Your Account Has Been Created!";
		String expectedProperDetailsTwo = "Congratulations! Your new account has been successfully created!";
		String expectedProperDetailsThree = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedProperDetailsFour = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedProperDetailsFive = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
		String expectedProperDetailsSix = "contact us";

		String actualProperDetails = acountSuccessPage.getPageContent(); // driver.findElement(By.id("content")).getText();

		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsOne));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsTwo));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsThree));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFour));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFive));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsSix));

		accountPage = acountSuccessPage.clickContinueButton();

		Assert.assertTrue(accountPage.didWeNavigateToAccountPage()); // Assert.assertTrue(driver.findElement(By.linkText("Edit
																		// your account information")).isDisplayed());
	}

	@Test(priority = 3)
	public void verifyRegistringAccountWithoutFillFields() {

		registerPage.clickOnContinueButton(); // driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String expectedFirstNameWarning = "First Name must be between 1 and 32 characters!";
		String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
		String expectedEmailWarning = "E-Mail Address does not appear to be valid!";
		String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";
		String expectedPasswordWarning = "Password must be between 4 and 20 characters!";
		String expectedPrivacyPolicyWarning = "Warning: You must agree to the Privacy Policy!";

		Assert.assertEquals(registerPage.getFirstNameWarning(), expectedFirstNameWarning); // Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(),expectedFirstNameWarning);
		Assert.assertEquals(registerPage.getLastNameWarning(), expectedLastNameWarning); // Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(),
																							// expectedLastNameWarning);
		Assert.assertEquals(registerPage.getEmailWarning(), expectedEmailWarning); // Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText(),expectedEmailWarning);
		Assert.assertEquals(registerPage.getTelephoneWarning(), expectedTelephoneWarning); // Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(),expectedTelephoneWarning);
		Assert.assertEquals(registerPage.getPasswordWarning(), expectedPasswordWarning); // Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(),
																							// expectedPasswordWarning);
		Assert.assertEquals(registerPage.getPrivacyPolicyWarning(), expectedPrivacyPolicyWarning); // Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert
																									// alert-danger
																									// alert-dismissible']")).getText(),
																									// expectedPrivacyPolicyWarning);

	}

	@Test(priority = 4)
	public void verifyRegisteringAccountBySubscribingToNewsletter() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(CommonUtils.generateBrandNewEmail());
		registerPage.enterTelephone(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("password"));
		registerPage.enterConfirmPassword(prop.getProperty("password"));
		registerPage.yesNewsLatterOption(); // driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		registerPage.selectPrivacyPolicy();
		acountSuccessPage = registerPage.clickOnContinueButton(); // driver.findElement(By.xpath("//input[@value='Continue']")).click();
		acountSuccessPage.clickContinueButton(); // driver.findElement(By.linkText("Continue")).click();

		newsletterPage = accountPage.selectSubscribeUnsubscribeNewsletterOption(); // driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();
																					
		Assert.assertTrue(newsletterPage.didWeNavigateToNewsletterPage()); // Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Newsletter']")).isDisplayed());
		Assert.assertTrue(newsletterPage.isYesNewsletterOptionSelected()); // Assert.assertTrue(driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).isSelected());

	}

}
