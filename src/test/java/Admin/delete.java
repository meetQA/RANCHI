package Admin;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Admin_R.LayerManagement_repository;
import Listener.ExtentTestManager;
import Listener.Extra_Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class delete {
	WebDriver driver;
	Extra_Screen ll = new Extra_Screen();
	String i = "delete_extra";
	@BeforeClass
	public void setDriver(ITestContext context) throws InterruptedException
	{
		//System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\GeckoDriver\\geckodriver.exe");
		//driver=new FirefoxDriver();

		
	}



@BeforeMethod
	public void Openurl(ITestContext context) throws InterruptedException 
	{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	context.setAttribute("WebDriver", driver);
	Thread.sleep(2000);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
		driver.get("https://qapoc.sgligis.com:10014");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_Login)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_Username)).sendKeys("Admin");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_Password)).sendKeys("1q2w3E*");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_Login1)).click();
		Thread.sleep(5000);
	}

@Test(priority=01,description="To verify that user is able to expand/collapse \"Layer Management\" menu from left panel of \"Home\" page.")
	public void PV_LayerManagement_01(Method method) throws InterruptedException 
	{
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should get \"Layer Management\" in expanded mode.");
		Assert.assertEquals("block", driver.findElement(By.xpath("//ul[@id=\"MenuItem_LayerManagement\"]")).getCssValue("display"));
		ll.Screenshot(driver, i ,method.getName()+"_01" );
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should get \"Layer Management\" in collapse mode.");
		Assert.assertEquals("none", driver.findElement(By.xpath("//ul[@id=\"MenuItem_LayerManagement\"]")).getCssValue("display"));	
	}

    

   @Test(priority=02,description="To verify that user that user is able to get Landing page \"Layer\".")
   public void PV_LayerManagement_02() throws InterruptedException {
	   
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : 1. Buttons:\r\n"
				+ "\"ADD ogc service\", \"SCAN LAYER\", Edit icon, (\"X\") icon, \"Previous\" ,\"Next\", Page control Number.\r\n"
				+ "2. \"SEARCH\" text-box.\r\n"
				+ "3. Table with the fields like: \r\n"
				+ "\"Actions\" , \"LayerTitle\", \"LayerName\", \"TableName\", \"IsActive\", \"IsBaseLayer\", \"IsQueryTable\", \"IsVisible\", \r\n"
				+ "\"Creation Time\".\r\n"
				+ "4. Dropdown: \"OGC Service\" \"Actions\" button ,\"Show entries\" .\r\n"
				+ "5. Links:           icon.");
		Assert.assertEquals(true, driver.findElement(By.xpath(LayerManagement_repository.btn_Add_OGC_Services)).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers)).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(LayerManagement_repository.btn_Delete_OGC_services)).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(LayerManagement_repository.btn_next)).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(LayerManagement_repository.btn_previous)).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(LayerManagement_repository.lnk_pageno_1)).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath("//th[text()=\"Layer Title\"]")).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath("//th[text()=\"Layer Name\"]")).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath("//th[text()=\"Table Name\"]")).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath("//th[text()=\"Active\"]")).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath("//th[text()=\"Is Base Layer?\"]")).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath("//th[text()=\"Is Queryable?\"]")).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath("//th[text()=\"Creation Time\"]")).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath("//th[text()=\"Is Visible ?\"]")).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(LayerManagement_repository.ddm_OGC_services)).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(LayerManagement_repository.btn_Action)).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(LayerManagement_repository.ddm_Show_Entries)).isDisplayed());	
   }
	   
   @Test(priority=03,description="To verify that user is able to get \"Add OGC service\" window by clicking on \"Add OGC Service\" button  from \"Layer\" page.")
	public void PV_LayerManagement_03() throws InterruptedException 
	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Add OGC Service\" button from the \"Layer\" page.");
	  	driver.findElement(By.xpath(LayerManagement_repository.btn_Add_OGC_Services)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : 1. User should able to click on  \"Add OGC Service\" button.\r\n"
		  		+ "2. User should get \"Add OGC service\" window with following:\r\n"
		  		+ "Dropdown: \"Layer Type\".\r\n"
		  		+ "Text Boxes: \"Name\", \"DB Name\" , \"URL\" , \"Db Connection String\".\r\n"
		  		+ "Checkbox: \"Is Active?\".\r\n"
		  		+ "Buttons: \"Cancel\" , \"Save\" , \"X\"(close).");
		Assert.assertEquals(true, driver.findElement(By.xpath("//h5[text()=\"Add OGC Service\"]")).isDisplayed());
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
		
	}
   
   @Test(priority=04,description="To verify that user is able to perform \"Save\" functionality of \"Add OGC Service\" window with \"Is Active?\" check-box selection.")
	public void PV_LayerManagement_04() throws InterruptedException 
	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Add OGC Service\" button from the \"Layer\" page.");
	  	driver.findElement(By.xpath(LayerManagement_repository.btn_Add_OGC_Services)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Select \"Layer Type\" from respective dropdown.");
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Enter Name in \"Name\" textbox.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_Name)).sendKeys("Test OGC Service1");
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Enter Database name in \"DB Name\" text-box.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbName)).sendKeys("police_vertical_new");
	    Thread.sleep(2000); ; 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Enter \"URL\" in\"URL\" text-box.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_URl)).sendKeys("http://192.168.3.85:1213/cgi-bin/IGiS_Ent_service.exe?IEG_PROJECT=police_vertical_ws&IEG_PROJECT=police_vertical_ws&SERVICE=WMS&VERSION=1.1.1&REQUEST=GetCapabilities");
	    Thread.sleep(2000); ; 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Enter Database connection string in \"DB Connection String\" text-box.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbConnectionString)).sendKeys("Server=192.168.2.37;Port=5432;User Id=igis;Password=igis;Database=police_vertical_new; ");
	    Thread.sleep(2000); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> :  Check-on \"Is Active ?\" check-box.");
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-15</b> : Click on \"Save\" button.");  
	  	driver.findElement(By.xpath(LayerManagement_repository.btn_Save)).click();
	    Thread.sleep(2000); ;
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : 1) User should able to click on \"Save\" button and \"Add OGC Service\" window should close.\r\n"
		  		+ "2) Added OGC service should display on portal.");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("Test OGC Service1"); 
	}
   
   @Test(priority=05,description="To verify that user is able to perform \"Save\" functionality of \"Add OGC Service\" window without \"Is Active?\" check-box selection.")
	public void PV_LayerManagement_05() throws InterruptedException 
	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Add OGC Service\" button from the \"Layer\" page.");
	  	driver.findElement(By.xpath(LayerManagement_repository.btn_Add_OGC_Services)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Select \"Layer Type\" from respective dropdown.");
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Enter Name in \"Name\" textbox.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_Name)).sendKeys("Test OGC Service2");
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Enter Database name in \"DB Name\" text-box.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbName)).sendKeys("police_vertical_new");
	    Thread.sleep(2000); ; 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Enter \"URL\" in \"URL\" text-box.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_URl)).sendKeys("http://192.168.3.85:1213/cgi-bin/IGiS_Ent_service.exe?IEG_PROJECT=police_vertical_ws&IEG_PROJECT=police_vertical_ws&SERVICE=WMS&VERSION=1.1.1&REQUEST=GetCapabilities");
	    Thread.sleep(2000); ; 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Enter Database connection string in \"DB Connection String\" text-box.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbConnectionString)).sendKeys("Server=192.168.2.37;Port=5432;User Id=igis;Password=igis;Database=police_vertical_new; ");
	    Thread.sleep(2000); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> :  Check-on \"Is Active ?\" check-box.");
	    driver.findElement(By.xpath(LayerManagement_repository.chk_Active)).click();
	    Thread.sleep(2000); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-15</b> : Click on \"Save\" button.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Save)).click();
	    Thread.sleep(2000); ;
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : 1. User should able to click on \"Save\" button and \"Save\" OGC Service.\r\n"
		  		+ "2. Saved \"OGC Service\" should display in Landing page of \"Layer\".");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("Test OGC Service2"); 
	}
   
   @Test(priority=06,description="To verify that user is able to close \"ADD OGC service\" window.")
	public void PV_LayerManagement_06() throws InterruptedException 
	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Add OGC Service\" button from the \"Layer\" page.");
	  	driver.findElement(By.xpath(LayerManagement_repository.btn_Add_OGC_Services)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on close(\"X\") button of \"ADD OGC services\" window.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should able to close \"Add OGC Service\" window.");
	    Assert.assertEquals(driver.findElement(By.xpath("//body[@class=\"abp-application-layout lp-opened-sidebar\"]")).isDisplayed(), true);
	}
   
   @Test(priority=07,description="To verify that user is able to perform \"Cancel\" functionality of \"ADD OGC service\" window.")
	public void PV_LayerManagement_07() throws InterruptedException 
	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Add OGC Service\" button from the \"Layer\" page.");
	  	driver.findElement(By.xpath(LayerManagement_repository.btn_Add_OGC_Services)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Cancel\" button of \"ADD OGC services\" window.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
	    Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should able to click on \"Cancel\" button of \"ADD OGC services\" window and \"ADD OGC services\" window should close.");
	    Assert.assertEquals(driver.findElement(By.xpath("//body[@class=\"abp-application-layout lp-opened-sidebar\"]")).isDisplayed(), true);
	}
   
   @Test(priority=8 , description="To verify that user gets validation message while \"Save\"  OGC Service with blank required details.")
	public void PV_LayerManagement_08() throws InterruptedException 
	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Add OGC Service\" button from the \"Layer\" page.");
	  	driver.findElement(By.xpath(LayerManagement_repository.btn_Add_OGC_Services)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Save\" button without entering mandatory details in \"Add OGC service\" window.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Save)).click();
	    Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should get validation message like:\r\n"
		  		+ "\"The Name field is required.\", \r\n"
		  		+ "\"The URL field is required.\" below their respective text-boxes.");
	    Assert.assertEquals(driver.findElement(By.xpath("//span[text()=\"The Name field is required.\"]")).isDisplayed(), true);
	    Assert.assertEquals(driver.findElement(By.xpath("//span[text()=\"The URL field is required.\"]")).isDisplayed(), true);
	    driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
	}
   
   @Test(priority=9,description="To verify that user gets validation message while \"Save\"  OGC Service with invalid URL.")
  	public void PV_LayerManagement_09(Method method) throws InterruptedException 
  	{
	    Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Add OGC Service\" button from the \"Layer\" page.");
	  	driver.findElement(By.xpath(LayerManagement_repository.btn_Add_OGC_Services)).click();
	    Thread.sleep(2000);
  	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Select \"Layer Type\" from respective dropdown.");
  	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Enter Name in \"Name\" textbox.");
  	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_Name)).sendKeys("Test OGC Service141");
  	    Thread.sleep(2000);
  	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Enter Database name in \"DB Name\" text-box.");
  	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbName)).sendKeys("police_vertical_new");
  	    Thread.sleep(2000); ; 
  	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Enter \"URL\" in \"URL\" text-box.");
  	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_URl)).sendKeys("htt.168.3.REQUEST=GetCapabilities");
  	    Thread.sleep(2000); ; 
  	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Enter Database connection string in \"DB Connection String\" text-box.");
  	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbConnectionString)).sendKeys("Server=192.168.2.37;Port=5432;User Id=igis;Password=igis;Database=police_vertical_new; ");
  	    Thread.sleep(2000); 
  	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> :  Check-on \"Is Active ?\" check-box.");
  	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-15</b> : Click on \"Save\" button.");
  	  	driver.findElement(By.xpath(LayerManagement_repository.btn_Save)).click();
  	    Thread.sleep(2000); ;
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should get validation message like: \r\n" +
		  "\"Invalid URI: The format of the URI could not be determined.\"."); 
  	    Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Invalid URI: The format of the URI could not be determined.\"]")).isDisplayed(), true);
  	    ll.Screenshot(driver, i ,method.getName()+"_01" );
  	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-16</b> : Click on \"OK\" button of validation message popup.");
  	    driver.findElement(By.xpath(LayerManagement_repository.btn_Ok)).click();
	    Thread.sleep(2000); 
		ExtentTestManager.getTest().log(Status.
		  INFO,"<b>Result</b> : 1. User should able to click on \"OK\" button of validation message popup.\r\n"
		  + "2. Validation message popup should close."); 
	    Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Invalid URI: The format of the URI could not be determined.\"]")).isDisplayed(), false);
	    ll.Screenshot(driver, i ,method.getName()+"_02" );
	    driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Yes)).click();
	    
  	}
   
   @Test(priority=10,description="To verify that user gets validation message when perform \"Cancel\" functionality after adding details into \"Add OGC Service\" window.")
  	public void PV_LayerManagement_10(Method method) throws InterruptedException 
  	{
	    Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Add OGC Service\" button from the \"Layer\" page.");
	  	driver.findElement(By.xpath(LayerManagement_repository.btn_Add_OGC_Services)).click();
	    Thread.sleep(2000);
 	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Select \"Layer Type\" from respective dropdown.");
 	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Enter Name in \"Name\" textbox.");
 	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_Name)).sendKeys("Test OGC Service1");
 	    Thread.sleep(2000);
 	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Enter Database name in \"DB Name\" text-box.");
 	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbName)).sendKeys("police_vertical_new");
 	    Thread.sleep(2000); ; 
 	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Enter \"URL\" in \"URL\" text-box.");
 	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_URl)).sendKeys("htt.168.3.REQUEST=GetCapabilities");
 	    Thread.sleep(2000); ; 
 	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Enter Database connection string in \"DB Connection String\" text-box.");
 	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbConnectionString)).sendKeys("Server=192.168.2.37;Port=5432;User Id=igis;Password=igis;Database=police_vertical_new; ");
 	    Thread.sleep(2000); 
 	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> :  Check-on \"Is Active ?\" check-box.");
  	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-15</b> : Click on \"Cancel\" button.");
  	    
  	  	driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
  	    Thread.sleep(2000); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should get validation message like \"Are you sure?\r\n"
		  + "You have unsaved changes.\".");
  	    Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Are you sure?\"]")).isDisplayed(), true); 
  	    Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"You have unsaved changes.\"]")).isDisplayed(), true); 
  	    ll.Screenshot(driver, i ,method.getName()+"_01" );
     	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-16</b> : Click on \"Yes\" button of validation message popup.");
  	    driver.findElement(By.xpath(LayerManagement_repository.btn_Yes)).click();
  	    Thread.sleep(2000); 
	    ExtentTestManager.getTest().log(Status. INFO,"<b>Result</b> : 1. User should able to click on \"Yes\"\" button of validation message popup and validation message popup should close.\r\n"
	      + "2. \"Add OGC Service\" window should also close.");
  	    Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Are you sure?\"]")).isDisplayed(), false); 
  	   Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"You have unsaved changes.\"]")).isDisplayed(), false); 
  	
  	}
     
   
   @Test(priority=11,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Add OGC Service\" window.")
 	public void PV_LayerManagement_11(Method method) throws InterruptedException 
 	{
	    Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Add OGC Service\" button from the \"Layer\" page.");
	  	driver.findElement(By.xpath(LayerManagement_repository.btn_Add_OGC_Services)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Select \"Layer Type\" from respective dropdown.");
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Enter Name in \"Name\" textbox.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_Name)).sendKeys("Test OGC Service1");
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Enter Database name in \"DB Name\" text-box.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbName)).sendKeys("police_vertical_new");
	    Thread.sleep(2000); ; 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Enter \"URL\" in \"URL\" text-box.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_URl)).sendKeys("htt.168.3.REQUEST=GetCapabilities");
	    Thread.sleep(2000); ; 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Enter Database connection string in \"DB Connection String\" text-box.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbConnectionString)).sendKeys("Server=192.168.2.37;Port=5432;User Id=igis;Password=igis;Database=police_vertical_new; ");
	    Thread.sleep(2000); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> :  Check-on \"Is Active ?\" check-box.");
 	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-15</b> : Click on \"Cancel\" button.");
 	    
 	  	driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
 	    Thread.sleep(2000); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should get validation message like \"Are you sure?\r\n"
		  + "You have unsaved changes.\".");
 	    Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Are you sure?\"]")).isDisplayed(), true); 
 	    Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"You have unsaved changes.\"]")).isDisplayed(), true); 
 	    ll.Screenshot(driver, i ,method.getName()+"_01" ); 
 	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-16</b> : Click on \"Cancel\" button of validation message popup.");
 	    driver.findElement(By.xpath("//div[@class=\"swal-modal\"]//button[text()=\"Cancel\"]")).click();
	    Thread.sleep(2000); 
	    ExtentTestManager.getTest().log(Status. INFO,"<b>Result</b> : 1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.\r\n"
		  + "2. \"Add OGC Service\" window should display on screen.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Are you sure?\"]")).isDisplayed(), false); 
 	    Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"You have unsaved changes.\"]")).isDisplayed(), false); 
 	   ll.Screenshot(driver, i ,method.getName()+"_02" ); 
 	    driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
 	    driver.findElement(By.xpath(LayerManagement_repository.btn_Yes)).click();
 	    Thread.sleep(2000); 
 	}
   
   @Test(priority=12,description="To verify that user gets validation message for create \"OGC Service\" which is already exist.")
	public void PV_LayerManagement_12(Method method) throws InterruptedException 
	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Add OGC Service\" button from the \"Layer\" page.");
	  	driver.findElement(By.xpath(LayerManagement_repository.btn_Add_OGC_Services)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Select \"Layer Type\" from respective dropdown.");
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Enter Name in \"Name\" textbox.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_Name)).sendKeys("Test OGC Service1");
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Enter Database name in \"DB Name\" text-box.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbName)).sendKeys("police_vertical_new");
	    Thread.sleep(2000); ; 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Enter \"URL\" in \"URL\" text-box.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_URl)).sendKeys("http://192.168.3.85:1213/cgi-bin/IGiS_Ent_service.exe?IEG_PROJECT=police_vertical_ws&IEG_PROJECT=police_vertical_ws&SERVICE=WMS&VERSION=1.1.1&REQUEST=GetCapabilities");
	    Thread.sleep(2000); ; 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Enter Database connection string in \"DB Connection String\" text-box.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbConnectionString)).sendKeys("Server=192.168.2.37;Port=5432;User Id=igis;Password=igis;Database=police_vertical_new; ");
	    Thread.sleep(2000); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> :  Check-on \"Is Active ?\" check-box.");
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-15</b> : Click on \"Save\" button.");
	  	driver.findElement(By.xpath(LayerManagement_repository.btn_Save)).click();
	    Thread.sleep(2000); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should get validation message like \"OGC service with this Name already exist\".");
	    Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"OGC service with this Name already exist\"]")).isDisplayed(), true); 
	    Thread.sleep(2000); 
	    ll.Screenshot(driver, i ,method.getName()+"_01" ); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-16</b> :  Click on \"OK\" button of validation popup.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Ok)).click();
	    Thread.sleep(2000); 
	    driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
	 	driver.findElement(By.xpath(LayerManagement_repository.btn_Yes)).click();
	 	 Thread.sleep(2000); 
	}
   
   @Test(priority=13,description="To verify that user is able to Edit \"OGC service\" from  \"Layer\" page.")
	public void PV_LayerManagement_13() throws InterruptedException 
	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("Test OGC Service1"); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Edit\" button in \"Layer\" page.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Edit_OGC_services)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Edit Name from \"Name\" textbox.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_Name)).sendKeys("EDIT");
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Edit Database name from \"DB Name\" text-box.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbName)).sendKeys("");
	    Thread.sleep(2000); ; 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Edit \"URL\" from \"URL\" text-box.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_URl)).sendKeys("");
	    Thread.sleep(2000); ; 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Edit Database connection string from \"Db Connection String\" text-box.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbConnectionString)).sendKeys("");
	    Thread.sleep(2000); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> :  Edit selection of  \"Is Active ?\" check-box.");
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-15</b> : Click on \"Save\" button of \"Edit OGC Service\" window .");
	  	driver.findElement(By.xpath(LayerManagement_repository.btn_Save)).click();
	    Thread.sleep(2000); ;
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : 1. User should able to click on \"Save\" button and \"Save\" OGC Service.\r\n"
		  + "2. User should able to save edited changes of OGC Service and should display in \"Layer\" page.");
	    Select dropdown1 = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown1.selectByVisibleText("EDITTest OGC Service1"); 
	}	  	
  
   @Test(priority=14,description="To verify that user is able to close \"Edit OGC service\" window.")
	public void PV_LayerManagement_14() throws InterruptedException 
	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("EDITTest OGC Service1"); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Edit\" button in \"Layer\" page.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Edit_OGC_services)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> :  Click on close(\"X\") button of \"Edit OGC Service\" page.");
	  	driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
	    Thread.sleep(2000); ;
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should able to close \"Edit OGC Service\" window." );
		Assert.assertEquals(driver.findElement(By.xpath("//body[@class=\"abp-application-layout lp-opened-sidebar\"]")).isDisplayed(), true);
	}	
   
   @Test(priority=15,description="To verify that user is able to perform \"Cancel\" functionality of \"Edit OGC Service\" window.")
  	public void PV_LayerManagement_15() throws InterruptedException 
  	{
  	    Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
  		Thread.sleep(1000);
  		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
  		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
  		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
  		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
  		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
  		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
  		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
  		Thread.sleep(2000);
  		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
  		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
  	    Thread.sleep(2000);
  	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
  	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
  	    dropdown.selectByVisibleText("EDITTest OGC Service1"); 
  	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Edit\" button in \"Layer\" page.");
  	    driver.findElement(By.xpath(LayerManagement_repository.btn_Edit_OGC_services)).click();
  	    Thread.sleep(2000);
  	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> :  Click on \"Cancel\" button of \"Edit OGC services\" window.");
  	  	driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
  	    Thread.sleep(2000); ;
  	    ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit OGC services\" window and \"Edit OGC services\" window should close." );
  		Assert.assertEquals(driver.findElement(By.xpath("//body[@class=\"abp-application-layout lp-opened-sidebar\"]")).isDisplayed(), true);
  	}	
   
   @Test(priority=16,description="To verify that user gets validation message when perform \"Cancel\" functionality after editing details into \"Add OGC Service\" window.")
	public void PV_LayerManagement_16(Method method) throws InterruptedException 
	{
	    Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
 		Thread.sleep(1000);
 		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
 		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
 		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
 		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
 		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
 		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
 		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
 		Thread.sleep(2000);
 		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
 		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
 	    Thread.sleep(2000);
 	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
 	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
 	    dropdown.selectByVisibleText("EDITTest OGC Service1"); 
 	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Edit\" button in \"Layer\" page.");
 	    driver.findElement(By.xpath(LayerManagement_repository.btn_Edit_OGC_services)).click();
 	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Edit Name from \"Name\" textbox.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_Name)).sendKeys("EDIT");
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Edit Database name from \"DB Name\" text-box.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbName)).sendKeys("");
	    Thread.sleep(2000); ; 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Edit \"URL\" from \"URL\" text-box.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_URl)).sendKeys("");
	    Thread.sleep(2000); ; 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Edit Database connection string from \"Db Connection String\" text-box.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbConnectionString)).sendKeys("");
	    Thread.sleep(2000); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> :  Edit selection of  \"Is Active ?\" check-box.");
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-15</b> : Click on\"Cancel\"/\"X\"(close) button of \"Edit OGC Service\" window. .");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
	    Thread.sleep(2000); ;
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should get validation message like \"Are you sure?\r\n"
		  + "You have unsaved changes.\".");
	    Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Are you sure?\"]")).isDisplayed(), true); 
	    Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"You have unsaved changes.\"]")).isDisplayed(), true); 
	    ll.Screenshot(driver, i ,method.getName()+"_01" );
	 	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-16</b> :Click on \"Yes\" button of validation message popup.");
	 	driver.findElement(By.xpath(LayerManagement_repository.btn_Yes)).click();
		Thread.sleep(2000); 
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : 1. User should able to click on \"Yes\"\" button of validation message popup and validation message popup should close.\r\n"
			  + "2. \"Edit OGC Service\" window should also close.");
	    Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Are you sure?\"]")).isDisplayed(), false); 
	 	Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"You have unsaved changes.\"]")).isDisplayed(), false);  
	}	  	
 
   
   @Test(priority=17,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Edit OGC Service\" window.")
	public void PV_LayerManagement_17(Method method) throws InterruptedException 
	{
	    Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("EDITTest OGC Service1"); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Edit\" button in \"Layer\" page.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Edit_OGC_services)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Edit Name from \"Name\" textbox.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_Name)).sendKeys("EDIT");
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Edit Database name from \"DB Name\" text-box.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbName)).sendKeys("");
	    Thread.sleep(2000); ; 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Edit \"URL\" from \"URL\" text-box.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_URl)).sendKeys("");
	    Thread.sleep(2000); ; 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Edit Database connection string from \"Db Connection String\" text-box.");
	  	driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbConnectionString)).sendKeys("");
	    Thread.sleep(2000); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> :  Edit selection of  \"Is Active ?\" check-box.");
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-15</b> : Click on\"Cancel\"/\"X\"(close) button of \"Edit OGC Service\" window. .");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
	    Thread.sleep(2000); ;
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should get validation message like \"Are you sure?\r\n"
		  + "You have unsaved changes.\".");
	    Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Are you sure?\"]")).isDisplayed(), true); 
	    Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"You have unsaved changes.\"]")).isDisplayed(), true); 
	    ll.Screenshot(driver, i ,method.getName()+"_01" );
	 	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-16</b> :Click on \"Cancel\" button of validation message popup.");
	 	driver.findElement(By.xpath("//div[@class=\"swal-modal\"]//button[text()=\"Cancel\"]")).click();
		Thread.sleep(2000); 
		ExtentTestManager.getTest().log(Status. INFO,"<b>Result</b> : 1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.\r\n"
			  + "2. \"Edit OGC Service\" window should display on screen.");
	    Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Are you sure?\"]")).isDisplayed(), false); 
	 	Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"You have unsaved changes.\"]")).isDisplayed(), false); 
	    ll.Screenshot(driver, i ,method.getName()+"_02" );
	 	driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
	  	driver.findElement(By.xpath(LayerManagement_repository.btn_Yes)).click();
	  	Thread.sleep(2000); 
	}
   
   @Test(priority=18,description="To verify that user is able to perform \"SCAN LAYER\" functionality of \"Layer\"page.")
	public void PV_LayerManagement_18() throws InterruptedException 
	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("EDITTest OGC Service1"); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should get Scan Layer page of selected \"OGC Service\"  with following:"
		  + "1. Links: \" Layer Error Count : \", \" Layer Publish Pending : \", \" Layer With Columns Issue : \", \r\n"
		  + "\" Layer Recorded Pending : \" , \" Layer Table Not Found :\" , \" Layer Sync Pending : \" , \" Clear \""
		  + "2. Buttons: \"<- Back\" , \"Rescan\", \"Next\" , \"Previous\", Page No. control."
		  + "3. \"Select Layer\" dropdown.");
	    Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Layer Error Count : 0')]")).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Layer Recorded Pending : 0')]")).isDisplayed(), true);  
	    Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Layer Publish Pending : 0')]")).isDisplayed(), true);  
	    Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Layer Table Not Found : 0')]")).isDisplayed(), true);  
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Layer With Columns Issue : 0')]")).isDisplayed(), true);  
		Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Layer Sync Pending : 0')]")).isDisplayed(), true);  
	    Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Clear')]")).isDisplayed(), true);  	 
	}
   
   @Test(priority=19,description="To verify that user is able to get back to \"Layer\" page from selected \"OGC Service\" Scan Layer page after clicking on the \"<-Back\" button.")
	public void PV_LayerManagement_19() throws InterruptedException 
	{
	    Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("EDITTest OGC Service1"); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click on \"<-Back\" button of Scan Layer page of selected \"OGC Service\" .");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Back )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should get back to \"Layer\" page from Scan Layer page of selected \"OGC Service\".");
		Assert.assertEquals(driver.findElement(By.xpath("//h5[text()=\"Layers\"]")).isDisplayed(), true); 	 
	}
   
   @Test(priority=20,description="To verify that user is able to perform \"Rescan\" functionality.")
   public void PV_LayerManagement_20() throws InterruptedException 
	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("EDITTest OGC Service1"); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click \"Rescan\" button.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should get list of available layers in selected \"OGC\" service."); 
	    Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Error )).isDisplayed(), true);
		  Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Record_Pending)).isDisplayed(), true);  
		  Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Publish)).isDisplayed(), true);  
		  Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Table_NotFound  )).isDisplayed(), true);  
		  Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Columns_Issue)).isDisplayed(), true);  
		  Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Sync_Pending)).isDisplayed(), true);  
		  Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.lnk_Clear)).isDisplayed(), true);  	 	 
	}
  
   @Test(priority=21,description="To verify that user is able to get layers in which error count is present by clicking on \"Layer Error Count\" link from Scan Layer page of selected \"OGC Service\".")
	public void PV_LayerManagement_21() throws InterruptedException 
	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("EDITTest OGC Service1"); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click \"Rescan\" button.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"Layer Error Count\" link.");
	    driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Error )).click();
	    Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should get list of layers in which error count is present.");
	    String a1 =  driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Error )).getText();
	    String[] word=a1.split("\\s");
		for(String w:word){
			System.out.println(w);  
		} 
		String b1 = word[4];
		System.out.println(b1);
		String a2 =  driver.findElement(By.xpath("//div[@class=\"col-sm-12 col-md-5\"]")).getText();
		String[] words=a2.split("\\s");
		for(String w:words){ 
			System.out.println(w);  
		} 
		String b2 = words[5];
		System.out.println(b2);
		Assert.assertEquals(b1, b2);
	}
   
   @Test(priority=22,description="To verify that user is able to get layers in which publishing work is pending by clicking on \"Layer Publish Pending\" link from Scan Layer page of selected \"OGC Service\" .")
	public void PV_LayerManagement_22() throws InterruptedException 
	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("EDITTest OGC Service1"); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click \"Rescan\" button.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"Layer Publish Pending\" link.");
	    driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Publish )).click();
	    Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : 1. User should get list of layers in which some publishing work is pending./Showing 0 entries if layers have no publishing work is pending.\r\n"
		  + "(Ideally shows 0.)\r\n" +
		 "2. Layers in which publishing work is pending should display with           icon." );
		String a1 =  driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Publish )).getText();
	    String[] word=a1.split("\\s");
		for(String w:word){ 
			System.out.println(w);  
		} 
		String b1 = word[4];
		System.out.println(b1);
		String a2 =  driver.findElement(By.xpath("//div[@class=\"col-sm-12 col-md-5\"]")).getText();
		String[] words=a2.split("\\s");
		for(String w:words){ 
			System.out.println(w);  
		} 
		String b2 = words[5];
		System.out.println(b2);
		Assert.assertEquals(b1, b2);
	}
   
   @Test(priority=23,description="To verify that user is able to get layers in which issue with DB column present by clicking on \"Layer with Column Issue\" link from Scan Layer page of selected \"OGC Service\" .")
	public void PV_LayerManagement_23() throws InterruptedException 
	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("EDITTest OGC Service1"); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click \"Rescan\" button.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"Layer with Column Issue\" link.");
	    driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Columns_Issue )).click();
	    Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : 1. User should get list of layers in which  issue with DB column present./Showing 0 entries if layers have no issue with DB column is present.\r\n"
		  + "2. Layers in which issue with DB column is present display with             icon." ); 
	    String a1 =  driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Columns_Issue )).getText();
	    String[] word=a1.split("\\s");
		for(String w:word){ 
			System.out.println(w);  
		} 
		String b1 = word[5];
		System.out.println(b1);
		String a2 =  driver.findElement(By.xpath("//div[@class=\"col-sm-12 col-md-5\"]")).getText();
		String[] words=a2.split("\\s");
		for(String w:words){ 
			System.out.println(w);  
		} 
		String b2 = words[5];
		System.out.println(b2);
		Assert.assertEquals(b1, b2);
	}
   
   @Test(priority=24,description="To verify that user is able to get layers in which layer recorded is pending by clicking on \"Layer Recorded Pending\" link from Scan Layer page of selected \"OGC Service\" .")
	public void PV_LayerManagement_24() throws InterruptedException 
	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("EDITTest OGC Service1"); 
	    //ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on "Scan Layer" button from "Layer" page.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers )).click();
	    Thread.sleep(2000);
	  //ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click "Rescan" button.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan )).click();
	    Thread.sleep(2000);
	    
	  //ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on "Layer Recorded Pending" link.");
	    driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Record_Pending)).click();
	    Thread.sleep(2000);
		
		/*
		 * ExtentTestManager.getTest().log(Status.
		 * INFO,"<b>Result</b> : 1. User should get list of layers in which layer recorded pending.\r\n"
		 * +
		 * "2. Layers with layer recorded pending should display with             icon."
		 * );
		 */
		 
	    String a1 =  driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Record_Pending )).getText();
	    String[] word=a1.split("\\s");
		for(String w:word){  
		System.out.println(w);  
		} 
		String b1 = word[4];
		System.out.println(b1);
		String a2 =  driver.findElement(By.xpath("//div[@class=\"col-sm-12 col-md-5\"]")).getText();
		String[] words=a2.split("\\s");
		for(String w:words){  
		System.out.println(w);  
		} 
		String b2 = words[5];
		System.out.println(b2);
		Assert.assertEquals(b1, b2);
	}
   
   @Test(priority=25,description="To verify that user is able to get layers in which no table available in current database by clicking on \"Layer Table Not Found \" link from Scan Layer page of selected \"OGC Service\" .")
  	public void PV_LayerManagement_25() throws InterruptedException 
  	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("EDITTest OGC Service1"); 
  	    //ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on "Scan Layer" button from "Layer" page.");
  	    driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers )).click();
  	    Thread.sleep(2000);
  	  //ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click "Rescan" button.");
  	    driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan )).click();
  	    Thread.sleep(2000);
  	    
  	  //ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on "Layer Table Not Found " link.");
  	    driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Table_NotFound)).click();
  	    Thread.sleep(2000);
  		
		/*
		 * ExtentTestManager.getTest().log(Status.
		 * INFO,"<b>Result</b> : 1. User should get list of layers in which no table available in current database./Showing 0 entries if layers have no table available in current database.\r\n"
		 * +
		 * "2. Layers with  no table available in current database should display with         icon."
		 * );
		 */
  		 
  	    String a1 =  driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Table_NotFound )).getText();
  	    String[] word=a1.split("\\s");
  		for(String w:word){  
  		System.out.println(w);  
  		} 
  		String b1 = word[5];
  		System.out.println(b1);
  		String a2 =  driver.findElement(By.xpath("//div[@class=\"col-sm-12 col-md-5\"]")).getText();
  		String[] words=a2.split("\\s");
  		for(String w:words){  
  		System.out.println(w);  
  		} 
  		String b2 = words[5];
  		System.out.println(b2);
  		Assert.assertEquals(b1, b2);
  	}
   
   @Test(priority=26,description="To verify that use is able to get layers in which some syncing is pending by clicking on \"Layer Sync Pending\" link from Scan Layer page of selected \"OGC Service\" .")
 	public void PV_LayerManagement_26() throws InterruptedException 
 	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("EDITTest OGC Service1"); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click \"Rescan\" button.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan )).click();
	    Thread.sleep(2000);
 	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"Layer Sync Pending\" link.");
 	    driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Sync_Pending)).click();
 	    Thread.sleep(2000);
 	    ExtentTestManager.getTest().log(Status. INFO,"<b>Result</b> : 1. User should get layers in which some syncing is pending./Showing 0 entries if layers have no syncing is pending.\r\n"
		 + "2. Layers with some syncing is pending should display with            icon." );
 	    String a1 =  driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Sync_Pending )).getText();
 	    String[] word=a1.split("\\s");
 		for(String w:word){  
 			System.out.println(w);  
 		} 
 		String b1 = word[4];
 		System.out.println(b1);
 		String a2 =  driver.findElement(By.xpath("//div[@class=\"col-sm-12 col-md-5\"]")).getText();
 		String[] words=a2.split("\\s");
 		for(String w:words){  
 			System.out.println(w);  
 		} 
 		String b2 = words[5];
 		System.out.println(b2);
 		Assert.assertEquals(b1, b2);
 	}
   
   @Test(priority=27,description="To verify that user is able to perform \"Clear\" link functionality from Scan Layer page of selected \"OGC Service\" .")
	public void PV_LayerManagement_27() throws InterruptedException 
	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("EDITTest OGC Service1"); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click \"Rescan\" button.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"Layer Sync Pending\" link.");
	    driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Sync_Pending)).click();
	    Thread.sleep(2000);
	    String a2 =  driver.findElement(By.xpath("//div[@class=\"col-sm-12 col-md-5\"]")).getText();
		String[] words=a2.split("\\s");
		for(String w:words){  
			System.out.println(w);  
		} 
		String b2 = words[5];
		System.out.println(b2);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Click on \"Clear\" link.");
	    driver.findElement(By.xpath(LayerManagement_repository.lnk_Clear)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status. INFO,"<b>Result</b> : User should get all the layers available in \"OGC Service\" and removing any other pre-applied filters."  );
	    String a1 =  driver.findElement(By.xpath("//div[@class=\"col-sm-12 col-md-5\"]")).getText();
		String[] word=a1.split("\\s");
		for(String w:word){ 
			System.out.println(w);  
		} 
		String b1 = word[5];
		System.out.println(b1);
		Assert.assertNotEquals(b1, b2);
	}
   
   @Test(priority=28,description="To verify that user is able to perform \"Add Layer\" functionality.")
  	public void PV_LayerManagement_28(Method method) throws InterruptedException 
  	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("EDITTest OGC Service1"); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click \"Rescan\" button.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan )).click();
	    Thread.sleep(2000);
  	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"Add Layer\" button of any particular layer.");
  	    driver.findElement(By.xpath(LayerManagement_repository.btn_Add_Layer_ATM)).click();
  	    Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : 1. User should get validation message like \"Added Successfully\".\r\n"
		  + "2. \"Layer Sync Pending\" shows 1 increment value after  adding layer.\r\n"
		  + "3. Added layer should display in list of  \"OGC service \" in \"Layer\" page.\r\n"
		  + "4. User should get two button namely \"Activate\" , \"Delete\" on added layer." );
		Assert.assertEquals(true,driver.findElement(By.xpath(LayerManagement_repository.btn_Activate_ATM )).isDisplayed());
  	    Assert.assertEquals(true,driver.findElement(By.xpath(LayerManagement_repository.btn_Discard_ATM)).isDisplayed());
  	    ll.Screenshot(driver, i ,method.getName()+"_01" );
  	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click \"Rescan\" button.");
  	    driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status. INFO,"<b>Result</b> : User should get \"0\" value of \"Layer Sync Pending\"."  ); 
	    String a1 =  driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Sync_Pending )).getText();
 	    String[] word=a1.split("\\s");
 		for(String w:word){ 
 			System.out.println(w);  
 		} 
 		String b1 = word[4];
 		System.out.println(b1);
 		Assert.assertEquals("0", b1);
  	}
   
   @Test(priority=29,description="To verify that user is able to \"Activate\"/\"Deactivate\" added layer.")
 	public void PV_LayerManagement_29(Method method) throws InterruptedException 
 	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("EDITTest OGC Service1"); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click \"Rescan\" button.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan )).click();
	    Thread.sleep(2000);
 	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> :  Click on \"Deactivate\" button.");
 	    driver.findElement(By.xpath(LayerManagement_repository.btn_Deactivate_ATM )).click();
 	    Thread.sleep(2000);  
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : 1. User should get validation message like \"Layer Updated Successfully\".\r\n"
		  + "2. User should get \"Activate\" button at place of \"Deactivate\" button." ); 
 	    Assert.assertEquals(true,driver.findElement(By.xpath(LayerManagement_repository.btn_Activate_ATM )).isDisplayed());
 	    ll.Screenshot(driver, i ,method.getName()+"_01" );
 	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> :  Click on \"Activate\" button.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Activate_ATM )).click();
	    Thread.sleep(2000);  
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : 1. User should get validation message like \"Layer Updated Successfully\".\r\n"
		  + "2. User should get \"Activate\" button at place of \"Deactivate\" button." );
	    Assert.assertEquals(true,driver.findElement(By.xpath(LayerManagement_repository.btn_Deactivate_ATM )).isDisplayed());
 	 
 	}
   
   @Test(priority=30,description="To verify that user is able to perform \"Delete\" functionality of scan layer page of selected \"OGC Service.")
	public void PV_LayerManagement_30(Method method) throws InterruptedException 
	{
	    Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("EDITTest OGC Service1"); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click \"Rescan\" button.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan )).click();
	    Thread.sleep(2000);
	    String a2 =  driver.findElement(By.xpath("//div[@class=\"col-sm-12 col-md-5\"]")).getText();
		String[] words=a2.split("\\s");
		for(String w:words){
			System.out.println(w);  
		} 
		String b2 = words[5];
		System.out.println(b2);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> :  Click on \"Delete\" button any particular layer.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Discard_ATM )).click();
	    Thread.sleep(2000);  
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should get validation message like \"Deleted Successfully\" and layer should delete." );
	    String a1 =  driver.findElement(By.xpath("//div[@class=\"col-sm-12 col-md-5\"]")).getText();
		String[] word=a1.split("\\s");
		for(String w:word){ 
			System.out.println(w);  
		} 
		String b1 = word[5];
		System.out.println(b1);
		Assert.assertNotEquals(b1, b2);
		ll.Screenshot(driver, i ,method.getName()+"_01" );
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> :   Click on \"Rescan\" button.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan )).click();
	    Thread.sleep(2000);  
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : 1. User should get validation message like \"Layer Updated Successfully\".\r\n"
		  + "2. User should get \"Activate\" button at place of \"Deactivate\" button.");
		String a3 =  driver.findElement(By.xpath("//div[@class=\"col-sm-12 col-md-5\"]")).getText();
	    String[] wordss=a3.split("\\s");
		for(String w:wordss){  
			System.out.println(w);  
		} 
		String b3 = wordss[5];
		System.out.println(b3);
		Assert.assertEquals(b3, b2);
	}
   
   @Test(priority=31,description="To verify that user is able to perform \"Add Mask Layer\" functionality.")
	public void PV_LayerManagement_31() throws InterruptedException 
	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("EDITTest OGC Service1"); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click \"Rescan\" button.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan )).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Add_Layer_ATM)).click();
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan )).click();
  	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"Add Mask Layer\" button of any particular layer.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Add_Mask_Layer_boundary_ward)).click();
	    Thread.sleep(2000);  
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Enter \"Title Name\" in \"Title Name\" check-box.");
	    driver.findElement(By.xpath(LayerManagement_repository.txt_Title_Name)).sendKeys("Test Mask Layer");
	    Thread.sleep(2000);  
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Check-on \"Is Mask?\" check-box.");
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> : Select \"Mask Layer Name\" from respective dropdown.");
	    Select dropdown1 = new Select(driver.findElement(By.id("sl_LayerList")));  
	    dropdown1.selectByVisibleText("atm");  
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-15</b> : Click on \"Save\" button.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();
	    Thread.sleep(2000);  
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : 1. User should able click on \"Save button\" and \"Add-Mask Layer\" window should close.\r\n"
		  + "2. Selected particular layer is added as Mask Layer" ); 
	    Select dropdown2 = new Select(driver.findElement(By.id("sl_LayersList")));  
	    dropdown2.selectByVisibleText("boundary_ward");  
	}
   
   @Test(priority=32,description="To verify that user is able to perform \"Add Mask Layer\" functionality without \"Is Mask?\" check-box selection.")
	public void PV_LayerManagement_32() throws InterruptedException 
	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("EDITTest OGC Service1"); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click \"Rescan\" button.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"Add Mask Layer\" button of any particular layer.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Add_Mask_Layer_bank)).click();
	    Thread.sleep(2000);  
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Enter \"Title Name\" in \"Title Name\" check-box.");
	    driver.findElement(By.xpath(LayerManagement_repository.txt_Title_Name)).sendKeys("Test Mask Layer1");
	    Thread.sleep(2000);  
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Check-on \"Is Mask?\" check-box.");
	    driver.findElement(By.xpath(LayerManagement_repository.chk_Is_Mask)).click();
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> : Select \"Mask Layer Name\" from respective dropdown.");
	    Select dropdown1 = new Select(driver.findElement(By.id("sl_LayerList")));  
	    dropdown1.selectByVisibleText("atm");  
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-15</b> : Click on \"Save\" button.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();
	    Thread.sleep(2000);  
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : 1. User should able click on \"Save button\" and \"Add-Mask Layer\" window should close.\r\n"
		  + "2. Selected particular layer is added as Mask Layer" ); 
	    Select dropdown2 = new Select(driver.findElement(By.id("sl_LayersList")));  
	    dropdown2.selectByVisibleText("bank");  
	}
   
   @Test(priority=33,description="To verify that user is able to perform \"Cancel\" functionality of \"Add-Mask Layer\" window.")
	public void PV_LayerManagement_33() throws InterruptedException 
	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("EDITTest OGC Service1"); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click \"Rescan\" button.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"Add Mask Layer\" button of any particular layer.");
	    driver.findElement(By.xpath("//div[@id=\"_boundary_zone\"]//a[text()=\"Add Mask-Layer\"]")).click();
	    Thread.sleep(2000);  
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Click on \"Cancel\" button of \"Add-Mask Layer\" window.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
	    Thread.sleep(2000);  	
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should able to click on \"Cancel\" button of \"Add Layer\" window and \"Add-Mask Layer\" window should close." );
	    Assert.assertEquals(driver.findElement(By.xpath("//body[@class=\"abp-application-layout lp-opened-sidebar\"]")).isDisplayed(), true); 
	}
   
   @Test(priority=34,description="To verify that user is able to close \"Add-Mask Layer\" window.")
	public void PV_LayerManagement_34() throws InterruptedException 
	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("EDITTest OGC Service1"); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click \"Rescan\" button.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"Add Mask Layer\" button of any particular layer.");
	    driver.findElement(By.xpath("//div[@id=\"_boundary_zone\"]//a[text()=\"Add Mask-Layer\"]")).click();
	    Thread.sleep(2000);  
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Click on \"X\"(close) button of Add-Mask Layer window.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
	    Thread.sleep(2000);  	
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should able to click on \"Cancel\" button of \"Add Layer\" window and \"Add-Mask Layer\" window should close." );
		Assert.assertEquals(driver.findElement(By.xpath("//body[@class=\"abp-application-layout lp-opened-sidebar\"]")).isDisplayed(), true); 
	}
   
   @Test(priority=35,description="To verify that user gets validation message when perform \"Save\" functionality with blank required details of \"Add-Mask Layer\" window.")
	public void PV_LayerManagement_35(Method method) throws InterruptedException 
	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("EDITTest OGC Service1"); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click \"Rescan\" button.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"Add Mask Layer\" button of any particular layer.");
	    driver.findElement(By.xpath("//div[@id=\"_boundary_zone\"]//a[text()=\"Add Mask-Layer\"]")).click();
	    Thread.sleep(2000);  
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Click on \"Save\" button of \"Add-Mask Layer\" window without entering mandatory deta");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();
	    Thread.sleep(2000);  	
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should able to click on \"Cancel\" button of \"Add Layer\" window and \"Add-Mask Layer\" window should close." );
		Assert.assertEquals(driver.findElement(By.xpath("//span[text()=\"Title Name is required\"]")).isDisplayed(), true); 
	    Assert.assertEquals(driver.findElement(By.xpath("//span[text()=\"MaskLayer Name is required.\"]")).isDisplayed(), true); 
	    ll.Screenshot(driver, i ,method.getName()+"_01" );   
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
		Thread.sleep(2000);
	}
   
   @Test(priority=36,description="To verify that user gets validation message when perform \"Cancel\"/\"X\"(close) functionality after Adding details in \"Add Layer\" window.")
	public void PV_LayerManagement_36(Method method) throws InterruptedException 
	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("EDITTest OGC Service1"); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click \"Rescan\" button.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"Add Mask Layer\" button of any particular layer.");
	    driver.findElement(By.xpath("//div[@id=\"_boundary_zone\"]//a[text()=\"Add Mask-Layer\"]")).click();
	    Thread.sleep(2000);  
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Enter \"Title Name\" in \"Title Name\" check-box.");
	    driver.findElement(By.xpath(LayerManagement_repository.txt_Title_Name)).sendKeys("Test Mask Layer");
	    Thread.sleep(2000);  
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Check-on \"Is Mask?\" check-box.");
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> : Select \"Mask Layer Name\" from respective dropdown.");
	    Select dropdown1 = new Select(driver.findElement(By.id("sl_LayerList")));  
	    dropdown1.selectByVisibleText("atm");  
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-15</b> : Click on \"Cancel\"/\"X\"(close) button of \"Add Layer\" window.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
	    Thread.sleep(2000);  
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should get validation message like \"Are you sure? You have unsaved changes.\"." );
	    Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Are you sure?\"]")).isDisplayed(), true); 
	  	Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"You have unsaved changes.\"]")).isDisplayed(), true); 
	  	ll.Screenshot(driver, i ,method.getName()+"_01" );   
	  	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-16</b> : Click on \"Yes\" button of validation message popup.");
	  	driver.findElement(By.xpath(LayerManagement_repository.btn_Yes)).click();
	  	Thread.sleep(2000); 
		ExtentTestManager.getTest().log(Status. INFO,"<b>Result</b> : 1. User should able to click on \"Yes\"\" button of validation message popup and validation message popup should close.\r\n"
			  + "2. \"Add-Mask Layer\" window should also close.");
	  	Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Are you sure?\"]")).isDisplayed(), false); 
	  	Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"You have unsaved changes.\"]")).isDisplayed(), false); 
	}
   
   @Test(priority=37,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Add-Mask Layer\" window.")
	public void PV_LayerManagement_37(Method method) throws InterruptedException 
	{
	   Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
	    Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));  
	    dropdown.selectByVisibleText("EDITTest OGC Service1"); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click \"Rescan\" button.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan )).click();
	    Thread.sleep(2000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"Add Mask Layer\" button of any particular layer.");
	    driver.findElement(By.xpath("//div[@id=\"_boundary_zone\"]//a[text()=\"Add Mask-Layer\"]")).click();
	    Thread.sleep(2000);  
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Enter \"Title Name\" in \"Title Name\" check-box.");
	    driver.findElement(By.xpath(LayerManagement_repository.txt_Title_Name)).sendKeys("Test Mask Layer");
	    Thread.sleep(2000);  
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Check-on \"Is Mask?\" check-box.");
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> : Select \"Mask Layer Name\" from respective dropdown.");
	    Select dropdown1 = new Select(driver.findElement(By.id("sl_LayerList")));  
	    dropdown1.selectByVisibleText("atm");  
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-15</b> : Click on \"Cancel\"/\"X\"(close) button of \"Add Layer\" window.");
	    driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
	    Thread.sleep(2000);  
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should get validation message like \"Are you sure? You have unsaved changes.\"." );
	    Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Are you sure?\"]")).isDisplayed(), true); 
	  	Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"You have unsaved changes.\"]")).isDisplayed(), true); 
	  	ll.Screenshot(driver, i ,method.getName()+"_01" );   
	  	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-16</b> : Click on \"Cancel\" button of validation message popup.");
	  	driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
	  	Thread.sleep(2000); 
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : 1. User should able to click on \"Cancel\"\" button of validation message popup and validation message popup should close.\r\n"
			 + "2. \"Add-Mask Layer\" window should also close.");
	  	Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Are you sure?\"]")).isDisplayed(), false); 
	  	Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"You have unsaved changes.\"]")).isDisplayed(), false); 
	  	ll.Screenshot(driver, i ,method.getName()+"_02" );   
	  	driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
	 	driver.findElement(By.xpath(LayerManagement_repository.btn_Yes)).click();
	 	Thread.sleep(2000); 
	}
@AfterMethod
	public void Aftermethod() throws InterruptedException
	{
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(LayerManagement_repository.profile_admin))).
		build().perform(); Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_logout)).click();
		Thread.sleep(2000);
		 
		driver.close();
		Thread.sleep(1000);
	}

	
}
