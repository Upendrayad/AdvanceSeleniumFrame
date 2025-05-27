package tutorialNinja.register;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import experiment.CommonUtils;

public class TC_RF_010 extends Base{
	
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
	public void verifyRegisteringAccountUsingInvalidEmail() throws InterruptedException, IOException {
		
    	 driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
 		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
 		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("invalidEmailOne"));
 		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephone"));
 		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("password"));
 		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	
		File srcScreenshot1 = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcScreenshot1,new File(System.getProperty("user.dir")+"\\Screenshots\\sc1Actual.png"));
		
		Thread.sleep(3000);
		
		//Assert.assertFalse(CommonUtils.compareTwoScreenshots(System.getProperty("user.dir")+"\\Screenshots\\sc1Actual.png",System.getProperty("user.dir")+"\\Screenshots\\sc1Expected.png"));
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("invalidEmailTwo"));
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Thread.sleep(2000);
		
		File srcScreenshot2 = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcScreenshot2,new File(System.getProperty("user.dir")+"\\Screenshots\\sc2Actual.png"));
		
		Thread.sleep(2000);
		
		//Assert.assertFalse(CommonUtils.compareTwoScreenshots(System.getProperty("user.dir")+"\\Screenshots\\sc2Actual.png",System.getProperty("user.dir")+"\\Screenshots\\sc2Expected.png"));
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("invalidEmailThree"));
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Thread.sleep(2000);
		
		String expectedWarningMessage = "E-Mail Address does not appear to be valid!";
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText(), expectedWarningMessage);
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("invalidEmailFour"));
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Thread.sleep(3000);
		
		File srcScreenshot3 = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcScreenshot3,new File(System.getProperty("user.dir")+"\\Screenshots\\sc3Actual.png"));
		
		Thread.sleep(3000);
		
		//Assert.assertFalse(CommonUtils.compareTwoScreenshots(System.getProperty("user.dir")+"\\Screenshots\\sc3Actual.png",System.getProperty("user.dir")+"\\Screenshots\\sc3Expected.png"));
		
	}

}
