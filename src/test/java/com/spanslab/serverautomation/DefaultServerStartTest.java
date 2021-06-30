package com.spanslab.serverautomation;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class DefaultServerStartTest {

	public static void main(String[] args) throws InterruptedException {
	
		 AppiumDriverLocalService service=  AppiumDriverLocalService.buildDefaultService(); //4723 port //all default settings
		 
		 System.out.println(service.isRunning());
		 
		 service.start();
		 
		 //load desiredcap and connect to androiddriver
		 
		 System.out.println(service.isRunning());
		 
		 System.out.println(service.getUrl());

		 Thread.sleep(2000);
		 
		 service.stop();
		 
		 System.out.println(service.isRunning());
		 
		 //will start by 12 clk

	}

}
