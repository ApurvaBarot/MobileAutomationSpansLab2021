package com.spanslab.cloud;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class SignInAndroidCloudTest {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();

		// Set your access credentials
		caps.setCapability("browserstack.user", "dinakaranbalaji1");
		caps.setCapability("browserstack.key", "6yXRE4nK1fyvTHWA2kPD");

		// Set URL of the application under test
		caps.setCapability("app", "bs://376a530b1b6696418b303adb00b8098771c20172");
//		caps.setCapability("appPackage", "org.khanacademy.android");
//		caps.setCapability("appActivity", "org.khanacademy.android.ui.library.MainActivity"); //home or main or splashscreen
		
		// Specify device and os_version for testing
//		caps.setCapability("device", "Google Pixel 3");
		
		caps.setCapability("device", "Samsung Galaxy S10e");
		caps.setCapability("os_version", "9.0");

		// Set other BrowserStack capabilities
		caps.setCapability("project", "Khan Academy Automation Project");
		caps.setCapability("build", "Java Android - SpansLab");
		caps.setCapability("name", "sign in invalid test");

		// Initialise the remote Webdriver using BrowserStack remote URL
		// and desired capabilities defined above
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://hub.browserstack.com/wd/hub"),
				caps);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		/* Write your Custom code here */
		driver.findElementByXPath("//*[@text='Dismiss']").click();
		driver.findElementByXPath("//*[@content-desc='Profile tab']").click();
		driver.findElementByXPath("//*[@text='Sign in']").click();
		driver.findElementByXPath("//*[contains(@text,'username')]").sendKeys("Radhika");
		driver.findElementByXPath("//*[@text='Password']").sendKeys("Radhika");

		// *[@text='Sign in' and @index='0']
		driver.findElementByXPath("(//*[@text='Sign in'])[2]").click();

		String actualValue = driver.findElementByXPath("//*[contains(@text,'Invalid')]").getText();
		System.out.println(actualValue);

		// Invoke driver.quit() after the test is done to indicate that the test is
		// completed.
		driver.quit();
		
		//will start by 2:20 PM IST

	}

}
