package com.spanslab.serverautomation;

import java.io.File;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class CustomizeServerStartTest2 {

	public static void main(String[] args) {
		AppiumDriverLocalService service = null;
		try {
			AppiumServiceBuilder builder = new AppiumServiceBuilder().usingAnyFreePort()
					.withLogFile(new File("src/test/resources/logs/server_"+LocalDateTime.now().toString().replace(":", "-")+".log"))
					.withArgument(GeneralServerFlag.RELAXED_SECURITY);

			service = AppiumDriverLocalService.buildService(builder);

			if (!service.isRunning()) {
				service.start();
			}
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("deviceName", "hhhhhh");
			cap.setCapability("platformName", "Android");
			cap.setCapability("app", "C:\\Components\\app\\Khan Academy_v6.3.0_apkpure.com.apk");

			AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(service, cap);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			service.stop();
		}

//		AppiumDriverLocalService.

	}

}
