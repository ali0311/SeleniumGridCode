package com.grid.setuptest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParallelRunTest {
	
	
	
	// Used dataProvider parameter to get data from @DataProvider annotation
	// method.
	// Can accept object array data(browser name, First Name and Last Name) from
	// getNames method.
	@Test(dataProvider = "getNames")
	public void gmailLogin(String browser, String fName, String lName)
			throws MalformedURLException, InterruptedException {

		// Initialize DesiredCapabilities null.
		DesiredCapabilities cap = null;

		// Initialize browser driver as per data received from getNames().
		if (browser.equals("firefox")) {
			// Set firefox browser capabilities for windows platform.
			cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
		} else if (browser.equals("chrome")) {
			// Set chrome browser capabilities for windows platform.
			cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
		} else if (browser.equals("iexplore")) {
			// Set IE browser capabilities for windows platform.
			cap = DesiredCapabilities.internetExplorer();
			cap.setBrowserName("internet explorer");
			cap.setPlatform(Platform.WINDOWS);
		}

		// Initialize RemoteWebDriver on grid 2 node with browser capability.
		//RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.179:4444/wd/hub"), cap);	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Open URL in requested browsers of node and execute test steps.
		driver.get("http://only-testing-blog.blogspot.in/2014/05/form.html");
		driver.findElement(By.name("FirstName")).sendKeys(fName);
		driver.findElement(By.name("LastName")).sendKeys(lName);

		driver.quit();
	}

	// Created @DataProvider annotation method to supply data(browser name,
	// First Name and Last Name) for test
	@DataProvider(parallel = true)
	public Object[][] getNames() {
		Object data[][] = new Object[1][3];
//		data[0][0] = "firefox";
//		data[0][1] = "FirstName1";
//		data[0][2] = "LastName1";

//		data[1][0] = "chrome";
//		data[1][1] = "FirstName2";
//		data[1][2] = "LastName2";

//		data[2][0] = "iexplore";
//		data[2][1] = "FirstName3";
//		data[2][2] = "LastName3";
		
		data[0][0] = "chrome";
		data[0][1] = "FirstName1";
		data[0][2] = "LastName1";

		return data;
	}
	
	
}
