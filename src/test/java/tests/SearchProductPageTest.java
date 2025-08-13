package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.TestUtil;

public class SearchProductPageTest extends BaseTest {
  @Test(priority=1)
  public void testWithInvalidSearchData() {
	  try {
		  sleep(2);
		  
		  WebElement searchBar = driver.findElement(By.id("gh-ac"));
		  searchBar.clear();
		  searchBar.sendKeys("abckefghijabcdefghi");
		  
		  WebElement searchButton = driver.findElement(By.id("gh-search-btn"));
		  searchButton.click();
		  
		  String productMSG = driver.findElement(By.xpath("//h3[@class='srp-save-null-search__heading']")).getText();
		  
		  Assert.assertEquals(productMSG, "No exact matches found");
		  
		  TestUtil.takeScreenshot(driver, "testWithInvalidSearchData_success");
		  
		  System.out.println("✅ Did not found the product");
		  
	  } catch(Exception e) {
		  System.out.println("❌ testWithInvalidSearchData failed: " + e.getMessage());
		  TestUtil.takeScreenshot(driver, "testWithInvalidSearchData_failed");
		  Assert.fail();
	  }
  }
  
  @Test(priority=2)
  public void testWithValidSearchData() {
	  try {
		  sleep(2);
		  
		  WebElement searchBar = driver.findElement(By.id("gh-ac"));
		  searchBar.clear();
		  searchBar.sendKeys("laptop");
		  
		  WebElement searchButton = driver.findElement(By.id("gh-search-btn"));
		  searchButton.click();
		  
		  sleep(2);
		  JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("window.scrollBy(0, 800)");
          sleep(1);
          js.executeScript("window.scrollBy(0, 800)");
          sleep(1);
          js.executeScript("window.scrollBy(0, 800)");
          sleep(1);
          js.executeScript("window.scrollBy(0, 800)");
          sleep(1);
          js.executeScript("window.scrollBy(0, 800)");
          sleep(1);
		  
		  List<WebElement> items = driver.findElements(By.xpath("//ul[@class='srp-results srp-list clearfix']/li"));
		  
		  int count = 0;
		  if(items.size() >= 1) {
			  TestUtil.takeScreenshot(driver, "testWithValidSearchData_success");
			  System.out.println("✅ Search results found");
			  
			  for(WebElement item : items) {
				  if(count == 10) {
					  break;
				  }
				  
				  WebElement nameElement = item.findElement(By.xpath(".//div/div[2]/div/a/div/span"));
				  String itemName = nameElement.getText();
				  System.out.println("Item Name: " + itemName);
				  count++;
			  }
		  }
	  } catch(Exception e) {
		  System.out.println("❌ testWithValidSearchData failed: " + e.getMessage());
		  TestUtil.takeScreenshot(driver, "testWithValidSearchData_failed");
		  Assert.fail();
	  }
  }
  
  @Test(priority=3)
  public void testWithValidSearchDataAndFilters() {
	  try {
		  sleep(2);
		  
		  WebElement searchBar = driver.findElement(By.id("gh-ac"));
		  searchBar.clear();
		  searchBar.sendKeys("laptop");
		  
		  WebElement searchButton = driver.findElement(By.id("gh-search-btn"));
		  searchButton.click();
		  
		  WebElement checkBox16GB = driver.findElement(By.xpath("//input[@type='checkbox' and @aria-label='16 GB']"));
		  checkBox16GB.click();
		  
		  WebElement checkBox15Inch = driver.findElement(By.xpath("//input[@type='checkbox' and @aria-label='15-15.9 in']"));
		  checkBox15Inch.click();
		  
		  WebElement moreFilterButton = driver.findElement(By.xpath("(//button[@class='fake-link'])[last()]"));
		  moreFilterButton.click();
		  sleep(2);
		  
		  WebElement itemLocationButton = driver.findElement(By.xpath("//div[@id='c4-0-@dialog-16-1-@mainPanel-location']"));
		  itemLocationButton.click();
		  sleep(2);
		  
		  WebElement worldwideButton = driver.findElement(By.xpath("(//input[@type='radio' and @data-value='Worldwide'])[last()]"));
		  worldwideButton.click();
		  sleep(2);
		  
		  WebElement applyButton = driver.findElement(By.xpath("//button[@aria-label='Apply']"));
		  applyButton.click();
		  sleep(2);
		  
		  sleep(2);
		  JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("window.scrollBy(0, 800)");
          sleep(1);
          js.executeScript("window.scrollBy(0, 800)");
          sleep(1);
          js.executeScript("window.scrollBy(0, 800)");
          sleep(1);
          js.executeScript("window.scrollBy(0, 800)");
          sleep(1);
          js.executeScript("window.scrollBy(0, 800)");
          sleep(1);
		  
		  List<WebElement> items = driver.findElements(By.xpath("//ul[@class='srp-results srp-list clearfix']/li"));
		  
		  int count = 0;
		  if(items.size() >= 1) {
			  TestUtil.takeScreenshot(driver, "testWithValidSearchDataAndFilters_success");
			  System.out.println("✅ Search results found");
			  
			  for(WebElement item : items) {
				  if(count == 10) {
					  break;
				  }
				  
				  WebElement nameElement = item.findElement(By.xpath(".//div/div[2]/div[1]/a/div/span"));
				  String itemName = nameElement.getText();
				  System.out.println("Item Name: " + itemName);
				  count++;
			  }
		  }
	  } catch(Exception e) {
		  System.out.println("❌ testWithValidSearchDataAndFilters failed: " + e.getMessage());
		  TestUtil.takeScreenshot(driver, "testWithValidSearchDataAndFilters_failed");
		  Assert.fail();
	  }
  }
}
