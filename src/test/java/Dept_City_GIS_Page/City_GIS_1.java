package Dept_City_GIS_Page;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Application_Pages_R.Home_Page_R;
import Application_Pages_R.Sign_In_Page_R;
import Dept_City_GIS_Page_R.CIty_GIS_1_R;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import Listener.ExtentTestManager;
import Listener.Extra_Screen;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;

public class City_GIS_1 {
	Home_Page_R obj = new Home_Page_R();
	Sign_In_Page_R obj2 = new Sign_In_Page_R();
	WebDriver driver;
	String Classname = "City_GIS_1_extras";
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
		  driver.findElement(By.xpath(Sign_In_Page_R.txt_Login_Name)).sendKeys("deptuser");
		  driver.findElement(By.xpath(Sign_In_Page_R.txt_Password)).sendKeys("Abc@1234");
		  driver.findElement(By.xpath(Sign_In_Page_R.btn_Sign_In)).click();
		 
	  }
 
  @Test(priority=1, description="To verify that user is able to search particular layer or attribute.")
  public void DSCL_Dept_CityGIS_01() throws InterruptedException {
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select Analytics option from the Top Panel.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Advance Search option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select layer from the layer list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("290"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Double click on specific Unique value.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Adance_Query)).sendKeys("\"ward_name\">= 'Aamwala Tarla'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Apply option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Apply)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the Search result and redirect to City GIS map with particular layer location.");
	  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@aria-labelledby=\"tabsearch\"]")).getCssValue("display")); 
  }
  
  @Test(priority=2, description="To verify that user is able to Unblink the search criteria.")
  public void DSCL_Dept_CityGIS_02() throws InterruptedException {
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select Analytics option from the Top Panel.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Advance Search option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select layer from the layer list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("290"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Double click on specific Unique value.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Adance_Query)).sendKeys("\"ward_name\">= 'Aamwala Tarla'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Apply option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Apply)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on the Unblink option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Unblink)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the Search result and redirect to City GIS map with particular layer location.");
	  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@aria-labelledby=\"tabsearch\"]")).getCssValue("display")); 
  }
  
  @Test(priority=3, description="To verify that user is able to move back on Advance search screen from the search result screen.")
  public void DSCL_Dept_CityGIS_03() throws InterruptedException {
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select Analytics option from the Top Panel.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Advance Search option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select layer from the layer list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("290"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Double click on specific Unique value.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Adance_Query)).sendKeys("\"ward_name\">= 'Aamwala Tarla'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Apply option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Apply)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on Back option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Back)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the Search result and redirect to City GIS map with particular layer location.");
	  Assert.assertEquals("block",driver.findElement(By.xpath("//div[@aria-labelledby=\"tabsearch\"]")).getCssValue("display")); 
  }
  
  @Test(priority=4, description="To verify that user is able to clear the query.")
  public void DSCL_Dept_CityGIS_04() throws InterruptedException {
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select Analytics option from the Top Panel.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Advance Search option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select layer from the layer list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("290"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Double click on specific Unique value.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Adance_Query)).sendKeys("\"ward_name\">= 'Aamwala Tarla'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Clear option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Clear)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the Search result and redirect to City GIS map with particular layer location.");
	  Assert.assertEquals("",driver.findElement(By.xpath(CIty_GIS_1_R.txt_Adance_Query)).getText()); 
  }
  
  @Test(priority=5, description="To verify that user is able to save the query.")
  public void DSCL_Dept_CityGIS_05() throws InterruptedException {
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select Analytics option from the Top Panel.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Advance Search option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select layer from the layer list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("290"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Double click on specific Unique value.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Adance_Query)).sendKeys("\"ward_name\">= 'Aamwala Tarla'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Save option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Save)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter the name in Name field of the save search pop-up.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Name)).sendKeys("Testing");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Enter the Description in Description field of the save search pop-up.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Description)).sendKeys("This is automation testing.");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Check on \"Save as Predefined Query\" checkbox.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.chk_qbispredefined)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on Save option of the Save Search pop-up..");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Save_Query)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get successful message for save record.");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//p[text()=\"Query Saved Successfully\"]")).isDisplayed()); 
  }
  
  @Test(priority=6, description="To verify that user is able to verify the query.")
  public void DSCL_Dept_CityGIS_06() throws InterruptedException {
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select Analytics option from the Top Panel.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Advance Search option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select layer from the layer list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("290"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Double click on specific Unique value.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Adance_Query)).sendKeys("\"ward_name\">= 'Aamwala Tarla'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Verify option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Verify)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get successful message for verified query.");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//p[text()=\"Query verified successfully\"]")).isDisplayed()); 
  }
  
  @Test(priority=7, description="To verify that user is able to load existing query.")
  public void DSCL_Dept_CityGIS_07() throws InterruptedException {
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select Analytics option from the Top Panel.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Advance Search option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Load Query option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Load_Query)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select the existing query from the list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlLoadQuery\"]")));  
	  dropdown.selectByValue("60"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Load option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Load)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the existing query.");
	  Assert.assertEquals("",driver.findElement(By.xpath(CIty_GIS_1_R.txt_Adance_Query)).getText()); 
  }
  
  @Test(priority=8, description="To verify user can get \"Load Query\" window popup.")
  public void DSCL_Dept_CityGIS_08() throws InterruptedException {
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select Analytics option from the Top Panel.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Advance Search option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Load Query option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Load_Query)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get \"Load Query\" window popup.");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//span[text()=\"Load  Query\"]")).isDisplayed()); 
  }
  
  @Test(priority=9, description="To verify that user is able to collapse/expand \"Load Query\" window popup.")
  public void DSCL_Dept_CityGIS_09(Method method) throws InterruptedException {
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select Analytics option from the Top Panel.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Advance Search option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Load Query option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Load_Query)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Collapse\" icon button from the load query window popup.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Collapse_LQ)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Load Query\" window popup should be collapse.");
	  Assert.assertEquals(true,driver.findElement(By.xpath(CIty_GIS_1_R.btn_Expand_LQ)).isDisplayed());
	  objs.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Expand\" icon button from the load query window popup.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Expand_LQ)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Load Query\" window popup should be expand..");
	  Assert.assertEquals(true,driver.findElement(By.xpath(CIty_GIS_1_R.btn_Collapse_LQ)).isDisplayed());
  }
  
  @Test(priority=10, description="To verify that user is able to \"Close\" load query window popup.")
  public void DSCL_Dept_CityGIS_10() throws InterruptedException {
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select Analytics option from the Top Panel.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Advance Search option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Load Query option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Load_Query)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Close\" icon button from the load query window popup.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Close_LQ)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1. \"Load Query\" window popup should be closed.\r\n"
	  		+ "2. User should be able to perform \"Advance Search\" functionality.");
	  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@aria-describedby=\"modalLoadQuery\"]")).getCssValue("display"));
  }
  
  @Test(priority=11, description="To verify that user is not able to Load particular query without selection of query.")
  public void DSCL_Dept_CityGIS_11() throws InterruptedException {
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select Analytics option from the Top Panel.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Advance Search option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Load Query option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Load_Query)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Load\" button.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Load)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get error message like: \"Please Select Query.\"");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//p[text()=\"Please Select Query.\"]")).isDisplayed()); 
  }
  
  @Test(priority=12, description="To verify that user is able to apply Spatial Filter for Layer.")
  public void DSCL_Dept_CityGIS_12() throws InterruptedException {
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select Analytics option from the Top Panel.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Advance Search option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select layer from the layer list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("290"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Double click on specific Unique value.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Adance_Query)).sendKeys("\"ward_name\">= 'Aamwala Tarla'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Spatial Filter option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Spatial_Filter)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select Layer B from the layer list.");
	  Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id=\"ddladvancedfilterlayers\"]")));  
	  dropdown1.selectByValue("42"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select Field from the field list.");
	  Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@id=\"ddladvancedfilterfields\"]")));  
	  dropdown2.selectByValue("road_name"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Select the Value from the list.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Values)).sendKeys("1 Lane");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Values)).sendKeys(Keys.ENTER);
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Enter the Buffer for layer B.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Buffer)).sendKeys("1000");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> 17. Click on Ok option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Ok)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Click on Apply option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Apply)).click();
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the filtered result on result tab and user also redirect on specific location on city GIS map.");
	  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@aria-labelledby=\"tabsearch\"]")).getCssValue("display")); 
  }
  
  @Test(priority=13, description="To verify that user is able to Reset Spatial Filter for Layer.")
  public void DSCL_Dept_CityGIS_13() throws InterruptedException {
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select Analytics option from the Top Panel.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Advance Search option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select layer from the layer list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("290"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Double click on specific Unique value.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Adance_Query)).sendKeys("\"ward_name\">= 'Aamwala Tarla'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Spatial Filter option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Spatial_Filter)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select Layer B from the layer list.");
	  Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id=\"ddladvancedfilterlayers\"]")));  
	  dropdown1.selectByValue("42"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select Field from the field list.");
	  Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@id=\"ddladvancedfilterfields\"]")));  
	  dropdown2.selectByValue("road_name"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Select the Value from the list.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Values)).sendKeys("1 Lane");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Values)).sendKeys(Keys.ENTER);
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Enter the Buffer for layer B.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Buffer)).sendKeys("1000");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on Reset button.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Reset)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the filtered result on result tab and user also redirect on specific location on city GIS map.");
	  Assert.assertEquals("",driver.findElement(By.xpath(CIty_GIS_1_R.txt_Buffer)).getText()); 
  }
  
  @Test(priority=14, description="To verify that user is able to apply spatial filter using Map Extent.")
  public void DSCL_Dept_CityGIS_14() throws InterruptedException {
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select Analytics option from the Top Panel.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Advance Search option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select layer from the layer list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("290"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Double click on specific Unique value.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Adance_Query)).sendKeys("\"ward_name\">= 'Aamwala Tarla'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Spatial Filter option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Spatial_Filter)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select Map Extent tab.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Map_Extent)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Enter Upper Left value for X.");
	  driver.findElement(By.xpath("//input[@id=\"txtupperX\"]")).sendKeys("77.98");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Enter Upper Left value for Y.");
	  driver.findElement(By.xpath("//input[@id=\"txtupperY\"]")).sendKeys("30.34");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Enter Lower Right value for X.");
	  driver.findElement(By.xpath("//input[@id=\"txtlowerX\"]")).sendKeys("78.04");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Enter Lower Right value for Y.");
	  driver.findElement(By.xpath("//input[@id=\"txtlowerY\"]")).sendKeys("30.3");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> 17. Click on Ok option.");
	  driver.findElement(By.xpath("//div[@aria-hidden=\"false\"]//button[text()=\"Ok\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14:</b> Click on Apply option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Apply)).click();
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the filtered result on result tab and user also redirect on specific location on city GIS map.");
	  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@aria-labelledby=\"tabsearch\"]")).getCssValue("display"));
  }
  
  @Test(priority=15, description="To verify that user is able to set spatial filter using selection area from the City GIS map.")
  public void DSCL_Dept_CityGIS_15() throws InterruptedException, AWTException {
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select Analytics option from the Top Panel.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Advance Search option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select layer from the layer list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("290"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Double click on specific Unique value.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Adance_Query)).sendKeys("\"ward_name\">= 'Aamwala Tarla'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Spatial Filter option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Spatial_Filter)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select Map Extent tab.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Map_Extent)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select from Map option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Select_From_Map)).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//div[@aria-describedby=\"modalAdvanceSearch\"]//button[text()=\"collapse\"]")).click();
	  driver.findElement(By.xpath("//div[@aria-describedby=\"modalSpatialFilter\"]//button[text()=\"collapse\"]")).click();
	  Thread.sleep(2000);
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  robot.mouseMove(1000,700);
	  robot.delay(1500);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> 17. Click on Ok option.");
	  driver.findElement(By.xpath("//div[@aria-describedby=\"modalAdvanceSearch\"]//button[text()=\"restore\"]")).click();
	  driver.findElement(By.xpath("//div[@aria-describedby=\"modalSpatialFilter\"]//button[text()=\"restore\"]")).click();
	  Thread.sleep(10000);
	  driver.findElement(By.xpath("//div[@aria-hidden=\"false\"]//button[text()=\"Ok\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14:</b> Click on Apply option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Apply)).click();
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the filtered result on result tab and user also redirect on specific location on city GIS map.");
	  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@aria-labelledby=\"tabsearch\"]")).getCssValue("display"));
  }
  
  @Test(priority=16, description="To verify that user is able to collapse/expand Spatial Filter.")
  public void DSCL_Dept_CityGIS_16() throws InterruptedException, AWTException {
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select Analytics option from the Top Panel.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Advance Search option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select layer from the layer list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("290"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Double click on specific Unique value.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Adance_Query)).sendKeys("\"ward_name\">= 'Aamwala Tarla'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Spatial Filter option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Spatial_Filter)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on Collapse button.");
	  driver.findElement(By.xpath("//div[@aria-describedby=\"modalSpatialFilter\"]//button[text()=\"collapse\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the Spatial Filter pop-up in collapse mode.");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//div[@aria-describedby=\"modalSpatialFilter\"]//button[text()=\"restore\"]")).isDisplayed());
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Expand button.");
	  driver.findElement(By.xpath("//div[@aria-describedby=\"modalSpatialFilter\"]//button[text()=\"restore\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the Spatial Filter pop-up in expanded mode.");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//div[@aria-describedby=\"modalSpatialFilter\"]//button[text()=\"collapse\"]")).isDisplayed());
  }
  
  @Test(priority=17, description="To verify that user is able to close Spatial Filter.")
  public void DSCL_Dept_CityGIS_17() throws InterruptedException, AWTException {
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select Analytics option from the Top Panel.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Advance Search option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select layer from the layer list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("290"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Double click on specific Unique value.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Adance_Query)).sendKeys("\"ward_name\">= 'Aamwala Tarla'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Spatial Filter option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Spatial_Filter)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on Close(X) icon.");
	  driver.findElement(By.xpath("//div[@aria-describedby=\"modalSpatialFilter\"]//button[text()=\"Close\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the Advance Search pop-up.");
	  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@aria-describedby=\"modalSpatialFilter\"]")).getCssValue("display"));
  }
  
  @Test(priority=18, description="To verify that user can get validation message if user not select 'Layer B' from drop down and click on 'OK' button on 'Spatial filter' popup.")
  public void DSCL_Dept_CityGIS_18() throws InterruptedException, AWTException {
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select Analytics option from the Top Panel.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Advance Search option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select layer from the layer list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("290"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Double click on specific Unique value.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Adance_Query)).sendKeys("\"ward_name\">= 'Aamwala Tarla'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Spatial Filter option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Spatial_Filter)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on Ok option.");
	  driver.findElement(By.xpath("//div[@aria-hidden=\"false\"]//button[text()=\"Ok\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message for Layer B like: \"Please select layer B\".");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//p[text()=\"Please select layer B\"]")).isDisplayed()); 
  }
  
  @Test(priority=19, description="To verify that user is not able to apply spatial filter without selecting field.")
  public void DSCL_Dept_CityGIS_19() throws InterruptedException, AWTException {
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select Analytics option from the Top Panel.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Advance Search option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select layer from the layer list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("290"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Double click on specific Unique value.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Adance_Query)).sendKeys("\"ward_name\">= 'Aamwala Tarla'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Spatial Filter option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Spatial_Filter)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select Layer B from the layer list.");
	  Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id=\"ddladvancedfilterlayers\"]")));  
	  dropdown1.selectByValue("42"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Ok option.");
	  driver.findElement(By.xpath("//div[@aria-hidden=\"false\"]//button[text()=\"Ok\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message for Fields like: \"Please select advanced filter field\".");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//p[text()=\"Please select advanced filter field\"]")).isDisplayed()); 
  }
  
  @Test(priority=20, description="To verify that user is not able to apply spatial filter without entering Value.")
  public void DSCL_Dept_CityGIS_20() throws InterruptedException, AWTException {
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select Analytics option from the Top Panel.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Advance Search option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select layer from the layer list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("290"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Double click on specific Unique value.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Adance_Query)).sendKeys("\"ward_name\">= 'Aamwala Tarla'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Spatial Filter option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Spatial_Filter)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select Layer B from the layer list.");
	  Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id=\"ddladvancedfilterlayers\"]")));  
	  dropdown1.selectByValue("42"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select Field from the field list.");
	  Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@id=\"ddladvancedfilterfields\"]")));  
	  dropdown2.selectByValue("road_name"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on Ok option.");
	  driver.findElement(By.xpath("//div[@aria-hidden=\"false\"]//button[text()=\"Ok\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message for Value like: \"Please select advanced filter value\".");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//p[text()=\"Please select advanced filter value\"]")).isDisplayed()); 
  }
  
  @Test(priority=21, description="To verify that user is not able to apply spatial filter without entering Buffer.")
  public void DSCL_Dept_CityGIS_21() throws InterruptedException, AWTException {
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select Analytics option from the Top Panel.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Advance Search option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select layer from the layer list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("290"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Double click on specific Unique value.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Adance_Query)).sendKeys("\"ward_name\">= 'Aamwala Tarla'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Spatial Filter option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Spatial_Filter)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select Layer B from the layer list.");
	  Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id=\"ddladvancedfilterlayers\"]")));  
	  dropdown1.selectByValue("42"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select Field from the field list.");
	  Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@id=\"ddladvancedfilterfields\"]")));  
	  dropdown2.selectByValue("road_name"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Select the Value from the list.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Values)).sendKeys("1 Lane");
	  driver.findElement(By.xpath(CIty_GIS_1_R.txt_Values)).sendKeys(Keys.ENTER);
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on Ok option.");
	  driver.findElement(By.xpath("//div[@aria-hidden=\"false\"]//button[text()=\"Ok\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message for Buffer Value like: \"Enter Buffer Value\".");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//p[text()=\"Enter Buffer Value\"]")).isDisplayed()); 
  }
  
  @Test(priority=22, description="To verify that user is able to get Bookmark Queries data.")
  public void DSCL_Dept_CityGIS_22() throws InterruptedException, AWTException {
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select Analytics option from the Top Panel.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Bookmark Queries option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Bookmark_Queries)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get \"Bookmarked Queries\" result panel at bottom.");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//h3[text()=\"Bookmarked Queries\"]")).isDisplayed()); 
  }
  
  @Test(priority=23, description="To verify that user is able to get Predefined Queries.")
  public void DSCL_Dept_CityGIS_23() throws InterruptedException, AWTException {
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select Analytics option from the Top Panel.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Predefined Queries option.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Predefined_Queries)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on View option.");
	  driver.findElement(By.xpath("//tr[1]//a[text()=\"View\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Apply option of the Advance Search screen.");
	  driver.findElement(By.xpath(CIty_GIS_1_R.btn_Apply)).click();
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the search result.");
	  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@aria-labelledby=\"tabsearch\"]")).getCssValue("display")); 
  }
  @AfterMethod
  public void afterClass() {
	driver.quit();
	  }
  }

