package MobileTestProject;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class googleNote_Reminder_Activity3 {
	AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;
	
 @BeforeClass
	  public void beforeClass() throws MalformedURLException {
	 

	  DesiredCapabilities caps = new DesiredCapabilities();
 	
     caps.setCapability("deviceId", "d4b8ac43");
	
     caps.setCapability("deviceName", "Lenovo K6 POWER");
	
     caps.setCapability("platformName", "android");
	
     caps.setCapability("appPackage", "com.google.android.keep");
	
     caps.setCapability("appActivity", ".activities.BrowseActivity");
        
     caps.setCapability("noReset", true);
     
     caps.setCapability("adbExecTimeout", "20000");
     
  // Initialize driver
		
     URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
 	
     driver = new AndroidDriver<MobileElement>(appServer, caps);
	
     wait = new WebDriverWait(driver, 100);
     
	  }
	
  @Test
  public void googleNoteAct2() {
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("new_note_button").click();
		driver.findElementById("editable_title").sendKeys("Note Title");
		driver.findElementById("edit_note_text").sendKeys("Note Description Details"); 	
		
		//Add Reminder
		driver.findElementById("com.google.android.keep:id/menu_switch_to_grid_view").click();
		driver.findElementById("save").click();
		driver.findElementByXPath("	\r\n" + 
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.TextView[1]").click();
		
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[2]").click();
		
		//Save the Reminder
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();
		
		
		//Navigate to the Reminder Page
		
		driver.findElementById("com.google.android.keep:id/drawer_navigation_reminders").click();
		
		
		String title = driver.findElementById("com.google.android.keep:id/index_note_title").getText();
		String desc = driver.findElementById("com.google.android.keep:id/index_note_text_description").getText();
		String reminder = driver.findElementById("com.google.android.keep:id/reminder_chip_text").getText();
		
		int count = 0;
		if(title.equalsIgnoreCase("Note Title") && desc.equalsIgnoreCase("Note Description Details") && reminder.equalsIgnoreCase("Today,18:00"))
		{
			count=1;
		}
		
		Assert.assertEquals(1, count);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
