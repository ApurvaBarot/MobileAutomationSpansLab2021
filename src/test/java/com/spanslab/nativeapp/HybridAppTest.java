package com.spanslab.nativeapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class HybridAppTest {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities cap=new DesiredCapabilities();
		
		cap.setCapability("deviceName", "Redmi K20");
		cap.setCapability("platformName", "Android");
		
		cap.setCapability("appPackage", "com.ltts.myts");
		cap.setCapability("appActivity", "android.support.customtabs.trusted.LauncherActivity"); 
		cap.setCapability("chromedriverExecutable", "D:\\B-Mine\\Company\\Company\\SpansLab\\chromedriver.exe");
		
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>
									(new URL("http://localhost:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		
		String currentContext= driver.getContext();
		System.out.println(currentContext);
		System.out.println("--------------------------------------");
		
//		Set<String> contexts= driver.getContextHandles();
//		
//		for(String context : contexts)
//		{
//			System.out.println(context);
//			
//			driver.context(context);//set context
//			
//			if(driver.findElementsByXPath("//*[@id='txtPassword']").size()>0)
//			{
//				break;
//			}
//		}
		
		driver.context("WEBVIEW_chrome");
//		
//		//it will try to point to the context where //*[@id='txtPassword'] is available
		driver.findElementByXPath("//*[@id='txtUsername']").sendKeys("123");
		driver.findElementByXPath("//*[@id='txtPassword']").sendKeys("hello123");
		
		driver.findElementByXPath("//*[@id='submit']").click();
//		
//		
//		driver.context("NATIVE_APP");
//		driver.findElementByXPath("//*[@resource-id='txtUsername']").sendKeys("123");
		
	}

}






