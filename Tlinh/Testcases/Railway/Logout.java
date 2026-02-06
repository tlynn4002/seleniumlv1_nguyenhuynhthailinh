package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.Constant;
import Constant.MenuItem;

public class Logout extends LoginTest {
		@Test
		public void TC06()
	    {
	    	System.out.println("TC06 - User is redirected to Home page after logging out");
	    	
	    	Account account=new Account(Constant.USERNAME, Constant.PASSWORD);
	    	
	    	System.out.println("Step 1: Navigate to QA Railway Website");
	    	System.out.println("Step 2: Click on Login tab");
	    	
	    	HomePage homePage = new HomePage();
	        homePage.open();
	        LoginPage loginPage = (LoginPage) homePage.gotoPage(MenuItem.LOGIN);
	        
	        System.out.println("Step 2: Login with valid Email and Password");
	        loginPage.login(account);
	        
	        System.out.println("Step 3: Click on FAQ tab");
	        FAQPage faqPage = (FAQPage) homePage.gotoPage(MenuItem.FAQ);
	        
	        System.out.println("Step 4: Click on Log out tab");
	        homePage = (HomePage) homePage.gotoPage(MenuItem.LOGOUT);
	    	Assert.assertTrue(homePage.isLogoutTabInvisible(),
	    	        "Login tab is not disappeared");

	   }
		

}
