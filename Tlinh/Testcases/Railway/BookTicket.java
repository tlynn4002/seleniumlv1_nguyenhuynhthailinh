package Railway;

import java.lang.invoke.ConstantBootstraps;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.Constant;
import Constant.MenuItem;
import Constant.SeatType;

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
		
		homePage = loginPage.login(account);
		
		System.out.println("Step 3: Click on Book ticket tab");
		BookTicketPage bookTicketPage = (BookTicketPage) homePage.gotoPage(MenuItem.BOOKTICKET);
		
		Ticket ticket=new Ticket("Nha Trang","Huế","Soft bed with air conditioner","1");
		
		System.out.println("Step 4: Select the next 2 days from Depart date");
		System.out.println("Step 5: Select Depart from Nha Trang and Arrive at Huế ");
		System.out.println("Step 6: Select Soft bed with air conditioner for Seat type");
		System.out.println("Step 7: Select 1 for Ticket amount");
		System.out.println("Step 8: Click on Book ticket button");
		
		
		
		String defaultDate = bookTicketPage.getDefaultDepartDate();
		String expectedDate = bookTicketPage.addDays(defaultDate, 2);

		bookTicketPage.bookTicket(ticket, 2);
		
		//verify infor
		String actualDepartDate=bookTicketPage.getInfoNeedToCheck("Depart Date").getText();
		String actualDepartStation=bookTicketPage.getInfoNeedToCheck("Depart Station").getText();
		String actualArriveStation=bookTicketPage.getInfoNeedToCheck("Arrive Station").getText();
		String actualSeatType=bookTicketPage.getInfoNeedToCheck("Seat Type").getText();
		String actualAmount=bookTicketPage.getInfoNeedToCheck("Amount").getText();
		
		
		
		Assert.assertEquals(actualDepartDate, expectedDate, "Depart Date mismatch");
		Assert.assertEquals(actualDepartStation, ticket.getDepartFrom(), "Depart Station mismatch");
		Assert.assertEquals(actualArriveStation, ticket.getArriveAt(), "Arrive Station mismatch");
		Assert.assertEquals(actualSeatType, ticket.getSeatType(), "Seat Type mismatch");
		Assert.assertEquals(actualAmount, ticket.getTicketAmount(), "Amount mismatch");
		
	}
	
	@Test
	public void TC13()
	{
		//Pre-condition: create an active account//
	//	Account account=AccountHelper.createAndActivateAccount();
		Account account=new Account(Constant.USERNAME, Constant.PASSWORD);
		System.out.println("Step 1: Navigate to QA Railway Website");
		System.out.println("Step 2: Login with a valid account");
		
		HomePage homePage=new HomePage();
		LoginPage loginPage=(LoginPage) homePage.open().gotoPage(MenuItem.LOGIN);
		homePage=loginPage.login(account);
		
		System.out.println("Step 3: Click on Book ticket tab");
		BookTicketPage bookTicketPage= (BookTicketPage) homePage.gotoPage(MenuItem.BOOKTICKET);
		
		Ticket ticket=new Ticket("Nha Trang","Sài Gòn","Soft bed with air conditioner","4");
		
		System.out.println("Step 4: Select the next 25 days from Depart date");
		System.out.println("Step 5: Select Depart from Nha Trang and Arrive at Sài Gòn ");
		System.out.println("Step 6: Select Soft seat with air conditioner for Seat type");
		System.out.println("Step 7: Select 5 for Ticket amount");
		System.out.println("Step 8: Click on Book ticket button");
	
		
		String defaultDate = bookTicketPage.getDefaultDepartDate();
		String expectedDate = bookTicketPage.addDays(defaultDate, 25);

		bookTicketPage.bookTicket(ticket, 25);
		//verify infor
		String actualDepartDate=bookTicketPage.getInfoNeedToCheck("Depart Date").getText();
		String actualDepartStation=bookTicketPage.getInfoNeedToCheck("Depart Station").getText();
		String actualArriveStation=bookTicketPage.getInfoNeedToCheck("Arrive Station").getText();
		String actualSeatType=bookTicketPage.getInfoNeedToCheck("Seat Type").getText();
		String actualAmount=bookTicketPage.getInfoNeedToCheck("Amount").getText();
				
				
				
		Assert.assertEquals(actualDepartDate, expectedDate, "Depart Date mismatch");
		Assert.assertEquals(actualDepartStation, ticket.getDepartFrom(), "Depart Station mismatch");
		Assert.assertEquals(actualArriveStation, ticket.getArriveAt(), "Arrive Station mismatch");
		Assert.assertEquals(actualSeatType, ticket.getSeatType(), "Seat Type mismatch");
		Assert.assertEquals(actualAmount, ticket.getTicketAmount(), "Amount mismatch");
				
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
		homePage=loginPage.login(account);
		
		System.out.println("Step 3: Click on Timetable tab");
		TimeTablePage timeTablePage=(TimeTablePage) homePage.gotoPage(MenuItem.TIMETABLE);
		
		System.out.println("Step 4:  Click on check price link of the route from Đà Nẵng to Sài Gòn");
		timeTablePage.getDymBtn("Depart Station", "Đà Nẵng", "Arrive Station", "Sài Gòn", "Check Price","check price").click();
		
		TicketPricePage ticketPricePage=new TicketPricePage();
		//check title//
		String expectedTitle="Ticket price from Đà Nẵng to Sài Gòn";
		String actualTitle=ticketPricePage.getTitleTicketPriceTable(expectedTitle);
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
		//check price by seat type code//
		for (SeatType seat : SeatType.values()) 
		{

	        String actualSeatPrice = ticketPricePage.getPriceToCheck(seat.getSeatTypeCode());
	        Assert.assertEquals(actualSeatPrice, seat.getPrice(), "Wrong price for " + seat.getSeatTypeCode());
	    }
		
	}
	
	@Test
	public void TC15()
	{
		Account account=new Account(Constant.USERNAME, Constant.PASSWORD);
		
		System.out.println("Step 1: Navigate to QA Railway Website");
		System.out.println("Step 2: Login with a valid account");
		
		HomePage homePage=new HomePage();
		LoginPage loginPage=(LoginPage) homePage.open().gotoPage(MenuItem.LOGIN);
		homePage=loginPage.login(account);
		
		System.out.println("Step 3: Click on Timetable tab");
		TimeTablePage timeTablePage=(TimeTablePage) homePage.gotoPage(MenuItem.TIMETABLE);
		
		System.out.println("Step 4:  Click on book ticket of route Quảng Ngãi to Huế");
		timeTablePage.getDymBtn("Depart Station", "Quảng Ngãi", "Arrive Station", "Huế", "Book ticket","book ticket").click();
		
		
		
		System.out.println("Step 5: Select Depart date = tomorrow");
		System.out.println("Step 6: Select Ticket amount = 5");
		System.out.println("Step 7: Click on Book ticket button");
		
		BookTicketPage bookTicketPage=new BookTicketPage();
		
		String departStation=bookTicketPage.getDefaultDepartFrom();
		String arriveStation=bookTicketPage.getDefaultArriveTo();
		Ticket ticket=new Ticket(departStation,arriveStation,"Soft bed with air conditioner","5");
		
		String today =Utilities.formatDate(LocalDate.now());
		String expectedDate = bookTicketPage.addDays(today, 1);//tomorrow//

		bookTicketPage.bookTicket(ticket, expectedDate);
		
	}

}
