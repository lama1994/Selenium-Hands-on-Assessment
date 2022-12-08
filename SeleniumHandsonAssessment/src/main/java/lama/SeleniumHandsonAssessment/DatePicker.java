package lama.SeleniumHandsonAssessment;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;

public class DatePicker {

	public WebDriver driver;
	public static final String driverPath = "//Users//lama//Desktop//Selenium//chromedriver";

	@Test
	public void TC_01() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",driverPath);
		driver = new ChromeDriver();
		
		driver.navigate().to("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		 WebElement dateBox = driver.findElement(By.xpath("//input[@id='dob']"));
		 dateBox.click();
		 Thread.sleep(2000);
		 
		 Select month = new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[1]")));
		 month.selectByVisibleText("Aug");
		 Thread.sleep(2000);
		 
		 Select year = new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[2]")));
		 year.selectByVisibleText("1994");
		 Thread.sleep(2000);
		 

		driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(3) > td:nth-child(3) > a")).click();
		Thread.sleep(2000);

		
	}
		
	
	 @AfterTest
	    public void takeScreenshot()
	    {
	        //take screenshot of the page
	        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        try {
	            FileUtils.copyFile(src, new File("/Users/lama/Desktop/Screenshot.png"));
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	 
	 @AfterSuite
		public void closeBrowser() throws InterruptedException {
			// Close the browser
			driver.close();
			
			// Quit the browser
			driver.quit();
		}
}
