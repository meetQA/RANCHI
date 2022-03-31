package Application_Pages;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import Application_Pages_R.Forgot_Password_Page_R;
import Application_Pages_R.Home_Page_R;
import Application_Pages_R.Sign_In_Page_R;
import Application_Pages_R.Sign_Up_Page_R;
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
 
  @Test(priority=1, description="To verify that user is able to navigates on Forgot Password section.")
  public void SGL_Ranchi_ForgotPassword_1() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Forgot Username / Password ?\" link from the member login section.");
	  driver.findElement(By.xpath(Sign_In_Page_R.link_Forgot_Username)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should navigates on \"Forgot Username / Password\" section.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Forgot_Password_Page_R.Label_Forgot_Password)).isDisplayed());
  }
  
  @Test(priority=2, description="To verify that user is able to get Email Address regarding change password.")
  public void SGL_Ranchi_ForgotPassword_2 () throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Forgot Username / Password ?\" link from the member login section.");
	  driver.findElement(By.xpath(Sign_In_Page_R.link_Forgot_Username)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter valid \"Email-Id\" into Email textbox.");
	  driver.findElement(By.xpath(Forgot_Password_Page_R.txt_Email)).sendKeys("meet.g@sgligis.com");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on Submit button.");
	  driver.findElement(By.xpath(Forgot_Password_Page_R.btn_Submit)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get mail regarding change password and redirect on Sign In page.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Forgot_Password_Page_R.success_message)).isDisplayed());
  }
  
  @Test(priority=3, description="To verify that user is able to \"Close\" Register section.")
  public void SGL_Ranchi_ForgotPassword_3() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Forgot Username / Password ?\" link from the member login section.");
	  driver.findElement(By.xpath(Sign_In_Page_R.link_Forgot_Username)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Close\" button.");
	  driver.findElement(By.xpath(Forgot_Password_Page_R.btn_Close)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Register\" section should close.");
	  Assert.assertEquals(false, driver.findElement(By.xpath(Forgot_Password_Page_R.Label_Forgot_Password)).isDisplayed());
  }
  @Test(priority=4, description="To verify that user is not able to get mail with blank \"Email Address\" textbox.")
  public void SGL_Ranchi_ForgotPassword_4 () throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Forgot Username / Password ?\" link from the member login section.");
	  driver.findElement(By.xpath(Sign_In_Page_R.link_Forgot_Username)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Submit button.");
	  driver.findElement(By.xpath(Forgot_Password_Page_R.btn_Submit)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message like \"Please Enter Register Email\".");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Forgot_Password_Page_R.validation_message)).isDisplayed());
  }
  
  @Test(priority=5, description="To verify that user is not able to get mail with invalid Email address.")
  public void SGL_Ranchi_ForgotPassword_5 () throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Forgot Username / Password ?\" link from the member login section.");
	  driver.findElement(By.xpath(Sign_In_Page_R.link_Forgot_Username)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter invalid \"Email-Id\" into Email textbox.");
	  driver.findElement(By.xpath(Forgot_Password_Page_R.txt_Email)).sendKeys("meet.gghhfhd");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on Submit button.");
	  driver.findElement(By.xpath(Forgot_Password_Page_R.btn_Submit)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message \"Please Enter valid Email address\".");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Forgot_Password_Page_R.validation_message_1)).isDisplayed());
  }
  
  @Test(priority=6, description="To verify that user is not able to get mail by entering non register Email Address.")
  public void SGL_Ranchi_ForgotPassword_6 () throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Forgot Username / Password ?\" link from the member login section.");
	  driver.findElement(By.xpath(Sign_In_Page_R.link_Forgot_Username)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter valid \"Email-Id\" into Email textbox.");
	  driver.findElement(By.xpath(Forgot_Password_Page_R.txt_Email)).sendKeys("meet.g@sgligis.com");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on Submit button.");
	  driver.findElement(By.xpath(Forgot_Password_Page_R.btn_Submit)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message as \"if you entered correct email Id then you received mail shortly\".");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Forgot_Password_Page_R.success_message)).isDisplayed());
  }
  @AfterMethod
  public void afterClass() {
	driver.quit();
	  }
  }


