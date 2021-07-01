package com.spanslab.appium;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;

public class AppiumCodeTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		File file=new File("src/test/resources/app/Khan Academy_v6.3.0_apkpure.com.apk");
		String apkPath= file.getAbsolutePath();
		System.out.println(apkPath);
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi K20");
		cap.setCapability("platformName", "Android");
		cap.setCapability("app", apkPath);
		cap.setCapability("autoLaunch", "false");
		
		cap.setCapability("unlockType", "pattern");
		cap.setCapability("unlockKey", "35968");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.startRecordingScreen();
		
		if (driver.isAppInstalled("org.khanacademy.android")) {
			driver.launchApp();
		}
		else
		{
			driver.installApp(apkPath);
		}
		System.out.println(driver.getSessionDetails());
		System.out.println(driver.getAutomationName());
		System.out.println(driver.getDeviceTime());
		
		System.out.println(driver.getCapabilities());
		
		System.out.println(driver.currentActivity());
		System.out.println(driver.getCurrentPackage());

		driver.findElementByXPath("//*[@text='Dismiss']").click();
		driver.findElementByXPath("//*[@content-desc='Profile tab']").click();
		driver.findElementByXPath("//*[@text='Sign in']").click();
		driver.findElementByXPath("//*[contains(@text,'username')]").sendKeys("Radhika");
		driver.findElementByXPath("//*[@text='Password']").sendKeys("Radhika");

		driver.findElementByXPath("(//*[@text='Sign in'])[2]").click();

		String actualValue = driver.findElementByXPath("//*[contains(@text,'Invalid')]").getText();
		System.out.println(actualValue);

		Thread.sleep(5000);
		driver.closeApp();
		
		String encoded= driver.stopRecordingScreen();
		
		byte[] decode=Base64.getDecoder().decode(encoded);
		
		
		
		FileOutputStream fout=new FileOutputStream(new File("recording/khanSignin.mp4"));
		fout.write(decode);
		fout.flush();
		
		driver.executeScript("mobile : shell", 
				ImmutableMap.of("command", "adb shell am start -a android.bluetooth.adapter.action.REQUEST_ENABLE"));

	}

}



