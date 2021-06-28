package com.spanslab.webapp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class OpenBrowserTest {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "redmi");
		cap.setCapability("platformName", "Android");
		cap.setCapability("browserName", "chrome");
		cap.setCapability("chromedriverExecutable", "D:\\B-Mine\\Company\\Company\\SpansLab\\chromedriver_win32 (3) -88.0\\chromedriver.exe");
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		
//		driver.get("https://google.com/"); //wait until page load happen
//		
//		String actualTitle=driver.getTitle();
//		System.out.println(actualTitle);

	}
}









