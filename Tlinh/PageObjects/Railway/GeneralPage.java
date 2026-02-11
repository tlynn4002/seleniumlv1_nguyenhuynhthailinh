package Railway;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.CaseFormat;

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
	private final By tabTimeTable=By.xpath("//a[@href='TrainTimeListPage.cshtml']");
	private final By tabMyTicket=By.xpath("//a[@href='/Page/ManageTicket.cshtml']");
	
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
	
	protected WebElement getBtnCreateAccount() 
	{
		return Utilities.waitForElementClickable(btnCreateAccount);
	}
	
	protected WebElement getTabMyTicket()
	{
		return Utilities.waitForElementClickable(tabMyTicket);
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
	

	public GeneralPage gotoPage(MenuItem menuItem) {
	    switch (menuItem) {
	        case HOME:
	            Utilities.click(tabHome);
	            return new HomePage();

	        case FAQ:
	            Utilities.click(tabFAQ);
	            return new FAQPage();

	        case REGISTER:
	            Utilities.click(tabRegister);
	            return new RegisterPage();

	        case LOGIN:
	            Utilities.click(tabLogin);
	            return new LoginPage();

	        case LOGOUT:
	            Utilities.click(tabLogout);
	            return new HomePage();
	        case BOOKTICKET:
	        	Utilities.click(tabBookTicket);
	        	return new BookTicketPage();
	        case TIMETABLE:
	        	Utilities.click(tabTimeTable);
	        	return new TimeTablePage();
	        case MYTICKET:
	        	Utilities.click(tabMyTicket);
	        	return new MyTicketPage();
	        default:
	            throw new IllegalArgumentException(
	                "There is no " + menuItem
	            );
	    }
	}


	
	
	
}
