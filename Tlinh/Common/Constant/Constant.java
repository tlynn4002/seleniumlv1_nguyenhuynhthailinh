package Constant;

import org.openqa.selenium.WebDriver;

import Common.Utilities;

public class Constant{
	
	public static WebDriver WEBDRIVER;
	public static final String RAILWAY_URL="http://saferailway.somee.com/Page/HomePage.cshtml";
	public static final String USERNAME="linhtu779@gmail.com";
	public static final String PASSWORD="123456789";
	public static final String INVALID_PASSWORD=".>+_)()(##";
	public static final String WRONG_PASSWORD="147852365";
	public static final String PID=Utilities.randomPID();
	public static final String RANDOM_EMAIL=Utilities.randomEmail(5);
	public static final int DEFAULT_TIMEOUT = 5;
	
}
