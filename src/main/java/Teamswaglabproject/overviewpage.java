package Teamswaglabproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class overviewpage {
	private WebDriver driver;
	 
    // Locators
    private By finishButton = By.id("finish");
    private By backToProductsButton = By.id("back-to-products");
 
    public overviewpage(WebDriver driver) {
        this.driver = driver;
    }
 
    // Scroll to bottom of the page to ensure all products are visible
    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
 
    // Click the Finish button after verifying it's visible and enabled
    public void clickFinishButton() {
        WebElement finish = driver.findElement(finishButton);
        if (finish.isDisplayed() && finish.isEnabled()) {
            finish.click();
        } else {
            throw new IllegalStateException("Finish button is not clickable.");
        }
    }
 
    // Click the Back to Products button after verifying it's visible and enabled
    public void clickBackToProductsButton() {
        WebElement back = driver.findElement(backToProductsButton);
        if (back.isDisplayed() && back.isEnabled()) {
            back.click();
        } else {
            throw new IllegalStateException("Back to Products button is not clickable.");
        }
    }
 
    // Check if Finish button is displayed
    public boolean isFinishButtonDisplayed() {
        return driver.findElement(finishButton).isDisplayed();
    }
 
    // Check if Back to Products button is displayed
    public boolean isBackToProductsButtonDisplayed() {
        return driver.findElement(backToProductsButton).isDisplayed();
    }

}
