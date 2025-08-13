package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.TestUtil;

public class HomePageTest extends BaseTest {

    @Test(priority = 1)
    public void testLogoPresence() {
        try {
        	sleep(2);
        	
            WebElement logo = driver.findElement(By.xpath("//*[@id=\"ebayLogoTitle\"]"));
            
            Assert.assertEquals(logo.getText(), "eBay Home");
            
            TestUtil.takeScreenshot(driver, "testLogoPresence_success");
            
            System.out.println("✅ Logo is present on homepage.");
        } catch (Exception e) {
            System.out.println("❌ testLogoPresence failed: " + e.getMessage());
            TestUtil.takeScreenshot(driver, "testLogoPresence_failed");
            Assert.fail();
        }
    }

    @Test(priority = 2)
    public void testSearchBarPresence() {
        try {
        	sleep(2);
        	
            WebElement searchBar = driver.findElement(By.id("gh-ac"));
            
            Assert.assertTrue(searchBar.isDisplayed(), "Search bar is not visible.");
            
            TestUtil.takeScreenshot(driver, "testSearchBarPresence_success");
            
            System.out.println("✅ Search bar is visible.");
        } catch (Exception e) {
            System.out.println("❌ testSearchBarPresence failed: " + e.getMessage());
            TestUtil.takeScreenshot(driver, "testSearchBarPresence_failed");
            Assert.fail();
        }
    }

    @Test(priority = 3)
    public void testCategoryDropdown() {
        try {
        	sleep(2);
        	
            WebElement dropdown = driver.findElement(By.id("gh-cat"));
            
            Assert.assertTrue(dropdown.isDisplayed(), "Category dropdown is not available.");
            
            TestUtil.takeScreenshot(driver, "testCategoryDropdown_success");
            
            System.out.println("✅ Category dropdown is visible.");
        } catch (Exception e) {
            System.out.println("❌ testCategoryDropdown failed: " + e.getMessage());
            TestUtil.takeScreenshot(driver, "testCategoryDropdown_failed");
            Assert.fail();
        }
    }

    @Test(priority = 4)
    public void testNavigationLinks() {
        try {
        	sleep(2);
        	
            WebElement dailyDeals = driver.findElement(By.linkText("Daily Deals"));
            WebElement helpContact = driver.findElement(By.linkText("Help & Contact"));
            WebElement brandOutlet = driver.findElement(By.linkText("Brand Outlet"));
            WebElement sell = driver.findElement(By.linkText("Sell"));
            
            Assert.assertTrue(dailyDeals.isDisplayed(), "Daily Deals link missing.");
            Assert.assertTrue(helpContact.isDisplayed(), "Help & Contact link missing.");
            Assert.assertTrue(brandOutlet.isDisplayed(), "Brand Outlet link missing.");
            Assert.assertTrue(sell.isDisplayed(), "Sell link missing.");
            
            TestUtil.takeScreenshot(driver, "testNavigationLinks_success");
            
            System.out.println("✅ Top navigation links are visible.");
        } catch (Exception e) {
            System.out.println("❌ testNavigationLinks failed: " + e.getMessage());
            TestUtil.takeScreenshot(driver, "testNavigationLinks_failed");
            Assert.fail();
        }
    }

    @Test(priority = 5)
    public void testSearchFunctionalityUI() {
        try {
        	sleep(2);
        	
            WebElement searchBar = driver.findElement(By.id("gh-ac"));
            WebElement searchBtn = driver.findElement(By.id("gh-search-btn"));
            searchBar.clear();
            searchBar.sendKeys("iPhone");
            sleep(3);
            searchBtn.click();
            
            Assert.assertTrue(driver.getTitle().contains("iPhone"), "Search did not redirect correctly.");
            
            TestUtil.takeScreenshot(driver, "testSearchFunctionalityUI_success");
            
            System.out.println("✅ Search functionality UI test passed.");
        } catch (Exception e) {
            System.out.println("❌ testSearchFunctionalityUI failed: " + e.getMessage());
            TestUtil.takeScreenshot(driver, "testSearchFunctionalityUI_failed");
            Assert.fail();
        }
    }
    
    @Test(priority = 6)
    public void testBrowseByCategory() {
    	try {
    		sleep(2);
        	
        	JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 300)");
            sleep(1);
        	
        	WebElement browseByCategoryHeading = driver.findElement(By.xpath("(//h2[@class='vl-card-header__headline'])[1]"));
        	String browseByCategoryHeadingText = browseByCategoryHeading.getText();
        	
        	List<WebElement> categories = driver.findElements(By.xpath("//ul[@id='s0-1-0-53-1-2-5-15-0[2]-10-@match-media-0-@ebay-carousel-list']//li//a//h3"));
        	
        	for(WebElement caterogy : categories) {
        		System.out.println(caterogy.getText());
        	}
        	
        	Assert.assertEquals(browseByCategoryHeadingText, "Browse by categories");
        	
        	TestUtil.takeScreenshot(driver, "testBrowseByCategory_success");
        	
        	System.out.println("✅ Browse By Categories is present on home page.");
    	} catch(Exception e) {
    		System.out.println("❌ testBrowseByCategory failed: " + e.getMessage());
            TestUtil.takeScreenshot(driver, "testBrowseByCategory_failed");
            Assert.fail();
    	}
    }
    
    @Test(priority = 7)
    public void tesrDiscoverRareFinds() {
    	try {
    		sleep(2);
        	
        	JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 300)");
            sleep(1);
            js.executeScript("window.scrollBy(0, 400)");
            sleep(1);
        	
        	WebElement discoverRareFindsHeading = driver.findElement(By.xpath("(//h2[@class='vl-card-header__headline'])[2]"));
        	String discoverRareFindsHeadingText = discoverRareFindsHeading.getText();
        	
        	List<WebElement> categories = driver.findElements(By.xpath("//ul[@id='s0-1-0-53-1-2-5-15-0[3]-10-@match-media-0-@ebay-carousel-list']//li//a//h3"));
        	
        	for(WebElement caterogy : categories) {
        		System.out.println(caterogy.getText());
        	}
        	
        	Assert.assertEquals(discoverRareFindsHeadingText, "Discover rare finds");
        	
        	TestUtil.takeScreenshot(driver, "tesrDiscoverRareFinds_success");
        	
        	System.out.println("✅ Discover rare finds is present on home page.");
    	} catch(Exception e) {
    		System.out.println("❌ tesrDiscoverRareFinds failed: " + e.getMessage());
            TestUtil.takeScreenshot(driver, "tesrDiscoverRareFinds_failed");
            Assert.fail();
    	}
    }
    
    @Test(priority = 8)
    public void tesrBestSellingBrands() {
    	try {
    		sleep(2);
        	
        	JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 300)");
            sleep(1);
            js.executeScript("window.scrollBy(0, 400)");
            sleep(1);
            js.executeScript("window.scrollBy(0, 400)");
            sleep(1);
        	
        	WebElement bestSellingBrandsHeading = driver.findElement(By.xpath("(//h2[@class='vl-card-header__headline'])[3]"));
        	String bestSellingBrandsHeadingText = bestSellingBrandsHeading.getText();
        	
        	List<WebElement> categories = driver.findElements(By.xpath("//ul[@id='s0-1-0-53-1-2-5-15-0[4]-10-@match-media-0-@ebay-carousel-list']//li//a//h3"));
        	
        	for(WebElement caterogy : categories) {
        		System.out.println(caterogy.getText());
        	}
        	
        	Assert.assertEquals(bestSellingBrandsHeadingText, "Best-selling brands on eBay");
        	
        	TestUtil.takeScreenshot(driver, "tesrBestSellingBrands_success");
        	
        	System.out.println("✅ Best-selling brands on eBay is present on home page.");
    	} catch(Exception e) {
    		System.out.println("❌ tesrBestSellingBrands failed: " + e.getMessage());
            TestUtil.takeScreenshot(driver, "tesrBestSellingBrands_failed");
            Assert.fail();
    	}
    }
    
    @Test(priority = 9)
    public void testFooterLinks() {
        try {
        	sleep(2);
        	
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            sleep(2);

            List<WebElement> footerLinks = driver.findElements(By.xpath("//footer//a"));

            System.out.println("Total footer links found: " + footerLinks.size());
            
            Assert.assertTrue(footerLinks.size() > 0, "No footer links found.");

            for (WebElement link : footerLinks) {
                String linkText = link.getText().trim();
                String href = link.getAttribute("href");

                System.out.println("Text: " + linkText + " | URL: " + href);

                Assert.assertNotNull(href, "Link has null href");
                Assert.assertFalse(href.isEmpty(), "Link has empty href");
            }

            TestUtil.takeScreenshot(driver, "FooterLinks_Success");

            System.out.println("✅ All footer links verified successfully.");

        } catch (Exception e) {
            System.out.println("❌ testFooterLinks failed: " + e.getMessage());
            TestUtil.takeScreenshot(driver, "FooterLinks_Failed");
            Assert.fail();
        }
    }

}
