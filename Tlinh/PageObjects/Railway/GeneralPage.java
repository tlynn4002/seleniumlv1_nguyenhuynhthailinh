package Railway;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;
import Constant.MenuItem;


public class GeneralPage {
	private final By tabLogin= By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
	private final By tabLogout=By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
	private final By tabHome=By.xpath("//span[normalize-space()='Home']");
	private final By lblWelcomeMessage=By.xpath("//div[@class='account']//child::strong");//
	//private final By lblWelcomeMessage=By.xpath("//div[@id='content']//child::h1");
	private final By tabFAQ=By.xpath("//a[@href='/Page/FAQ.cshtml']");
	private final By tabRegister=By.xpath("//span[normalize-space()='Register']");
	private final By btnCreateAccount= By.xpath("//a[normalize-space()='create an account']");
	private final By tabBookTicket=By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
	protected WebElement getTabLogin()
	{
		return Utilities.waitForElementClickable(tabLogin);
	}
	
	protected WebElement getTabLogout()
	{
		return Utilities.waitForElementClickable(tabLogout);
	}
	
	protected WebElement getlblWelcomeMessage()
	{
		return Utilities.waitForElementClickable(lblWelcomeMessage);
	}
	
	protected String getWelcomeMessage()
	{
		return this.getlblWelcomeMessage().getText();
	}
	protected WebElement getTabFAQ()
	{
		return Utilities.waitForElementClickable(tabFAQ);
	}
	
	public boolean isLogoutTabInvisible() {
	    return Utilities.waitForElementInvisible(tabLogout);
	}
	
	protected WebElement getTabRegister()
	{
		return Utilities.waitForElementClickable(tabRegister);
	}
	protected WebElement getTabBookTicket()
	{
		return Utilities.waitForElementClickable(tabBookTicket);
	}
	public LoginPage gotoLoginPage()
	{
		this.getTabLogin().click();
		return new LoginPage();
	}
	public RegisterPage gotoRegisterPage()
	{
		this.getTabRegister().click();
		return new RegisterPage();
	}
	
	protected WebElement getBtnCreateAccount() 
	{
		return Utilities.waitForElementClickable(btnCreateAccount);
	}
	
	public GeneralPage gotoPage(MenuItem menuItem) {
	    switch (menuItem) {
	        case HOME:
	            Utilities.click(tabHome, 2);
	            return new HomePage();

	        case FAQ:
	            Utilities.click(tabFAQ, 2);
	            return new FAQPage();

	        case REGISTER:
	            Utilities.click(tabRegister, 2);
	            return new RegisterPage();

	        case LOGIN:
	            Utilities.click(tabLogin, 2);
	            return new LoginPage();

	        case LOGOUT:
	            Utilities.click(tabLogout, 2);
	            return new HomePage();
	        case BOOKTICKET:
	        	Utilities.click(tabBookTicket, 2);
	        	return new BookTicketPage();
	        default:
	            throw new IllegalArgumentException(
	                "There is no " + menuItem
	            );
	    }
	}


	
	
	
}
