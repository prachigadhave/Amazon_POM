package com.amazon.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.base.TestBase;

public class LoginPage  extends TestBase {
By singInLink=By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]");
By email=By.name("email");
By continueBtn=By.xpath("//*[@id=\"continue\"]");
By password=By.name("password");
By signInBtn=By.id("signInSubmit");

public  boolean validateLogin(String uname,String pwd)  {
	
	driver.findElement(singInLink).click();
	wait(3000);
	driver.findElement(email).sendKeys(uname);
	driver.findElement(continueBtn).click();
	wait(2000);
	driver.findElement(password).sendKeys(pwd);
	driver.findElement(signInBtn).click();
	WebDriverWait wait =new WebDriverWait (driver,Duration.ofSeconds(10));
	boolean actResult=true;
	try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")));
	}catch(TimeoutException te) {
		actResult=false;
		System.out.println("Screenshot for Login Failure");
	
	captureScreenshot();
	}
return actResult;	
}}
