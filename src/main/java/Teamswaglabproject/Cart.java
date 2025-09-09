package Teamswaglabproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart {
	
	    WebDriver driver;
	 
	    // Constructor
	    public Cart(WebDriver driver) {
	        this.driver = driver;
	    }
	 
	    // Locators
	     By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
	     By cartIcon = By.className("shopping_cart_link");
	     By cartItems = By.className("cart_item");
	     By removeButtons = By.xpath("//button[text()='Remove']");
	     By continueShoppingButton = By.id("continue-shopping");
	     By checkoutButton = By.id("checkout");
	     By cartBadge = By.className("shopping_cart_badge");
	 
	    // Add item and go to cart
	    public void addItemToCart() {
	        driver.findElement(addToCartButton).click();
	        driver.findElement(cartIcon).click();
	    }
	 
	    // Check if cart page is loaded
	    public boolean isCartPageLoaded() {
	        return driver.getCurrentUrl().contains("cart.html");
	    }
	 
	    // Get number of items in cart
	    public int getCartItemCount() {
	        return driver.findElements(cartItems).size();
	    }
	 
	    // Remove all items
	    public void removeAllItems() {
	        List<WebElement> removeBtns = driver.findElements(removeButtons);
	        for (WebElement btn : removeBtns) {
	            btn.click();
	        }
	    }
	 
	    // Click continue shopping
	    public void clickContinueShopping() {
	        driver.findElement(continueShoppingButton).click();
	    }
	 
	    // Click checkout
	    public void clickCheckout() {
	        driver.findElement(checkoutButton).click();
	    }
	 
	    // Check if cart is empty
	    public boolean isCartEmpty() {
	        return driver.findElements(cartItems).isEmpty();
	    }
	 
	    // Get cart badge count
	    public String getCartBadgeCount() {
	        if (!driver.findElements(cartBadge).isEmpty()) {
	            return driver.findElement(cartBadge).getText();
	        }
	        return "0";
	    }
	}
	 
	 


