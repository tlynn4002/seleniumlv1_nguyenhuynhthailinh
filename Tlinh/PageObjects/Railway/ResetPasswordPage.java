package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;

public class ResetPasswordPage extends GeneralPage{
	private final By txtNewPassword=By.xpath("//input[@id='newPassword']");
	private final By txtCfNewPassword=By.xpath("//input[@id='confirmPassword']");
	private final By txtResetToken=By.xpath("//input[@id='resetToken']");
	private final By btnResetPassword=By.xpath("//input[@title='Reset password']");
	//locator when reset is error
	private final By lblMsg=By.xpath("//div[contains(@id,'content')]/p");
	private final By errorPasswordMsg=By.xpath("//label[contains(@class,'validation-error')]");
	protected WebElement getTxtNewPassword()
	{
		return Utilities.waitForElementVisible(txtNewPassword);
	}
	protected WebElement getTxtCfNewPassword()
	{
		return Utilities.waitForElementVisible(txtCfNewPassword);
	}
	protected WebElement getTxtResetToken()
	{
		return Utilities.waitForElementVisible(txtResetToken);
	}
	protected WebElement getBtnResetPassword()
	{
		return Utilities.waitForElementClickable(btnResetPassword);
	}
	protected WebElement getLblMsg()
	{
		return Utilities.waitForElementVisible(lblMsg);
	}
	protected WebElement getErrorPasswordMsg()
	{
		return Utilities.waitForElementVisible(errorPasswordMsg);
	}
	public boolean isTxtResetTokenHasValue()
	{
		return Utilities.isTextboxHasValue(txtResetToken);
	}
	
	public void changePassword(String password, String cfPassword)
	{

		WebElement newPass = getTxtNewPassword();
		WebElement cfPass  = getTxtCfNewPassword();
		WebElement btn     = getBtnResetPassword();

		Utilities.scrollToElement(newPass);
		newPass.clear();
		newPass.sendKeys(password);

		Utilities.scrollToElement(cfPass);
		cfPass.clear();
		cfPass.sendKeys(cfPassword);

		Utilities.scrollToElement(btn);
		btn.click();
		
	}
}
