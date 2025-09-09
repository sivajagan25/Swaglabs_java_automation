
package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import swaglabs.*;

public class Swaglabstestcases {
    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;
    

    @BeforeTest
    public void setup() {
    	extent = Reportslog.getReportInstance();
    	System.setProperty("webdriver.edge.driver", "C:\\Users\\sivajagan.d\\eclipse-workspace\\test\\Resource\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }
    
    //Dataprovider for loginpage username and password
    
    @DataProvider(name = "logindata",indices = {0,1,2})
	public Object[][] getlogindata(){
		return new Object[][] {
			{"wrong","secret_sauce"},
			{"2nd wrong","secret_sauce"},
			{"standard_user","secret_sauce"}
			
			
		};
		}
	

    @Test(dataProvider ="logindata")
    public void loginTest(String usernameee,String password) {
    	 test = extent.createTest("Login Test");
        Swaglabslogin login = new Swaglabslogin(driver);
        login.loginpage(usernameee, password);
       
        test.pass("login successfully");
    }

    @Test(dependsOnMethods = {"loginTest"},priority = 1)
    public void productTest() {
    	test = extent.createTest("ProductPage Test");
        ProductPage pp = new ProductPage(driver);
        test.info("It is navigaed to product page");
        pp.addtocartbtnn();
        test.info("AddToCart button is clicked");
        pp.prductlink();
        test.info("ProductLink is clicked");
       
        pp.remove();
        test.info("Remove button is clicked");
        pp.backproduct();
        test.info("Backproduct button is clicked");
        pp.clickremove();
        test.info("clickremove button is clicked");
        pp.dropdown();
        test.info("Dropdown is clicked");
        pp.addtocartbtnn();
        
        
    }
        
        
    

    @Test(dependsOnMethods = {"productTest"},priority = 2)
    public void socialMediaTest() {
    	test = extent.createTest("SocialMedia Test");
        Socialmedia social = new Socialmedia(driver);
        social.twitt();
      
        social.facee();
        
        social.inked();
        test.pass("socialmedia page is successfully ");
        
    }

    @Test(dependsOnMethods = {"socialMediaTest"},priority = 3)
    public void cartTest() {
    	test = extent.createTest("cart Test page");
        Cartpage cart = new Cartpage(driver);
        cart.cartpageee();
        cart.checkoutt();
        test.pass("carttest page is successfully ");
    }

    @Test(dependsOnMethods = {"cartTest"},priority = 4)
    public void informationTest() {
    	test = extent.createTest("InformtionPage Test");
        Yourinformation info = new Yourinformation(driver);
        info.fname("jagan");
        test.info("fname entered successfully ");
        info.lname("siva");
        test.info("lname entered successfully ");
        info.postal("123333");
        test.info("postal entered successfully ");
        info.screen();
        test.info("Screenshot taken is successfully ");
        info.continueee();
        test.pass("Information page is successfully ");
    }

    @Test(dependsOnMethods = {"informationTest"},priority = 5)
    public void overviewTest() {
    	test = extent.createTest("overview page Test");
        Overview over = new Overview(driver);
        over.finishhclick();
        over.backhome();
        test.pass("overview page is successfully ");
    }

    @Test(dependsOnMethods = {"overviewTest"},priority = 6)
    public void logoutTest() {
    	test = extent.createTest("logout Page Test");
        Sidebar side = new Sidebar(driver);
        side.sideclk();
        test.pass("Side button clicked is successfully ");
        side.logoutt();
        test.pass("logout page is successfully ");
    }
    @AfterTest

public void flushExtentReport() {
        extent.flush();
        System.out.println("Project completed");
    }

}

