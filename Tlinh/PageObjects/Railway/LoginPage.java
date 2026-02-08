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
    //Locators for when forgetPassword//
    private final By forgetPasswordLink=By.xpath("//a[@href='/Account/ForgotPassword.cshtml']");
    private final By btnSendInstruction=By.xpath("//input[@value='Send Instructions']");
    private final By txtEmail=By.xpath("//input[@id='email']");
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

    public String getLblLoginErrorMsg()
    {
    	return Utilities.waitForElementClickable(lblLoginErrorMsg, 3).getText();
    }
    public WebElement getForgetPasswordLink()
    {
    	return Utilities.waitForElementClickable(forgetPasswordLink);
    }
    public WebElement getBtnSendInstruction()
    {
    	return Utilities.waitForElementClickable(btnSendInstruction,8);
    	
    }
    public WebElement getTxtEmail()
    {
    	return Utilities.waitForElementClickable(txtEmail);
    }
   
    //Methods
    public HomePage login(Account account) {
    	//Submit login credentials
    	this.getTxtUsername().clear();
    	this.getTxtPassword().clear();
    	this.getTxtUsername().sendKeys(account.getEmail());
    	this.getTxtPassword().sendKeys(account.getPassword());
    	this.getBtnLogin().click();
    	
    	//Land on Home Page
    	return new HomePage();
    }
    public void forgetPassword(Account account)
    {
    	this.getForgetPasswordLink().click();
    	this.getTxtEmail().clear();
    	this.getTxtEmail().sendKeys(account.getEmail());
    	Utilities.scrollToElement(getBtnSendInstruction());
    	this.getBtnSendInstruction().click();
    }
    
}