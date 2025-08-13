package tests;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.TestUtil;

public class PurchasingandSellingTest extends BaseTest {
  @Test(priority=1)
  public void addingMultipleProductToCart() {
	  try {
		  sleep(2);
		  
		  WebElement appleButton = driver.findElement(By.xpath("//h3[text()='Apple']"));
		  appleButton.click();
		  
		  WebElement macMiniElement = driver.findElement(By.xpath("//span[text()='Mac Mini (2018)']"));
		  macMiniElement.click();
		  
		  List<WebElement> macMiniList = driver.findElements(By.xpath("//ul[@class='brwrvr__item-results brwrvr__item-results--list']/li"));
		  
		  for(WebElement macMini : macMiniList) {
			  WebElement nameElement = macMini.findElement(By.xpath(".//div/div/div[2]/div/div/span/a/h3"));
			  String macMiniName = nameElement.getText();
			  if(macMiniName.contains("Mac mini 3.6GHz i3 8GB 256GB")) {
				  nameElement.click();
				  sleep(2);
				  break;
			  }
		  }
		  
		  WebElement quantity = driver.findElement(By.id("qtyTextBox"));
		  quantity.clear();
		  quantity.sendKeys("2");
		  
		  WebElement addToCart1 = driver.findElement(By.id("atcBtn_btn_1"));
		  addToCart1.click();
		  sleep(5);
		  
		  WebElement seeInCart1 = driver.findElement(By.xpath("(//a[@class='ux-call-to-action fake-btn fake-btn--primary'])[1]"));
		  seeInCart1.click();
		  
		  String price = driver.findElement(By.xpath("//div[@data-test-id='SUBTOTAL']/span/span/span")).getText();
		  Assert.assertEquals(price, "US $993.20");
		  System.out.println("Total price is: " + price);
		  
		  WebElement checkoutButton = driver.findElement(By.xpath("//button[@data-test-id='cta-top']"));
		  checkoutButton.click();
		  
		  WebElement guestButton = driver.findElement(By.id("gxo-btn"));
		  guestButton.click();
		  
		  WebElement confirmAndPayButton = driver.findElement(By.xpath("//button[@data-test-id='CONFIRM_AND_PAY_BUTTON']"));
		  confirmAndPayButton.click();
		  
		  String errorMSG = driver.findElement(By.xpath("//h2[@class='page-notice__title']/span")).getText();
		  
		  Assert.assertEquals(errorMSG, "Add your shipping details and click Done");
		  
		  TestUtil.takeScreenshot(driver, "addingMultipleProductToCart_success");
		  
		  System.out.println("✅ Element added to cart and error message displayed");
		  sleep(2);
		  
	  } catch(Exception e) {
		  System.out.println("❌ addingMultipleProductToCart failed: " + e.getMessage());
		  TestUtil.takeScreenshot(driver, "addingMultipleProductToCart_failed");
		  Assert.fail();
	  }
  }
  
  @Test(priority=2)
  public void addingDifferentMultipleProductTo() {
	  try {
		  sleep(2);
		  
		  WebElement appleButton = driver.findElement(By.xpath("//h3[text()='Apple']"));
		  appleButton.click();
		  
		  WebElement macMiniElement = driver.findElement(By.xpath("//span[text()='Mac Mini (2018)']"));
		  macMiniElement.click();
		  
		  List<WebElement> macMiniList = driver.findElements(By.xpath("//ul[@class='brwrvr__item-results brwrvr__item-results--list']/li"));
		  
		  for(WebElement macMini : macMiniList) {
			  WebElement nameElement = macMini.findElement(By.xpath(".//div/div/div[2]/div/div/span/a/h3"));
			  String macMiniName = nameElement.getText();
			  if(macMiniName.contains("Mac mini 3.6GHz i3 8GB 256GB")) {
				  nameElement.click();
				  sleep(2);
				  break;
			  }
		  }
		  
		  WebElement addToCart1 = driver.findElement(By.id("atcBtn_btn_1"));
		  addToCart1.click();
		  sleep(5);
		  
		  WebElement seeInCart1 = driver.findElement(By.xpath("(//a[@class='ux-call-to-action fake-btn fake-btn--primary'])[1]"));
		  seeInCart1.click();
		  
		  WebElement secondItem = driver.findElement(By.xpath("//ul[@class='carousel__list']/li[3]"));
		  secondItem.click();
		  
		  String originalTab = driver.getWindowHandle();
		  sleep(2);
		  
		  Set<String> windowHandels = driver.getWindowHandles();
		  for(String handel : windowHandels) {
			  if(!handel.equals(originalTab)) {
				  driver.switchTo().window(handel);
				  break;
			  }
		  }
		  
		  WebElement addToCart2 = driver.findElement(By.id("atcBtn_btn_1"));
		  addToCart2.click();
		  sleep(5);
		  
		  WebElement seeInCart2 = driver.findElement(By.xpath("(//a[@class='ux-call-to-action fake-btn fake-btn--primary'])[1]"));
		  seeInCart2.click();
		  
		  List<WebElement> items = driver.findElements(By.xpath("//ul[@class='cart-bucket__vendor-list']"));
		  int size = items.size();
		  
		  Assert.assertEquals(size, 2);
		  
		  TestUtil.takeScreenshot(driver, "addingDifferentMultipleProductTo_success");
		  
		  System.out.println("✅ Two elements are added to cart successfully");
		  
	  } catch(Exception e) {
		  System.out.println("❌ addingDifferentMultipleProductTo failed: " + e.getMessage());
		  TestUtil.takeScreenshot(driver, "addingDifferentMultipleProductTo_failed");
		  Assert.fail();
	  }
  }
  
  @Test(priority=3)
  public void sellingProduct() {
	  try {
		  sleep(2);
		  
		  WebElement sellButton = driver.findElement(By.xpath("//a[@aria-label='Sell']"));
		  sellButton.click();
		  
		  String header = driver.findElement(By.xpath("//h2[@class='textual-display hero__title']")).getText();
		  
		  Assert.assertEquals(header, "Make money selling on eBay");
		  
		  List<WebElement> navigationLinks = driver.findElements(By.xpath("//nav[@class='header-links']/ul/li/a"));
		  
		  for(WebElement link : navigationLinks) {
			  if(link.getText().equals("My eBay")) {
				  continue;
			  }
			  link.click();
			  sleep(2);
		  }
		  
		  WebElement searchBar = driver.findElement(By.xpath("//input[@aria-label=\"Tell us what you're selling\"]"));
		  searchBar.clear();
		  searchBar.sendKeys("Dell G15");
		  
		  List<WebElement> searchItems = driver.findElements(By.xpath("//div[@class=\"suggestion-list\"]/div/button/span[2]"));
		  
		  for(WebElement item1 : searchItems) {
			  if(item1.getText().contains("5520")) {
				  item1.click();
			  }
		  }
		  
		  WebElement searchButton = driver.findElement(By.xpath("//button[@aria-label='Search']"));
		  searchButton.click();
		  
		  WebElement screenSizeButton = driver.findElement(By.xpath("//button[@name='Screen Size']"));
		  screenSizeButton.click();
		  
		  WebElement sizeCheckBox = driver.findElement(By.xpath("//input[@value='15.6 in']"));
		  sizeCheckBox.click();
		  sleep(4);
		  
		  List<WebElement> items = driver.findElements(By.xpath("//ul[@class='card-container__list']/li/button/div[2]/div"));
		  
		  for(WebElement item2 : items) {
			  System.out.println(item2.getText());
		  }
		  
		  TestUtil.takeScreenshot(driver, "sellingProduct_success");
		  
		  System.out.println("✅ Products to sell are displaying successfully");
		  
	  } catch(Exception e) {
		  System.out.println("❌ sellingProduct failed: " + e.getMessage());
		  TestUtil.takeScreenshot(driver, "sellingProduct_failed");
		  Assert.fail();
	  }
  }
}
