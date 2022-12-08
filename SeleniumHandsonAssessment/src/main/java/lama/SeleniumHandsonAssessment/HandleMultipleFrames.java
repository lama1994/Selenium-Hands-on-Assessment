package lama.SeleniumHandsonAssessment;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class HandleMultipleFrames {

	public WebDriver driver;
	public static final String driverPath = "//Users//lama//Desktop//Selenium//chromedriver";

	@Test
	public void TC_01() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",driverPath);
		driver = new ChromeDriver();
		
		driver.navigate().to("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement frameElement1 = driver.findElement(By.xpath("/html/body/main/div/div[1]/div[1]/iframe"));
		driver.switchTo().frame(frameElement1);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		WebElement frameElement2 = driver.findElement(By.xpath("/html/body/main/div/div[1]/div[2]/iframe"));
		driver.switchTo().frame(frameElement2);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		WebElement frameElement3 = driver.findElement(By.xpath("/html/body/main/div/div[2]/iframe"));
		driver.switchTo().frame(frameElement3);
		
		WebElement link = driver.findElement(By.xpath("//*[@id=\"i79\"]/th/a"));
		link.click();
		Thread.sleep(2000);
	}
	
	@AfterTest
    public void takeScreenshot()
    {
        //take screenshot of the page
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("/Users/lama/Desktop/Screenshotfram.png"));
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
