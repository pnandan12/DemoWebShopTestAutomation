package com.app.qa.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import com.app.qa.base.TestBase;

public class TestUtils extends TestBase {
	public static long Page_Load_Timeout=30;
	public static long Implicity_Wait=50;
	public static void screenShot() {
		try {
			FileUtils.deleteDirectory(new File(prop.getProperty("screenShotPath")));
			File img = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentDir=prop.getProperty("screenShotPath");
			FileUtils.copyFile(img,  new File( currentDir+"Failed"+System.currentTimeMillis() + ".png"));
			
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
