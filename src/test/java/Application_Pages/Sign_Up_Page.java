package Application_Pages;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
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

public class Sign_Up_Page {
	Home_Page_R obj = new Home_Page_R();
	Sign_In_Page_R obj2 = new Sign_In_Page_R();
	Sign_Up_Page_R obj3 = new Sign_Up_Page_R();
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
 
  @Test(priority=1, description="To verify that user is able to redirect on Registration page for Sign-Up.")
  public void DSCL_SignUp_01() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Sign Up button.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.btn_Sign_Up)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on \"Registration\" page/window pop-up. ");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Sign_Up_Page_R.Label_Register)).isDisplayed());
  }
  
  @Test(priority=2, description="To verify that user is able to Sign-Up in DSCL application using valid details.")
  public void DSCL_SignUp_02() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Sign Up button.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.btn_Sign_Up)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter valid \"First Name\" into First Name textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_First_Name)).sendKeys("Meet");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid \"Last Name\" into Last Name textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_Last_Name)).sendKeys("Gondaliya");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter valid \"User Name\" into User Name textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_User_Name)).sendKeys("Meet_Gondaliya");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Enter valid \"Mobile No.\" into Mobile No. textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_Mobile_No)).sendKeys("9023328797");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter valid \"Email-Id\" into Email textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_Email)).sendKeys("meet.g@sgligis.com");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b>  Checked on \"I Agree to the Terms and Conditions\".");
	  driver.findElement(By.xpath(Sign_Up_Page_R.chk_Term_Con)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Sign Up button.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.btn_Sign_Up_2)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get successful message for the Registration and redirecting to Sign In Page.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Sign_Up_Page_R.Label_Success_Register)).isDisplayed());
  }
  
  @Test(priority=3, description="To verify that user is able to redirect on Sign-In page.")
  public void DSCL_SignUp_06() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Sign Up button.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.btn_Sign_Up)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on link of Sign In from the Sign-Up Page.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.lnk_Sign_In)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on \"Sign In\" page/window pop-up.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Home_Page_R.label_Sign_In)).isDisplayed());
  }
  
  @Test(priority=4, description="To verify that user get \"Terms & Conditions\" page.")
  public void DSCL_SignUp_07() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Sign Up button.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.btn_Sign_Up)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Terms & Conditions\" link button.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.lnk_Term_Cond)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get \"Terms & Conditions\" related window popup.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Sign_Up_Page_R.Label_Term_Cond)).isDisplayed());
  }
  
  @Test(priority=5, description="To verify that user is not able to Sign-Up in DSCL application with blank details.")
  public void DSCL_SignUp_08() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Sign Up button.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.btn_Sign_Up)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Sign-Up button.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.btn_Sign_Up_2)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message regarding blank First Name, Last Name, User Name, Mobile No., Password, Confirm Password, Email, Captcha, and using agree on Terms and Conditions.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Sign_Up_Page_R.validation_message)).isDisplayed());
  }
  
  @Test(priority=17, description="To verify that user is not able to Sign-Up in DSCL application with invalid Captcha and valid First Name, Last Name, User Name, Mobile No., Password, Confirm Password, and Email.")
  public void DSCL_SignUp_17() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Sign Up button.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.btn_Sign_Up)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter valid \"First Name\" into First Name textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_First_Name)).sendKeys("Meet");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid \"Last Name\" into Last Name textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_Last_Name)).sendKeys("Gondaliya");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter valid \"User Name\" into User Name textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_User_Name)).sendKeys("Meet_Gondaliya");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Enter valid \"Mobile No.\" into Mobile No. textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_Mobile_No)).sendKeys("9023328797");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter valid \"Email-Id\" into Email textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_Email)).sendKeys("meet.g@sgligis.com");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter invalid Captcha in Captcha textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_captcha)).sendKeys("meet.g@sgligis.com");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b>  Checked on \"I Agree to the Terms and Conditions\".");
	  driver.findElement(By.xpath(Sign_Up_Page_R.chk_Term_Con)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on Sign Up button.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.btn_Sign_Up_2)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message like \"Please Enter valid Captcha\".");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Sign_Up_Page_R.validation_captcha)).isDisplayed());
  }
  
  @Test(priority=18, description="To verify that user is able to \"Close\" Sign-Up page/window pop-up.")
  public void DSCL_SignUp_18() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Sign Up button.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.btn_Sign_Up)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Close\" button.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Close)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on Home page of the DSCL page.");
	  Assert.assertEquals(false, driver.findElement(By.xpath(Sign_Up_Page_R.Label_Register)).isDisplayed());
  }
  @AfterMethod
  public void afterClass() {
	driver.quit();
	  }
  }


