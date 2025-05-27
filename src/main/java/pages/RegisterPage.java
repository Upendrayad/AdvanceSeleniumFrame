package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	public void enterEmail(String emailText) {
		emailField.sendKeys(emailText);
	}
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	public void enterTelephone(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	public void enterPassword(String Password) {
		passwordField.sendKeys(Password);
	}

	@FindBy(id = "input-confirm")
	private WebElement passwordConfirmField;
	
	public void enterConfirmPassword(String Password) {
		passwordConfirmField.sendKeys(Password);
	}
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement newsLetter;
	
	public void yesNewsLatterOption() {
		newsLetter.click();
	}

	@FindBy(name = "agree")
	private WebElement privacyPolicyField;
	
	public void selectPrivacyPolicy() {
		privacyPolicyField.click();
	}

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	public AcountSuccessPage clickOnContinueButton() {
		continueButton.click();
		return new AcountSuccessPage(driver);
	}
	
		@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
		private WebElement firstNameWarning;
		
		public String getFirstNameWarning() {
			return firstNameWarning.getText();
		}
		
		@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
		private WebElement lastNameWarning;
		
		public String getLastNameWarning() {
			 return lastNameWarning.getText();
		}
		
		@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
		private WebElement emailWarning;

		@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
		private WebElement telephoneWarning;

		@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
		private WebElement passwordWarning;

		@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
		private WebElement privacyPolicyWarning;
		
		public String getEmailWarning() {
			return emailWarning.getText();
		}

		public String getTelephoneWarning() {
			return telephoneWarning.getText();
		}

		public String getPasswordWarning() {
			return passwordWarning.getText();
		}

		public String getPrivacyPolicyWarning() {
			return privacyPolicyWarning.getText();
		}

}
