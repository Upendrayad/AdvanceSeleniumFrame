package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsletterPage {

	WebDriver driver;
	
	public NewsletterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Newsletter']")
	private WebElement newsletterBreadcrumb;
	
	public boolean didWeNavigateToNewsletterPage() {
		 return newsletterBreadcrumb.isDisplayed();
	}
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsletterOption;
	
	public boolean isYesNewsletterOptionSelected() {
		return yesNewsletterOption.isSelected();
	}
}
