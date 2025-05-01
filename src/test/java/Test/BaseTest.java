package Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Pages.AptConfirmPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MakeAptPage;
import Utilities.ReadUtilProperties;

public class BaseTest {
	
	public WebDriver driver;
	public MakeAptPage ap ;
	ReadUtilProperties rp ; 
	public AptConfirmPage acp;
	public String screenshotname="";
	
	@BeforeClass
	@Parameters("browser")
	public void setupBroswer(String browser) throws IOException {
		 
		switch(browser) {

		case("edge") : driver = new EdgeDriver();break;
		case("chrome") : // Create preferences map
		                   Map<String, Object> prefs = new HashMap<>();
                           prefs.put("credentials_enable_service", false);
					       prefs.put("profile.password_manager_enabled", false);
					       
					    // Setup ChromeOptions
					       ChromeOptions options = new ChromeOptions();
					       options.setExperimentalOption("prefs", prefs);
					       
					    // Add incognito mode and disable automation infobar
					        options.addArguments("--incognito");
					        options.addArguments("--disable-save-password-bubble");
					        options.addArguments("--disable-infobars");
					        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
					       
				           driver = new ChromeDriver(options);
		                   break;
		default : System.out.println("Invalid browser");return;		
		}
		//driver = new EdgeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		rp = new ReadUtilProperties();
		driver.get( rp.readURL());
		
		
	}
	
	
	public void clickMakeApp() {
		
		HomePage hp = new HomePage(driver);
		hp.clickMakeAppbtn();
		//System.out.println("Make Appointment click Success");
		
	}
	
	public void login() throws IOException {
		 
		
		 
		 LoginPage lp = new LoginPage(driver);
		 
		 lp.enterUsername();
		 lp.enterPassword();
		 lp.clickLoginbtn();
		// System.out.println("LoginSuccess");
	 }
	
	public void logoutbase() {
		
		ap = new MakeAptPage(driver);
		ap.clickDrawerOption();
		ap.clickLogout();
		
	}
	
	
	
	public WebDriver getDriver() {
	    return driver;
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		
		//Thread.sleep(800);
		driver.quit();
	}

}
