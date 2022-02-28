package Application_Pages;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import Application_Pages_R.Forgot_Password_Page_R;
import Application_Pages_R.Home_Page_R;
import Application_Pages_R.Sign_In_Page_R;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import Listener.ExtentTestManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;

public class Forgot_Password_Page {
	Home_Page_R obj = new Home_Page_R();
	Sign_In_Page_R obj2 = new Sign_In_Page_R();
	Forgot_Password_Page_R obj4 = new Forgot_Password_Page_R();
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
 
  @Test(priority=1, description="To verify that user is able to redirect on Forgot Password page.")
  public void DSCL_ForgotPassword_1() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on link of Forgot Username / Password from the Sign-In page.");
	  driver.findElement(By.xpath(Forgot_Password_Page_R.lnk_Forgot_Password)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on \"Forgot Username / Password\" page/window pop-up.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Forgot_Password_Page_R.Label_Forgot_Password)).isDisplayed());
  }
  
  @Test(priority=2, description="To verify that user is able to get email regarding change password.")
  public void DSCL_ForgotPassword_2 () throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on link of Forgot Username / Password from the Sign-In page.");
	  driver.findElement(By.xpath(Forgot_Password_Page_R.lnk_Forgot_Password)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter valid \"Email-Id\" into Email textbox.");
	  driver.findElement(By.xpath(Forgot_Password_Page_R.txt_Email)).sendKeys("meet.g@sgligis.com");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Submit button.");
	  driver.findElement(By.xpath(Forgot_Password_Page_R.btn_Submit)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get mail regarding change password and redirect on Sign In page.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Forgot_Password_Page_R.success_message)).isDisplayed());
  }
  
  @Test(priority=3, description="To verify that user is not able to send mail with blank Email address.")
  public void DSCL_ForgotPassword_3 () throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on link of Forgot Username / Password from the Sign-In page.");
	  driver.findElement(By.xpath(Forgot_Password_Page_R.lnk_Forgot_Password)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Submit button.");
	  driver.findElement(By.xpath(Forgot_Password_Page_R.btn_Submit)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message like \"Please Enter Register Email\".");
	  Assert.assertEquals(false, driver.findElement(By.xpath(Forgot_Password_Page_R.success_message)).isDisplayed());
  }
  
  @Test(priority=4, description="To verify that user is not able to send mail with invalid Email address.")
  public void DSCL_ForgotPassword_4 () throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on link of Forgot Username / Password from the Sign-In page.");
	  driver.findElement(By.xpath(Forgot_Password_Page_R.lnk_Forgot_Password)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter invalid \"Email-Id\" into Email textbox.");
	  driver.findElement(By.xpath(Forgot_Password_Page_R.txt_Email)).sendKeys("meet.gghhfhd");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Submit button.");
	  driver.findElement(By.xpath(Forgot_Password_Page_R.btn_Submit)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message like \"Invalid Email\".");
	  Assert.assertEquals(false, driver.findElement(By.xpath(Forgot_Password_Page_R.success_message)).isDisplayed());
  }
  
  @Test(priority=5, description="To verify that user is able to \"Close\" Forgot Username / Password page/window pop-up.")
  public void DSCL_ForgotPassword_5 () throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on link of Forgot Username / Password from the Sign-In page.");
	  driver.findElement(By.xpath(Forgot_Password_Page_R.lnk_Forgot_Password)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Close\" button.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Close)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on Home page of the DSCL page.");
	  Assert.assertEquals(false, driver.findElement(By.xpath(Forgot_Password_Page_R.Label_Forgot_Password)).isDisplayed());
  }
  @AfterMethod
  public void afterClass() {
	driver.quit();
	  }
  }


