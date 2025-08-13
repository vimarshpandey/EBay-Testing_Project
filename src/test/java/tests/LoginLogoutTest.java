package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.TestUtil;

public class LoginLogoutTest extends BaseTest {
	
  @Test(priority = 1)
  public void testLoginPageLoading() {
	  try {
		  sleep(2);
		  
		  WebElement signInLink = driver.findElement(By.linkText("Sign in"));
		  signInLink.click();
		  
		  sleep(2);
		  
		  String greetingMSG = driver.findElement(By.tagName("h1")).getText();
		  
		  Assert.assertEquals(greetingMSG, "Sign in to your account");
		  
		  TestUtil.takeScreenshot(driver, "testLoginLoading_success");
		  
		  System.out.println("✅ Login page loaded successfully");
		  
	  } catch(Exception e) {
		System.out.println("❌ testLoginPageLoading failed: " + e.getMessage());
		TestUtil.takeScreenshot(driver, "testLoginLoading_failed");
		Assert.fail();
	  }
  }
  
  @Test(priority = 2)
  public void testLoginWithValidUsernameAndPassword() {
	  try {
		  sleep(2);
		  
		  WebElement signInLink = driver.findElement(By.linkText("Sign in"));
		  signInLink.click();
		  
		  WebElement username = driver.findElement(By.id("userid"));
		  username.sendKeys("vimpandey2001@gmail.com");
		  
		  WebElement usernameSubmitButton = driver.findElement(By.id("signin-continue-btn"));
		  usernameSubmitButton.click();
		  
		  WebElement password = driver.findElement(By.id("pass"));
		  password.sendKeys("");  //enter password
		  
		  WebElement passwordSubmitButton = driver.findElement(By.id("sgnBt"));
		  passwordSubmitButton.click();
		  
		  sleep(30); //time to enter OTP sent on mobile number
		  
		  String currentURL = driver.getCurrentUrl();
		  if(currentURL.contains("signin") ) {
			  System.out.println("Did not directed to Home Page");
		  } else {
			  TestUtil.takeScreenshot(driver, "testLoginWithValidUsernameAndPassword_success");
			  System.out.println("✅ Logged in successfully");
			  System.out.println("Directed to Home Page");
		  }
		  
	  } catch(Exception e) {
		System.out.println("❌ testLoginWithValidUsernameAndPassword failed: " + e.getMessage());
		TestUtil.takeScreenshot(driver, "testLoginWithValidUsernameAndPassword_failed");
		Assert.fail();
	  }
  }
  
  @Test(priority=4)
  public void testLoginWithInvalidUsername() {
	  try {
		  sleep(2);
		  
		  WebElement signInLink = driver.findElement(By.linkText("Sign in"));
		  signInLink.click();
		  
		  WebElement username = driver.findElement(By.id("userid"));
		  username.sendKeys("gmail.com");
		  
		  WebElement usernameSubmitButton = driver.findElement(By.id("signin-continue-btn"));
		  usernameSubmitButton.click();
		  
		  String errorMSG = driver.findElement(By.id("signin-error-msg")).getText();
		  Assert.assertEquals(errorMSG, "We couldn't find this eBay account. Try again or create an account.");
		  
		  sleep(5);
		  
		  String currentURL = driver.getCurrentUrl();
		  if(currentURL.contains("signin") ) {
			  TestUtil.takeScreenshot(driver, "testLoginWithInvalidUsername_Success");
			  System.out.println("✅ Did not logged in");
			  System.out.println("Did not directed to Home Page");
		  } else {
			  System.out.println("❌ Directed to Home Page");
		  }
	  } catch(Exception e) {
		System.out.println("❌ testLoginWithInvalidUsername failed: " + e.getMessage());
		TestUtil.takeScreenshot(driver, "testLoginWithInvalidUsername_Failed");
		Assert.fail();
	  }
  }
  
  @Test(priority=5)
  public void testLoginWithaVlidUsernameandInvalidPassword() {
	  try {
		  sleep(2);
		  
		  WebElement signInLink = driver.findElement(By.linkText("Sign in"));
		  signInLink.click();
		  
		  WebElement username = driver.findElement(By.id("userid"));
		  username.sendKeys("vimpandey2001@gmail.com");
		  
		  WebElement usernameSubmitButton = driver.findElement(By.id("signin-continue-btn"));
		  usernameSubmitButton.click();
		  
		  WebElement password = driver.findElement(By.id("pass"));
		  password.sendKeys("Invalid Password");
		  
		  WebElement passwordSubmitButton = driver.findElement(By.id("sgnBt"));
		  passwordSubmitButton.click();
		  
		  String errorMSG = driver.findElement(By.id("signin-error-msg")).getText();
		  Assert.assertEquals(errorMSG, "This password is incorrect. Try again or reset password.");
		  
		  sleep(5);
		  
		  String currentURL = driver.getCurrentUrl();
		  if(currentURL.contains("signin") ) {
			  TestUtil.takeScreenshot(driver, "testLoginWithaVlidUsernameandInvalidPassword_success");
			  System.out.println("✅ Did not logged in");
			  System.out.println("Did not directed to Home Page");
		  } else {
			  System.out.println("❌ Directed to Home Page");
		  }
	  } catch(Exception e) {
		System.out.println("❌ testLoginWithaVlidUsernameandInvalidPassword failed: " + e.getMessage());
		TestUtil.takeScreenshot(driver, "testLoginWithaVlidUsernameandInvalidPassword_failed");
		Assert.fail();
	  }
  }
  
  @Test(priority=6)
  public void testLoginWithaBlankUsernameand() {
	  try {
		  sleep(2);
		  
		  WebElement signInLink = driver.findElement(By.linkText("Sign in"));
		  signInLink.click();
		  
		  WebElement username = driver.findElement(By.id("userid"));
		  username.sendKeys("");
		  
		  WebElement usernameSubmitButton = driver.findElement(By.id("signin-continue-btn"));
		  usernameSubmitButton.click();
		  
		  String errorMSG = driver.findElement(By.id("signin-error-msg")).getText();
		  Assert.assertEquals(errorMSG, "Oops, that's not a match.");
		  
		  sleep(5);
		  
		  String currentURL = driver.getCurrentUrl();
		  if(currentURL.contains("signin") ) {
			  TestUtil.takeScreenshot(driver, "testLoginWithaBlankUsernameand_success");
			  System.out.println("✅ Did not logged in");
			  System.out.println("Did not directed to Home Page");
		  } else {
			  System.out.println("❌ Directed to Home Page");
		  }
	  } catch(Exception e) {
		System.out.println("❌ testLoginWithaBlankUsernameand failed: " + e.getMessage());
		TestUtil.takeScreenshot(driver, "testLoginWithaBlankUsernameand_failed");
		Assert.fail();
	  }
  }
  
  @Test(priority=7)
  public void testLoginWithaValidUsernameandAndBlankPassword() {
	  try {
		  sleep(2);
		  
		  WebElement signInLink = driver.findElement(By.linkText("Sign in"));
		  signInLink.click();
		  
		  WebElement username = driver.findElement(By.id("userid"));
		  username.sendKeys("vimpandey2001@gmail.com");
		  
		  WebElement usernameSubmitButton = driver.findElement(By.id("signin-continue-btn"));
		  usernameSubmitButton.click();
		  
		  WebElement password = driver.findElement(By.id("pass"));
		  password.sendKeys("");
		  
		  WebElement passwordSubmitButton = driver.findElement(By.id("sgnBt"));
		  Assert.assertFalse(passwordSubmitButton.isEnabled(), "Sign in button should be disabled");
		  
		  sleep(5);
		  
		  String currentURL = driver.getCurrentUrl();
		  if(currentURL.contains("signin") ) {
			  TestUtil.takeScreenshot(driver, "testLoginWithaValidUsernameandAndBlankPassword_success");
			  System.out.println("✅ Did not logged in");
			  System.out.println("Did not directed to Home Page");
		  } else {
			  System.out.println("❌ Directed to Home Page");
		  }
	  } catch(Exception e) {
		System.out.println("❌ testLoginWithaValidUsernameandAndBlankPassword failed: " + e.getMessage());
		TestUtil.takeScreenshot(driver, "testLoginWithaValidUsernameandAndBlankPassword_failed");
		Assert.fail();
	  }
  }
  
  @Test(priority=8)
  public void testLogoutFunctionality() {
	  try {
		  sleep(2);
		  
		  WebElement signInLink = driver.findElement(By.linkText("Sign in"));
		  signInLink.click();
		  
		  WebElement username = driver.findElement(By.id("userid"));
		  username.sendKeys("vimpandey2001@gmail.com");
		  
		  WebElement usernameSubmitButton = driver.findElement(By.id("signin-continue-btn"));
		  usernameSubmitButton.click();
		  
		  WebElement password = driver.findElement(By.id("pass"));
		  password.sendKeys("");  //enter password
		  
		  WebElement passwordSubmitButton = driver.findElement(By.id("sgnBt"));
		  passwordSubmitButton.click();
		  
//		  WebElement sendButton = driver.findElement(By.id("send-button"));
//		  sendButton.click();
		  
		  sleep(40); //time for entering OTP from email
		  
		  WebElement hoverElement = driver.findElement(By.className("gh-identity__greeting"));
		  Actions actions = new Actions(driver);
		  actions.moveToElement(hoverElement).perform();
		  
		  WebElement signout = driver.findElement(By.linkText("Sign out"));
		  signout.click();
		  
		  sleep(3);
		  
		  String currentURL = driver.getCurrentUrl();
		  if(currentURL.contains("signin") ) {
			  TestUtil.takeScreenshot(driver, "testLogoutFunctionality_success");
			  System.out.println("✅ Logged Out");
			  System.out.println("Directed to Sign in Page");
		  } else {
			  System.out.println("❌ Did not logged out");
		  }
	  } catch(Exception e) {
		System.out.println("❌ testLogoutFunctionality failed: " + e.getMessage());
		TestUtil.takeScreenshot(driver, "testLogoutFunctionality_failed");
		Assert.fail();
	  }
  }
}
