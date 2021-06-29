package com.spanslab.nativeapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class NativeApp5Test {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi K20");
		cap.setCapability("platformName", "Android");
		
		cap.setCapability("appPackage", "com.aranoah.healthkart.plus");
		cap.setCapability("appActivity", "com.aranoah.healthkart.plus.home.HomeActivity"); //home or main or splashscreen or start
		
		cap.setCapability("noReset", true);
		
		//login and choose locator --> set noReset as true
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		//2 scroll activity 
		
	}

}
