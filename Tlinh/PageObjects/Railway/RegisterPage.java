package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;

public class RegisterPage extends GeneralPage{
	private final By txtEmail = By.xpath("//input[@id='email']");
	private final By txtPassword=By.xpath("//input[@id='password']");
	private final By txtConfirmPassword=By.xpath("//input[@id='confirmPassword']");
	private final By txtPID=By.xpath("//input[@id='pid']");
	private final By btnRegister=By.xpath("//input[@title='Register']");
	private final By lblErrorMsg=By.xpath("//p[@class='message error']");
	private final By lblPasswordErrorMsg=By.xpath("//label[normalize-space()='Invalid password length']");
	private final By lblPIDErrorMsg=By.xpath("//label[normalize-space()='Invalid ID length']");
	private final By successfulActivateMsg=By.xpath("//div[@id='content']/p");
	
	protected WebElement getTxtEmail()
	{
		return Utilities.waitForElementClickable(txtEmail, 3);
	}
	
	protected WebElement getTxtPassword()
	{
		return Utilities.waitForElementClickable(txtPassword, 3);
	}
	
	protected WebElement getConfirmPassword()
	{
		return Utilities.waitForElementClickable(txtConfirmPassword, 3);
	}
	
	protected WebElement getTxtPID()
	{
		return Utilities.waitForElementClickable(txtPID, 3);
	}
	
	protected WebElement getBtnRegister()
	{
		return Utilities.waitForElementClickable(btnRegister, 3);
	}
	protected WebElement getLblErrorMsg()
	{
		return Utilities.waitForElementClickable(lblErrorMsg, 3);
	}
	
	protected WebElement getLblPasswordErrorMsg()
	{
		return Utilities.waitForElementClickable(lblPasswordErrorMsg, 3);
	}
	protected String getPasswordErrorMsg()
	{
		return this.getLblPasswordErrorMsg().getText();
	}
	
	protected WebElement getLblPIDErrorMsg()
	{
		return Utilities.waitForElementClickable(lblPIDErrorMsg, 3);
	}
	protected WebElement getSuccessfulActivate()
	{
		return Utilities.waitForElementClickable(successfulActivateMsg);
	}
	public RegisterPage register(Account account) {
    	//Submit login credentials
    	this.getTxtEmail().clear();
    	this.getTxtPassword().clear();
    	this.getConfirmPassword().clear();
    	this.getTxtPID().clear();
    	this.getTxtEmail().sendKeys(account.getEmail());
    	this.getTxtPassword().sendKeys(account.getPassword());
    	this.getConfirmPassword().sendKeys(account.getPassword());
    	this.getTxtPID().sendKeys(account.getPid());
    	this.getBtnRegister().click();
    	
    	
    	return new RegisterPage();
    }
}

