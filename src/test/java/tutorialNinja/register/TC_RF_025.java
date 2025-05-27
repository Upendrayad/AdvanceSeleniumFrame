package tutorialNinja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;

public class TC_RF_025 extends Base {
	

	WebDriver driver;

	@AfterMethod
	public void teardown() {
		if(driver != null)
		{
		driver.quit();
		}
	}

	@BeforeMethod
		public void setUp(){
		    driver = openBrowserAndApplication();			
			driver.findElement(By.xpath("//span[text()='My Account']")).click();
			driver.findElement(By.linkText("Register")).click();
	        }
	@Test
	
public void verifyPlaceHoldersOfTextFieldsInRegisterAccountPage() {
		
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
		
		String pageHeading = "Register Account";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/h1")).getText(), pageHeading);
		
		String expectedURL = "https://tutorialsninja.com/demo/index.php?route=account/register";
		Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
		
		String expectedTitle = "Register Account";
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		
}
}
