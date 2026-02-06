package Railway;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.Utilities;
import Constant.Constant;

public class HomePage extends GeneralPage {
	public HomePage open() 
	{
	
		Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
		return this;
	}

	public void openRailway() {
	    for (int i = 0; i < 3; i++) {
	        try {
	            Constant.WEBDRIVER.get(Constant.RAILWAY_URL);

	            WebDriverWait wait = new WebDriverWait(
	                Constant.WEBDRIVER, Duration.ofSeconds(5)
	            );

	            wait.until(ExpectedConditions.visibilityOfElementLocated(btnCreateAccount));
	            return; 

	        } catch (Exception e) {
	            // retry
	        }
	    }

	    throw new RuntimeException("Railway site is not available");
	}

	private final By btnCreateAccount= By.xpath("//a[normalize-space()='create an account']");
	
	protected WebElement getBtnCreateAccount() 
	{
		return Utilities.waitForElementClickable(btnCreateAccount, 3);
	}
	 public RegisterPage gotoRegisterPageByCreateAccount() {
	        WebElement btn = getBtnCreateAccount();

	        
	        ((JavascriptExecutor) Constant.WEBDRIVER)
	            .executeScript("arguments[0].scrollIntoView({block:'center'});", btn);

	        Utilities.sleep(1);

	        btn.click();

	        return new RegisterPage();
	    }
}
