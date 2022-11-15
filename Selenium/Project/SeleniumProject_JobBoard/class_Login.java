package SeleniumProject_JobBoard;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class class_Login {
	
	WebDriver driver;
@BeforeMethod
		  public void openBrowser() {
		  
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUSMITAKUNDU\\Desktop\\Selenium_Required\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver ();
			driver.manage().window().maximize();
			driver.get("https://alchemy.hguy.co/jobs/wp-admin");		  
		  }		
  @Test
  public void loginProcess_UC8() {
	  String userName = "root";
	  String password = "pa$$w0rd";
	 
	  driver.findElement(By.id("user_login")).sendKeys(userName);
	  driver.findElement(By.id("user_pass")).sendKeys(password);
	  driver.findElement(By.name("wp-submit")).click();
	  
	  String pageTitle = driver.getTitle();
	  Assert.assertEquals("Dashboard ‹ Alchemy Jobs — WordPress", pageTitle);
  }
  

  @AfterMethod
  public void closeBrowser() {
	 driver.quit();
  }

}
