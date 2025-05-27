package tutorialNinja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;

public class TC_RF_014 extends Base{
	
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
	public void verifyMandatoryFieldsSymbolAndColorInRegisterAccountPage() {
		
		String expectedContent = "\"* \"";
		String expectedColor = "rgb(255, 0, 0)";
		
		WebElement firstNameLabel = driver.findElement(By.cssSelector("label[for='input-firstname']"));
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String fnContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", firstNameLabel);
		String fnColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", firstNameLabel);
		
		
		System.out.println(fnContent);
		System.out.println(fnColor);
		
		Assert.assertEquals(fnContent, expectedContent);
		Assert.assertEquals(fnColor, expectedColor);

}
}
