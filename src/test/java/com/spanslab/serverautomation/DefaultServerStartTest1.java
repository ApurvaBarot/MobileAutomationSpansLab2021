package com.spanslab.serverautomation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class DefaultServerStartTest1 {

	public static void main(String[] args) throws MalformedURLException {
		AppiumDriverLocalService service=null;
		try
		{
			service= AppiumDriverLocalService.buildDefaultService();
			
			service.start();
			
			DesiredCapabilities cap=new DesiredCapabilities();
			cap.setCapability("deviceName", "hhhhhh");
			cap.setCapability("platformName", "Android");
			cap.setCapability("app", "C:\\Components\\app\\Khan Academy_v6.3.0_apkpure.com.apk");
			
			AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(service,cap);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			service.stop();
		}

	}

}






