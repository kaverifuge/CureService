package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	public WebDriver driver;
	
	public BasePage(WebDriver driver) {
		
		this.driver = driver;
		//System.out.println("Basepage1");
		PageFactory.initElements(driver, this);
		//System.out.println("Basepage2");

	}

}
