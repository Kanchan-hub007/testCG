package functionDef;

import static org.junit.Assert.assertEquals;
import functionDef.*;
import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class LoginAction {
	static WebDriver driver=null;

	@Given("^Open the Browser \"([^\"]*)\"$")
	public void OpentheBrowser(String BrowserName) {
		System.out.println(System.getProperty("user.dir"));
		if (BrowserName.equals("Chrome")) { 
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
		}
		else if (BrowserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
		}
		if (BrowserName.equals("Chrome")) {

			ChromeOptions co= new ChromeOptions();
			co.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
			Map<String, Object> mango = new HashMap<String, Object>();
			mango.put("credentials_enable_service", false);
			mango.put("profile.password_manager_enabled", false);

			co.setExperimentalOption("prefs", mango);


			driver = new ChromeDriver(co); //capabilities
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}

		else if (BrowserName.equals("Firefox")) {
			driver = new FirefoxDriver();	
		}

		//			driver.get(url);		

	}
	@When("^User enter URL \"([^\"]*)\"$")
	public void Opentheurl(String url) {
		driver.get(url);

	}

	@Then("^//*[@id=\"header_logo\"]$")
	public void displayedText() {

	}
	@And("^Free CRM helps any business large or small$")
	public void displayedText1() {

	}

	@Given("^Homepage is already displayed$")
	public void homepageDisplayed() throws InterruptedException {

	}

	@When("^User enter userName password \"([^\"]*)\" in \"([^\"]*)\"$")
	public void Login(String UserName,String password) throws InterruptedException {
		Thread.sleep(50);
		WebElement obj = driver.findElement(By.className("login"));
		obj.click();

		driver.findElement(By.name("email_create")).clear();
		driver.findElement(By.name("email_create")).sendKeys(UserName);
//		driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(50);
		WebElement obj1 = driver.findElement(By.id("SubmitCreate"));
//		WebElement obj = driver.findElement(By.cssSelector(".fluid"));
		obj1.click();
		Thread.sleep(50);
		WebElement element = driver.findElement(By.id("uniform-id_gender2"));
//        Select select=new Select(element);
//        select.by
		element.click();
		driver.findElement(By.name("customer_firstname")).sendKeys("Kanchan");
		driver.findElement(By.name("customer_lastname")).sendKeys("Kumari");
		driver.findElement(By.name("passwd")).sendKeys("newuser@123");
		driver.findElement(By.name("firstname")).sendKeys("Kanchan");
		driver.findElement(By.name("lastname")).sendKeys("Kumari");
		Thread.sleep(50);
		driver.findElement(By.id("address1")).sendKeys("Karnataka");
		driver.findElement(By.id("city")).sendKeys("Bangalore");
		WebElement element1 = driver.findElement(By.id("id_state"));
		element1.click();
		Thread.sleep(10);
		Select select=new Select(element1);
        select.selectByIndex(5);
        Thread.sleep(50);
        driver.findElement(By.name("postcode")).sendKeys("12345");
        driver.findElement(By.name("phone_mobile")).sendKeys("8884117512");
        driver.findElement(By.name("submitAccount")).click();
        
	}

	
	@When("^Click on Login Button$")
	public void clickLogin() throws InterruptedException {
		Thread.sleep(50);
		WebElement obj = driver.findElement(By.id("SubmitCreate"));
//		WebElement obj = driver.findElement(By.cssSelector(".fluid"));
		obj.click();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	@Then("^User Logged in Successfully should be displayed$")
	public void userLogged() {

		Object expectedResult = null;
		String result = null;
		result=driver.findElement(By.className("header_user_info")).getText();
		System.out.println("the debug analyser: "+result);
		assertEquals(expectedResult, result);
	}
	@Then("^Homepage should be displayed$")
	public void userLoggedagain() {

		Object expectedResult = "Kanchan Kumari";
		String result = null;
		result=driver.findElement(By.linkText("Kanchan Kumari")).getText();
		System.out.println("the debug analyser: "+result);
//		assertEquals(expectedResult, result);
	}

	@Given("^Click on Signout and resignIn$")
	public void Loginagain(String UserName,String password) throws InterruptedException {
		Thread.sleep(50);
		WebElement obj = driver.findElement(By.linkText("Sign out"));
		obj.click();
		Thread.sleep(50);
		driver.findElement(By.id("search_query_top")).click();
		driver.findElement(By.name("submit_search")).click();
		Thread.sleep(50);
		driver.findElement(By.id("search_query")).sendKeys("Skirt");
		Thread.sleep(50);
		driver.findElement(By.name("submit_search")).click();
		
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.className("Women"));
		action.moveToElement(element).perform();
		driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li/a")).click();
	
		
	}
	
}


