package Railway;


import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;
import Constant.MenuItem;

public class LoginTest extends TestBase{
    @Test
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");
        
        String expectedMsg = "Welcome"+" "+ Constant.USERNAME;
        Account account=new Account(Constant.USERNAME,Constant.PASSWORD);
        
        System.out.println("Step 1: Navigate to QA Railway Website");
        System.out.println("Step 2: Click on 'Login' tab");
        
        HomePage homePage = new HomePage();
        
        LoginPage loginPage = (LoginPage) homePage.open().gotoPage(MenuItem.LOGIN);
        
        System.out.println("Step 3: Enter valid Email and Password");
        System.out.println("Step 4: Click on 'Login' button");
        
        String actualMsg = loginPage
                .login(account)
                .getWelcomeMessage();


        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
    
    @Test
    public void TC02() {
    	System.out.println("TC02 - User cannot login with blank Username textbox");
    	
    	String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
    	
    	Account account=new Account("",Constant.PASSWORD);
    	System.out.println("Step 1: Navigate to QA Railway Website");
    	System.out.println("Step 2: Click on Login tab");
    	
    	HomePage homePage = new HomePage();

        LoginPage loginPage = (LoginPage) homePage.open().gotoPage(MenuItem.LOGIN);

    	System.out.println("Step 3: User doesn't type any words into Username textbox but enter valid information into Password textbox");
    	System.out.println("Step 4: Click on Login button");

    	loginPage.login(account);
    

        String actualMsg = loginPage.getLblLoginErrorMsg(); 
        Assert.assertEquals(actualMsg, expectedMsg,
                "Error message is not display correctly");
    }
    
    @Test
    public void TC03() {
    	System.out.println("TC03 - User cannot log into Railway with invalid password ");

    	String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
    	Account account=new Account(Constant.USERNAME,Constant.INVALID_PASSWORD);
    	
    	System.out.println("Step 1: Navigate to QA Railway Website");
    	System.out.println("Step 2: Click on Login tab");
    	
    	HomePage homePage = new HomePage();
        LoginPage loginPage = (LoginPage) homePage.open().gotoPage(MenuItem.LOGIN);
        
    	System.out.println("Step 3: Enter valid Email and invalid Password");
    	System.out.println("Step 4: Click on \"Login\" button");

        loginPage.login(account);

        String actualMsg = loginPage.getLblLoginErrorMsg();
        

        Assert.assertEquals(actualMsg, expectedMsg,
                "Invalid message is not display correctly");
    }
    @Test
    public void TC04()
    {
    	System.out.println("TC04 - System shows message when user enters wrong password many times. ");
    	
    	String actualMsg;
        String expectedMsg;
        
        Account account=new Account(Constant.USERNAME, Constant.WRONG_PASSWORD);
        
    	System.out.println("Step 1: Navigate to QA Railway Website");
    	System.out.println("Step 2: Click on Login tab");

    	HomePage homePage = new HomePage();        
        LoginPage loginPage = (LoginPage) homePage.open().gotoPage(MenuItem.LOGIN);
        
        
        System.out.println("Step 3: Enter valid information into \"Username\" textbox except \"Password\" textbox");
        System.out.println("Step 4: Click on Login button");
        System.out.println("Step 5: Repeat step 3 and 4 three more times");

        for(int i=1;i<=4;i++)
        {
        	
        	loginPage.login(account);
        	actualMsg = loginPage.getLblLoginErrorMsg();
        	expectedMsg= "Invalid username or password. Please try again.";
        	Assert.assertEquals(actualMsg, expectedMsg,
                     "Warning message for many attemps login is not displayed correctly");
        	
        	if(i==4)
        	{
        		loginPage.login(account);
        		actualMsg = loginPage.getLblLoginErrorMsg();
            	expectedMsg= "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
            	Assert.assertEquals(actualMsg, expectedMsg,
                         "Warning message for many attemps login is not displayed correctly");
        	}
        }
    }
    
    @Test
    public void TC05() 
    {
    	
    	System.out.println("TC05 - User can't login with an account hasn't been activated. ");
    
    	String expectedMsg = "Invalid username or password. Please try again.";
    	
    	String inactiveMail="fakemail0101@sharklasers.com";
    	String inactivePassword ="147852369";
    	Account account= new Account(inactiveMail, inactivePassword);
    	
    	System.out.println("Step 1: Navigate to QA Railway Website");
    	System.out.println("Step 2: Click on Login tab");
    	
    	HomePage homePage = new HomePage();
    	
        LoginPage loginPage = (LoginPage) homePage.open().gotoPage(MenuItem.LOGIN);

    	System.out.println("Step 3: Enter username and password of account hasn't been activated.");
    	System.out.println("Step 4: Click on Login button");
        
        loginPage.login(account);

        String actualMsg = loginPage.getLblLoginErrorMsg();

        Assert.assertEquals(actualMsg, expectedMsg,
                "Invalid message is not display correctly");
    }
    
    
}