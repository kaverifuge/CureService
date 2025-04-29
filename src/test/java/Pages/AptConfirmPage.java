package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AptConfirmPage extends BasePage{

	public AptConfirmPage(WebDriver driver) {
		super(driver);
		//System.out.println("2");
		// TODO Auto-generated constructor stub
	}
	
	
	//Elements
	
	//h2[text()='Make Appointment']
	
	@FindBy(xpath="//h2[text()='Appointment Confirmation']")
	WebElement txtAptConfirm;
	
	@FindBy(xpath="//a[text()='Go to Homepage']")
	WebElement btnBackToHome;
	
	
	
	//Methods
	
	public boolean compareConfirmtxt() throws InterruptedException {
		//System.out.println("111");
		Thread.sleep(400);
		String txt = txtAptConfirm.getText();
		//System.out.println(txt);
		
		if("Appointment Confirmation".equals(txt)) {
			
				return true;
		}
		else {
				return false;
		}
		
		
	}
	
	
	public void clickBackToHomebtn() {
		
		btnBackToHome.click();
	}

}
