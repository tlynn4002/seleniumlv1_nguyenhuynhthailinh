package Railway;

import java.text.Format;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.Utilities;
import Constant.Constant;
public class GruerrillaMailPage {
	private By txtEmailName=By.xpath("//span[@id='inbox-id']");
	private By inputEmailName=By.xpath("//span/input[@type=\"text\"]");
	private By btnSet=By.xpath("//button[@class='save button small']");
	private By chkboxScamble=By.xpath("//input[@id='use-alias']");
	private By lblEmailName=By.id("email-widget");
	
	private String confirmationEmail=  "//tr[contains(@class,'mail_row')]//a[contains(text(),'%s')]";
	private By linkConfirmActive=By.xpath("//div[contains(@class,'email_body')]/a");
	
	protected WebElement getTxtEmailName()
	{
		return Utilities.waitForElementClickable(txtEmailName);
	}
	
	protected WebElement getBnSet()
	{
		return Utilities.waitForElementClickable(btnSet);
	}
	
	protected WebElement getChkboxScamble()
	{
		return Utilities.waitForElementClickable(chkboxScamble);
	}
	
	protected WebElement getLblEmailName()
	{
		return Utilities.waitForElementClickable(lblEmailName);
	}
	
	protected WebElement getInputEmailName()
	{
		return Utilities.waitForElementClickable(inputEmailName);
	}
	
	protected WebElement getLinkConfirmActive()
	{
		return Utilities.waitForElementClickable(linkConfirmActive);
	}
	
	public GruerrillaMailPage setEmailName(String randomEmailName) 
	{
		this.getTxtEmailName().click();
		this.getInputEmailName().sendKeys(randomEmailName);
		this.getBnSet().click();
		this.getChkboxScamble().click();
		return this;
	}
	
	public void activeEmail(String subject, String title) {

	    Utilities.switchToWindowByTitle("Guerrilla Mail");
	    Utilities.closeAdsIfPresent();

	    // wait for email and refesh page
	    waitForEmail(subject, 60);

	    By emailLocator = By.xpath(
	        String.format(confirmationEmail, subject)
	    );
	    
	    //click on email //
	    Utilities.waitForElementVisible(emailLocator, 60);
	    Utilities.scrollToElement((Utilities.waitForElementClickable(emailLocator)));
	    Constant.WEBDRIVER.findElement(emailLocator).click();

	   // lick link activate
	    Utilities.waitForElementVisible(linkConfirmActive, 20);
	    getLinkConfirmActive().click();

	    // navigate to railway to do next steps
	    Utilities.switchToWindowByTitle(title);
	}

	
		
	public void waitForEmail(String subject, int sc) 
	{
	    By emailLocator = By.xpath(
	        String.format(confirmationEmail, subject)
	    );

	    WebDriverWait wait = new WebDriverWait(
	        Constant.WEBDRIVER,
	        Duration.ofSeconds(sc)
	    );

	    wait.until(driver -> {
	        Utilities.refreshPage();
	        Utilities.closeAdsIfPresent();
	        return driver.findElements(emailLocator).size() > 0;
	    });
	}

	
}
