package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;

public class MyTicketPage extends GeneralPage{
	private final By btnCancel=By.xpath("(//input[@value='Cancel'])[1]");
	protected WebElement getBtnCancel()
	{
		return Utilities.waitForElementClickable(btnCancel);
	}
	
	public void clickOnAlert(boolean accept)
	{
		Utilities.handleAlert(accept);
		
	}
}
