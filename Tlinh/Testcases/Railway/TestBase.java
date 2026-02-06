package Railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Common.Utilities;
import Constant.Constant;

public class TestBase {
	
	 	@BeforeMethod
	    public void beforeMethod() {
	        System.out.println("Pre-condition");

	       

	        Constant.WEBDRIVER = new ChromeDriver();
	        Constant.WEBDRIVER.manage().window().maximize();
	        
	        Utilities.setDriver(Constant.WEBDRIVER);
	    }

	    @AfterMethod
	    public void afterMethod() {
	        System.out.println("Post-condition");

	        Constant.WEBDRIVER.quit();
	    }

}
