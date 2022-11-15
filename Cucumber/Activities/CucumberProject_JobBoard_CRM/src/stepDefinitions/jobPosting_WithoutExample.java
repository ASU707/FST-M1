package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class jobPosting_WithoutExample {


	WebDriver driver;
	WebDriverWait wait;


	@Given("^User is on Post Job Page$")
	public void jobPostPage() 
	{
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUSMITAKUNDU\\Desktop\\Selenium_Required\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver ();
			driver.manage().window().maximize();
			
			// Open Job Portal
			  driver.get("https://alchemy.hguy.co/jobs");
			  
			//Navigate to the Post a Job page
			  driver.findElement(By.xpath("//div[@class = 'main-navigation']/ul/li[3]/a")).click();
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);		  
		
	}

	@When("^User enters details for Job with \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	public void postJobPage(String email, String jobTitle, String description, String applicationURL, String companyName) throws Throwable {
		
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
		  
           
	}
	@Then("^User Creates and Verifies the Job with \"(.*)\"$")
	public void verifyPostedJob(String verifyJobName) throws Throwable {
		
		// Open website’s backend portal and login
		  
		  driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		  
		
		  String userName = "root";
		  String password = "pa$$w0rd";
		 		  
		  driver.findElement(By.id("user_login")).sendKeys(userName);
		  driver.findElement(By.id("user_pass")).sendKeys(password);
		  driver.findElement(By.name("wp-submit")).click();
		  
		// Go to Job Listing and Search the above Job to approve it  
		  
		  String hrefJobListing = driver.findElement(By.xpath("//div[@id = 'adminmenuwrap']/ul/li[7]/a")).getAttribute("href");
		  driver.get(hrefJobListing);
		  
		  driver.findElement(By.id("post-search-input")).sendKeys(verifyJobName);
		  driver.findElement(By.id("search-submit")).click();
		  
		  String hrefApproveJob = driver.findElement(By.xpath("//table[@class='wp-list-table widefat fixed striped posts']/tbody/tr[1]/td[9]/div/a")).getAttribute("href");
		  driver.get(hrefApproveJob);
		  
		  
		// Open Job Portal
		  driver.get("https://alchemy.hguy.co/jobs");
		  
		 //Verify the Job is found in Job Page
		  
		  driver.findElement(By.xpath("//div[@class = 'main-navigation']/ul/li[1]/a")).click();
		  
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 //Enter Job details
		 WebElement jobName = driver.findElement(By.id("search_keywords"));
		 driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		 jobName.sendKeys(verifyJobName);
		 jobName.sendKeys(Keys.TAB);
		 jobName.sendKeys(Keys.TAB);
		
		 
		 //Go to the job
		  String hrefJob = driver.findElement(By.xpath("//div[@class = 'job_listings']/ul/li[1]/a")).getAttribute("href");
		  driver.get(hrefJob);
		  
		  // Verify the above job is shown
		  String jobNameFound = driver.findElement(By.xpath("//div[@class = 'ast-single-post-order']/h1")).getAttribute("textContent");
		  System.out.println(jobNameFound);
		  
		  if(verifyJobName.equalsIgnoreCase(jobNameFound))
		  {
			  System.out.println("Job Posted Successfully"); 
		  }
		  
		  else
		  {
			  System.out.println("Job is not Posted Successfully"); 
		  }
	} 
        
    @And("^Close the Job Listing Verification browser$")
	 public void closeThe3rdBrowser() throws Throwable {
	
        driver.close();
    }
}

