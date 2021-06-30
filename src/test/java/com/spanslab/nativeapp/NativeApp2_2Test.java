package com.spanslab.nativeapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class NativeApp2_2Test {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi K20");
		cap.setCapability("platformName", "Android");
//		cap.setCapability("app", "C:\\Components\\app\\Khan Academy_v6.3.0_apkpure.com.apk");
//		cap.setCapability("udid", "f43c4160");
		cap.setCapability("appPackage", "org.khanacademy.android");
		cap.setCapability("appActivity", "org.khanacademy.android.ui.library.MainActivity"); //home or main or splashscreen
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		// check and then click
		if (driver.findElementsByXPath("//*[@text='Dismiss']").size() > 0) {
			driver.findElementByXPath("//*[@text='Dismiss']").click();
		}

//	    driver.findElementByXPath("//*[@content-desc='Profile tab']").click();
		driver.findElementByAccessibilityId("Profile tab").click();

		driver.findElementByXPath("//*[contains(@text,'Sign up')]").click();

		driver.findElementByXPath("//*[@text='First name']").sendKeys("Balaji");
		driver.findElementByXPath("//*[@text='Last name']").sendKeys("Dinakaran");

		driver.findElementByXPath("//*[@text='Birthday']").click();

		String data = "";
		List<WebElement> elements = driver.findElementsByXPath("//*[@resource-id='android:id/numberpicker_input']");

		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).getText().length() == 2) {
				data = "08";
			} else if (elements.get(i).getText().length() == 3) {
				data = "Aug";
			} else {
				data = "1990";
			}

			while (!elements.get(i).getText().equals(data)) {
				System.out.println(elements.get(i).getText());
				elements.get(i).click();
				elements.get(i).clear();
				elements.get(i).sendKeys(data);
			}

		}

		driver.findElementByXPath("//*[@text='OK']").click();

	}
}
