package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Common.Utilities;

public class TimeTablePage extends GeneralPage{
	private final String dymBtn =
	        "//tr[" +
	        "td[" +
	        "position()=" +
	        "count(//th[contains(normalize-space(.),'%s')]/preceding-sibling::th) + 1" +
	        " and " +
	        "contains(normalize-space(.),'%s')" +
	        "]" +
	        " and " +
	        "td[" +
	        "position() =" +
	        "count(//th[contains(normalize-space(.),'%s')]/preceding-sibling::th) + 1" +
	        " and " +
	        "contains(normalize-space(.),'%s')" +
	        "]" +
	        "]" +
	        "/td[" +
	        "position() =" +
	        "count(//th[contains(normalize-space(.),'%s')]/preceding-sibling::th) + 1" +
	        "]//a[contains(text(),'%s')]";


	
	public WebElement getDymBtn(String col1, String value1, String col2, String value2, String col3, String nameBtn)
	{
		Utilities.scrollToElement( Utilities.waitForElementClickable(By.xpath(String.format(dymBtn, col1, value1, col2, value2, col3,nameBtn))));
		return Utilities.waitForElementClickable(By.xpath(String.format(dymBtn, col1, value1, col2, value2, col3,nameBtn)));
	}
	

}
