package MobileTestProject;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class createToDoList {
	 // Instantiate Appium Driver
	
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;
	
	@BeforeTest
	  public void beforeTest() throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
	  	
	      caps.setCapability("deviceId", "d4b8ac43");
		
	      caps.setCapability("deviceName", "Lenovo K6 POWER");
		
	      caps.setCapability("platformName", "android");
		
	   caps.setCapability("appPackage", "com.android.chrome");
		
	   caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
	    
	      caps.setCapability("noReset", true);
	      
	      caps.setCapability("adbExecTimeout", "20000");
	     
	      // Initialize driver
		
	        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	    	
	        driver = new AndroidDriver<MobileElement>(appServer, caps);
		
	        wait = new WebDriverWait(driver, 100);
	        
	       
	  }	
	
  @Test
  public void createToDoListMethod() {
	  
	  // Open page & scroll to the To Do List option
  	
      driver.get("https://www.training-support.net/selenium");
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View")));
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().className(\"android.view.View\")).scrollIntoView("
				+ "new UiSelector().description(\"To-Do List Elements get added at run time\"))")).click();
	  
	
	 String Tasks[] = {"Add tasks to list", "Get number of tasks","Clear the list"};  
	
	// Add tasks
	for (int i=0;i<Tasks.length;i++)
	{
		driver.findElementById("taskInput").sendKeys(Tasks[i]);
		driver.findElementByClassName("android.widget.Button").click();
	}
	
	//Strike Out tasks
	
	for (int i=0;i<Tasks.length;i++)
	{
		driver.findElementByLinkText(Tasks[i]).click();
		
	}
	
	//Clear the lists
	
	driver.findElementByClassName("android.view.View").click();
	
	
	  
  }
  

  @AfterTest
  public void afterTest() {
	 // driver.quit();
  }

}
