package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_Login extends BaseTest{
	
	 @Test
	 public void verifyLogin() throws IOException {
		 
		 clickMakeApp();
		 login();
		 
		 if(driver.getTitle().equals("CURA Healthcare Service")) {
			 
			 Assert.assertTrue(true);
			 System.out.println("TC002_Login_PASS");
		 }else
		 {
			 Assert.assertTrue(false);
			 System.out.println("TC002_Login_FAIL");
			 
		 }
		 
	 }

}
