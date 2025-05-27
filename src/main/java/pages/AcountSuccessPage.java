package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcountSuccessPage {
	WebDriver driver;

	public AcountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Logout")
	private WebElement logoutOptiont;

	public boolean isUserLogedIn() {
		return logoutOptiont.isDisplayed();  //Assert.assertTrue(logoutOptiont.isDisplayed());
	}
	
	@FindBy(xpath="//div[@id='common-success']//h1")
	private WebElement getPageHeading;
	
	public String getPageHeading() {
		return getPageHeading.getText();
	}
	
	@FindBy(id="content")
	private WebElement pageContent;
	
	public String getPageContent() {
		 return pageContent.getText();
	}
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Success']")
	private WebElement accountSuccessPageBreadcrumb;
	
	public boolean didWeNavigateToAccountSuccessPage() {
		return accountSuccessPageBreadcrumb.isDisplayed();
	}
	
	@FindBy(xpath="//div[@class='buttons']//a")
	private WebElement continueButton;
	
	public AccountPage clickContinueButton() {
		continueButton.click();
		return new AccountPage(driver);
	}
}
