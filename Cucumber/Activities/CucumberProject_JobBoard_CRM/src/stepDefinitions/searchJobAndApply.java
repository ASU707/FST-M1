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

public class searchJobAndApply {
	

		WebDriver driver;
		WebDriverWait wait;
		
		String jobTitle = "BDD1_Cucumber";

		@Given("^User is on Job Page$")
		public void jobPage() 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUSMITAKUNDU\\Desktop\\Selenium_Required\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver ();
			driver.manage().window().maximize();
			driver.get("https://alchemy.hguy.co/jobs");
			
			//Navigate to the Job page
			  driver.findElement(By.xpath("//div[@class = 'main-navigation']/ul/li[1]/a")).click();
			  
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}

		@When("^User searches for a Full Time Job$")
		public void jobSearch() throws Throwable {
			
			//Uncheck all other Job types other than Full Time Job
			
			driver.findElement(By.id("job_type_freelance")).click();
			driver.findElement(By.id("job_type_internship")).click();
			driver.findElement(By.id("job_type_part-time")).click();
			driver.findElement(By.id("job_type_temporary")).click();
			
					
			 //Enter Job details
			WebElement element =  driver.findElement(By.id("search_keywords"));
			element.sendKeys(jobTitle);
			element.sendKeys(Keys.TAB);
			element.sendKeys(Keys.TAB);
			
			//Navigate to the Job Page
			
			 String hrefJob = driver.findElement(By.xpath("//div[@class = 'job_listings']/ul/li[1]/a")).getAttribute("href");
			 driver.get(hrefJob);
		    
		   
		    
		}
		@Then("^User Applies for the Job$")
		public void jobApply() throws Throwable {
			
			// Verify the Title of the Job Listing
			 
			 String jobListingTitle = driver.findElement(By.xpath("//div[@class = 'ast-single-post-order']/h1")).getText();
			 System.out.println("Title of the Job Listing is: "+jobListingTitle);
			 
			 
			//Apply for Job
			  driver.findElement(By.xpath("//input[@type='button' and @value='Apply for job']")).click();
		
			
		} 
	        
	    @And("^Close the Job Listing browser$")
		 public void closeThe2ndBrowser() throws Throwable {
		
	        driver.close();
	    }
	}
