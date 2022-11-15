package stepDefinitions;


import java.awt.List;
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


public class CRM_Class2 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^user logged in to CRM with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_login_to_CRM_with_and(String username, String password) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUSMITAKUNDU\\Desktop\\Selenium_Required\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver ();
		
		wait = new WebDriverWait(driver, 20);
		driver.get("https://alchemy.hguy.co/crm/");
		driver.manage().window().maximize();
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("username_password")).sendKeys(password);
		driver.findElement(By.id("bigbutton")).click();
	}
	@Given("^user naviagte to create lead page$")
	public void user_naviagte_to_create_lead_page() throws Throwable {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Actions mousehover = new Actions(driver);
		mousehover.moveToElement(driver.findElement(By.xpath(".//*[@id=\"toolbar\"]/ul/li[2]"))).build().perform();
		driver.findElement(By.xpath(".//*[@id=\"moduleTab_9_Leads\"]")).click();
		driver.findElement(By.xpath(".//*[@id=\"actionMenuSidebar\"]/ul/li[1]/a")).click();
	}
	@When("^Add details with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void add_details_with_and(String FirstName, String LastName) throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id=\"salutation\"]")));
		dropdown.selectByIndex(1);
		driver.findElement(By.xpath(".//*[@id=\"first_name\"]")).sendKeys(FirstName);
		driver.findElement(By.xpath(".//*[@id=\"last_name\"]")).sendKeys(LastName);
		driver.findElement(By.xpath(".//*[@id=\"SAVE\"]")).click();
	}
	@Then("^verify details are added successfully$")
	public void verify_details_are_added_successfully() throws Throwable {
		driver.findElement(By.xpath(".//*[@id=\"actionMenuSidebar\"]/ul/li[3]/a/div[2]")).click();
		String name = driver.findElement(By.xpath("//*[@id=\"MassUpdate\"]/div[3]/table/tbody/tr[1]/td[3]")).getText();
		System.out.println(name);
	}
	@Then("^Close the Browser$")
	public void browse_close() throws Throwable {
		driver.close();
	}
}


