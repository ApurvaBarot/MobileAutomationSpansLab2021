package com.spanslab.webapp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class OpenBrowserUdidTest {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "redmi");
		cap.setCapability("platformName", "Android");
		cap.setCapability("browserName", "chrome");
		cap.setCapability("chromedriverExecutable", "D:\\B-Mine\\Company\\Company\\SpansLab\\chromedriver.exe");
		cap.setCapability("udid", "f43c4160");
		
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		
//		driver.get("https://google.com/"); //wait until page load happen
//		
//		String actualTitle=driver.getTitle();
//		System.out.println(actualTitle);

	}
}









