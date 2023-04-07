package com.amazon.testscenios;

import org.testng.annotations.Test;
import com.amazon.base.TestBase;
import com.amazon.pages.LoginPage;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class PlaceOrder extends TestBase{
	
  @Test
  
  public void loginTest() throws InterruptedException {
	  LoginPage loginPage=new LoginPage();
	 boolean actResult= loginPage.validateLogin("prachigadhave98@gmail.com", "124@Prachi");
	  Assert.assertTrue(actResult);
  }

  @Test
  public void searchProduct() {
	  Assert.assertTrue(false);
	  
  }
  
  @Test
  public void  selectProductTest() {
	  Assert.assertTrue(false);
  }
  
  @Test
  public void  addToCartTest() {
	  Assert.assertTrue(false);
  }
  @Test
  public void  makePaymentTest() {
	  Assert.assertTrue(false);
  }
  @Test
  public void  logOffTesttTest() {
	  Assert.assertTrue(false);
  }
  
  @BeforeClass
  public void beforeClass() {
	  launchBrowser();
	  navigateToURL();  
  }

  @AfterClass
  public void afterClass() {
  }

}
