package Application_Pages;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Application_Pages_R.Home_Page_R;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import Listener.ExtentTestManager;
import Listener.Extra_Screen;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;

public class Home_Page {
	Home_Page_R obj = new Home_Page_R();
	WebDriver driver;
	String Classname = "Hoem_page_extras";
	Extra_Screen objs = new Extra_Screen();
	
	@BeforeMethod
	  public void openBrowser(ITestContext context) {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  context.setAttribute("WebDriver", driver);
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get(Home_Page_R.URL);
	  }
 
  @Test(priority=01, description="To verify that user can get the Home page of the DSCL application.")
  public void DSCL_HOME_01() {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Check Url of DSCL Application ");
	  String actualURL=driver.getCurrentUrl();
	  String expectedURL=Home_Page_R.URL;
	  Assert.assertEquals(actualURL, expectedURL);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get Home page of the DSCL application.");
	  String actualTitle=driver.getTitle();
	  String expectedTitle="Dehradun Smart City Ltd";
	  Assert.assertEquals(actualTitle, expectedTitle);
  }
  
  @Test(priority=02, description="To verify that user can get the image slider on the Home page and slider is change automatically.")
  public void DSCL_HOME_02() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Observe Home page and wait for specific duration to change image slider automatically.");
	  System.out.println(driver.findElement(By.xpath(Home_Page_R.img_1)).isDisplayed());
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get image slider on home page and image slider should be change automatically.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Home_Page_R.img_1)).isDisplayed());
	  Thread.sleep(4000);
	  Assert.assertEquals(true, driver.findElement(By.xpath(Home_Page_R.img_2)).isDisplayed());
	  Thread.sleep(4000);
	  Assert.assertEquals(true, driver.findElement(By.xpath(Home_Page_R.img_3)).isDisplayed());
  }
  
  @Test(priority=03, description="To verify that user can get the image slider on the Home page and user is able to change image slider manually.")
  public void DSCL_HOME_03(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Next button of the slider.");
	  driver.findElement(By.xpath(Home_Page_R.btn_Next_Slider)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get next image of the slider.");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(Home_Page_R.img_3)).isDisplayed();
	  Assert.assertEquals(true, driver.findElement(By.xpath(Home_Page_R.img_3)).isDisplayed());
	  objs.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Previous button of the slider.");
	  driver.findElement(By.xpath(Home_Page_R.btn_Previous_Slider)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get previous image of the slider.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Home_Page_R.img_2)).isDisplayed());
  }
  
  @Test(priority=04, description="To verify that user can get \"About DSCL\" page.")
  public void DSCL_HOME_04() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on ABOUT DSCL tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_About_DSCL)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on \"About DSCL\" page/window pop-up.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Home_Page_R.label_About_DSCL)).isDisplayed());
  }
  
  @Test(priority=05, description="To verify that user can get \"Sign In\" page.")
  public void DSCL_HOME_05() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on \"Sign In\" page/window pop-up.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Home_Page_R.label_Sign_In)).isDisplayed());
  }
  
  @Test(priority=06, description="To verify that user can get \"City GIS\" portal page")
  public void DSCl_HOME_06 () throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landing page of the City GIS Portal.");
	  Assert.assertEquals("Dehradun GIS Portal", driver.getTitle());
  }
 
  
  @AfterMethod
  public void afterClass() {
	 driver.quit();
	  }
  }
