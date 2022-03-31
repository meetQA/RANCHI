package Application_Pages;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Application_Pages_R.Home_Page_R;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import Listener.ExtentTestManager;
import Listener.Extra_Screen;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;

public class Home_Page {
	Home_Page_R obj = new Home_Page_R();
	WebDriver driver;
	String Classname = "Hoem_page_extras";
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
 
  @Test(priority=1, description="To verify that user get the Home page of the Ranchi application.")
  public void SGL_Ranchi_Home_1() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  Thread.sleep(4000);
	  String actualURL=driver.getCurrentUrl();
	  String expectedURL=Home_Page_R.URL;
	  Assert.assertEquals(actualURL, expectedURL);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get Home page of the Ranchi application.");
	  String actualTitle=driver.getTitle();
	  String expectedTitle="Ranchi Smart City Portal";
	  Assert.assertEquals(actualTitle, expectedTitle);
  }
  
	/*
	 * @Test(priority=02,
	 * description="To verify that user can get the content slider on the Home page and slider is change automatically."
	 * ) public void DSCL_HOME_02() throws InterruptedException {
	 * ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	 * ExtentTestManager.getTest().log(Status.INFO,
	 * "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	 * ExtentTestManager.getTest().log(Status.INFO,
	 * "<b>Step-3:</b> Observe Home page and wait for specific duration to change images automatically."
	 * ); System.out.println(driver.findElement(By.xpath(Home_Page_R.img_1)).
	 * isDisplayed()); ExtentTestManager.getTest().log(Status.INFO,
	 * "<b>Result:</b> User should gets the images change automatically on home page."
	 * ); Assert.assertEquals(true,
	 * driver.findElement(By.xpath(Home_Page_R.img_1)).isDisplayed());
	 * Thread.sleep(4000); Assert.assertEquals(true,
	 * driver.findElement(By.xpath(Home_Page_R.img_2)).isDisplayed());
	 * Thread.sleep(4000); Assert.assertEquals(true,
	 * driver.findElement(By.xpath(Home_Page_R.img_3)).isDisplayed()); }
	 */
  
  @Test(priority=3, description="To verify that user can get the image slider on the Home page and user is able to change image slider manually.")
  public void SGL_Ranchi_Home_3(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Next button of the slider.");
	  driver.findElement(By.xpath(Home_Page_R.btn_Next_Slider)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get next content of the slider.");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(Home_Page_R.img_3)).isDisplayed();
	  Assert.assertEquals(true, driver.findElement(By.xpath(Home_Page_R.img_3)).isDisplayed());
	  objs.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on Previous button of the Slider.");
	  driver.findElement(By.xpath(Home_Page_R.btn_Previous_Slider)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get previous  content of the slider.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Home_Page_R.img_2)).isDisplayed());
  }
  
  @Test(priority=4, description="To verify that user can view \"About\" section.")
  public void SGL_Ranchi_Home_4() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"About\" link from home page.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_About_DSCL)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on \"About DSCL\" page/window pop-up.");
	  String aa = "Ranchi Smart City Corporation Limited is SPV incorporated on 30.09.2016 for execution of smart city projects of Ranchi. Urban Development & Housing Department, Govt. of Jharkhand vide Memo no. 4552 dated 16.08.2016 notified the construction of Ranchi Smart City Corporation Ltd as the SPV to implement the Smart City Project.";
	  Assert.assertEquals(aa, driver.findElement(By.xpath(Home_Page_R.label_About_DSCL_01)).getText());
  }
  
  @Test(priority=5, description="To verify that user can get \"How it Works\" section.")
  public void SGL_Ranchi_Home_5() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"How it Works\" link from home page.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_How_it_works)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the how it works section .");
	  String aa = "Instead, smart cities gain value through data driven decision making. Smart Cities improve operational efficiency and reduce costs by collecting and analyzing data.";
	  Assert.assertEquals(aa, driver.findElement(By.xpath(Home_Page_R.label_About_DSCL)).getText());
  }
  
  @Test(priority=6, description="To verify that user can get \"Mission\" section.")
  public void SGL_Ranchi_Home_6() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Mission\" link from home page.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Mission)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the mission section .");
	  String aa = "The aims and objectives of the company are as follows: To plan, design, develop, implement, manage, maintain, operator and monitor the Smart City Development Projects for the city of Ranchi in accordance with Smart City Mission of the Government of India and State Government. Resource building in terms of financial and physical assets for Smart City Project.";
	  Assert.assertEquals(aa, driver.findElement(By.xpath(Home_Page_R.label_About_DSCL)).getText());
  }
  
  @Test(priority=7, description="To verify that user gets Ranchi smart city website by clicking on \"Read More\" button.")
  public void SGL_Ranchi_Home_7() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"Read More\" link from home page.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Read_more)).click();
	  Thread.sleep(2000);
	  String parent=driver.getWindowHandle();
	  Set<String>s=driver.getWindowHandles();
     // Now iterate using Iterator
	 Iterator<String> I1= s.iterator();
     while(I1.hasNext()){
    	 String child_window=I1.next();
         if(!parent.equals(child_window)){
        	 driver.switchTo().window(child_window);
             String actualTitle = driver.switchTo().window(child_window).getTitle();
             String expectedTitle="About Ranchi Smart City Corporation Ltd RSCCL | Ranchi Smart City";
             ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should navigates to web site of \"Ranchi Smart City Ltd.\"");
	         Assert.assertEquals(actualTitle, expectedTitle);
	         Thread.sleep(2000);
	         } 
     }
 
  }
  @Test(priority=8, description="To verify that user gets \"SIGN IN\" section.")
  public void SGL_Ranchi_Home_8() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"SIGN IN\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.lnk_Sign_In)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get \"Member Login\" section on home page.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Home_Page_R.label_Sign_In)).isDisplayed());
  }
  
  @Test(priority=9, description="To verify that user can get \"City GIS\" page.")
  public void SGL_Ranchi_Home_9() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on \"CITY GIS\" button from home page.");
	  driver.findElement(By.xpath(Home_Page_R.btn_City_GIS)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get landing page of the City GIS Portal.");
	  Assert.assertEquals("Ranchi GIS Portal", driver.getTitle());
  }
  
  @Test(priority=10, description="To verify that user is able to perform \"Powered by IGiS\" functionality.")
  public void SGL_Ranchi_Home_10() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Open browser.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter URL of the Ranchi application in address bar.");
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on Powered by IGiS link from bottom side.");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(Home_Page_R.lnk_Power_By)).click();
	  Thread.sleep(5000);	  
	  String parent=driver.getWindowHandle();
	  Set<String>s=driver.getWindowHandles();
     // Now iterate using Iterator
	 Iterator<String> I1= s.iterator();
     while(I1.hasNext()){
    	 String child_window=I1.next();
         if(!parent.equals(child_window)){
        	 driver.switchTo().window(child_window);
             String actualTitle = driver.switchTo().window(child_window).getTitle();
             String expectedTitle="IGiS - GIS Mapping, Image Processing & CAD Software | Scanpoint Geomatics Ltd.";
             ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the information related to igis product.");
	         Assert.assertEquals(actualTitle, expectedTitle);
	         Thread.sleep(2000);
	         } 
         }
  }
 
  
  @AfterMethod
  public void afterClass() {
	 driver.quit();
	  }
  }
