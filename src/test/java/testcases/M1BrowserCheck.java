package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.M1loginpage;

public class M1BrowserCheck {
	WebDriver driver;
      //int driver =0;
	 M1loginpage a;
	
	@BeforeTest
    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\sivajagan.d\\eclipse-workspace\\test\\Resource\\ChromeDrive\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");
        System.out.println(driver.getCurrentUrl());
        a= new M1loginpage();
    }
	
  @Test
  public void check() {
	  
	  a.getname();
  }
}
