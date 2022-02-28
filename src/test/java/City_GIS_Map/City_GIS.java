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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
  public void DSCL_CityGIS_01() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landing page of the City GIS Portal.");
	  Assert.assertEquals("Dehradun GIS Portal", driver.getTitle());
  }
  
  @Test(priority=2, description="To verify that user is able to redirect on Home page of the DSCL application while clicking on DSCL logo.")
  public void DSCL_CityGIS_02() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Logo of the DSCL.");
	  driver.findElement(By.xpath(City_GIS_R.lnk_Logo)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get Home page of the DSCL application.");
	  Assert.assertEquals("Dehradun Smart City Ltd", driver.getTitle());
  }
  
  @Test(priority=3, description="To verify search functionality on City GIS page.")
  public void DSCL_CityGIS_03() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on \"Search\" option from the top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter the search criteria into search textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Search)).sendKeys("Bank");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Enter/Search icon.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Search_Icon)).click();
	  Thread.sleep(30000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get \"Searched\" result panel at bottom.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.label_Search)).isDisplayed());
  }
  
  @Test(priority=4, description="To verify that user is able to change language (from English to Hindi) / (from Hindi to English) for City GIS page.")
  public void DSCL_CityGIS_04(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Profile icon button from the City GIS page.");
	  driver.findElement(By.xpath(City_GIS_R.btn_User_Profile)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on link of 'Hindi' language option from the list.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Hindi_Lan)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get City GIS page in Hindi language.");
	  Assert.assertEquals("देहरादून जीआईएस पोर्टल", driver.getTitle());
	  objs.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Profile icon button from the City GIS page.");
	  driver.findElement(By.xpath(City_GIS_R.btn_User_Profile)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on link of 'English' language option from the list.");
	  driver.findElement(By.xpath(City_GIS_R.btn_English_Lan)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get City GIS page in Hindi language.");
	  Assert.assertEquals("Dehradun GIS Portal", driver.getTitle());
  }
  
  @Test(priority=5, description="To verify that user is able to Collapse/Expand Layer panel. ")
  public void DSCL_CityGIS_05(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Layer icon.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Layers)).click();
	  driver.findElement(By.xpath(City_GIS_R.btn_Layers)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get Layer panel in Collapse/Expand mode.");
	  System.out.println(driver.findElement(By.xpath(City_GIS_R.Layer_Panel)).getAttribute("class"));
	 Assert.assertEquals("layers col-sm-2 modalinactive collapse-left", driver.findElement(By.xpath(City_GIS_R.Layer_Panel)).getAttribute("class"));
	  objs.Screenshot(driver, Classname ,method.getName()+"_01" );
	 Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b>  Click on Layer icon.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Layers)).click();
	  driver.findElement(By.xpath(City_GIS_R.btn_Layers)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get Layer panel in Collapse/Expand mode.");
	  Assert.assertEquals("layers col-sm-2 modalactive expand-right", driver.findElement(By.xpath(City_GIS_R.Layer_Panel)).getAttribute("class"));
  }
  
  @Test(priority=6, description="To verify that user is able to Search particular Layer from the list of layers.")
  public void DSCL_CityGIS_06() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter layer name into Search Layer textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Search_Layer)).sendKeys("Ward Boundary");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get searched layer in layer panel list.");
	  Assert.assertEquals(false, driver.findElement(By.xpath(City_GIS_R.Layer_Dehradun_Basemap)).isDisplayed());
  }
  
  @Test(priority=7, description="To verify that user is able to Un-select all the selected layers.")
  public void DSCL_CityGIS_07() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on All Layer OFF link from the Layer panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_ALl_Layer_Off)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get City GIS Map without selection of any layers.");
	  List<WebElement> element1 = driver.findElements(By.xpath("//input[@type=\"checkbox\" ]"));
	  System.out.println(element1.size());
	  for(int i =0; i<element1.size(); i++) {
		  Assert.assertEquals(false, element1.get(i).isSelected() );
	  } 
  }
  
  @Test(priority=8, description="To verify that user is able to get Legend for the selected layers.")
  public void DSCL_CityGIS_08() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Legend option from the Layer panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Legend)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get Legend Popup for selected layers.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.label_Legend_pop)).isDisplayed());
  }
  
  @Test(priority=9, description="To verify that user is able to Expand/Collapse particular layer from the layer list.")
  public void DSCL_CityGIS_09(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  List<WebElement> element1 = driver.findElements(By.xpath("//div[@class=\"x-tree-node-el x-unselectable x-tree-node-collapsed\"]"));
	  System.out.println(element1.size());
	  for(int i =0; i<element1.size(); i++) {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on icon of the expand/collapse from the Layer panel for the particular layer.");
		  element1.get(i).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get list of sub-layers in expanded/collapse mode.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"x-tree-node-el x-unselectable x-tree-node-expanded\"]")).isDisplayed() );
		  objs.Screenshot(driver, Classname ,method.getName()+"_"+i );
		  Thread.sleep(1000);
	  } 
  }
  
  @Test(priority=10, description="To verify that user is able to use 'Select all' facility for sub-layers.")
  public void DSCL_CityGIS_10(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
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
	  for(int j =0; j<element1.size(); j++) {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2."+j+":</b> Click on Check-box which is ahead of layer.");
		  element1.get(j).click();
		  List<WebElement> element = driver.findElements(By.xpath("//div/li[2]/ul/li/div[1]/input[@checked]"));
		  System.out.println(element.size());
		  for(int i =0; i<element.size(); i++) {
			  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> All sublayers data should be display on map and all checkbox selected.");
			  Assert.assertEquals(true, element.get(i).isDisplayed() );
		  }	 
		  objs.Screenshot(driver, Classname ,method.getName()+"_"+j );
		  Thread.sleep(1000); 
	  }  
  }
  
  @Test(priority=11, description="To verify that user is able to use 'Un-Select all' facility for sub-layers.")
  public void DSCL_CityGIS_11(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
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
	  for(int j =0; j<element1.size(); j++) {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2."+j+":</b> Click on Check-box which is ahead of layer.");
		  element1.get(j).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3."+j+":</b> Again click on Check-box which is ahead of layer.");
		  element1.get(j).click();
		  List<WebElement> element = driver.findElements(By.xpath("//div/li[2]/ul/li/div[1]/input[@checked]"));
		  System.out.println(element.size());
		  for(int i =0; i<element.size(); i++) {
			  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get City GIS map without selected layers.");
			  Assert.assertEquals(true, element.get(i).isDisplayed() );
		  }	 
		  objs.Screenshot(driver, Classname ,method.getName()+"_"+j );
		  Thread.sleep(1000); 
	  }  
  }
  
  @Test(priority=12, description="To verify that user is able to 'Select' particular sub-layer.")
  public void DSCL_CityGIS_12(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  List<WebElement> element1 = driver.findElements(By.xpath("//div[@class=\"x-tree-node-el x-unselectable x-tree-node-collapsed\"]"));
	  System.out.println(element1.size());
	  for(int i =0; i<element1.size(); i++) {
		  element1.get(i).click();
		  Thread.sleep(1000);
	  } 
	  List<WebElement> element = driver.findElements(By.xpath("//div/li/ul/li/div/input"));
	  System.out.println(element.size());
	  for(int i =0; i<element.size(); i++) {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2"+i+":</b> Select particular layer from the sub-layer list.");
		  element.get(i).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Layer data should be display on the map.");
		  Assert.assertEquals(true, element.get(i).isDisplayed() );
		  objs.Screenshot(driver, Classname ,method.getName()+"_"+i );
		  Thread.sleep(1000);
		  element.get(i).click();
	  }
  }
  
  @Test(priority=13, description="To verify that user is able to 'Un-Select' particular Sub-layer.")
  public void DSCL_CityGIS_13(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  List<WebElement> element1 = driver.findElements(By.xpath("//div[@class=\"x-tree-node-el x-unselectable x-tree-node-collapsed\"]"));
	  System.out.println(element1.size());
	  for(int i =0; i<element1.size(); i++) {
		  element1.get(i).click();
		  Thread.sleep(1000);
	  } 
	  List<WebElement> element = driver.findElements(By.xpath("//div/li/ul/li/div/input"));
	  System.out.println(element.size());
	  for(int i =0; i<element.size(); i++) {
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2"+i+":</b> Select particular layer from the sub-layer list.");
		  element.get(i).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3"+i+":</b> Un-Select particular layer from the sub-layer list.");
		  element.get(i).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get City GIS map without selected layer.");
		  Assert.assertEquals(true, element.get(i).isDisplayed() );
		  objs.Screenshot(driver, Classname ,method.getName()+"_"+i );
		  Thread.sleep(1000);  
	  }
  }
  @Test(priority=14, description="To verify that user is able to Get Layer Information pop-up.")
  public void DSCL_CityGIS_14(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select and right click on the mouse for the particular sub-layer. ");
	  Actions action = new Actions(driver);
	  WebElement link =driver.findElement(By.xpath(City_GIS_R.Layer_Dehradun_Basemap)); 
	  action.contextClick(link).perform();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Get layer Information' functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Get_Layer_information)).click();
	  Thread.sleep(2000);
  	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on City GIS map without information pop-up of the layer. ");
   	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.label_information_window)).isDisplayed() );	
      objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'OK' button of information pop up.");
      driver.findElement(By.xpath(City_GIS_R.btn_ok_information)).click();
	  Thread.sleep(2000);
  }
  
  @Test(priority=15, description="To verify that user is able to Close Layer Information pop-up.")
  public void DSCL_CityGIS_15(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select and right click on the mouse for the particular sub-layer. ");
	  Actions action = new Actions(driver);
	  WebElement link =driver.findElement(By.xpath(City_GIS_R.Layer_Dehradun_Basemap)); 
	  action.contextClick(link).perform();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Get layer Information' functionality.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Get_Layer_information)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on City GIS map without information pop-up of the layer. ");
   	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.label_information_window)).isDisplayed() );	
      objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Close icon from the layer Information pop-up.");
      driver.findElement(By.xpath(City_GIS_R.btn_close_information)).click();
	  Thread.sleep(2000);
  }
  
  @Test(priority=16, description="To verify that user is able to perform 'Zoom To Extent' functionality.")
  public void DSCL_CityGIS_16() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select and right click on the mouse for the particular sub-layer. ");
	  Actions action = new Actions(driver);
	  WebElement link =driver.findElement(By.xpath(City_GIS_R.Layer_Dehradun_Basemap)); 
	  action.contextClick(link).perform();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Zoom to Layer Extent option.");
  }
  
  @Test(priority=17, description="To verify that user is able to change opacity of the layer.")
  public void DSCL_CityGIS_17() throws InterruptedException {
	//  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	//  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select and right click on the mouse for the particular sub-layer. ");
	  Actions action = new Actions(driver);
	  WebElement link =driver.findElement(By.xpath(City_GIS_R.Layer_Dehradun_Basemap)); 
	  action.contextClick(link).perform();
	  Thread.sleep(4000);
	//  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Change Layer opacity option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Change_Layer_opacity)).click();
	 // ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Drag opacity option to change opacity of the layer.");
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
  
  @Test(priority=18, description="To verify that user is able to close pop-up of the change opacity option.")
  public void DSCL_CityGIS_18() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select and right click on the mouse for the particular sub-layer. ");
	  Actions action = new Actions(driver);
	  WebElement link =driver.findElement(By.xpath(City_GIS_R.Layer_Dehradun_Basemap)); 
	  action.contextClick(link).perform();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Change Layer opacity option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Change_Layer_opacity)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Close icon from the pop-up of the change opacity.");
	  driver.findElement(By.xpath(City_GIS_R.btn_close)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get City GIS map without pop-up of the change opacity.");
	  Assert.assertEquals(false, driver.findElement(By.xpath("//span[text()=\"Opacity\"]")).isDisplayed() );
  }
  
  @Test(priority=19, description="To verify that user is able to perform ID tool functionality.")
  public void DSCL_CityGIS_19() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Tools icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Identify link from the Tools.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Identify)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on particular attribute on the City GIS map.");
	  Actions action = new Actions(driver);
	  action.moveByOffset(853,450).click().perform();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the Pop-up with details of particular attribute which are selected from the City GIS map.");
	  Assert.assertEquals("visible",driver.findElement(By.xpath("//div[@class=\" gx-popup x-window x-resizable-pinned\"]")).getCssValue("visibility"));
  }
  
  @Test(priority=20, description="To verify that user is able to close ID Tool popup.")
  public void DSCL_CityGIS_20() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Tools icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Identify link from the Tools.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Identify)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on particular attribute on the City GIS map.");
	  Actions action = new Actions(driver);
	  action.moveByOffset(853,450).click().perform();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Close button from the feature info Pop-up.");
	  driver.findElement(By.xpath(City_GIS_R.btn_close)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the Pop-up with details of particular attribute which are selected from the City GIS map.");
	  Assert.assertEquals("hidden",driver.findElement(By.xpath("//div[@class=\" gx-popup x-window x-resizable-pinned\"]")).getCssValue("visibility"));
  }
  
  @Test(priority=21, description="To verify that user is able to download the details  in specific format from ID tool popup.")
  public void DSCL_CityGIS_21() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Tools icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Identify link from the Tools.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Identify)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on particular attribute on the City GIS map.");
	  Actions action = new Actions(driver);
	  action.moveByOffset(853,450).click().perform();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Download option from the feature info Pop-up.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Download)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on Download option from the feature info Pop-up.");
	  driver.findElement(By.xpath(City_GIS_R.lnk_XLS_Download)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should able to download the all details in selected file format.");
	  File f = new File("C:\\Users\\meet.g\\Downloads\\boundary_municipal (6).xls"); 
	  f.exists();
  }
  
  @Test(priority=22, description="To verify that user is able to perform pan functionality on City GIS map.")
  public void DSCL_CityGIS_22() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Tools icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Display option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Display)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Pan option and try to pan on map.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Pan)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should be able to move/drag City GIS map.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//a[@class=\"active\" and text()=\"Pan\"]")).isDisplayed());
  }
  
  @Test(priority=23, description="To verify that user is able to set Marker on specific location using coordinates.")
  public void DSCL_CityGIS_23() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Tools icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Display option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Display)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Coordinates option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Coordinates)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter Longitude value in Lon [Grad] field.");
	  driver.findElement(By.xpath(City_GIS_R. txt_long_grad)).sendKeys("77.9");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Enter Latitude value in Lat [Grad] field.");
	  driver.findElement(By.xpath(City_GIS_R.txt_lat_grad)).sendKeys("30.34");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select particular Zoom level.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_zoom)).click();
	  driver.findElement(By.xpath("//div[text()=\"1 : 5610\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on Go button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get Marker on City GIS map with mentioned coordinates.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.img_Pin_point)).isDisplayed());    
  }
  
  @Test(priority=24, description="To verify that user is able to remove marker from the City GIS map using Remove markers button.")
  public void DSCL_CityGIS_24() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Tools icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Display option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Display)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Coordinates option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Coordinates)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter Longitude value in Lon [Grad] field.");
	  driver.findElement(By.xpath(City_GIS_R. txt_long_grad)).sendKeys("78.19");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Enter Latitude value in Lat [Grad] field.");
	  driver.findElement(By.xpath(City_GIS_R.txt_lat_grad)).sendKeys("30.51");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select particular Zoom level.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_zoom)).click();
	  driver.findElement(By.xpath("//div[text()=\"1 : 5610\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on Go button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go)).click();
	  List<WebElement> element = driver.findElements(By.xpath("//div/div/img"));
	  System.out.println(element.size());
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Remove Markers button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_rm_marker)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get City GIS map without the marker.");
	  List<WebElement> element1 = driver.findElements(By.xpath("//div/div/img"));
	  System.out.println(element1.size());
	  Assert.assertNotEquals(element1.size(), element.size());    
  }
  
  @Test(priority=25, description="To verify that all markers should clear while closing coordinates popup.")
  public void DSCL_CityGIS_25() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Tools icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Display option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Display)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Coordinates option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Coordinates)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter Longitude value in Lon [Grad] field.");
	  driver.findElement(By.xpath(City_GIS_R. txt_long_grad)).sendKeys("77.9");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Enter Latitude value in Lat [Grad] field.");
	  driver.findElement(By.xpath(City_GIS_R.txt_lat_grad)).sendKeys("30.34");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select particular Zoom level.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_zoom)).click();
	  driver.findElement(By.xpath("//div[text()=\"1 : 5610\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on Go button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go)).click();
	  List<WebElement> element = driver.findElements(By.xpath("//div/div/img"));
	  System.out.println(element.size());
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Close icon from the Go to Coordinates pop-up.");
	  driver.findElement(By.xpath(City_GIS_R.btn_close)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get City GIS map without Go to Coordinates pop-up and without markers of the specific locations.");
	  List<WebElement> element1 = driver.findElements(By.xpath("//div/div/img"));
	  System.out.println(element1.size());
	  Assert.assertNotEquals(element1.size(), element.size());    
  }
  
  @Test(priority=26, description="To verify that user is able to measure the City GIS map using Length tool.")
  public void DSCL_CityGIS_26() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Tools icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Measure option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Measure)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Length option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Length)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select two location on map.");
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
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the facility to measure length from the City GIS map using Line.\r\n"
	  		+ "User should get specified length on the footer.");
	  System.out.println( driver.findElement(By.xpath(City_GIS_R.polyline)).isDisplayed());
	  Assert.assertEquals(true,  driver.findElement(By.xpath(City_GIS_R.polyline)).isDisplayed());   
  }
  
  @Test(priority=27, description="To verify that user is able to measure the City GIS map using Area tool.")
  public void DSCL_CityGIS_27() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Tools icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Measure option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Measure)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Area option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Area)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select more than two location on map.");
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
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the facility to measure area from the City GIS map using polygon.\r\n" 
	  		+ "User should get specified area on the footer.");
	  System.out.println( driver.findElement(By.xpath(City_GIS_R.polygone)).isDisplayed());
	  Assert.assertEquals(true,  driver.findElement(By.xpath(City_GIS_R.polygone)).isDisplayed());   
  }
  
  @Test(priority=28, description="To verify that user is able to perform Swipe tool using By Layer option.")
  public void DSCL_CityGIS_28() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select on particular layer from the layer list for swipe.");
	  driver.findElement(By.xpath(City_GIS_R.Layer_Dehradun_Basemap)).click(); 
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Tools icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Swipe icon from the top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select By Layer option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe_Layer)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on OK button from the pop-up of swipe.");
	  driver.findElement(By.xpath(City_GIS_R.btn_ok_swipe_popup)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Swipe on map.");
	  Robot robot = new Robot();
	  robot.mouseMove(853,450);
	  robot.delay(1500);
	  String a1 = driver.findElement(By.xpath("//div[@id=\"OpenLayers_Layer_WMS_257\"]")).getAttribute("style");
	  System.out.println(a1);
	  robot.mouseMove(980,450);
	  robot.delay(1500);
	  String a2 = driver.findElement(By.xpath("//div[@id=\"OpenLayers_Layer_WMS_257\"]")).getAttribute("style");
	  System.out.println(a2);
	  Thread.sleep(3000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Selected layer should be swipe as per mouse moves on map.");
	  Assert.assertNotEquals(a1,a2);
  }
  
  @Test(priority=29, description="To verify that user is able to stop swipe tool from the City GIS map.")
  public void DSCL_CityGIS_29() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select on particular layer from the layer list for swipe.");
	  driver.findElement(By.xpath(City_GIS_R.Layer_Dehradun_Basemap)).click(); 
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Tools icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Swipe icon from the top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select By Layer option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe_Layer)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on OK button from the pop-up of swipe.");
	  driver.findElement(By.xpath(City_GIS_R.btn_ok_swipe_popup)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Tools icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on Swipe icon from the top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select By Layer option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe_Layer)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on OK button from the pop-up of swipe.");
	  driver.findElement(By.xpath(City_GIS_R.btn_ok_swipe_popup)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Selected layer should be swipe as per mouse moves on map.");
	  Assert.assertEquals(false,  driver.findElement(By.xpath(City_GIS_R.dialog_swipe_popup)).isDisplayed());
  }
  
  @Test(priority=30, description="To verify that user is able to stop swipe tool from the City GIS map.")
  public void DSCL_CityGIS_30() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select on particular layer from the layer list for swipe.");
	  driver.findElement(By.xpath(City_GIS_R.Layer_Dehradun_Basemap)).click(); 
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Tools icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Swipe icon from the top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select By Layer option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe_Layer)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on (X) icon of the pop-up.");
	  driver.findElement(By.xpath(City_GIS_R.btn_close)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Selected layer should be swipe as per mouse moves on map.");
	  Assert.assertEquals(false,  driver.findElement(By.xpath(City_GIS_R.dialog_swipe_popup)).isDisplayed());
  }
  
  @Test(priority=31, description="To verify that user is able to perform Swipe tool using By Pointer option.")
  public void DSCL_CityGIS_31() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select on particular layer from the layer list for swipe.");
	  driver.findElement(By.xpath(City_GIS_R.Layer_Dehradun_Basemap)).click(); 
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Tools icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Swipe icon from the top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select By Pointer option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe_Pointer)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on OK button from the pop-up of swipe.");
	  driver.findElement(By.xpath(City_GIS_R.btn_ok_swipe_popup)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Swipe on map.");
	  Robot robot = new Robot();
	  robot.mouseMove(853,450);
	  robot.delay(1500);
	  String a1 = driver.findElement(By.xpath("//div[@id=\"OpenLayers_Layer_WMS_257\"]")).getAttribute("style");
	  System.out.println(a1);
	  robot.mouseMove(980,450);
	  robot.delay(1500);
	  String a2 = driver.findElement(By.xpath("//div[@id=\"OpenLayers_Layer_WMS_257\"]")).getAttribute("style");
	  System.out.println(a2);
	  Thread.sleep(3000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Selected layer should be swipe as per mouse moves on map.");
	  Assert.assertNotEquals(a1,a2);
  }
  
  @Test(priority=32, description="To verify that user is able to stop 'By Pointer' swipe tool from the City GIS map.")
  public void DSCL_CityGIS_32() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select on particular layer from the layer list for swipe.");
	  driver.findElement(By.xpath(City_GIS_R.Layer_Dehradun_Basemap)).click(); 
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Tools icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Swipe icon from the top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select By Pointer option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe_Pointer)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on OK button from the pop-up of swipe.");
	  driver.findElement(By.xpath(City_GIS_R.btn_ok_swipe_popup)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Tools icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on Swipe icon from the top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select By Pointer option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe_Pointer)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on OK button from the pop-up of swipe.");
	  driver.findElement(By.xpath(City_GIS_R.btn_ok_swipe_popup)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Selected layer should be swipe as per mouse moves on map.");
	  Assert.assertEquals(false,  driver.findElement(By.xpath(City_GIS_R.dialog_swipe_popup)).isDisplayed());
  }
  
  @Test(priority=33, description="To verify that user is able to close popup of the start/stop swipe by pointer functionality.")
  public void DSCL_CityGIS_33() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select on particular layer from the layer list for swipe.");
	  driver.findElement(By.xpath(City_GIS_R.Layer_Dehradun_Basemap)).click(); 
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Tools icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Swipe icon from the top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select By Pointer option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Swipe_Pointer)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on (X) icon of the pop-up.");
	  driver.findElement(By.xpath(City_GIS_R.btn_close)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Selected layer should be swipe as per mouse moves on map.");
	  Assert.assertEquals(false,  driver.findElement(By.xpath(City_GIS_R.dialog_swipe_popup)).isDisplayed());
  }
  
  @Test(priority=34, description="To verify that user is able to add bookmark for City GIS map.")
  public void DSCL_CityGIS_34() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Go to particular location using Zoom-in facility.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Tools icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Bookmark option from the Top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Bookmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter the bookmark Name in Name textbox. ");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_name)).sendKeys("Testing");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Enter the bookmark Description in Description textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_Des)).sendKeys("Test for automation.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Add button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Add)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the added bookmarks under Bookmarks list of the layer panel.");
	  Assert.assertEquals(true,  driver.findElement(By.xpath("//a[text()=\"Testing\"]")).isDisplayed());
  }
  
  @Test(priority=35, description="To verify that user is able to Cancel bookmark.")
  public void DSCL_CityGIS_35() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Go to particular location using Zoom-in facility.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Tools icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Bookmark option from the Top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Bookmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter the bookmark Name in Name textbox. ");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_name)).sendKeys("Testing");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Enter the bookmark Description in Description textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_Des)).sendKeys("Test for automation.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Cancel option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Cancel)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get City GIS map without bookmark.");
	  Assert.assertEquals(false,  driver.findElement(By.xpath(City_GIS_R.dialog_Bookmark)).isDisplayed());
  }
  
  @Test(priority=36, description="To verify that user is able to close the pop-up of the bookmark.")
  public void DSCL_CityGIS_36() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Go to particular location using Zoom-in facility.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Tools icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Bookmark option from the Top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Bookmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter the bookmark Name in Name textbox. ");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_name)).sendKeys("Testing");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Enter the bookmark Description in Description textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_Des)).sendKeys("Test for automation.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Close icon of the pop-up of bookmark..");
	  driver.findElement(By.xpath(City_GIS_R.btn_close)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get City GIS map without bookmark.");
	  Assert.assertEquals(false,  driver.findElement(By.xpath(City_GIS_R.dialog_Bookmark)).isDisplayed());
  }
  
  @Test(priority=37, description="To verify that user is able to redirect on specified location using saved Bookmarks.")
  public void DSCL_CityGIS_37() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Go to particular location using Zoom-in facility.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  Thread.sleep(4000);
	  String a1 = driver.findElement(By.xpath("//div[@class=\"olControlOverviewMapExtentRectangle\"]")).getAttribute("style");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Tools icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Bookmark option from the Top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Bookmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter the bookmark Name in Name textbox. ");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_name)).sendKeys("Testing");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Enter the bookmark Description in Description textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_Des)).sendKeys("Test for automation.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Add button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Add)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Zoom out");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_out)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on specific Bookmarks.");
	  driver.findElement(By.xpath("//a[text()=\"Testing\"]")).click();
	  String a2 = driver.findElement(By.xpath("//div[@class=\"olControlOverviewMapExtentRectangle\"]")).getAttribute("style");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should be redirect on specific location which is mentioned in Bookmark.");
	  Assert.assertEquals(a1,a2);
  }
  
  @Test(priority=38, description="To verify that user is able to remove saved bookmark.")
  public void DSCL_CityGIS_38() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Go to particular location using Zoom-in facility.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Tools icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Tools)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Bookmark option from the Top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Bookmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Enter the bookmark Name in Name textbox. ");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_name)).sendKeys("Testing");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Enter the bookmark Description in Description textbox.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Bookmark_Des)).sendKeys("Test for automation.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Add button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Add)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on Remove option from the bookmark list.");
	  driver.findElement(By.xpath(City_GIS_R.Remove_Bookmark)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get bookmark list except removed bookmark.");
	  Assert.assertEquals("display: none;",driver.findElement(By.xpath("//div[@id=\"hr-bookmarks\"]")).getAttribute("style"));
  }
  
  @Test(priority=39, description="To verify that user is able to generate Print of the City GIS map.")
  public void DSCL_CityGIS_39() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Print option from the Top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Print)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on the Print option of the Print Preview pop-up. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_print)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the Print of City GIS map with selected layers.");

  }
  
  @Test(priority=48, description="To verify that user is able to Zoom-In in Print Preview screen.")
  public void DSCL_CityGIS_48() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Print option from the Top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Print)).click();
	  Thread.sleep(2000);
	  String a1 = driver.findElement(By.xpath("//div[@class=\"olControlScaleLineTop\"]")).getText();
	  System.out.println(a1);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on the Plus(+) icon for Zoom-In. ");
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[2]/a[text()=\"+\"]")));
	  Thread.sleep(2000);
	  String a2 = driver.findElement(By.xpath("//div[@class=\"olControlScaleLineTop\"]")).getText();
	  System.out.println(a2);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the map with specified zoom-in level on preview screen.");
	  Assert.assertNotEquals(a1, a2);
  }
  
  @Test(priority=49, description="To verify that user is able to Zoom-Out in Print Preview screen.")
  public void DSCL_CityGIS_49() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Print option from the Top panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Print)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on the Plus(+) icon for Zoom-In. ");
	  driver.findElement(By.xpath("//a[text()=\"+\"]")).click();
	  String a1 = driver.findElement(By.xpath("//div[@class=\"olControlScaleLineTop\"]")).getText();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on the Minus(-) icon for Zoom-Out. ");
	  driver.findElement(By.xpath("//a[text()=\"-\"]")).click();
	  Thread.sleep(2000);
	  String a2 = driver.findElement(By.xpath("//div[@class=\"olControlScaleLineTop\"]")).getText();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the map with specified zoom-out level on preview screen.");
	  Assert.assertNotEquals(a1, a2);
  }
  
  @Test(priority=50, description="To verify that user is able to get help of the application.")
  public void DSCL_CityGIS_50() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Help option from the Top Panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Help)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should be redirect on Help Page.");
	  String parent=driver.getWindowHandle();
	  Set<String>s=driver.getWindowHandles();
     // Now iterate using Iterator
	 Iterator<String> I1= s.iterator();
     while(I1.hasNext()){
    	 String child_window=I1.next();
         if(!parent.equals(child_window)){
        	 driver.switchTo().window(child_window);
             String actualTitle = driver.switchTo().window(child_window).getTitle();
             String expectedTitle="Dehradun Smart City";
	         Assert.assertEquals(actualTitle, expectedTitle);
	         Thread.sleep(2000);
	         } 
         }
  }
  
  @Test(priority=51, description="To verify that City GIS map is set to specific extent while clicking on 'Home' icon from bottom panel.")
  public void DSCL_CityGIS_51() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Fixed Zoom-In icon from the bottom panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Home icon from the bottom panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Home)).click();
	  Thread.sleep(2000);
	  String a2 = driver.findElement(By.xpath("//div[@class=\"olControlOverviewMapExtentRectangle\"]")).getAttribute("style");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the City GIS map on specified size or Layout.");
	  Assert.assertEquals("position: absolute; z-index: 1000; top: 66px; left: 106px; height: 18px; width: 38px;", a2);
  }
  
  @Test(priority=52, description="To verify that City GIS map is set to previously zoom scale while clicking on 'Zoom Previous' icon from bottom panel.")
  public void DSCL_CityGIS_52() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Fixed Zoom-In icon from the bottom panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  Thread.sleep(4000);
	  String a1 = driver.findElement(By.xpath("//div[@class=\"olControlOverviewMapExtentRectangle\"]")).getAttribute("style");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Zoom Previous icon of the bottom panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_Previous)).click();
	  Thread.sleep(2000);
	  String a2 = driver.findElement(By.xpath("//div[@class=\"olControlOverviewMapExtentRectangle\"]")).getAttribute("style");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the City GIS map on specified size or Layout.");
	  Assert.assertNotEquals(a1, a2);
  }
  
  @Test(priority=53, description="To verify that City GIS map is set to previously zoom scale while clicking on 'Zoom Next' icon from bottom panel.")
  public void DSCL_CityGIS_53() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Fixed Zoom-In icon from the bottom panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  Thread.sleep(4000);
	  String a1 = driver.findElement(By.xpath("//div[@class=\"olControlOverviewMapExtentRectangle\"]")).getAttribute("style");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Zoom Previous icon of the bottom panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_Previous)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Zoom Next icon of the bottom panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_Next)).click();
	  Thread.sleep(2000);
	  String a2 = driver.findElement(By.xpath("//div[@class=\"olControlOverviewMapExtentRectangle\"]")).getAttribute("style");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the City GIS map on specified size or Layout.");
	  Assert.assertEquals(a1, a2);
  }
  
  @Test(priority=54, description="To verify that user is able to perform 'Fixed Zoom In' facility.")
  public void DSCL_CityGIS_54() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  String a2 = driver.findElement(By.xpath("//div[@class=\"olControlScaleLineTop\"]")).getText();
	  System.out.print(a2);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Fixed Zoom-In icon from the bottom panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  Thread.sleep(4000);
	  String a1 =driver.findElement(By.xpath("//div[@class=\"olControlScaleLineTop\"]")).getText();
	  System.out.print(a1);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get City GIS map on fixed Zoom-In position.");
	  Assert.assertNotEquals(a1, a2);
  }
  
  @Test(priority=55, description="To verify that user is able to perform 'Fixed Zoom Out' facility.")
  public void DSCL_CityGIS_55() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Fixed Zoom-In icon from the bottom panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  Thread.sleep(4000);
	  String a2 = driver.findElement(By.xpath("//div[@class=\"olControlScaleLineTop\"]")).getText();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Fixed Zoom-Out icon from the bottom panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_out)).click();
	  String a1 =driver.findElement(By.xpath("//div[@class=\"olControlScaleLineTop\"]")).getText();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get City GIS map on fixed Zoom-In position.");
	  Assert.assertNotEquals(a1, a2);
  }
  
  @Test(priority=56, description="To verify that user is able to perform 'Clear selection' facility.")
  public void DSCL_CityGIS_56() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select particular layer from the sub-layer list.");
	  driver.findElement(By.xpath("//div/li[1]/div/input")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on the Clear selection icon from the bottom panel..");
	  driver.findElement(By.xpath(City_GIS_R.btn_Clear_selection)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get City GIS map on fixed Zoom-In position.");
	  Assert.assertEquals(false, driver.findElement(By.xpath("//div/li[1]/div/input")).isSelected());
  }
  
  @Test(priority=57, description="To verify that user is able to perform 'Current Location' facility.")
  public void DSCL_CityGIS_57() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on the Current Location icon from the bottom panel.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Current_Location)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the current location on City GIS map.");  
  }
  
  @Test(priority=58, description="To verify that user is able to select particular landmarks of the city on City GIS map.")
  public void DSCL_CityGIS_58() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Dashboard)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Landmark option from the Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select particular Landmark from the landmark list.");
	  driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Next option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the selected landmarks on City GIS map.");
	  driver.findElement(By.xpath(City_GIS_R.txt_Search_Layer)).sendKeys("bank");
	  Thread.sleep(2000);
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@id=\"extdd-247\"]/input")).isSelected());
  }
  
  @Test(priority=59, description="To verify that user is able to Clear selected landmark from the City GIS map.")
  public void DSCL_CityGIS_59() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Dashboard)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Landmark option from the Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select particular Landmark from the landmark list.");
	  driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Next option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on Clear option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Clear)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the City GIS map without any selected landmark.");
	  Assert.assertEquals(false, driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).isSelected());
  }
  
  @Test(priority=60, description="To verify that user is able to collapse/expand Landmark list in Dashboard.")
  public void DSCL_CityGIS_60(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Dashboard)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Expand icon for Landmark.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landmark list on collapse mode in Dashboard.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//ul[@class=\"divLoadPartial collapse show\"]")).isDisplayed());
	  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Collapse icon for Landmark.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landmark list on expanded mode in Dashboard.");
	  Assert.assertEquals(false, driver.findElement(By.xpath("//ul[@class=\"divLoadPartial collapse\"]")).isDisplayed());
  }
  
  @Test(priority=61, description="To verify that user is able to get details of particular landmark using location.")
  public void DSCL_CityGIS_61() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Dashboard)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Landmark option from the Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select particular Landmark from the landmark list.");
	  driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Next option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Enter the value in meter in Select by My Location field of the expanded screen of Select By Location.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"txtlandmarkbuffer\"]")));  
	  dropdown.selectByValue("3");  
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Go button of the expanded screen of Select By Location. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Landmark)).click();
	  driver.findElement(By.xpath("//button[text()=\"OK\"]")).click();
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on entered location.\r\n"
 		+ "User should get Detail Result of the selected landmark.");
	  Assert.assertEquals("1000 m", driver.findElement(By.xpath("//div[@class=\"olControlScaleLineTop\"]")).getText());
	  Assert.assertEquals(true,driver.findElement(By.xpath(City_GIS_R.label_Detailed_Result)).isDisplayed());
  }
  
  @Test(priority=62, description="To verify that user is able to search particular landmark using ward boundary.")
  public void DSCL_CityGIS_62() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Dashboard)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Landmark option from the Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select particular Landmark from the landmark list.");
	  driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Next option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select the ward from the Select by Ward Boundary field of the expanded screen of Select By Location. ");
	  driver.findElement(By.xpath("//input[@id=\"landmarkrdbyBoundary\"]")).click();
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlBoundaryvalue\"]")));  
	  dropdown.selectByValue("360");  
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Go button of the expanded screen of Select By Location. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Landmark)).click();
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on entered location.\r\n"
	  		+ "User should get Detail Result of the selected landmark.");
	  Assert.assertEquals("200 m", driver.findElement(By.xpath("//div[@class=\"olControlScaleLineTop\"]")).getText());
	  Assert.assertEquals(true,driver.findElement(By.xpath(City_GIS_R.label_Detailed_Result)).isDisplayed());
  }
  
  @Test(priority=63, description="To verify that user is able to perform expand/collapse facility for list of landmark details Popup.")
  public void DSCL_CityGIS_63(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Dashboard)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Landmark option from the Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select particular Landmark from the landmark list.");
	  driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Next option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select the ward from the Select by Ward Boundary field of the expanded screen of Select By Location. ");
	  driver.findElement(By.xpath("//input[@id=\"landmarkrdbyBoundary\"]")).click();
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlBoundaryvalue\"]")));  
	  dropdown.selectByValue("360");  
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Go button of the expanded screen of Select By Location. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Landmark)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on Plus(+) icon to expand list of landmark details popup.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get list of landmarks popup in expanded mode.");
	  Assert.assertEquals("height: auto;", driver.findElement(By.xpath("//div[@class=\"panel\"]")).getAttribute("style"));
	  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Minus(-) icon to collapse list of landmark details popup.");
	  driver.findElement(By.xpath(City_GIS_R.btn_collapse_Detailed_Result)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get list of landmarks popup in collapsed mode.");
	  Assert.assertEquals("", driver.findElement(By.xpath("//div[@class=\"panel\"]")).getAttribute("style"));
  }
  
  @Test(priority=64, description="To verify that user is able to perform next/previous facility for list of landmark details Popup.")
  public void DSCL_CityGIS_64(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Dashboard)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Landmark option from the Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select particular Landmark from the landmark list.");
	  driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Next option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select the ward from the Select by Ward Boundary field of the expanded screen of Select By Location. ");
	  driver.findElement(By.xpath("//input[@id=\"landmarkrdbyBoundary\"]")).click();
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlBoundaryvalue\"]")));  
	  dropdown.selectByValue("360");  
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Go button of the expanded screen of Select By Location. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Landmark)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on Plus(+) icon to expand list of landmark details popup.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Next(>) icon.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next_Detailed_Result)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on next list of the landmark detail.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//h3[text()=\"Records 4 To 6\"]")).isDisplayed());
	  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on Previous(<) icon.");
	  driver.findElement(By.xpath(City_GIS_R.btn_previous_Detailed_Result)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on previous list of the landmark detail.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//h3[text()=\"Records 1 To 3\"]")).isDisplayed());
  }
  
  @Test(priority=65, description="To verify that user is able to get landmark details using 'More' option.")
  public void DSCL_CityGIS_65() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Dashboard)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Landmark option from the Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select particular Landmark from the landmark list.");
	  driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Next option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select the ward from the Select by Ward Boundary field of the expanded screen of Select By Location. ");
	  driver.findElement(By.xpath("//input[@id=\"landmarkrdbyBoundary\"]")).click();
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlBoundaryvalue\"]")));  
	  dropdown.selectByValue("360");  
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Go button of the expanded screen of Select By Location. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Landmark)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on Plus(+) icon to expand list of landmark details popup.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on 'More' button of the particular landmark.");
	  driver.findElement(By.xpath(City_GIS_R.btn_More_Detailed_Result)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the more details regarding particular Landmark.");
	  Assert.assertEquals("", driver.findElement(By.xpath("//div[@id=\"landmarkdetailresultdetail\"]")).getAttribute("style"));
  }
  
  @Test(priority=66, description="To verify that user is able to perform 'Back to List of Landmark' facility from  the More detail.")
  public void DSCL_CityGIS_66() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Dashboard)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Landmark option from the Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select particular Landmark from the landmark list.");
	  driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Next option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select the ward from the Select by Ward Boundary field of the expanded screen of Select By Location. ");
	  driver.findElement(By.xpath("//input[@id=\"landmarkrdbyBoundary\"]")).click();
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlBoundaryvalue\"]")));  
	  dropdown.selectByValue("360");  
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Go button of the expanded screen of Select By Location. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Landmark)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on Plus(+) icon to expand list of landmark details popup.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on 'More' button of the particular landmark.");
	  driver.findElement(By.xpath(City_GIS_R.btn_More_Detailed_Result)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on (<-) icon.");
	  driver.findElement(By.xpath("//div[@class=\"close\"]/button/i[@class=\"fa fa-arrow-left\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get list of Landmarks popup.");
	  Assert.assertEquals("display: none;", driver.findElement(By.xpath("//div[@id=\"landmarkdetailresultdetail\"]")).getAttribute("style"));
  }
  
  @Test(priority=67, description="To verify that user is able to collapse/expand more detail popup of the landmark.")
  public void DSCL_CityGIS_67(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Dashboard)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Landmark option from the Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select particular Landmark from the landmark list.");
	  driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Next option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select the ward from the Select by Ward Boundary field of the expanded screen of Select By Location. ");
	  driver.findElement(By.xpath("//input[@id=\"landmarkrdbyBoundary\"]")).click();
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlBoundaryvalue\"]")));  
	  dropdown.selectByValue("360");  
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Go button of the expanded screen of Select By Location. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Landmark)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on Plus(+) icon to expand list of landmark details popup.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on 'More' button of the particular landmark.");
	  driver.findElement(By.xpath(City_GIS_R.btn_More_Detailed_Result)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on Minus(-) icon.");
	  driver.findElement(By.xpath("//aside[@id=\"modalNearbyquery\"]/form/div/div[@class=\"close\"]//button[@class=\"collapse\"]/i[@class=\"fa fa-minus\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the more details regarding particular Landmark.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//form[@class=\"needs-validation clscmnshowhide box ui-draggable collapsed-box\"]")).isDisplayed());
	  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on Plus(+) icon.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_More_Result)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the more details regarding particular Landmark.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//form[@class=\"needs-validation clscmnshowhide box ui-draggable\"]")).isDisplayed());
  }
  
  @Test(priority=68, description="To verify that user is able to Close more detail popup.")
  public void DSCL_CityGIS_68() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Dashboard)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Landmark option from the Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select particular Landmark from the landmark list.");
	  driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Next option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select the ward from the Select by Ward Boundary field of the expanded screen of Select By Location. ");
	  driver.findElement(By.xpath("//input[@id=\"landmarkrdbyBoundary\"]")).click();
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlBoundaryvalue\"]")));  
	  dropdown.selectByValue("360");  
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Go button of the expanded screen of Select By Location. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Landmark)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on Plus(+) icon to expand list of landmark details popup.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on 'More' button of the particular landmark.");
	  driver.findElement(By.xpath(City_GIS_R.btn_More_Detailed_Result)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on (X) icon.");
	  driver.findElement(By.xpath("//aside[@id=\"modalNearbyquery\"]/form/div/div[@class=\"close\"]//button[@class=\"frm-close\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on landmarks popup.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//aside[@class=\"dialog col-sm-12 pull-right second-modal-dialog modalinactive close-dialog-right\"]")).isDisplayed());
  }
  
  @Test(priority=69, description="To verify that user is able to perform 'Approx Distance' functionality.")
  public void DSCL_CityGIS_69() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Dashboard)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Landmark option from the Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Landmarks)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select particular Landmark from the landmark list.");
	  driver.findElement(By.xpath(City_GIS_R.chk_landmark_Bank)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Next option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Next)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select the ward from the Select by Ward Boundary field of the expanded screen of Select By Location. ");
	  driver.findElement(By.xpath("//input[@id=\"landmarkrdbyBoundary\"]")).click();
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlBoundaryvalue\"]")));  
	  dropdown.selectByValue("360");  
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Go button of the expanded screen of Select By Location. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Landmark)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on Plus(+) icon to expand list of landmark details popup.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on 'Approx Distance' button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Distance_Detailed_Result)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get approx distance between user location to selected landmark.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.img_Pin_point)).isDisplayed());
  }
  
  @Test(priority=70, description="To verify that user is able to find ward information.")
  public void DSCL_CityGIS_70() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Dashboard)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Ward Information option from the Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Ward_Information)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select Zone from the Zone list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlZone\"]")));  
	  dropdown.selectByValue("Harrawala"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select Ward from the Ward list.");
	  Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id=\"ddlWardname\"]")));  
	  dropdown1.selectByValue("394"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on Go option. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Ward_Inf)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get pop-up of the particular Ward Information and also redirect on particular ward on City GIS map.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.label_Ward_Information)).isDisplayed());
  }
  
  @Test(priority=71, description="To verify that user is able to Collapse and expand Ward Info pop-up.")
  public void DSCL_CityGIS_71(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Dashboard)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Ward Information option from the Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Ward_Information)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select Zone from the Zone list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlZone\"]")));  
	  dropdown.selectByValue("Harrawala"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select Ward from the Ward list.");
	  Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id=\"ddlWardname\"]")));  
	  dropdown1.selectByValue("394"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on Go option. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Ward_Inf)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on Minus(-) icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_collapse_Ward_Inf)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get Ward Info pop-up in collapse mode.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.btn_expand_Ward_Inf)).isDisplayed());
	  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on Plus(+) icon. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Ward_Inf)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get Ward Info pop-up in collapse mode.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.btn_collapse_Ward_Inf)).isDisplayed());  
  }
  
  @Test(priority=72, description="To verify that user is able to Close Ward Info pop-up.")
  public void DSCL_CityGIS_72() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Dashboard)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Ward Information option from the Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Ward_Information)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select Zone from the Zone list.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@id=\"ddlZone\"]")));  
	  dropdown.selectByValue("Harrawala"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select Ward from the Ward list.");
	  Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id=\"ddlWardname\"]")));  
	  dropdown1.selectByValue("394"); 
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on Go option. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Go_Ward_Inf)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> To verify that user is able to Close Ward Info pop-up.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Close_Ward_Inf)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get expanded  screen for ward details.");
	  Assert.assertEquals(false, driver.findElement(By.xpath(City_GIS_R.label_Ward_Information)).isDisplayed());
  }
  
  @Test(priority=73, description="To verify that user is able to Collapse and expand Ward Info expanded screen.")
  public void DSCL_CityGIS_73(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Dashboard)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Collapse icon of the Ward Information.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Ward_Information)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get Ward Info expanded screen in collapse mode.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//ul[@class=\"divLoadPartial collapse show\"]")).isDisplayed());
	  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Collapse icon of the Ward Information.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Ward_Information)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get Ward Info expanded screen in expand mode.");
	  Assert.assertEquals(false, driver.findElement(By.xpath("//ul[@class=\"divLoadPartial collapse\"]")).isDisplayed());
  }
  
  @Test(priority=74, description="To verify that user is able to get Emergency Services.")
  public void DSCL_CityGIS_74() throws InterruptedException, AWTException {
	  
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Dashboard)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Around Me option from the Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Around_Me)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Emergency Services option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Emergency_services)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Ok button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Ok)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Set location on City GIS map.");
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get Details Result pop-up for nearest emergency services.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.label_Detailed_Result)).isDisplayed());
  }		  
  
  @Test(priority=75, description="To verify that user is able to Expand particular service from the Detail Result pop-up.")
  public void DSCL_CityGIS_75() throws InterruptedException, AWTException {
	  
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Dashboard)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Around Me option from the Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Around_Me)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Emergency Services option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Emergency_services)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Ok button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Ok)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Set location on City GIS map.");
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on (+) icon for particular service.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result_WI)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get expanded screen for particular service with More and Direction button.");
	  Assert.assertEquals("height: auto;", driver.findElement(By.xpath("//div[@class=\"panel\"]")).getAttribute("style"));
  }	
  
  @Test(priority=76, description="To verify that user is able to get More detail pop-up for particular service.")
  public void DSCL_CityGIS_76() throws InterruptedException, AWTException {
	  
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Dashboard)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Around Me option from the Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Around_Me)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Emergency Services option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Emergency_services)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Ok button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Ok)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Set location on City GIS map.");
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on (+) icon for particular service.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result_WI)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on More button of the particular service. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_More_Detailed_Result)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the Detail pop-up for particular services.");
	  Assert.assertEquals("", driver.findElement(By.xpath("//div[@id=\"landmarkdetailresultdetail\"]")).getAttribute("style"));
  }	
  
  @Test(priority=77, description="To verify that user is able to Collapse/expand More detail pop-up for particular service.")
  public void DSCL_CityGIS_77(Method method) throws InterruptedException, AWTException {
	  
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Dashboard)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Around Me option from the Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Around_Me)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Emergency Services option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Emergency_services)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Ok button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Ok)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Set location on City GIS map.");
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on (+) icon for particular service.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result_WI)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on More button of the particular service. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_More_Detailed_Result)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on Minus(-) icon.");
	  driver.findElement(By.xpath("//aside[@id=\"modalNearbyquery\"]/form/div/div[@class=\"close\"]//button[@class=\"collapse\"]/i[@class=\"fa fa-minus\"]")).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the More Detail pop-up in Collapse mode.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//form[@class=\"needs-validation clscmnshowhide box ui-draggable collapsed-box\"]")).isDisplayed());
	  objs.Screenshot(driver, Classname ,method.getName()+"_"+1 );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Click on Plus(+) icon.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_More_Result)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the More Detail pop-up in Collapse mode.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//form[@class=\"needs-validation clscmnshowhide box ui-draggable\"]")).isDisplayed());
  }	
  
  @Test(priority=78, description="To verify that user is able to Close More detail pop-up for particular service.")
  public void DSCL_CityGIS_78() throws InterruptedException, AWTException {
	  
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Dashboard)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Around Me option from the Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Around_Me)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Emergency Services option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Emergency_services)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Ok button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Ok)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Set location on City GIS map.");
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on (+) icon for particular service.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result_WI)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on More button of the particular service. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_More_Detailed_Result)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on (X) icon from the More Detail pop-up.");
	  driver.findElement(By.xpath("//aside[@id=\"modalNearbyquery\"]/form/div/div[@class=\"close\"]//button[@class=\"frm-close\"]")).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the Details Result pop-up with list of services.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//aside[@class=\"dialog col-sm-12 pull-right second-modal-dialog modalinactive close-dialog-right\"]")).isDisplayed());
  }	
  
  @Test(priority=79, description="To verify that user is able to get Direction for particular emergency service.")
  public void DSCL_CityGIS_79() throws InterruptedException, AWTException {
	  
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Dashboard)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Around Me option from the Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Around_Me)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Emergency Services option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Emergency_services)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Ok button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Ok)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Set location on City GIS map.");
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on (+) icon for particular service.");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result_WI)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on Distance button of the particular service. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_Distance_Detailed_Result)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get approx distance of selected services.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div/div/div/img[@class=\"olAlphaImg\" and @src=\"/Commonwidget/dehradun_widget/images/redpin.png\"]")).isDisplayed());
  }	
  
  @Test(priority=80, description="To verify that user is able to Collapse/expand Detail Result pop-up.")
  public void DSCL_CityGIS_80() throws InterruptedException, AWTException {
	  
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Dashboard)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Around Me option from the Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Around_Me)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Emergency Services option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Emergency_services)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Ok button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Ok)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Set location on City GIS map.");
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on (-) icon for Detail Result popup.");
	  driver.findElement(By.xpath(City_GIS_R.btn_collapse_Detailed_Result_WI)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should be get Details Result pop-up in Collapse mode.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result_WI1)).isDisplayed());
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> lick on (+) icon for Detail Result popup. ");
	  driver.findElement(By.xpath(City_GIS_R.btn_expand_Detailed_Result_WI1)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should be get Details Result pop-up in expanded mode.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(City_GIS_R.btn_collapse_Detailed_Result_WI)).isDisplayed());
  }	
  
  @Test(priority=81, description="To verify that user is able to Close Detail Result pop-up.")
  public void DSCL_CityGIS_81() throws InterruptedException, AWTException {
	  
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Dashboard)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select Around Me option from the Dashboard.");
	  driver.findElement(By.xpath(City_GIS_R.ddm_Around_Me)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Emergency Services option.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Emergency_services)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on Ok button.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Ok)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Set location on City GIS map.");
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on (X) icon for particular service.");
	  driver.findElement(By.xpath(City_GIS_R.btn_close_Detailed_Result_WI1)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get Dashboard pop-up.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//aside[@class=\"dialog col-sm-12 pull-right second-modal-dialog modalinactive close-dialog-right\"]")).isDisplayed());
  }	
  
  @Test(priority=82, description="To verify that user is able to get current Longitude value.")
  public void DSCL_CityGIS_82() throws InterruptedException, AWTException {
	  
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Drag cursor over the City Gis map.");
	  Thread.sleep(4000);
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Drag cursor over the City Gis map."); 
	  System.out.println(driver.findElement(By.xpath("//div[@id=\"x-coord\"]")).getText());
	  Assert.assertEquals("X: 77.99", driver.findElement(By.xpath("//div[@id=\"x-coord\"]")).getText());
  }	
  
  @Test(priority=83, description="To verify that user is able to get current Latitude value.")
  public void DSCL_CityGIS_83() throws InterruptedException, AWTException {
	  
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Drag cursor over the City Gis map.");
	  Thread.sleep(4000);
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> To verify that user is able to get current Latitude value."); 
	  System.out.println(driver.findElement(By.xpath("//div[@id=\"y-coord\"]")).getText());
	  Assert.assertEquals("Y: 30.31", driver.findElement(By.xpath("//div[@id=\"y-coord\"]")).getText());
  }	
  
  @Test(priority=84, description="To verify that user is able to get current Ward name and Zone name.")
  public void DSCL_CityGIS_84() throws InterruptedException, AWTException {
	  
	//  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	 // ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Drag cursor over the City Gis map.");
	  Thread.sleep(4000);
	  Robot robot = new Robot();
	  robot.mouseMove(853,600);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  Thread.sleep(4000);
	//  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> To verify that user is able to get current Latitude value."); 
	  System.out.println(driver.findElement(By.xpath("//div[@id=\"statusbarmapinfo\"]")).getText());
	  Assert.assertEquals("Ward : Mehuwala-2,Harbajwala | Zone : Arcedeia", driver.findElement(By.xpath("//div[@id=\"statusbarmapinfo\"]")).getText());
  }	
  
  @Test(priority=85, description="To verify that user is able to get current version information of the application.")
  public void DSCL_CityGIS_85() throws InterruptedException, AWTException {
	  
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Observe footer panel it should display the version information."); 
	  System.out.println(driver.findElement(By.xpath("//div[@id=\"appversion\"]")).getText());
	  Assert.assertEquals("v 1.0.3", driver.findElement(By.xpath("//div[@id=\"appversion\"]")).getText());
  }	
  
  @Test(priority=86, description="To verify that user is able to get the scale of the City GIS map.")
  public void DSCL_CityGIS_86() throws InterruptedException, AWTException {
	  
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on CITY GIS button from the menu bar.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(6000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Go to particular location using Zoom-in facility.");
	  driver.findElement(By.xpath(City_GIS_R.btn_Zoom_In)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the scale of City GIS map in footer."); 
	  System.out.println(driver.findElement(By.xpath("//div[@class=\"olControlScaleLineTop\"]")).getText());
	  Assert.assertEquals("2 km", driver.findElement(By.xpath("//div[@class=\"olControlScaleLineTop\"]")).getText());
  }	
  @AfterMethod
  public void afterClass() {
	driver.quit();
	  }
  }
