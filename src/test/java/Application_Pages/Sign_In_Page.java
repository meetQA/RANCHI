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
 
  @Test(priority=1, description="To verify that user is able to redirect on \"Sign In\" page.")
  public void DSCL_SignIn_01() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on \"Sign In\" page/window pop-up.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Home_Page_R.label_Sign_In)).isDisplayed());
  }
  
  @Test(priority=2, description="To verify that user is able to \"Sign In\" in DSCL application using valid User Name and Password.")
  public void DSCL_SignIn_02() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter valid \"User Name\" into User Name Textbox.");
	  driver.findElement(By.xpath(Sign_In_Page_R.txt_Login_Name)).sendKeys("admin");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter valid \"Password\" into Password Textbox.");
	  driver.findElement(By.xpath(Sign_In_Page_R.txt_Password)).sendKeys("Abc@1234");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Sign In button.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Sign_In)).click();
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get successful message for Sign In and user should be redirecting to City GIS portal with appropriate user Dashboard.");
	  Assert.assertEquals("DSCL Dashboard", driver.getTitle());
  }
  
  @Test(priority=3, description="To verify that user is able to view / hide entered Password using click on 'View Password' icon.")
  public void DSCL_SignIn_03(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter valid \"User Name\" into User Name Textbox.");
	  driver.findElement(By.xpath(Sign_In_Page_R.txt_Login_Name)).sendKeys("admin");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter valid \"Password\" into Password Textbox.");
	  driver.findElement(By.xpath(Sign_In_Page_R.txt_Password)).sendKeys("Abc@1234");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Sign In button.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Hide_View_Password)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User can see actually entered password in Password textbox.");
	  Assert.assertEquals( driver.findElement(By.xpath(Sign_In_Page_R.txt_Password)).getAttribute("type"),"text");
	  objs.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Again click on View Password icon.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Hide_View_Password)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User can see actually entered password in Password textbox.");
	  Assert.assertEquals("password", driver.findElement(By.xpath(Sign_In_Page_R.txt_Password)).getAttribute("type"));
  }
  
  @Test(priority=4, description="To verify that user is not able to \"Sign In\" in DSCL application with blank details of the User Name and Password.")
  public void DSCL_SignIn_04(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Sign In button.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Sign_In)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation messages like \"Please Enter Valid Username\" and \"Please Enter Valid Password\".");
	  Assert.assertEquals("Please Enter Valid Username", driver.findElement(By.xpath(Sign_In_Page_R.txt_loginUserName_error)).getText());
	  Assert.assertEquals("Please Enter Valid Password", driver.findElement(By.xpath(Sign_In_Page_R.txt_password_error)).getText());
  }
  
  @Test(priority=5, description="To verify that user is not able to \"Sign In\" in DSCL application with invalid Username and valid Password.")
  public void DSCL_SignIn_05() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter invalid \"User Name\" into User Name Textbox.");
	  driver.findElement(By.xpath(Sign_In_Page_R.txt_Login_Name)).sendKeys("adyymin");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter valid \"Password\" into Password Textbox.");
	  driver.findElement(By.xpath(Sign_In_Page_R.txt_Password)).sendKeys("Abc@1234");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Sign In button.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Sign_In)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message like \"Invalid User Name Or Password\".");
	  System.out.println( driver.findElement(By.xpath(Sign_In_Page_R.txt_error)).getText());
	  Assert.assertEquals("Invalid User Name Or Password.", driver.findElement(By.xpath(Sign_In_Page_R.txt_error)).getText());
  }
  
  @Test(priority=6, description="To verify that user is not able to \"Sign In\" in DSCL application with valid Username and invalid Password.")
  public void DSCL_SignIn_06() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter valid \"User Name\" into User Name Textbox.");
	  driver.findElement(By.xpath(Sign_In_Page_R.txt_Login_Name)).sendKeys("Admin");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter invalid \"Password\" into Password Textbox.");
	  driver.findElement(By.xpath(Sign_In_Page_R.txt_Password)).sendKeys("Abc@1ded234");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Sign In button.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Sign_In)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message like \"Invalid User Name Or Password.\".");
	  System.out.println( driver.findElement(By.xpath(Sign_In_Page_R.txt_error)).getText());
	  Assert.assertEquals("Invalid User Name Or Password.", driver.findElement(By.xpath(Sign_In_Page_R.txt_error)).getText());
  }
  
  @Test(priority=7, description="To verify that user is not able to \"Sign In\" in DSCL application with invalid Username and invalid Password.")
  public void DSCL_SignIn_07() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter invalid \"User Name\" into User Name Textbox.");
	  driver.findElement(By.xpath(Sign_In_Page_R.txt_Login_Name)).sendKeys("Adyymin");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter invalid \"Password\" into Password Textbox.");
	  driver.findElement(By.xpath(Sign_In_Page_R.txt_Password)).sendKeys("Abc@1ded234");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Sign In button.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Sign_In)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message like \"Invalid User Name Or Password.\".");
	  System.out.println( driver.findElement(By.xpath(Sign_In_Page_R.txt_error)).getText());
	  Assert.assertEquals("Invalid User Name Or Password.", driver.findElement(By.xpath(Sign_In_Page_R.txt_error)).getText());
  }
 
  @Test(priority=8, description="To verify that user is able to \"Close\" Sign-In page/window pop-up.")
  public void DSCL_SignIn_08() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on SIGN IN tab from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on \"Close\" button.");
	  driver.findElement(By.xpath(Sign_In_Page_R.btn_Close)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on Home page of the DSCL page.");
	  Assert.assertEquals(false, driver.findElement(By.xpath(Home_Page_R.label_Sign_In)).isDisplayed());
  }
  @AfterMethod
  public void afterClass() {
	driver.quit();
	  }
  }

