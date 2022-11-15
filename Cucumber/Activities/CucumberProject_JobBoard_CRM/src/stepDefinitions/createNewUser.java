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


public class createNewUser {

	WebDriver driver;
	WebDriverWait wait;
	
	String newUserName = "JBUser28";
    String newUserEmail = "JBUser28@alchemy.com";

	@Given("^User is on Admin Page$")
	public void userLogin() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUSMITAKUNDU\\Desktop\\Selenium_Required\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver ();
		driver.manage().window().maximize();
		
		 driver.get("https://alchemy.hguy.co/jobs/wp-admin");
			
		  String userName = "root";
		  String password = "pa$$w0rd";
		  
		  driver.findElement(By.id("user_login")).sendKeys(userName);
		  driver.findElement(By.id("user_pass")).sendKeys(password);
		  driver.findElement(By.name("wp-submit")).click();
		
	}

	@When("^User adds a new User$")
	public void userCreation() throws Throwable {
		
		//Navigate to Users Page
	
		String hrefUsers = driver.findElement(By.xpath("//div[@id = 'adminmenuwrap']/ul/li[11]/a")).getAttribute("href");
	    driver.get(hrefUsers);
	    String addUsers = driver.findElement(By.xpath("//div[@class = 'wrap']/a")).getAttribute("href");
	    driver.get(addUsers);
	    
	    //Create User
	    
	    
	    driver.findElement(By.id("user_login")).sendKeys(newUserName);
	    WebElement temp = driver.findElement(By.id("email"));
	    temp.sendKeys(newUserEmail);
	    temp.sendKeys(Keys.TAB);
	    temp.sendKeys(Keys.TAB);
	    temp.sendKeys(Keys.TAB);
	    temp.sendKeys(Keys.TAB);
	    temp.sendKeys(Keys.ENTER);
	    
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  
	    driver.findElement(By.id("createusersub")).click();
	    
	    
	}
	@Then("^New User gets added$")
	public void verifyCreation() throws Throwable {
	
		//Search the above User
	    driver.findElement(By.id("user-search-input")).sendKeys(newUserName);
	    driver.findElement(By.id("search-submit")).click();
	    
	    String getconfirmText = driver.findElement(By.xpath("//div[@class = 'tablenav-pages one-page']/span")).getAttribute("innerHTML");
	    System.out.println(getconfirmText);
	    
	    if (getconfirmText.equalsIgnoreCase("1 item"))
	    {
	    	System.out.println("User is created successfully...");
	    }
	    else
	    {
	    	System.out.println("Some Problem with User Creation");
	    }
	} 
        
    @And("^Close the browser$")
	 public void closeTheBrowser() throws Throwable {
	
        driver.close();
    }
}
