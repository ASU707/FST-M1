package SeleniumProject_JobBoard;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class class_JobBoard {
	
	WebDriver driver;
	
  @BeforeMethod
	  public void openBrowser() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUSMITAKUNDU\\Desktop\\Selenium_Required\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.get("https://alchemy.hguy.co/jobs");
	  
	  }

  @Test
  public void verifyWebsiteTitle_UC1() {
	  
	  String websiteTitle = driver.findElement(By.xpath("//head/title")).getAttribute("textContent");
	  System.out.println("Website Title is: "+websiteTitle);
	  Assert.assertEquals("Alchemy Jobs – Job Board Application", websiteTitle);
	  
  }
@Test  
public void verifyWebsiteHeading1_UC2() {
	  
	 String websiteHeading = driver.findElement(By.xpath(".//*[@class= 'entry-title' and @itemprop = 'headline']")).getAttribute("textContent");
	  System.out.println("Website's First Heading is: "+websiteHeading);
	  Assert.assertEquals("Welcome to Alchemy Jobs", websiteHeading);
	  
  }

@Test  
public void verifyImageUrl_UC3() {
	  
	 String imgsrc = driver.findElement(By.xpath(".//*[@class= 'post-thumb-img-content post-thumb']/img")).getAttribute("src");
	  System.out.println("Image URL is : "+imgsrc);
	 	  
  }

@Test  
public void verifyWebsiteHeading2_UC4() {
	  
	String websiteHeading = driver.findElement(By.xpath("//div[@class = 'entry-content clear']/h2")).getAttribute("textContent");
	  System.out.println("Website's Second Heading is: "+websiteHeading);
	  Assert.assertEquals("Quia quis non", websiteHeading);
	  
  }
  
  @Test  
  public void verifyJobPage_UC5() {
  	  
   driver.findElement(By.xpath("//div[@class = 'main-navigation']/ul/li[1]/a")).click();
   String pageTitleJobs = driver.getTitle();
  	  System.out.println("Page Title of Job Page is: "+pageTitleJobs);
  	  Assert.assertEquals("Jobs – Alchemy Jobs", pageTitleJobs);
  	  
    }  
  
  @AfterMethod
  public void closeBrowser() {
	  driver.quit();
  }

}
