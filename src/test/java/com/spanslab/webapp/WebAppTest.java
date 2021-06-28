package com.spanslab.webapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class WebAppTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "redmi");
		cap.setCapability("platformName", "Android");
		cap.setCapability("browserName", "chrome");
		cap.setCapability("chromedriverExecutable", "D:\\B-Mine\\Company\\Company\\SpansLab\\chromedriver.exe");
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(1,TimeUnit.SECONDS);
		driver.get("https://magento.com/");//wait until page load 
		
		driver.findElementByXPath("//*[text()='Sign in']").click(); //findelement --> try to find the element in 500ms
		driver.findElementByXPath("//*[@id='email']").sendKeys("balaji0017@gmail.com");  //findelement --> try to find the element in 500ms
		driver.findElementByXPath("//*[@id='pass']").sendKeys("balaji@12345");
	
		if(driver.isKeyboardShown())
		{
			driver.hideKeyboard();
		}
		
		driver.findElementByXPath("//*[@id='send2']").click();
	
		//wait //wait until logout presence
		
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Log Out']")));
		
		//get the title
		System.out.println(driver.getTitle());
		
		driver.findElementByXPath("//*[text()='Log Out']").click();
		
		//click log out
		Thread.sleep(5000);
		driver.quit();

	}
}



