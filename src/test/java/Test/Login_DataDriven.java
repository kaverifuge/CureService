package Test;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.LoginPage;
import Utilities.ReadExceldata;
import Utilities.ReadUtilProperties;

public class Login_DataDriven extends BaseTest {
	
	public ReadExceldata rdata;
	public LoginPage lp;
	//public AptConfirmPage ap1;
	
	ReadUtilProperties rp ; 
	

	@Test
	public void LoginDatadriver() throws IOException, InterruptedException {
		

		clickMakeApp();
		
		rdata = new ReadExceldata();
		int rowcount = rdata.rowCount();
		
		 String[][] data = rdata.readData();

		lp = new LoginPage(driver);
		
		for (int row = 1 ; row <= rowcount  ; row++) {
		  
		 String username= data[row][0];
		 String password = data[row][1];

		// System.out.println();
		// System.out.println(username +"  "+password);
		 //int attempt = 8;
		// while(attempt<8)
		 //{
		 //try {
		lp.enterUsernamedatadriven(username);
		lp.enterPassworddatadriven(password);
		Thread.sleep(200);
		lp.clickLoginbtn();

		
		SoftAssert sa = new SoftAssert();
		 
		//System.out.println("value : "+lp.compareConfirmtxt1());
				
		if (lp.compareConfirmtxt1()==false)
		{
				sa.assertTrue(true);
		  		System.out.println("Login Pass : "+username+"  "+password);
		  		Thread.sleep(300);
		  		logoutbase();
		  		clickMakeApp(); 		         
		}
		else  {
			      System.out.println("Login FAIL : "+username+"  "+password);
			    
			      driver.navigate().refresh();
			   	  sa.assertTrue(false);

			       
			}
		  
		
	//	 }catch(StaleElementReferenceException e) {
			 
		//	 System.out.println("Stale Element Exception... Retrying");
		 //}
		  //attempt++;
		//}//while
		}//for loop
			
	}
	
	

}
