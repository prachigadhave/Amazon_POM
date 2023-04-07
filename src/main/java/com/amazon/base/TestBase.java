package com.amazon.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	FileInputStream fis;
	public static WebDriver driver;
	Properties prop;

	public void launchBrowser() {
		String fileName = ".\\src\\main\\resources\\Config\\config.properties";
		try {
			fis = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (prop.getProperty("Browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (prop.getProperty("Browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
	}

	public void navigateToURL() {
		driver.get(prop.getProperty("URL"));
	}

	public void captureScreenshot() {
		Date date=new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyMMd_HHmmss");
		String scrnShotName="scrrenshot_"+sdf.format(date)+".png";//
		TakesScreenshot srcnShot=(TakesScreenshot) driver;
		File srcFile =srcnShot.getScreenshotAs(OutputType.FILE);
		File destFile=new File(".\\src\\test\\resources\\Screenshots\\"+scrnShotName);//screenshot_20230406_100215
		try {
			FileUtils.copyFile(srcFile, destFile);
		}catch(IOException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void wait(int msec) {
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}