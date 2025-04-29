package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MakeAptPage extends BasePage{

	public MakeAptPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	
	//Elements
	
	@FindBy(css="select#combo_facility")
	WebElement dropfacility;
	
	@FindBy(css="input#radio_program_medicaid")
	WebElement radioHealthcarePgm;
	
	@FindBy(css ="input#txt_visit_date")
	WebElement dateDate;
	
	
	
	//@FindBy(xpath="//div[@class='datepicker-days']//tr[2]//td[7]")
	//WebElement dateDate;
	
	@FindBy(css="textarea#txt_comment")
	WebElement txtComment;
	
	 @FindBy(css="button#btn-book-appointment")
	 WebElement btnBookApt;
	 
	 @FindBy(xpath="//a[text()='Logout']")
	 WebElement btnLogout;
	 
	 @FindBy(css="a#menu-toggle")
		WebElement btndrawer;
	 
	 //Methods
	 
	 public void selectFacility() {
		 
		 Select sel = new Select(dropfacility);
		 sel.selectByVisibleText("Hongkong CURA Healthcare Center");
	 }
	 
	 public void selectMedicaid() {
		 
		 radioHealthcarePgm.click();
	 }
	 
	 public void pickDate() {
		 dateDate.sendKeys("29/04/2025");
		 
	 }
	 public void enterComment() {
		 
		 txtComment.sendKeys("New Patient Registeration");
	 }
	 
	 public void clickBookAptbtn() {
		 
		 btnBookApt.click();
	 }
	 
	 public void clickDrawerOption () {
			btndrawer.click();
			
		}
	 
	 public void clickLogout () {
		 btnLogout.click();
			
		}
	 
}
