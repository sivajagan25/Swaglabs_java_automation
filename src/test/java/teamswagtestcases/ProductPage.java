package teamswagtestcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Teamswaglabproject.Cart;
import Teamswaglabproject.ProductPageLocators;
import swaglabs.Reportslog;
 
//@Listeners(ExtentReport.class)
 
@Test
public class ProductPage {
	
	
	WebDriver driver;
    Cart cartPage;
    ExtentReports extent;
    ExtentTest test;
	 @BeforeClass
	    public void setupReport() {
	    	ExtentReports extent = Reportslog.getReportInstance();
	    }
	 
	    // Runs before each test
	    @BeforeMethod
	    public void setup() {
	        System.out.println("Launching browser and navigating to SauceDemo...");
	        System.setProperty("webdriver.edge.driver", "C:\\Users\\sivajagan.d\\eclipse-workspace\\test\\Resource\\msedgedriver.exe");
	        driver = new EdgeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.saucedemo.com/");
	 
	        System.out.println("Logging in...");
	        driver.findElement(By.id("user-name")).sendKeys("standard_user");
	        driver.findElement(By.id("password")).sendKeys("secret_sauce");
	        driver.findElement(By.id("login-button")).click();
	 
	       
	    }
	 
 
@Test   //(dependsOnMethods = "testLogin")
    public void testProductImageDisplay() {
        ProductPageLocators productpg = new ProductPageLocators(driver);
        productpg.productImageDisplay();
        Reporter.log("Product Image is displayed", true);
    }
 
 
@Test//(dependsOnMethods = "testLogin")
    public void testProductImageNavigation() {
        ProductPageLocators productpg = new ProductPageLocators(driver);
        String actualURL = productpg.productImageNavigation();
        String expectedURL = "https://www.saucedemo.com/inventory-item.html?id=4";
        Assert.assertEquals(actualURL, expectedURL, "Product image navigation URL mismatch");
        Reporter.log("Navigated to description page", true);
        driver.navigate().back();
    }
 
 
@Test//(dependsOnMethods = "testLogin")
    public void testProductNameNavigation() {
        ProductPageLocators productpg = new ProductPageLocators(driver);
        String actualURL = productpg.productNameNavigation();
        String expectedURL = "https://www.saucedemo.com/inventory-item.html?id=4";
        Assert.assertEquals(actualURL, expectedURL, "Product name navigation URL mismatch");
        Reporter.log("Navigated to description page", true);
//        driver.navigate().back();
        productpg.AddToCart();
        productpg.backproduct();
        
        
    }
 
@Test //(dependsOnMethods = "testLogin")
public void checkDropDown() {
	ProductPageLocators productpg = new ProductPageLocators(driver);
	productpg.dropdown();
}
 
@Test(dependsOnMethods = "testLogin")
    public void testCartIconNavigation() {
        ProductPageLocators productpg = new ProductPageLocators(driver);
        String actualURL = productpg.cartIconClick();
        String expectedURL = "https://www.saucedemo.com/cart.html";
        Assert.assertEquals(actualURL, expectedURL, "Cart icon navigation URL mismatch");
        Reporter.log("Navigated to add to cart page", true);
        driver.navigate().back();
    }
 
 
@Test(dependsOnMethods = "testLogin")
    public void verifyCartCountIncrease() {
        ProductPageLocators productpg = new ProductPageLocators(driver);
        int initialCount = productpg.getCartCount();
        productpg.AddToCart();
        int updatedCount = productpg.getCartCount();
        Assert.assertEquals(updatedCount, initialCount + 1, "Cart count could not increased after adding");
        Reporter.log("Cart count increased after adding product", true);
    }
 
@Test(dependsOnMethods = {"verifyCartCountIncrease"})
public void verifyCartCountDecrease() {
    ProductPageLocators productpg = new ProductPageLocators(driver);
    SoftAssert softAssert = new SoftAssert();
    int initialCount = productpg.getCartCount();
 
 
    productpg.RemoveFromCart();
    int updatedCount = productpg.getCartCount();
 
    if (initialCount > 1) {
        Assert.assertEquals(updatedCount, initialCount - 1, "Cart count not decreased correctly after removing a product.");
        Reporter.log("Cart count decreased correctly from " + initialCount + " to " + updatedCount, true);
    } else if (initialCount == 1) {
        Assert.assertEquals(updatedCount, 0, "Cart should be empty after removing the last product.");
        Reporter.log("Cart is empty after removing the last product", true);
}
    else {
          
          softAssert.fail("Initial cart count was zero, nothing to remove.");
    }
}
 
 
 
 
 
 
//	@AfterClass
//	public void closeBrowser() {
//		driver.quit();
//		System.out.println("Test Execution Completed");
//	}
	
}
 
