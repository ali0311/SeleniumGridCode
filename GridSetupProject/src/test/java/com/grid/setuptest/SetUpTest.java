package com.grid.setuptest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SetUpTest
{
	WebDriver driver ;
	String hubUrl = "http://192.168.0.106:4444/wd/hub";
	
	@Test
	public void LoginTest() throws MalformedURLException
	{
		
//********Normal Set up
		
//	String currentDir = System.getProperty("user.dir");
//	String chromeDriverPath= currentDir + "//Resources//chromedriver.exe";
//	System.setProperty("webdriver.chrome.driver", chromeDriverPath);
//	ChromeOptions options = new ChromeOptions();
//	driver = new ChromeDriver(options);
//	driver.get("https://www.flipkart.com/");
//	driver.quit();
		

//*******Generic code
		
		//define desire capability
		
//		DesiredCapabilities cap = new DesiredCapabilities();
//		//cap.setBrowserName("chrome");
//		//cap.setBrowserName("firefox");
//		cap.setPlatform(Platform.WIN10);
//		
//		//define chrome options
//		// ChromeOptions options = new ChromeOptions();
//		 FirefoxOptions options = new FirefoxOptions();
//		 options.merge(cap);
//		 
//		 String hubUrl = "http://192.168.0.179:4444/wd/hub";
//		 driver= new RemoteWebDriver(new URL(hubUrl),options);
//		 
//		 driver.get("https://www.flipkart.com/");
//		 driver.quit();
		 
		 
		 //FOR IE
		
//		DesiredCapabilities cap1 = DesiredCapabilities.internetExplorer();
//		driver= new RemoteWebDriver(new URL(hubUrl),cap1);
//		 
//		cap1.setPlatform(Platform.WIN10);
//		
//		driver.get("https://www.flipkart.com/");
//		driver.quit();
		
		//FOR firefox
		
//		DesiredCapabilities cap2 = DesiredCapabilities.firefox(); 
//		driver= new RemoteWebDriver(new URL(hubUrl),cap2);
//		 
//		cap2.setPlatform(Platform.WIN10);
//		
//		driver.get("https://www.flipkart.com/");
//		driver.quit();
		
		
		//FOR Chrome
		
		DesiredCapabilities cap3 = DesiredCapabilities.chrome(); 
		driver= new RemoteWebDriver(new URL(hubUrl),cap3);
		 
		cap3.setPlatform(Platform.WIN10);
		
		driver.get("https://www.flipkart.com/");
		driver.quit();
		
//		DesiredCapabilities cap4 = DesiredCapabilities.chrome(); 
//		driver= new RemoteWebDriver(new URL(hubUrl),cap4);
//		 
//		cap4.setPlatform(Platform.WIN10);
//		
//		driver.get("https://www.flipkart.com/");
//		driver.quit();

	}
}
