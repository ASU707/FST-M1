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

public class class_PostJob {
	
	WebDriver driver;
	
	  @BeforeMethod
		  public void openBrowser() {
		  
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUSMITAKUNDU\\Desktop\\Selenium_Required\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver ();
			driver.manage().window().maximize();
					  
		  }	

@Test (priority = 0)
	  
  public void postJob_UC7() {
	  
	  //Variable details
	  
	  String email = "ABC_Owner@test.com";
	  String jobTitle = "Application Junior Developer";
	  String description = "Application Junior Developer Profile";
	  String applicationURL = "https://general/application/webpages/jobs";
	  String companyName = "Private TECH Company";
	  
	  // Open Job Portal
	  driver.get("https://alchemy.hguy.co/jobs");
	  
	//Navigate to the Post a Job page
	  driver.findElement(By.xpath("//div[@class = 'main-navigation']/ul/li[3]/a")).click();
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  
	//Enter Job details in above 5 fields one by one
	  
	  driver.findElement(By.id("create_account_email")).sendKeys(email);
	  driver.findElement(By.id("job_title")).sendKeys(jobTitle);
	  
	  WebElement iframe = driver.findElement(By.xpath("//iframe[@id='job_description_ifr']")); 
	  driver.switchTo().frame(iframe);
	  
	  WebElement descArea = driver.findElement(By.xpath("//html/body/p"));
	  descArea.sendKeys(description);
	
	  driver.switchTo().defaultContent();
	  
	 driver.findElement(By.id("application")).sendKeys(applicationURL);
	 driver.findElement(By.id("company_name")).sendKeys(companyName);
	 
	//Preview the Job
	  driver.findElement(By.name("submit_job")).click();
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  
	//Submit the Job
	  driver.findElement(By.name("continue")).click();
	  
	//Verify it is submitted properly
	  String successText = driver.findElement(By.xpath(".//*[@class= 'entry-content clear' and @itemprop = 'text']")).getAttribute("textContent");
	  System.out.println(successText);
	  Assert.assertEquals("Job submitted successfully. Your listing will be visible once approved.", successText.trim());
	
  }
 
  @Test (priority = 1)
  public void loginAndApprove_UC7()
  {
	  
	// Open website’s backend portal and login
	  
		  driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		
		  String userName = "root";
		  String password = "pa$$w0rd";
		  String jobTitle = "Application Junior Developer";
		  
		  driver.findElement(By.id("user_login")).sendKeys(userName);
		  driver.findElement(By.id("user_pass")).sendKeys(password);
		  driver.findElement(By.name("wp-submit")).click();
		  
		// Go to Job Listing and Search the above Job to approve it  
		  
		  String hrefJobListing = driver.findElement(By.xpath("//div[@id = 'adminmenuwrap']/ul/li[7]/a")).getAttribute("href");
		  driver.get(hrefJobListing);
		  
		  driver.findElement(By.id("post-search-input")).sendKeys(jobTitle);
		  driver.findElement(By.id("search-submit")).click();
		  
		  String hrefApproveJob = driver.findElement(By.xpath("//table[@class='wp-list-table widefat fixed striped posts']/tbody/tr[1]/td[9]/div/a")).getAttribute("href");
		  driver.get(hrefApproveJob);
		  
  }
  
  @Test (priority = 2)
  public void verifyJobInPortal_UC7()
  {
	  // Open Job Portal
	  driver.get("https://alchemy.hguy.co/jobs");
	  
	  String jobTitle = "Application Junior Developer";
	  
	  //Verify the Job is found in Job Page
	  
	  driver.findElement(By.xpath("//div[@class = 'main-navigation']/ul/li[1]/a")).click();
	  
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 //Enter Job details
	 WebElement jobName = driver.findElement(By.id("search_keywords"));
	 driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
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
