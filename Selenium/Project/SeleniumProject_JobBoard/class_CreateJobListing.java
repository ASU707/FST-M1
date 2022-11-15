package SeleniumProject_JobBoard;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class class_CreateJobListing {
	
	WebDriver driver;
	@BeforeMethod
			  public void openBrowser() {
			  
			  System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUSMITAKUNDU\\Desktop\\Selenium_Required\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver ();
				driver.manage().window().maximize();
				driver.get("https://alchemy.hguy.co/jobs/wp-admin");		  
			  }			
  @Test
public void create_JobListing_BE_UC9() {
	  String userName = "root";
	  String password = "pa$$w0rd";
	  String jobPosition = "Lead Developer Technical";
	  String applicationURL = "MyCompany@fine.com";
	  String companyName = "HighTech Ltd.";
	 
	  driver.findElement(By.id("user_login")).sendKeys(userName);
	  driver.findElement(By.id("user_pass")).sendKeys(password);
	  driver.findElement(By.name("wp-submit")).click();
	  
	// Go to Job Listing 
	  
	  String hrefJobListing = driver.findElement(By.xpath("//div[@id = 'adminmenuwrap']/ul/li[7]/a")).getAttribute("href");
	  driver.get(hrefJobListing);
	  
	  //Click on Add New Button
	  String addNewLink = driver.findElement(By.xpath("//div[@class='wrap']/a")).getAttribute("href");
	  driver.get(addNewLink);
	  driver.findElement(By.id("post-title-0")).sendKeys(jobPosition);
	  
	  //Fill in details
	  WebElement appTextBox = driver.findElement(By.id("_application"));
	  appTextBox.clear();
	  appTextBox.sendKeys(applicationURL);
	  driver.findElement(By.id("_company_name")).sendKeys(companyName);
	 	  
	  driver.findElement(By.cssSelector("button[class='components-button editor-post-publish-panel__toggle editor-post-publish-button__button is-primary']")).click();
	  driver.findElement(By.cssSelector("button[class='components-button editor-post-publish-button editor-post-publish-button__button is-primary']")).click();
	   
	  
  }
  
  @Test
  public void verifyJobInPortal()
  {
	  // Open Job Portal
	  driver.get("https://alchemy.hguy.co/jobs");
	  
	  String jobTitle = "Lead Developer Technical";
	  
	  //Verify the Job is found in Job Page
	  
	  driver.findElement(By.xpath("//div[@class = 'main-navigation']/ul/li[1]/a")).click();
	  
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 //Enter Job details
	 WebElement jobName = driver.findElement(By.id("search_keywords"));
	 driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
	 jobName.sendKeys(jobTitle);
	 jobName.sendKeys(Keys.TAB);
	 jobName.sendKeys(Keys.TAB);
	
	 
	 //Go to the job
	  String hrefJob = driver.findElement(By.xpath("//div[@class = 'job_listings']/ul/li[1]/a")).getAttribute("href");
	  driver.get(hrefJob);
	  
	  // Verify the above job is shown
	  String verifyJobName = driver.findElement(By.xpath("//div[@class = 'ast-single-post-order']/h1")).getAttribute("textContent");
	  Assert.assertEquals(jobTitle, verifyJobName);
	 
  }
  
  @AfterMethod
  public void closeBrowser() {
	driver.quit();
  }
}
