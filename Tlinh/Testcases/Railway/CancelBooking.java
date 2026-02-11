package Railway;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.Constant;
import Constant.MenuItem;

public class CancelBooking extends TestBase{
	@Test
	public void TC16()
	{
		Account account=AccountHelper.createAndActivateAccount();
	//	Account account=new Account(Constant.USERNAME, Constant.PASSWORD);
		System.out.println("Step 1: Navigate to QA Railway Website");
		System.out.println("Step 2: Login with a valid account");

		HomePage homePage=new HomePage();
		LoginPage loginPage=(LoginPage) homePage.open().gotoPage(MenuItem.LOGIN);
		homePage=loginPage.login(account);
		
		System.out.println("Step 3: Book a ticket");
		BookTicketPage bookTicketPage=(BookTicketPage) loginPage.gotoPage(MenuItem.BOOKTICKET);
		
		Ticket ticket=new Ticket("Nha Trang","Huế","Soft bed with air conditioner","1");
		bookTicketPage.bookTicket(ticket, 2);
		
	
		System.out.println("Step 4: Click on My ticket tab");
		
		MyTicketPage myTicketPage= (MyTicketPage) bookTicketPage.gotoPage(MenuItem.MYTICKET);
		
		System.out.println("Step 5: Click on Cancel button of ticket which user want to cancel.");
		myTicketPage.getBtnCancel().click();
		
		System.out.println("Step 6: Click on OK button on Confirmation message Are you sure?");
		
		myTicketPage.clickOnAlert(true);
		
		boolean cancelStatus=myTicketPage.getBtnCancel().isDisplayed();
		Assert.assertFalse(cancelStatus);

	}
	

}
