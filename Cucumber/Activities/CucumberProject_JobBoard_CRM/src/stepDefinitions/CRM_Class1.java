package stepDefinitions;

import java.awt.List;
import java.util.Iterator;
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

public class CRM_Class1 {
	
	WebDriver driver;
	WebDriverWait wait;

	
	@Given("^Log in to crm with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_logged_in_to_crm_with_and(String username, String password) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUSMITAKUNDU\\Desktop\\Selenium_Required\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver ();
		
		wait = new WebDriverWait(driver, 10);
		driver.get("https://alchemy.hguy.co/crm/");
		driver.manage().window().maximize();
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("username_password")).sendKeys(password);
		driver.findElement(By.id("bigbutton")).click();
	}
	@When("^count the number of dashlets$")
	public void count_the_number_of_dashlets() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 java.util.List<WebElement> dashlet = driver.findElements(By.xpath(".//html/body/div[3]/div/div/div[1]/div[2]/div/div[2]/div/table/tbody/tr/td/ul/li[contains(@id,'dashlet_')]"));
		int dashletsize = dashlet.size();
		System.out.println("Number of dashlet in the screen:" + dashletsize);
		Iterator<WebElement> itr = dashlet.iterator();
		while (itr.hasNext()) {
			WebElement dashletTitleElement = itr.next().findElement(By.xpath(".//td[@class='dashlet-title']/h3"));
			String dashletTitle = dashletTitleElement.getText();
			System.out.println(dashletTitle);
		}
	}
	@Then("^print the number of title and dashlets$")
	public void print_the_number_of_title_and_dashlets() throws Throwable {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		java.util.List<WebElement> dashlet = driver.findElements(By.xpath(".//html/body/div[3]/div/div/div[1]/div[2]/div/div[2]/div/table/tbody/tr/td/ul/li[contains(@id,'dashlet_')]"));
		int dashletsize = dashlet.size();
		System.out.println("Number of dashlet in the screen:" + dashletsize);
		Iterator<WebElement> itr = dashlet.iterator();
		while (itr.hasNext()) {
			WebElement dashletTitleElement = itr.next().findElement(By.xpath(".//td[@class='dashlet-title']/h3"));
			String dashletTitle = dashletTitleElement.getText();
			System.out.println(dashletTitle);
			}
	}
	@Then("^close browser$")
	public void browse_close() throws Throwable {
		driver.close();
	}


}
