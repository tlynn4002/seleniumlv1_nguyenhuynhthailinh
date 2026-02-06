package Railway;

import org.testng.annotations.Test;

import Constant.MenuItem;

public class BookTicket {
	@Test
	public void TC12()
	{
		System.out.println("Step 1: Navigate to QA Railway Website");
		System.out.println("Step 2: Login with a valid account");
		HomePage homePage=new HomePage();
		LoginPage loginPage=(LoginPage) homePage.open().gotoPage(MenuItem.LOGIN);
		
		System.out.println("Step 3: Click on Book ticket tab");
		homePage.getTabBookTicket().click();
		
		System.out.println("Step 4: Select the next 2 days from Depart date");
		
		
		System.out.println("Step 5: Select Depart from Nha Trang and Arrive at Huế ");
		System.out.println("Step 6: Select Soft bed with air conditioner for Seat type");
		System.out.println("Step 7: Select 1 for Ticket amount");
		System.out.println("Step 8: Click on Book ticket button");

	}

}
