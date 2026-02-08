package Railway;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.Constant;
import Constant.MenuItem;

public class ResetPassword extends TestBase{
	@Test
	public void TC10()
	{
		//Pre-condition//
		Account account=AccountHelper.createAndActivateAccount();
		
		System.out.println("Step 1: Navigate to QA Railway Login page");
		HomePage homePage=new HomePage();
		LoginPage loginPage=(LoginPage) homePage.open().gotoPage(MenuItem.LOGIN);
		
		System.out.println("Step 2: Click on Forgot Password page link");
		System.out.println("Step 3: Enter the email address of the activated account");
		System.out.println("Step 4: Click on Send Instructions button");
		loginPage.forgetPassword(account);
		
		System.out.println("Step 5: Login to the mailbox (the same mailbox when creating account)");
		System.out.println("Step 6: Open email with subject containing Please reset your password and the email of the account at step 3");
		System.out.println("Step 7: Click on the reset link");
		AccountHelper.resetPassword();
		
		
		ResetPasswordPage resetPasswordPage=new ResetPasswordPage();
		boolean txtTokenHasValue=resetPasswordPage.isTxtResetTokenHasValue();
		
		//Check the token textbox has value or not//
		Assert.assertTrue(txtTokenHasValue, "The reset password doesn't have token value");
		System.out.println("Step 8: Input the same password into New Password and Confirm Password fields");
		System.out.println("Step 9: Click on Reset Password button");
		resetPasswordPage.changePassword(account.getPassword(),account.getPassword());
		String expectedMsg="The new password cannot be the same with the current password";
		Assert.assertEquals(resetPasswordPage.getLblMsg().getText(), expectedMsg);

	}
	
	@Test
	public void TC11()
	{
		//Pre-condition//
		Account account=AccountHelper.createAndActivateAccount();
		
		String expectedMsg1="Could not reset password. Please correct the errors and try again.";
		String expectedMsg2="The password confirmation did not match the new password.";
		
		System.out.println("Step 1: Navigate to QA Railway Login page");
		HomePage homePage=new HomePage();
		LoginPage loginPage=(LoginPage) homePage.open().gotoPage(MenuItem.LOGIN);
		
		System.out.println("Step 2: Click on Forgot Password page link");
		System.out.println("Step 3: Enter the email address of the activated account");
		System.out.println("Step 4: Click on Send Instructions button");
		loginPage.forgetPassword(account);
		
		System.out.println("Step 5: Login to the mailbox (the same mailbox when creating account)");
		System.out.println("Step 6: Open email with subject containing Please reset your password and the email of the account at step 3");
		System.out.println("Step 7: Click on the reset link");
		AccountHelper.resetPassword();
		
		
		ResetPasswordPage resetPasswordPage=new ResetPasswordPage();
		boolean txtTokenHasValue=resetPasswordPage.isTxtResetTokenHasValue();
		
		//Check the token textbox has value or not//
		Assert.assertTrue(txtTokenHasValue, "The reset password doesn't have token value");
		System.out.println("Step 8: Input different input into 2 fields new password and confirm password");
		System.out.println("Step 9: Click on Reset Password button");
		resetPasswordPage.changePassword(account.getPassword(),Utilities.randomPassword(9));
		
		//check error message//
		Assert.assertEquals(resetPasswordPage.getLblMsg().getText(), expectedMsg1);
		Assert.assertEquals(resetPasswordPage.getErrorPasswordMsg().getText(), expectedMsg2);


	}

}
