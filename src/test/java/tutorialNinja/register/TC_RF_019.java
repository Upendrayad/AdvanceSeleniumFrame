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

public class TC_RF_019 extends Base{
	
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
	public void  verifyLeadingAndTrailingSpacesWhileRegisteringAccount() {
		
		String enteredFirstName = "        " +prop.getProperty("firstName")+ "     ";
		driver.findElement(By.id("input-firstname")).sendKeys(enteredFirstName);
		String enteredLastName = "       "+prop.getProperty("lastName")+"    ";
		driver.findElement(By.id("input-lastname")).sendKeys(enteredLastName);
		String enteredEmail = "      "+CommonUtils.generateBrandNewEmail()+"       ";
		driver.findElement(By.id("input-email")).sendKeys(enteredEmail);
		String enteredTelphone = "   "+prop.getProperty("telephone")+"   ";
		driver.findElement(By.id("input-telephone")).sendKeys(enteredTelphone);
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.findElement(By.xpath("//a[@class='btn btn-primary'][text()='Continue']")).click();
		driver.findElement(By.linkText("Edit your account information")).click();
		
		Assert.assertEquals(driver.findElement(By.id("input-firstname")).getDomAttribute("value"),enteredFirstName.trim());
		Assert.assertEquals(driver.findElement(By.id("input-lastname")).getDomAttribute("value"), enteredLastName.trim());
		Assert.assertEquals(driver.findElement(By.id("input-email")).getDomAttribute("value"), enteredEmail.trim());
		Assert.assertEquals(driver.findElement(By.id("input-telephone")).getDomAttribute("value"), enteredTelphone.trim());
	}

}
