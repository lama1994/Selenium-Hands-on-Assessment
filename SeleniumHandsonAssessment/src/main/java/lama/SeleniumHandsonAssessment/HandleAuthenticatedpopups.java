package lama.SeleniumHandsonAssessment;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class HandleAuthenticatedpopups {
	public WebDriver driver;
	public static final String driverPath = "//Users//lama//Desktop//Selenium//chromedriver";
	public String text ="Toronto";
	
	@Test
	public void TC_01() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",driverPath);
		driver = new ChromeDriver();
		
		driver.navigate().to("https://the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
	
		String username = "admin";
		String password = "admin";
		
		String URL = "https://" +username +":" +password +"@"+ "the-internet.herokuapp.com/basic_auth";
		driver.get(URL);
		Thread.sleep(2000);

		
		
		WebElement message = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p"));
		String m=message.getText();
		System.out.println("Message is "+m);
		
		AssertJUnit.assertEquals(m, "Congratulations! You must have the proper credentials.");
		Thread.sleep(2000);

	}
	
	@AfterSuite
	public void closeBrowser() throws InterruptedException {
		// Close the browser
		driver.close();
		
		// Quit the browser
		driver.quit();
	}
}
