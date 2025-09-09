package teamswagtestcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Teamswaglabproject.Cart;
import swaglabs.Reportslog;

//import Utilities.ExtentReportManager;
import com.aventstack.extentreports.*;
 
public class Carttestcase {
 
    WebDriver driver;
    Cart cartPage;
    ExtentReports extent;
    ExtentTest test;
 
    // Runs once before all tests
    @BeforeClass
    public void setupReport() {
    	extent = Reportslog.getReportInstance();
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
 
        System.out.println("Adding item to cart...");
        cartPage = new Cart(driver);
        cartPage.addItemToCart();
    }
 
    @Test
    public void testCartPageLoads() {
        test = extent.createTest("Cart Page Loads");
        System.out.println("Test: Checking if cart page is loaded...");
        Assert.assertTrue(cartPage.isCartPageLoaded(), "Cart page should be loaded");
        test.pass("Cart page loaded successfully");
    }
 
    @Test
    public void testItemsDisplayedInCart() {
        test = extent.createTest("Items Displayed in Cart");
        System.out.println("Test: Checking if items are displayed in cart...");
        Assert.assertTrue(cartPage.getCartItemCount() > 0, "Cart should have items");
        test.pass("Items are displayed in the cart");
    }
 
    @Test
    public void testRemoveItems() {
        test = extent.createTest("Remove Items from Cart");
        System.out.println("Test: Removing items from cart...");
        cartPage.removeAllItems();
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart should be empty after removing items");
        test.pass("Items removed successfully");
    }
 
    @Test
    public void testContinueShoppingButton() {
        test = extent.createTest("Continue Shopping Button");
        System.out.println("Test: Clicking continue shopping button...");
        cartPage.clickContinueShopping();
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Should go to inventory page");
        test.pass("Navigated to inventory page");
    }
 
    @Test
    public void testCheckoutButton() {
        test = extent.createTest("Checkout Button");
        System.out.println("Test: Clicking checkout button...");
        cartPage.clickCheckout();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one"), "Should go to checkout page");
        test.pass("Navigated to checkout page");
    }
 
    @Test
    public void testCartBadgeCountMatchesItems() {
        test = extent.createTest("Cart Badge Count Matches Items");
        System.out.println("Test: Checking cart badge count...");
        String badgeCount = cartPage.getCartBadgeCount();
        int itemCount = cartPage.getCartItemCount();
        Assert.assertEquals(Integer.parseInt(badgeCount), itemCount, "Badge count should match item count");
        test.pass("Cart badge count matches item count");
    }
 
    @Test
    public void testCheckoutWithEmptyCart() {
        test = extent.createTest("Checkout with Empty Cart");
        System.out.println("Test: Removing items and checking out...");
        cartPage.removeAllItems();
        cartPage.clickCheckout();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one"), "Should go to checkout even if cart is empty");
        test.pass("Checkout works with empty cart");
    }
 
    @Test
    public void testRemoveItemWhenCartIsEmpty() {
        test = extent.createTest("Remove Item When Cart Is Empty");
        System.out.println("Test: Trying to remove items from empty cart...");
        cartPage.removeAllItems();
        cartPage.removeAllItems(); // Try removing again
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart should remain empty");
        test.pass("No error when removing from empty cart");
    }
 
    // Runs after each test
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
        }
        System.out.println("Closing browser...");
        driver.quit();
    }
 
    // Runs once after all tests
    @AfterClass
    public void flushReport() {
        extent.flush();
    }
}
 
 
 