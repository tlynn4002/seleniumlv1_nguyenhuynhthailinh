package Railway;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;


public class LoginPage extends GeneralPage {
	// Locators
    private final By txtUsername = By.xpath("//input[@id='username']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By btnLogin = By.xpath("//input[@value='login']");
    private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
   

    // Elements
    public WebElement getTxtUsername() {
        return Utilities.waitForElementClickable(txtUsername, 3);
    }

    public WebElement getTxtPassword() {
        return Utilities.waitForElementClickable(txtPassword, 3);
    }

    public WebElement getBtnLogin() {
    	return Utilities.waitForElementClickable(btnLogin, 3);
    }

    public String getLblLoginErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblLoginErrorMsg).getText();
    }
    
   
    //Methods
    public HomePage login(String username, String password) {
    	//Submit login credentials
    	this.getTxtUsername().clear();
    	this.getTxtPassword().clear();
    	this.getTxtUsername().sendKeys(username);
    	this.getTxtPassword().sendKeys(password);
    	this.getBtnLogin().click();
    	
    	//Land on Home Page
    	return new HomePage();
    }
    
    
}