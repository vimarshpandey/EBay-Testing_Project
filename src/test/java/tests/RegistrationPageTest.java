package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.TestUtil;

public class RegistrationPageTest extends BaseTest {
  @Test(priority=1)
  public void testRegisterPageLoading() {
	  try {
		  sleep(2);
		  
		  WebElement registerLink = driver.findElement(By.linkText("register"));
		  registerLink.click();
		  
		  String greetingMSG = driver.findElement(By.tagName("h1")).getText();
		  
		  Assert.assertEquals(greetingMSG, "Create an account");
		  
		  TestUtil.takeScreenshot(driver, "testRegisterLoading_success");
		  
		  System.out.println("✅ Register page loaded successfully");
		  
	  } catch(Exception e) {
		  System.out.println("❌ testRegisterPageLoading failed: " + e.getMessage());
		  TestUtil.takeScreenshot(driver, "testRegisterLoading_failed");
		  Assert.fail();
	  }
  }
  
  @Test(priority=2)
  public void testRegisterWithValidData() {
	  try {
		  sleep(2);
		  
		  WebElement registerLink = driver.findElement(By.linkText("register"));
		  registerLink.click();
		  
		  WebElement personalTab = driver.findElement(By.id("personalaccount-radio"));
		  personalTab.click();
		  
		  WebElement firstNameField = driver.findElement(By.id("firstname"));
		  firstNameField.clear();
		  firstNameField.sendKeys("Vimarsh");
		  
		  WebElement lastNameField = driver.findElement(By.id("lastname"));
		  lastNameField.clear();
		  lastNameField.sendKeys("Pandey");
		  
		  WebElement emailField = driver.findElement(By.id("Email"));
		  emailField.clear();
		  emailField.sendKeys("vimarsh240501@gmail.com");
		  
		  WebElement passwordField = driver.findElement(By.id("password"));
		  passwordField.clear();
		  passwordField.sendKeys("REDtiles@2001");
		  sleep(5);
		  
		  WebElement submitButton = driver.findElement(By.id("EMAIL_REG_FORM_SUBMIT"));
		  submitButton.click();
		  sleep(20); //time for entering captcha
		  
		  WebElement phoneNumberField = driver.findElement(By.id("phoneCountry"));
		  phoneNumberField.sendKeys("7897294086");
		  
		  WebElement continueButton = driver.findElement(By.id("SEND_AUTH_CODE"));
		  continueButton.click();
		  sleep(30); //time for entering OTP send on mobile number
		  
		  String currentURL = driver.getCurrentUrl();
		  if(currentURL.contains("signin") ) {
			  System.out.println("Did not directed to Home Page");
		  } else {
			  TestUtil.takeScreenshot(driver, "testRegisterWithValidData_success");
			  System.out.println("✅ Registration successfull");
			  System.out.println("Directed to Home Page");
		  }
		  
	  } catch(Exception e) {
		  System.out.println("❌ testRegisterWithValidData failed: " + e.getMessage());
		  TestUtil.takeScreenshot(driver, "testRegisterWithValidData_failed");
		  Assert.fail();
	  }
  }
  
  @Test(priority=3)
  public void testRegisterWithAlreadyRegisteredData() {
	  try {
		  sleep(2);
		  
		  WebElement registerLink = driver.findElement(By.linkText("register"));
		  registerLink.click();
		  
		  WebElement personalTab = driver.findElement(By.id("personalaccount-radio"));
		  personalTab.click();
		  
		  WebElement firstNameField = driver.findElement(By.id("firstname"));
		  firstNameField.clear();
		  firstNameField.sendKeys("Vimarsh");
		  
		  WebElement lastNameField = driver.findElement(By.id("lastname"));
		  lastNameField.clear();
		  lastNameField.sendKeys("Pandey");
		  
		  WebElement emailField = driver.findElement(By.id("Email"));
		  emailField.clear();
		  emailField.sendKeys("vimpandey2001@gmail.com");
		  
		  WebElement passwordField = driver.findElement(By.id("password"));
		  passwordField.clear();
		  passwordField.sendKeys("REDtiles@2001");
		  sleep(5);
		  
		  WebElement submitButton = driver.findElement(By.id("EMAIL_REG_FORM_SUBMIT"));
		  submitButton.click();
		  sleep(20); //time for entering captcha
		  
		  String errorMSG = driver.findElement(By.tagName("h1")).getText();
		  
		  Assert.assertEquals(errorMSG, "An account already exists");
		  
		  TestUtil.takeScreenshot(driver, "testRegisterWithAlreadyRegisteredData_success");
		  
		  System.out.println("✅ Already registered message displayed");
		  
	  } catch(Exception e) {
		  System.out.println("❌ testRegisterWithAlreadyRegisteredData failed: " + e.getMessage());
		  TestUtil.takeScreenshot(driver, "testRegisterWithAlreadyRegisteredData_failed");
		  Assert.fail();
	  }
  }
  
  @Test(priority=4)
  public void testRegisterWithSomeBlankFields() {
	  try {
		  sleep(2);
		  
		  WebElement registerLink = driver.findElement(By.linkText("register"));
		  registerLink.click();
		  
		  WebElement personalTab = driver.findElement(By.id("personalaccount-radio"));
		  personalTab.click();
		  
		  WebElement firstNameField = driver.findElement(By.id("firstname"));
		  firstNameField.clear();
		  firstNameField.sendKeys("Vimarsh");
		  
		  WebElement lastNameField = driver.findElement(By.id("lastname"));
		  lastNameField.clear();
		  lastNameField.sendKeys("Pandey");
		  
		  WebElement passwordField = driver.findElement(By.id("password"));
		  passwordField.clear();
		  passwordField.sendKeys("REDtiles@2001");
		  sleep(5);
		  
		  WebElement submitButtton = driver.findElement(By.id("EMAIL_REG_FORM_SUBMIT"));
		  
		  Assert.assertFalse(submitButtton.isEnabled(), "Submit button should be disabled");
		  
		  TestUtil.takeScreenshot(driver, "testRegisterWithSomeBlankFields_success");
		  
		  System.out.println("✅ Already registered message displayed");
		  
	  } catch(Exception e) {
		  System.out.println("❌ testRegisterWithSomeBlankFields failed: " + e.getMessage());
		  TestUtil.takeScreenshot(driver, "testRegisterWithSomeBlankFields_failed");
		  Assert.fail();
	  }
  }
}
