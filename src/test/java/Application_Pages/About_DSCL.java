package Application_Pages;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import Application_Pages_R.About_DSCL_R;
import Application_Pages_R.Home_Page_R;
import Application_Pages_R.Sign_In_Page_R;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import Listener.ExtentTestManager;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;

public class About_DSCL {
	Home_Page_R obj = new Home_Page_R();
	About_DSCL_R obj5 = new About_DSCL_R();
	WebDriver driver;
	
	@BeforeMethod
	  public void openBrowser(ITestContext context) {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  context.setAttribute("WebDriver", driver);
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get(Home_Page_R.URL);
	  }
 
  @Test(priority=1, description="To verify that user can get the About us page of the DSCL application.")
  public void DSCL_About_DSCL_1() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on ABOUT DSCL tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_About_DSCL)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on \"About DSCL\" page/window pop-up.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Home_Page_R.label_About_DSCL)).isDisplayed());
  }
  
  @Test(priority=2, description="To verify that user can get \"More\" details related DSCL application.")
  public void DSCL_About_DSCL_2() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on ABOUT DSCL tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_About_DSCL)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on \"READ MORE\" button.");
	  driver.findElement(By.xpath(About_DSCL_R.lnk_Read_More)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on more details page for DSCL application.");
	  String parent=driver.getWindowHandle();
	  Set<String>s=driver.getWindowHandles();
     // Now iterate using Iterator
	 Iterator<String> I1= s.iterator();
     while(I1.hasNext()){
    	 String child_window=I1.next();
         if(!parent.equals(child_window)){
        	 driver.switchTo().window(child_window);
             String actualTitle = driver.switchTo().window(child_window).getTitle();
             String expectedTitle="SmartCity, Dehradun";
	         Assert.assertEquals(actualTitle, expectedTitle);
	         Thread.sleep(2000);
	         } 
         }
  }
  
  @Test(priority=3, description="To verify that user is able to \"Close\" About DSCL page/window pop-up.")
  public void DSCL_About_DSCL_3() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on ABOUT DSCL tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_About_DSCL)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on \"Close\" button.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Close)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on \"About DSCL\" page/window pop-up.");
	  Assert.assertEquals(false, driver.findElement(By.xpath(Home_Page_R.label_About_DSCL)).isDisplayed());
  }
  @AfterMethod
  public void afterClass() {
	driver.quit();
	  }
  }


