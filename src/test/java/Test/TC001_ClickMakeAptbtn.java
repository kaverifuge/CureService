package Test;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_ClickMakeAptbtn extends BaseTest{
	
	@Test
	public void verifyClickMakeAppbtnWorks() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	        clickMakeApp();
	         
	        
	        String title = "CURA Healthcare Service";
	        
	        String actualTitle = driver.getTitle();
	        
	       // System.out.println(title +"  "+actualTitle);
	        if(actualTitle.equals(title)) {
	        	
	        	Assert.assertTrue(true);
	        	System.out.println ("TC001_PASS") ;
					
				}
	        else {
	        	
	        	System.out.println ("TC001_FAIL");
	        	Assert.assertTrue(false);
	        }
	        
	        
	}
}
