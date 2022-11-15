package MobileTestProject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.awt.Dimension;
import java.awt.List;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class googleTask_Activity1 {
	
	AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;
	
 @BeforeClass
	  public void beforeClass() throws MalformedURLException {
	 

	  DesiredCapabilities caps = new DesiredCapabilities();
 	
     caps.setCapability("deviceId", "d4b8ac43");
	
     caps.setCapability("deviceName", "Lenovo K6 POWER");
	
     caps.setCapability("platformName", "android");
	
     caps.setCapability("appPackage", "com.google.android.apps.tasks");
	
     caps.setCapability("appActivity", ".ui.TaskListsActivity");
        
     caps.setCapability("noReset", true);
     
     caps.setCapability("adbExecTimeout", "20000");
     
  // Initialize driver
		
     URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
 	
     driver = new AndroidDriver<MobileElement>(appServer, caps);
	
     wait = new WebDriverWait(driver, 100);
     
	  }
	
  @Test
  public void googleTaskAct1() {
	
	  
	 String Tasks[] = {"Complete Activity with Google Tasks", "Complete Activity with Google Keep","Complete the second Activity Google Keep"};  
		
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Add tasks
		for (int i=0;i<Tasks.length;i++)
		{
			driver.findElementById("tasks_fab").click();
			driver.findElementById("add_task_title").sendKeys(Tasks[i]);
			driver.findElementById("add_task_done").click();
			
					
		}
	  
		java.util.List<MobileElement> textItems = driver.findElementsByClassName("android.widget.TextView");
		int count = 0;
    	
        for(MobileElement textItem : textItems) {
        	
	
           for (int i=0;i<Tasks.length;i++)
           {
        	  
        	   if(textItem.getText().equalsIgnoreCase(Tasks[i]))
        	   {
        		   count++;
        	   }
           }
        }
	
      
        Assert.assertEquals(count, Tasks.length);
        
        }
			
	
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
