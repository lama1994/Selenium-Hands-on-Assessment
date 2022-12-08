package lama.SeleniumHandsonAssessment;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AutoSuggestDropdown {
	public WebDriver driver;
	public static final String driverPath = "//Users//lama//Desktop//Selenium//chromedriver";

	@Test
	public void TC_01() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",driverPath);
		driver = new ChromeDriver();
		
		driver.navigate().to("https://www.google.com/webhp?hl=en");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.name("q")).sendKeys("java tutorial");
		Thread.sleep(5000);
		
        List<WebElement> autoSuggest = driver.findElements(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div/ul/li"));
        
        for(WebElement list:autoSuggest)
		{
				
					System.out.println(list.getText());
	    }
        
        for(WebElement list:autoSuggest)
		{
				try {
					if(list.getText().contains("w3schools")) {
						list.click();
					 }
		        }
		        catch(StaleElementReferenceException staleException) {
		            staleException.printStackTrace();
		        }
	    }
       
        
	}
	
	@AfterTest
    public void takeScreenshot()
    {
        //take screenshot of the page
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("/Users/lama/Desktop/ScreenshotAutoSuggest.png"));
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
