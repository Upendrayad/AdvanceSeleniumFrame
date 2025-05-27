package tutorialNinja.register;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import experiment.CommonUtils;

public class TC_RF_012 extends Base{

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
	@Test
	public void verifyRegisteringAccountUsingKeyboardKeys() {
		
		Actions actions = new Actions(driver);
		
		for(int i=1;i<=23;i++) {
		 actions.sendKeys(Keys.TAB).perform();
		}
		
		 actions.sendKeys(prop.getProperty("firstName")).pause(Duration.ofSeconds(1))
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(prop.getProperty("lastName"))
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(CommonUtils.generateBrandNewEmail())
		.pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
		.sendKeys(prop.getProperty("telephone")).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
		.pause(Duration.ofSeconds(1)).sendKeys(prop.getProperty("password")).pause(Duration.ofSeconds(1))
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(prop.getProperty("password"))
		.pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
		.sendKeys(Keys.LEFT).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
		.pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
		.sendKeys(Keys.SPACE).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
		.pause(Duration.ofSeconds(1)).sendKeys(Keys.ENTER).build().perform();
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='column-right']//a[text()='Logout']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
		
	}

}
