package Railway;

import java.lang.invoke.ConstantBootstraps;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.Constant;
import Constant.MenuItem;

public class BookTicket extends TestBase {
	@Test
	public void TC12()
	{
		//Pre-condition: create an active account//
//		Account account=AccountHelper.createAndActivateAccount();
		Account account=new Account(Constant.USERNAME, Constant.PASSWORD);
		System.out.println("Step 1: Navigate to QA Railway Website");
		System.out.println("Step 2: Login with a valid account");
		
		HomePage homePage=new HomePage();
		LoginPage loginPage=(LoginPage) homePage.open().gotoPage(MenuItem.LOGIN);
		loginPage.login(account);
		
		System.out.println("Step 3: Click on Book ticket tab");
		loginPage.gotoPage(MenuItem.BOOKTICKET);
		
		Ticket ticket=new Ticket("Nha Trang","Huế","Soft bed with air conditioner","1");
		
		System.out.println("Step 4: Select the next 2 days from Depart date");
		System.out.println("Step 5: Select Depart from Nha Trang and Arrive at Huế ");
		System.out.println("Step 6: Select Soft bed with air conditioner for Seat type");
		System.out.println("Step 7: Select 1 for Ticket amount");
		System.out.println("Step 8: Click on Book ticket button");
		
		BookTicketPage bookTicketPage=new BookTicketPage();
		
		String defaultDate = bookTicketPage.getDefaultDepartDate();
		String expectedDate = bookTicketPage.addDays(defaultDate, 2);

		bookTicketPage.bookTicket(ticket, 2);
		bookTicketPage.checkInfor(ticket, expectedDate);
		
	}
	
	@Test
	public void TC13()
	{
		//Pre-condition: create an active account//
//		Account account=AccountHelper.createAndActivateAccount();
		Account account=new Account(Constant.USERNAME, Constant.PASSWORD);
		System.out.println("Step 1: Navigate to QA Railway Website");
		System.out.println("Step 2: Login with a valid account");
		
		HomePage homePage=new HomePage();
		LoginPage loginPage=(LoginPage) homePage.open().gotoPage(MenuItem.LOGIN);
		loginPage.login(account);
		
		System.out.println("Step 3: Click on Book ticket tab");
		loginPage.gotoPage(MenuItem.BOOKTICKET);
		
		Ticket ticket=new Ticket("Nha Trang","Sài Gòn","Soft bed with air conditioner","4");
		
		System.out.println("Step 4: Select the next 25 days from Depart date");
		System.out.println("Step 5: Select Depart from Nha Trang and Arrive at Sài Gòn ");
		System.out.println("Step 6: Select Soft seat with air conditioner for Seat type");
		System.out.println("Step 7: Select 5 for Ticket amount");
		System.out.println("Step 8: Click on Book ticket button");
		
		BookTicketPage bookTicketPage=new BookTicketPage();
		
		String defaultDate = bookTicketPage.getDefaultDepartDate();
		String expectedDate = bookTicketPage.addDays(defaultDate, 25);

		bookTicketPage.bookTicket(ticket, 25);
		bookTicketPage.checkInfor(ticket, expectedDate);
	}
	
	@Test
	public void TC14()
	{
		
//		Account account=AccountHelper.createAndActivateAccount();
		Account account=new Account(Constant.USERNAME, Constant.PASSWORD);
		
		System.out.println("Step 1: Navigate to QA Railway Website");
		System.out.println("Step 2: Login with a valid account");
		
		HomePage homePage=new HomePage();
		LoginPage loginPage=(LoginPage) homePage.open().gotoPage(MenuItem.LOGIN);
		loginPage.login(account);
		
		System.out.println("Step 3: Click on Timetable tab");
		loginPage.gotoPage(MenuItem.TIMETABLE);
		
		System.out.println("Step 4:  Click on check price link of the route from Đà Nẵng to Sài Gòn");
		TimeTablePage timeTablePage=new TimeTablePage();
		timeTablePage.getDymBtn("Depart Station", "Đà Nẵng", "Arrive Station", "Sài Gòn", "Check Price","check price").click();
		
		
		TicketPricePage ticketPricePage=new TicketPricePage();
		ticketPricePage.checkInfor(ticketPricePage, "HS", "310000");
		ticketPricePage.checkInfor(ticketPricePage, "SS", "335000");
		ticketPricePage.checkInfor(ticketPricePage, "SSC", "360000");
		ticketPricePage.checkInfor(ticketPricePage, "HB", "410000");
		ticketPricePage.checkInfor(ticketPricePage, "SB", "460000");
		ticketPricePage.checkInfor(ticketPricePage, "SBC", "510000");
		
	}

}
