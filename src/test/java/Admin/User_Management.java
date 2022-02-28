package Admin;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import Admin_R.User_Management_R;
import Application_Pages_R.Home_Page_R;
import Application_Pages_R.Sign_In_Page_R;
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
		  Assert.assertEquals("DSCL Dashboard", driver.getTitle());
	  }
 
  @Test(priority=1, description="To verify that user is able to get User Management functionality.")
  public void DSCL_Admin_UserManagement_01() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the expanded list of the User Management like:\r\n"
	  		+ "\r\n"
	  		+ "- Manage Users,\r\n"
	  		+ "- Manage Roles,\r\n"
	  		+ "- Assign Role permission,\r\n"
	  		+ "- Manage Configurations.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).isDisplayed());
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.btn_Manage_Configurations)).isDisplayed());
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).isDisplayed());
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).isDisplayed());
  }
  
  @Test(priority=2, description="To verify that user is able to get User Management functionality.")
  public void DSCL_Admin_UserManagement_02(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Management in expanded mode.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//ul[@class=\"collapse-level-1 collapse show\"]")).isDisplayed());
	  objs.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Collapse icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Management in collapse mode.");
	  Assert.assertEquals(false, driver.findElement(By.xpath("//ul[@class=\"collapse-level-1 collapse\"]")).isDisplayed());
  }
  
  @Test(priority=3, description="To verify that user is able to get User Management screen.")
  public void DSCL_Admin_UserManagement_03() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Users\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landing page of User Management.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.label_Manage_User)).isDisplayed());
  }
  
  @Test(priority=4, description="To verify that user is able to perform  Add User functionality.")
  public void DSCL_Admin_UserManagement_04() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Users\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Add User\" button.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.btn_Add_User)));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b>  Select particular Role from the Role list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"cmbgroup\"]")));  
	  dropdown.selectByValue("92"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter valid First Name in First Name textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_First_Name)).sendKeys("Meet");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Enter valid Middle Name in Middle Name textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_Middle_Name)).sendKeys("Ghanshyambhai");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter valid Last Name in Last Name textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_Last_Name)).sendKeys("Gondaliya");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter valid User Name in User Name textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_Login_Name)).sendKeys("MeetQA");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Enter valid Mobile No. in Mobile No. textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_Mobile_No)).sendKeys("9027324797");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Enter valid Email-id in Email textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_EmailId)).sendKeys("meegft.g@sgligis.com"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"Register\" button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Register)).click();
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get successful message of the Registration.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Success_Message)).isDisplayed());
  }
  
  @Test(priority=5, description="To verify that user is able to perform Cancel register user functionality.")
  public void DSCL_Admin_UserManagement_05() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Users\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Add User\" button.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.btn_Add_User)));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Cancel\" button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Cancel)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should not able to register user and get landing page of the User Management.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.label_Manage_User)).isDisplayed());
  }
  
  @Test(priority=6, description="To verify that user is able to perform Edit Functionality.")
  public void DSCL_Admin_UserManagement_06() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Users\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Edit\" button.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.btn_Edit_User)));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Change selected Role from the Role list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"cmbgroup\"]")));  
	  dropdown.selectByValue("92"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Change existing First Name in First Name textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_First_Name)).sendKeys("Meet");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Change existing Middle Name in Middle Name textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_Middle_Name)).sendKeys("Ghanshyambhai");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Change existing Last Name in Last Name textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_Last_Name)).sendKeys("Gondaliya");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Change existing Mobile No. in Mobile No. textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_Mobile_No)).sendKeys("9923328797");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Change existing Email-Id in Email textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_EmailId)).sendKeys("meet.g@sgligis.com"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"Update\" button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Update)).click();
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get successful message of the Update user details.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Success_Message_Update)).isDisplayed());
  }
  
  @Test(priority=7, description="To verify that user is able to perform Delete Functionality.")
  public void DSCL_Admin_UserManagement_07() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Users\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Delete\" button for the particular user.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.btn_Delete_User)));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Yes\" button of the confirmation message of the Delete user.");
	  driver.findElement(By.xpath(User_Management_R.btn_Yes_User_Delete)).click();
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get successful message of the delete record.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"sweet-alert showSweetAlert visible\"]")).isDisplayed());
  }
  
  @Test(priority=8, description="To verify that user is able to perform Active/In-Active functionality.")
  public void DSCL_Admin_UserManagement_08(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Users\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Check on \"Active/In-Active\" button for the particular user.");
	  driver.findElement(By.xpath(User_Management_R.btn_Active_User)).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath(User_Management_R.btn_Ok)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Selected users are Active in DSCL application.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.btn_Active_User)).isSelected());
	  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Check on \"Active/In-Active\" button for the particular user.");
	  driver.findElement(By.xpath(User_Management_R.btn_Active_User)).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath(User_Management_R.btn_Ok)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Selected users are Active in DSCL application.");
	  Assert.assertEquals(false, driver.findElement(By.xpath(User_Management_R.btn_Active_User)).isSelected());
  }
  
  @Test(priority=9, description="To verify that user is able to perform Delete Multiple functionality.")
  public void DSCL_Admin_UserManagement_09() throws InterruptedException {
	  
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Users\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select the users from the user list.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.btn_Select_User)));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:/b> Click on Delete Multiple button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Delete_Multiple_User)).click();
	  Thread.sleep(3000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get success message for Delete Multiple users.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"sweet-alert showSweetAlert visible\"]")).isDisplayed());
  }
  
  @Test(priority=10, description="To verify that user is able to perform Search functionality.")
  public void DSCL_Admin_UserManagement_10() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Users\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter Search criteria into Search textbox.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].value='admin';",  driver.findElement(By.xpath(User_Management_R.txt_Search)));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the searched result into User Data grid.");
	  Assert.assertEquals("admin", driver.findElement(By.xpath("//tr[1]/td[10]")).getText());
  }
  
  @Test(priority=11, description="To verify that user is able to select number of records show on User Data grid.")
  public void DSCL_Admin_UserManagement_11() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Users\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Number from the \"Show No. of Entries\" dropdown list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@name=\"tbluser_length\"]")));  
	  dropdown.selectByValue("50"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the selected number of the records on Data User grid.");
	  Assert.assertNotEquals("10", driver.findElement(By.xpath("//tr/td[5]/input")).getText());
  }
  
  @Test(priority=12, description="To verify that user is able to perform Sorting functionality for SR. NO. column of the User Data grid.")
  public void DSCL_Admin_UserManagement_12(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Users\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
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
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Sorting\" icon of the SR. NO. column..");
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
	  objs.Screenshot(driver, Classname ,method.getName()+"_01" );
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Sorting\" icon of the SR. NO. column.");
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
  }
  
  @Test(priority=13, description="To verify that user is able to perform Sorting functionality for the Name, User Name, Email, Role Name, Created By, and Created On columns of the User Data grid.")
  public void DSCL_Admin_UserManagement_13(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Users\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
	  List<WebElement> element1 = driver.findElements(By.xpath("//tr/td[6]"));
	  System.out.println(element1.size());
	  String[] stringArray2 = new String[element1.size()];
	  for(int i =0; i<element1.size(); i++) {
		 
		 stringArray2[i]=driver.findElements(By.xpath("//tr/td[6]")).get(i).getText();
		 Thread.sleep(2000);
	  } 
	  for(int i =0; i<element1.size(); i++) {
			 
		  System.out.println(stringArray2[i]);
		  } 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Sorting\" icon of the Name column.");
	  driver.findElement(By.xpath(User_Management_R.btn_Sorting_Name)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid in alphabetical order.");
	  List<WebElement> element2 = driver.findElements(By.xpath("//tr/td[6]"));
	  System.out.println(element2.size());
	  String[] stringArray3 = new String[element2.size()];
	  for(int i =0; i<element1.size(); i++) {
		 
		 stringArray3[i]=driver.findElements(By.xpath("//tr/td[6]")).get(i).getText();
		 Thread.sleep(2000);
	  } 
	  for(int i =0; i<element1.size(); i++) {
			 
		  System.out.println(stringArray3[i]);
		  }
	  Assert.assertNotEquals(stringArray3,stringArray2);
	  objs.Screenshot(driver, Classname ,method.getName()+"_01" );
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Sorting\" icon of the User Name column.");
	 List<WebElement> element4 = driver.findElements(By.xpath("//tr/td[7]"));
	  System.out.println(element4.size());
	  String[] stringArray4 = new String[element2.size()];
	  for(int i =0; i<element1.size(); i++) {
		 
		 stringArray4[i]=driver.findElements(By.xpath("//tr/td[7]")).get(i).getText();
		 Thread.sleep(2000);
	  } 
	  for(int i =0; i<element4.size(); i++) {
			 
		  System.out.println(stringArray4[i]);
		  } 
	  driver.findElement(By.xpath(User_Management_R.btn_Sorting_User_Name)).click();
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get records in Ascending/Descending order.");
	 List<WebElement> element5 = driver.findElements(By.xpath("//tr/td[7]"));
	  System.out.println(element5.size());
	  String[] stringArray5 = new String[element5.size()];
	  for(int i =0; i<element1.size(); i++) {
		 
		 stringArray5[i]=driver.findElements(By.xpath("//tr/td[7]")).get(i).getText();
		 Thread.sleep(2000);
	  } 
	  for(int i =0; i<element5.size(); i++) {
			 
		  System.out.println(stringArray5[i]);
		  } 
	  
	  Assert.assertNotEquals(stringArray5,stringArray4);
	  objs.Screenshot(driver, Classname ,method.getName()+"_02" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b>  Click on \"Sorting\" icon of the Email column.");
		 List<WebElement> element6 = driver.findElements(By.xpath("//tr/td[8]"));
		  System.out.println(element6.size());
		  String[] stringArray6 = new String[element6.size()];
		  for(int i =0; i<element6.size(); i++) {
			 
			 stringArray6[i]=driver.findElements(By.xpath("//tr/td[8]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element6.size(); i++) {
				 
			  System.out.println(stringArray6[i]);
			  } 
		  driver.findElement(By.xpath(User_Management_R.btn_Sorting_User_Name)).click();
		  Thread.sleep(2000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get records in Ascending/Descending order.");
		 List<WebElement> element7 = driver.findElements(By.xpath("//tr/td[8]"));
		  System.out.println(element7.size());
		  String[] stringArray7= new String[element7.size()];
		  for(int i =0; i<element7.size(); i++) {
			 
			 stringArray7[i]=driver.findElements(By.xpath("//tr/td[8]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element7.size(); i++) {
				 
			  System.out.println(stringArray7[i]);
			  } 
		  
		  Assert.assertNotEquals(stringArray6,stringArray7);
		  objs.Screenshot(driver, Classname ,method.getName()+"_03" );
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Sorting\" icon of the Role Name column.");
			 List<WebElement> element8 = driver.findElements(By.xpath("//tr/td[9]"));
			  System.out.println(element8.size());
			  String[] stringArray8 = new String[element8.size()];
			  for(int i =0; i<element8.size(); i++) {
				 
				 stringArray8[i]=driver.findElements(By.xpath("//tr/td[9]")).get(i).getText();
				 Thread.sleep(2000);
			  } 
			  for(int i =0; i<element8.size(); i++) {
					 
				  System.out.println(stringArray8[i]);
				  } 
			  driver.findElement(By.xpath(User_Management_R.btn_Sorting_User_Name)).click();
			  Thread.sleep(2000);
			 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get records in Ascending/Descending order.");
			 List<WebElement> element9 = driver.findElements(By.xpath("//tr/td[9]"));
			  System.out.println(element9.size());
			  String[] stringArray9= new String[element9.size()];
			  for(int i =0; i<element9.size(); i++) {
				 
				 stringArray9[i]=driver.findElements(By.xpath("//tr/td[9]")).get(i).getText();
				 Thread.sleep(2000);
			  } 
			  for(int i =0; i<element9.size(); i++) {
					 
				  System.out.println(stringArray9[i]);
				  } 
			  
			  Assert.assertNotEquals(stringArray9,stringArray8);
			  objs.Screenshot(driver, Classname ,method.getName()+"_04" );
			  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Sorting\" icon of the Created By column.");
				 List<WebElement> element10 = driver.findElements(By.xpath("//tr/td[10]"));
				  System.out.println(element10.size());
				  String[] stringArray10 = new String[element10.size()];
				  for(int i =0; i<element10.size(); i++) {
					 
					 stringArray10[i]=driver.findElements(By.xpath("//tr/td[10]")).get(i).getText();
					 Thread.sleep(2000);
				  } 
				  for(int i =0; i<element10.size(); i++) {
						 
					  System.out.println(stringArray10[i]);
					  } 
				  driver.findElement(By.xpath(User_Management_R.btn_Sorting_User_Name)).click();
				  Thread.sleep(2000);
				 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get records in Ascending/Descending order.");
				 List<WebElement> element11 = driver.findElements(By.xpath("//tr/td[10]"));
				  System.out.println(element11.size());
				  String[] stringArray11= new String[element11.size()];
				  for(int i =0; i<element11.size(); i++) {
					 
					 stringArray11[i]=driver.findElements(By.xpath("//tr/td[10]")).get(i).getText();
					 Thread.sleep(2000);
				  } 
				  for(int i =0; i<element11.size(); i++) {
						 
					  System.out.println(stringArray11[i]);
					  } 
				  
				  Assert.assertNotEquals(stringArray11,stringArray10);
				  objs.Screenshot(driver, Classname ,method.getName()+"_05" );
				  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Sorting\" icon of the Created On column.");
					 List<WebElement> element12 = driver.findElements(By.xpath("//tr/td[11]"));
					  System.out.println(element12.size());
					  String[] stringArray12 = new String[element12.size()];
					  for(int i =0; i<element12.size(); i++) {
						 
						 stringArray10[i]=driver.findElements(By.xpath("//tr/td[11]")).get(i).getText();
						 Thread.sleep(2000);
					  } 
					  for(int i =0; i<element12.size(); i++) {
							 
						  System.out.println(stringArray12[i]);
						  } 
					  driver.findElement(By.xpath(User_Management_R.btn_Sorting_User_Name)).click();
					  Thread.sleep(2000);
					 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get records in Ascending/Descending order.");
					 List<WebElement> element13 = driver.findElements(By.xpath("//tr/td[11]"));
					  System.out.println(element13.size());
					  String[] stringArray13= new String[element13.size()];
					  for(int i =0; i<element13.size(); i++) {
						 
						 stringArray13[i]=driver.findElements(By.xpath("//tr/td[11]")).get(i).getText();
						 Thread.sleep(2000);
					  } 
					  for(int i =0; i<element13.size(); i++) {
							 
						  System.out.println(stringArray13[i]);
						  } 
					  
					  Assert.assertNotEquals(stringArray13,stringArray12);
  }
  
  @Test(priority=14, description="To verify that user is able to Select All users from the user data grid.")
  public void DSCL_Admin_UserManagement_14() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Users\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on check box of the header row from the User data grid.");
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
  
  @Test(priority=15, description="To verify that user is able to select particular user from the user data grid.")
  public void DSCL_Admin_UserManagement_15(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Users\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
	  List<WebElement> element1 = driver.findElements(By.xpath("//tr/td[1]/input"));
	  System.out.println(element1.size());
	  for(int i =0; i<element1.size(); i++) {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3."+i+":</b> Click on check box of the particular user from the user data grid.");
		  element1.get(i).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get particular user from the user data grid as selected.");
		  Assert.assertEquals(true,driver.findElement(By.xpath("//tr/td[1]/input")).isSelected());
		  Thread.sleep(1000);
		  objs.Screenshot(driver, Classname ,method.getName()+"_"+i );
	  } 
  }
  
  @Test(priority=16, description="To verify that user is able to perform Next/Previous page functionality.")
  public void DSCL_Admin_UserManagement_16(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Users\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Next button of the paging.");
	  driver.findElement(By.xpath(User_Management_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get next page of the User Data grid.");
	  Assert.assertEquals("2",driver.findElement(By.xpath("//a[@class=\"paginate_button current\"]")).getText());
	  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Previous button of the paging.");
	  driver.findElement(By.xpath(User_Management_R.btn_Previous)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get previous page of the User Data grid.");
	  Assert.assertEquals("1",driver.findElement(By.xpath("//a[@class=\"paginate_button current\"]")).getText());
  }
  
  @Test(priority=17, description="To verify that user is able to go on particular page no. of the user data grid.")
  public void DSCL_Admin_UserManagement_17() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Users\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on particular page no.");
	  driver.findElement(By.xpath("//a[text()=\"2\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get user data grid of the selected page no.");
	  Assert.assertEquals("2",driver.findElement(By.xpath("//a[@class=\"paginate_button current\"]")).getText());
  }
  
  @Test(priority=18, description="To verify that user is able to check number of entries are available in user data grid.")
  public void DSCL_Admin_UserManagement_18() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Users\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Check No. of Entries status on footer of the user data grid.");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the No. of the Entries availability status of the user data grid.");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//div[@id=\"tbluser_info\"]")).isDisplayed());
  }
  
  @Test(priority=19, description="To verify that user is not able to add user with blank required details.")
  public void DSCL_Admin_UserManagement_19() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Users\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Add User\" button.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.btn_Add_User)));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Register\" button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Register)).click();
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get error message for the select Department first.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_Email)).isDisplayed());
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_First_Name)).isDisplayed());
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_last_Name)).isDisplayed());
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_Mobile_No)).isDisplayed());
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_User_Name)).isDisplayed());  
  }
  
  @Test(priority=20, description="To verify that user is not able to add user with In-valid details like: First Name, Middle Name, Last Name, User Name,  Mobile No., and Email-id.")
  public void DSCL_Admin_UserManagement_20() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Users\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Add User\" button.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.btn_Add_User)));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b>  Select particular Role from the Role list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"cmbgroup\"]")));  
	  dropdown.selectByValue("92"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter invalid First Name in First Name textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_First_Name)).sendKeys("Meet");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Enter invalid Middle Name in Middle Name textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_Middle_Name)).sendKeys("Ghanshyambhai");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter invalid Last Name in Last Name textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_Last_Name)).sendKeys("Gondaliya");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter invalid User Name in User Name textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_Login_Name)).sendKeys("MeetQA");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Enter invalid Mobile No. in Mobile No. textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_Mobile_No)).sendKeys("90238797");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Enter invalid Email-id in Email textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_EmailId)).sendKeys("meetsgligis.com"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"Register\" button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Register)).click();
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get error message for the In-valid First name, Middle Name, Last Name, User Name, Mobile No., and Email-id.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Please enter valid mobile number\"]")).isDisplayed());
	  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Please enter valid email address\"]")).isDisplayed());
  }
  
  @Test(priority=22, description="To verify that user is not able to add user without entering \"User Name\".")
  public void DSCL_Admin_UserManagement_22() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Users\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Add User\" button.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.btn_Add_User)));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b>  Select particular Role from the Role list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"cmbgroup\"]")));  
	  dropdown.selectByValue("92"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter invalid First Name in First Name textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_First_Name)).sendKeys("Meet");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Enter invalid Middle Name in Middle Name textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_Middle_Name)).sendKeys("Ghanshyambhai");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter invalid Last Name in Last Name textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_Last_Name)).sendKeys("Gondaliya");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter invalid Mobile No. in Mobile No. textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_Mobile_No)).sendKeys("9023338797");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Enter invalid Email-id in Email textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_EmailId)).sendKeys("meetsg@ligis.com"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Register\" button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Register)).click();
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get error message like: \"Please enter valid  Register Username\".");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_User_Name)).isDisplayed());  
  }
  
  @Test(priority=23, description="To verify that user is not able to perform \"Delete Multiple\" functionality without selection of users.")
  public void DSCL_Admin_UserManagement_23() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Users\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Delete Multiple\" button.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",   driver.findElement(By.xpath(User_Management_R.btn_Delete_Multiple_User)));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get error message like: \"Please Select Users\".");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Select_User)).isDisplayed());  
  }
  
  @Test(priority=24, description="To verify that user is able to get Role Management screen.")
  public void DSCL_Admin_UserManagement_24() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Roles\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landing page of Role Management.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.label_Manage_Roles)).isDisplayed());  
  }
  
  @Test(priority=25, description="To verify that user is able to perform  Add Role functionality.")
  public void DSCL_Admin_UserManagement_25() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Roles\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Add Role\" button.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(User_Management_R.btn_Add_Role)));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid Role Code in Role code textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_Role_Code)).sendKeys("Testing");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter valid Role Name in Role Name textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_Role_Name)).sendKeys("Tester");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b>  Enter required Description for the Role.");
	  driver.findElement(By.xpath(User_Management_R.txt_Description)).sendKeys("User is able to testing all functionality.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Save\" button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Save)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get successful message of the role added.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Success_Message_Role)).isDisplayed());  
  }
  
  @Test(priority=26, description="To verify that user is able to perform Cancel add role functionality.")
  public void DSCL_Admin_UserManagement_26() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Roles\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Add Role\" button.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(User_Management_R.btn_Add_Role)));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Cancel\" button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Cancel)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should not able to add role and get landing page of the Role Management.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.label_Manage_Roles)).isDisplayed()); 
  }
  
  @Test(priority=27, description="To verify that user is able to perform Edit Functionality.")
  public void DSCL_Admin_UserManagement_27() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Roles\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Edit\" button.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].value='Testing';",  driver.findElement(By.xpath(User_Management_R.txt_Search)));
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(User_Management_R.btn_Edit_User)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Change existing Role code in Role Code textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_Role_Code)).sendKeys("Testing");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Change existing Role name in Role Name textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_Role_Name)).sendKeys("Tester");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Change existing Description in Description text area.");
	  driver.findElement(By.xpath(User_Management_R.txt_Description)).sendKeys("User is able to testing all functionality nd tes.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Save\" button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Update)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get successful message of the role added.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Success_Message_Update_Role)).isDisplayed());  
  }
  
  @Test(priority=28, description="To verify that user is able to perform Delete Functionality.")
  public void DSCL_Admin_UserManagement_28() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Roles\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> To verify that user is able to perform Delete Functionality.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].value='Testing';",  driver.findElement(By.xpath(User_Management_R.txt_Search)));
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(User_Management_R.btn_Delete_User)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get successful message of the delete record.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"sweet-alert showSweetAlert visible\"]")).isDisplayed());
  }
  
  @Test(priority=29, description="To verify that user is able to perform Active functionality.")
  public void DSCL_Admin_UserManagement_29(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Roles\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Check on \"Active\" button for the particular roles.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(User_Management_R.btn_Active_User)));
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(User_Management_R.btn_Ok)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Selected roles are Active in DSCL application.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.btn_Active_User)).isSelected());
	  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Check on \"Active/In-Active\" button for the particular user.");
	  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(User_Management_R.btn_Active_User)));
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(User_Management_R.btn_Ok)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Selected roles are in-Active in DSCL application.");
	  Assert.assertEquals(false, driver.findElement(By.xpath(User_Management_R.btn_Active_User)).isSelected());
  }
  
  @Test(priority=30, description="To verify that user is able to perform Delete Multiple functionality.")
  public void DSCL_Admin_UserManagement_30() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Roles\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select the roles from the role list.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(User_Management_R.btn_Select_User)));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:/b> Click on Delete Multiple button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Delete_Multiple_User)).click();
	  Thread.sleep(3000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get success message for Delete Multiple roles.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"sweet-alert showSweetAlert visible\"]")).isDisplayed());
  }
  @Test(priority=31, description="To verify that user is able to perform Search functionality.")
  public void DSCL_Admin_UserManagement_31() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Roles\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter Search criteria into Search textbox.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].value='Testing';",  driver.findElement(By.xpath(User_Management_R.txt_Search)));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the searched result into User Data grid.");
	  Assert.assertEquals("Testing", driver.findElement(By.xpath("//tr[2]/td[6]")).getText());
  }
  
  @Test(priority=32, description="To verify that user is able to select number of records show on Role Data grid.")
  public void DSCL_Admin_UserManagement_32() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Roles\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Number from the \"Show No. of Entries\" dropdown list.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//option[@value=\"50\"]")));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the selected number of the records on Data User grid.");
	  Assert.assertNotEquals("10", driver.findElement(By.xpath("//tr/td[5]/input")).getText());
  }
  
  @Test(priority=33, description="To verify that user is able to perform Sorting functionality for SR. NO. column of the Role Data grid.")
  public void DSCL_Admin_UserManagement_33(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Roles\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
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
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Sorting\" icon of the SR. NO. column..");
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
	  objs.Screenshot(driver, Classname ,method.getName()+"_01" );
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Sorting\" icon of the SR. NO. column.");
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
  }
  
  @Test(priority=34, description="To verify that user is able to perform Sorting functionality for the Role Code, Role Name, and Description on columns of the Role Data grid.")
  public void DSCL_Admin_UserManagement_34(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Roles\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
	  List<WebElement> element1 = driver.findElements(By.xpath("//tr/td[6]"));
	  System.out.println(element1.size());
	  String[] stringArray2 = new String[element1.size()];
	  for(int i =0; i<element1.size(); i++) {
		 
		 stringArray2[i]=driver.findElements(By.xpath("//tr/td[6]")).get(i).getText();
		 Thread.sleep(2000);
	  } 
	  for(int i =0; i<element1.size(); i++) {
			 
		  System.out.println(stringArray2[i]);
		  } 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Sorting\" icon of the Role Name column.");
	  driver.findElement(By.xpath(User_Management_R.btn_Sorting_Name)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get User Data grid in alphabetical order.");
	  List<WebElement> element2 = driver.findElements(By.xpath("//tr/td[6]"));
	  System.out.println(element2.size());
	  String[] stringArray3 = new String[element2.size()];
	  for(int i =0; i<element1.size(); i++) {
		 
		 stringArray3[i]=driver.findElements(By.xpath("//tr/td[6]")).get(i).getText();
		 Thread.sleep(2000);
	  } 
	  for(int i =0; i<element1.size(); i++) {
			 
		  System.out.println(stringArray3[i]);
		  }
	  Assert.assertNotEquals(stringArray3,stringArray2);
	  objs.Screenshot(driver, Classname ,method.getName()+"_01" );
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Sorting\" icon of the Role Code column.");
	 List<WebElement> element4 = driver.findElements(By.xpath("//tr/td[7]"));
	  System.out.println(element4.size());
	  String[] stringArray4 = new String[element2.size()];
	  for(int i =0; i<element1.size(); i++) {
		 
		 stringArray4[i]=driver.findElements(By.xpath("//tr/td[7]")).get(i).getText();
		 Thread.sleep(2000);
	  } 
	  for(int i =0; i<element4.size(); i++) {
			 
		  System.out.println(stringArray4[i]);
		  } 
	  driver.findElement(By.xpath(User_Management_R.btn_Sorting_User_Name)).click();
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get records in Ascending/Descending order.");
	 List<WebElement> element5 = driver.findElements(By.xpath("//tr/td[7]"));
	  System.out.println(element5.size());
	  String[] stringArray5 = new String[element5.size()];
	  for(int i =0; i<element1.size(); i++) {
		 
		 stringArray5[i]=driver.findElements(By.xpath("//tr/td[7]")).get(i).getText();
		 Thread.sleep(2000);
	  } 
	  for(int i =0; i<element5.size(); i++) {
			 
		  System.out.println(stringArray5[i]);
		  } 
	  
	  Assert.assertNotEquals(stringArray5,stringArray4);
	  objs.Screenshot(driver, Classname ,method.getName()+"_02" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b>  Click on \"Sorting\" icon of the Description column.");
		 List<WebElement> element6 = driver.findElements(By.xpath("//tr/td[8]"));
		  System.out.println(element6.size());
		  String[] stringArray6 = new String[element6.size()];
		  for(int i =0; i<element6.size(); i++) {
			 
			 stringArray6[i]=driver.findElements(By.xpath("//tr/td[8]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element6.size(); i++) {
				 
			  System.out.println(stringArray6[i]);
			  } 
		  driver.findElement(By.xpath(User_Management_R.btn_Sorting_User_Name)).click();
		  Thread.sleep(2000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get records in Ascending/Descending order.");
		 List<WebElement> element7 = driver.findElements(By.xpath("//tr/td[8]"));
		  System.out.println(element7.size());
		  String[] stringArray7= new String[element7.size()];
		  for(int i =0; i<element7.size(); i++) {
			 
			 stringArray7[i]=driver.findElements(By.xpath("//tr/td[8]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element7.size(); i++) {
				 
			  System.out.println(stringArray7[i]);
			  } 
		  
		  Assert.assertNotEquals(stringArray6,stringArray7);
  }
  
  @Test(priority=35, description="To verify that user is able to Select All roles from the role data grid.")
  public void DSCL_Admin_UserManagement_35() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Roles\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on check box of the header row from the User data grid.");
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
  
  @Test(priority=36, description="To verify that user is able to select particular role from the role data grid.")
  public void DSCL_Admin_UserManagement_36(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Roles\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
	  List<WebElement> element1 = driver.findElements(By.xpath("//tr/td[1]/input"));
	  System.out.println(element1.size());
	  for(int i =0; i<element1.size(); i++) {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3."+i+":</b> Click on check box of the particular role from the role data grid.");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();",  element1.get(i));
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get particular role from the role data grid as selected.");
		  Assert.assertEquals(true,driver.findElement(By.xpath("//tr/td[1]/input")).isSelected());
		  Thread.sleep(1000);
		  objs.Screenshot(driver, Classname ,method.getName()+"_"+i );
	  } 
  }
  
  @Test(priority=37, description="To verify that user is able to perform Next/Previous page functionality.")
  public void DSCL_Admin_UserManagement_37(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Roles\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Next button of the paging.");
	  driver.findElement(By.xpath(User_Management_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get next page of the Role Data grid.");
	  Assert.assertEquals("2",driver.findElement(By.xpath("//a[@class=\"paginate_button current\"]")).getText());
	  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Previous button of the paging.");
	  driver.findElement(By.xpath(User_Management_R.btn_Previous)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get previous page of the Role Data grid.");
	  Assert.assertEquals("1",driver.findElement(By.xpath("//a[@class=\"paginate_button current\"]")).getText());
  }
  
  @Test(priority=38, description="To verify that user is able to go on particular page no. of the user data grid.")
  public void DSCL_Admin_UserManagement_38() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Users\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on particular page no.");
	  driver.findElement(By.xpath("//a[text()=\"2\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get role data grid of the selected page no.");
	  Assert.assertEquals("2",driver.findElement(By.xpath("//a[@class=\"paginate_button current\"]")).getText());
  }
  
  @Test(priority=39, description="To verify that user is able to check number of entries are available in user data grid.")
  public void DSCL_Admin_UserManagement_39() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Users\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_User)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Check No. of Entries status on footer of the user data grid.");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the No. of the Entries availability status of the role data grid.");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//div[@id=\"tbluser_info\"]")).isDisplayed());
  }
  
  @Test(priority=40, description="To verify that user is not able to add role with blank required details.")
  public void DSCL_Admin_UserManagement_40() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Roles\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Add Role\" button.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(User_Management_R.btn_Add_Role)));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Save\" button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Save)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get error message for the select Department first.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_Role_Name)).isDisplayed());
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_Role_Code)).isDisplayed()); 
  }
  
  @Test(priority=41, description="To verify that user is not able to add role with In-valid Role Name.")
  public void DSCL_Admin_UserManagement_41() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Roles\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Add Role\" button.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(User_Management_R.btn_Add_Role)));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid Role Code in Role code textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_Role_Code)).sendKeys("Testing");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Save\" button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Save)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get error message for In-valid Role Name.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_Role_Name)).isDisplayed()); 
  }
  
  @Test(priority=42, description="To verify that user is not able to perform \"Delete Multiple\" functionality without selection of role/s.")
  public void DSCL_Admin_UserManagement_42() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Manage Roles\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Manage_Roles)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Delete Multiple\" button.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(User_Management_R.btn_Delete_Multiple_User)));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get error message like: \"Please Select Roles\".");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Select_Role)).isDisplayed());  
  }
  
  @Test(priority=43, description="To verify that user is able to get Role Permission screen.")
  public void DSCL_Admin_UserManagement_43() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Assign Role Permission\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> btn_Assign_Role_Permission.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.label_Assign_Role_Per)).isDisplayed());  
  }
  
  @Test(priority=44, description="To verify that user is able to assign module rights to particular role.")
  public void DSCL_Admin_UserManagement_44() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Assign Role Permission\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select particular Role from the Role list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
	  dropdown.selectByValue("92"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Module Rights button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Module_Rights)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select modules from the module list.");
	  driver.findElement(By.xpath(User_Management_R.chk_Dep_User)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Save\" button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Save)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get success message for the modules are assigned to the role.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\" Rights and Predefinded Query Rights assign sucsessfully.\"]")).isDisplayed());  
  }
  
  @Test(priority=45, description="To verify that user is able to perform Check All functionality.")
  public void DSCL_Admin_UserManagement_45 () throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Assign Role Permission\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select particular Role from the Role list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
	  dropdown.selectByValue("92"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Module Rights button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Module_Rights)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Check All\" button.");
	  driver.findElement(By.xpath("//a[text()=\"Check All\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Save\" button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Save)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get success message for the modules are assigned to the role.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\" Rights and Predefinded Query Rights assign sucsessfully.\"]")).isDisplayed());  
  }
  
  @Test(priority=46, description="To verify that user is able to perform Uncheck All functionality.")
  public void DSCL_Admin_UserManagement_46 () throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Assign Role Permission\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select particular Role from the Role list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
	  dropdown.selectByValue("92"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Module Rights button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Module_Rights)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Check All\" button.");
	  driver.findElement(By.xpath("//a[text()=\"Check All\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Uncheck All\" button.");
	  driver.findElement(By.xpath("//a[text()=\"Uncheck All\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Save\" button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Save)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get error message like: \"Please select at least one module.\"");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_MR)).isDisplayed());  
  }
  
  @Test(priority=47, description="To verify that user is able to perform Invert functionality.")
  public void DSCL_Admin_UserManagement_47() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Assign Role Permission\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select particular Role from the Role list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
	  dropdown.selectByValue("92"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Module Rights button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Module_Rights)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select modules from the module list.");
	  driver.findElement(By.xpath(User_Management_R.chk_Dep_User)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on Invert button.");
	  driver.findElement(By.xpath("//a[text()=\"Invert\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Save\" button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Save)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get success message for the modules are assigned to the role.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\" Rights and Predefinded Query Rights assign sucsessfully.\"]")).isDisplayed()); 
  }
  
  @Test(priority=48, description="To verify that user is able to perform Search functionality.")
  public void DSCL_Admin_UserManagement_48() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Assign Role Permission\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select particular Role from the Role list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
	  dropdown.selectByValue("92"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Module Rights button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Module_Rights)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select modules from the module list.");
	  driver.findElement(By.xpath(User_Management_R.chk_Dep_User)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Enter module name in search textbox.");
	  driver.findElement(By.xpath("//input[@placeholder=\"Search module\"]")).sendKeys("admin");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get result of searched module in module list.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div[text()=\"Admin Menu (Left Panel)\"]")).isDisplayed());  
  }
  
  @Test(priority=49, description="To verify that user is able to Expand particular module from the module list.")
  public void DSCL_Admin_UserManagement_49() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Assign Role Permission\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select particular Role from the Role list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
	  dropdown.selectByValue("92"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Module Rights button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Module_Rights)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Expand icon ahead from the particular module.");
	  driver.findElement(By.xpath(User_Management_R.btn_expand)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get result of searched module in module list.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//span[@class=\"jqx-tree-item-arrow-expand jqx-icon-arrow-down\"]")).isDisplayed());  
  }

  @Test(priority=50, description="To verify that user is able to perform Cancel functionality.")
  public void DSCL_Admin_UserManagement_50() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Assign Role Permission\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select particular Role from the Role list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
	  dropdown.selectByValue("92"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Module Rights button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Module_Rights)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Expand icon ahead from the particular module.");
	  driver.findElement(By.xpath(User_Management_R.btn_expand)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on Cancel button.");
	  driver.findElement(By.xpath("//button[text()=\"Cancel\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landing page of Role Permission without any selection of role and modules.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Roles\"]")).isDisplayed());  
  }
  
  @Test(priority=52, description="To verify that user is able to assign predefined query rights to particular role.")
  public void DSCL_Admin_UserManagement_52() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Assign Role Permission\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select particular Role from the Role list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
	  dropdown.selectByValue("92"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Predefined Query Rights button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Predefined_Query_Rights)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select predefined query from the query list.");
	  driver.findElement(By.xpath(User_Management_R.chk_Pre_Query)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Save\" button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Save)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get success message for the modules are assigned to the role.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Success_Message_MR)).isDisplayed());
  }
  
  @Test(priority=53, description="To verify that user is able to perform Check All functionality.")
  public void DSCL_Admin_UserManagement_53() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Assign Role Permission\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select particular Role from the Role list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
	  dropdown.selectByValue("92"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Predefined Query Rights button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Predefined_Query_Rights)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Check All\" button.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.chk_Dep_All)));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Save\" button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Save)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get success message for the modules are assigned to the role.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Success_Message_MR)).isDisplayed());
  }
  
  @Test(priority=54, description="To verify that user is able to perform Uncheck All functionality.")
  public void DSCL_Admin_UserManagement_54() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Assign Role Permission\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select particular Role from the Role list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
	  dropdown.selectByValue("92"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Predefined Query Rights button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Predefined_Query_Rights)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Check All\" button.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.chk_Dep_All)));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Uncheck All\" button.");
	  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.chk_Uncheck_Dep_All)));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Save\" button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Save)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User s87hould get error message like: \"Please select at least one module.\"");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_MR)).isDisplayed());  
  }
  
  @Test(priority=55, description="To verify that user is able to perform Invert functionality.")
  public void DSCL_Admin_UserManagement_55() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Assign Role Permission\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select particular Role from the Role list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
	  dropdown.selectByValue("92"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Predefined Query Rights button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Predefined_Query_Rights)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Check All\" button.");
	  driver.findElement(By.xpath(User_Management_R.chk_Dep_All)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on Invert button.");
	  driver.findElement(By.xpath(User_Management_R.btn_invert)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Save\" button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Save)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get success message for the modules are assigned to the role.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_MR)).isDisplayed());  
  }
  
  @Test(priority=56, description="To verify that user is able to perform Search functionality.")
  public void DSCL_Admin_UserManagement_56() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Assign Role Permission\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select particular Role from the Role list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
	  dropdown.selectByValue("92"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Predefined Query Rights button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Predefined_Query_Rights)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b>  Enter query name in search textbox.");
	  driver.findElement(By.xpath("//div[@class=\"tab-pane active\"]/div/input")).sendKeys("Atm");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get result of searched module in module list.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div[text()=\"atm\"]")).isDisplayed());   
  }
  
  @Test(priority=57, description="To verify that user is able to perform Cancel functionality.")
  public void DSCL_Admin_UserManagement_57() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Assign Role Permission\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select particular Role from the Role list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
	  dropdown.selectByValue("92"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Predefined Query Rights button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Predefined_Query_Rights)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select predefined query from the query list.");
	  driver.findElement(By.xpath(User_Management_R.chk_Pre_Query)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on Cancel button.");
	  driver.findElement(By.xpath("//button[text()=\"Cancel\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landing page of Role Permission without any selection of role and modules.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Roles\"]")).isDisplayed());  
  }
  
  @Test(priority=58, description="To verify that user is not able to assign any module and predefined query rights without selection of Role. ")
  public void DSCL_Admin_UserManagement_58() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Assign Role Permission\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Save\" button.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath(User_Management_R.btn_Save)));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get alert message for selection of role is required.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_SR)).isDisplayed());
  }
  
  @Test(priority=59, description="To verify that user is not able to assign 0any role permission with890out selection of modules and predefined query rights.")
  public void DSCL_Admin_UserManagement_59() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Assign Role Permission\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Assign_Role_Permission)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select particular Role from the Role list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
	  dropdown.selectByValue("92"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Predefined Query Rights button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Predefined_Query_Rights)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Check All\" button.");
	  driver.findElement(By.xpath(User_Management_R.chk_Dep_All)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Uncheck All\" button.");
	  driver.findElement(By.xpath(User_Management_R.chk_Uncheck_Dep_All)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Save\" button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Save)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get error message like: \"Please select at least one module.\"");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Validation_Message_MR)).isDisplayed());  
  }
  
  @Test(priority=60, description="To verify that user is able to perform Add Group functionality.")
  public void DSCL_Admin_UserManagement_60() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Add Groups\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Add_Group )).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b>  Enter valid Group name in Group Name textbox.");
	  driver.findElement(By.xpath(User_Management_R.txt_Add_Group )).sendKeys("Testing");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Add Group\" button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Add_group)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get success message for the added group.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Success_Message_AG )).isDisplayed());  
  }
  
  @Test(priority=61, description="To verify that user is able to perform Edit Group functionality.")
  public void DSCL_Admin_UserManagement_61() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Add Groups\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Add_Group )).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b>  Click on \"Edit\" button of the existing group.");
	  driver.findElement(By.xpath("//i[@id=\"btn_Testing\"]" )).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Save\" button.");
	  driver.findElement(By.xpath("//i[@id=\"btn_Testing\"]" )).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get success message for the added group.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.Success_Message_AG_edit )).isDisplayed());  
  }
  
  @Test(priority=62, description="To verify that user is able to perform Scroll up/down functionality for view all layer list.")
  public void DSCL_Admin_UserManagement_62() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Add Groups\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Add_Group )).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Scroll down/up of layer list for the show all available layers.");
	  WebElement element = driver.findElement(By.xpath("//span[text()=\"WIFI Access Point \"]"));
	  Actions actions = new Actions(driver);
	  actions.moveToElement(element);
	  actions.perform();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should see all the available layers in layer list.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"WIFI Access Point \"]")).isDisplayed()); 
  }
  
  @Test(priority=63, description="To verify that user is able to perform Scroll up/down functionality for view all layer list.")
  public void DSCL_Admin_UserManagement_63() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Add Groups\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Add_Group )).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Scroll down/up of group list for the 780show all available groups.");
	  WebElement element = driver.findElement(By.xpath("//strong[text()=\"abc\"]"));
	  Actions actions = new Actions(driver);
	  actions.moveToElement(element);
	  actions.perform();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should see all the available groups in group list.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//strong[text()=\"abc\"]")).isDisplayed()); 
  }
  
  @Test(priority=64, description="To verify that user is able to assign layers to the particular group.")
  public void DSCL_Admin_UserManagement_64() throws InterruptedException, AWTException {
	//  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
		  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
		  Thread.sleep(2000);
		//  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Add Groups\".");
		  driver.findElement(By.xpath(User_Management_R.btn_Add_Group )).click();
		//  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Drag particular layer from the layer list and drop into the particular group.");
		  WebElement From=driver.findElement(By.xpath("//span[@id=\"Layer_abd_connectivity_drain\"]/i"));		
	      WebElement To=driver.findElement(By.xpath("//th[@id=\"group_Testing\"]/ul"));	
	      JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("function createEvent(typeOfEvent) {\n" +"var event =document.createEvent(\"CustomEvent\");\n" +"event.initCustomEvent(typeOfEvent,true, true, null);\n" +"event.dataTransfer = {\n" +"data: {},\n" +"setData: function (key, value) {\n" +"this.data[key] = value;\n" +"},\n" +"getData: function (key) {\n" +"return this.data[key];\n" +"}\n" +"};\n" +"return event;\n" +"}\n" +"\n" +"function dispatchEvent(element, event,transferData) {\n" +"if (transferData !== undefined) {\n" +"event.dataTransfer = transferData;\n" +"}\n" +"if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" +"} else if (element.fireEvent) {\n" +"element.fireEvent(\"on\" + event.type, event);\n" +"}\n" +"}\n" +"\n" +"function simulateHTML5DragAndDrop(element, destination) {\n" +"var dragStartEvent =createEvent('dragstart');\n" +"dispatchEvent(element, dragStartEvent);\n" +"var dropEvent = createEvent('drop');\n" +"dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" +"var dragEndEvent = createEvent('dragend');\n" +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +"}\n" +"\n" +"var source = arguments[0];\n" +"var destination = arguments[1];\n" +"simulateHTML5DragAndDrop(source,destination);",From, To);
		  Thread.sleep(1500);
		//  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Drag particular layer from the layer list and drop into the particular group.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Layer is Added Into Group Successfully.\"]")).isDisplayed()); 
  }
  
  @Test(priority=65, description="To verify that user is able to \"Remove\" assigned layer from the group.")
  public void DSCL_Admin_UserManagement_65() throws InterruptedException {
	        //  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
			  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
			  Thread.sleep(2000);
			//  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Add Groups\".");
			  driver.findElement(By.xpath(User_Management_R.btn_Add_Group )).click();
			//  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Drag particular layer from the layer list and drop into the particular group.");
			  WebElement From=driver.findElement(By.xpath("//span[@id=\"Layer_abd_connectivity_drain\"]/i"));		
		      WebElement To=driver.findElement(By.xpath("//th[@id=\"group_Testing\"]/ul"));	
		      JavascriptExecutor js = (JavascriptExecutor) driver;
			  js.executeScript("function createEvent(typeOfEvent) {\n" +"var event =document.createEvent(\"CustomEvent\");\n" +"event.initCustomEvent(typeOfEvent,true, true, null);\n" +"event.dataTransfer = {\n" +"data: {},\n" +"setData: function (key, value) {\n" +"this.data[key] = value;\n" +"},\n" +"getData: function (key) {\n" +"return this.data[key];\n" +"}\n" +"};\n" +"return event;\n" +"}\n" +"\n" +"function dispatchEvent(element, event,transferData) {\n" +"if (transferData !== undefined) {\n" +"event.dataTransfer = transferData;\n" +"}\n" +"if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" +"} else if (element.fireEvent) {\n" +"element.fireEvent(\"on\" + event.type, event);\n" +"}\n" +"}\n" +"\n" +"function simulateHTML5DragAndDrop(element, destination) {\n" +"var dragStartEvent =createEvent('dragstart');\n" +"dispatchEvent(element, dragStartEvent);\n" +"var dropEvent = createEvent('drop');\n" +"dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" +"var dragEndEvent = createEvent('dragend');\n" +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +"}\n" +"\n" +"var source = arguments[0];\n" +"var destination = arguments[1];\n" +"simulateHTML5DragAndDrop(source,destination);",From, To);
			  Thread.sleep(1500);
			//  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Drag particular layer from the layer list and drop into the particular group.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Layer is Added Into Group Successfully.\"]")).isDisplayed());  
  }
  
  @Test(priority=66, description="Click on \"Delete\" button from the group.")
  public void DSCL_Admin_UserManagement_66() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Add Groups\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Add_Group )).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Delete\" button from the group.");
	  driver.findElement(By.xpath(User_Management_R.btn_Delete_group )).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(User_Management_R.btn_Yes_User_Delete )).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get success message for Group is deleted.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Group deleted successfully.\"]")).isDisplayed()); 
  }
  
  @Test(priority=67, description="To verify that user is not able to \"Add Group\" without group name.")
  public void DSCL_Admin_UserManagement_67() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Add Groups\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Add_Group )).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Add Group\" button.");
	  JavascriptExecutor executor = (JavascriptExecutor) driver;
	  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(User_Management_R.btn_Add_group)));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get error message for group name is required.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Please enter a name with at least 3 letters\"]")).isDisplayed()); 
  }
  
  @Test(priority=68, description="To verify that user is not able to \"Add Group\" without group name.")
  public void DSCL_Admin_UserManagement_68() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Add Groups\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Add_Group )).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Add Group\" button.");
	  driver.findElement(By.xpath(User_Management_R.btn_Add_group)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get error message for group name is required.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Please enter a name with at least 3 letters\"]")).isDisplayed()); 
  }
  
  @Test(priority=69, description="To verify that user is able to get \"Role Group Mapping\" page.")
  public void DSCL_Admin_UserManagement_69() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on \"Role Group Mapping\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Role_Group_Mapping )).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landing page of the Role Group Mapping.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(User_Management_R.label_Role_GM)).isDisplayed()); 
  }
  
  @Test(priority=70, description="To verify that user is able to assign/unassigned particular groups to the selected role.")
  public void DSCL_Admin_UserManagement_70() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on \"Role Group Mapping\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Role_Group_Mapping )).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select particular role from the role list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
	  dropdown.selectByValue("92"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Check on checkbox of the particular group from the group list.");
	  driver.findElement(By.xpath(User_Management_R.chk_Group_Water_Supply )).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get selected role with the assigned Groups.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Layer successfully added for this role.\"]")).isDisplayed());  
  }
  
  @Test(priority=71, description="To verify that user is able to assign particular layers from the group for the selected role.")
  public void DSCL_Admin_UserManagement_71() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on \"Role Group Mapping\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Role_Group_Mapping )).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select particular role from the role list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
	  dropdown.selectByValue("92"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Check on checkbox ahead of the layer list from the particular group.");
	  WebElement ele = driver.findElement(By.xpath("//li[@data-groupname=\"Water Supply\"]/span/strong"));
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();", ele);
	  Thread.sleep(2000);
	  WebElement ele1 =  driver.findElement(By.xpath("//input[@name=\"chkGroup_Water_Supply\"]"));
	  executor.executeScript("arguments[0].click();", ele1);
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get selected role with the assigned group with only selected layers.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Layer successfully added for this role.\"]")).isDisplayed());  
  }
  
  @Test(priority=72, description="To verify that user is able to assign/unassign \"Is Default\" functionality for the layer.")
  public void DSCL_Admin_UserManagement_72(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on \"Role Group Mapping\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Role_Group_Mapping )).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select particular role from the role list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
	  dropdown.selectByValue("92"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Is Default\" checkbox for the selected layer.");
	  WebElement ele = driver.findElement(By.xpath("//li[@data-groupname=\"Water Supply\"]/span/strong"));
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();", ele);
	  Thread.sleep(2000);
	  WebElement ele1 =  driver.findElement(By.xpath("//input[@name=\"chkGroup_Water_Supply\"]"));
	  executor.executeScript("arguments[0].click();", ele1);
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(User_Management_R.btn_Ok)).click();
	  WebElement ele2 =  driver.findElement(By.xpath("//input[@id=\"Default_chkGroup_Water_Supply_wtr_overhead_tank_poly\"]"));
	  executor.executeScript("arguments[0].click();", ele2);
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get selected layer as active on city GIS map after login with particular department.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Layer wtr overhead tank poly is default active  for this role.\"]")).isDisplayed());  
	  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  driver.findElement(By.xpath(User_Management_R.btn_Ok)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Again click on \"Is Default\" checkbox for selected layer.");
	  executor.executeScript("arguments[0].click();", ele2);
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get success message for Inactive \"Is Default\" functionality for selected layer.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Layer wtr overhead tank poly is default inactive for this role.\"]")).isDisplayed());  
  }
  
  @Test(priority=73, description="To verify that user is able to assign/unassign \"Is Right Click\" functionality for the layer.")
  public void DSCL_Admin_UserManagement_73(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on \"Role Group Mapping\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Role_Group_Mapping )).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select particular role from the role list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlrole\"]")));  
	  dropdown.selectByValue("92"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Is Right Click\" checkbox for the selected layer.");
	  WebElement ele2 = driver.findElement(By.xpath("//li[text()=\"Water Overhead Tank \"]/div/input[2]"));
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();", ele2);
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get selected layer as active on city GIS map after login with particular department.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Layer wtr overhead tank poly right click active for this role.\"]")).isDisplayed());
	  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  driver.findElement(By.xpath(User_Management_R.btn_Ok)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Again click on \"Is Right Click\" checkbox for selected layer.");
	  executor.executeScript("arguments[0].click();", ele2);
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get success message for Inactive \"Is Default\" functionality for selected layer.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Layer wtr overhead tank poly right click inactive for this role.\"]")).isDisplayed());  
  }
  
  @Test(priority=74, description="To verify that user is not able to assign any \"group\" and \"layers of the group\" without selection of Role.")
  public void DSCL_Admin_UserManagement_74(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  driver.findElement(By.xpath(User_Management_R.ddm_User_managment)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on \"Role Group Mapping\".");
	  driver.findElement(By.xpath(User_Management_R.btn_Role_Group_Mapping )).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Check on checkbox ahead of the layer list from the particular group.");
	  driver.findElement(By.xpath("//li[@data-groupname=\"Water Supply\"]/input")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get error message for role is not selected.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Please Select Role For Assign Groups\"]")).isDisplayed());
  }
  @AfterMethod
  public void afterClass() {
	driver.quit();
	  }
  }


