package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Pagefactorylogin {
	final WebDriver driver;
	public Pagefactorylogin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		//this.driver = null;
		
	}
	@FindBys({
		@FindBy(id="userName-wrapper"),
		@FindBy(id="userName")
	})
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(how=How.ID,using="login")
	WebElement loginBtn;
	public void Loignaction(String uName,String pWd) {
		if(driver == null) {
			throw new IllegalStateException("webdriver is not innialized");
		}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", password);
		username.sendKeys(uName);
		password.sendKeys(pWd);
		loginBtn.click();
	}

}
