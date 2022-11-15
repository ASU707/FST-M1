package stepDefinitions;



import java.awt.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class CRM_Class3 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^Login page with \"([^\"])\" and \"([^\"])\"$")
	public void user_is_on_Login_page_with_and(String username, String password) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUSMITAKUNDU\\Desktop\\Selenium_Required\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver ();
		
		wait = new WebDriverWait(driver, 20);
		driver.get("https://alchemy.hguy.co/crm/");
		driver.manage().window().maximize();
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("username_password")).sendKeys(password);
		driver.findElement(By.id("bigbutton")).click();
	}
	@When("^meeting is scheduled$")
	public void meeting_is_scheduled() throws Throwable {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Actions mousehover = new Actions(driver);
		mousehover.moveToElement(driver.findElement(By.xpath(".//*[@id=\"toolbar\"]/ul/li[5]"))).build().perform();
		driver.findElement(By.xpath(".//*[@id=\"moduleTab_9_Meetings\"]")).click();
		driver.findElement(By.xpath(".//*[@id=\"actionMenuSidebar\"]/ul/li[1]/a/div[2]")).click();
	}
	@When("^Members are added with \"([^\"])\" \"([^\"])\"$")
	public void members_are_added_with(String firstname, String lastname) throws Throwable {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id=\"name\"]")).sendKeys("1234");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		driver.findElement(By.xpath(".//*[@id=\"search_first_name\"]")).sendKeys(firstname);
		driver.findElement(By.xpath(".//*[@id=\"search_last_name\"]")).sendKeys(lastname);
		driver.findElement(By.xpath(".//*[@id=\"invitees_search\"]")).click();
		driver.findElement(By.xpath(".//*[@id=\"invitees_add_1\"]")).click();
		Actions action = new Actions(driver);
		action.keyDown(Keys.ALT).sendKeys(String.valueOf('\u0041')).perform();
	}
	@Then("^verify meeting created successfully$")
	public void verify_meeting_is_created_successfully() throws Throwable {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id=\"actionMenuSidebar\"]/ul/li[2]/a/div[2]")).click();
		String meeting= driver.findElement(By.xpath("//*[@id=\"tab-content-0\"]/div[1]/div[1]/div[2]")).getText();
		System.out.println(meeting);
	}
	@Then("^close The browser$")
	public void close_The_browser() throws Throwable {
		driver.close();
	}
}