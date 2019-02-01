package com.grid.setuptest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Calc {

 // Used dataProvider parameter to get data from @DataProvider annotation method.
 // Can accept object array data(browser name, num1, num2 and expected sum value) from getNames method.
 @Test(dataProvider = "getCalcData")
 public static void calcTest(String browser, String num1, String num2, String expSumNum) throws MalformedURLException, InterruptedException {

  System.out.println(browser);

  // Initialize DesiredCapabilities null.
  DesiredCapabilities cap = null;

  // Initialize browser driver as per data received from getCalcData().
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
  RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

  // Pause test for 20 minutes to check exactly how many concurrent browsers opening at same time.
  Thread.sleep(20000);

  driver.get("http://only-testing-blog.blogspot.in/2014/04/calc.html");
  driver.findElement(By.xpath("//input[@id='Resultbox']")).clear();
  driver.findElement(By.xpath("//input[@id='" + num1 + "']")).click();
  driver.findElement(By.xpath("//input[@id='plus']")).click();
  driver.findElement(By.xpath("//input[@id='" + num2 + "']")).click();
  driver.findElement(By.xpath("//input[@id='equals']")).click();

  // Get actual result and compare with expected result.
  String strResult = driver.findElement(By.xpath("//input[@id='Resultbox']")).getAttribute("value");
  int actualResult = Integer.parseInt(strResult);
  int expectedResult = Integer.parseInt(expSumNum);
  Assert.assertEquals(actualResult, expectedResult);

  // Close browser instance.
  driver.quit();
 }

 // Created @DataProvider annotation method to supply data(browser name, num1, num2 and expected sum value) for test
 @DataProvider(parallel = true)
 public Object[][] getCalcData() {
  Object data[][] = new Object[3][4];
  data[0][0] = "firefox";
  data[0][1] = "1";
  data[0][2] = "3";
  data[0][3] = "4";

  data[1][0] = "chrome";
  data[1][1] = "2";
  data[1][2] = "5";
  data[1][3] = "7";

  data[2][0] = "iexplore";
  data[2][1] = "3";
  data[2][2] = "5";
  data[2][3] = "8";

  return data;
 }
}