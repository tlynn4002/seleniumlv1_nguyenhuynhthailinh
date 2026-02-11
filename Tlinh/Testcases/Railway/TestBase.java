
package Railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Common.Utilities;
import Constant.Constant;

public class TestBase {
	
	@Parameters({"browser", "url"})
	@BeforeMethod
    public void beforeMethod(@Optional("chrome") String browser, @Optional("http://railway.somee.com") String url) {
		
		switch (browser.toLowerCase()) {
        case "chrome":
        	Constant.WEBDRIVER = new ChromeDriver();
            System.out.println("ChromeDriver initialized");
            break;

        case "firefox":
        	Constant.WEBDRIVER = new FirefoxDriver();
            System.out.println("FirefoxDriver initialized");
            break;

        default:
            System.out.println("Browser " + browser + " is not valid. Using Chrome as default.");
            Constant.WEBDRIVER = new ChromeDriver();
		}
		Utilities.setDriver(Constant.WEBDRIVER);
        Constant.WEBDRIVER.manage().window().maximize();
    }
	 	//Utilities.setDriver(Constant.WEBDRIVER);
	    @AfterMethod
	    public void afterMethod() {
	        System.out.println("Post-condition");

	        Constant.WEBDRIVER.quit();
	    }

}
