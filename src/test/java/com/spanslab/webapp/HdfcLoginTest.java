package com.spanslab.webapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class HdfcLoginTest {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "redmi");
		cap.setCapability("platformName", "Android");
		cap.setCapability("browserName", "chrome");
		cap.setCapability("chromedriverExecutable", "D:\\B-Mine\\Company\\Company\\SpansLab\\chromedriver.exe");
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://netbanking.hdfcbank.com/netbanking/");//wait until page load 
		
		driver.switchTo().frame(driver.findElementByXPath("//*[contains(@src,'RSLogin')]"));
		
		driver.findElementByXPath("//*[@name='fldLoginUserId']").sendKeys("test123");
		//click on continue
		
		driver.switchTo().defaultContent();

	}

}
