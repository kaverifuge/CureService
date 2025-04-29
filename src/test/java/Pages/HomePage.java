package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	//Constructor
	
	public HomePage(WebDriver driver) {
		
	   super(driver);
	}
	
	
	//Elements
	
	@FindBy(id="btn-make-appointment")
	WebElement btnMakeAppointment;
	
	@FindBy(css="a#menu-toggle")
	WebElement btndrawer;
	
	//Methods
	
	public void clickMakeAppbtn() {
		
		btnMakeAppointment.click();
	}
	
	public void clickDrawerOption() {
		btndrawer.click();
		
	}

}

      
