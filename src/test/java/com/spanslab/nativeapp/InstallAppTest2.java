package com.spanslab.nativeapp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class InstallAppTest2 {

	public static void main(String[] args) throws MalformedURLException {
		
		File file=new File("src/test/resources/app/Khan Academy_v6.3.0_apkpure.com.apk");
		String apkPath= file.getAbsolutePath();
		System.out.println(apkPath);
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "hhhhhh");
		cap.setCapability("platformName", "Android");
		cap.setCapability("app", apkPath);
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
	}

}
