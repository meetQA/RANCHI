package Application_Pages;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Application_Pages_R.Home_Page_R;
import Application_Pages_R.Sign_In_Page_R;
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

public class Sign_In_Page {
	Home_Page_R obj = new Home_Page_R();
	Sign_In_Page_R obj2 = new Sign_In_Page_R();
	WebDriver driver;
	String Classname = "Sign_In_Page_extras";
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
 
  @Test(priority=1, description="To verify that user gets \"Member Login\" section.")
  public void SGL_Ranchi_SignIn_1() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get \"Member Login\" section on home page.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Home_Page_R.label_Sign_In)).isDisplayed());
  }
  
  @Test(priority=2, description="To verify that user is able to \"LOGIN\" in Ranchi application using valid username and password. ")
  public void SGL_Ranchi_SignIn_2() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid \"User Name\" into User Name Textbox.");
	  driver.findElement(By.xpath(Sign_In_Page_R.txt_Login_Name)).sendKeys("admin");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter valid \"Password\" into Password Textbox.");
	  driver.findElement(By.xpath(Sign_In_Page_R.txt_Password)).sendKeys("Abc@1234");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on Sign In button.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Sign_In)).click();
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on landing page of \"admin\" department.");
	  Assert.assertEquals("RSCL Dashboard", driver.getTitle());
  }
  
  @Test(priority=3, description="To verify that user is able to view / hide entered password by clicking \"View/Hide Password\" icon.")
  public void SGL_Ranchi_SignIn_3(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid \"User Name\" into User Name Textbox.");
	  driver.findElement(By.xpath(Sign_In_Page_R.txt_Login_Name)).sendKeys("admin");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter valid \"Password\" into Password Textbox.");
	  driver.findElement(By.xpath(Sign_In_Page_R.txt_Password)).sendKeys("Abc@1234");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"View Password\" icon.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Hide_View_Password)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Entered password display in readable format.");
	  Assert.assertEquals( driver.findElement(By.xpath(Sign_In_Page_R.txt_Password)).getAttribute("type"),"text");
	  objs.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"View Password\" icon.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Hide_View_Password)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get entered password in password protected format.");
	  Assert.assertEquals("password", driver.findElement(By.xpath(Sign_In_Page_R.txt_Password)).getAttribute("type"));
  }
  
  @Test(priority=4, description="To verify that user is able to \"Close\" member login section.")
  public void SGL_Ranchi_SignIn_4() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Close\" button.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Close)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Member Login\" section should close.");
	  Assert.assertEquals(false, driver.findElement(By.xpath(Home_Page_R.label_Sign_In)).isDisplayed());
  }
  
  @Test(priority=5, description="To verify that user is able to navigate on \"Forgot Username /Password\" section.")
  public void SGL_Ranchi_SignIn_5() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Forgot Username / Password ?\" link from the member login section.");
	  driver.findElement(By.xpath(Sign_In_Page_R.link_Forgot_Username)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should navigates on \"Forgot Username / Password\" section.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//h2[text()=\"Forgot Username / Password\"]")).isDisplayed());
  }
  
  @Test(priority=6, description="To verify that user is able to navigate on \"Register\" section.")
  public void SGL_Ranchi_SignIn_6() throws InterruptedException {
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
  @Test(priority=7, description="To verify that user is not able to \"LOGIN\" in Ranchi application with blank credentials.")
  public void SGL_Ranchi_SignIn_7() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Sign In button.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation messages like \"Please Enter Username\" and \"Please Enter Password\".");
	  Assert.assertEquals("Please Enter Username", driver.findElement(By.xpath(Sign_In_Page_R.txt_loginUserName_error)).getText());
	  Assert.assertEquals("Please Enter Password", driver.findElement(By.xpath(Sign_In_Page_R.txt_password_error)).getText());
  }
  
  @Test(priority=8, description="To verify that user is not able to \"LOGIN\" in Ranchi application with invalid Username and valid Password.")
  public void SGL_Ranchi_SignIn_8() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter invalid \"User Name\" into User Name Textbox.");
	  driver.findElement(By.xpath(Sign_In_Page_R.txt_Login_Name)).sendKeys("adyymin");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter valid \"Password\" into Password Textbox.");
	  driver.findElement(By.xpath(Sign_In_Page_R.txt_Password)).sendKeys("Abc@1234");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on Sign In button.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Sign_In)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message like \"Invalid Username or Password.\".");
	  System.out.println( driver.findElement(By.xpath(Sign_In_Page_R.txt_error)).getText());
	  Assert.assertEquals("Invalid Username or Password.", driver.findElement(By.xpath(Sign_In_Page_R.txt_error)).getText());
  }
  
  @Test(priority=9, description="To verify that user is not able to \"LOGIN\" in Ranchi application with valid Username and invalid Password.")
  public void SGL_Ranchi_SignIn_9() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid \"User Name\" into User Name Textbox.");
	  driver.findElement(By.xpath(Sign_In_Page_R.txt_Login_Name)).sendKeys("admin");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter invalid \"Password\" into Password Textbox.");
	  driver.findElement(By.xpath(Sign_In_Page_R.txt_Password)).sendKeys("Abc@12hgh34");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on Sign In button.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Sign_In)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message \"You are left with 4 attempts after which you will be blocked for 1 Hours\".");
	  System.out.println( driver.findElement(By.xpath(Sign_In_Page_R.txt_error_1)).getText());
	  Assert.assertEquals("You are left with 4 attempts after which you will be blocked for 1 Hours", driver.findElement(By.xpath(Sign_In_Page_R.txt_error_1)).getText());
  }
  
  @Test(priority=10, description="To verify that user is not able to \"LOGIN\" in Ranchi application with invalid Username and invalid Password.")
  public void SGL_Ranchi_SignIn_10() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on SIGN IN tab from the menu bar.");
      driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
      Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter invalid \"User Name\" into User Name Textbox.");
	  driver.findElement(By.xpath(Sign_In_Page_R.txt_Login_Name)).sendKeys("admin");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter invalid \"Password\" into Password Textbox.");
	  driver.findElement(By.xpath(Sign_In_Page_R.txt_Password)).sendKeys("Abc@12hgh34");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on Sign In button.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Sign_In)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message \"You are left with 3 attempts after which you will be blocked for 1 Hours\".");
	  System.out.println( driver.findElement(By.xpath(Sign_In_Page_R.txt_error_2)).getText());
	  Assert.assertEquals("You are left with 3 attempts after which you will be blocked for 1 Hours", driver.findElement(By.xpath(Sign_In_Page_R.txt_error_2)).getText());		  
  }
 
  
  @AfterMethod
  public void afterClass() {
	driver.quit();
	  }
  }

