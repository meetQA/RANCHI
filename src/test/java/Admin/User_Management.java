package Admin;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import Admin_R.User_Management_R;
import Application_Pages_R.Home_Page_R;
import Application_Pages_R.Sign_In_Page_R;
import City_GIS_Map_R.City_GIS_R;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import Listener.ExtentTestManager;
import Listener.Extra_Screen;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;

public class User_Management {
	Home_Page_R obj = new Home_Page_R();
	WebDriver driver;
	String Classname = "User_Management_Extras";
	Extra_Screen objs = new Extra_Screen();
	@BeforeMethod
	  public void openBrowser(ITestContext context) throws InterruptedException {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  context.setAttribute("WebDriver", driver);
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get(Home_Page_R.URL);
		  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(Sign_In_Page_R.txt_Login_Name)).sendKeys("admin");
		  driver.findElement(By.xpath(Sign_In_Page_R.txt_Password)).sendKeys("Abc@1234");
		  driver.findElement(By.xpath(Sign_In_Page_R.btn_Sign_In)).click();
		  Thread.sleep(5000);
		  Assert.assertEquals("RSCL Dashboard", driver.getTitle());
	  }
 
	@Test(priority=01, description="To verify that user is able to change language (from English to Hindi) / (from Hindi to English) for \"Administrator\" page.")
	  public void SGL_Ranchi_Admin_Language_01(Method method) throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"Language\" from the Main Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_Language)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b>  Click on link of \"Hindi\" from the Language selection.");
		  driver.findElement(By.xpath(User_Management_R.btn_Hindi)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get administrator page in \"Hindi\" language.");
		  Assert.assertEquals("RSCL डैशबोर्ड", driver.getTitle());
		  objs.Screenshot(driver, Classname ,method.getName()+"_01" );
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on expand icon of the \"Language\" from the Main Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_Language_H)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on link of \"English\" from the Language selection.");
		  driver.findElement(By.xpath(User_Management_R.btn_English)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get administrator page in \"English\" language.");
		  Assert.assertEquals("RSCL Dashboard", driver.getTitle());
	  }
	
	@Test(priority=02, description="To verify that user is able to perform \"Help\" functionality. ")
	  public void SGL_Ranchi_Admin_Language_02() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Help\" functionality from \"MAIN\" panel.");
		  driver.findElement(By.xpath(User_Management_R.btn_Help)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should navigate on help page .");
		  String parent=driver.getWindowHandle();
		  Set<String>s=driver.getWindowHandles();
	     // Now iterate using Iterator
		  Iterator<String> I1= s.iterator();
	      while(I1.hasNext()){
	    	 String child_window=I1.next();
	         if(!parent.equals(child_window)){
	        	 driver.switchTo().window(child_window);
	             String actualTitle = driver.switchTo().window(child_window).getTitle();
	             String expectedTitle="Ranchi Smart City Portal";
		         Assert.assertEquals(actualTitle, expectedTitle);
		         Thread.sleep(2000);
		         } 
	         }
	  }
	
	@Test(priority=03, description="To verify that user is able to get \"User Management\" functionality.")
	  public void SGL_Ranchi_Admin_Language_03() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the expanded list of the User Management like:\r\n"
		  		+ "\r\n"
		  		+ "- Manage Users,\r\n"
		  		+ "- Manage Roles,\r\n"
		  		+ "- Assign Role Permission,\r\n"
		  		+ "- Add Groups, \r\n"
		  		+ "- Role Group Mapping,\r\n"
		  		+ "- Layer Management");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).isDisplayed());
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.btn_Manage_Configurations)).isDisplayed());
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).isDisplayed());
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).isDisplayed());
	  }
	
	@Test(priority=04, description="To verify that user is able to expand/collapse \"User Management\" panel.")
	  public void SGL_Ranchi_Admin_Language_04(Method method) throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get \"User Management\" in expanded mode.");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).isDisplayed());
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.btn_Manage_Configurations)).isDisplayed());
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).isDisplayed());
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).isDisplayed());
		  objs.Screenshot(driver, Classname ,method.getName()+"_01" );
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on collapse icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get \"User Management\" in collapse mode.");
		  Assert.assertEquals(false, driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).isDisplayed());
		  Assert.assertEquals(false, driver.findElement(By.xpath(User_Management_R.btn_Manage_Configurations)).isDisplayed());
		  Assert.assertEquals(false, driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).isDisplayed());
		  Assert.assertEquals(false, driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).isDisplayed());
	  }
	
	@Test(priority=05, description="To verify that user is able to get \"Manage Users\" in \"User Management\" screen.")
	  public void SGL_Ranchi_Admin_Language_05() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Users\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landing page of \"User Management\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.label_Manage_User)).isDisplayed());
	  }
	
	@Test(priority=06, description="To verify that user is able to perform  \"Add User\" functionality.")
	  public void SGL_Ranchi_Admin_Language_06() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Users\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Add User\" button.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.btn_Add_User)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select particular role from the \"Role\" list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"Roleid\"]")));  
		  dropdown.selectByValue("56"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Enter valid first name in \"First Name\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_First_Name)).sendKeys("Meet");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Enter valid middle name in \"Middle Name\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Middle_Name)).sendKeys("Ghanshyambhai");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b>  Enter valid last name in \"Last Name\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Last_Name)).sendKeys("Gondaliya");
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Enter valid user name in \"Username\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Login_Name)).sendKeys("MeetQAT");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14:</b> Enter valid mobile no. in \"Mobile No.\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Mobile_No)).sendKeys("9027324787");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15:</b> Enter valid email-id in \"Email Address\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_EmailId)).sendKeys("meegftf.g@sgligis.com"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16:</b> Click on \"Register\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Register)).click();
		  Thread.sleep(10000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) User should get successful message as\r\n"
		  		+ " \"User Added Successfully and Password sent through e-mail.\"\r\n"
		  		+ "2) Added user should be display in manage user list.");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Success_Message)).isDisplayed());
	  }
	
	@Test(priority=07, description="To verify that user is able to perform \"Cancel\" register user functionality.")
	  public void SGL_Ranchi_Admin_Language_07() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Users\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Add User\" button.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.btn_Add_User)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Cancel\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Cancel)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should not able to register user and get landing page of the \"User Management\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.label_Manage_User)).isDisplayed());
	  }
	
	@Test(priority=8, description="To verify that user is able to perform \"Edit\" functionality.")
	  public void SGL_Ranchi_Admin_Language_08() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application."); 
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel." ); 
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Users\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Edit\" button.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.btn_Edit_User)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Change selected role from the \"Role\" list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@name=\"Roleid\"]")));  
		  dropdown.selectByValue("56"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b>  Change existing first name in \"First Name\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_First_Name)).sendKeys("");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Change existing middle name in \"Middle Name\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Middle_Name)).sendKeys("");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Change existing last name in \"Last Name\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Last_Name)).sendKeys("");
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Change existing mobile No. in \"Mobile No.\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Mobile_No)).sendKeys("");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14:</b> Change existing email-Id in \"Email Address\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_EmailId)).sendKeys(""); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15:</b> Click on \"Update\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Update)).click();
		  Thread.sleep(5000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) User should get successful message as\r\n"
		  		+ " \"User details updated successfully.\"\r\n"
		  		+ "2) Updated user should be display in manage user list.");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Success_Message_Update)).isDisplayed());
	  }
	
	@Test(priority=9, description="To verify that user is able to perform \"Delete\" functionality.")
	  public void SGL_Ranchi_Admin_Language_09() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application."); 
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel." ); 
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Users\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Delete\" button for the particular user.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.btn_Delete_User)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Yes\" button of the confirmation message of the Delete user.");
		  driver.findElement(By.xpath(User_Management_R.btn_Yes_User_Delete)).click();
		  Thread.sleep(5000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) User should get successful message as\r\n"
		  		+ " \"User deleted successfully.\"\r\n"
		  		+ "2) User should be deleted from manage user list.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"sweet-alert showSweetAlert visible\"]")).isDisplayed());
	  }
	
	@Test(priority=10, description="To verify that user is able to perform \"Active/In-Active\" functionality.")
	  public void SGL_Ranchi_Admin_Language_10(Method method) throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application."); 
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel." ); 
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Users\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Check on \"Active/In-Active\" button for the particular user.");
		  driver.findElement(By.xpath(User_Management_R.btn_Active_User)).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath(User_Management_R.btn_Ok)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the succesfull message,\r\n"
		  		+ "\"User Inactive successfully.\"");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.btn_Active_User)).isSelected());
		  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Check on \"Active/In-Active\" button for the particular user.");
		  driver.findElement(By.xpath(User_Management_R.btn_Active_User)).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath(User_Management_R.btn_Ok)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the succesfull message,\r\n"
		  		+ "\"User Active successfully.\"");
		  Assert.assertEquals(false, driver.findElement(By.xpath(User_Management_R.btn_Active_User)).isSelected());
	  }
	
	@Test(priority=11, description="To verify that user is able to perform \"Delete Multiple\" functionality.To verify that user is able to perform \"Delete Multiple\" functionality.")
	  public void SGL_Ranchi_Admin_Language_11() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application."); 
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel." ); 
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Users\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select the users from \"Users\" list.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.btn_Select_User)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:/b>Click on \"Delete Multiple\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Delete_Multiple_User)).click();
		  Thread.sleep(3000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b>User should get confirmation massage for delete user. ");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"sweet-alert showSweetAlert visible\"]")).isDisplayed());
	  }
	
	@Test(priority=12, description="To verify that user is able to perform \"Search\" functionality.")
	  public void SGL_Ranchi_Admin_Language_12() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application."); 
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel." ); 
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Users\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter search criteria into \"Search\" textbox.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].value='admin';",  driver.findElement(By.xpath(User_Management_R.txt_Search)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the searched result into User Data grid.");
		  Assert.assertEquals("admin", driver.findElement(By.xpath("//tr[1]/td[10]")).getText());
	  }
	
	@Test(priority=13, description="To verify that user is able to select number of records show on user data grid.")
	  public void SGL_Ranchi_Admin_Language_13() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application."); 
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel." ); 
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Users\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select number from the \"Show No. of Entries\" dropdown list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@name=\"tbluser_length\"]")));  
		  dropdown.selectByValue("50"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the selected number of the records on Data User grid.");
		  Assert.assertNotEquals("10", driver.findElement(By.xpath("//tr/td[5]/input")).getText());
	  }
	
	@Test(priority=14, description="To verify that user is able to perform \"Sorting\" functionality for the SR. NO. , Name, User Name, Email Address, Role Name, Created By, and Created On columns of the user data grid.")
	  public void SGL_Ranchi_Admin_Language_14(Method method) throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application."); 
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel." ); 
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Users\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
		  Thread.sleep(2000);
		  List<WebElement> element1 = driver.findElements(By.xpath("//tr/td[2]"));
		  System.out.println(element1.size());
		  String[] stringArray2 = new String[element1.size()];
		  for(int i =0; i<element1.size(); i++) {
			 
			 stringArray2[i]=driver.findElements(By.xpath("//tr/td[2]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element1.size(); i++) {
				 
			  System.out.println(stringArray2[i]);
			  }  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Sorting\" icon of the SR. NO. column.");
		  driver.findElement(By.xpath(User_Management_R.btn_Sorting_SR)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Click on \"Sorting\" icon of the SR. NO. column.");
		  List<WebElement> element2 = driver.findElements(By.xpath("//tr/td[2]"));
		  System.out.println(element2.size());
		  String[] stringArray3 = new String[element2.size()];
		  for(int i =0; i<element1.size(); i++) {
			 
			 stringArray3[i]=driver.findElements(By.xpath("//tr/td[2]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element1.size(); i++) {
				 
			  System.out.println(stringArray3[i]);
			  }
		  Assert.assertEquals(stringArray3,stringArray2);
		 objs.Screenshot(driver, Classname ,method.getName()+"_01" );
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Sorting\" icon of the SR. NO. column.");
		  driver.findElement(By.xpath(User_Management_R.btn_Sorting_SR)).click();
		  
		  Thread.sleep(2000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid on Ascending order..");
		 
		  List<WebElement> element4 = driver.findElements(By.xpath("//tr/td[2]"));
		  System.out.println(element4.size());
		  String[] stringArray4 = new String[element2.size()];
		  for(int i =0; i<element1.size(); i++) {
			 
			 stringArray4[i]=driver.findElements(By.xpath("//tr/td[2]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element4.size(); i++) {
				 
			  System.out.println(stringArray4[i]);
			  } 
		  Assert.assertNotEquals(stringArray3,stringArray4);
		  List<WebElement> element5 = driver.findElements(By.xpath("//tr/td[6]"));
		  System.out.println(element5.size());
		  String[] stringArray5 = new String[element5.size()];
		  for(int i =0; i<element5.size(); i++) 
		  {
		    stringArray5[i]=driver.findElements(By.xpath("//tr/td[6]")).get(i).getText();
			Thread.sleep(2000);
		  } 
		  for(int i =0; i<element5.size(); i++) 
		  {
		    System.out.println(stringArray5[i]);
			
		  }  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Sorting\" icon of the Name column.");
		  driver.findElement(By.xpath("//th[text()=\"Name\"]")).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid in alphabetical order.");
		  List<WebElement> element6 = driver.findElements(By.xpath("//tr/td[6]"));
		  System.out.println(element6.size());
		  String[] stringArray6 = new String[element6.size()];
		  for(int i =0; i<element6.size(); i++) {
			 
			 stringArray6[i]=driver.findElements(By.xpath("//tr/td[6]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element6.size(); i++) {
				 
			  System.out.println(stringArray6[i]);
			  }
		  Assert.assertNotEquals(stringArray6,stringArray5);
		  objs.Screenshot(driver, Classname ,method.getName()+"_02" ); 
		  List<WebElement> element7 = driver.findElements(By.xpath("//tr/td[7]"));
		  System.out.println(element7.size());
		  String[] stringArray7 = new String[element7.size()];
		  for(int i =0; i<element7.size(); i++) 
		  {
		    stringArray7[i]=driver.findElements(By.xpath("//tr/td[7]")).get(i).getText();
			Thread.sleep(2000);
		  } 
		  for(int i =0; i<element7.size(); i++) 
		  {
		    System.out.println(stringArray7[i]);
			
		  }  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Sorting\" icon of the User Name column.");
		  driver.findElement(By.xpath("//th[text()=\"Username\"]")).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid in alphabetical order.");
		  List<WebElement> element8 = driver.findElements(By.xpath("//tr/td[7]"));
		  System.out.println(element8.size());
		  String[] stringArray8 = new String[element8.size()];
		  for(int i =0; i<element8.size(); i++) {
			 
			 stringArray8[i]=driver.findElements(By.xpath("//tr/td[7]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element8.size(); i++) {
				 
			  System.out.println(stringArray8[i]);
			  }
		  Assert.assertNotEquals(stringArray7,stringArray8);
		  objs.Screenshot(driver, Classname ,method.getName()+"_03" );
		  List<WebElement> element9 = driver.findElements(By.xpath("//tr/td[8]"));
		  System.out.println(element9.size());
		  String[] stringArray9 = new String[element9.size()];
		  for(int i =0; i<element9.size(); i++) 
		  {
		    stringArray9[i]=driver.findElements(By.xpath("//tr/td[8]")).get(i).getText();
			Thread.sleep(2000);
		  } 
		  for(int i =0; i<element9.size(); i++) 
		  {
		    System.out.println(stringArray9[i]);
			
		  }  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"Sorting\" icon of the Email Address column.");
		  driver.findElement(By.xpath("//th[text()=\"Email Address\"]")).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid in alphabetical order.");
		  List<WebElement> element10 = driver.findElements(By.xpath("//tr/td[8]"));
		  System.out.println(element10.size());
		  String[] stringArray10 = new String[element10.size()];
		  for(int i =0; i<element10.size(); i++) {
			 
			 stringArray10[i]=driver.findElements(By.xpath("//tr/td[8]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element10.size(); i++) {
				 
			  System.out.println(stringArray10[i]);
			  }
		  Assert.assertNotEquals(stringArray9,stringArray10);
		  objs.Screenshot(driver, Classname ,method.getName()+"_04" );
		  List<WebElement> element11 = driver.findElements(By.xpath("//tr/td[9]"));
		  System.out.println(element11.size());
		  String[] stringArray11 = new String[element11.size()];
		  for(int i =0; i<element11.size(); i++) 
		  {
		    stringArray11[i]=driver.findElements(By.xpath("//tr/td[9]")).get(i).getText();
			Thread.sleep(2000);
		  } 
		  for(int i =0; i<element11.size(); i++) 
		  {
		    System.out.println(stringArray11[i]);
			
		  }  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on \"Sorting\" icon of the Role Name column.");
		  driver.findElement(By.xpath("//th[text()=\"Role Name\"]")).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid in alphabetical order.");
		  List<WebElement> element12 = driver.findElements(By.xpath("//tr/td[9]"));
		  System.out.println(element12.size());
		  String[] stringArray12 = new String[element12.size()];
		  for(int i =0; i<element12.size(); i++) {
			 
			 stringArray12[i]=driver.findElements(By.xpath("//tr/td[9]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element12.size(); i++) {
				 
			  System.out.println(stringArray12[i]);
			  }
		  Assert.assertNotEquals(stringArray12,stringArray11);
		  objs.Screenshot(driver, Classname ,method.getName()+"_05" );
		  List<WebElement> element13 = driver.findElements(By.xpath("//tr/td[10]"));
		  System.out.println(element13.size());
		  String[] stringArray13 = new String[element13.size()];
		  for(int i =0; i<element13.size(); i++) 
		  {
		    stringArray13[i]=driver.findElements(By.xpath("//tr/td[10]")).get(i).getText();
			Thread.sleep(2000);
		  } 
		  for(int i =0; i<element13.size(); i++) 
		  {
		    System.out.println(stringArray13[i]);
			
		  }  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Click on \"Sorting\" icon of the Created By column.");
		  driver.findElement(By.xpath("//th[text()=\"Created By\"]")).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid in alphabetical order.");
		  List<WebElement> element14 = driver.findElements(By.xpath("//tr/td[10]"));
		  System.out.println(element14.size());
		  String[] stringArray14 = new String[element14.size()];
		  for(int i =0; i<element14.size(); i++) {
			 
			 stringArray14[i]=driver.findElements(By.xpath("//tr/td[10]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element14.size(); i++) {
				 
			  System.out.println(stringArray14[i]);
			  }
		  Assert.assertNotEquals(stringArray13,stringArray14);
		  objs.Screenshot(driver, Classname ,method.getName()+"_06" );
		  List<WebElement> element15 = driver.findElements(By.xpath("//tr/td[11]"));
		  System.out.println(element15.size());
		  String[] stringArray15 = new String[element15.size()];
		  for(int i =0; i<element15.size(); i++) 
		  {
		    stringArray15[i]=driver.findElements(By.xpath("//tr/td[11]")).get(i).getText();
			Thread.sleep(2000);
		  } 
		  for(int i =0; i<element15.size(); i++) 
		  {
		    System.out.println(stringArray15[i]);
			
		  }  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14:</b> Click on \"Sorting\" icon of the Created On column.");
		  driver.findElement(By.xpath("//th[text()=\"Created On\"]")).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid in alphabetical order.");
		  List<WebElement> element16 = driver.findElements(By.xpath("//tr/td[11]"));
		  System.out.println(element16.size());
		  String[] stringArray16 = new String[element16.size()];
		  for(int i =0; i<element16.size(); i++) {
			 
			 stringArray16[i]=driver.findElements(By.xpath("//tr/td[11]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element16.size(); i++) {
				 
			  System.out.println(stringArray16[i]);
			  }
		  Assert.assertNotEquals(stringArray15,stringArray16);
  
	  }
	
	@Test(priority=15, description="To verify that user is able to \"Select All\" users from the user data grid.")
	  public void SGL_Ranchi_Admin_Language_15() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application."); 
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel." ); 
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Users\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on check box of the header row from the User data grid.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();",   driver.findElement(By.xpath(User_Management_R.chk_Select_All)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get all the user from the user data grid as selected.");
		  List<WebElement> element1 = driver.findElements(By.xpath("//tr/td[1]/input"));
		  System.out.println(element1.size());
		  for(int i =0; i<element1.size(); i++) {
			  Assert.assertEquals(true,driver.findElement(By.xpath("//tr/td[1]/input")).isSelected());
			 Thread.sleep(1000);
		  } 
	  }
	
	@Test(priority=16, description="To verify that user is able to select particular user from the user data grid.")
	  public void SGL_Ranchi_Admin_Language_16(Method method) throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application."); 
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel." ); 
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Users\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
		  Thread.sleep(2000);
		  List<WebElement> element1 = driver.findElements(By.xpath("//tr/td[1]/input"));
		  System.out.println(element1.size());
		  for(int i =0; i<element1.size(); i++) {
			  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8."+i+":</b> Click on check box of the particular user from the user data grid.");
			  element1.get(i).click();
			  Thread.sleep(2000);
			  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get particular user from the user data grid as selected.");
			  Assert.assertEquals(true,driver.findElement(By.xpath("//tr/td[1]/input")).isSelected());
			  Thread.sleep(1000);
			  objs.Screenshot(driver, Classname ,method.getName()+"_"+i );
		  } 
	  }
	
	@Test(priority=17, description="To verify that user is able to perform \"Pagination\" functionality.")
	  public void SGL_Ranchi_Admin_Language_17(Method method) throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application."); 
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel." ); 
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Users\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Next\" button of the paging.");
		  driver.findElement(By.xpath(User_Management_R.btn_Next)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get next page of the User Data grid.");
		  Assert.assertEquals("2",driver.findElement(By.xpath("//a[@class=\"paginate_button current\"]")).getText());
		  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Previous\" button of the paging.");
		  driver.findElement(By.xpath(User_Management_R.btn_Previous)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Click on \"Previous\" button of the paging.");
		  Assert.assertEquals("1",driver.findElement(By.xpath("//a[@class=\"paginate_button current\"]")).getText());
	  }
	
	@Test(priority=18, description="To verify that user is able to check \"Number of Entries\" are available in user data grid.")
	  public void SGL_Ranchi_Admin_Language_18() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application."); 
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel." ); 
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Users\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Check \"No. of Entries\" status on footer of the user data grid.");
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the \"No. of the Entries\" availability status of the user data grid.");
		  Assert.assertEquals(true,driver.findElement(By.xpath("//div[@id=\"tbluser_info\"]")).isDisplayed());
	  }
	
	@Test(priority=19, description="To verify that user is able to perform \"Dashboard\" functionality from \"User Management\" screen.")
	  public void SGL_Ranchi_Admin_Language_19() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application."); 
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel." ); 
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Users\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Dashboard\" icon from \"User Management\" screen.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Dashboard)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on landing page of \"Admin\" department.");
		  Assert.assertEquals(true,driver.findElement(By.xpath("//span[text()=\"Roles\"]")).isDisplayed());
	  }
	
	@Test(priority=20, description="To verify that user is able to perform \"Dashboard\" functionality from \"Add User\" screen.")
	  public void SGL_Ranchi_Admin_Language_20() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application."); 
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel." ); 
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Users\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Add User\" button.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.btn_Add_User)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Dashboard\" icon from \"Add User\" screen.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Dashboard)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on landing page of \"Admin\" department.");
		  Assert.assertEquals(true,driver.findElement(By.xpath("//span[text()=\"Roles\"]")).isDisplayed());
	  }
	
	@Test(priority=21, description="To verify that user is able to perform \"Manage Users\" functionality from \"Add User\" screen.")
	  public void SGL_Ranchi_Admin_Language_21() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application."); 
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel." ); 
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Users\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Add User\" button.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.btn_Add_User)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Manage Users\" icon from \"Add User\" screen.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Manage_User)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on landing page of \"User Management\" screen.");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.label_Manage_User)).isDisplayed());
	  }
	
	@Test(priority=22, description="To verify that user is able to perform \"Dashboard\" functionality from \"Edit User\" screen.")
	  public void SGL_Ranchi_Admin_Language_22() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application."); 
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel." ); 
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Users\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Edit\" button.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.btn_Edit_User)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Dashboard\" icon from \"Add User\" screen.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Dashboard)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on landing page of \"Admin\" department.");
		  Assert.assertEquals(true,driver.findElement(By.xpath("//span[text()=\"Roles\"]")).isDisplayed());
	  }
	
	@Test(priority=23, description="To verify that user is able to perform \"Manage Users\" functionality from \"Edit User\" screen.")
	  public void SGL_Ranchi_Admin_Language_23() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application."); 
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel." ); 
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Users\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Edit\" button.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.btn_Edit_User)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Manage Users\" icon from \"Add User\" screen.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Manage_User)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on landing page of \"User Management\" screen.");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.label_Manage_User)).isDisplayed());
	  }
	
	@Test(priority=24, description="To verify that user is not able to add user with blank required details.")
	  public void SGL_Ranchi_Admin_Language_24() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application."); 
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel." ); 
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Users\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Add User\" button.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.btn_Add_User)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Register\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Register)).click();
		  Thread.sleep(10000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the validation massage like.\r\n"
		  		+ "\"Please select Role\"\r\n"
		  		+ "\"Please Enter First Name\"\r\n"
		  		+ "\"Please Enter Last Name\"\r\n"
		  		+ "\"Please Enter Username\"\r\n"
		  		+ "\"Please Enter Mobile No.\"\r\n"
		  		+ "\"Please Enter Email Address\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_Email)).isDisplayed());
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_First_Name)).isDisplayed());
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_last_Name)).isDisplayed());
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_Mobile_No)).isDisplayed());
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_User_Name)).isDisplayed()); 
	  }
	
	@Test(priority=25, description="To verify that user is not able to add user with In-valid Mobile No.")
	  public void SGL_Ranchi_Admin_Language_25() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Users\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Add User\" button.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.btn_Add_User)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select particular role from the \"Role\" list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"Roleid\"]")));  
		  dropdown.selectByValue("56"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Enter valid first name in \"First Name\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_First_Name)).sendKeys("Meet");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Enter valid middle name in \"Middle Name\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Middle_Name)).sendKeys("Ghanshyambhai");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b>  Enter valid last name in \"Last Name\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Last_Name)).sendKeys("Gondaliya");
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Enter valid user name in \"Username\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Login_Name)).sendKeys("MeetQAT");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14:</b> Enter In-valid Mobile number in Mobile No. textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Mobile_No)).sendKeys("9027787");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15:</b> Enter valid email-id in \"Email Address\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_EmailId)).sendKeys("meegftf.g@sgligis.com"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16:</b> Click on \"Register\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Register)).click();
		  Thread.sleep(10000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the validation message like,\r\n"
		  		+ " \"Please enter valid mobile number\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Please enter valid mobile number\"]")).isDisplayed());
	  }
	
	@Test(priority=26, description="To verify that user is not able to add user with In-valid Email-id.")
	  public void SGL_Ranchi_Admin_Language_26() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Users\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Add User\" button.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.btn_Add_User)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select particular role from the \"Role\" list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"Roleid\"]")));  
		  dropdown.selectByValue("56"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Enter valid first name in \"First Name\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_First_Name)).sendKeys("Meet");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Enter valid middle name in \"Middle Name\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Middle_Name)).sendKeys("Ghanshyambhai");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b>  Enter valid last name in \"Last Name\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Last_Name)).sendKeys("Gondaliya");
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Enter valid user name in \"Username\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Login_Name)).sendKeys("MeetQAT");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14:</b> Enter valid Mobile number in Mobile No. textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Mobile_No)).sendKeys("9023325787");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15:</b> Enter In-valid email-id in \"Email Address\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_EmailId)).sendKeys("meegfsgligis.com"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16:</b> Click on \"Register\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Register)).click();
		  Thread.sleep(10000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the validation message like,\r\n"
		  		+ " \"Please Enter valid email address\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Please enter valid email address\"]")).isDisplayed());
	  }
	
	@Test(priority=27, description="To verify that user is not able to perform \"Delete Multiple\" functionality without selection of roles.")
	  public void SGL_Ranchi_Admin_Language_27() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Users\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Delete Multiple\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Delete_Multiple_User)).click();
		  Thread.sleep(3000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the validation message like,\r\n"
		  		+ "\"Please Select Users\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Select_User)).isDisplayed());  
	  }
	
	@Test(priority=28, description="To verify that user is able to get \"Role Management\" screen.")
	  public void SGL_Ranchi_Admin_Language_28() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Roles\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landing page of \"Role Management\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.label_Manage_Roles)).isDisplayed());  
	  }
	
	@Test(priority=29, description="To verify that user is able to perform  \"Add Role\" functionality.")
	  public void SGL_Ranchi_Admin_Language_29() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Roles\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Add Role\" button.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(User_Management_R.btn_Add_Role)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Enter valid role name in \"Role Name\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Role_Code)).sendKeys("Testing");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Enter valid role code in \"Role code\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Role_Name)).sendKeys("Tester");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b>  Enter required Description for the Role.");
		  driver.findElement(By.xpath(User_Management_R.txt_Description)).sendKeys("User is able to testing all functionality.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on \"Save\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Save)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) User should get successful message as\r\n"
		  		+ " \"Role inserted successfully.\"\r\n"
		  		+ "2) Added role should be display in manage role list.");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Success_Message_Role)).isDisplayed());  
	  }
	
	@Test(priority=30, description="To verify that user is able to perform \"Cancel\" add role functionality.")
	  public void SGL_Ranchi_Admin_Language_30() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Roles\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Add Role\" button.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(User_Management_R.btn_Add_Role)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b>  Click on \"Cancel\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Cancel)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should not able to add role and get landing page of the \"Role Management\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.label_Manage_Roles)).isDisplayed()); 
	  }
	
	@Test(priority=31, description="To verify that user is able to perform \"Edit\" functionality.")
	  public void SGL_Ranchi_Admin_Language_31() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Roles\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Edit\" button.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].value='Testing';",  driver.findElement(By.xpath(User_Management_R.txt_Search)));
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(User_Management_R.btn_Edit_User)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Change existing role name in \"Role Name\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Role_Code)).sendKeys("");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Change existing role code in \"Role Code\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Role_Name)).sendKeys("");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Change existing description in \"Description\" text area.");
		  driver.findElement(By.xpath(User_Management_R.txt_Description)).sendKeys("");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on \"Update\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Update)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) User should get successful message as\r\n"
		  		+ " \"Role updated successfully.\"\r\n"
		  		+ "2) Updated role should be display in manage role list.");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Success_Message_Update_Role)).isDisplayed());  
	  }
	
	@Test(priority=32, description="To verify that user is able to perform \"Delete\" functionality.")
	  public void SGL_Ranchi_Admin_Language_32() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Roles\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Delete\" button for the particular user.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].value='Testing';",  driver.findElement(By.xpath(User_Management_R.txt_Search)));
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(User_Management_R.btn_Delete_User)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User  should get confirmation message for delete role.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"sweet-alert showSweetAlert visible\"]")).isDisplayed());  
	  }
	
	@Test(priority=33, description="To verify that user is able to perform \"Active/In-Active\" functionality.")
	  public void SGL_Ranchi_Admin_Language_33(Method method) throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Roles\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Check on \"Active\" Checkbox for the particular role.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(User_Management_R.btn_Active_User)));
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(User_Management_R.btn_Ok)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the succesfull message,\r\n"
		  		+ "\"Role Inactive Successfully.\"");
		  Assert.assertEquals(false, driver.findElement(By.xpath(User_Management_R.btn_Active_User)).isSelected());
		  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Check on \"In-Active\" Checkbox for the particular role.");
		  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(User_Management_R.btn_Active_User)));
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(User_Management_R.btn_Ok)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the succesfull message,\r\n"
		  		+ "\"Role Active Successfully.\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.btn_Active_User)).isSelected()); 
	  }
	
	@Test(priority=34, description="To verify that user is able to perform \"Delete Multiple\" functionality.")
	  public void SGL_Ranchi_Admin_Language_34() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Roles\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select the roles from the role list.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(User_Management_R.btn_Select_User)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:/b> Click on \"Delete Multiple\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Delete_Multiple_User)).click();
		  Thread.sleep(3000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User  should get confirmation message for delete role.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"sweet-alert showSweetAlert visible\"]")).isDisplayed());
	  }
	
	@Test(priority=35, description="To verify that user is able to perform \"Search\" functionality.")
	  public void SGL_Ranchi_Admin_Language_35() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Roles\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter Search criteria into Search textbox.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].value='Testing';",  driver.findElement(By.xpath(User_Management_R.txt_Search)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the searched result into User Data grid.");
		  Assert.assertEquals("Testing", driver.findElement(By.xpath("//tr[2]/td[6]")).getText());
	  }
	
	@Test(priority=36, description="To verify that user is able to select number of records show on role data grid.")
	  public void SGL_Ranchi_Admin_Language_36() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Roles\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select Number from the \"Show No. of Entries\" dropdown list.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//option[@value=\"50\"]")));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the selected number of the records on Data User grid.");
		  Assert.assertNotEquals("10", driver.findElement(By.xpath("//tr/td[5]/input")).getText());
	  }
	
	@Test(priority=37, description="To verify that user is able to perform \"Sorting\" functionality for the SR. NO., Role Name, Role Code, and Description on columns of the Role Data grid..")
	  public void SGL_Ranchi_Admin_Language_37(Method method) throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Roles\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
		  Thread.sleep(2000);
		  List<WebElement> element1 = driver.findElements(By.xpath("//tr/td[2]"));
		  System.out.println(element1.size());
		  String[] stringArray2 = new String[element1.size()];
		  for(int i =0; i<element1.size(); i++) {
			 
			 stringArray2[i]=driver.findElements(By.xpath("//tr/td[2]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element1.size(); i++) {
				 
			  System.out.println(stringArray2[i]);
			  }  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Sorting\" icon of the SR. NO. column..");
		  driver.findElement(By.xpath(User_Management_R.btn_Sorting_SR)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid on Descending order.");
		  List<WebElement> element2 = driver.findElements(By.xpath("//tr/td[2]"));
		  System.out.println(element2.size());
		  String[] stringArray3 = new String[element2.size()];
		  for(int i =0; i<element1.size(); i++) {
			 
			 stringArray3[i]=driver.findElements(By.xpath("//tr/td[2]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element1.size(); i++) {
				 
			  System.out.println(stringArray3[i]);
			  }
		  Assert.assertEquals(stringArray3,stringArray2);
		  objs.Screenshot(driver, Classname ,method.getName()+"_01" );
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Sorting\" icon of the SR. NO. column.");
		  driver.findElement(By.xpath(User_Management_R.btn_Sorting_SR)).click();
		  
		  Thread.sleep(2000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get records in Ascending/Descending order.");
		 
		  List<WebElement> element4 = driver.findElements(By.xpath("//tr/td[2]"));
		  System.out.println(element4.size());
		  String[] stringArray4 = new String[element2.size()];
		  for(int i =0; i<element1.size(); i++) {
			 
			 stringArray4[i]=driver.findElements(By.xpath("//tr/td[2]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element4.size(); i++) {
				 
			  System.out.println(stringArray4[i]);
			  } 
		  Assert.assertNotEquals(stringArray3,stringArray4);
		  objs.Screenshot(driver, Classname ,method.getName()+"_02" );
		  List<WebElement> element5 = driver.findElements(By.xpath("//tr/td[6]"));
		  System.out.println(element5.size());
		  String[] stringArray5 = new String[element5.size()];
		  for(int i =0; i<element5.size(); i++) 
		  {
		    stringArray5[i]=driver.findElements(By.xpath("//tr/td[6]")).get(i).getText();
			Thread.sleep(2000);
		  } 
		  for(int i =0; i<element5.size(); i++) 
		  {
		    System.out.println(stringArray5[i]);
			
		  }  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Sorting\" icon of the Role Name column..");
		  driver.findElement(By.xpath("//th[text()=\"Role Name\"]")).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid in alphabetical order.");
		  List<WebElement> element6 = driver.findElements(By.xpath("//tr/td[6]"));
		  System.out.println(element6.size());
		  String[] stringArray6 = new String[element6.size()];
		  for(int i =0; i<element6.size(); i++) {
			 
			 stringArray6[i]=driver.findElements(By.xpath("//tr/td[6]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element6.size(); i++) {
				 
			  System.out.println(stringArray6[i]);
			  }
		  Assert.assertNotEquals(stringArray6,stringArray5);
		  objs.Screenshot(driver, Classname ,method.getName()+"_03" ); 
		  List<WebElement> element7 = driver.findElements(By.xpath("//tr/td[7]"));
		  System.out.println(element7.size());
		  String[] stringArray7 = new String[element7.size()];
		  for(int i =0; i<element7.size(); i++) 
		  {
		    stringArray7[i]=driver.findElements(By.xpath("//tr/td[7]")).get(i).getText();
			Thread.sleep(2000);
		  } 
		  for(int i =0; i<element7.size(); i++) 
		  {
		    System.out.println(stringArray7[i]);
			
		  }  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"Sorting\" icon of the Role Code column.");
		  driver.findElement(By.xpath("//th[text()=\"Role Code\"]")).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid in alphabetical order.");
		  List<WebElement> element8 = driver.findElements(By.xpath("//tr/td[7]"));
		  System.out.println(element8.size());
		  String[] stringArray8 = new String[element8.size()];
		  for(int i =0; i<element8.size(); i++) {
			 
			 stringArray8[i]=driver.findElements(By.xpath("//tr/td[7]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element8.size(); i++) {
				 
			  System.out.println(stringArray8[i]);
			  }
		  Assert.assertNotEquals(stringArray7,stringArray8);
		  objs.Screenshot(driver, Classname ,method.getName()+"_04" );
		  List<WebElement> element9 = driver.findElements(By.xpath("//tr/td[8]"));
		  System.out.println(element9.size());
		  String[] stringArray9 = new String[element9.size()];
		  for(int i =0; i<element9.size(); i++) 
		  {
		    stringArray9[i]=driver.findElements(By.xpath("//tr/td[8]")).get(i).getText();
			Thread.sleep(2000);
		  } 
		  for(int i =0; i<element9.size(); i++) 
		  {
		    System.out.println(stringArray9[i]);
			
		  }  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on \"Sorting\" icon of the Description column.");
		  driver.findElement(By.xpath("//th[text()=\"Description\"]")).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid in alphabetical order.");
		  List<WebElement> element10 = driver.findElements(By.xpath("//tr/td[8]"));
		  System.out.println(element10.size());
		  String[] stringArray10 = new String[element10.size()];
		  for(int i =0; i<element10.size(); i++) {
			 
			 stringArray10[i]=driver.findElements(By.xpath("//tr/td[8]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element10.size(); i++) {
				 
			  System.out.println(stringArray10[i]);
			  }
		  Assert.assertNotEquals(stringArray9,stringArray10);
	  }
	
	@Test(priority=38, description="To verify that user is able to \"Select All\" roles from the role data grid.")
	  public void SGL_Ranchi_Admin_Language_38() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Roles\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on check box of the header row from the role data grid.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.chk_Select_All)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get all the role from the role data grid as selected.");
		  List<WebElement> element1 = driver.findElements(By.xpath("//tr/td[1]/input"));
		  System.out.println(element1.size());
		  for(int i =0; i<element1.size(); i++) {
			  Assert.assertEquals(true,driver.findElement(By.xpath("//tr/td[1]/input")).isSelected());
			 Thread.sleep(1000);
		  } 
	  }
	
	@Test(priority=39, description="To verify that user is able to select particular role from the role data grid.")
	  public void SGL_Ranchi_Admin_Language_39(Method method) throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Roles\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
		  Thread.sleep(2000);
		  List<WebElement> element1 = driver.findElements(By.xpath("//tr/td[1]/input"));
		  System.out.println(element1.size());
		  for(int i =0; i<element1.size(); i++) {
			  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8."+i+":</b> Click on check box of the particular role from the role data grid.");
			  JavascriptExecutor executor = (JavascriptExecutor)driver;
			  executor.executeScript("arguments[0].click();",  element1.get(i));
			  Thread.sleep(2000);
			  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get particular role from the role data grid as selected.");
			  Assert.assertEquals(true,driver.findElement(By.xpath("//tr/td[1]/input")).isSelected());
			  Thread.sleep(1000);
			  objs.Screenshot(driver, Classname ,method.getName()+"_"+i );
		  } 
	  }
	
	@Test(priority=41, description="To verify that user is able to check \"Number of Entries\" are available in role data grid.")
	  public void SGL_Ranchi_Admin_Language_41() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Roles\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Check \"No. of Entries\" status on footer of the role data grid.");
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the \"No. of the Entries\" availability status of the role data grid.");
		  Assert.assertEquals(true,driver.findElement(By.xpath("//div[@id=\"tbluser_info\"]")).isDisplayed());
	  }
	
	@Test(priority=42, description="To verify that user is able to perform \"Dashboard\" functionality from \"Role Management\" screen.")
	  public void SGL_Ranchi_Admin_Language_42() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Roles\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Dashboard\" icon from \"User Management\" screen.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Dashboard)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on landing page of \"Admin\" department.");
		  Assert.assertEquals(true,driver.findElement(By.xpath("//span[text()=\"Roles\"]")).isDisplayed());
	  }
	
	@Test(priority=43, description="To verify that user is able to perform \"Dashboard\" functionality from \"Add Role\" screen.")
	  public void SGL_Ranchi_Admin_Language_43() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Roles\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Add Role\" button.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(User_Management_R.btn_Add_Role)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Dashboard\" icon from \"User Management\" screen.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Dashboard)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on landing page of \"Admin\" department.");
		  Assert.assertEquals(true,driver.findElement(By.xpath("//span[text()=\"Roles\"]")).isDisplayed());
	  }
	
	@Test(priority=44, description="To verify that user is able to perform \"Manage Roles\" functionality from \"Add Role\" screen.")
	  public void SGL_Ranchi_Admin_Language_44() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Roles\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Add Role\" button.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(User_Management_R.btn_Add_Role)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Manage Roles\" icon from \"Add Role\" screen.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Manage_Roles)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on landing page of \"Role Management\" screen.");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.label_Manage_Roles)).isDisplayed());  
	  }
	
	@Test(priority=45, description="To verify that user is able to perform \"Dashboard\" functionality from \"Edit Role\" screen.")
	  public void SGL_Ranchi_Admin_Language_45() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Roles\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Edit\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Edit_User)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Dashboard\" icon from \"User Management\" screen.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Dashboard)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on landing page of \"Admin\" department.");
		  Assert.assertEquals(true,driver.findElement(By.xpath("//span[text()=\"Roles\"]")).isDisplayed());
	  }
	
	@Test(priority=46, description="To verify that user is able to perform \"Manage Roles\" functionality from \"Edit Role\" screen.")
	  public void SGL_Ranchi_Admin_Language_46() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Roles\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Edit\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Edit_User)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Manage Roles\" icon from \"Add Role\" screen.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Manage_Roles)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on landing page of \"Role Management\" screen.");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.label_Manage_Roles)).isDisplayed());  
	  }
	
	@Test(priority=47, description="To verify that user is not able to add role with blank required details.")
	  public void SGL_Ranchi_Admin_Language_47() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Roles\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Add Role\" button.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(User_Management_R.btn_Add_Role)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on \"Save\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Save)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the validation massage like.\r\n"
		  		+ "\"Please enter Role Name\"\r\n"
		  		+ "\"Please Enter Role Code\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_Role_Name)).isDisplayed());
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_Role_Code)).isDisplayed());  
	  }
	
	@Test(priority=48, description="To verify that user is not able to perform \"Delete Multiple\" functionality without selection of roles.")
	  public void SGL_Ranchi_Admin_Language_48() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Manage Roles\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click \"Delete Multiple\" button.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(User_Management_R.btn_Delete_Multiple_User)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get error message like: \"Please Select Roles\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Select_Role)).isDisplayed()); 
	  }
	
	@Test(priority=49, description="To verify that user is able to get \"Role Permission\" screen.")
	  public void SGL_Ranchi_Admin_Language_49() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Assign Role Permission\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landing page of Role Permission.");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.label_Assign_Role_Per)).isDisplayed());
	  }
	
	@Test(priority=50, description="To verify that user is able to assign \"Module Rights\" to particular role.")
	  public void SGL_Ranchi_Admin_Language_50() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Assign Role Permission\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select particular Role from the Role list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
		  dropdown.selectByValue("56"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Module Rights button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Module_Rights)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Select modules from the module list.");
		  driver.findElement(By.xpath(User_Management_R.chk_Dep_User)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"Save\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Save)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the successful message like,\r\n"
		  		+ "\"Modules Rights and Predefinded Query Rights assign sucsessfully.\"");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Module Rights and Predefinded Query Rights assign sucsessfully.\"]")).isDisplayed());
	  }
	
	@Test(priority=51, description="To verify that user is able to perform \"Check All\" functionality.")
	  public void SGL_Ranchi_Admin_Language_51() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Assign Role Permission\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select particular Role from the Role list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
		  dropdown.selectByValue("56"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Module Rights button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Module_Rights)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Check All\" button.");
		  driver.findElement(By.xpath("//a[text()=\"Check All\"]")).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"Save\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Save)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get success message for the modules are assigned to the role.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Module Rights and Predefinded Query Rights assign sucsessfully.\"]")).isDisplayed());
	  }
	
	@Test(priority=52, description="To verify that user is able to perform \"Uncheck All\" functionality.")
	  public void SGL_Ranchi_Admin_Language_52() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Assign Role Permission\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select particular Role from the Role list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
		  dropdown.selectByValue("56"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Module Rights button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Module_Rights)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Check All\" button.");
		  driver.findElement(By.xpath("//a[text()=\"Check All\"]")).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"Uncheck All\" button.");
		  driver.findElement(By.xpath("//a[text()=\"Uncheck All\"]")).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on \"Save\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Save)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get error message like: \"Please select at least one module.\"");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_MR)).isDisplayed());  
	  }
	
	@Test(priority=53, description="To verify that user is able to perform \"Invert\" functionality.")
	  public void SGL_Ranchi_Admin_Language_53() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Assign Role Permission\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select particular Role from the Role list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
		  dropdown.selectByValue("56"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Module Rights button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Module_Rights)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Check All\" button.");
		  driver.findElement(By.xpath("//a[text()=\"Check All\"]")).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on Invert button.");
		  driver.findElement(By.xpath("//a[text()=\"Invert\"]")).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on \"Save\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Save)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get error message like: \"Please select at least one module.\"");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_MR)).isDisplayed());  
	  }
	
	@Test(priority=54, description="To verify that user is able to perform \"Search\" functionality.")
	  public void SGL_Ranchi_Admin_Language_54() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Assign Role Permission\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select particular Role from the Role list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
		  dropdown.selectByValue("56"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Module Rights button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Module_Rights)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Enter module name in search textbox.");
		  driver.findElement(By.xpath("//input[@placeholder=\"Search module\"]")).sendKeys("admin");
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get result of searched module in module list.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//div[text()=\"Admin Menu (Left Panel)\"]")).isDisplayed());  
	  }
	
	@Test(priority=55, description="To verify that user is able to expand particular module from the module list.")
	  public void SGL_Ranchi_Admin_Language_55() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Assign Role Permission\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select particular Role from the Role list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
		  dropdown.selectByValue("56"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Module Rights button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Module_Rights)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on expand icon ahead from the particular module.");
		  driver.findElement(By.xpath(User_Management_R.btn_expand)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get result of searched module in module list.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[@class=\"jqx-tree-item-arrow-expand jqx-icon-arrow-down\"]")).isDisplayed()); 
	  }
	
	@Test(priority=56, description="To verify that user is able to perform \"Cancel\" functionality.")
	  public void SGL_Ranchi_Admin_Language_56() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Assign Role Permission\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select particular Role from the Role list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
		  dropdown.selectByValue("56"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Cancel button.");
		  driver.findElement(By.xpath("//button[text()=\"Cancel\"]")).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should be get the landing page of the administrator.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Roles\"]")).isDisplayed());  
	  }
	
	@Test(priority=57, description="To verify that user is able to perform \"Dashboard\" functionality from \"Role Permission\" screen.")
	  public void SGL_Ranchi_Admin_Language_57() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Assign Role Permission\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Dashboard\" icon from \"Role Permission\" screen.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Dashboard)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should be get the landing page of the administrator.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Roles\"]")).isDisplayed());  
	  }
	
	@Test(priority=58, description="To verify that user is able to assign \"Predefined Query Rights\" to particular role.")
	  public void SGL_Ranchi_Admin_Language_58() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Assign Role Permission\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select particular Role from the Role list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
		  dropdown.selectByValue("56"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Predefined Query Rights button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Predefined_Query_Rights)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Select predefined query from the query list.");
		  driver.findElement(By.xpath(User_Management_R.chk_Pre_Query)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Save\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Save)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get success message for the modules are assigned to the role.");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Success_Message_MR)).isDisplayed());
	  }
	
	@Test(priority=59, description="To verify that user is able to perform \"Check All\" functionality.")
	  public void SGL_Ranchi_Admin_Language_59() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Assign Role Permission\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select particular Role from the Role list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
		  dropdown.selectByValue("56"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Predefined Query Rights button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Predefined_Query_Rights)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Check All\" button.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.chk_Dep_All)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"Save\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Save)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get success message for the modules are assigned to the role.");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Success_Message_MR)).isDisplayed());
	  }
	
	@Test(priority=60, description="To verify that user is able to perform \"Uncheck All\" functionality.")
	  public void SGL_Ranchi_Admin_Language_60() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Assign Role Permission\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select particular Role from the Role list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
		  dropdown.selectByValue("56"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Predefined Query Rights button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Predefined_Query_Rights)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Check All\" button.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.chk_Dep_All)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"Uncheck All\" button.");
		  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.chk_Uncheck_Dep_All)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on \"Save\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Save)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User s87hould get error message like: \"Please select at least one module.\"");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_MR)).isDisplayed()); 
	  }
	
	@Test(priority=61, description="To verify that user is able to perform \"Invert\" functionality.")
	  public void SGL_Ranchi_Admin_Language_61() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Assign Role Permission\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select particular Role from the Role list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
		  dropdown.selectByValue("56"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Predefined Query Rights button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Predefined_Query_Rights)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Check All\" button.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.chk_Dep_All)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on Invert button.");
		  driver.findElement(By.xpath(User_Management_R.btn_invert)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on \"Save\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Save)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User s87hould get error message like: \"Please select at least one module.\"");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_MR)).isDisplayed()); 
	  }
	
	@Test(priority=62, description="To verify that user is able to perform \"Search\" functionality.")
	  public void SGL_Ranchi_Admin_Language_62() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Assign Role Permission\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select particular Role from the Role list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
		  dropdown.selectByValue("56"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Predefined Query Rights button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Predefined_Query_Rights)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Enter \"Query\" name in search textbox.");
		  driver.findElement(By.xpath("//div[@class=\"tab-pane fade active show\"]/div/input")).sendKeys("Testing");
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get result of searched module in module list.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//div[text()=\"Testing\"]")).isDisplayed()); 
	  }
	
	@Test(priority=63, description="To verify that user is able to perform \"Cancel\" functionality.")
	  public void SGL_Ranchi_Admin_Language_63() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Assign Role Permission\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select particular Role from the Role list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
		  dropdown.selectByValue("56"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Predefined Query Rights button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Predefined_Query_Rights)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Cancel\" button.");
		  driver.findElement(By.xpath("//button[text()=\"Cancel\"]")).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landing page of \"Role Permission\" without any selection of role and queries.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Roles\"]")).isDisplayed()); 
	  }
	
	@Test(priority=64, description="To verify that user is not able to assign any \"Module Rights\" and \"Predefined Query Rights\" without selection of Role.")
	  public void SGL_Ranchi_Admin_Language_64() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Assign Role Permission\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Save\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Save)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the validation massage like\r\n"
		  		+ "\"please select role\"");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_SR)).isDisplayed());
	  }
	
	@Test(priority=65, description="To verify that user is not able to assign any role permission without selection of \"Modules Rights\" and \"Predefined Query Rights\".")
	  public void SGL_Ranchi_Admin_Language_65() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Assign Role Permission\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select particular Role from the Role list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
		  dropdown.selectByValue("56"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Predefined Query Rights button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Predefined_Query_Rights)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Check All\" button.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.chk_Dep_All)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on Invert button.");
		  driver.findElement(By.xpath(User_Management_R.btn_invert)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on \"Save\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Save)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User s87hould get error message like: \"Please select at least one module.\"");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_MR)).isDisplayed()); 
	  }
	
	@Test(priority=66, description="To verify that user is able to perform \"Add Groups\" functionality.")
	  public void SGL_Ranchi_Admin_Language_66() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Add Groups\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Add_Group )).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter valid group name in \"Group Name\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Add_Group )).sendKeys("Testing");
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Add Groups\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Add_group)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) User should get successful message as\r\n"
		  		+ " \"Group Added successfully.\"\r\n"
		  		+ "2) Added group should be display in add group list.");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Success_Message_AG )).isDisplayed());  
	  }
	
	@Test(priority=67, description="To verify that user is able to perform \"Edit Group\" functionality.")
	  public void SGL_Ranchi_Admin_Language_67() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Add Groups\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Add_Group )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b>  Click on \"Edit\" button of the existing group.");
		  driver.findElement(By.xpath("//i[@id=\"btn_Testing\"]" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Save\" button.");
		  driver.findElement(By.xpath("//i[@id=\"btn_Testing\"]" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) User should get successful message as\r\n"
		  		+ " \"Group Name Saved\"\r\n"
		  		+ "2) Updated group should be display in add group list.");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Success_Message_AG_edit )).isDisplayed());
	  }
	
	@Test(priority=69, description="To verify that user is able to \"Remove\" assigned layer from the group.")
	  public void SGL_Ranchi_Admin_Language_69() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Add Groups\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Add_Group )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Remove(x)\" icon of the assigned layer from the group.");
		  driver.findElement(By.xpath("//i[@onclick=\"DeleteLayerFromGroup('ranchi_osm','Ranchi_Image')\"]" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) User should get successful message as,\r\n"
		  		+ "\"Layer Is Deleted In Group.\"\r\n"
		  		+ "2) Layer should be deleted from particular group.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"sweet-alert showSweetAlert visible\"]")).isDisplayed());
	  }
	
	@Test(priority=70, description="To verify that user is able to perform \"Delete\" functionality for the group.")
	  public void SGL_Ranchi_Admin_Language_70() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Add Groups\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Add_Group )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Delete\" button from the group.");
		  driver.findElement(By.xpath(User_Management_R.btn_Delete_group )).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(User_Management_R.btn_Yes_User_Delete )).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get success message for Group is deleted.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Group deleted successfully.\"]")).isDisplayed());
	  }
	
	@Test(priority=71, description="To verify that user is able to perform \"Scroll up/down\" functionality for view all layer list.")
	  public void SGL_Ranchi_Admin_Language_71() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Add Groups\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Add_Group )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Scroll down/up of layer list for the show all available layers.");
		  WebElement element = driver.findElement(By.xpath("//span[text()=\"Wtr Asset Point \"]"));
		  Actions actions = new Actions(driver);
		  actions.moveToElement(element);
		  actions.perform();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should see all the available layers in layer list.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Wtr Asset Point \"]")).isDisplayed()); 
	  }
	
	@Test(priority=72, description="To verify that user is able to perform \"Sorting\" functionality for particular layer.")
	  public void SGL_Ranchi_Admin_Language_72() throws InterruptedException {
          ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Add Groups\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Add_Group )).click();
		  Thread.sleep(2000);
		  List<WebElement> element1 = driver.findElements(By.xpath("//div/table/div/div/label"));
		  System.out.println(element1.size());
		  String[] stringArray2 = new String[element1.size()];
		  for(int i =0; i<4; i++) {
			 
			 stringArray2[i]=driver.findElements(By.xpath("//div/table/div/div/label")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<4; i++) {
				 
			  System.out.println(stringArray2[i]);
			  }  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter the another layer number in particular layer checkbox and click enter button.");
		  driver.findElement(By.xpath("//div/table/div[1]/div/input")).clear();
		  driver.findElement(By.xpath("//div/table/div[1]/div/input")).sendKeys("05");
		  driver.findElement(By.xpath("//div/table/div[1]/div/input")).sendKeys(Keys.ENTER);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(City_GIS_R.btn_Ok)).click();
		  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get successful message as,\r\n"
		  		+ "\"Layer Sorting Updated\".");
		  Thread.sleep(2000);
		  List<WebElement> element2 = driver.findElements(By.xpath("//div/table/div/div/label"));
		  System.out.println(element2.size());
		  String[] stringArray3 = new String[element2.size()];
		  for(int i =0; i<4; i++) {
			 
			 stringArray3[i]=driver.findElements(By.xpath("//div/table/div/div/label")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<4; i++) {
				 
			  System.out.println(stringArray3[i]);
			  }
		  Assert.assertNotEquals(stringArray3,stringArray2);
	  }
	
	@Test(priority=73, description="To verify that user is able to perform \"Sorting\" functionality for particular group.")
	  public void SGL_Ranchi_Admin_Language_73() throws InterruptedException {
          ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Add Groups\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Add_Group )).click();
		  Thread.sleep(2000);
		  List<WebElement> element1 = driver.findElements(By.xpath("//h6/strong"));
		  System.out.println(element1.size());
		  String[] stringArray2 = new String[element1.size()];
		  for(int i =0; i<element1.size(); i++) {
			 
			 stringArray2[i]=driver.findElements(By.xpath("//h6/strong")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element1.size(); i++) {
				 
			  System.out.println(stringArray2[i]);
			  }  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter the another group number in particular group checkbox and click enter button.");
		  driver.findElement(By.xpath("//div/table/thead[1]//div/input")).clear();
		  driver.findElement(By.xpath("//div/table/thead[1]//div/input")).sendKeys("2");
		  driver.findElement(By.xpath("//div/table/thead[1]//div/input")).sendKeys(Keys.ENTER);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(City_GIS_R.btn_Ok)).click();
		  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get successful message as,\r\n"
		  		+ "\"Group Sorting Updated\".");
		  Thread.sleep(2000);
		  List<WebElement> element2 = driver.findElements(By.xpath("//h6/strong"));
		  System.out.println(element2.size());
		  String[] stringArray3 = new String[element2.size()];
		  for(int i =0; i<element1.size(); i++) {
			 
			 stringArray3[i]=driver.findElements(By.xpath("//h6/strong")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element1.size(); i++) {
				 
			  System.out.println(stringArray3[i]);
			  }
		  Assert.assertNotEquals(stringArray3,stringArray2);
	  }
	
	@Test(priority=74, description="To verify that user is able to perform \"Scroll up/down\" functionality for view all group list.")
	  public void SGL_Ranchi_Admin_Language_74() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Add Groups\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Add_Group )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Scroll down/up of group list for the show all available groups.");
		  WebElement element = driver.findElement(By.xpath("//strong[text()=\"ITMS\"]"));
		  Actions actions = new Actions(driver);
		  actions.moveToElement(element);
		  actions.perform();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should see all the available groups in group list.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//strong[text()=\"ITMS\"]")).isDisplayed()); 
	  }
	
	@Test(priority=75, description="To verify that user is able to perform \"Dashboard\" functionality from \"Add Groups\" screen.")
	  public void SGL_Ranchi_Admin_Language_75() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Add Groups\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Add_Group )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Dashboard\" icon from \"Role Permission\" screen.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Dashboard)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should be get the landing page of the administrator.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Roles\"]")).isDisplayed());  
	  }
	
	@Test(priority=76, description="To verify that user is not able to \"Add Group\" without group name.")
	  public void SGL_Ranchi_Admin_Language_76() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Add Groups\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Add_Group )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Add Group\" button.");
		  JavascriptExecutor executor = (JavascriptExecutor) driver;
		  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(User_Management_R.btn_Add_group)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation massage like\r\n"
		  		+ "\"Please enter a name with at least 3 letters\"");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Please enter a name with at least 3 letters\"]")).isDisplayed());  
	  }
	
	@Test(priority=77, description="To verify that user is not able to assign same layer to the particular group.")
	  public void SGL_Ranchi_Admin_Language_77() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Add Groups\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Add_Group )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter valid group name in \"Group Name\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Add_Group )).sendKeys("Ranchi Image");
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Add Group\" button.");
		  JavascriptExecutor executor = (JavascriptExecutor) driver;
		  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(User_Management_R.btn_Add_group)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the error message like,\r\n"
		  		+ "\"Layer is Already Exist.\"");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Group Already Exist\"]")).isDisplayed());  
	  }
	
	@Test(priority=78, description="To verify that user is able to get \"Role Group Mapping\" page.")
	  public void SGL_Ranchi_Admin_Language_78() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Role Group Mapping\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Role_Group_Mapping )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landing page of the \"Role Group Mapping\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.label_Role_GM)).isDisplayed()); 
	  }
	
	@Test(priority=79, description="To verify that user is able to \"Assign/Unassigned\" particular groups to the selected role.")
	  public void SGL_Ranchi_Admin_Language_79() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Role Group Mapping\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Role_Group_Mapping )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select particular role from the role list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
		  dropdown.selectByValue("56"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-0:</b> Check on checkbox of the particular group from the group list.");
		  driver.findElement(By.xpath(User_Management_R.chk_Group_Water_Supply )).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the successful message as,\r\n"
		  		+ "\"Layer successfully deleted for this role.\"");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Layer successfully added for this role\"]")).isDisplayed()); 
	  }
	
	@Test(priority=80, description="To verify that user is able to \"Assign/Unassigned\" particular layers from the group for the selected role.")
	  public void SGL_Ranchi_Admin_Language_80() throws InterruptedException {
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Role Group Mapping\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Role_Group_Mapping )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select particular role from the role list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
		  dropdown.selectByValue("56"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Check on checkbox ahead of the layer list from the particular group.");
		  WebElement ele = driver.findElement(By.xpath("//li[@data-groupname=\"Water Supply\"]/span/strong"));
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", ele);
		  Thread.sleep(2000);
		  WebElement ele1 =  driver.findElement(By.xpath("//input[@name=\"chkGroup_Water_Supply\"]"));
		  executor.executeScript("arguments[0].click();", ele1);
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get selected role with the assigned group with only selected layers.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Layer Borewell successfully Updated for this role\"]")).isDisplayed()); 
	  }
	
	@Test(priority=81, description="To verify that user is able to \"Is Default\" functionality for the layer.")
	  public void SGL_Ranchi_Admin_Language_81(Method method) throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Role Group Mapping\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Role_Group_Mapping )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select particular role from the role list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
		  dropdown.selectByValue("56"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Is Default\" checkbox for the selected layer.");
		  WebElement ele = driver.findElement(By.xpath("//li[@data-groupname=\"Water Supply\"]/span/strong"));
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", ele);
		  Thread.sleep(2000);
		  WebElement ele1 =  driver.findElement(By.xpath("//input[@name=\"chkGroup_Water_Supply\"]"));
		  executor.executeScript("arguments[0].click();", ele1);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(User_Management_R.btn_Ok)).click();
		  Thread.sleep(2000);
		  WebElement ele2 =  driver.findElement(By.xpath("//input[@id=\"Default_chkGroup_Water_Supply_borewell\"]"));
		  executor.executeScript("arguments[0].click();", ele2);
		  Thread.sleep(4000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get selected layer as active on city GIS map after login with particular department.");
		  System.out.println(driver.findElement(By.xpath("//p[text()=\"Layer borewell is default active  for this role.\"]")).isDisplayed());  
		  boolean aa = driver.findElement(By.xpath("//p[text()=\"Layer borewell is default active  for this role.\"]")).isDisplayed();
		  Assert.assertEquals(aa,true);
		  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
		  driver.findElement(By.xpath(User_Management_R.btn_Ok)).click();
		   ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Again click on \"Is Default\" checkbox for selected layer.");
		  executor.executeScript("arguments[0].click();", ele2);
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get success message for Inactive \"Is Default\" functionality for selected layer.");
		  Assert.assertEquals(false, driver.findElement(By.xpath("//p[text()=\"Layer borewell is default inactive for this role.\"]")).isDisplayed());  
	  }
	
	@Test(priority=82, description="To verify that user is able to assign/unassign \"Is Right Click\" functionality for the layer.")
	  public void SGL_Ranchi_Admin_Language_82(Method method) throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Role Group Mapping\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Role_Group_Mapping )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select particular role from the role list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
		  dropdown.selectByValue("56"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Is Right Click\" checkbox for the selected layer.");
		  WebElement ele2 = driver.findElement(By.xpath("//li[text()=\"Borewell \"]/div/input[2]"));
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", ele2);
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get selected layer as active on city GIS map after login with particular department.");
		  System.out.println(driver.findElement(By.xpath("//p[text()=\"Layer borewell right click active for this role.\"]")).isDisplayed());
		  boolean aa = driver.findElement(By.xpath("//p[text()=\"Layer borewell right click active for this role.\"]")).isDisplayed();
		  Assert.assertEquals(aa,true);
		  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
		  driver.findElement(By.xpath(User_Management_R.btn_Ok)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Again click on \"Is Right Click\" checkbox for selected layer.");
		  executor.executeScript("arguments[0].click();", ele2);
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get success message for Inactive \"Is Default\" functionality for selected layer.");
		  System.out.println(driver.findElement(By.xpath("//p[text()=\"Layer borewell right click inactive for this role.\"]")).isDisplayed());
		  boolean bb = driver.findElement(By.xpath("//p[text()=\"Layer borewell right click inactive for this role.\"]")).isDisplayed();
		  Assert.assertEquals(bb,false);
	  }
	
	@Test(priority=83, description="To verify that user is able to perform \"Dashboard\" functionality from \"Role Group Mapping\" screen.")
	  public void SGL_Ranchi_Admin_Language_83() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Role Group Mapping\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Role_Group_Mapping )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select particular role from the role list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
		  dropdown.selectByValue("56"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Dashboard\" icon from \"Role Permission\" screen.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Dashboard)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should be get the landing page of the administrator.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Roles\"]")).isDisplayed());    
	  }
	
	@Test(priority=84, description="To verify that user is not able to assign any \"group\" and layers of the group without selection of Role.")
	  public void SGL_Ranchi_Admin_Language_84() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Role Group Mapping\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Role_Group_Mapping )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Check on checkbox ahead of the layer list from the particular group.");
		  driver.findElement(By.xpath("//li[@data-groupname=\"Water Supply\"]/input")).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get error message for role is not selected.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Please Select Role For Assign Layers\"]")).isDisplayed());
	  }
	
	@Test(priority=85, description="To verify that user is able to get \"Layer Management\" functionality.")
	  public void SGL_Ranchi_Admin_Language_85() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landing page of the \"Layer Management\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//h5[text()=\"Layer Management\"]")).isDisplayed());
	  }
	
	@Test(priority=86, description="To verify that user is able to perform  \"Add Layer\" functionality.")
	  public void SGL_Ranchi_Admin_Language_86() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Add Layer\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Add_Layer )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Enter valid  layer name in \"Layer Name\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Layer_Name )).sendKeys("Testing");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Enter valid  alias name in \"Alias Name\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Alias_Name )).sendKeys("Testing");
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Select checkbox of \"Is Visible?\" ");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Select checkbox of \"In Advance Query ?\" ");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Click on \"Save\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Save )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) User should get the successful message as ,\r\n"
		  		+ "\"Layer Added Successfully.\"\r\n"
		  		+ "2) Added layer should be display in layer management list.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Layer Added Successfully.\"]")).isDisplayed());
	  }
	
	@Test(priority=87, description="To verify that user is able to perform \"Cancel\" functionality.")
	  public void SGL_Ranchi_Admin_Language_87() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Add Layer\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Add_Layer )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Cancel\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Cancel )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landing page of the \"Layer Management\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//h5[text()=\"Layer Management\"]")).isDisplayed());
	  }
	
	@Test(priority=88, description="To verify that user is able to perform \"Dashboard\" functionality from \"Layer Management\" screen.")
	  public void SGL_Ranchi_Admin_Language_88() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Dashboard\" icon from \"Layer Management\" screen.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Dashboard)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should be get the landing page of the administrator.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Roles\"]")).isDisplayed());    
	  }
	
	@Test(priority=89, description="To verify that user is able to perform \"Dashboard\" functionality from \"Add Layer\" screen.")
	  public void SGL_Ranchi_Admin_Language_89() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Add Layer\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Add_Layer )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Dashboard\" icon from \"Add Layer\" screen.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Dashboard)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should be get the landing page of the administrator.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Roles\"]")).isDisplayed());    
	  }
	
	@Test(priority=90, description="To verify that user is able to perform \"Layer Management\" functionality from \"Add Layer\" screen.")
	  public void SGL_Ranchi_Admin_Language_90() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Add Layer\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Add_Layer )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Layer Management\" icon.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Layer_Management)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landing page of the \"Layer Management\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//h5[text()=\"Layer Management\"]")).isDisplayed());    
	  }
	
	@Test(priority=91, description="To verify that user is able to perform \"Edit\" functionality.")
	  public void SGL_Ranchi_Admin_Language_91() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Edit\" button.");
		  driver.findElement(By.xpath("//tbody[@id=\"ttbllayerbody\"]/tr[1]/td[3]/a" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Update\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Update)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) User should get the successful message as ,\r\n"
		  		+ "\"Layer Updated Successfully.\"\r\n"
		  		+ "2) Updated layer should be display in layer management list.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Layer Updated Successfully.\"]")).isDisplayed());    
	  }
	
	@Test(priority=92, description="To verify that user is able to perform \"Delete\" functionality.")
	  public void SGL_Ranchi_Admin_Language_92() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Delete\" button for the particular layer.");
		  driver.findElement(By.xpath("//tbody[@id=\"ttbllayerbody\"]/tr[1]/td[4]/a" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User  should get confirmation message for delete layer.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"sweet-alert showSweetAlert visible\"]")).isDisplayed());   
	  }
	
	@Test(priority=93, description="To verify that user is able to perform \"Manage Attribute\" functionality.")
	  public void SGL_Ranchi_Admin_Language_93() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Manage Attribute\" button for the particular layer.");
		  driver.findElement(By.xpath("//tbody[@id=\"ttbllayerbody\"]/tr[1]/td[5]/a" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landing page of the \"Layer Attribute Management\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//h5[text()=\"Layer Attribute Management\"]")).isDisplayed());   
	  }
	
	@Test(priority=94, description="To verify that user is able to perform \"Dashboard\" functionality from \"Layer Attribute Management\" screen.")
	  public void SGL_Ranchi_Admin_Language_94() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Manage Attribute\" button for the particular layer.");
		  driver.findElement(By.xpath("//tbody[@id=\"ttbllayerbody\"]/tr[1]/td[5]/a" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Dashboard\" icon.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Dashboard)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should be get the landing page of the administrator.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Roles\"]")).isDisplayed());   
	  }
	
	@Test(priority=95, description="To verify that user is able to perform \"Layer Management\" functionality from \"Layer Attribute Management\" screen.")
	  public void SGL_Ranchi_Admin_Language_95() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Manage Attribute\" button for the particular layer.");
		  driver.findElement(By.xpath("//tbody[@id=\"ttbllayerbody\"]/tr[1]/td[5]/a" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Layer Management\" icon.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Layer_Management)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landing page of the \"Layer Management\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//h5[text()=\"Layer Management\"]")).isDisplayed());     
	  }
	
	@Test(priority=96, description="To verify that user is able to perform \"Edit\" functionality from \"Layer Attribute Management\" screen.")
	  public void SGL_Ranchi_Admin_Language_96() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Manage Attribute\" button for the particular layer.");
		  driver.findElement(By.xpath("//tbody[@id=\"ttbllayerbody\"]/tr[10]/td[5]/a" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Edit\" button.");
		  driver.findElement(By.xpath("//tbody[@id=\"tbodyLayerAttributes\"]/tr[1]/td[3]/a" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Update\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Update)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) User should get the successful message as ,\r\n"
		  		+ "\"Layer Attributes Detail Updated Successfully\"\r\n"
		  		+ "2) Updated layer should be display in layer attribute management list.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Layer Attributes Detail Updated Successfully\"]")).isDisplayed());      
	  }
	
	@Test(priority=97, description="To verify that user is able to perform \"Cancel\" functionality from \"Edit Layer Attribute\" screen.")
	  public void SGL_Ranchi_Admin_Language_97() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Manage Attribute\" button for the particular layer.");
		  driver.findElement(By.xpath("//tbody[@id=\"ttbllayerbody\"]/tr[10]/td[5]/a" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Edit\" button.");
		  driver.findElement(By.xpath("//tbody[@id=\"tbodyLayerAttributes\"]/tr[1]/td[3]/a" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Cancel\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Cancel )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landing page of the \"Layer Attribute Management\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//h5[text()=\"Layer Attribute Management\"]")).isDisplayed());       
	  }
	
	@Test(priority=98, description="To verify that user is able to perform \"Dashboard\" functionality from \"Edit Layer Attribute\" screen.")
	  public void SGL_Ranchi_Admin_Language_98() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Manage Attribute\" button for the particular layer.");
		  driver.findElement(By.xpath("//tbody[@id=\"ttbllayerbody\"]/tr[10]/td[5]/a" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Edit\" button.");
		  driver.findElement(By.xpath("//tbody[@id=\"tbodyLayerAttributes\"]/tr[1]/td[3]/a" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Dashboard\" icon.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Dashboard)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should be get the landing page of the administrator.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Roles\"]")).isDisplayed());       
	  }
	
	@Test(priority=99, description="To verify that user is able to perform \"Layer Management\" functionality from \"Edit Layer Attribute\" screen.")
	  public void SGL_Ranchi_Admin_Language_99() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Manage Attribute\" button for the particular layer.");
		  driver.findElement(By.xpath("//tbody[@id=\"ttbllayerbody\"]/tr[10]/td[5]/a" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Edit\" button.");
		  driver.findElement(By.xpath("//tbody[@id=\"tbodyLayerAttributes\"]/tr[1]/td[3]/a" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Layer Management\" icon.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Layer_Management)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landing page of the \"Layer Management\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//h5[text()=\"Layer Management\"]")).isDisplayed());       
	  }
	
	@Test(priority=100, description="To verify that user is able to perform \"Delete\" functionality from \"Layer Attribute Management\".")
	  public void SGL_Ranchi_Admin_Language_100() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Manage Attribute\" button for the particular layer.");
		  driver.findElement(By.xpath("//tbody[@id=\"ttbllayerbody\"]/tr[10]/td[5]/a" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Delete\" button for the particular layer attribute.");
		  driver.findElement(By.xpath("//tbody[@id=\"tbodyLayerAttributes\"]/tr[1]/td[4]/a" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User  should get confirmation message for delete layer.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"sweet-alert showSweetAlert visible\"]")).isDisplayed());       
	  }
	
	@Test(priority=101, description="To verify that user is able to perform \"Search\" functionality from \"Layer Attribute Management\".")
	  public void SGL_Ranchi_Admin_Language_101() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Manage Attribute\" button for the particular layer.");
		  driver.findElement(By.xpath("//tbody[@id=\"ttbllayerbody\"]/tr[10]/td[5]/a" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Enter search criteria into \"Search\" textbox.");
		  driver.findElement(By.xpath("//input[@aria-controls=\"tblLayerAttributes\"]")).sendKeys("Name");
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the searched result into User Data grid.");
		  Assert.assertEquals("name", driver.findElement(By.xpath("//tbody[@id=\"tbodyLayerAttributes\"]/tr[1]/td[5]")).getText());       
	  }
	
	@Test(priority=102, description="To verify that user is able to select number of records show from \"Layer Attribute Management\".")
	  public void SGL_Ranchi_Admin_Language_102() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Manage Attribute\" button for the particular layer.");
		  driver.findElement(By.xpath("//tbody[@id=\"ttbllayerbody\"]/tr[10]/td[5]/a" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select number from the \"Show No. of Entries\" dropdown list.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//option[@value=\"50\"]")));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the selected number of the records on Data User grid.");
		  Assert.assertNotEquals("10", driver.findElement(By.xpath("//tr/td[5]")).getText());    
	  }
	
	@Test(priority=103, description="To verify that user is able to perform \"Back\" functionality from \"Layer Attribute Management\".")
	  public void SGL_Ranchi_Admin_Language_103() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Manage Attribute\" button for the particular layer.");
		  driver.findElement(By.xpath("//tbody[@id=\"ttbllayerbody\"]/tr[10]/td[5]/a" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Back\" button.");
		  driver.findElement(By.xpath("//a[text()=\"Back\"]" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landing page of the \"Layer Management\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//h5[text()=\"Layer Management\"]")).isDisplayed());         
	  }
	
	@Test(priority=104, description="To verify that user is able to perform \"Delete Multiple\" functionality from \"Layer Attribute Management\".")
	  public void SGL_Ranchi_Admin_Language_104() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Manage Attribute\" button for the particular layer.");
		  driver.findElement(By.xpath("//tbody[@id=\"ttbllayerbody\"]/tr[10]/td[5]/a" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select the layers from \"layer atrribute\" list.");
		  driver.findElement(By.xpath("//tr[1]/td[1]/input" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Delete Multiple\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Delete_Multiple_User )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get confirmation massage for delete layer attribute. ");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"sweet-alert showSweetAlert visible\"]")).isDisplayed());         
	  }
	
	@Test(priority=105, description="To verify that user is able to perform \"Sorting\" functionality for \"SR. NO.\" ,\"Field Name\",\"Alias Name\", \"Is visible?\" column.")
	  public void SGL_Ranchi_Admin_Language_105(Method method) throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Manage Attribute\" button for the particular layer.");
		  driver.findElement(By.xpath("//tbody[@id=\"ttbllayerbody\"]/tr[10]/td[5]/a" )).click();
		  Thread.sleep(2000);
          List<WebElement> element1 = driver.findElements(By.xpath("//tr/td[2]"));
				  System.out.println(element1.size());
				  String[] stringArray2 = new String[element1.size()];
				  for(int i =0; i<element1.size(); i++) {
					 
					 stringArray2[i]=driver.findElements(By.xpath("//tr/td[2]")).get(i).getText();
					 Thread.sleep(2000);
				  } 
				  for(int i =0; i<element1.size(); i++) {
						 
					  System.out.println(stringArray2[i]);
					  }  
				  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Sorting\" icon of the SR. NO. column.");
				  driver.findElement(By.xpath(User_Management_R.btn_Sorting_SR)).click();
				  Thread.sleep(2000);
				  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get data grid on Descending/Ascending order.");
				  List<WebElement> element2 = driver.findElements(By.xpath("//tr/td[2]"));
				  System.out.println(element2.size());
				  String[] stringArray3 = new String[element2.size()];
				  for(int i =0; i<element1.size(); i++) {
					 
					 stringArray3[i]=driver.findElements(By.xpath("//tr/td[2]")).get(i).getText();
					 Thread.sleep(2000);
				  } 
				  for(int i =0; i<element1.size(); i++) {
						 
					  System.out.println(stringArray3[i]);
					  }
				  Assert.assertEquals(stringArray3,stringArray2);
				 objs.Screenshot(driver, Classname ,method.getName()+"_01" );
				 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Sorting\" icon of the SR. NO. column.");
				  driver.findElement(By.xpath(User_Management_R.btn_Sorting_SR)).click();
				  
				  Thread.sleep(2000);
				 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid on Ascending order.");
				 
				  List<WebElement> element4 = driver.findElements(By.xpath("//tr/td[2]"));
				  System.out.println(element4.size());
				  String[] stringArray4 = new String[element2.size()];
				  for(int i =0; i<element1.size(); i++) {
					 
					 stringArray4[i]=driver.findElements(By.xpath("//tr/td[2]")).get(i).getText();
					 Thread.sleep(2000);
				  } 
				  for(int i =0; i<element4.size(); i++) {
						 
					  System.out.println(stringArray4[i]);
					  } 
				  Assert.assertNotEquals(stringArray3,stringArray4);
				  List<WebElement> element5 = driver.findElements(By.xpath("//tr/td[6]"));
				  System.out.println(element5.size());
				  String[] stringArray5 = new String[element5.size()];
				  for(int i =0; i<element5.size(); i++) 
				  {
				    stringArray5[i]=driver.findElements(By.xpath("//tr/td[6]")).get(i).getText();
					Thread.sleep(2000);
				  } 
				  for(int i =0; i<element5.size(); i++) 
				  {
				    System.out.println(stringArray5[i]);
					
				  }  
				  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"Sorting\" icon of the \"Alias Name\" column.");
				  driver.findElement(By.xpath("//th[text()=\"Alias Name\"]")).click();
				  Thread.sleep(2000);
				  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid in alphabetical order.");
				  List<WebElement> element6 = driver.findElements(By.xpath("//tr/td[6]"));
				  System.out.println(element6.size());
				  String[] stringArray6 = new String[element6.size()];
				  for(int i =0; i<element6.size(); i++) {
					 
					 stringArray6[i]=driver.findElements(By.xpath("//tr/td[6]")).get(i).getText();
					 Thread.sleep(2000);
				  } 
				  for(int i =0; i<element6.size(); i++) {
						 
					  System.out.println(stringArray6[i]);
					  }
				  Assert.assertNotEquals(stringArray6,stringArray5);
				  objs.Screenshot(driver, Classname ,method.getName()+"_02" ); 
				  List<WebElement> element7 = driver.findElements(By.xpath("//tr/td[7]"));
				  System.out.println(element7.size());
				  String[] stringArray7 = new String[element7.size()];
				  for(int i =0; i<element7.size(); i++) 
				  {
				    stringArray7[i]=driver.findElements(By.xpath("//tr/td[7]")).get(i).getText();
					Thread.sleep(2000);
				  } 
				  for(int i =0; i<element7.size(); i++) 
				  {
				    System.out.println(stringArray7[i]);
					
				  }  
				  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on \"Sorting\" icon of the \"Is visible?\" column.");
				  driver.findElement(By.xpath("//th[text()=\"Is Visible?\"]")).click();
				  Thread.sleep(2000);
				  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid in alphabetical order.");
				  List<WebElement> element8 = driver.findElements(By.xpath("//tr/td[7]"));
				  System.out.println(element8.size());
				  String[] stringArray8 = new String[element8.size()];
				  for(int i =0; i<element8.size(); i++) {
					 
					 stringArray8[i]=driver.findElements(By.xpath("//tr/td[7]")).get(i).getText();
					 Thread.sleep(2000);
				  } 
				  for(int i =0; i<element8.size(); i++) {
						 
					  System.out.println(stringArray8[i]);
					  }
				  Assert.assertNotEquals(stringArray7,stringArray8);
				  objs.Screenshot(driver, Classname ,method.getName()+"_03" );
				  List<WebElement> element9 = driver.findElements(By.xpath("//tr/td[5]"));
				  System.out.println(element9.size());
				  String[] stringArray9 = new String[element9.size()];
				  for(int i =0; i<element9.size(); i++) 
				  {
				    stringArray9[i]=driver.findElements(By.xpath("//tr/td[5]")).get(i).getText();
					Thread.sleep(2000);
				  } 
				  for(int i =0; i<element9.size(); i++) 
				  {
				    System.out.println(stringArray9[i]);
					
				  }  
				  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Click on \"Sorting\" icon of the \"Field Name\" column.");
				  driver.findElement(By.xpath("//th[text()=\"Field Name\"]")).click();
				  Thread.sleep(2000);
				  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid in alphabetical order.");
				  List<WebElement> element10 = driver.findElements(By.xpath("//tr/td[5]"));
				  System.out.println(element10.size());
				  String[] stringArray10 = new String[element10.size()];
				  for(int i =0; i<element10.size(); i++) {
					 
					 stringArray10[i]=driver.findElements(By.xpath("//tr/td[5]")).get(i).getText();
					 Thread.sleep(2000);
				  } 
				  for(int i =0; i<element10.size(); i++) {
						 
					  System.out.println(stringArray10[i]);
					  }
				  Assert.assertNotEquals(stringArray9,stringArray10);
				          
	  }
	
	@Test(priority=106, description="To verify that user is able to \"Select All\" users from from \"Layer Attribute Management\".")
	  public void SGL_Ranchi_Admin_Language_106() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Manage Attribute\" button for the particular layer.");
		  driver.findElement(By.xpath("//tbody[@id=\"ttbllayerbody\"]/tr[10]/td[5]/a" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on check box of the header row from the layer attribute data grid.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();",   driver.findElement(By.xpath(User_Management_R.chk_Select_All)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get all the user from the layer attribute data grid as selected.");
		  List<WebElement> element1 = driver.findElements(By.xpath("//tr/td[1]/input"));
		  System.out.println(element1.size());
		  for(int i =0; i<element1.size(); i++) {
			  Assert.assertEquals(true,driver.findElement(By.xpath("//tr/td[1]/input")).isSelected());
			 Thread.sleep(1000);
		  }          
	  }
	
	@Test(priority=107, description="To verify that user is able to select particular user from the user data grid.")
	  public void SGL_Ranchi_Admin_Language_107(Method method) throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Manage Attribute\" button for the particular layer.");
		  driver.findElement(By.xpath("//tbody[@id=\"ttbllayerbody\"]/tr[10]/td[5]/a" )).click();
		  Thread.sleep(2000);
		  List<WebElement> element1 = driver.findElements(By.xpath("//tr/td[1]/input"));
		  System.out.println(element1.size());
		  for(int i =0; i<element1.size(); i++) {
			  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9."+i+":</b> Click on check box of the particular user from the layer attribute data grid.");
			  element1.get(i).click();
			  Thread.sleep(2000);
			  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get particular user from the layer attribute data grid as selected.");
			  Assert.assertEquals(true,driver.findElement(By.xpath("//tr/td[1]/input")).isSelected());
			  Thread.sleep(1000);
			  objs.Screenshot(driver, Classname ,method.getName()+"_"+i );
		  }         
	  }
	
	@Test(priority=108, description="To verify that user is able to perform \"Pagination\" functionality from \"Layer Attribute Management\".")
	  public void SGL_Ranchi_Admin_Language_108(Method method) throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Manage Attribute\" button for the particular layer.");
		  driver.findElement(By.xpath("//tbody[@id=\"ttbllayerbody\"]/tr[10]/td[5]/a" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Next\" button of the paging.");
		  driver.findElement(By.xpath(User_Management_R.btn_Next)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get next page of the User Data grid.");
		  Assert.assertEquals("2",driver.findElement(By.xpath("//a[@class=\"paginate_button current\"]")).getText());
		  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Previous\" button of the paging.");
		  driver.findElement(By.xpath(User_Management_R.btn_Previous)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Click on \"Previous\" button of the paging.");
		  Assert.assertEquals("1",driver.findElement(By.xpath("//a[@class=\"paginate_button current\"]")).getText()); 
	  }
	
	@Test(priority=109, description="To verify that user is able to perform \"Search\" functionality from layer management screen.")
	  public void SGL_Ranchi_Admin_Language_109() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter search criteria into \"Search\" textbox.");
		  driver.findElement(By.xpath("//input[@aria-controls=\"tbllayermanagement\"]")).sendKeys("Testing");
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the searched result into User Data grid.");
		  Assert.assertEquals("Testing", driver.findElement(By.xpath("//tbody[@id=\"tbllayermanagement\"]/tr[1]/td[6]")).getText());
	  }
	
	@Test(priority=110, description="To verify that user is able to perform \"Delete Multiple\" functionality from layer management screen.")
	  public void SGL_Ranchi_Admin_Language_110() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select the layers from \"layer atrribute\" list.");
		  driver.findElement(By.xpath("//tr[1]/td[1]/input" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Delete Multiple\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Delete_Multiple_User )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get confirmation massage for delete layer attribute. ");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"sweet-alert showSweetAlert visible\"]")).isDisplayed()); 
	  }
	
	@Test(priority=111, description="To verify that user is able to select number of records show on user data grid.")
	  public void SGL_Ranchi_Admin_Language_111() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select number from the \"Show No. of Entries\" dropdown list.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//option[@value=\"50\"]")));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the selected number of the records on Data User grid.");
		  Assert.assertNotEquals("10", driver.findElement(By.xpath("//tr/td[5]")).getText());    
	  }
	
	@Test(priority=112, description="To verify that user is able to \"Select All\" users from the layer management data grid.")
	  public void SGL_Ranchi_Admin_Language_112() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on check box of the header row from the User data grid.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();",   driver.findElement(By.xpath(User_Management_R.chk_Select_All)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get all the user from the user data grid as selected.");
		  List<WebElement> element1 = driver.findElements(By.xpath("//tr/td[1]/input"));
		  System.out.println(element1.size());
		  for(int i =0; i<element1.size(); i++) {
			  Assert.assertEquals(true,driver.findElement(By.xpath("//tr/td[1]/input")).isSelected());
			 Thread.sleep(1000);
		  }  
	  }
	
	@Test(priority=113, description="To verify that user is able to select particular user from the layer management data grid.")
	  public void SGL_Ranchi_Admin_Language_113(Method method) throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  List<WebElement> element1 = driver.findElements(By.xpath("//tr/td[1]/input"));
		  System.out.println(element1.size());
		  for(int i =0; i<element1.size(); i++) {
			  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8."+i+":</b> Click on check box of the particular user from the layer attribute data grid.");
			  element1.get(i).click();
			  Thread.sleep(2000);
			  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get particular user from the layer attribute data grid as selected.");
			  Assert.assertEquals(true,driver.findElement(By.xpath("//tr/td[1]/input")).isSelected());
			  Thread.sleep(1000);
			  objs.Screenshot(driver, Classname ,method.getName()+"_"+i );
		  } 
	  }
	
	@Test(priority=114, description="To verify that user is able to perform  \"Pagination\" functionality layer management data grid.")
	  public void SGL_Ranchi_Admin_Language_114(Method method) throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Next\" button of the paging.");
		  driver.findElement(By.xpath(User_Management_R.btn_Next)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get next page of the User Data grid.");
		  Assert.assertEquals("2",driver.findElement(By.xpath("//a[@class=\"paginate_button current\"]")).getText());
		  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Previous\" button of the paging.");
		  driver.findElement(By.xpath(User_Management_R.btn_Previous)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Click on \"Previous\" button of the paging.");
		  Assert.assertEquals("1",driver.findElement(By.xpath("//a[@class=\"paginate_button current\"]")).getText());
	  }
	
	@Test(priority=115, description="To verify that user is able to perform \"Sorting\" functionality for \"SR. NO.\",\"Layer Name\",\"Alias Name\",\"Is Visible?\", column..")
	  public void SGL_Ranchi_Admin_Language_115(Method method) throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  List<WebElement> element1 = driver.findElements(By.xpath("//tr/td[2]"));
		  System.out.println(element1.size());
		  String[] stringArray2 = new String[element1.size()];
		  for(int i =0; i<element1.size(); i++) {
			 
			 stringArray2[i]=driver.findElements(By.xpath("//tr/td[2]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element1.size(); i++) {
				 
			  System.out.println(stringArray2[i]);
			  }  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Sorting\" icon of the SR. NO. column.");
		  driver.findElement(By.xpath(User_Management_R.btn_Sorting_SR)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get data grid on Descending/Ascending order.");
		  List<WebElement> element2 = driver.findElements(By.xpath("//tr/td[2]"));
		  System.out.println(element2.size());
		  String[] stringArray3 = new String[element2.size()];
		  for(int i =0; i<element1.size(); i++) {
			 
			 stringArray3[i]=driver.findElements(By.xpath("//tr/td[2]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element1.size(); i++) {
				 
			  System.out.println(stringArray3[i]);
			  }
		  Assert.assertEquals(stringArray3,stringArray2);
		 objs.Screenshot(driver, Classname ,method.getName()+"_01" );
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Sorting\" icon of the SR. NO. column.");
		  driver.findElement(By.xpath(User_Management_R.btn_Sorting_SR)).click();
		  
		  Thread.sleep(2000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid on Ascending order.");
		 
		  List<WebElement> element4 = driver.findElements(By.xpath("//tr/td[2]"));
		  System.out.println(element4.size());
		  String[] stringArray4 = new String[element2.size()];
		  for(int i =0; i<element1.size(); i++) {
			 
			 stringArray4[i]=driver.findElements(By.xpath("//tr/td[2]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element4.size(); i++) {
				 
			  System.out.println(stringArray4[i]);
			  } 
		  Assert.assertNotEquals(stringArray3,stringArray4);
		  List<WebElement> element5 = driver.findElements(By.xpath("//tr/td[6]"));
		  System.out.println(element5.size());
		  String[] stringArray5 = new String[element5.size()];
		  for(int i =0; i<element5.size(); i++) 
		  {
		    stringArray5[i]=driver.findElements(By.xpath("//tr/td[6]")).get(i).getText();
			Thread.sleep(2000);
		  } 
		  for(int i =0; i<element5.size(); i++) 
		  {
		    System.out.println(stringArray5[i]);
			
		  }  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Sorting\" icon of the \"Layer Name\" column.");
		  driver.findElement(By.xpath("//th[text()=\"Layer Name\"]")).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid in alphabetical order.");
		  List<WebElement> element6 = driver.findElements(By.xpath("//tr/td[6]"));
		  System.out.println(element6.size());
		  String[] stringArray6 = new String[element6.size()];
		  for(int i =0; i<element6.size(); i++) {
			 
			 stringArray6[i]=driver.findElements(By.xpath("//tr/td[6]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element6.size(); i++) {
				 
			  System.out.println(stringArray6[i]);
			  }
		  Assert.assertNotEquals(stringArray6,stringArray5);
		  objs.Screenshot(driver, Classname ,method.getName()+"_02" ); 
		  List<WebElement> element7 = driver.findElements(By.xpath("//tr/td[7]"));
		  System.out.println(element7.size());
		  String[] stringArray7 = new String[element7.size()];
		  for(int i =0; i<element7.size(); i++) 
		  {
		    stringArray7[i]=driver.findElements(By.xpath("//tr/td[7]")).get(i).getText();
			Thread.sleep(2000);
		  } 
		  for(int i =0; i<element7.size(); i++) 
		  {
		    System.out.println(stringArray7[i]);
			
		  }  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"Sorting\" icon of the \"Alias Name\" column.");
		  driver.findElement(By.xpath("//th[text()=\"Alias Name\"]")).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid in alphabetical order.");
		  List<WebElement> element8 = driver.findElements(By.xpath("//tr/td[7]"));
		  System.out.println(element8.size());
		  String[] stringArray8 = new String[element8.size()];
		  for(int i =0; i<element8.size(); i++) {
			 
			 stringArray8[i]=driver.findElements(By.xpath("//tr/td[7]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element8.size(); i++) {
				 
			  System.out.println(stringArray8[i]);
			  }
		  Assert.assertNotEquals(stringArray7,stringArray8);
		  objs.Screenshot(driver, Classname ,method.getName()+"_03" );
		  List<WebElement> element9 = driver.findElements(By.xpath("//tr/td[8]"));
		  System.out.println(element9.size());
		  String[] stringArray9 = new String[element9.size()];
		  for(int i =0; i<element9.size(); i++) 
		  {
		    stringArray9[i]=driver.findElements(By.xpath("//tr/td[8]")).get(i).getText();
			Thread.sleep(2000);
		  } 
		  for(int i =0; i<element9.size(); i++) 
		  {
		    System.out.println(stringArray9[i]);
			
		  }  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on \"Sorting\" icon of the \"Is Visible?\" column.");
		  driver.findElement(By.xpath("//th[text()=\"Is Visible?\"]")).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid in alphabetical order.");
		  List<WebElement> element10 = driver.findElements(By.xpath("//tr/td[8]"));
		  System.out.println(element10.size());
		  String[] stringArray10 = new String[element10.size()];
		  for(int i =0; i<element10.size(); i++) {
			 
			 stringArray10[i]=driver.findElements(By.xpath("//tr/td[8]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element10.size(); i++) {
				 
			  System.out.println(stringArray10[i]);
			  }
		  Assert.assertNotEquals(stringArray9,stringArray10);
	  }
	
	@Test(priority=116, description="To verify that user is not able to add layer with blank required details.")
	  public void SGL_Ranchi_Admin_Language_116() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Add Layer\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Add_Layer )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Save\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Save )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the validation massage like.\r\n"
		  		+ "\"Please Enter Layer Name\"\r\n"
		  		+ "\"Please Enter Alias Name\"");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Please Enter Layer Name\"]")).isDisplayed());
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Please Enter Alias Name\"]")).isDisplayed());
	  }
	
	@Test(priority=117, description="To verify that user is not able to add layer without entering \" Layer Name \".")
	  public void SGL_Ranchi_Admin_Language_117() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Add Layer\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Add_Layer )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Enter valid  alias name in \"Alias Name\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Alias_Name )).sendKeys("Testing");
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Save\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Save )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the validation massage like.\r\n"
		  		+ "\"Please Enter Layer Name\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Please Enter Layer Name\"]")).isDisplayed());
	  }
	
	@Test(priority=118, description="To verify that user is not able to add layer without entering \"Alias Name\".")
	  public void SGL_Ranchi_Admin_Language_118() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Add Layer\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Add_Layer )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Enter valid  layer name in \"Layer Name\" textbox.");
		  driver.findElement(By.xpath(User_Management_R.txt_Layer_Name )).sendKeys("Testing");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Save\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Save )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the validation massage like.\r\n"
		  		+ "\"Please Enter Alias Name\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Please Enter Alias Name\"]")).isDisplayed());
	  }
	
	@Test(priority=120, description="To verify that user is not able to perform \"Delete Multiple\" functionality without selection of manage attribute from layer attribute mananement screen..")
	  public void SGL_Ranchi_Admin_Language_120() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Manage Attribute\" button for the particular layer.");
		  driver.findElement(By.xpath("//tbody[@id=\"ttbllayerbody\"]/tr[10]/td[5]/a" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Delete Multiple\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Delete_Multiple_User )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the validation message as,\r\n"
		  		+ "\"Please Select Layer\" ");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Please Select Layer\"]")).isDisplayed());
	  }
	
	@Test(priority=121, description="To verify that user is not able to perform \"Delete Multiple\" functionality without selection of layar from layer management screen.")
	  public void SGL_Ranchi_Admin_Language_121() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"User Management\" from the \"Main\" Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Layer Management\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Layer_Management )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Delete Multiple\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Delete_Multiple_User )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the validation message as,\r\n"
		  		+ "\"Please Select Layer\" ");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Please Select Layer\"]")).isDisplayed());
	  }
	
	@Test(priority=122, description="To verify that user is able to get \"Event Logs\" screen.")
	  public void SGL_Ranchi_Admin_Language_122() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select \"Event Logs\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Event_Log)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landing page of the \"Event Logs\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//h5[text()=\"Event Logs\"]")).isDisplayed());
	  }
	
	@Test(priority=123, description="To verify that user is able to perform \"Event Logs\" functionality.")
	  public void SGL_Ranchi_Admin_Language_123() throws InterruptedException {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select \"Event Logs\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Event_Log)).click();
		  Thread.sleep(2000);
		  String aa = driver.findElement(By.xpath("//div[@id=\"tbllogdetails_info\"]")).getText();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on profile icon.");
		  driver.findElement(By.xpath(User_Management_R.btn_User_Profile)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Logout\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Logout)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"SIGN IN\" button from home page of the Ranchi application.");
		  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Enter valid credentials of \"Citizen\" User.");
		  driver.findElement(By.xpath(Sign_In_Page_R.txt_Login_Name)).sendKeys("deptuser");
		  driver.findElement(By.xpath(Sign_In_Page_R.txt_Password)).sendKeys("Abc@1234");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"LOGIN\" button.");
		  driver.findElement(By.xpath(Sign_In_Page_R.btn_Sign_In)).click();
		  Thread.sleep(5000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on Profile icon button from the City GIS page.");
		  driver.findElement(By.xpath(City_GIS_R.btn_User_Profile)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Click on \"Logout\" functionality.");
		  driver.findElement(By.xpath("//i[@class=\"fa fa-power-off text-sm\"]")).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14:</b> Click on \"SIGN IN\" button from home page of the Ranchi application.");
		  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15:</b> Enter valid credentials of \"Citizen\" User.");
		  driver.findElement(By.xpath(Sign_In_Page_R.txt_Login_Name)).sendKeys("Admin");
		  driver.findElement(By.xpath(Sign_In_Page_R.txt_Password)).sendKeys("Abc@1234");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16:</b> Click on \"LOGIN\" button.");
		  driver.findElement(By.xpath(Sign_In_Page_R.btn_Sign_In)).click();
		  Thread.sleep(5000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17:</b> Select \"Event Logs\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Event_Log)).click();
		  Thread.sleep(2000);
		  String ab = driver.findElement(By.xpath("//div[@id=\"tbllogdetails_info\"]")).getText();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1.User should get landing page of the \"Event Logs\".\r\n"
		  		+ "2. User should get the garden department signin-signout logs in \"Event Logs\" page.");
		  Assert.assertNotEquals(aa,ab);
	  }
	
	@Test(priority=124, description="To verify that user is able to perform \"Dashboard\" functionality from \"Log Details\" screen.")
	  public void SGL_Ranchi_Admin_Language_124() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select \"Event Logs\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Event_Log)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Dashboard\" icon.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Dashboard)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should be get the landing page of the administrator.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Roles\"]")).isDisplayed());  
	  }
	
	@Test(priority=125, description="To verify that user is able to perform \"Delete\" functionality.")
	  public void SGL_Ranchi_Admin_Language_125() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select \"Event Logs\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Event_Log)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Delete\" button for the particular logs.");
		  driver.findElement(By.xpath("//tbody/tr[1]/td[3]/a" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User  should get confirmation message for delete logs.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"sweet-alert showSweetAlert visible\"]")).isDisplayed());   
	  }
	
	@Test(priority=126, description="To verify that user is able to perform \"Delete Multiple\" functionality.")
	  public void SGL_Ranchi_Admin_Language_126() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select \"Event Logs\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Event_Log)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select the logs from \"logs\" list.");
		  driver.findElement(By.xpath("//tr[1]/td[1]/input" )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Delete Multiple\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Delete_Multiple_User )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get confirmation massage for delete logs.  ");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"sweet-alert showSweetAlert visible\"]")).isDisplayed());        
	  }
	
	@Test(priority=127, description="To verify that user is able to perform \"Search\" functionality.")
	  public void SGL_Ranchi_Admin_Language_127() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select \"Event Logs\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Event_Log)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b>Enter search criteria into \"Search\" textbox.");
		  driver.findElement(By.xpath("//input[@aria-controls=\"tbllogdetails\"]")).sendKeys("user");
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the searched result into User Data grid.");
		  String aa = driver.findElement(By.xpath("//tbody/tr[1]/td[4]")).getText();
		  Assert.assertEquals(true, aa.contains("deptuser"));       
	  }
	
	@Test(priority=128, description="To verify that user is able to select number of records show on logs data grid.")
	  public void SGL_Ranchi_Admin_Language_128() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select \"Event Logs\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Event_Log)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select number from the \"Show No. of Entries\" dropdown list.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@name=\"tbllogdetails_length\"]")));  
		  dropdown.selectByValue("50"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the selected number of the records on Data User grid.");
		  Assert.assertNotEquals("10", driver.findElement(By.xpath("//tr/td[5]/input")).getText());
	  }
	
	@Test(priority=129, description="To verify that user is able to perform \"Sorting\" functionality for \"SR. NO.\", \"Username\",\"IP Address\",\"Login Status\",\"Action type\",\"Module Name\",\"Action Date\" column.")
	  public void SGL_Ranchi_Admin_Language_129(Method method) throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select \"Event Logs\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Event_Log)).click();
		  Thread.sleep(2000);
          List<WebElement> element1 = driver.findElements(By.xpath("//tr/td[2]"));
		  System.out.println(element1.size());
		  String[] stringArray2 = new String[element1.size()];
		  for(int i =0; i<element1.size(); i++) {
			 
			 stringArray2[i]=driver.findElements(By.xpath("//tr/td[2]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element1.size(); i++) {
				 
			  System.out.println(stringArray2[i]);
			  }  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Sorting\" icon of the SR. NO. column.");
		  driver.findElement(By.xpath(User_Management_R.btn_Sorting_SR)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get logs data grid on Descending/Ascending order.");
		  List<WebElement> element2 = driver.findElements(By.xpath("//tr/td[2]"));
		  System.out.println(element2.size());
		  String[] stringArray3 = new String[element2.size()];
		  for(int i =0; i<element1.size(); i++) {
			 
			 stringArray3[i]=driver.findElements(By.xpath("//tr/td[2]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element1.size(); i++) {
				 
			  System.out.println(stringArray3[i]);
			  }
		  Assert.assertEquals(stringArray3,stringArray2);
		 objs.Screenshot(driver, Classname ,method.getName()+"_01" );
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Sorting\" icon of the SR. NO. column.");
		  driver.findElement(By.xpath(User_Management_R.btn_Sorting_SR)).click();
		  
		  Thread.sleep(2000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid on Ascending order..");
		 
		  List<WebElement> element4 = driver.findElements(By.xpath("//tr/td[2]"));
		  System.out.println(element4.size());
		  String[] stringArray4 = new String[element2.size()];
		  for(int i =0; i<element1.size(); i++) {
			 
			 stringArray4[i]=driver.findElements(By.xpath("//tr/td[2]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element4.size(); i++) {
				 
			  System.out.println(stringArray4[i]);
			  } 
		  Assert.assertNotEquals(stringArray3,stringArray4);
		  List<WebElement> element5 = driver.findElements(By.xpath("//tr/td[6]"));
		  System.out.println(element5.size());
		  String[] stringArray5 = new String[element5.size()];
		  for(int i =0; i<element5.size(); i++) 
		  {
		    stringArray5[i]=driver.findElements(By.xpath("//tr/td[6]")).get(i).getText();
			Thread.sleep(2000);
		  } 
		  for(int i =0; i<element5.size(); i++) 
		  {
		    System.out.println(stringArray5[i]);
			
		  }  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Sorting\" icon of the \"Login Status\" column.");
		  driver.findElement(By.xpath("//th[text()=\"Login Status\"]")).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid in alphabetical order.");
		  List<WebElement> element6 = driver.findElements(By.xpath("//tr/td[6]"));
		  System.out.println(element6.size());
		  String[] stringArray6 = new String[element6.size()];
		  for(int i =0; i<element6.size(); i++) {
			 
			 stringArray6[i]=driver.findElements(By.xpath("//tr/td[6]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element6.size(); i++) {
				 
			  System.out.println(stringArray6[i]);
			  }
		  Assert.assertNotEquals(stringArray6,stringArray5);
		  objs.Screenshot(driver, Classname ,method.getName()+"_02" ); 
		  List<WebElement> element7 = driver.findElements(By.xpath("//tr/td[7]"));
		  System.out.println(element7.size());
		  String[] stringArray7 = new String[element7.size()];
		  for(int i =0; i<element7.size(); i++) 
		  {
		    stringArray7[i]=driver.findElements(By.xpath("//tr/td[7]")).get(i).getText();
			Thread.sleep(2000);
		  } 
		  for(int i =0; i<element7.size(); i++) 
		  {
		    System.out.println(stringArray7[i]);
			
		  }  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"Sorting\" icon of the \"Action type\" column.");
		  driver.findElement(By.xpath("//th[text()=\"Action Type\"]")).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid in alphabetical order.");
		  List<WebElement> element8 = driver.findElements(By.xpath("//tr/td[7]"));
		  System.out.println(element8.size());
		  String[] stringArray8 = new String[element8.size()];
		  for(int i =0; i<element8.size(); i++) {
			 
			 stringArray8[i]=driver.findElements(By.xpath("//tr/td[7]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element8.size(); i++) {
				 
			  System.out.println(stringArray8[i]);
			  }
		  Assert.assertNotEquals(stringArray7,stringArray8);
		  objs.Screenshot(driver, Classname ,method.getName()+"_03" );
		  List<WebElement> element9 = driver.findElements(By.xpath("//tr/td[8]"));
		  System.out.println(element9.size());
		  String[] stringArray9 = new String[element9.size()];
		  for(int i =0; i<element9.size(); i++) 
		  {
		    stringArray9[i]=driver.findElements(By.xpath("//tr/td[8]")).get(i).getText();
			Thread.sleep(2000);
		  } 
		  for(int i =0; i<element9.size(); i++) 
		  {
		    System.out.println(stringArray9[i]);
			
		  }  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on \"Sorting\" icon of the \"Module Name\" column.");
		  driver.findElement(By.xpath("//th[text()=\"Module Name\"]")).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid in alphabetical order.");
		  List<WebElement> element10 = driver.findElements(By.xpath("//tr/td[8]"));
		  System.out.println(element10.size());
		  String[] stringArray10 = new String[element10.size()];
		  for(int i =0; i<element10.size(); i++) {
			 
			 stringArray10[i]=driver.findElements(By.xpath("//tr/td[8]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element10.size(); i++) {
				 
			  System.out.println(stringArray10[i]);
			  }
		  Assert.assertNotEquals(stringArray9,stringArray10);
		  objs.Screenshot(driver, Classname ,method.getName()+"_04" );
		  List<WebElement> element11 = driver.findElements(By.xpath("//tr/td[9]"));
		  System.out.println(element11.size());
		  String[] stringArray11 = new String[element11.size()];
		  for(int i =0; i<element11.size(); i++) 
		  {
		    stringArray11[i]=driver.findElements(By.xpath("//tr/td[9]")).get(i).getText();
			Thread.sleep(2000);
		  } 
		  for(int i =0; i<element11.size(); i++) 
		  {
		    System.out.println(stringArray11[i]);
			
		  }  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Click on \"Sorting\" icon of the \"Action Date\" column.");
		  driver.findElement(By.xpath("//th[text()=\"Action Date\"]")).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid in alphabetical order.");
		  List<WebElement> element12 = driver.findElements(By.xpath("//tr/td[9]"));
		  System.out.println(element12.size());
		  String[] stringArray12 = new String[element12.size()];
		  for(int i =0; i<element12.size(); i++) {
			 
			 stringArray12[i]=driver.findElements(By.xpath("//tr/td[9]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element12.size(); i++) {
				 
			  System.out.println(stringArray12[i]);
			  }
		  Assert.assertNotEquals(stringArray12,stringArray11);
		  objs.Screenshot(driver, Classname ,method.getName()+"_05" );
		  List<WebElement> element13 = driver.findElements(By.xpath("//tr/td[4]"));
		  System.out.println(element13.size());
		  String[] stringArray13 = new String[element13.size()];
		  for(int i =0; i<element13.size(); i++) 
		  {
		    stringArray13[i]=driver.findElements(By.xpath("//tr/td[4]")).get(i).getText();
			Thread.sleep(2000);
		  } 
		  for(int i =0; i<element13.size(); i++) 
		  {
		    System.out.println(stringArray13[i]);
			
		  }  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14:</b> Click on \"Sorting\" icon of the \"Username\" column.");
		  driver.findElement(By.xpath("//th[text()=\"Username\"]")).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid in alphabetical order.");
		  List<WebElement> element14 = driver.findElements(By.xpath("//tr/td[4]"));
		  System.out.println(element14.size());
		  String[] stringArray14 = new String[element14.size()];
		  for(int i =0; i<element14.size(); i++) {
			 
			 stringArray14[i]=driver.findElements(By.xpath("//tr/td[4]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element14.size(); i++) {
				 
			  System.out.println(stringArray14[i]);
			  }
		  Assert.assertNotEquals(stringArray13,stringArray14);
		  objs.Screenshot(driver, Classname ,method.getName()+"_06" );
		  List<WebElement> element15 = driver.findElements(By.xpath("//tr/td[5]"));
		  System.out.println(element15.size());
		  String[] stringArray15 = new String[element15.size()];
		  for(int i =0; i<element15.size(); i++) 
		  {
		    stringArray15[i]=driver.findElements(By.xpath("//tr/td[5]")).get(i).getText();
			Thread.sleep(2000);
		  } 
		  for(int i =0; i<element15.size(); i++) 
		  {
		    System.out.println(stringArray15[i]);
			
		  }  
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15:</b> Click on \"Sorting\" icon of the \"IP Address\" column.");
		  driver.findElement(By.xpath("//th[text()=\"IP Address\"]")).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid in alphabetical order.");
		  List<WebElement> element16 = driver.findElements(By.xpath("//tr/td[5]"));
		  System.out.println(element16.size());
		  String[] stringArray16 = new String[element16.size()];
		  for(int i =0; i<element16.size(); i++) {
			 
			 stringArray16[i]=driver.findElements(By.xpath("//tr/td[5]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element16.size(); i++) {
				 
			  System.out.println(stringArray16[i]);
			  }
		  Assert.assertNotEquals(stringArray15,stringArray16);
	  }
	
	@Test(priority=130, description="To verify that user is able to \"Select All\" logs from the logs data grid.")
	  public void SGL_Ranchi_Admin_Language_130() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select \"Event Logs\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Event_Log)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on check box of the header row from the User data grid.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();",   driver.findElement(By.xpath(User_Management_R.chk_Select_All)));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get all the user from the user data grid as selected.");
		  List<WebElement> element1 = driver.findElements(By.xpath("//tr/td[1]/input"));
		  System.out.println(element1.size());
		  for(int i =0; i<element1.size(); i++) {
			  Assert.assertEquals(true,driver.findElement(By.xpath("//tr/td[1]/input")).isSelected());
			 Thread.sleep(1000);
		  } 
	  }
	
	@Test(priority=131, description="To verify that user is able to select particular log from the logs data grid.")
	  public void SGL_Ranchi_Admin_Language_131(Method method) throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select \"Event Logs\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Event_Log)).click();
		  Thread.sleep(2000);
		  List<WebElement> element1 = driver.findElements(By.xpath("//tr/td[1]/input"));
		  System.out.println(element1.size());
		  for(int i =0; i<element1.size(); i++) {
			  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7."+i+":</b> Click on check box of the particular user from the user data grid.");
			  element1.get(i).click();
			  Thread.sleep(2000);
			  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get particular user from the user data grid as selected.");
			  Assert.assertEquals(true,driver.findElement(By.xpath("//tr/td[1]/input")).isSelected());
			  Thread.sleep(1000);
			  objs.Screenshot(driver, Classname ,method.getName()+"_"+i );
		  } 
	  }
	
	@Test(priority=132, description="To verify that user is able to perform  \"Pagination\" functionality.")
	  public void SGL_Ranchi_Admin_Language_132(Method method) throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select \"Event Logs\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Event_Log)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Next\" button of the paging.");
		  driver.findElement(By.xpath(User_Management_R.btn_Next)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get next page of the User Data grid.");
		  Assert.assertEquals("2",driver.findElement(By.xpath("//a[@class=\"paginate_button current\"]")).getText());
		  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Previous\" button of the paging.");
		  driver.findElement(By.xpath(User_Management_R.btn_Previous)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Click on \"Previous\" button of the paging.");
		  Assert.assertEquals("1",driver.findElement(By.xpath("//a[@class=\"paginate_button current\"]")).getText());
	  }
	
	@Test(priority=133, description="To verify that user is not able to perform \"Delete Multiple\" functionality without selection of event logs.")
	  public void SGL_Ranchi_Admin_Language_133() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select \"Event Logs\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Event_Log)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Delete Multiple\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Delete_Multiple_User)).click();
		  Thread.sleep(3000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message as,\r\n"
		  		+ "\"Please Select Log\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Please Select Log\"]")).isDisplayed()); 
	  }
	
	@Test(priority=134, description="To verify that user is able to perform \"Water Pipeline\" functionality.")
	  public void SGL_Ranchi_Admin_Language_134() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"Reports\" from the \"MAIN\" panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_Reports )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Water Pipeline\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Water_Pipeline)).click();
		  Thread.sleep(3000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select ward number from the \"Ward Number\" dropdown.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlwaterward\"]")));  
		  dropdown.selectByValue("10"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select material construction from the \"Material Construction\" dropdown.");
		  Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id=\"ddlwatermaterial\"]")));  
		  dropdown1.selectByVisibleText("DI K-7"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Select  pipeline diameter  from the \"Pipeline Diameter\" dropdown.");
		  Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@id=\"ddlwaterpipelinediameter\"]")));  
		  dropdown2.selectByVisibleText("100"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"Generate Report\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Generate_Report )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Report should export in pdf format.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"No Data Found\"]")).isDisplayed()); 
	  }
	
	@Test(priority=135, description="To verify that user is able to perform \"Dashboard\" functionality from \"Water Pipeline\" screen.")
	  public void SGL_Ranchi_Admin_Language_135() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"Reports\" from the \"MAIN\" panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_Reports )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Water Pipeline\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Water_Pipeline)).click();
		  Thread.sleep(3000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Dashboard\" icon.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Dashboard)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should be get the landing page of the administrator.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Roles\"]")).isDisplayed()); 
	  }
	
	@Test(priority=136, description="To verify that user is not able to perform \"Water Pipeline\" functionality without selecting ward number.")
	  public void SGL_Ranchi_Admin_Language_136() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"Reports\" from the \"MAIN\" panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_Reports )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Water Pipeline\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Water_Pipeline)).click();
		  Thread.sleep(3000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Generate Report\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Generate_Report )).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the validation message as,\r\n"
		  		+ "\"Please Select Ward Number\"");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Please Select Ward Number\"]")).isDisplayed()); 
	  }
	
	@Test(priority=137, description="To verify that user is able to perform \"School Detail\" functionality.")
	  public void SGL_Ranchi_Admin_Language_137() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"Reports\" from the \"MAIN\" panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_Reports )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"School Detail\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_School_Detail)).click();
		  Thread.sleep(3000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select ward number from the \"Ward Number\" dropdown.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlwaterward\"]")));  
		  dropdown.selectByValue("10"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select school type from the \" School Type \" dropdown.");
		  Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id=\"ddlschooltype\"]")));  
		  dropdown1.selectByVisibleText("Higher Secondary"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Select type of degree from the \"Type of Degree\" dropdown.");
		  Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@id=\"ddltypeofdegree\"]")));  
		  dropdown2.selectByVisibleText("Class IV"); 
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"Generate Report\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Generate_Report )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Report should export in pdf format.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"No Data Found\"]")).isDisplayed()); 
	  }
	
	@Test(priority=138, description="To verify that user is able to perform \"Dashboard\" functionality from \"School Detail\" screen.")
	  public void SGL_Ranchi_Admin_Language_138() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"Reports\" from the \"MAIN\" panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_Reports )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"School Detail\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_School_Detail)).click();
		  Thread.sleep(3000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Dashboard\" icon.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Dashboard)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should be get the landing page of the administrator.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Roles\"]")).isDisplayed()); 
	  }
	
	@Test(priority=139, description="To verify that user is not able to perform \"School Detail\" functionality without selecting ward number.")
	  public void SGL_Ranchi_Admin_Language_139() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"Reports\" from the \"MAIN\" panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_Reports )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"School Detail\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_School_Detail)).click();
		  Thread.sleep(3000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Generate Report\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Generate_Report )).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the validation message as,\r\n"
		  		+ "\"Please Select Ward Number\"");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Please Select Ward Number\"]")).isDisplayed()); 
	  }
	
	@Test(priority=140, description="To verify that user is able to perform \"Features Audit Report\" functionality with selected report type.")
	  public void SGL_Ranchi_Admin_Language_140() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"Reports\" from the \"MAIN\" panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_Reports )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Features Audit Report\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Features_Audit_Report)).click();
		  Thread.sleep(3000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Generate Report\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Generate_Report )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Report should export in pdf format.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//embed[@type=\"application/pdf\"]")).isDisplayed()); 
	  }
	
	@Test(priority=142, description="To verify that user is able to perform \"Dashboard\" functionality from \"Features Audit Report\" screen.")
	  public void SGL_Ranchi_Admin_Language_142() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand icon of the \"Reports\" from the \"MAIN\" panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_Reports )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"Features Audit Report\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Features_Audit_Report)).click();
		  Thread.sleep(3000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Dashboard\" icon.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Dashboard)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should be get the landing page of the administrator.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Roles\"]")).isDisplayed()); 
	  }
	
	@Test(priority=143, description="To verify that user is able to get \"View Profile\" screen.")
	  public void SGL_Ranchi_Admin_Language_143() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"User Profile\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_User_Profile)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the \"View Profile\" screen.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Welcome \"]")).isDisplayed()); 
		  Assert.assertEquals(true, driver.findElement(By.xpath("//strong[text()=\"admin\"]")).isDisplayed());
	  }
	
	@Test(priority=144, description="To verify that user is able to perform \"Edit Profile\" functionality.")
	  public void SGL_Ranchi_Admin_Language_144() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Profile\" icon .");
		  driver.findElement(By.xpath(User_Management_R.btn_User_Profile)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"User Profile\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Profile)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Edit Profile\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Edit_Profile)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Update\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Update)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get success message as \r\n"
		  		+ "\"Profile Updated Successfully\"");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Profile updated successfully.\"]")).isDisplayed());
	  }
	
	@Test(priority=145, description="To verify that user is able to perform \"Cancel\" functionality.")
	  public void SGL_Ranchi_Admin_Language_145() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Profile\" icon .");
		  driver.findElement(By.xpath(User_Management_R.btn_User_Profile)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"User Profile\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Profile)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Edit Profile\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Edit_Profile)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Cancel\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Cancel)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should not able to update the user profile.");
		  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.btn_Edit_Profile)).isDisplayed());
	  }
	
	@Test(priority=146, description="To verify that user is able to perform \"Dashboard\" functionality from \"View Profile\" screen.")
	  public void SGL_Ranchi_Admin_Language_146() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Profile\" icon .");
		  driver.findElement(By.xpath(User_Management_R.btn_User_Profile)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"User Profile\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Profile)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Dashboard\" icon.");
		  driver.findElement(By.xpath(User_Management_R.lnk_Dashboard)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should be get the landing page of the administrator.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Roles\"]")).isDisplayed()); 
	  }
	
	@Test(priority=147, description="To verify that user can not able to perform \"View Profile\" functionality with entering invalid new password.")
	  public void SGL_Ranchi_Admin_Language_147() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Profile\" icon .");
		  driver.findElement(By.xpath(User_Management_R.btn_User_Profile)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"User Profile\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Profile)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Edit Profile\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Edit_Profile)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Enter invalid new password into \"New Password\" textbox.");
		  driver.findElement(By.xpath("//input[@data-requireerrorcode=\"register_password\"]")).sendKeys("dsss");
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Update\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Update)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the suggesstion message as,\r\n"
		  		+ "\"Password must contain 1 small-case letter, 1 Capital letter, 1 digit, 1 special character and the length should be between 6-12 characters.\"");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Password must contain 1 small-case letter, 1 Capital letter, 1 digit, 1 special character and the length should be between 6-12 characters.\"]")).isDisplayed());
	  }
	
	@Test(priority=148, description="To verify that user can not able to perform \"View Profile\" functionality with entering invalid confirm password.")
	  public void SGL_Ranchi_Admin_Language_148() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Profile\" icon .");
		  driver.findElement(By.xpath(User_Management_R.btn_User_Profile)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"User Profile\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Profile)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Edit Profile\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Edit_Profile)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Enter new password into \"New Password\" textbox.");
		  driver.findElement(By.xpath("//input[@data-requireerrorcode=\"register_password\"]")).sendKeys("Abc@1234");
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Enter invalid confirm password into \"Confirm Password\" textbox.");
		  driver.findElement(By.xpath("//input[@data-requireerrorcode=\"register_retypepassword_notmatch\"]")).sendKeys("dsss");
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"Update\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Update)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the suggesstion message as,\r\n"
		  		+ "\"Confirm Password Does Not Match\".");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Confirm Password Does Not Match\"]")).isDisplayed());
	  }
	
	@Test(priority=149, description="To verify that user is able to perform \"Logout\" functionality.")
	  public void SGL_Ranchi_Admin_Language_149() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Profile\" icon .");
		  driver.findElement(By.xpath(User_Management_R.btn_User_Profile)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Logout\" functionality.");
		  driver.findElement(By.xpath(User_Management_R.btn_Logout)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get \"Home\" page of the \"Ranchi\" application.");
		  String actualTitle=driver.getTitle();
		  String expectedTitle="Ranchi Smart City Portal";
		  Assert.assertEquals(actualTitle, expectedTitle);
	  }
	
	@Test(priority=150, description="To verify that user is able to perform \"Administrator\" functionality from home page.")
	  public void SGL_Ranchi_Admin_Language_150() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Profile\" icon .");
		  driver.findElement(By.xpath(User_Management_R.btn_User_Profile)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Edit Profile\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Edit_Profile)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Administrator\" link from home page.");
		  driver.findElement(By.xpath(User_Management_R.btn_Administrator )).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on landing page of \"Admin\" department.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Roles\"]")).isDisplayed()); 
	  }
	
	@Test(priority=151, description="To verify that user is able to redirect on \"Home\" Page of the admin page while clicking on \"Ranchi\" logo.")
	  public void SGL_Ranchi_Admin_Language_151() throws InterruptedException {
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" link from the home page of the Ranchi application.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid credentials of register \"Citizen\" user.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Sign In button.");
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Profile\" icon .");
		  driver.findElement(By.xpath(User_Management_R.btn_User_Profile)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Edit Profile\" button.");
		  driver.findElement(By.xpath(User_Management_R.btn_Edit_Profile)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Ranchi\" logo from the admin page.");
		  driver.findElement(By.xpath("//img[@alt=\"brand\"]")).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on landing page of \"Admin\" department.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Roles\"]")).isDisplayed()); 
	  }
  @AfterMethod
  public void afterClass() {
	driver.quit();
	  }
  }


