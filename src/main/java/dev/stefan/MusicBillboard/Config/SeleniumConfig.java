package dev.stefan.MusicBillboard.Config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;

import dev.stefan.MusicBillboard.Expection.WebDriveException;

public class SeleniumConfig {

	private static final String Message = "Selenium啟動時發生錯誤";
	
	@Value("${driver.key}")
	private String driverKey;
	
	@Value("${driver.value}")
	private String driverValue;
	
	@Value("${implicitly.wait}")
	private int implicitlyTime;
	
	@Value("${options.argument.head}")
	private String optionsHead;
	
	@Value("${options.argument.window }")
	private String optionsWindow;
	
	@Value("${options.argument.image}")
	private String optionsImage;
	
	private WebDriver webDriver;
	
	public WebDriver getWebDriver() throws WebDriveException {
		  ChromeOptions options = new ChromeOptions();
		  
		  try {
			System.setProperty(driverKey, driverValue);
			  //For headless browser you have to set the window size to fire on event.
			  //Because headless browser can't recognise where to click without window size
			  options.addArguments(optionsHead);
			  options.addArguments(optionsWindow);
			  //Without loading img
			  options.addArguments(optionsImage);
			  webDriver = new ChromeDriver(options);
			  webDriver.manage().timeouts().implicitlyWait(implicitlyTime, TimeUnit.SECONDS);
		} catch (Exception e) {
			throw new WebDriveException(Message);
		}
		  
          return webDriver;
	}
	
}
