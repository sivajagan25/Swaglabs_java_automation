package testcases;

import org.testng.annotations.Test;
import letskodeitPractice.locators;
import org.testng.annotations.BeforeTest;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
public class letskodeittestcase {
	WebDriver driver;
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.edge.driver", "C:\\Users\\sivajagan.d\\eclipse-workspace\\test\\Resource\\msedgedriver.exe");
      driver = new EdgeDriver();
      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
      driver.get("https://www.letskodeit.com/practice");
      driver.manage().window().maximize();
  }
  
  @Test
  public void ratioo() throws InterruptedException {
	 locators m1=new locators(driver);
	  m1.ratiobtnn();
	  Thread.sleep(3000);
	  m1.checkboxx();
	  m1.openwinn();
	  m1.opennewtab();
	  m1.drop();
	  m1.multii();
	  m1.autosuggest();
	  //Thread.sleep(3000);
	  m1.alterr();
	  m1.hover();
	  
  }

  @AfterTest
  public void afterTest() {
	  //driver.quit();
  }

}
