package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;

public class BookTicketPage {
	private final By departDate=By.xpath("//select[@name='Date']");
	private final By departFrom=By.xpath("//select[@name='DepartStation']");
	private final By arriveAt=By.xpath("//select[@name='ArriveStation']");
	private final By seatType=By.xpath("//select[@name='SeatType']");
	private final By ticketAmount=By.xpath("//select[@name='TicketAmount']");
	private final By btnBookTicket=By.xpath("//input[@value='Book ticket']");
	
	
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
}
