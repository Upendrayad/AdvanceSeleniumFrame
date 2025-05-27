package tutorialNinja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;

public class TC_RF_020 extends Base {
	
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
	public void verifyPrivacyPolicyFieldOnRegisterAccountPage() {

		Assert.assertFalse(driver.findElement(By.name("agree")).isSelected());
	}

}
