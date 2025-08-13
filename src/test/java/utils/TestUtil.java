package utils;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtil {
    public static void takeScreenshot(WebDriver driver, String fileName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "./screenshots/" + fileName + "_" + System.currentTimeMillis() + ".png";
            File dest = new File(path);
            dest.getParentFile().mkdirs(); // create screenshots folder if not present
            FileUtils.copyFile(src, dest); // <- Simple and clean
            System.out.println("📸 Screenshot saved: " + path);
        } catch (Exception e) {
            System.out.println("❌ Screenshot failed: " + e.getMessage());
        }
    }
}
