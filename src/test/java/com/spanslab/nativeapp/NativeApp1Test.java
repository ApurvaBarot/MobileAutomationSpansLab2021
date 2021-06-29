package com.spanslab.nativeapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class NativeApp1Test {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi K20");
		cap.setCapability("platformName", "Android");
		cap.setCapability("app", "C:\\Components\\app\\Khan Academy_v6.3.0_apkpure.com.apk");
		cap.setCapability("udid", "f43c4160");
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
//		driver.findElementByXPath("//*[@text='Dismiss']").click();
//		
//		driver.findElementByXPath("//*[@text='Profile']").click();
//		
//		driver.findElementByXPath("//*[@text='Sign in']").click();
		
		driver.findElementByXPath("//*[@text='Dismiss']").click();
		 driver.findElementByXPath("//*[@content-desc='Profile tab']").click();
		 driver.findElementByXPath("//*[@text='Sign in']").click();
		 driver.findElementByXPath("//*[contains(@text,'username')]").sendKeys("Radhika");
		 driver.findElementByXPath("//*[@text='Password']").sendKeys("Radhika");
		 driver.findElementByXPath("(//*[@text='Sign in'])[2]").click();
		 
		 String actualValue=driver.findElementByXPath("//*[contains(@text,'Invalid')]").getText();
		 System.out.println(actualValue);

		 Thread.sleep(5000);
		 driver.closeApp();
		
	}	
}
