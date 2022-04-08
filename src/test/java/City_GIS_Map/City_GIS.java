package City_GIS_Map;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import Admin_R.User_Management_R;
import Application_Pages_R.Home_Page_R;
import City_GIS_Map_R.City_GIS_R;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import Listener.ExtentTestManager;
import Listener.Extra_Screen;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;

public class City_GIS {
	Home_Page_R obj = new Home_Page_R();
	City_GIS_R obj2 = new City_GIS_R();
	WebDriver driver;
	String Classname = "City_GIS_extras";
	Extra_Screen objs = new Extra_Screen();
	
	@BeforeMethod
	  public void openBrowser(ITestContext context) {
		  WebDriverManager.chromedriver().setup();
		  ChromeOptions options = new ChromeOptions();
	        Map<String, Object> prefs = new HashMap<String, Object>();
	        prefs.put("profile.default_content_setting_values.geolocation", 2);
	        options.setExperimentalOption("prefs", prefs);
		  driver = new ChromeDriver(options);
		  context.setAttribute("WebDriver", driver);
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.manage().getCookies();
		  driver.get(Home_Page_R.URL);
	  }
 
  @Test(priority=1, description="To verify that user is able to redirect on City GIS page.")
  public void SGL_Ranchi_CITYGIS_1() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landing page of the City GIS Portal.");
	  Assert.assertEquals("Ranchi GIS Portal", driver.getTitle());
  }
  
  @Test(priority=2, description="To verify that user is able to redirect on \"Home\" Page of the \"Ranchi\" application while clicking on \"Ranchi\" logo.")
  public void SGL_Ranchi_CITYGIS_02() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Ranchi\" logo from the \"CITY GIS\" page.");
	  driver.findElement(By.xpath(City_GIS_R.lnk_Logo)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get \"Home\" page of the \"Ranchi\" application.");
	  Assert.assertEquals("Ranchi Smart City Portal", driver.getTitle());
  }
  
  @Test(priority=3, description="To verify that user is able to change language of \"CITY GIS\" page.")
  public void SGL_Ranchi_CITYGIS_03(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Profile icon button from the City GIS page.");
	  driver.findElement(By.xpath(City_GIS_R.btn_User_Profile)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on link of 'Hindi' language option from the list.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Hindi_Lan)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get City GIS page in Hindi language.");
	  Assert.assertEquals("रांची जीआईएस पोर्टल", driver.getTitle());
	  objs.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on Profile icon button from the City GIS page.");
	  driver.findElement(By.xpath(City_GIS_R.btn_User_Profile)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on link of 'English' language option from the list.");
	  driver.findElement(By.xpath(City_GIS_R.btn_English_Lan)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get City GIS page in Hindi language.");
	  Assert.assertEquals("Ranchi GIS Portal", driver.getTitle());
  }
  
  @Test(priority=4, description="To verify that user is able to perform collapse/expand functionality of \"Layers\" panel.")
  public void SGL_Ranchi_CITYGIS_04(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Layer icon.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Layers)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get Layer panel in Collapse/Expand mode.");
	  System.out.println(driver.findElement(By.xpath(City_GIS_R.Layer_Panel)).getAttribute("class"));
	  Assert.assertEquals("layers col-sm-2 modalinactive collapse-left", driver.findElement(By.xpath(City_GIS_R.Layer_Panel)).getAttribute("class"));
	  objs.Screenshot(driver, Classname ,method.getName()+"_01" );
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b>  Click on Layer icon.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Layers)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get Layer panel in Collapse/Expand mode.");
	  Assert.assertEquals("layers col-sm-2 modalactive expand-right", driver.findElement(By.xpath(City_GIS_R.Layer_Panel)).getAttribute("class"));
  }
  
  @Test(priority=5, description="To verify that user is able to \"Search\" particular layer from the list of layers.")
  public void SGL_Ranchi_CITYGIS_05() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter layer name into Search Layer textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Search_Layer)).sendKeys("Ward Boundary");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get searched layer in layer panel list.");
	  Assert.assertEquals(false, driver.findElement(By.xpath(City_GIS_R.Layer_Ranchi_Basemap)).isDisplayed());
  }
  
  @Test(priority=6, description="To verify that user is able to perform \"All Layers Off\" functionality .")
  public void SGL_Ranchi_CITYGIS_06() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b>  Click on \"All Layers Off\" link from the layer panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_ALl_Layer_Off)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b>  All the layers should be de-selected in layer panel.");
	  List<WebElement> element1 = driver.findElements(By.xpath("//input[@type=\"checkbox\" ]"));
	  System.out.println(element1.size());
	  for(int i =0; i<element1.size(); i++) {
		  Assert.assertEquals(false, element1.get(i).isSelected() );
	  } 
  }
  
  @Test(priority=7, description="To verify that user is able to get \"Legend\" for the selected layers.")
  public void SGL_Ranchi_CITYGIS_07() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Legend\" link from the layer panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Legend)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get \"Legend\" dialog of selected layers.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.label_Legend_pop)).isDisplayed());
  }
  
  @Test(priority=8, description="To verify that user is able perform expand/collapse functionality for \"Legend\" dialog.")
  public void SGL_Ranchi_CITYGIS_08(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Legend\" link from the layer panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Legend)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on expand/collapse button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Legend_Expand)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Legend\" dialog should collapse/expand as per selection.");
	  Assert.assertEquals("none", driver.findElement(By.xpath("//div[@class=\"x-window-bwrap\"]")).getCssValue("display"));
	  objs.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on expand/collapse button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Legend_Expand)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Legend\" dialog should collapse/expand as per selection.");
	  Assert.assertEquals("block", driver.findElement(By.xpath("//div[@class=\"x-window-bwrap\"]")).getCssValue("display"));
  }
  
  @Test(priority=9, description="To verify that user is able perform close functionality for \"Legend\" dialog.")
  public void SGL_Ranchi_CITYGIS_09( ) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Legend\" link from the layer panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Legend)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on close button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Legend_Close)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Legend\" dialog should be close.");
	  Assert.assertEquals(false, driver.findElement(By.xpath(City_GIS_R.label_Legend_pop)).isDisplayed());
  }
  
  @Test(priority=10, description="To verify that user is able to perform \"Reset\" functionality.")
  public void SGL_Ranchi_CITYGIS_10( ) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b>  Click on \"All Layers Off\" link from the layer panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_ALl_Layer_Off)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Reset\" Link from the layer panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Reset)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) User should get all the \"Default Layers\" selected in layer panel.\r\n"
	 		+ "2) User should get all the \"Default Layers\" on Map.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(" //ul/div/li[1]/ul/li[1]/div/input")).isSelected());
  }
  
  @Test(priority=11, description="To verify that user is able to perform expand/collapse functionality of particular layer group.")
  public void SGL_Ranchi_CITYGIS_11(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  List<WebElement> element1 = driver.findElements(By.xpath("//div[@class=\"x-tree-node-el x-unselectable x-tree-node-collapsed\"]"));
	  System.out.println(element1.size());
	  for(int i =0; i<element1.size(); i++) {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on icon (\"+\") of the expand/collapse of particular layer group from the layer panel.");
		  element1.get(i).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get list of sub-layers in expanded/collapse mode.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"x-tree-node-el x-unselectable x-tree-node-expanded\"]")).isDisplayed() );
		  objs.Screenshot(driver, Classname ,method.getName()+"_"+i );
		  Thread.sleep(1000);
	  } 
  }
  
  @Test(priority=12, description="To verify that user is able to perform expand/collapse functionality of particular layer group.")
  public void SGL_Ranchi_CITYGIS_12(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  List<WebElement> element1 = driver.findElements(By.xpath("//div[@class=\"x-tree-node-el x-unselectable x-tree-node-collapsed\"]"));
	  System.out.println(element1.size());
	  for(int i =0; i<element1.size(); i++) {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on icon (\">\") of the expand/collapse of particular layer group from the layer panel.");
		  element1.get(i).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get list of sub-layers in expanded/collapse mode.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"x-tree-node-el x-unselectable x-tree-node-expanded\"]")).isDisplayed() );
		  objs.Screenshot(driver, Classname ,method.getName()+"_"+i );
		  Thread.sleep(1000);
	  } 
  }
  
  @Test(priority=13, description="To verify that user is able to \"Select All\" sub layers for particular layer group.")
  public void SGL_Ranchi_CITYGIS_13(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  List<WebElement> element2 = driver.findElements(By.xpath("//div[@class=\"x-tree-node-el x-unselectable x-tree-node-collapsed\"]"));
	  System.out.println(element2.size());
	  for(int i =0; i<element2.size(); i++) {
		  element2.get(i).click();
		  Thread.sleep(1000);
	  } 
	  List<WebElement> element1 = driver.findElements(By.xpath("//div/li/div/input"));
	  System.out.println(element1.size());
	  for(int j =0; j<element1.size()-1; j++) {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4."+j+":</b> Click on check-box which is ahead of particular layer group.");
		  element1.get(j).click();
		  List<WebElement> element = driver.findElements(By.xpath("//div/li[2]/ul/li/div[1]/input[@checked]"));
		  System.out.println(element.size());
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) User should get all the sub layers selected of particular layer group in layer panel.\r\n"
			  		+ "2)All sub-layers should display on map.");
		  for(int i =0; i<element.size(); i++) {
			
			  Assert.assertEquals(true, element.get(i).isDisplayed() );
		  }	 
		  objs.Screenshot(driver, Classname ,method.getName()+"_"+j );
		  element1.get(j).click();
		  Thread.sleep(1000); 
	  }  
  }
  
  @Test(priority=14, description="To verify that user is able to \"Deselect All\" sub layers for particular layer group..")
  public void SGL_Ranchi_CITYGIS_14(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  List<WebElement> element2 = driver.findElements(By.xpath("//div[@class=\"x-tree-node-el x-unselectable x-tree-node-collapsed\"]"));
	  System.out.println(element2.size());
	  for(int i =0; i<element2.size(); i++) {
		  element2.get(i).click();
		  Thread.sleep(1000);
	  } 
	  List<WebElement> element1 = driver.findElements(By.xpath("//div/li/div/input"));
	  System.out.println(element1.size());
	  for(int j =0; j<element1.size()-1; j++) {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4."+j+":</b> Click on check-box which is ahead of particular layer group.");
		  element1.get(j).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5."+j+":</b> Again click on Check-box which is ahead of layer.");
		  element1.get(j).click();
		  List<WebElement> element = driver.findElements(By.xpath("//div/li[2]/ul/li/div[1]/input[@checked]"));
		  System.out.println(element.size());
		  for(int i =0; i<element.size(); i++) {
			  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) User should get all the sub layers selected of particular layer group in layer panel.\r\n"
			  		+ "2)All sub-layers should display on map.");
			  Assert.assertEquals(true, element.get(i).isDisplayed() );
		  }	 
		  objs.Screenshot(driver, Classname ,method.getName()+"_"+j );
		  Thread.sleep(1000); 
	  }  
  }
  
  @Test(priority=15, description="To verify that user is able to \"Select\" particular sub-layer for particular layer group.")
  public void SGL_Ranchi_CITYGIS_15(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on icon (\"+\") of the expand/collapse of particular layer group from the layer panel.");
	  List<WebElement> element1 = driver.findElements(By.xpath("//div[@class=\"x-tree-node-el x-unselectable x-tree-node-collapsed\"]"));
	  System.out.println(element1.size());
	  for(int i =0; i<element1.size(); i++) {
		  element1.get(i).click();
		  Thread.sleep(1000);
	  } 
	  List<WebElement> element = driver.findElements(By.xpath("//div/li/ul/li/div/input"));
	  System.out.println(element.size());
	  for(int i =0; i<element.size(); i++) {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5"+i+":</b> Select particular layer from the sub-layer list.");
		  element.get(i).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Layer data should be display on the map.");
		  Assert.assertEquals(true, element.get(i).isDisplayed() );
		  objs.Screenshot(driver, Classname ,method.getName()+"_"+i );
		  Thread.sleep(1000);
		  element.get(i).click();
	  }
  }
  
  @Test(priority=16, description="To verify that user is able to \"Deselect\" particular sub-layer for particular layer group.")
  public void SGL_Ranchi_CITYGIS_16(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on icon (\"+\") of the expand/collapse of particular layer group from the layer panel.");
	  List<WebElement> element1 = driver.findElements(By.xpath("//div[@class=\"x-tree-node-el x-unselectable x-tree-node-collapsed\"]"));
	  System.out.println(element1.size());
	  for(int i =0; i<element1.size(); i++) {
		  element1.get(i).click();
		  Thread.sleep(1000);
	  } 
	  List<WebElement> element = driver.findElements(By.xpath("//div/li/ul/li/div/input"));
	  System.out.println(element.size());
	  for(int i =0; i<element.size(); i++) {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5."+i+":</b> Select particular layer from the sub-layer list.");
		  element.get(i).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6."+i+":</b> Deselect same layer from the particular layer group..");
		  element.get(i).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Layer data should be display on the map.");
		  Assert.assertEquals(true, element.get(i).isDisplayed() );
		  objs.Screenshot(driver, Classname ,method.getName()+"_"+i );
		  Thread.sleep(1000);
	  }
  }
  
  @Test(priority=17, description="To verify that user is able to Get Layer Information pop-up.")
  public void SGL_Ranchi_CITYGIS_17(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select and right click on the mouse for the particular sub-layer. ");
	  Actions action = new Actions(driver);
	  WebElement link =driver.findElement(By.xpath(City_GIS_R.Layer_Ranchi_Basemap)); 
	  action.contextClick(link).perform();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on 'Get layer Information' functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Get_Layer_information)).click();
	  Thread.sleep(2000);
  	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on City GIS map without information pop-up of the layer. ");
   	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.label_information_window)).isDisplayed() );	
      objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on 'OK' button of information pop up.");
      driver.findElement(By.xpath(City_GIS_R.btn_ok_information)).click();
	  Thread.sleep(2000);
  }
  
  @Test(priority=18, description="To verify that user is able to close \"Get Layer Information\" pop-up.")
  public void SGL_Ranchi_CITYGIS_18(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select and right click on the mouse for the particular sub-layer. ");
	  Actions action = new Actions(driver);
	  WebElement link =driver.findElement(By.xpath(City_GIS_R.Layer_Ranchi_Basemap)); 
	  action.contextClick(link).perform();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on 'Get layer Information' functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Get_Layer_information)).click();
	  Thread.sleep(2000);	 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on City GIS map without information pop-up of the layer. ");
   	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.label_information_window)).isDisplayed() );	
      objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on Close icon from the layer Information pop-up.");
      driver.findElement(By.xpath(City_GIS_R.btn_close_information)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Layer information pop-up should close. ");
  }
  
  @Test(priority=19, description="To verify that user is able to perform 'Zoom To Extent' functionality.")
  public void SGL_Ranchi_CITYGIS_19() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select and right click on the mouse for the particular sub-layer. ");
	  Actions action = new Actions(driver);
	  WebElement link =driver.findElement(By.xpath("//span[text()='RRDA Boundary']")); 
	  action.contextClick(link).perform();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Zoom to Layer Extent option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_Layer_Extent)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get all layer data on map with specific zoom level.");
  }
  
  @Test(priority=20, description="To verify that user is able to perform \"Change Layer Opacity\" functionality.")
  public void SGL_Ranchi_CITYGIS_20() throws InterruptedException {
	//  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	//  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	//  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	//  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select and right click on the mouse for the particular sub-layer. ");
	  Actions action = new Actions(driver);
	  WebElement link =driver.findElement(By.xpath(City_GIS_R.Layer_Ranchi_Basemap)); 
	  action.contextClick(link).perform();
	  Thread.sleep(4000);
	//  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Change Layer opacity option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Change_Layer_opacity)).click();
	 // ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Drag opacity option to change opacity of the layer.");
	  WebElement grayScale =driver.findElement(By.xpath(City_GIS_R.btn_drag_Change_opacity));
	  action.dragAndDropBy(grayScale, -50, 0);
	  String x = driver.findElement(By.xpath(City_GIS_R.layer_opacity)).getAttribute("style");
	  System.out.println(x);
	  Thread.sleep(2000);
	  action.dragAndDropBy(grayScale, 25, 0);
	  String y = driver.findElement(By.xpath(City_GIS_R.layer_opacity)).getAttribute("style");
	  System.out.println(y);
	//  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the layer with the specified opacity on City GIS map.");
	  //Assert.assertNotEquals(x, y);
  }
  
  @Test(priority=21, description="To verify that user is able to close pop-up of the \"Change Layer Opacity\" functionality.")
  public void SGL_Ranchi_CITYGIS_21() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select and right click on the mouse for the particular sub-layer. ");
	  Actions action = new Actions(driver);
	  WebElement link =driver.findElement(By.xpath(City_GIS_R.Layer_Ranchi_Basemap)); 
	  action.contextClick(link).perform();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Change Layer opacity option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Change_Layer_opacity)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Close icon from the pop-up of the change opacity.");
	  driver.findElement(By.xpath(City_GIS_R.btn_close)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get City GIS map without pop-up of the change opacity.");
	  Assert.assertEquals(false, driver.findElement(By.xpath("//span[text()=\"Opacity\"]")).isDisplayed() );
  }
  
  
  @Test(priority=22, description="To verify that user is able to redirect on specified location using saved Bookmarks.")
  public void SGL_Ranchi_CITYGIS_22() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Go to particular location using Zoom-in facility.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  Thread.sleep(4000);
	  String a1 = driver.findElement(By.xpath("//div[@class=\"olControlOverviewMapExtentRectangle\"]")).getAttribute("style");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Tools\" icon from top panel. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Bookmarks\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Bookmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter the bookmark name in \"Name\" textbox. ");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_name)).sendKeys("Testing");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter the bookmark description in \"Description\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_Des)).sendKeys("Test for automation.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Add button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Add)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Zoom out");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_out)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on specific Bookmarks.");
	  driver.findElement(By.xpath("//a[text()=\"Testing\"]")).click();
	  String a2 = driver.findElement(By.xpath("//div[@class=\"olControlOverviewMapExtentRectangle\"]")).getAttribute("style");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get specific location on map which is mentioned in saved \"Bookmarks\" .");
	  Assert.assertEquals(a1,a2);
  }
  
  @Test(priority=23, description="To verify that user is able to remove saved \"Bookmarks\".")
  public void SGL_Ranchi_CITYGIS_23() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Go to particular location using Zoom-in facility.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Tools\" icon from top panel. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Bookmarks\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Bookmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter the bookmark name in \"Name\" textbox. ");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_name)).sendKeys("Testing");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter the bookmark description in \"Description\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_Des)).sendKeys("Test for automation.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Add button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Add)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on Remove option from the bookmark list.");
	  driver.findElement(By.xpath(City_GIS_R.Remove_Bookmark)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Saved bookmark should removed from the \"Bookmark\" list.");
	  Assert.assertEquals("display: none;",driver.findElement(By.xpath("//div[@id=\"hr-bookmarks\"]")).getAttribute("style"));
  }
  
  @Test(priority=24, description="To verify that user is able to perform \"Send Email\" functionality from added bookmark in layer panel.")
  public void SGL_Ranchi_CITYGIS_24() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Go to particular location using Zoom-in facility.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Tools\" icon from top panel. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Bookmarks\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Bookmarks)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter the bookmark name in \"Name\" textbox. ");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_name)).sendKeys("Testing");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter the bookmark description in \"Description\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_Des)).sendKeys("Test for automation.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Add button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Add)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Send Email\" link from the bookmark list.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Send_Email)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Enter email id in \"Sent TO\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Email_id)).sendKeys("testing@sgligis.com");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Enter description in \"Body\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Email_Body)).sendKeys("Test for automation.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Click on \"Sent Email\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Send_Email_Pop)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the success message as\r\n"
	  		+ "\"Mail sent successfully to:\"");
	  Assert.assertEquals("Sending failed.",driver.findElement(By.xpath("//p[text()=\"Sending failed.\"]")).getText());
  }
  
  @Test(priority=25, description="To verify that user is able to close the \"Sent Email\" dialog. ")
  public void SGL_Ranchi_CITYGIS_25() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Go to particular location using Zoom-in facility.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Tools\" icon from top panel. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Bookmarks\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Bookmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter the bookmark name in \"Name\" textbox. ");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_name)).sendKeys("Testing");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter the bookmark description in \"Description\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_Des)).sendKeys("Test for automation.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Add button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Add)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Send Email\" link from the bookmark list.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Send_Email)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on close icon from the \"Sent Email\" dialog.");
	  driver.findElement(By.xpath("//body/div[@style=\"position: absolute; z-index: 9013; visibility: visible; left: 750px; top: 262px; width: 420px; display: block;\"]//div[@class=\"x-tool x-tool-close\"]")).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Sent Email\" dialog should be close.");
	  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@class=\"x-shadow\"]")).getCssValue("display"));
  }
  
  @Test(priority=26, description="To verify that user is not able to sent email without entering email id.")
  public void SGL_Ranchi_CITYGIS_26() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Go to particular location using Zoom-in facility.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Tools\" icon from top panel. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Bookmarks\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Bookmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter the bookmark name in \"Name\" textbox. ");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_name)).sendKeys("Testing");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter the bookmark description in \"Description\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_Des)).sendKeys("Test for automation.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Add button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Add)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Send Email\" link from the bookmark list.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Send_Email)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"Sent Email\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Send_Email_Pop)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message as \"Please enter valid email id\".");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//p[text()=\"Please enter valid email id\"]")).isDisplayed());
  }
  
  @Test(priority=27, description="To verify that user is not able to sent email with invalid email id.")
  public void SGL_Ranchi_CITYGIS_27() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Go to particular location using Zoom-in facility.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Tools\" icon from top panel. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Bookmarks\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Bookmarks)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter the bookmark name in \"Name\" textbox. ");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_name)).sendKeys("Testing");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter the bookmark description in \"Description\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_Des)).sendKeys("Test for automation.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Add button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Add)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Send Email\" link from the bookmark list.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Send_Email)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Enter invalid email id in \"Sent TO\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Email_id)).sendKeys("testingligis.com");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Enter description in \"Body\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Email_Body)).sendKeys("Test for automation.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Click on \"Sent Email\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Send_Email_Pop)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message as \"Please enter valid email id\".");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//p[text()=\"Please enter valid email id\"]")).isDisplayed());
  }
  
  @Test(priority=28, description="To verify that user is able to get the \"Available Layers\" dialog.")
  public void SGL_Ranchi_CITYGIS_28() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Add Layers\" functionality from layer panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Add_Layer )).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the dialog of \"Available Layers\" functionality.");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//span[text()=\"Available Layers\"]")).isDisplayed());
  }
  
  @Test(priority=29, description="To verify that user is able to \"Search\" particular layer from the \"Available Layers\" dialog.")
  public void SGL_Ranchi_CITYGIS_29() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Add Layers\" functionality from layer panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Add_Layer )).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"View available data from\" dropdown.");
	  driver.findElement(By.xpath(City_GIS_R.btn_View_Available_data )).click();
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Add a New Server\" functionality.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",   driver.findElement(By.xpath(City_GIS_R.btn_Add_New_Server )));
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select type from the \"Type\" dropdown.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter url in \"URL\" textbox.");
	  String aa = "http://qaranchi.sgligis.com:1213/cgi-bin/IGiS_Ent_service.exe?IEG_PROJECT=ranchi_ws&LAYERS=boundary_ward&TRANSPARENT=TRUE&FORMAT=image/png&SERVICE=WMA";
	  driver.findElement(By.xpath(City_GIS_R.txt_url_ANS)).sendKeys(aa);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Add Server\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Add_Server  )).click();
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Enter layer name into \"Search Layers\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Search_Layer_AL )).sendKeys("valve");
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get searched layer in \"Available Layers\" dialog.");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//div[text()=\"valve\"]")).isDisplayed());
  }
  
  @Test(priority=30, description="To verify that user is able to perform \"Sort Alphabetically\" functionality from \"Available Layers\" dialog.")
  public void SGL_Ranchi_CITYGIS_30() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Add Layers\" functionality from layer panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Add_Layer )).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"View available data from\" dropdown.");
	  driver.findElement(By.xpath(City_GIS_R.btn_View_Available_data )).click();
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Add a New Server\" functionality.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",   driver.findElement(By.xpath(City_GIS_R.btn_Add_New_Server )));
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select type from the \"Type\" dropdown.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter url in \"URL\" textbox.");
	  String aa = "http://qaranchi.sgligis.com:1213/cgi-bin/IGiS_Ent_service.exe?IEG_PROJECT=ranchi_ws&LAYERS=boundary_ward&TRANSPARENT=TRUE&FORMAT=image/png&SERVICE=WMA";
	  driver.findElement(By.xpath(City_GIS_R.txt_url_ANS)).sendKeys(aa);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Add Server\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Add_Server  )).click();
	  Thread.sleep(1000);
	  ArrayList<String> datasetcount = new ArrayList<String>();
	  List<WebElement> element1 = driver.findElements(By.xpath("//div[@class=\"layercard\"]/div[1]"));
	  System.out.println(element1.size());
	  for(int i =0; i<element1.size(); i++) {
		  datasetcount.add(element1.get(i).getText());
		  Thread.sleep(1000);
	  } 
	  System.out.println(datasetcount);
	  Collections.sort(datasetcount); 
	  System.out.println(datasetcount);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Sort Alphabetically\" functionality from the \"Available Layers\" dialog.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Sort_alphabetically)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Available layers should be sorting \"Ascending/Descending\" order as per selection.");
	  ArrayList<String> datasetcount1 = new ArrayList<String>();
	  List<WebElement> element2 = driver.findElements(By.xpath("//div[@class=\"layercard\"]/div[1]"));
	  System.out.println(element2.size());
	  for(int i =0; i<element2.size(); i++) {
		  datasetcount1.add(element2.get(i).getText());
		  Thread.sleep(1000);
	  } 
	  System.out.println(datasetcount1);
	  Assert.assertEquals(datasetcount, datasetcount1);
  }
  @Test(priority=31, description="To verify that user is able to add layer in layer panel.")
  public void SGL_Ranchi_CITYGIS_31() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Add Layers\" functionality from layer panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Add_Layer )).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"View available data from\" dropdown.");
	  driver.findElement(By.xpath(City_GIS_R.btn_View_Available_data )).click();
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Add a New Server\" functionality.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",   driver.findElement(By.xpath(City_GIS_R.btn_Add_New_Server )));
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select type from the \"Type\" dropdown.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter url in \"URL\" textbox.");
	  String aa = "http://qaranchi.sgligis.com:1213/cgi-bin/IGiS_Ent_service.exe?IEG_PROJECT=ranchi_ws&LAYERS=boundary_ward&TRANSPARENT=TRUE&FORMAT=image/png&SERVICE=WMA";
	  driver.findElement(By.xpath(City_GIS_R.txt_url_ANS)).sendKeys(aa);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Add Server\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Add_Server  )).click();
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on particular \"Add Layer\" button.");
	  driver.findElement(By.xpath("//div/div[3]//table[@name=\"addlayer\"]//tr[2]/td[2]/em/button" )).click();
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Selected layer should be display in layer panel.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Search_Layer)).sendKeys("ranchi");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"ranchi\"]")).isDisplayed());
  }
  
  @Test(priority=32, description="To verify that user is able to perform \"Cancel\" functionality.")
  public void SGL_Ranchi_CITYGIS_32() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Add Layers\" functionality from layer panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Add_Layer )).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"View available data from\" dropdown.");
	  driver.findElement(By.xpath(City_GIS_R.btn_View_Available_data )).click();
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Add a New Server\" functionality.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",   driver.findElement(By.xpath(City_GIS_R.btn_Add_New_Server )));
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select type from the \"Type\" dropdown.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter url in \"URL\" textbox.");
	  String aa = "http://qaranchi.sgligis.com:1213/cgi-bin/IGiS_Ent_service.exe?IEG_PROJECT=ranchi_ws&LAYERS=boundary_ward&TRANSPARENT=TRUE&FORMAT=image/png&SERVICE=WMA";
	  driver.findElement(By.xpath(City_GIS_R.txt_url_ANS)).sendKeys(aa);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Cancel\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Cancel)).click();
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Add new server\" dialog should be close.");
	//  Assert.assertEquals(false, driver.findElement(By.xpath("//span[text()=\"Add new server...\"]")).isDisplayed());
  }
  
  @Test(priority=33, description="To verify that user is able to close the \"Add new server\" dialog.")
  public void SGL_Ranchi_CITYGIS_33() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Add Layers\" functionality from layer panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Add_Layer )).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"View available data from\" dropdown.");
	  driver.findElement(By.xpath(City_GIS_R.btn_View_Available_data )).click();
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Add a New Server\" functionality.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",   driver.findElement(By.xpath(City_GIS_R.btn_Add_New_Server )));
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select type from the \"Type\" dropdown.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter url in \"URL\" textbox.");
	  String aa = "http://qaranchi.sgligis.com:1213/cgi-bin/IGiS_Ent_service.exe?IEG_PROJECT=ranchi_ws&LAYERS=boundary_ward&TRANSPARENT=TRUE&FORMAT=image/png&SERVICE=WMA";
	  driver.findElement(By.xpath(City_GIS_R.txt_url_ANS)).sendKeys(aa);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Close\" button.");
	  driver.findElement(By.xpath("//div[@style=\"position: absolute; z-index: 9023; visibility: visible; left: 810px; top: 179px; width: 300px; display: block;\"]//div[@class=\"x-tool x-tool-close\"]")).click();
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Add new server\" dialog should be close.");
	 // Assert.assertEquals(false, driver.findElement(By.xpath("//span[text()=\"Add new server...\"]")).isDisplayed());
  }
  
  @Test(priority=34, description="To verify that user is able to close the \"Available Layers\" dialog.")
  public void SGL_Ranchi_CITYGIS_34() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Add Layers\" functionality from layer panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Add_Layer )).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on close icon of the \"Available Layers\" dialog.");
	  driver.findElement(By.xpath("//div[@style=\"position: absolute; z-index: 9003; visibility: visible; left: 740px; top: 117px; width: 440px; display: block;\"]//div[@class=\"x-tool x-tool-close\"]")).click();
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Add new server\" dialog should be close.");
	 // Assert.assertEquals(false, driver.findElement(By.xpath("//span[text()=\"Add new server...\"]")).isDisplayed());
  }
  
  @Test(priority=35, description="To verify that user is not able to add server without entering \"URL\".")
  public void SGL_Ranchi_CITYGIS_35() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Add Layers\" functionality from layer panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Add_Layer )).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"View available data from\" dropdown.");
	  driver.findElement(By.xpath(City_GIS_R.btn_View_Available_data )).click();
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Add a New Server\" functionality.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",   driver.findElement(By.xpath(City_GIS_R.btn_Add_New_Server )));
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Add Server\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Add_Server  )).click();
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the validation message as \"Please Enter URL\".");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Please Enter URL\"]")).isDisplayed());
  }
  
  @Test(priority=36, description="To verify that user is able to perform \"Identify\" tool functionality.")
  public void SGL_Ranchi_CITYGIS_36() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Tools\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Identify\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Identify)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on particular attribute on the map.");
	  Actions action = new Actions(driver);
	  action.moveByOffset(853,600).click().perform();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the \"Feature Info\" popup with details of particular data record.");
	  Assert.assertEquals("visible",driver.findElement(By.xpath("//div[@class=\" gx-popup x-window x-resizable-pinned\"]")).getCssValue("visibility"));
  }
  
  @Test(priority=37, description="To verify that user is able to close \"Feature Info\" popup.")
  public void SGL_Ranchi_CITYGIS_37() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Tools\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Identify\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Identify)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on particular attribute on the map.");
	  Actions action = new Actions(driver);
	  action.moveByOffset(853,600).click().perform();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Close button from the feature info Pop-up.");
	  driver.findElement(By.xpath(City_GIS_R.btn_close)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the Pop-up with details of particular attribute which are selected from the City GIS map.");
	  Assert.assertEquals("hidden",driver.findElement(By.xpath("//div[@class=\" gx-popup x-window x-resizable-pinned\"]")).getCssValue("visibility"));
  }
  
  @Test(priority=38, description="To verify that user is able to \"Download\" the details  in specific format from \"Feature Info\" popup.")
  public void SGL_Ranchi_CITYGIS_38() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Tools\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Identify\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Identify)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on particular attribute on the map.");
	  Actions action = new Actions(driver);
	  action.moveByOffset(853,600).click().perform();
	  Thread.sleep(6000);
	  File file = new File("C:\\Users\\meet.g\\Downloads");
	  for (File file1:file.listFiles() )
		  { 
		  if(file1.getName().startsWith("boundary_ward")&& file1.getName().endsWith(".xls"))
			  {
			  file1.delete();
			  }
		  }
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Download option from the feature info Pop-up.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Download)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on Download option from the feature info Pop-up.");
	  driver.findElement(By.xpath(City_GIS_R.lnk_XLS_Download)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should able to download the all details in selected file format.");
	  File f = new File("C:\\Users\\meet.g\\Downloads\\boundary_ward.xls"); 
	 Assert.assertEquals(true,  f.exists());
  }
  
  @Test(priority=39, description="To verify that user is able to perform \"Table/Detail\" option from feature info pop-up.")
  public void SGL_Ranchi_CITYGIS_39() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Tools\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Identify\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Identify)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on particular attribute on the map.");
	  Actions action = new Actions(driver);
	  action.moveByOffset(853,600).click().perform();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Table/Detail\" option from the feature info pop-up.");
	  driver.findElement(By.xpath("//button[text()=\"Table\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Feature Info\" pop-up should be display in \"Detail/Table\" format.");
	  Assert.assertEquals(true,  driver.findElement(By.xpath("//button[text()=\"Detail\"]")).isDisplayed());
  }
  
  @Test(priority=40, description="To verify that user is able to perform \"Pan\" functionality on map.")
  public void SGL_Ranchi_CITYGIS_40() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Tools\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Display\"..");
	  driver.findElement(By.xpath(City_GIS_R.btn_Display)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Pan\"  functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Pan)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1.\"Pan\" functionality should be activated.   2.User should perform action on map like move / drag/zoom in/zoom out.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//a[@class=\"active\" and text()=\"Pan\"]")).isDisplayed());
  }
  
  @Test(priority=41, description="To verify \"Coordinates\" functionality.")
  public void SGL_Ranchi_CITYGIS_41() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Tools\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Display\"..");
	  driver.findElement(By.xpath(City_GIS_R.btn_Display)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Coordinates\"  functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Coordinates)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter longitude value in \"Lon [Grad]\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R. txt_long_grad)).sendKeys("85.32");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter latitude value in \"Lat [Grad]\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_lat_grad)).sendKeys("23.34");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select particular zoom level from \"Zoom\" drop-down.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_zoom)).click();
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath("//div[text()=\"1 : 5610\"]")));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Go\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the marker point on map at mentioned coordinates and zoom level.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.img_Pin_point)).isDisplayed());    
  }
  
  @Test(priority=42, description="To verify that user is able to \"Remove markers\" from the map.")
  public void SGL_Ranchi_CITYGIS_42() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Tools\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Display\"..");
	  driver.findElement(By.xpath(City_GIS_R.btn_Display)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Coordinates\"  functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Coordinates)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter longitude value in \"Lon [Grad]\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R. txt_long_grad)).sendKeys("85.32");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter latitude value in \"Lat [Grad]\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_lat_grad)).sendKeys("23.34");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select particular zoom level from \"Zoom\" drop-down.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_zoom)).click();
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath("//div[text()=\"1 : 5610\"]")));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Go\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go)).click();
	  List<WebElement> element = driver.findElements(By.xpath("//div/div/img"));
	  System.out.println(element.size());
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Remove Markers button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_rm_marker)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Marker point on map should be removed.");
	  List<WebElement> element1 = driver.findElements(By.xpath("//div/div/img"));
	  System.out.println(element1.size());
	  Assert.assertNotEquals(element1.size(), element.size());    
  }
  
  @Test(priority=43, description="To verify user is able to perform \"Coordinates\" functionality with \"Remember locations\" mode.")
  public void SGL_Ranchi_CITYGIS_43() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Tools\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Display\"..");
	  driver.findElement(By.xpath(City_GIS_R.btn_Display)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Coordinates\"  functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Coordinates)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter longitude value in \"Lon [Grad]\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R. txt_long_grad)).sendKeys("85.32");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter latitude value in \"Lat [Grad]\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_lat_grad)).sendKeys("23.34");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select particular zoom level from \"Zoom\" drop-down.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_zoom)).click();
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath("//div[text()=\"1 : 89757\"]")));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Go\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Enter longitude value in \"Lon [Grad]\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R. txt_long_grad)).clear();
	  driver.findElement(By.xpath(City_GIS_R. txt_long_grad)).sendKeys("85.38");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Enter latitude value in \"Lat [Grad]\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_lat_grad)).clear();
	  driver.findElement(By.xpath(City_GIS_R.txt_lat_grad)).sendKeys("23.34");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Select particular zoom level from \"Zoom\" drop-down.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14:</b> Click on \"Remember Locations\" checkbox from .");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15:</b> Click on \"Go\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the marker point on map at mentioned coordinates and zoom level with remembering previous location marker points.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.img_Pin_point)).isDisplayed());
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div/div[2]/img[@class=\"olAlphaImg\"]")).isDisplayed());
	  
    
  }
  
  @Test(priority=44, description="To verify user is able to perform \"Coordinates\" functionality with \"Remove markers on close\" mode.")
  public void SGL_Ranchi_CITYGIS_44() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Tools\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Display\"..");
	  driver.findElement(By.xpath(City_GIS_R.btn_Display)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Coordinates\"  functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Coordinates)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter longitude value in \"Lon [Grad]\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R. txt_long_grad)).sendKeys("85.32");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter latitude value in \"Lat [Grad]\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_lat_grad)).sendKeys("23.34");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select particular zoom level from \"Zoom\" drop-down.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_zoom)).click();
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath("//div[text()=\"1 : 89757\"]")));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Remove markers on close\" mode checkbox.");
	  driver.findElement(By.xpath("//div/div[6]//input[@class=\" x-form-checkbox x-form-field hr-html-panel-font-size-11\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"Go\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go)).click();
	  List<WebElement> element = driver.findElements(By.xpath("//div/div/img"));
	  System.out.println(element.size());
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on close button of the \"Go To Coordinates\" dialog.");
	  driver.findElement(By.xpath(City_GIS_R.btn_close)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Marker point on map should be removed.");
	  List<WebElement> element1 = driver.findElements(By.xpath("//div/div/img"));
	  System.out.println(element1.size());
	  Assert.assertNotEquals(element1.size(), element.size()); 
    
  }
  
  @Test(priority=45, description="To verify close functionality of \"Go To Coordinates\" dialog.")
  public void SGL_Ranchi_CITYGIS_45() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Tools\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Display\"..");
	  driver.findElement(By.xpath(City_GIS_R.btn_Display)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Coordinates\"  functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Coordinates)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter longitude value in \"Lon [Grad]\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R. txt_long_grad)).sendKeys("85.32");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter latitude value in \"Lat [Grad]\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_lat_grad)).sendKeys("23.34");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select particular zoom level from \"Zoom\" drop-down.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_zoom)).click();
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",  driver.findElement(By.xpath("//div[text()=\"1 : 89757\"]")));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Remove markers on close\" mode checkbox.");
	  driver.findElement(By.xpath("//div/div[6]//input[@class=\" x-form-checkbox x-form-field hr-html-panel-font-size-11\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"Go\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go)).click();
	  List<WebElement> element = driver.findElements(By.xpath("//div/div/img"));
	  System.out.println(element.size());
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on close button of the \"Go To Coordinates\" dialog.");
	  driver.findElement(By.xpath(City_GIS_R.btn_close)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Go To Coordinates\" pop-up should be close.");
	  List<WebElement> element1 = driver.findElements(By.xpath("//div/div/img"));
	  System.out.println(element1.size());
	  Assert.assertNotEquals(element1.size(), element.size()); 
    
  }
  
  @Test(priority=46, description="To verify that user is able to perform \"Length\" functionality.")
  public void SGL_Ranchi_CITYGIS_46() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Tools\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Measure\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Measure)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Length\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Length)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click and select the two location on map.");
	  Robot robot = new Robot();
	  robot.mouseMove(950,220);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  robot.mouseMove(1200,400);
	  robot.delay(1500);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseMove(1300,450);
	  robot.delay(1500);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1. User should get the line between two selected location.\r\n"
	  		+ "2. User should get the length between selected locations in \"m/km\" on map.\r\n"
	  		+ "3. User should get the same length in \"m/km\" in bottom panel.");
	  System.out.println( driver.findElement(By.xpath(City_GIS_R.polyline)).isDisplayed());
	  Assert.assertEquals(true,  driver.findElement(By.xpath(City_GIS_R.polyline)).isDisplayed());   
  }
  
  @Test(priority=47, description="To verify that user is able to perform \"Area\" functionality.")
  public void SGL_Ranchi_CITYGIS_47() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Tools\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Measure\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Measure)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Area\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Area)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click and select more than two locations on map.");
	  Robot robot = new Robot();
	  robot.mouseMove(950,220);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  robot.mouseMove(1200,400);
	  robot.delay(1500);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseMove(1500,450);
	  robot.delay(1500);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1. User should get the polygon between selected locations.\r\n"
	  		+ "2. User should get the area between selected locations in \"m2/km2\" on map.\r\n"
	  		+ "3. User should get the length in \"m2/km2\" in bottom panel.");
	  System.out.println( driver.findElement(By.xpath(City_GIS_R.polygone)).isDisplayed());
	  Assert.assertEquals(true,  driver.findElement(By.xpath(City_GIS_R.polygone)).isDisplayed());   
  }
  
  @Test(priority=48, description="To verify that user is able to perform \"Swipe\" tool functionality using \"By Layer\" option.")
  public void SGL_Ranchi_CITYGIS_48() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click and select particular layer from the layer panel.");
	  driver.findElement(By.xpath(City_GIS_R.Layer_Ranchi_Basemap)).click(); 
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Tools\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Move mouse over on \"Swipe\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"By Layer\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe_Layer)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Ok\" button of the \"Start Swipe\" pop-up.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",   driver.findElement(By.xpath(City_GIS_R.btn_ok_swipe_popup)));
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Move mouse over selected layer on map.");
	  Robot robot = new Robot();
	  robot.mouseMove(853,450);
	  robot.delay(1500);
	  String a1 = driver.findElement(By.xpath("//div[@id=\"OpenLayers_Layer_WMS_261\"]")).getAttribute("style");
	  System.out.println(a1);
	  robot.mouseMove(980,450);
	  robot.delay(1500);
	  String a2 = driver.findElement(By.xpath("//div[@id=\"OpenLayers_Layer_WMS_261\"]")).getAttribute("style");
	  System.out.println(a2);
	  Thread.sleep(3000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Selected layer should be swipe as per mouse movements on map.");
	  Assert.assertNotEquals(a1,a2);
  }
  
  @Test(priority=49, description="To verify that user is able to stop swipe \"By Layer\" functionality.")
  public void SGL_Ranchi_CITYGIS_49() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click and select particular layer from the layer panel.");
	  driver.findElement(By.xpath(City_GIS_R.Layer_Ranchi_Basemap)).click(); 
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Tools\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Move mouse over on \"Swipe\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"By Layer\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe_Layer)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Ok\" button of the \"Start Swipe\" pop-up.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",   driver.findElement(By.xpath(City_GIS_R.btn_ok_swipe_popup)));
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Tools icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on Swipe icon from the top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Select By Layer option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe_Layer)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on OK button from the pop-up of swipe.");
	  executor.executeScript("arguments[0].click();",   driver.findElement(By.xpath(City_GIS_R.btn_ok_swipe_popup)));
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) \"Stop Swipe\" pop-up should close.\r\n"
	  		+ "2) \"Swipe\" functionality should stopped.");
	  Assert.assertEquals(false,  driver.findElement(By.xpath(City_GIS_R.dialog_swipe_popup)).isDisplayed());
  }
  
  @Test(priority=50, description="To verify that user is able to close popup of start/stop swipe.")
  public void SGL_Ranchi_CITYGIS_50() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click and select particular layer from the layer panel.");
	  driver.findElement(By.xpath(City_GIS_R.Layer_Ranchi_Basemap)).click(); 
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Tools\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Move mouse over on \"Swipe\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"By Layer\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe_Layer)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on (X) icon of the pop-up.");
	  driver.findElement(By.xpath(City_GIS_R.btn_close)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Start Swipe\" pop-up should close.");
	  Assert.assertEquals(false,  driver.findElement(By.xpath(City_GIS_R.dialog_swipe_popup)).isDisplayed());
  }
  
  @Test(priority=51, description="To verify that user is not able to perform \"Swipe\" tool using \"By Layer\" option without selecting layer.")
  public void SGL_Ranchi_CITYGIS_51() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Tools\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Swipe\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select \"By Layer\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe_Layer)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the alert message as \"Select Proper Layer Before Swipe Start\"");
	  Assert.assertEquals(true,  driver.findElement(By.xpath("//span[text()=\"Select Proper Layer Before Swipe Start\"]")).isDisplayed());
  }
  
  @Test(priority=52, description="To verify that user is able to perform \"Swipe\" tool functionality using \"By Pointer\" option.")
  public void SGL_Ranchi_CITYGIS_52() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click and select particular layer from the layer panel.");
	  driver.findElement(By.xpath(City_GIS_R.Layer_Ranchi_Basemap)).click(); 
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Tools\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Move mouse over on \"Swipe\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"By Pointer\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe_Pointer)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Ok\" button of the \"Start Swipe\" pop-up.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",   driver.findElement(By.xpath(City_GIS_R.btn_ok_swipe_popup)));
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Move mouse over selected layer on map.");
	  Robot robot = new Robot();
	  robot.mouseMove(853,450);
	  robot.delay(1500);
	  String a1 = driver.findElement(By.xpath("//div[@id=\"OpenLayers_Layer_WMS_261\"]")).getAttribute("style");
	  System.out.println(a1);
	  robot.mouseMove(980,450);
	  robot.delay(1500);
	  String a2 = driver.findElement(By.xpath("//div[@id=\"OpenLayers_Layer_WMS_261\"]")).getAttribute("style");
	  System.out.println(a2);
	  Thread.sleep(3000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Selected layer should be swipe as per mouse movements on map.");
	  Assert.assertNotEquals(a1,a2);
  }
  
  @Test(priority=53, description="To verify that user is able to stop swipe \"By Pointer\" functionality.")
  public void SGL_Ranchi_CITYGIS_53() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click and select particular layer from the layer panel.");
	  driver.findElement(By.xpath(City_GIS_R.Layer_Ranchi_Basemap)).click(); 
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Tools\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Move mouse over on \"Swipe\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"By Pointer\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe_Pointer)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Ok\" button of the \"Start Swipe\" pop-up.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",   driver.findElement(By.xpath(City_GIS_R.btn_ok_swipe_popup)));
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on Tools icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Swipe icon from the top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe)).click();
	  
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Select By Pointer option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe_Pointer)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on OK button from the pop-up of swipe.");
	  executor.executeScript("arguments[0].click();",   driver.findElement(By.xpath(City_GIS_R.btn_ok_swipe_popup)));
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) \"Stop Swipe\" pop-up should close.\r\n"
	  		+ "2) \"Swipe\" functionality should stopped.");
	  Assert.assertEquals(false,  driver.findElement(By.xpath(City_GIS_R.dialog_swipe_popup)).isDisplayed());
  }
  
  @Test(priority=54, description="To verify that user is able to close popup of the start/stop swipe \"By Pointer\" functionality.")
  public void SGL_Ranchi_CITYGIS_54() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click and select particular layer from the layer panel.");
	  driver.findElement(By.xpath(City_GIS_R.Layer_Ranchi_Basemap)).click(); 
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Tools\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Move mouse over on \"Swipe\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select \"By Pointer\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe_Pointer)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on close (X) icon of the \"Stop Swipe\"  pop-up.");
	  driver.findElement(By.xpath(City_GIS_R.btn_close)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Start Swipe\" pop-up should close.");
	  Assert.assertEquals(false,  driver.findElement(By.xpath(City_GIS_R.dialog_swipe_popup)).isDisplayed());
  }
  
  @Test(priority=55, description="To verify that user is not able to perform \"Swipe\" tool using \"By Pointer\" option without selecting layer.")
  public void SGL_Ranchi_CITYGIS_55() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Tools\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Swipe\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select \"By Pointer\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe_Pointer)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the alert message as \"Select Proper Layer Before Swipe Pointer Start\".");
	  Assert.assertEquals(true,  driver.findElement(By.xpath("//span[text()=\"Select Proper Layer Before Swipe Pointer Start\"]")).isDisplayed());
  }
  
  @Test(priority=56, description="To verify that user is able to perform \"Bookmarks\" functionality.")
  public void SGL_Ranchi_CITYGIS_56() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Go to particular location using Zoom-in facility.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Tools\" icon from top panel. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Bookmarks\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Bookmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter the bookmark name in \"Name\" textbox. ");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_name)).sendKeys("Testing");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter the bookmark description in \"Description\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_Des)).sendKeys("Test for automation.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Add button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Add)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should added bookmark in bookmarks list presents at bottom side of the layer panel..");
	  Assert.assertEquals(true,  driver.findElement(By.xpath("//a[text()=\"Testing\"]")).isDisplayed());
  }
  
  @Test(priority=57, description="To verify that user is able to perform \"Cancel\" functionality from \"Add a Bookmark\" dialog.")
  public void SGL_Ranchi_CITYGIS_57() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Go to particular location using Zoom-in facility.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Tools\" icon from top panel. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Bookmarks\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Bookmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter the bookmark name in \"Name\" textbox. ");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_name)).sendKeys("Testing");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter the bookmark description in \"Description\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_Des)).sendKeys("Test for automation.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Cancel option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Cancel)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) Bookmark should not save.\r\n"
	  		+ "2) \"Add a bookmark\" dialog should close.");
	  Assert.assertEquals(false,  driver.findElement(By.xpath(City_GIS_R.dialog_Bookmark)).isDisplayed());
  }
  
  @Test(priority=58, description="To verify that user is able to perform close functionality from \"Add a Bookmark\" dialog.")
  public void SGL_Ranchi_CITYGIS_58() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Go to particular location using Zoom-in facility.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Tools\" icon from top panel. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Bookmarks\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Bookmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter the bookmark name in \"Name\" textbox. ");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_name)).sendKeys("Testing");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Enter the bookmark description in \"Description\" textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_Des)).sendKeys("Test for automation.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on close icon of the \"Add a bookmark\" dialog.");
	  driver.findElement(By.xpath(City_GIS_R.btn_close)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Add a Bookmark\" dialog should be close.");
	  Assert.assertEquals(false,  driver.findElement(By.xpath(City_GIS_R.dialog_Bookmark)).isDisplayed());
  }
  
  @Test(priority=59, description="To verify that user is not able to add bookmark without entering bookmark name.")
  public void SGL_Ranchi_CITYGIS_59() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Go to particular location using Zoom-in facility.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse over on \"Tools\" icon from top panel. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Bookmarks\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Bookmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Add button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Add)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message as \"Bookmark name cannot be empty\".");
	  Assert.assertEquals(true,  driver.findElement(By.xpath("//span[text()=\"Bookmark name cannot be empty\"]")).isDisplayed());
  }
  
  @Test(priority=60, description="To verify that user is able to perform \"Advance Search\" functionality.")
  public void SGL_Ranchi_CITYGIS_60() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Advance Search\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select anyone layer from the \"Layer\" drop-down.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("136"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> click on field name from the drop-down.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Adance_Query)).sendKeys("\"name\">= 'Allahabad Bank'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Apply\" option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Apply)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) User should navigates to result tab with information.\r\n"
	  		+ "2) User should get records on map with specific zoom-level.");
	  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@aria-labelledby=\"tabsearch\"]")).getCssValue("display")); 
  }
  
  @Test(priority=61, description="To verify that user is able to perform expand/collapse functionality for \"Advance Search\" dialog.")
  public void SGL_Ranchi_CITYGIS_61(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Advance Search\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on collapse/expand button.");
	  driver.findElement(By.xpath("//button[@title=\"collapse\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Advance Search\" dialog should collapse/expand as per selection.");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//button[@title=\"restore\"]")).isDisplayed()); 
	  objs.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on collapse/expand button.");
	  driver.findElement(By.xpath("//button[@title=\"restore\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Advance Search\" dialog should collapse/expand as per selection.");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//button[@title=\"collapse\"]")).isDisplayed()); 
  }
  
  @Test(priority=62, description="To verify that user is able to perform close functionality for \"Advance Search\" dialog.")
  public void SGL_Ranchi_CITYGIS_62() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Advance Search\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on close button.");
	  driver.findElement(By.xpath("//button[@title=\"Close\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Advance Search\" functionality dialog should close.");
	  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@aria-describedby=\"modalAdvanceSearch\"]")).getCssValue("display")); 
  }
  
  @Test(priority=63, description="To verify that user is able to perform \"Blink/Unblink\" functionality of \"Result\" tab from \"Advance Search\" dialogs.")
  public void SGL_Ranchi_CITYGIS_63() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Advance Search\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select anyone layer from the \"Layer\" drop-down.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("136"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> click on field name from the drop-down.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Adance_Query)).sendKeys("\"name\">= 'Allahabad Bank'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Apply\" option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Apply)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on the \"Blink/Unblink\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Unblink)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Records which are display on map should be blink/unblink.");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//button[text()=\"Blink\"]")).isDisplayed()); 
	  driver.findElement(By.xpath("//button[@title=\"collapse\"]")).click();
	  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@aria-labelledby=\"tabsearch\"]")).getCssValue("display")); 
  }
  
  @Test(priority=64, description="To verify that user is able to perform \"Back\" functionality of \"Result\" tab from \"Advance Search\" dialog.")
  public void SGL_Ranchi_CITYGIS_64() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Advance Search\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select anyone layer from the \"Layer\" drop-down.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("136"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> click on field name from the drop-down.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Adance_Query)).sendKeys("\"name\">= 'Allahabad Bank'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Apply\" option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Apply)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"Back\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Back)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should navigates on \"Advance Search\" tab.");
	  Assert.assertEquals("block",driver.findElement(By.xpath("//div[@aria-labelledby=\"tabsearch\"]")).getCssValue("display"));  
  }
  
  @Test(priority=65, description="To verify that user is able to perform \"Clear\" functionality from \"Advance Search\" dialog.")
  public void SGL_Ranchi_CITYGIS_65() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Advance Search\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select anyone layer from the \"Layer\" drop-down.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("136"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> click on field name from the drop-down.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Adance_Query)).sendKeys("\"name\">= 'Allahabad Bank'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Clear\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Clear_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Advance Search\" dialog and map should be clear and resets.");
	  Assert.assertEquals("",driver.findElement(By.xpath(City_GIS_R.txt_Adance_Query)).getText());  
  }
  
  @Test(priority=66, description="To verify that user is able to perform \"Save\" functionality from \"Advance Search\" dialog.")
  public void SGL_Ranchi_CITYGIS_66() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Advance Search\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select anyone layer from the \"Layer\" drop-down.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("136"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> click on field name from the drop-down.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Adance_Query)).sendKeys("\"name\">= 'Allahabad Bank'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Save\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Save)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b>  Enter the query name in \"Name\" textbox of the \"Save Query\" dialog.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Name)).sendKeys("Testing");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Enter the query description in \"Description\" textbox of the save query dialog.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Description)).sendKeys("This is automation testing.");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Click and check the \"Is Predefined Query?\" checkbox.");
	  driver.findElement(By.xpath(City_GIS_R.chk_qbispredefined)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14:</b> Click on \"Save\" button from \"Save Query\" dialog.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Save_Query)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get success message as \"Query Saved Successfully\".");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//p[text()=\"Query Saved Successfully\"]")).isDisplayed()); 
  }
  
  @Test(priority=67, description="To verify that user is able to \"Verify\" the query  from \"Advance Search\" dialog.")
  public void SGL_Ranchi_CITYGIS_67() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Advance Search\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select anyone layer from the \"Layer\" drop-down.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("136"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> click on field name from the drop-down.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Adance_Query)).sendKeys("\"name\">= 'Allahabad Bank'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Verify\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Verify)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get successful message as \"Query verified successfully\".");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//p[text()=\"Query verified successfully.\"]")).isDisplayed()); 
  }
  
  @Test(priority=68, description="To verify that user is able to \"Load Query\"  from \"Advance Search\" dialog.")
  public void SGL_Ranchi_CITYGIS_68() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Advance Search\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Load Query\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Load_Query)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select anyone query from \"Select Query\" drop down.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlLoadQuery\"]")));  
	  dropdown.selectByValue("116"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Load\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Load)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) Query should apply.\r\n"
	  		+ "2) User should navigates to result tab with information.\r\n"
	  		+ "3) User should get records on map with specific zoom-level.\r\n"
	  		+ "4) Query should display in values textbox of \"Advance Query\" tab.");
	  Assert.assertEquals("",driver.findElement(By.xpath(City_GIS_R.txt_Adance_Query)).getText()); 
  }
  
  @Test(priority=69, description="To verify that user is able to perform \"Spatial Filter\" functionality \"Advance Search\" dialog.")
  public void SGL_Ranchi_CITYGIS_69() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Advance Search\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select anyone layer from the \"Layer\" drop-down.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("136"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> click on field name from the drop-down.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Adance_Query)).sendKeys("\"name\">= 'Allahabad Bank'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Spatial Filter\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Spatial_Filter)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Select \"Layer B\" from the layer list");
	  Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id=\"ddladvancedfilterlayers\"]")));  
	  dropdown1.selectByValue("156"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Select \"Field\" from the fields list.");
	  Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@id=\"ddladvancedfilterfields\"]")));  
	  dropdown2.selectByValue("road_name"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Enter the \"Value\" from value list.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Values)).sendKeys("'7th Club Road'");
	  driver.findElement(By.xpath(City_GIS_R.txt_Values)).sendKeys(Keys.ENTER);
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14:</b> Enter the \"Buffer\" value.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Buffer)).sendKeys("1000");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15:</b> Click on \"Ok\" button.");
	  driver.findElement(By.xpath("//button[@id=\"btnspatialfilterOk\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16:</b> Click on \"Apply\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Apply)).click();
	  Thread.sleep(80000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) User should navigates to result tab with information.\r\n"
	  		+ "2) User should get records on map with specific zoom-level..");
	  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@aria-labelledby=\"tabsearch\"]")).getCssValue("display")); 
  }
  
  @Test(priority=70, description="To verify that user is able to perform \"Reset\" spatial filter functionality.")
  public void SGL_Ranchi_CITYGIS_70() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Advance Search\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select anyone layer from the \"Layer\" drop-down.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("136"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> click on field name from the drop-down.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Adance_Query)).sendKeys("\"name\">= 'Allahabad Bank'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Spatial Filter\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Spatial_Filter)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Select \"Layer B\" from the layer list");
	  Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id=\"ddladvancedfilterlayers\"]")));  
	  dropdown1.selectByValue("156"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Select \"Field\" from the fields list.");
	  Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@id=\"ddladvancedfilterfields\"]")));  
	  dropdown2.selectByValue("road_name"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Enter the \"Value\" from value list.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Values)).sendKeys("'7th Club Road'");
	  driver.findElement(By.xpath(City_GIS_R.txt_Values)).sendKeys(Keys.ENTER);
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14:</b> Enter the \"Buffer\" value.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Buffer)).sendKeys("1000");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15:</b> Click on \"Reset\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Reset)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Spatial Filter\" dialog should resets.");
	  Assert.assertEquals("",driver.findElement(By.xpath(City_GIS_R.txt_Buffer)).getText()); 
  }
  
  @Test(priority=71, description="To verify that user is able to perform spatial filter functionality using \"Map Extent\" option.")
  public void SGL_Ranchi_CITYGIS_71() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Advance Search\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select anyone layer from the \"Layer\" drop-down.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("136"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> click on field name from the drop-down.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Adance_Query)).sendKeys("\"name\">= 'Allahabad Bank'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Spatial Filter\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Spatial_Filter)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Select \"Map Extent\" tab.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Map_Extent)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Enter \"Upper left\" value for \"X\" coordinate.");
	  driver.findElement(By.xpath("//input[@id=\"txtupperX\"]")).sendKeys("85.27");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b>  Enter \"Upper left\" value for \"Y\" coordinate.");
	  driver.findElement(By.xpath("//input[@id=\"txtupperY\"]")).sendKeys("23.37");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14:</b> Enter \"Lower right\" value for \"X\" coordinate.");
	  driver.findElement(By.xpath("//input[@id=\"txtlowerX\"]")).sendKeys("85.34");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15:</b> Enter \"Lower right\" value for \"Y\" coordinate.");
	  driver.findElement(By.xpath("//input[@id=\"txtlowerY\"]")).sendKeys("23.8");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16:</b> Click on \"Ok\" button.");
	  driver.findElement(By.xpath("//div[@aria-hidden=\"false\"]//button[text()=\"Ok\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17:</b> Click on \"Apply\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Apply)).click();
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) User should navigates to result tab with information.\r\n"
	  		+ "2) User should get records on map with specific zoom-level..");
	  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@aria-labelledby=\"tabsearch\"]")).getCssValue("display")); 
  }
  
  @Test(priority=72, description="To verify that user is able to perform \"Select From Map\" button functionality from \"Map Extent\" tab of \"Spatial Filter\" dialog.")
  public void SGL_Ranchi_CITYGIS_72() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Advance Search\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select anyone layer from the \"Layer\" drop-down.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("136"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> click on field name from the drop-down.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Adance_Query)).sendKeys("\"name\">= 'Allahabad Bank'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Spatial Filter\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Spatial_Filter)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Select \"Map Extent\" tab.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Map_Extent)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Select from Map option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Select_From_Map)).click();
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
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Click on \"Ok\" button.");
	  driver.findElement(By.xpath("//div[@aria-describedby=\"modalAdvanceSearch\"]//button[text()=\"restore\"]")).click();
	  driver.findElement(By.xpath("//div[@aria-describedby=\"modalSpatialFilter\"]//button[text()=\"restore\"]")).click();
	  Thread.sleep(10000);
	  driver.findElement(By.xpath("//div[@aria-hidden=\"false\"]//button[text()=\"Ok\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14:</b> Click on \"Apply\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Apply)).click();
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) User should navigates to result tab with information.\r\n"
	  		+ "2) User should get records on map with specific zoom-level.");
	  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@aria-labelledby=\"tabsearch\"]")).getCssValue("display"));
  }
  
  @Test(priority=73, description="To verify that user is able to perform collapse/expand functionality of \"Spatial Filter\" dialog.")
  public void SGL_Ranchi_CITYGIS_73(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Advance Search\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select anyone layer from the \"Layer\" drop-down.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("136"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> click on field name from the drop-down.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Adance_Query)).sendKeys("\"name\">= 'Allahabad Bank'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Spatial Filter\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Spatial_Filter)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on collapse/expand button.");
	  driver.findElement(By.xpath("//div[@aria-describedby=\"modalSpatialFilter\"]//button[text()=\"collapse\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Spatial Filter\" dialog should be collapse/expand as per functionality.");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//div[@aria-describedby=\"modalSpatialFilter\"]//button[text()=\"restore\"]")).isDisplayed());
	  objs.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on collapse/expand button.");
	  driver.findElement(By.xpath("//div[@aria-describedby=\"modalSpatialFilter\"]//button[text()=\"restore\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Spatial Filter\" dialog should be collapse/expand as per functionality.");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//div[@aria-describedby=\"modalSpatialFilter\"]//button[text()=\"collapse\"]")).isDisplayed());
  }
  
  @Test(priority=74, description="To verify that user is able to perform close button functionality of \"Spatial Filter\" dialog.")
  public void SGL_Ranchi_CITYGIS_74() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Advance Search\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select anyone layer from the \"Layer\" drop-down.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("136"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Double click on specific field.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select the condition from the various option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> click on field name from the drop-down.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Adance_Query)).sendKeys("\"name\">= 'Allahabad Bank'");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Spatial Filter\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Spatial_Filter)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on close(X) button.");
	  driver.findElement(By.xpath("//div[@aria-describedby=\"modalSpatialFilter\"]//button[text()=\"Close\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) \"Spatial Filter\" dialog should close.\r\n"
	  		+ "2) Navigates to \"Advance Search\" dialog.");
	  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@aria-describedby=\"modalSpatialFilter\"]")).getCssValue("display"));
  }
  
  @Test(priority=75, description="To verify that user is not able to perform \"Apply\" functionality from \"Advance Search\" dialog without selecting layer from the \"Layer\" drop down.")
  public void SGL_Ranchi_CITYGIS_75() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Advance Search\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Apply\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Apply)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get alert message as \"Please select Layer\".");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//p[text()=\"Please select Layer\"]")).isDisplayed());
  }
  
  @Test(priority=76, description="To verify that user is not able to perform \"Verify\" functionality from \"Advance Search\" dialog without selecting layer from the \"Layer\" drop down.")
  public void SGL_Ranchi_CITYGIS_76() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Advance Search\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Verify\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Verify)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get alert message as \"Please select Layer\".");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//p[text()=\"Please select Layer\"]")).isDisplayed());
  }
  
  @Test(priority=77, description="To verify that user is not able to perform \"Save\" functionality from \"Advance Search\" dialog without selecting layer from the \"Layer\" drop down.")
  public void SGL_Ranchi_CITYGIS_77() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Advance Search\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Save\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Save)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get alert message as \"Please select Layer\".");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//p[text()=\"Please select Layer\"]")).isDisplayed());
  }
  
  @Test(priority=78, description="To verify that user is not able to perform \"Load Query\" functionality without selecting query from the \"Select Query\" drop down.")
  public void SGL_Ranchi_CITYGIS_78() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Advance Search\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select anyone layer from the \"Layer\" drop-down.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("136"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Load Query\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Load_Query)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Load\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Load)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User Should get the alert message as \"Please Select Query.\"");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//p[text()=\"Please Select Query.\"]")).isDisplayed());
  }
  
  @Test(priority=79, description="To verify that user is not able to perform \"Spatial Filter\" functionality from \"Advance Search\" dialog without selecting layer from the \"Layer\" drop down.")
  public void SGL_Ranchi_CITYGIS_79() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Advance Search\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Spatial Filter\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Spatial_Filter)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get alert message as \"Please select Layer\".");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//p[text()=\"Please select Layer\"]")).isDisplayed());
  }
  
  @Test(priority=80, description="To verify that user is not able to perform \"Spatial Filter\" functionality without selection of \"Layer B\".")
  public void SGL_Ranchi_CITYGIS_80() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Advance Search\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select anyone layer from the \"Layer\" drop-down.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("136"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Spatial Filter\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Spatial_Filter)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Ok\" button.");
	  driver.findElement(By.xpath("//div[@aria-hidden=\"false\"]//button[text()=\"Ok\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message as \"Please select the second layer (Layer B)\".");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//p[text()=\"Please select the second layer (Layer B)\"]")).isDisplayed());
  }
  
  @Test(priority=81, description="To verify that user is not able to perform \"Spatial Filter\" functionality without selection of \"Fields\".")
  public void SGL_Ranchi_CITYGIS_81() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Advance Search\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select anyone layer from the \"Layer\" drop-down.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("136"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Spatial Filter\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Spatial_Filter)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select \"Layer B\" from the layer list");
	  Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id=\"ddladvancedfilterlayers\"]")));  
	  dropdown1.selectByValue("156"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Ok\" button.");
	  driver.findElement(By.xpath("//div[@aria-hidden=\"false\"]//button[text()=\"Ok\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message as \"Please select the field for second layer (Layer B)\".");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//p[text()=\"Please select the field for second layer (Layer B)\"]")).isDisplayed());
  }
  
  @Test(priority=82, description="To verify that user is not able to perform \"Spatial Filter\" functionality without selection of \"Value\".")
  public void SGL_Ranchi_CITYGIS_82() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Advance Search\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Advance_Search)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select anyone layer from the \"Layer\" drop-down.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlqbLayer\"]")));  
	  dropdown.selectByValue("136"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Spatial Filter\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Spatial_Filter)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select \"Layer B\" from the layer list");
	  Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id=\"ddladvancedfilterlayers\"]")));  
	  dropdown1.selectByValue("156"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select \"Field\" from the fields list.");
	  Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@id=\"ddladvancedfilterfields\"]")));  
	  dropdown2.selectByValue("road_name"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Ok\" button.");
	  driver.findElement(By.xpath("//div[@aria-hidden=\"false\"]//button[text()=\"Ok\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message as \"Please select the value for second layer (Layer B)\".");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//p[text()=\"Please select the value for second layer (Layer B)\"]")).isDisplayed());
  }

  @Test(priority=83, description="To verify that user is able to perform \"Predefined Queries\" functionality.")
  public void SGL_Ranchi_CITYGIS_83() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Predefined Queries\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Predefined_Queries)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"View\" button from \"Predefined Query\" data grid.");
	  driver.findElement(By.xpath("//tr[2]//a[text()=\"View\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Apply\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Apply)).click();
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) User should navigates to result tab with information.\r\n"
	  		+ "2) User should get records on map with specific zoom-level.");
	  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@aria-labelledby=\"tabsearch\"]")).getCssValue("display")); 
  }
  
  @Test(priority=84, description="To verify that user is able to perform \"Bookmark Queries\" functionality.")
  public void SGL_Ranchi_CITYGIS_84() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Move mouse over on \"Analytics\" icon from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Bookmark Queries option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Bookmark_Queries)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get \"Bookmarked Queries\" result panel at bottom.");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//h3[text()=\"Bookmarked Queries\"]")).isDisplayed()); 
  }
  
  @Test(priority=85, description="To verify that user is able to perform \"Image\" functionality.")
  public void SGL_Ranchi_CITYGIS_85() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Image\" functionality from the top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Analytics)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Bookmark Queries option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Image)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Satellite image should display on map.");
	  Assert.assertEquals(true,driver.findElement(By.xpath("//div/li[1]/ul/li[2]/div/input[@checked]")).isSelected()); 
  }
  
  @Test(priority=86, description="To verify that user is able to perform \"Print\" functionality.")
  public void SGL_Ranchi_CITYGIS_86() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on  \"Print\" functionality from the top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Print)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on the Print option of the Print Preview pop-up. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_print)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Click on the \"Print\" button from the \"Print Preview\" dialog.");
	  
  }
  
  @Test(priority=87, description="To verify that user is able to change print \"Layout\".")
  public void SGL_Ranchi_CITYGIS_87() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on  \"Print\" functionality from the top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Print)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select anyone layout from \"Layout\" dropdown .");
	  driver.findElement(By.xpath("//div[@class=\"x-toolbar x-small-editor mdright x-toolbar-layout-ct\"]//tr/td[2]/div[@class=\"x-form-field-wrap x-form-field-trigger-wrap\"]//img")).click();
	  Thread.sleep(2000);
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",   driver.findElement(By.xpath("//div[text()=\"A3 Portrait\"]")));
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on the Print option of the Print Preview pop-up. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_print)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) File should download.\r\n"
	  		+ "2) Downloaded file should contain printed map as per changes.");
	  
  }
  
  @Test(priority=88, description="To verify that user is able to set print \"Resolution\".")
  public void SGL_Ranchi_CITYGIS_88() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on  \"Print\" functionality from the top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Print)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select anyone resolution from \"Resolution\" dropdown.");
	  driver.findElement(By.xpath("//div[@class=\"x-toolbar x-small-editor mdright x-toolbar-layout-ct\"]//tr/td[5]/div[@class=\"x-form-field-wrap x-form-field-trigger-wrap\"]//img")).click();
	  Thread.sleep(2000);
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",   driver.findElement(By.xpath("//div[text()=\"150 dpi\"]")));
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on the Print option of the Print Preview pop-up. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_print)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) File should download.\r\n"
	  		+ "2) Downloaded file should contain printed map as per changes.");
	  
  }
  
  @Test(priority=89, description="To verify that user is able to add print \"Title\".")
  public void SGL_Ranchi_CITYGIS_89() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on  \"Print\" functionality from the top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Print)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter title in textbox.");
	  driver.findElement(By.xpath("//input[@name=\"mapTitle\"]")).sendKeys("Testing");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on the Print option of the Print Preview pop-up. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_print)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) File should download.\r\n"
	  		+ "2) Downloaded file should contain printed map as per changes.");
	  
  }
  
  @Test(priority=90, description="To verify that user is able to add print \"Comments\".")
  public void SGL_Ranchi_CITYGIS_90() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on  \"Print\" functionality from the top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Print)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter comments in textbox.");
	  driver.findElement(By.xpath("//textarea[@name=\"mapComment\"]")).sendKeys("Testing");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on the Print option of the Print Preview pop-up. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_print)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) File should download.\r\n"
	  		+ "2) Downloaded file should contain printed map as per changes.");
	  
  }
  
  @Test(priority=91, description="To verify that user is able to change print \"Format\".")
  public void SGL_Ranchi_CITYGIS_91() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on  \"Print\" functionality from the top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Print)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select anyone format from \"Format\" dropdown.");
	  driver.findElement(By.xpath("//div[@class=\"x-toolbar x-small-editor x-form-item mdright x-toolbar-layout-ct\"]//tr/td[2]/div//img")).click();
	  Thread.sleep(2000);
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",   driver.findElement(By.xpath("//div[text()=\"jpg\"]")));
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on the Print option of the Print Preview pop-up. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_print)).click();
	  Thread.sleep(2000);
      ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) File should download.\r\n"
	  		+ "2) Downloaded file should contain printed map as per changes.");
	  
  }
  
  @Test(priority=92, description="To verify that user is change print \"Rotation\" functionality.")
  public void SGL_Ranchi_CITYGIS_92() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on  \"Print\" functionality from the top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Print)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter the angle value in \"Rotation\" field.");
	  driver.findElement(By.xpath("//input[@name=\"rotation\"]")).sendKeys("240");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on the Print option of the Print Preview pop-up. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_print)).click();
	  Thread.sleep(2000);
      ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) File should download.\r\n"
	  		+ "2) Downloaded file should contain printed map as per changes.");
	  
  }
  
  @Test(priority=93, description="To verify that user is change print \"Rotation\" functionality.")
  public void SGL_Ranchi_CITYGIS_93() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on  \"Print\" functionality from the top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Print)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click and check \"Include Legend?\" checkbox.");
	  driver.findElement(By.xpath("//input[@name=\"mapLegend\"]")).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on the Print option of the Print Preview pop-up. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_print)).click();
	  Thread.sleep(2000);
      ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) File should download.\r\n"
	  		+ "2) Downloaded file should contain printed map as per changes.");
	  
  }
  
  @Test(priority=94, description="To verify that user is able to set print \"Area\".")
  public void SGL_Ranchi_CITYGIS_94() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on  \"Print\" functionality from the top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Print)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the print area sizes from area size drop-down.");
	  driver.findElement(By.xpath("//div[@class=\"x-form-element\"]/div//img")).click();
	  Thread.sleep(2000);
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",   driver.findElement(By.xpath("//div[text()=\"1:1,000\"]")));
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on the Print option of the Print Preview pop-up. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_print)).click();
	  Thread.sleep(2000);
      ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) File should download.\r\n"
	  		+ "2) Downloaded file should contain printed map as per changes.");
	  
  }
  
  @Test(priority=95, description="To verify that user is able to perform \"Zoom-In\" in print preview area.")
  public void SGL_Ranchi_CITYGIS_95() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on  \"Print\" functionality from the top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Print)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on the plus(\"+\") icon for \"Zoom-In\".");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",    driver.findElement(By.xpath("//div/div[2]/a[text()=\"+\"]")));
	  executor.executeScript("arguments[0].click();",    driver.findElement(By.xpath("//div/div[2]/a[text()=\"+\"]")));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on the Print option of the Print Preview pop-up. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_print)).click();
	  Thread.sleep(2000);
      ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) File should download.\r\n"
	  		+ "2) Downloaded file should contain printed map as per changes.");
	  
  }
  
  @Test(priority=96, description="To verify that user is able to perform \"Zoom-Out\" in print preview area.")
  public void SGL_Ranchi_CITYGIS_96() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on  \"Print\" functionality from the top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Print)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on the plus(\"-\") icon for \"Zoom-In\".");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",    driver.findElement(By.xpath("//div/div[2]/a[text()=\"−\"]")));
	  executor.executeScript("arguments[0].click();",    driver.findElement(By.xpath("//div/div[2]/a[text()=\"−\"]")));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on the Print option of the Print Preview pop-up. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_print)).click();
	  Thread.sleep(2000);
      ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) File should download.\r\n"
	  		+ "2) Downloaded file should contain printed map as per changes.");
	  
  }
  
  @Test(priority=97, description="To verify that user able to perform close button functionality of \"Print Preview\" dialog.")
  public void SGL_Ranchi_CITYGIS_97() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on  \"Print\" functionality from the top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Print)).click();
	  Thread.sleep(2000);
	  List<WebElement> element1 = driver.findElements(By.xpath("//div[@class=\" x-panel x-hide-display\"]"));
	  System.out.println(element1.size());
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on close button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_close)).click();
	  Thread.sleep(2000);
      ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Print Preview\" dialog should close.");
	  Assert.assertEquals(false,driver.findElement(By.xpath("//div[@class=\" x-panel x-hide-display\"]")).isDisplayed());
  }
  
  @Test(priority=98, description="To verify that user is able to get \"Help\" of the application.")
  public void SGL_Ranchi_CITYGIS_98() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Help\" functionality from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Help)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should navigate on \"Help\" page of the \"Ranchi\" portal.");
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
  
  @Test(priority=99, description="To verify that user is able to perform the \"Search\" functionality from the top panel.")
  public void SGL_Ranchi_CITYGIS_99() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Search\" button from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter the search criteria in search textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Search)).sendKeys("Bank");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Search\" icon or press \"Enter\" button from keyboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search_Icon)).click();
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get searched result in \"Search Result\" data grid at bottom.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.label_Search)).isDisplayed());
  }
  
  @Test(priority=100, description="To verify that user is able to perform \"Location\" functionality from \"Search Result\" data grid.")
  public void SGL_Ranchi_CITYGIS_100() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Search\" button from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter the search criteria in search textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Search)).sendKeys("Bank");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Search\" icon or press \"Enter\" button from keyboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search_Icon)).click();
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Location\" button.");
	  driver.findElement(By.xpath("//tr[2]/td/button[@title=\"Click on GPS\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get pin-point on landmark on map with specific zoom-level.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.img_Pin_point)).isDisplayed());
  }
  
  @Test(priority=101, description="To verify that user able to perform \"Search\" functionality in \"Search Result\" data grid.")
  public void SGL_Ranchi_CITYGIS_101() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Search\" button from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter the search criteria in search textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Search)).sendKeys("Bank");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Search\" icon or press \"Enter\" button from keyboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search_Icon)).click();
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter text in \"Search\" text-box of grid.");
	  driver.findElement(By.xpath("//label/input[@type=\"search\"]")).sendKeys("Mahatma Gandhi");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get only filtered searched record(s) in grid.");
	  String aa = driver.findElement(By.xpath("//table[@aria-describedby=\"example_info\"]//tr[1]/td[4]/span")).getText();
	  System.out.print(aa);
	  Assert.assertEquals(true, aa.contains("Mahatma Gandhi") );
  }
  
  @Test(priority=102, description="To verify that user able to change \"No of entries\" functionality in one page in \"Search Result\" data grid.")
  public void SGL_Ranchi_CITYGIS_102() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Search\" button from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter the search criteria in search textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Search)).sendKeys("Bank");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Search\" icon or press \"Enter\" button from keyboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search_Icon)).click();
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select option from the \"Show entries\" drop-down.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@name=\"example_length\"]")));  
	  dropdown.selectByValue("20"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get no. of entries as per selected option in one page.");
	  List<WebElement> element = driver.findElements(By.xpath("//table[@aria-describedby=\"example_info\"]//tr/td[4]/span"));
	  System.out.println(element.size());
	  Assert.assertEquals(20, element.size() );
  }
  
  @Test(priority=103, description="To verify that user able to perform pagination functionality of \"Search Result\" data grid.")
  public void SGL_Ranchi_CITYGIS_103(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Search\" button from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter the search criteria in search textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Search)).sendKeys("Bank");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Search\" icon or press \"Enter\" button from keyboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search_Icon)).click();
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Next\", \"Previous\" and \"Page no.\" button from data grid.");
	  driver.findElement(By.xpath("//a[text()=\"Next\"]")).click();  
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect to next, previous and selected page no. in data grid.");
	  String aa = driver.findElement(By.xpath("//div[@id=\"example_info\"]")).getText();
	  System.out.println(aa);
	  Assert.assertEquals(true, aa.contains("Showing 5 to 8 of 73 entries") );
	  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Next\", \"Previous\" and \"Page no.\" button from data grid.");
	  driver.findElement(By.xpath("//a[text()=\"Previous\"]")).click();  
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect to next, previous and selected page no. in data grid.");
	  String a1 = driver.findElement(By.xpath("//div[@id=\"example_info\"]")).getText();
	  System.out.println(a1);
	  Assert.assertEquals(true, a1.contains("Showing 1 to 4 of 73 entries") );
	  objs.Screenshot(driver, Classname ,method.getName()+"_"+2 );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Next\", \"Previous\" and \"Page no.\" button from data grid.");
	  driver.findElement(By.xpath("//a[text()=\"3\"]")).click();  
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect to next, previous and selected page no. in data grid.");
	  String a2 = driver.findElement(By.xpath("//div[@id=\"example_info\"]")).getText();
	  System.out.println(a2);
	  Assert.assertEquals(true, a2.contains("Showing 9 to 12 of 73 entries") );
  }
  
  @Test(priority=104, description="To verify that user able to perform the \"Sorting\" functionality of col. in \"Search Result\" data grid.")
  public void SGL_Ranchi_CITYGIS_104(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Search\" button from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter the search criteria in search textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Search)).sendKeys("Bank");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Search\" icon or press \"Enter\" button from keyboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search_Icon)).click();
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on descending/ascending shorting order of col. from grid.");
	  ArrayList<String> datasetcount = new ArrayList<String>();
	  List<WebElement> element1 = driver.findElements(By.xpath("//tr/td[3]/p/a"));
	  System.out.println(element1.size());
	  for(int i =0; i<element1.size(); i++) {
		  datasetcount.add(element1.get(i).getText());
		  Thread.sleep(1000);
	  } 
	  System.out.println(datasetcount);
	  driver.findElement(By.xpath("//th[text()=\"Name\"]")).click();  
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the record(s) in descending/ascending shorting order as per selection.");
	  ArrayList<String> datasetcount1 = new ArrayList<String>();
	  List<WebElement> element2 = driver.findElements(By.xpath("//tr/td[3]/p/a"));
	  System.out.println(element2.size());
	  for(int i =0; i<element2.size(); i++) {
		  datasetcount1.add(element2.get(i).getText());
		  Thread.sleep(1000);
	  } 
	  System.out.println(datasetcount1);
	  Assert.assertNotEquals(datasetcount, datasetcount1);
	  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on descending/ascending shorting order of col. from grid.");
	  driver.findElement(By.xpath("//th[text()=\"Name\"]")).click();  
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the record(s) in descending/ascending shorting order as per selection.");
	  ArrayList<String> datasetcount2 = new ArrayList<String>();
	  List<WebElement> element3 = driver.findElements(By.xpath("//tr/td[3]/p/a"));
	  System.out.println(element3.size());
	  for(int i =0; i<element3.size(); i++) {
		  datasetcount2.add(element3.get(i).getText());
		  Thread.sleep(1000);
	  } 
	  System.out.println(datasetcount2);
	  Assert.assertNotEquals(datasetcount1, datasetcount2);
  }
  
  @Test(priority=105, description="To verify collapse/expand functionalities of \"Search Result\" data grid.")
  public void SGL_Ranchi_CITYGIS_105(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Search\" button from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter the search criteria in search textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Search)).sendKeys("Bank");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Search\" icon or press \"Enter\" button from keyboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search_Icon)).click();
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on collapse/expand button.");
	  driver.findElement(By.xpath("//div[@id=\"GridModalDialog\"]//button[@class=\"collapse\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Searched Result\" grid should collapse/expand as per selection.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"dialog grid-data table-data full-width modalactive expand-top collapse-dialog-bottom\"]")).isDisplayed());
	  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on collapse/expand button.");
	  driver.findElement(By.xpath("//div[@id=\"GridModalDialog\"]//button[@class=\"collapse\"]")).click();  
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Searched Result\" grid should collapse/expand as per selection.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"dialog grid-data table-data full-width modalactive expand-top collapse-dialog-top\"]")).isDisplayed());
  }
  
  @Test(priority=106, description="To verify close functionality of \"Search Result\" data grid.")
  public void SGL_Ranchi_CITYGIS_106(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Search\" button from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter the search criteria in search textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Search)).sendKeys("Bank");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Search\" icon or press \"Enter\" button from keyboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search_Icon)).click();
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on collapse/expand button.");
	  driver.findElement(By.xpath("//div[@id=\"GridModalDialog\"]//button[@class=\"collapse\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Searched Result\" grid should collapse/expand as per selection.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"dialog grid-data table-data full-width modalactive expand-top collapse-dialog-bottom\"]")).isDisplayed());
	  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on close button.");
	  driver.findElement(By.xpath("//button[@class=\"tool-items pull-right minus frm-close\"]")).click();  
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Searched Result\" grid should collapse/expand as per selection.");
	  Assert.assertEquals(false, driver.findElement(By.xpath("//div[@class=\"dialog grid-data table-data full-width close-dialog-bottom\"]")).isDisplayed());
  }
  
  @Test(priority=107, description="To verify close functionality of \"Search Result\" data grid.")
  public void SGL_Ranchi_CITYGIS_107() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Search\" button from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter the search criteria in search textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Search)).sendKeys("Bank");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Search\" icon or press \"Enter\" button from keyboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search_Icon)).click();
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Copy\" button.");
	  driver.findElement(By.xpath("//span[text()=\"Copy\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Text presents in \"Search Result\" data grid should \"COPY TO CLIPBOARD\".");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@id=\"datatables_buttons_info\"]")).isDisplayed());
  }
  
  @Test(priority=108, description="To verify \"Excel\" functionality of \"Search Result\" data grid.")
  public void SGL_Ranchi_CITYGIS_108() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Search\" button from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter the search criteria in search textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Search)).sendKeys("Bank");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Search\" icon or press \"Enter\" button from keyboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search_Icon)).click();
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Excel\" button.");
	  File file = new File("C:\\Users\\meet.g\\Downloads");
	  for (File file1:file.listFiles() )
		  { 
		  if(file1.getName().startsWith("Query Result")&& file1.getName().endsWith(".xlsx"))
			  {
			  file1.delete();
			  }
		  }
	  driver.findElement(By.xpath("//span[text()=\"Excel\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Excel file should downloaded with all the present data of \"Search Result\" grid information.");
	  File f = new File("C:\\Users\\meet.g\\Downloads\\Query Result.xlsx"); 
	  Assert.assertEquals(true,  f.exists());
  }
  
  @Test(priority=109, description="To verify \"PDF\" functionality of \"Search Result\" data grid.")
  public void SGL_Ranchi_CITYGIS_109() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Search\" button from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter the search criteria in search textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Search)).sendKeys("Bank");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Search\" icon or press \"Enter\" button from keyboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search_Icon)).click();
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"PDF\" button.");
	  File file = new File("C:\\Users\\meet.g\\Downloads");
	  for (File file1:file.listFiles() )
		  { 
		  if(file1.getName().startsWith("Query Result")&& file1.getName().endsWith(".pdf"))
			  {
			  file1.delete();
			  }
		  }
	  driver.findElement(By.xpath("//span[text()=\"PDF\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> PDF file should downloaded with all the present data of \"Search Result\" grid information.");
	  File f = new File("C:\\Users\\meet.g\\Downloads\\Query Result.pdf"); 
	  Assert.assertEquals(true,  f.exists());
  }
  
  @Test(priority=110, description="To verify \"CSV\" functionality of \"Search Result\" data grid.")
  public void SGL_Ranchi_CITYGIS_110() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Search\" button from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter the search criteria in search textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Search)).sendKeys("Bank");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Search\" icon or press \"Enter\" button from keyboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search_Icon)).click();
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"CSV\" button.");
	  File file = new File("C:\\Users\\meet.g\\Downloads");
	  for (File file1:file.listFiles() )
		  { 
		  if(file1.getName().startsWith("Query Result")&& file1.getName().endsWith(".csv"))
			  {
			  file1.delete();
			  }
		  }
	  driver.findElement(By.xpath("//span[text()=\"CSV\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> CSV file should downloaded with all the present data of \"Search Result\" grid information.");
	  File f = new File("C:\\Users\\meet.g\\Downloads\\Query Result.csv"); 
	  Assert.assertEquals(true,  f.exists());
  }
  
  @Test(priority=111, description="To verify \"Column Visibility\" functionality of \"Search Result\" data grid.")
  public void SGL_Ranchi_CITYGIS_111() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Search\" button from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter the search criteria in search textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Search)).sendKeys("Bank");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Search\" icon or press \"Enter\" button from keyboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search_Icon)).click();
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Column Visibility\" button and select/deselect displayed column.");
	  List<WebElement> element1 = driver.findElements(By.xpath("//tr/th"));
	  System.out.println(element1.size());
	  driver.findElement(By.xpath("//span[text()=\"Column visibility\"]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//span[text()=\"Layer Name\"]")).click();	
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> As per selection/unselecting of columns should be display in \"Search Result\" data grid or not.");
	  List<WebElement> element2 = driver.findElements(By.xpath("//tr/th"));
	  System.out.println(element2.size());
	  Assert.assertNotEquals(element1.size(),element2.size());
  }
  
  @Test(priority=112, description="To verify that user is able to perform the \"Full Screen\" functionality of \"Search Result\" data grid.")
  public void SGL_Ranchi_CITYGIS_112() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Search\" button from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter the search criteria in search textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Search)).sendKeys("Bank");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Search\" icon or press \"Enter\" button from keyboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search_Icon)).click();
	  Thread.sleep(10000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Full Screen\" icon of \"Search Result\" data grid.");
	  driver.findElement(By.xpath("//button[@onclick=\"gridscreenfull();\"]")).click();
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get \"Search Result\" data grid on full screen mode.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"dialog grid-data table-data full-width modalactive expand-top full-screen\"]")).isDisplayed());
  }
  
  @Test(priority=113, description="To verify that user is not able to perform \"Search\" functionality with blank text box.")
  public void SGL_Ranchi_CITYGIS_113() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on \"Search\" button from top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter the search criteria in search textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Search)).sendKeys("");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Search\" icon or press \"Enter\" button from keyboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search_Icon)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> To verify that user is not able to perform \"Search\" functionality with blank text box.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Please enter search text\"]")).isDisplayed());
  }
  
  @Test(priority=114, description="To verify that user is able to perform \"Collapse/Expand\" functionality of top panel.")
  public void SGL_Ranchi_CITYGIS_114(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon.");
	  driver.findElement(By.xpath("//ul/div[@class=\"btn-collapse\"]/a")).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Top panel\" should collapse/expand as per selection.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//ul[@class=\"list-inline nav-top modalinactive close-dialog-top\"]")).isDisplayed());
	  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon.");
	  driver.findElement(By.xpath("//ul/div[@class=\"btn-collapse\"]/a")).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Top panel\" should collapse/expand as per selection.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//ul[@class=\"list-inline nav-top modalactive expand-bottom\"]")).isDisplayed());
  }
  
  @Test(priority=115, description="To verify that user get the \"GIS INFOGRAPHICS\".")
  public void SGL_Ranchi_CITYGIS_115() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(8000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the \"GIS INFOGRAPHICS\" functionalities like:\r\n"
	  		+ "i.Around Me\r\n"
	  		+ "ii.Landmarks\r\n"
	  		+ "iii.Ward Information\r\n"
	  		+ "iv.Find Direction\r\n"
	  		+ "v.Send Map through Email\r\n"
	  		+ "vi.Statistical Information");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//aside[@id=\"modalDeptDashboard\"]")).isDisplayed());
  }
  
  @Test(priority=116, description="To verify that user is able to perform collapse/expand functionality for \"GIS INFOGRAPHICS\".")
  public void SGL_Ranchi_CITYGIS_116(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(8000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get collapse/expand mode of \"GIS INFOGRAPHICS\".");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//aside[@id=\"modalDeptDashboard\"]")).isDisplayed());
	  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get collapse/expand mode of \"GIS INFOGRAPHICS\".");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//aside[@class=\"dashboard col-sm-2 pull-right modalinactive collapse-right\"]")).isDisplayed());
  }
  
  @Test(priority=117, description="To verify that user is able to perform collapse/expand functionality for \"Around Me\".")
  public void SGL_Ranchi_CITYGIS_117(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Around Me\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Around_Me)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Around Me\" functionality should be expands and display following list of functionalities like :\r\n"
	  		+ "i.Emergency Services\r\n"
	  		+ "ii.Tourist Attraction\r\n"
	  		+ "iii.Fun & Entertainment");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//ul[@class=\"child collapse show\"]")).isDisplayed());
	  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Again click on \"Around Me\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Around_Me)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get collapse mode of \"Around Me\".");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//a[@class=\"collapsed\" and @id=\"aroundme\"]")).isDisplayed());
  }
  
  @Test(priority=118, description="To verify that user is able to perform \"Emergency Services\" functionality from \"Around Me\" section.")
  public void SGL_Ranchi_CITYGIS_118() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Around Me\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Around_Me)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Emergency Services\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Emergency_services)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"OK\" button from suggestion popup and click on map.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Ok)).click();
	  Thread.sleep(4000);		 
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the \"Detailed Result\" dialog with list of nearest \"Emergency Services\".");
	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.label_Detailed_Result)).isDisplayed());
  }
  
  @Test(priority=119, description="To verify that user is able to get \"More\" detail dialog for particular \"Emergency Services\".")
  public void SGL_Ranchi_CITYGIS_119() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Around Me\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Around_Me)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Emergency Services\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Emergency_services)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"OK\" button from suggestion popup and click on map.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Ok)).click();
	  Thread.sleep(4000);		 
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on (+) icon for particular services.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result_WI)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"More\" button for particular records.");
	  driver.findElement(By.xpath(City_GIS_R.btn_More_Detailed_Result)).click();
	  Thread.sleep(4000);
      ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get more details related to record in \"Detailed Result\" dialog.");
	  Assert.assertEquals("overflow-y: auto; height: 500px;", driver.findElement(By.xpath("//div[@id=\"landmarkdetailresultdetail\"]")).getAttribute("style"));
  }
  
  @Test(priority=120, description="To verify that user is able to perform back button functionality of more details dialog.")
  public void SGL_Ranchi_CITYGIS_120() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Around Me\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Around_Me)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Emergency Services\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Emergency_services)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"OK\" button from suggestion popup and click on map.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Ok)).click();
	  Thread.sleep(4000);		 
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on (+) icon for particular services.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result_WI)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"More\" button for particular records.");
	  driver.findElement(By.xpath(City_GIS_R.btn_More_Detailed_Result)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on back(\"<-\") icon from the more detail pop-up.");
	  driver.findElement(By.xpath(City_GIS_R.btn_back)).click();
	  Thread.sleep(4000);
      ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect to the list of the records in \"Detailed Result\" dialog.");
	  Assert.assertEquals("none", driver.findElement(By.xpath("//div[@id=\"landmarkdetailresultdetail\"]")).getCssValue("display"));
  }
  
  @Test(priority=121, description="To verify that user is able to perform \"Distance\" functionality from \"Detailed Result\" dialog.")
  public void SGL_Ranchi_CITYGIS_121() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Around Me\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Around_Me)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Emergency Services\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Emergency_services)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"OK\" button from suggestion popup and click on map.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Ok)).click();
	  Thread.sleep(4000);		 
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on (+) icon for particular services.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result_WI)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Distance button of the particular service. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Distance_Detailed_Result)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the direction as a shortest path between user location and data record location on map.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div/div/div/img[@class=\"olAlphaImg\" and @src=\"/Commonwidget/ranchi_wd/images/redpin.png\"]")).isDisplayed());
  }
  
  @Test(priority=122, description="To verify that user is able to collapse/expand \"Detailed Result\" pop-up of \"Emergency Services\" functionality.")
  public void SGL_Ranchi_CITYGIS_122(Method method) throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Around Me\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Around_Me)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Emergency Services\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Emergency_services)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"OK\" button from suggestion popup and click on map.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Ok)).click();
	  Thread.sleep(4000);		 
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on collapse button of \"Detailed Result\" dialog.");
	  driver.findElement(By.xpath(City_GIS_R.btn_collapse_Detailed_Result_WI)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get \"Detailed Result\" dialog in collapse mode.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result_WI1)).isDisplayed());
	  Thread.sleep(4000);
	  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on expand button of \"Detailed Result\" dialog.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result_WI1)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get \"Detailed Result\" dialog in expand mode.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.btn_collapse_Detailed_Result_WI)).isDisplayed());
  }
  
  @Test(priority=123, description="To verify that user is able to close \"Detailed Result\" pop-up.")
  public void SGL_Ranchi_CITYGIS_123() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Around Me\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Around_Me)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Emergency Services\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Emergency_services)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"OK\" button from suggestion popup and click on map.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Ok)).click();
	  Thread.sleep(4000);		 
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on close button of \"Detailed Result\" dialog.");
	  driver.findElement(By.xpath(City_GIS_R.btn_close_Detailed_Result_WI1)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Detailed Result\" dialog should close.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//aside[@class=\"dialog col-sm-12 pull-right second-modal-dialog modalinactive close-dialog-right\"]")).isDisplayed());
  }
  
  @Test(priority=124, description="To verify that user is able to perform \"Tourist Attraction\" functionality from \"Around Me\" section.")
  public void SGL_Ranchi_CITYGIS_124() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Around Me\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Around_Me)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Tourist Attraction\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tourist_Attraction)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"OK\" button from suggestion popup and click on map.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Ok)).click();
	  Thread.sleep(4000);		 
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the \"Detailed Result\" dialog with list of nearest \"Tourist Attraction\".");
	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.label_Detailed_Result)).isDisplayed());
  }
  
  @Test(priority=125, description="To verify that user is able to get \"More\" detail dialog for particular \"Tourist Attraction\".")
  public void SGL_Ranchi_CITYGIS_125() throws InterruptedException, AWTException {
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Around Me\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Around_Me)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Tourist Attraction\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tourist_Attraction)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"OK\" button from suggestion popup and click on map.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Ok)).click();
	  Thread.sleep(4000);		 
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on (+) icon for particular services.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result_TA)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"More\" button for particular records.");
	  driver.findElement(By.xpath(City_GIS_R.btn_More_Detailed_Result)).click();
	  Thread.sleep(4000);
      ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get more details related to record in \"Detailed Result\" dialog.");
	  Assert.assertEquals("overflow-y: auto; height: 500px;", driver.findElement(By.xpath("//div[@id=\"landmarkdetailresultdetail\"]")).getAttribute("style"));
  }
  
  @Test(priority=126, description="To verify that user is able to perform \"Distance\" functionality from \"Detailed Results\" dialog.")
  public void SGL_Ranchi_CITYGIS_126() throws InterruptedException, AWTException {
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Around Me\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Around_Me)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Tourist Attraction\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tourist_Attraction)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"OK\" button from suggestion popup and click on map.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Ok)).click();
	  Thread.sleep(4000);		 
	  Robot robot = new Robot();
	  robot.mouseMove(1000,400);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on (+) icon for particular services.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result_TA)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Distance button of the particular service. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Distance_Detailed_Result)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the direction as a shortest path between user location and data record location on map.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div/div/div/img[@class=\"olAlphaImg\" and @src=\"/Commonwidget/ranchi_wd/images/redpin.png\"]")).isDisplayed());
  }
  
  @Test(priority=127, description="To verify that user is able to perform pagination functionality of \"Detailed Result\" dialog ")
  public void SGL_Ranchi_CITYGIS_127() throws InterruptedException, AWTException {
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Around Me\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Around_Me)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Tourist Attraction\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tourist_Attraction)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"OK\" button from suggestion popup and click on map.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Ok)).click();
	  Thread.sleep(4000);		 
	  Robot robot = new Robot();
	  robot.mouseMove(1000,400);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on (+) icon for particular services.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result_TA)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on next(\">\")/previous(\"<\") icon. ");
	  driver.findElement(By.xpath("//button[@onclick=\"getNextResultSet(this)\"]")).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect to the next /previous page of \"Detailed Result\" dialog.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//h3[text()=\"Records 4 To 6\"]")).isDisplayed());
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on next(\">\")/previous(\"<\") icon. ");
      driver.findElement(By.xpath("//button[@onclick=\"getPrevResultSet(this)\"]")).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect to the next /previous page of \"Detailed Result\" dialog.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//h3[text()=\"Records 1 To 3\"]")).isDisplayed());
  }
  
  @Test(priority=128, description="To verify that user is able to perform \"Fun & Entertainment\" functionality from \"Around Me\" section.")
  public void SGL_Ranchi_CITYGIS_128() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Around Me\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Around_Me)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Fun & Entertainment\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_fun_entertainment)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"OK\" button from suggestion popup and click on map.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Ok)).click();
	  Thread.sleep(4000);		 
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the \"Detailed Result\" dialog with list of nearest \"Fun & Entertainment\"..");
	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.label_Detailed_Result)).isDisplayed());
  }
  
  @Test(priority=129, description="To verify that user is able to get \"More\" detail dialog for particular \"Fun & Entertainment\".")
  public void SGL_Ranchi_CITYGIS_129() throws InterruptedException, AWTException {
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Around Me\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Around_Me)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Fun & Entertainment\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_fun_entertainment)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"OK\" button from suggestion popup and click on map.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Ok)).click();
	  Thread.sleep(4000);		 
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on (+) icon for particular services.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result_FAE)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"More\" button for particular records.");
	  driver.findElement(By.xpath(City_GIS_R.btn_More_Detailed_Result)).click();
	  Thread.sleep(4000);
      ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get more details related to record in \"Detailed Result\" dialog.");
	  Assert.assertEquals("overflow-y: auto; height: 500px;", driver.findElement(By.xpath("//div[@id=\"landmarkdetailresultdetail\"]")).getAttribute("style"));
  }
  
  @Test(priority=130, description="To verify that user is able to perform \"Distance\" functionality from \"Detailed Results\" dialog.")
  public void SGL_Ranchi_CITYGIS_130() throws InterruptedException, AWTException {
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Around Me\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Around_Me)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Fun & Entertainment\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_fun_entertainment)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"OK\" button from suggestion popup and click on map.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Ok)).click();
	  Thread.sleep(4000);		 
	  Robot robot = new Robot();
	  robot.mouseMove(1000,400);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on (+) icon for particular services.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result_FAE)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Distance button of the particular service. ");
	  driver.findElement(By.xpath("//ul/li[1]/div/a[@data-backendlayer=\"landmark_Restaurant\" and text()=\" Distance\"]")).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the direction as a shortest path between user location and data record location on map.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div/div/div/img[@class=\"olAlphaImg\" and @src=\"/Commonwidget/ranchi_wd/images/redpin.png\"]")).isDisplayed());
  }
  
  @Test(priority=131, description="To verify that user is able to perform \"Landmarks\" functionality for \"Select by My Location\" option.")
  public void SGL_Ranchi_CITYGIS_131() throws InterruptedException, AWTException {
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Landmarks\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click and check particular checkbox of landmark from the \"Landmark\" list.");
	  driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Next\" Button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select \"Select by My Location\" option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select anyone distance option from drop-down of \"Select by My Location\".");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"txtlandmarkbuffer\"]")));  
	  dropdown.selectByValue("3");  
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Go\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Landmark)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"OK\" button from suggestion popup and click on map");
	  driver.findElement(By.xpath("//button[text()=\"OK\"]")).click();
	  Thread.sleep(2000);
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
      ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) Buffer should draw on map as per value selected in buffer value textbox.\r\n"
	  		+ "2) User should get \"Detailed Result\" dialo");
	  Assert.assertEquals("1000 m", driver.findElement(By.xpath("//div[@class=\"olControlScaleLineTop\"]")).getText());
	  Assert.assertEquals(true,driver.findElement(By.xpath(City_GIS_R.label_Detailed_Result)).isDisplayed());
  }
  
  @Test(priority=132, description="To verify that user is able to perform \"Clear\" functionality from landmarks.")
  public void SGL_Ranchi_CITYGIS_132() throws InterruptedException, AWTException {
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Landmarks\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click and check particular checkbox of landmark from the \"Landmark\" list.");
	  driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Next\" Button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Clear\" option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Clear)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Landmark checkbox should be resets.");
	  Assert.assertEquals(false, driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).isSelected());
  }
  
  @Test(priority=133, description="To verify that user is able to perform \"More\" functionality from  landmarks \"Detailed Result\" dialog.")
  public void SGL_Ranchi_CITYGIS_133() throws InterruptedException, AWTException {
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Landmarks\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click and check particular checkbox of landmark from the \"Landmark\" list.");
	  driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Next\" Button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select \"Select by My Location\" option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select anyone distance option from drop-down of \"Select by My Location\".");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"txtlandmarkbuffer\"]")));  
	  dropdown.selectByValue("3");  
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Go\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Landmark)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"OK\" button from suggestion popup and click on map");
	  driver.findElement(By.xpath("//button[text()=\"OK\"]")).click();
	  Thread.sleep(2000);
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on Plus(+) icon to expand list of landmark details popup.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Click on 'More' button of the particular landmark.");
	  driver.findElement(By.xpath(City_GIS_R.btn_More_Detailed_Result)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the more details regarding particular Landmark.");
	  Assert.assertEquals("overflow-y: auto; height: 500px;", driver.findElement(By.xpath("//div[@id=\"landmarkdetailresultdetail\"]")).getAttribute("style"));
  }
  
  @Test(priority=134, description="To verify that user is able to perform \"Back\" functionality from  landmarks \"Detailed Result\" dialog..")
  public void SGL_Ranchi_CITYGIS_134() throws InterruptedException, AWTException {
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Landmarks\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click and check particular checkbox of landmark from the \"Landmark\" list.");
	  driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Next\" Button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select \"Select by My Location\" option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select anyone distance option from drop-down of \"Select by My Location\".");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"txtlandmarkbuffer\"]")));  
	  dropdown.selectByValue("3");  
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Go\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Landmark)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"OK\" button from suggestion popup and click on map");
	  driver.findElement(By.xpath("//button[text()=\"OK\"]")).click();
	  Thread.sleep(2000);
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on Plus(+) icon to expand list of landmark details popup.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Click on 'More' button of the particular landmark.");
	  driver.findElement(By.xpath(City_GIS_R.btn_More_Detailed_Result)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14:</b> Click on (<-) icon.");
	  driver.findElement(By.xpath("//div[@class=\"close\"]/button/i[@class=\"fa fa-arrow-left\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect to list of \"Landmarks\".");
	  Assert.assertEquals("none", driver.findElement(By.xpath("//div[@id=\"landmarkdetailresultdetail\"]")).getCssValue("display"));
  }
  
  @Test(priority=135, description="To verify that user is able to collapse/expand more \"Detailed Result\" popup of the landmarks.")
  public void SGL_Ranchi_CITYGIS_135(Method method) throws InterruptedException, AWTException {
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Landmarks\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click and check particular checkbox of landmark from the \"Landmark\" list.");
	  driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Next\" Button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select \"Select by My Location\" option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select anyone distance option from drop-down of \"Select by My Location\".");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"txtlandmarkbuffer\"]")));  
	  dropdown.selectByValue("3");  
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Go\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Landmark)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"OK\" button from suggestion popup and click on map");
	  driver.findElement(By.xpath("//button[text()=\"OK\"]")).click();
	  Thread.sleep(2000);
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on Minus(-) icon.");
	  driver.findElement(By.xpath("//aside[@id=\"modalNearbyquery\"]/form/div/div[@class=\"close\"]//button[@class=\"collapse\"]/i[@class=\"fa fa-minus\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get more \"Detailed Result\" popup in collapse mode.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//form[@class=\"needs-validation clscmnshowhide box ui-draggable collapsed-box\"]")).isDisplayed());
	  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Click on Plus(+) icon.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_More_Result)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get more \"Detailed Result\" popup in expanded mode.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//form[@class=\"needs-validation clscmnshowhide box ui-draggable\"]")).isDisplayed());
  }
  
  @Test(priority=136, description="To verify that user is able to close \"Detailed Result\" pop-up.")
  public void SGL_Ranchi_CITYGIS_136() throws InterruptedException, AWTException {
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Landmarks\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click and check particular checkbox of landmark from the \"Landmark\" list.");
	  driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Next\" Button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select \"Select by My Location\" option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select anyone distance option from drop-down of \"Select by My Location\".");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"txtlandmarkbuffer\"]")));  
	  dropdown.selectByValue("3");  
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Go\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Landmark)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"OK\" button from suggestion popup and click on map");
	  driver.findElement(By.xpath("//button[text()=\"OK\"]")).click();
	  Thread.sleep(2000);
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on close(X) icon of \"Detailed Result\" pop-up.");
	  driver.findElement(By.xpath("//aside[@id=\"modalNearbyquery\"]/form/div/div[@class=\"close\"]//button[@class=\"frm-close\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Detailed Result\" dialog should close.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//aside[@class=\"dialog col-sm-12 pull-right second-modal-dialog modalinactive close-dialog-right\"]")).isDisplayed());
  }
  
  @Test(priority=137, description="To verify that user is able to perform \"Distance\" functionality from \"Detailed Results\" dialog.")
  public void SGL_Ranchi_CITYGIS_137() throws InterruptedException, AWTException {
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Landmarks\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click and check particular checkbox of landmark from the \"Landmark\" list.");
	  driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Next\" Button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select \"Select by My Location\" option.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select anyone distance option from drop-down of \"Select by My Location\".");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"txtlandmarkbuffer\"]")));  
	  dropdown.selectByValue("3");  
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Go\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Landmark)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on \"OK\" button from suggestion popup and click on map");
	  driver.findElement(By.xpath("//button[text()=\"OK\"]")).click();
	  Thread.sleep(2000);
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on Plus(+) icon to expand list of landmark details popup.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Click on 'Distance' button.");
	  driver.findElement(By.xpath("//ul/li[1]/div/a[@data-backendlayer=\"landmark_Bank\" and text()=\" Distance\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the direction as a shortest path between user location and data record location on map.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div/div/div/img[@class=\"olAlphaImg\" and @src=\"/Commonwidget/ranchi_wd/images/redpin.png\"]")).isDisplayed());
  }
  
  @Test(priority=138, description="To verify that user is able to perform \"Landmarks\" functionality for \"Select by Ward Number\" option.")
  public void SGL_Ranchi_CITYGIS_138() throws InterruptedException, AWTException {
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Landmarks\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click and check particular checkbox of landmark from the \"Landmark\" list.");
	  driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Next\" Button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select \"Select by Ward Number\" radiobutton.");
	  driver.findElement(By.xpath("//input[@id=\"landmarkrdbyBoundary\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select the Ward Number from drop-down.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlBoundaryvalue\"]")));  
	  dropdown.selectByValue("39");  
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Go\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Landmark)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) Selected ward should be highlighted on map.\r\n"
	  		+ "2) User should get \"Detailed Result\" dialog.");
	  Assert.assertEquals("1000 m", driver.findElement(By.xpath("//div[@class=\"olControlScaleLineTop\"]")).getText());
	  Assert.assertEquals(true,driver.findElement(By.xpath(City_GIS_R.label_Detailed_Result)).isDisplayed());
  }
  
  @Test(priority=139, description="To verify that user is able to perform \"More\" functionality from landmarks \"Detailed Result\" dialog.")
  public void SGL_Ranchi_CITYGIS_139() throws InterruptedException, AWTException {
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Landmarks\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click and check particular checkbox of landmark from the \"Landmark\" list.");
	  driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Next\" Button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select \"Select by Ward Number\" radiobutton.");
	  driver.findElement(By.xpath("//input[@id=\"landmarkrdbyBoundary\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select the Ward Number from drop-down.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlBoundaryvalue\"]")));  
	  dropdown.selectByValue("39");  
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Go\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Landmark)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on Plus(+) icon to expand list of landmark details popup.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on 'More' button of the particular landmark.");
	  driver.findElement(By.xpath(City_GIS_R.btn_More_Detailed_Result)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get more details related to record in \"Detailed Result\" dial");
	  Assert.assertEquals("overflow-y: auto; height: 500px;", driver.findElement(By.xpath("//div[@id=\"landmarkdetailresultdetail\"]")).getAttribute("style"));
  }
  
  @Test(priority=140, description="To verify that user is able to perform \"Distance\" functionality from landmarks \"Detailed Result\" dialog.")
  public void SGL_Ranchi_CITYGIS_140() throws InterruptedException, AWTException {
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Landmarks\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click and check particular checkbox of landmark from the \"Landmark\" list.");
	  driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Next\" Button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select \"Select by Ward Number\" radiobutton.");
	  driver.findElement(By.xpath("//input[@id=\"landmarkrdbyBoundary\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select the Ward Number from drop-down.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlBoundaryvalue\"]")));  
	  dropdown.selectByValue("39");  
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on \"Go\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Landmark)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Click on Plus(+) icon to expand list of landmark details popup.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on 'Distance' button.");
	  driver.findElement(By.xpath("//ul/li[1]/div/a[@data-backendlayer=\"landmark_Bank\" and text()=\" Distance\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Click on \"OK\" button from suggestion popup and click on map for location of the user.");
	  driver.findElement(By.xpath("//button[text()=\"OK\"]")).click();
	  Thread.sleep(2000);
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("//ul/li[1]/div/a[@data-backendlayer=\"landmark_Bank\" and text()=\" Distance\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the direction as a shortest path between user location and data record location on map.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div/div/div/img[@class=\"olAlphaImg\" and @src=\"/Commonwidget/ranchi_wd/images/redpin.png\"]")).isDisplayed());
  }
  
  @Test(priority=141, description="To verify that user is not able to perform \"Landmarks\" functionality without select in any landmarks.")
  public void SGL_Ranchi_CITYGIS_141() throws InterruptedException {
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Landmarks\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on \"Next\" Button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation massage like\r\n"
	  		+ "\"Please select atleast one Landmark.\"");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Please select atleast one Landmark.\"]")).isDisplayed());
  }
  
  @Test(priority=142, description="To verify that user is not able to perform \"Landmarks\" functionality without select the \"Select by My Location\" functionality.")
  public void SGL_Ranchi_CITYGIS_142() throws InterruptedException {
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Landmarks\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click and check particular checkbox of landmark from the \"Landmark\" list.");
	  driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Next\" Button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on \"Go\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Landmark)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation massage like \"Please Enter Buffer Value between 1 to 10 km\"");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Please Enter Buffer Value between 1 to 10 km\"]")).isDisplayed());
  }
  
  @Test(priority=143, description="To verify that user is not able to perform \"Landmarks\" functionality without select the \"Select by Ward Number\" functionality.")
  public void SGL_Ranchi_CITYGIS_143() throws InterruptedException {
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Landmarks\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click and check particular checkbox of landmark from the \"Landmark\" list.");
	  driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on \"Next\" Button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select \"Select by Ward Number\" radiobutton.");
	  driver.findElement(By.xpath("//input[@id=\"landmarkrdbyBoundary\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on \"Go\" button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Landmark)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation massage like\r\n"
	  		+ "\"Please Select by Ward Number\".");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Please select ward number\"]")).isDisplayed());
  }
  
  @Test(priority=144, description="To verify that user is able to perform \"Ward Information\" functionality.")
  public void SGL_Ranchi_CITYGIS_144() throws InterruptedException {
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Ward Information\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Ward_Information)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select by Ward Number from the \"Ward Number\" drop-down list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlWardname\"]")));  
	  dropdown.selectByValue("10"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Go option. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Ward_Inf)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1) \"Ward Information\" dialog should open.\r\n"
	  		+ "2) Selected \"Ward Number\" should highlighted on center of map.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.label_Ward_Information)).isDisplayed());
  }
  
  @Test(priority=145, description="To verify that user is able to perform collapse/expand functionality of \"Ward Information\" dialog.")
  public void SGL_Ranchi_CITYGIS_145(Method method) throws InterruptedException {
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Ward Information\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Ward_Information)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select by Ward Number from the \"Ward Number\" drop-down list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlWardname\"]")));  
	  dropdown.selectByValue("10"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Go option. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Ward_Inf)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on expand/collapse button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_collapse_Ward_Inf)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Ward Information\" dialog should collapse/expand as per selection.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.btn_expand_Ward_Inf)).isDisplayed());
	  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on expand/collapse button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Ward_Inf)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> \"Ward Information\" dialog should collapse/expand as per selection.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.btn_collapse_Ward_Inf)).isDisplayed()); 
  }
  
  @Test(priority=146, description="To verify that user is able to perform close functionality of \"Ward Information\" dialog.")
  public void SGL_Ranchi_CITYGIS_146() throws InterruptedException {
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Ward Information\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Ward_Information)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select by Ward Number from the \"Ward Number\" drop-down list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlWardname\"]")));  
	  dropdown.selectByValue("10"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Go option. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Ward_Inf)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on close button..");
	  driver.findElement(By.xpath(City_GIS_R.btn_Close_Ward_Inf)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Click on close button.");
	  Assert.assertEquals(false, driver.findElement(By.xpath(City_GIS_R.label_Ward_Information)).isDisplayed());
  }
  
  @Test(priority=147, description="To verify that user is not able to perform \"Ward Information\" functionality without selecting the Ward Number.")
  public void SGL_Ranchi_CITYGIS_147() throws InterruptedException {
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Ward Information\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Ward_Information)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on Go option. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Ward_Inf)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation massage like\r\n"
	  		+ "\"Please Select Ward Number\"");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Please Select Ward Number\"]")).isDisplayed());
  }
  
  @Test(priority=148, description="To verify user get \"Find Direction\" dialog from \"Find Direction\" functionality.")
  public void SGL_Ranchi_CITYGIS_148() throws InterruptedException {
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Find Direction\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Find_Direction)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get dialog of \"Find Direction\".");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Find Direction\"]")).isDisplayed());
  }
  
  @Test(priority=149, description="To verify that user is able to perform \"Find Direction\" functionality without using current location button.")
  public void SGL_Ranchi_CITYGIS_149() throws InterruptedException {
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on expand/collapse icon of \"GIS INFOGRAPHICS\".");
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  driver.findElement(By.xpath("//a[@title=\"GiS Infographics\"]")).click();
	  Thread.sleep(4000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on \"Find Direction\" functionality.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Find_Direction)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click in text box of \"Source Location\".");
	  driver.findElement(By.xpath(City_GIS_R.txt_Source_Location)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on map or enter the landmark name in source location textbox to get the \"Source Location\".");
	  driver.findElement(By.xpath(City_GIS_R.txt_Source_Location)).sendKeys("85.301166610431,23.313056416789");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click in text box of \"Destination Location\".");
	  driver.findElement(By.xpath(City_GIS_R.txt_Destination_Location)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on map or enter the landmark name in source location textbox to get the \"Source Location\".");
	  driver.findElement(By.xpath(City_GIS_R.txt_Destination_Location)).sendKeys("85.376383438191,23.34896394763");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step10:</b> Click on \"Direction\" button.");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();",     driver.findElement(By.xpath(City_GIS_R.btn_Direction)));
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the direction as a shortest path between \"Source Location\" and \"Destination Location\" on map.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div/div/div/img[@class=\"olAlphaImg\" and @src=\"/Commonwidget/ranchi_wd/images/redpin.png\"]")).isDisplayed());
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div/div/div/img[@class=\"olAlphaImg\" and @src=\"/Commonwidget/ranchi_wd/images/bluepin.png\"]")).isDisplayed());
	  Assert.assertEquals(true, driver.findElement(By.xpath("//*[name()=\"svg\"]/*[name()=\"g\"]/*[name()=\"g\"]/*[name()=\"polyline\"]")).isDisplayed());
  }
  
  
  @AfterMethod
  public void afterClass() {
	driver.quit();
	  }
  }
