package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AptConfirmPage;
import Pages.MakeAptPage;

public class TC003_BookApt extends BaseTest{
	
	public MakeAptPage mp;
	public AptConfirmPage ac;
	
	@Test
	public void bookAppointment() throws IOException, InterruptedException {
		
		clickMakeApp();
		login();
		
		mp = new MakeAptPage(driver);
		mp.selectFacility();
		mp.selectMedicaid();
		mp.pickDate();
		mp.enterComment();
		mp.clickBookAptbtn();
		
		ac = new AptConfirmPage(driver);
		
		if(ac.compareConfirmtxt()==true) {
			
			Assert.assertTrue(true);
			
			System.out.println("TC003_BookApt_PASS");
		}
		else {
			
			
			System.out.println("TC003_BookApt_FAIL");
			Assert.assertTrue(false);
		}
		
	}

}
