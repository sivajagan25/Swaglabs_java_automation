package Teamswaglabproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkoutpage {
	
	       WebDriver driver;
	 
	    // Constructor
	    public Checkoutpage(WebDriver driver) {
	        this.driver = driver;
	    }
	 
	    // Locators
	    By usernameField = By.id("user-name");
	    By passwordField = By.id("password");
	    By loginButton = By.id("login-button");
	 
	    By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
	    By cartIcon = By.className("shopping_cart_link");
	    By checkoutButton = By.id("checkout");
	 
	    By firstNameField = By.id("first-name");
	    By lastNameField = By.id("last-name");
	    By postalCodeField = By.id("postal-code");
	  By continuebtn=By.id("continue") ;
	    By finishButton = By.id("finish");
	 
	    By confirmationMessage = By.className("complete-header");
	 
	    // Login to the site
	    public void login(String username, String password) {
	        driver.findElement(usernameField).sendKeys(username);
	        driver.findElement(passwordField).sendKeys(password);
	        driver.findElement(loginButton).click();
	    }
	 
	    // Add product and go to cart
	    public void addProductToCart() {
	        driver.findElement(addToCartButton).click();
	       driver.findElement(cartIcon).click();
	    }
	 
	    // Proceed to checkout
	    public void startCheckout() {
	        driver.findElement(checkoutButton).click();
	    }
	 
	    // Fill checkout form
	    public void fillCheckoutForm(String firstName, String lastName, String postalCode) {
	        driver.findElement(firstNameField).sendKeys(firstName);
	        driver.findElement(lastNameField).sendKeys(lastName);
	        driver.findElement(postalCodeField).sendKeys(postalCode);
	        driver.findElement(continuebtn).click();
	    }
	 
	    // Finish checkout
	    public void finishCheckout() {
	        driver.findElement(finishButton).click();
	    }
	 
	    // Verify confirmation
	    public boolean isCheckoutComplete() {
	        return driver.findElement(confirmationMessage).isDisplayed();
	    }
	}
	 


