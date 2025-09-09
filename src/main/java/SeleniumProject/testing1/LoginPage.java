package SeleniumProject.testing1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
By username=By.name("username");
By password=By.name("password");
By SignInButton=By.xpath("//*[@id=\"submit\"]");
public void typeusername(String uname) {
	driver.findElement(username).sendKeys(uname);
}
public void typePassword(String passwordvalue) {
	driver.findElement(password).sendKeys(passwordvalue);
}
public void clicksignIn() {
	driver.findElement(SignInButton).click();
}


}
