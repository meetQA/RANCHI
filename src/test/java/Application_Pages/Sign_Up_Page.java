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
 
  @Test(priority=1, description="To verify that user is able to navigates on \"Register\" section.")
  public void SGL_Ranchi_SignUp_1() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"CREATE AN ACCOUNT\" button.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Register)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should navigates on \"Register\" section.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//h2[text()=\"Register\"]")).isDisplayed());
  }
  
  @Test(priority=2, description="To verify that user is able to perform \"CREATE AN ACCOUNT\" functionality in Ranchi application.")
  public void SGL_Ranchi_SignUp_2() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"CREATE AN ACCOUNT\" button.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Register)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter valid \"First Name\" into First Name textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_First_Name)).sendKeys("Meet");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Enter valid \"Last Name\" into Last Name textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_Last_Name)).sendKeys("Gondaliya");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter valid \"User Name\" into User Name textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_User_Name)).sendKeys("Meet_Gondaliya");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter valid \"Mobile No.\" into Mobile No. textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_Mobile_No)).sendKeys("9023328797");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Enter valid \"Email-Id\" into Email textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_Email)).sendKeys("meet.g@sgligis.com");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b>  Checked on \"I Agree to the Terms and Conditions\".");
	  driver.findElement(By.xpath(Sign_Up_Page_R.chk_Term_Con)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on Sign Up button.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.btn_Sign_Up_2)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get successful message for the Registration and redirecting to Sign In Page.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Sign_Up_Page_R.Label_Success_Register)).isDisplayed());
  }
  
  @Test(priority=4, description="To verify that user is able to \"Close\" Register section.")
  public void SGL_Ranchi_SignUp_4() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"CREATE AN ACCOUNT\" button.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Register)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Close\" button.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.btn_Close)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Register\" section should close.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Home_Page_R.label_Sign_In)).isDisplayed());
  }
  
  @Test(priority=5, description="To verify that user is not able to create new user in Ranchi application with blank details.")
  public void SGL_Ranchi_SignUp_5() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"CREATE AN ACCOUNT\" button.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Register)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign-Up button.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.btn_Sign_Up_2)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message regarding blank First Name, Last Name, User Name, Mobile No., Password, Confirm Password, Email, Captcha, and using agree on Terms and Conditions.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Please Enter First Name\"]")).isDisplayed());
	  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Please Enter Last Name\"]")).isDisplayed());
	  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Please Enter Username\"]")).isDisplayed());
	  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Please Enter Email Address\"]")).isDisplayed());
	  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Please Enter Mobile No.\"]")).isDisplayed());
	  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Please Enter Captcha Code\"]")).isDisplayed());
	  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Please check I agree terms and condition\"]")).isDisplayed());
	  
  }
  
  @Test(priority=6, description="To verify that user is not able to create new user in Ranchi application with invalid Mobile No. and valid First Name, Last Name, User Name, Email Address, Captcha and checkbox.")
  public void SGL_Ranchi_SignUp_6() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"CREATE AN ACCOUNT\" button.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Register)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter valid \"First Name\" into First Name textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_First_Name)).sendKeys("Meet");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Enter valid \"Last Name\" into Last Name textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_Last_Name)).sendKeys("Gondaliya");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter valid \"User Name\" into User Name textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_User_Name)).sendKeys("Meet_Gondaliya");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter invalid \"Mobile No.\" into Mobile No. textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_Mobile_No)).sendKeys("90233297");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Enter valid \"Email-Id\" into Email textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_Email)).sendKeys("meet.g@sgligis.com");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b>  Checked on \"I Agree to the Terms and Conditions\".");
	  driver.findElement(By.xpath(Sign_Up_Page_R.chk_Term_Con)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on Sign Up button.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.btn_Sign_Up_2)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message \"Please enter valid mobile number\".");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Please enter valid mobile number\"]")).isDisplayed());
  }
  
  @Test(priority=7, description="To verify that user is not able to create new user in Ranchi application with invalid Email and valid First Name, Last Name, User Name, Mobile No., Captcha and checkbox.")
  public void SGL_Ranchi_SignUp_7() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"CREATE AN ACCOUNT\" button.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Register)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter valid \"First Name\" into First Name textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_First_Name)).sendKeys("Meet");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Enter valid \"Last Name\" into Last Name textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_Last_Name)).sendKeys("Gondaliya");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter valid \"User Name\" into User Name textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_User_Name)).sendKeys("Meet_Gondaliya");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter valid \"Mobile No.\" into Mobile No. textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_Mobile_No)).sendKeys("90233297");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Enter invalid \"Email-Id\" into Email textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_Email)).sendKeys("meesgligis.com");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b>  Checked on \"I Agree to the Terms and Conditions\".");
	  driver.findElement(By.xpath(Sign_Up_Page_R.chk_Term_Con)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on Sign Up button.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.btn_Sign_Up_2)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message like \"Please Enter valid email address\".");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Please Enter valid email address\"]")).isDisplayed());
  }
  
  @Test(priority=8, description="To verify that user is not able to create new user in Ranchi application with invalid Captcha and valid First Name, Last Name, User Name, Mobile No., Email Address and checkbox.")
  public void SGL_Ranchi_SignUp_8() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"CREATE AN ACCOUNT\" button.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Register)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter valid \"First Name\" into First Name textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_First_Name)).sendKeys("Meet");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Enter valid \"Last Name\" into Last Name textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_Last_Name)).sendKeys("Gondaliya");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter valid \"User Name\" into User Name textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_User_Name)).sendKeys("Meet_Gondaliya");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter valid \"Mobile No.\" into Mobile No. textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_Mobile_No)).sendKeys("9023328797");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Enter valid \"Email-Id\" into Email textbox.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.txt_Email)).sendKeys("mees@gligis.com");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b>  Checked on \"I Agree to the Terms and Conditions\".");
	  driver.findElement(By.xpath(Sign_Up_Page_R.chk_Term_Con)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on Sign Up button.");
	  driver.findElement(By.xpath(Sign_Up_Page_R.btn_Sign_Up_2)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message \"Please Enter valid Captcha Code.\"");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Please Enter Captcha Code\"]")).isDisplayed());
  }
 
  @AfterMethod
  public void afterClass() {
	driver.quit();
	  }
  }


