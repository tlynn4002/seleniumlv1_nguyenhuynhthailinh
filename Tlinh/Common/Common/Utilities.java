package Common;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Constant.Constant;
public class Utilities {
	
	private static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
	
	
    public static WebElement waitForElementClickable(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    public static WebElement waitForElementClickable(By locator) {
        return waitForElementClickable(locator, Constant.DEFAULT_TIMEOUT);
    }

	
	public static void scrollToEndPage (WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public static void scrollByPixel (WebDriver driver, int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,arguments[0])", pixel);
	}
	
	public static void scrollToElement(WebElement element) {
	    ((JavascriptExecutor) Constant.WEBDRIVER)
	        .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	}

	
	public static boolean waitForElementInvisible(By locator, int timeout) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	    return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	public static boolean waitForElementInvisible(By locator)
	{
		return waitForElementInvisible(locator, Constant.DEFAULT_TIMEOUT);
	}

	public static void click(By locator, int timeout) {
	    WebElement element = waitForElementClickable(locator, timeout);
	    element.click();
	}

	public static String randomPID() {
	    String numberFrom0to9 = "0123456789";
	    StringBuilder pid = new StringBuilder();
	    Random random = new Random();

	    for (int i = 0; i < 9; i++) {
	        int index = random.nextInt(numberFrom0to9.length());
	        pid.append(numberFrom0to9.charAt(index));
	    }
	    return pid.toString();
	}
	public static String randomEmail(int length)
	{
		 String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		 StringBuilder result = new StringBuilder();
		 Random random = new Random();

		 for (int i = 0; i < length; i++) 
		 {
		     result.append(chars.charAt(random.nextInt(chars.length())));
		 }
		    return result.toString();
	}
	public static String randomPassword(int length)
	{
		String chars = "0123456789";
		 StringBuilder result = new StringBuilder();
		 Random random = new Random();

		 for (int i = 0; i < length; i++) 
		 {
		     result.append(chars.charAt(random.nextInt(chars.length())));
		 }
		    return result.toString();
	}
	public static void switchToWindowByTitle(String title) {
	    for (String window : driver.getWindowHandles()) {
	        driver.switchTo().window(window);
	        if (driver.getTitle().contains(title)) {
	            return;
	        }
	    }
	}
	
	public static void switchToWindowByTitleAndRefresh(String title) {
	    WebDriver driver = Constant.WEBDRIVER;

	    for (String window : driver.getWindowHandles()) {
	        driver.switchTo().window(window);
	        if (driver.getTitle().contains(title)) {
	            driver.navigate().refresh();

	            new WebDriverWait(driver, Duration.ofSeconds(10)).until(
	                wd -> ((JavascriptExecutor) wd)
	                    .executeScript("return document.readyState")
	                    .equals("complete")
	            );
	            break;
	        }
	    }
	}

	
	public static void sleep(int seconds) 
	{
	        try {
	            Thread.sleep(seconds * 1000L);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	public static void closeAdsIfPresent() {
	    try {
	        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;

	        js.executeScript(
	            "let ads = document.querySelectorAll('iframe, .ads, [id*=ad]');" +
	            "ads.forEach(a => a.remove());"
	        );
	    } catch (Exception e) {
	        // ignore
	    }
	}

	public static boolean isTextboxHasValue(By locator, int timeout) {
	    WebElement element = waitForElementClickable(locator, timeout);
	    String value = element.getAttribute("value");
	    return value != null && !value.trim().isEmpty();
	}

	public static boolean isTextboxHasValue(By locator) {
	    return isTextboxHasValue(locator, Constant.DEFAULT_TIMEOUT);
	}

	public static void switchToDefaultContent() {
	    try {
	        Constant.WEBDRIVER.switchTo().defaultContent();
	    } catch (Exception e) {
	        // ignore
	    }
	}
	public static WebElement waitForElementVisible(By locator, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(
	            Constant.WEBDRIVER,
	            Duration.ofSeconds(timeoutInSeconds)
	    );
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static WebElement waitForElementVisible(By locator) {
	    WebDriverWait wait = new WebDriverWait(
	        driver,
	        Duration.ofSeconds(Constant.DEFAULT_TIMEOUT)
	    );
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void refreshPage() {
	    Constant.WEBDRIVER.navigate().refresh();
	}

	public static LocalDate parseDate(String dateText) {
	    DateTimeFormatter formatter =
	            DateTimeFormatter.ofPattern(Constant.DATE_FORMAT);
	    return LocalDate.parse(dateText, formatter);
	}

	public static String formatDate(LocalDate date) {
	    DateTimeFormatter formatter =
	            DateTimeFormatter.ofPattern(Constant.DATE_FORMAT);
	    return date.format(formatter);
	}
	
}