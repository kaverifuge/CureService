package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC004_Logout extends BaseTest{

	
	
	
	@Test
	public void Logout() throws IOException {
		
		clickMakeApp();
		login();
		logoutbase();
		
		if(driver.getTitle().equals("CURA Healthcare Service11")) {
			
			Assert.assertTrue(true);
			System.out.println("TC004_Logout_PASS");
		}else {
			
			
			System.out.println("TC004_Logout_FAIL");
			Assert.assertTrue(false);
		}
	}
}
