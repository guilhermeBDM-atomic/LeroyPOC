package br.com.atomicsolutions.appium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {
	
	private static AndroidDriver<MobileElement> driver;
	
	public static AndroidDriver<MobileElement> getDriver()
	{
		if (driver == null) {
			createDriver();
		}
		return driver;
	}
	
	private static void createDriver()
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		//desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:/Users/Guilherme/eclipse-workspace/CursoAppium/src/main/resources/CTAppium.apk");
		desiredCapabilities.setCapability("appPackage", "br.com.leroymerlin");
	    desiredCapabilities.setCapability("appActivity", "br.com.leroymerlin.MainActivity");
//	    desiredCapabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
	    desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);


		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void killDriver()
	{
		if(driver!=null)
		{
			driver.quit();
			driver=null;
			
		}
		
		
	}
	
}
