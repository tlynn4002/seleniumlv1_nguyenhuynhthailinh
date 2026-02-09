package Railway;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Common.Utilities;

public class TicketPricePage extends GeneralPage{

	private final By lblTitleTicketPrice=By.xpath("//h1[normalize-space()='Ticket Price']");
	private String priceToCheck="//tr[th[normalize-space()='Price (VND)']]/td[count(//tr[th[normalize-space()='Seat type']]/td[normalize-space()='%s']/preceding-sibling::td)+1]";
	
	public boolean isTitleDisplayed()
	{
		return Utilities.isDisplayed(lblTitleTicketPrice);
	}
	public String getPriceToCheck(String seatType)
	{
		String xpathPriceToCheck=String.format(priceToCheck, seatType);
		return Utilities.waitForElementVisible(By.xpath(xpathPriceToCheck)).getText();
	}
	
	public void checkInfor(TicketPricePage ticketPricePage, String seatType, String expectedValue)
	{
		String actualValue=ticketPricePage.getPriceToCheck(seatType);
		
		Assert.assertEquals(actualValue, expectedValue, seatType+" is not match as expected");
		
		
	}
	
}
