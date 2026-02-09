package Railway;

import java.awt.Checkbox;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v142.network.model.PrivateNetworkRequestPolicy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Common.Utilities;

public class BookTicketPage extends GeneralPage{
	private final By departDate=By.xpath("//select[@name='Date']");
	private final By departFrom=By.xpath("//select[@name='DepartStation']");
	private final By arriveAt=By.xpath("//select[@name='ArriveStation']");
	private final By seatType=By.xpath("//select[@name='SeatType']");
	private final By ticketAmount=By.xpath("//select[@name='TicketAmount']");
	private final By btnBookTicket=By.xpath("//input[@value='Book ticket']");
	//locator after booking ticket//
	private final By lblMsg=By.xpath("//div[contains(@id,'content')]/h1");
	//dynamic xpath for locator after book ticket//
	private final String infoNeedToCheck="//td[position() =count(//th[contains(text(),'%s')]/preceding-sibling::th) + 1 ]";
	
	protected WebElement getDepartDate()
	{
		return Utilities.waitForElementClickable(departDate);
	}
	
	protected WebElement getDepartFrom()
	{
		return Utilities.waitForElementClickable(departFrom);
	}
	
	protected WebElement getArriveAt()
	{
		return Utilities.waitForElementClickable(arriveAt);
	}
	
	protected WebElement getSeatType()
	{
		return Utilities.waitForElementClickable(seatType);
	}
	
	protected WebElement getTicketAmount()
	{
		return Utilities.waitForElementClickable(ticketAmount);
	}
	
	protected WebElement getBtnBookTicket()
	{
		return Utilities.waitForElementClickable(btnBookTicket);
	}
	
	protected WebElement getLblMsg()
	{
		return Utilities.waitForElementVisible(lblMsg);
	}
	protected String getInfoNeedToCheck()
	{
		return infoNeedToCheck;
	}
	protected WebElement getInfoNeedToCheck(String col)
	{
		String infoXpath=String.format(infoNeedToCheck, col);
		Utilities.scrollToElement(Utilities.waitForElementClickable(By.xpath(infoXpath)));
		return Utilities.waitForElementVisible(By.xpath(infoXpath));
		
	}
	
	///get departDate from Railway//
	public String getDefaultDepartDate()
	{
		Select select = new Select(getDepartDate());
	    return select.getFirstSelectedOption().getText().trim();
	}
	//add days to departDate default value//
	public String addDays(String defaultDateString, int days) {
		 LocalDate defaultDate = Utilities.parseDate(defaultDateString);

		 LocalDate finalDepartDate = defaultDate.plusDays(days);

		    return Utilities.formatDate(finalDepartDate);
	}
	
	
	
	public void bookTicket(Ticket ticket, int days)
	{
		 String defaultDateText = getDefaultDepartDate();

		 String departDateText =addDays(defaultDateText,days);

		 new Select(getDepartDate())
		            .selectByVisibleText(departDateText);
		 
		 new Select(getDepartFrom()).selectByVisibleText(ticket.getDepartFrom());
		 Utilities.waitForSelectReload(arriveAt);

		 new Select(getArriveAt()).selectByVisibleText(ticket.getArriveAt());
		

		 new Select(getSeatType())
		            .selectByVisibleText(ticket.getSeatType());

		 new Select(getTicketAmount())
		            .selectByVisibleText(ticket.getTicketAmount());
		 

		    getBtnBookTicket().click();
	}
	
	public void checkInfor(Ticket ticket,String expectedDate)
	{
		String actualDepartDate=getInfoNeedToCheck("Depart Date").getText();
		String actualDepartStation=getInfoNeedToCheck("Depart Station").getText();
		String actualArriveStation=getInfoNeedToCheck("Arrive Station").getText();
		String actualSeatType=getInfoNeedToCheck("Seat Type").getText();
		String actualAmount=getInfoNeedToCheck("Amount").getText();
		
		
		
		Assert.assertEquals(actualDepartDate, expectedDate, "Depart Date mismatch");
		Assert.assertEquals(actualDepartStation, ticket.getDepartFrom(), "Depart Station mismatch");
		Assert.assertEquals(actualArriveStation, ticket.getArriveAt(), "Arrive Station mismatch");
		Assert.assertEquals(actualSeatType, ticket.getSeatType(), "Seat Type mismatch");
		Assert.assertEquals(actualAmount, ticket.getTicketAmount(), "Amount mismatch");
		
		
	}
	

}
