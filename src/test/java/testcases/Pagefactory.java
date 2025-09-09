package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Pagefactorylogin;
import pages.Pagefactoryprofile;

public class Pagefactory {
	static WebDriver driver;
	@BeforeClass
	public void launchBrowser() {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\sivajagan.d\\eclipse-workspace\\test\\Resource\\ChromeDrive\\chromedriver-win64\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://demoqa.com/login");
	        
		
	}
	@AfterClass
	public void closeBrowser() {
		System.out.println("test excuted completed");
	}
  @Test
  public void LoginTest() {
	  Pagefactorylogin loginpg=new Pagefactorylogin(driver);
	  Pagefactoryprofile profilepg=new Pagefactoryprofile(driver);
	  loginpg.Loignaction("TestNg","Mercury25*");
	  profilepg.verifUser("TestNg");
	  profilepg.logout_Action();
  }
}
