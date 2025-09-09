package Teamswaglabproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {
	 
	
		WebDriver driver;
		
	    private By usernameField = By.id("user-name");
	    private By passwordField = By.id("password");
	    private By loginButton = By.id("login-button");
	    private By errorMessage = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");
	 
	    public Loginpage(WebDriver driver) {
	        this.driver = driver;
	    }
	 
	    public void enterUsername(String username) {
	        driver.findElement(usernameField).sendKeys(username);
	    }
	 
	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }
	 
	    public void clickLogin() {
	        driver.findElement(loginButton).click();
	    }
	 
	    public String getErrorMessage() {
	        return driver.findElement(errorMessage).getText();
	    }
	 
	    public boolean isLoginButtonClickable() {
	        return driver.findElement(loginButton).isDisplayed() && driver.findElement(loginButton).isEnabled();
	    }
	 
	public void login(String username, String password) {
	        driver.findElement(By.id("user-name")).sendKeys(username);
	        driver.findElement(By.id("password")).sendKeys(password);
	      driver.findElement(By.id("login-button")).click();
	    }
	 
	}
	 
	 
	 

