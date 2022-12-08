package lama.SeleniumHandsonAssessment;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class CaptureTooltip {

	public WebDriver driver;
	public static final String driverPath = "//Users//lama//Desktop//Selenium//chromedriver";
	public String text ="Toronto";
	
	@Test
	public void TC_01() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",driverPath);
		driver = new ChromeDriver();
		
		driver.navigate().to("https://jqueryui.com/tooltip/");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		
		WebElement frameElement = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frameElement);
		
		WebElement ageTextBox = driver.findElement(By.xpath("//*[@id=\"age\"]"));
		
		String tooltipText = ageTextBox.getAttribute("title");
	    System.out.println("Tooltip obtained from title: " + tooltipText);

		AssertJUnit.assertEquals(tooltipText, "We ask for your age only for statistical purposes.");

	}
	
	@AfterSuite
	public void closeBrowser() throws InterruptedException {
		// Close the browser
		driver.close();
		
		// Quit the browser
		driver.quit();
	}
}
