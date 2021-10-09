package StepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	
	WebDriver driver;
	int value;

	@Given ("^user loads the application$")
	
	public void user_loads_the_application() throws IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		driver =new ChromeDriver();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		Properties prop= new Properties();
		prop.load(fis);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("produrl"));
	}
	
	@When("^title of page is Welcome$")
	public void title_of_page_is_welcome() {
	    // Write code here that turns the phrase above into concrete actions
	    String title = driver.getTitle();
	    Assert.assertEquals(title, "Welcome");
	}
	
	@When("^name of tea is ([^\\\"]*)$")
	public void name_of_tea_is_Loose_Tea(String tea) {
		By teaname = By.xpath("//span[@class='editor_collections']");
		
		List<WebElement> teanames = driver.findElements(teaname);
		
		for (int i=0; i<teanames.size(); i++) {
			if (teanames.get(i).getText().equals(tea)){
				value=i;
			}
		}
	}
	
	@Then("^user clicks on See Collection$")
	public void user_clicks_on_See_Collections() {
		By addbuttons = By.xpath("//span[text()='See Collection']");
		List<WebElement> addbuttonslist = driver.findElements(addbuttons);
		addbuttonslist.get(value).click();
	}
	
	@Then("^Menu page is displayed$")
	public void Menu_page_is_displayed() {
		Assert.assertEquals(driver.getTitle(), "Menu");
	}
	
	@Then("^Close the browser$")
	public void close_the_browser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
	
		
	
}
