package com.spanslab.nativeapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;

public class NativeApp3Test {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi K20");
		cap.setCapability("platformName", "Android");
		cap.setCapability("app", "C:\\Components\\app\\Khan Academy_v6.3.0_apkpure.com.apk");
		cap.setCapability("udid", "f43c4160");
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//*[@text='Dismiss']").click();
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		while(driver.findElementsByXPath("//*[@text='Arts and humanities']").size()==0)
		{
			driver.executeScript("mobile:shell",ImmutableMap.of("command", "input touchscreen swipe 1000 800 1000 400"));
		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//*[@text='Arts and humanities']").click();
	    

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		while(driver.findElementsByXPath("//*[@text='Art of Asia']").size()==0)
		{
			driver.executeScript("mobile:shell",ImmutableMap.of("command", "input touchscreen swipe 1000 800 1000 400"));
		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//*[@text='Art of Asia']").click();
		
		
		
	}

}
