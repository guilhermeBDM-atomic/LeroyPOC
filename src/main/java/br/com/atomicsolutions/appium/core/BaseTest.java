package br.com.atomicsolutions.appium.core;

import static br.com.atomicsolutions.appium.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {

	
	
	@Rule
	public TestName testName = new TestName();
	
	@AfterAll
	public static void tearDown() {
		DriverFactory.killDriver();
	}
	
	public void gerarPrint()
	{
		File imagem  = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(imagem, new File("target/screenshots/"+testName.getMethodName()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
