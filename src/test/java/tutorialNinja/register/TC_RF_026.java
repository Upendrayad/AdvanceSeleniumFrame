package tutorialNinja.register;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;

public class TC_RF_026 extends Base {
	

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
	public void verifyUIOfRegisterAccountPage() throws IOException {
		
		// https://drive.google.com/file/d/1X6EPJW-Ojl3Xpv99qrnOV4wU8FuekmtO/view
	
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcScreenshot = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(srcScreenshot,new File(System.getProperty("user.dir")+"\\Screenshots\\actualRegisterPageUI.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Assert.assertTrue(CommonUtils.compareTwoScreenshots(System.getProperty("user.dir")+"\\Screenshots\\actualRegisterPageUI.png", System.getProperty("user.dir")+"\\Screenshots\\expectedRegisterPageUI.png"));
		
	}
}
