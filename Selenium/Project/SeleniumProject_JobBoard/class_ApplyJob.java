package SeleniumProject_JobBoard;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class class_ApplyJob {
	
	WebDriver driver;
	
	  @BeforeMethod
		  public void openBrowser() {
		  
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUSMITAKUNDU\\Desktop\\Selenium_Required\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver ();
			driver.manage().window().maximize();
			driver.get("https://alchemy.hguy.co/jobs");
					  
		  }
	
  
	  @Test
	public void applyJob_UC6() {
	  //Variables
		  String searchJobName = "Testing";
		  String searchJobLocation = "Bangalore";
	  
	  //Navigate to the Job page
	  driver.findElement(By.xpath("//div[@class = 'main-navigation']/ul/li[1]/a")).click();
	  
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 //Enter Job details
	  driver.findElement(By.id("search_keywords")).sendKeys(searchJobName);
	  WebElement element = driver.findElement(By.id("search_location"));
	 element.sendKeys(searchJobLocation);
	 element.sendKeys(Keys.TAB);
	 
	 //Go to any job
	  String hrefJob = driver.findElement(By.xpath("//div[@class = 'job_listings']/ul/li[1]/a")).getAttribute("href");
	  driver.get(hrefJob);
	 
	  //Apply for Job
	  driver.findElement(By.xpath("//input[@type='button' and @value='Apply for job']")).click();
	  //Get the Email Address
	  String hrefValueWhole = driver.findElement(By.xpath("//div[@class = 'application_details']/p/a")).getAttribute("href");
	  int index1 = hrefValueWhole.indexOf(":");
	  int index2 = hrefValueWhole.indexOf("?");
	  String emailAddress = hrefValueWhole.substring(index1+1, index2);
	  System.out.println("The Email Address is: "+emailAddress);
	  
  }
  

  @AfterMethod
  public void closeBrowser() {
	 driver.quit();
  }

}
