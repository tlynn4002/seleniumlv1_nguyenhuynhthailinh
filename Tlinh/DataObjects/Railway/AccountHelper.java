package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;

import Common.Utilities;
import Constant.Constant;

public class AccountHelper {

    public static Account createAndActivateAccount() {

        WebDriver driver = Constant.WEBDRIVER;
        String randomEmail = Constant.RANDOM_EMAIL;

        // Open Guerrilla Mail
        driver.get("https://www.guerrillamail.com/");

        GruerrillaMailPage mailGruerrilla = new GruerrillaMailPage();
        mailGruerrilla.setEmailName(randomEmail);
        String email = mailGruerrilla.getLblEmailName().getText();

        // Create account object
        Account account = new Account(email, Constant.PASSWORD, Constant.PID);

        // Open new tab for Railway
        driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);

        // Register account
        HomePage homePage = new HomePage();
        homePage.openRailway();
        homePage.gotoRegisterPageByCreateAccount();

        RegisterPage registerPage = new RegisterPage();
        registerPage.register(account);

        // Back to Guerrilla Mail
        Utilities.switchToWindowByTitle("Guerrilla Mail");
        Utilities.closeAdsIfPresent();
        GruerrillaMailPage mailPage2 = new GruerrillaMailPage();

        // Activate email
        mailPage2.activeEmail("Please confirm your account","Safe Railway - Registration Confirmation Pages");

      
        
        return account; 
    }
    public static void resetPassword() 
    {

        Utilities.switchToWindowByTitle("Guerrilla Mail");
        Utilities.closeAdsIfPresent();
        //click back to inbox//
        Utilities.click(By.id("back_to_inbox_link"), 5);
        GruerrillaMailPage mailPage = new GruerrillaMailPage();

        mailPage.activeEmail(
            "Please reset your password",
            "Safe Railway - Password Reset"
        );
    

    }
 
}

