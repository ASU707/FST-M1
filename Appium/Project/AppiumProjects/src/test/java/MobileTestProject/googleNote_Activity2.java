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

public class googleNote_Activity2 {
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
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();
		
		String title = driver.findElementById("com.google.android.keep:id/index_note_title").getText();
		String desc = driver.findElementById("com.google.android.keep:id/index_note_text_description").getText();
		
		int count = 0;
		if(title.equalsIgnoreCase("Note Title") && desc.equalsIgnoreCase("Note Description Details"))
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
