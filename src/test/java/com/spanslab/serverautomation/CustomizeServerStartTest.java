package com.spanslab.serverautomation;

import java.io.File;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class CustomizeServerStartTest {

	public static void main(String[] args) {
		
		AppiumServiceBuilder builder=new AppiumServiceBuilder()
				.usingAnyFreePort()
				.withLogFile(new File("serverlog.log"))
				.withArgument(GeneralServerFlag.RELAXED_SECURITY);
		
		AppiumDriverLocalService service= AppiumDriverLocalService.buildService(builder);
		
		service.start();
		
		System.out.println(service.getUrl());
		
		service.stop();
		
		
//		AppiumDriverLocalService.

	}

}
