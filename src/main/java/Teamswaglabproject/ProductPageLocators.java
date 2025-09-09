package Teamswaglabproject;
 
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
 
public class ProductPageLocators {
 
    final WebDriver driver;
 
    public ProductPageLocators(WebDriver driver) {
        this.driver = driver;
    }
 
    private By productImage = By.xpath("//a[@id='item_4_img_link']/img");
    private By productName = By.xpath("//a[@id='item_4_title_link']");
    private By cartIcon = By.className("shopping_cart_link");
    private By cartIconNumber = By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a/span");
    private By addToCart = By.xpath("//button[text()='Add to cart']");
    private By removeFromCart = By.xpath("//button[text()='Remove']");
    private By dropDown = By.className("product_sort_container");
    private By menu = By.id("react-burger-menu-btn");
    private By productlink = By.id("item_4_title_link");
    private By back = By.id("back-to-products");
    private By filter = By.xpath("//*[@id='header_container']/div[2]/div/span/select");
 
    public void productImageDisplay() {
        boolean display = driver.findElement(productImage).isDisplayed();
        if (display) {
            System.out.println("Product Image is displayed");
        } else {
            System.out.println("Product Image is not displayed");
        }
    }
 
    public String productImageNavigation() {
        driver.findElement(productImage).click();
        return driver.getCurrentUrl();
    }
 
    public void productNameDisplay() {
        boolean display = driver.findElement(productName).isDisplayed();
        if (display) {
            System.out.println("Product Name is displayed");
        } else {
            System.out.println("Product Name is not displayed");
        }
    }
 
    public String productNameNavigation() {
        driver.findElement(productName).click();
        return driver.getCurrentUrl();
    }
 
    public void cartIconDisplay() {
        boolean display = driver.findElement(cartIcon).isDisplayed();
        if (display) {
            System.out.println("Cart Icon is displayed");
        } else {
            System.out.println("Cart Icon is not displayed");
        }
    }
 
    public String cartIconClick() {
        driver.findElement(cartIcon).click();
        return driver.getCurrentUrl();
    }
 
    public void AddToCart() {
        driver.findElement(addToCart).click();
    }
 
    public void RemoveFromCart() {
        driver.findElement(removeFromCart).click();
    }
 
    public int getCartCount() {
        try {
            return Integer.parseInt(driver.findElement(cartIconNumber).getText());
        } catch (Exception e) {
            return 0;
        }
    }
 
    public void menuClick() {
        driver.findElement(menu).click();
    }
 
    public void prductlink() {
        driver.findElement(productlink).click();
    }
 
    public void backproduct() {
        driver.findElement(back).click();
    }
 
    public void dropdown() {
        Select select = new Select(driver.findElement(filter));
        List options = select.getOptions();
        for (int i = 0; i < options.size(); i++) {
            select.selectByIndex(i);
        }
    }
    
    
    
    
}
 
 