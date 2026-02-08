package Railway;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v142.network.model.PrivateNetworkRequestPolicy;
import org.openqa.selenium.support.ui.Select;

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

		 new Select(getDepartFrom())
		            .selectByVisibleText(ticket.getDepartFrom());

		 new Select(getArriveAt())
		            .selectByVisibleText(ticket.getArriveAt());

		 new Select(getSeatType())
		            .selectByVisibleText(ticket.getSeatType());

		 new Select(getTicketAmount())
		            .selectByVisibleText(ticket.getTicketAmount());

		    getBtnBookTicket().click();
	}
	

}
