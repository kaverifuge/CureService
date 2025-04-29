package Pages;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.ReadUtilProperties;

public class LoginPage extends BasePage{

	public ReadUtilProperties rdp = new ReadUtilProperties();
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	//Elements
	
	@FindBy(css="input#txt-username")
	WebElement txtusername;
	
	@FindBy(css="input#txt-password")
	WebElement txtpassword;
	
	@FindBy(css="button#btn-login")
	WebElement btnLogin;
	
	@FindBy(xpath="//p[text()='Login failed! Please ensure the username and password are valid.']")
	WebElement txtloginfail;
	
	
	//Methods
	
	public void enterUsername() throws IOException {
		
		
		txtusername.sendKeys(rdp.readUsername());
		
	}
	
	public void enterPassword() throws IOException {
		
		txtpassword.sendKeys(rdp.readPassword());
		
	}
	
	public void clickLoginbtn() throws IOException {
		
		btnLogin.click();
		
	}
	
	public void enterUsernamedatadriven(String username) throws IOException, InterruptedException {

		txtusername.sendKeys(username);		
	}
	
	public void enterPassworddatadriven(String password) throws IOException {
		
		txtpassword.sendKeys(password);
		
	}
	
	public void clrtxtUsernamedatadriven() throws IOException {
		
		txtusername.clear();
		
	}
	
	public void clrtxtPassworddatadriven() throws IOException {
		
		txtpassword.clear();
		
	}
	
	public boolean compareConfirmtxt1() {
		
	//	System.out.println("22");
		String txt = "";
		try {
		 txt = txtloginfail.getText();
		}
		catch(NoSuchElementException e) {
			 txt = "";
		}
	//	System.out.println(txt);
		
		//if("Login failed! Please ensure the username and password are valid".equals(txt)) {
		if(!"".equals(txt)) {
				return true;
		}
		else {
				return false;
		}
		
		
	}
	

	
}
