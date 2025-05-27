package tutorialNinja.register;


import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import experiment.CommonUtils;

public class TC_RF_003 extends Base{
	
WebDriver driver;
Properties prop;
	
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
	        prop = CommonUtils.loadProperties();
			driver.findElement(By.xpath("//span[text()='My Account']")).click();
			driver.findElement(By.linkText("Register")).click();
	        }
	    @Test(priority=1)
public void verifyRegisterAccountWithAllFields() {
	    	driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
			driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
			driver.findElement(By.id("input-email")).sendKeys(CommonUtils.generateBrandNewEmail());
			driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephone"));
			driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("password"));
			driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("password"));
			driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
			driver.findElement(By.name("agree")).click();
			driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
		
		String expectedProperDetailsOne = "Your Account Has Been Created!";
		String expectedProperDetailsTwo = "Congratulations! Your new account has been successfully created!";
		String expectedProperDetailsThree = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedProperDetailsFour = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedProperDetailsFive = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
		String expectedProperDetailsSix = "contact us";
		
		String actualProperDetails = driver.findElement(By.id("content")).getText();
		
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsOne));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsTwo));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsThree));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFour));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFive));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsSix));
		
		driver.findElement(By.linkText("Continue")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	   }
	

}
