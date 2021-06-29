package com.spanslab.nativeapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class NativeApp2Test {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi K20");
		cap.setCapability("platformName", "Android");
		cap.setCapability("app", "C:\\Components\\app\\Khan Academy_v6.3.0_apkpure.com.apk");
		cap.setCapability("udid", "f43c4160");
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//*[@text='Dismiss']").click();
//	    driver.findElementByXPath("//*[@content-desc='Profile tab']").click();
		driver.findElementByAccessibilityId("Profile tab").click();
		
	    driver.findElementByXPath("//*[contains(@text,'Sign up')]").click();
	    
	    driver.findElementByXPath("//*[@text='First name']").sendKeys("Balaji");
	    driver.findElementByXPath("//*[@text='Last name']").sendKeys("Dinakaran");
	  
	    driver.findElementByXPath("//*[@text='Birthday']").click();
	    
	    if(driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[1]").getText().length()==2)
	    {
	    	driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[1]").click();
		    driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[1]").clear();
		    driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[1]").sendKeys("08");
	    }
	    else
	    {
	    	driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[1]").click();
		    driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[1]").clear();
		    driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[1]").sendKeys("Aug");
	    }
	    
	    
	    
	    driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[2]").click();
	    driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[2]").clear();
	    driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[2]").sendKeys("Aug");
	    
	    driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[3]").click();
	    driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[3]").clear();
	    driver.findElementByXPath("(//*[@resource-id='android:id/numberpicker_input'])[3]").sendKeys("1990");
	    
	    driver.findElementByXPath("//*[@text='OK']").click();
	}
}




