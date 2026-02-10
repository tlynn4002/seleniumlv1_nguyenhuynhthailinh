package Railway;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Common.Utilities;

public class TicketPricePage extends GeneralPage{

	private final By lblTitleTicketPrice=By.xpath("//h1[normalize-space()='Ticket Price']");
	private String priceToCheck="//tr[th[normalize-space()='Price (VND)']]/td[count(//tr[th[normalize-space()='Seat type']]/td[normalize-space()='%s']/preceding-sibling::td)+1]";
	private String titleTicketPriceTable="//table[contains(@class,'MyTable MedTable')]//tr[1]/th[contains(text(),'%s')]";
	public boolean isTitleDisplayed()
	{
		return Utilities.isDisplayed(lblTitleTicketPrice);
	}
	public String getPriceToCheck(String seatType)
	{
		String xpathPriceToCheck=String.format(priceToCheck, seatType);
		return Utilities.waitForElementVisible(By.xpath(xpathPriceToCheck)).getText();
	}
	
	public String getTitleTicketPriceTable(String title)
	{
		String xpathTitleTable=String.format(titleTicketPriceTable, title);
		return Utilities.waitForElementVisible(By.xpath(xpathTitleTable)).getText();
	}
	
}
