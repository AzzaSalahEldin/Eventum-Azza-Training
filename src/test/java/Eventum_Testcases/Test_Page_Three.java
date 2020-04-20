package Eventum_Testcases;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qacart.base.TestBase;
import com.qacart.utils.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class Test_Page_Three  extends TestBase {
	
	
	//dashboard/associate widget
	public Test_Page_Three() {
		super();
	}
	
	@BeforeMethod
	public void start(Method method) throws InterruptedException,Throwable {
		
		//logger = extent.startTest(method.getName());
		initialization(prop.getProperty("local"));
        driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void Test_Case_1() throws InterruptedException {
	
		login();
		driver.navigate().to("http://192.168.45.31:8080/upm-visualization-web/#/reporter/dashboard?id=352");
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		WebElement daterange=driver.findElement(By.xpath("//div[contains(@class,'react-bootstrap-daterangepicker-container')]"));
		 wait.until(ExpectedConditions.visibilityOf(daterange)).click();
		 WebElement select_date=driver.findElement(By.xpath("//li[contains(text(),'Last 30 Days')]"));
		 wait.until(ExpectedConditions.visibilityOf(select_date)).click();
		WebElement webElement2=driver.findElement(By.xpath("//button[contains(@class,'panelAction-menuBtn')]"));
        wait.until(ExpectedConditions.visibilityOf(webElement2)).click();

        driver.findElement(By.xpath("//li[@class='widget-chart-menuItem']")).click();
        
       List< WebElement> emptywidgets= driver.findElements(By.xpath("//div[contains(@class,'empty-widget-container')]"));
       WebElement anywidget= emptywidgets.get(0);
       
        wait.until(ExpectedConditions.visibilityOf( anywidget)).click();

          List<WebElement> choicebtn=driver.findElements(By.xpath("//button[@class='ms-choice']"));
            WebElement x= choicebtn.get(0); 
            x.click();
            
           WebElement menu=driver.findElement(By.xpath("//div[contains(@class,'panels-container')]//li[3]"));
           wait.until(ExpectedConditions.visibilityOf( menu)).click();
    WebElement popup=driver.findElement(By.xpath("//i[contains(@class,'ev ev-tree')]"));
           
        try {
    	     popup.click();
     	  } catch (Exception e) {
    	     JavascriptExecutor executor = (JavascriptExecutor) driver;
      	     executor.executeScript("arguments[0].click();", popup);
      	  }
        wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath("//input[@placeholder='Search in Tree']")))).sendKeys("Azza_Interface");
        Actions builder = new Actions(driver);        
        builder.sendKeys(Keys.ENTER).perform();
        WebElement intrf= driver.findElement(By.xpath("//a[contains(@title,'Azza_Interface')]"));
        wait.until(ExpectedConditions.visibilityOf(intrf));

       WebElement parent = intrf.findElement(By.xpath( "./.."));
  
       List<WebElement> options = parent.findElements(By.tagName("div"));
       WebElement bb=options.get(0);  
       bb.click();
       driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']")).click();

       WebElement elementToClick = driver.findElement(By.xpath("//div//button[contains(@tooltip,'Add Aggregation')]"));
        //   ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elementToClick);
 //elementToClick.click();
 try {
     ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elementToClick);

      	   elementToClick.click();
   	  } catch (Exception e) {
  	     JavascriptExecutor executor = (JavascriptExecutor) driver;
	     executor.executeScript("arguments[0].click();", elementToClick);
	  }
           
 WebElement attr= driver.findElement(By.xpath("//div[contains(@class,'ms-parent input-select aggSelectAttr-menu')]//button[contains(@class,'ms-choice')]"));
 
 //wait.until(ExpectedConditions.visibilityOf(attr)).click();
 
 try {
	    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", attr);

	    attr.click();
	  	  } catch (Exception e) {
	 	     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", attr);
		  }
 WebElement octets=driver.findElement(By.xpath("//div[contains(@class,'ms-parent input-select aggSelectAttr-menu')]//span[text()='Octets In']"));


try {
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", octets);

    octets.click();
  	  } catch (Exception e) {
 	     JavascriptExecutor executor = (JavascriptExecutor) driver;
	     executor.executeScript("arguments[0].click();", octets);
	  }


WebElement aggr2= driver.findElement(By.xpath("//span[contains(text(),'Select Aggregation')]"));

wait.until(ExpectedConditions.visibilityOf(aggr2)).click();

WebElement avg=driver.findElement(By.xpath("//li[contains(@class,'name-menuItem')]//span[text()='Average']"));


try {
   ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",avg);

   avg.click();
 	  } catch (Exception e) {
	     JavascriptExecutor executor = (JavascriptExecutor) driver;
	     executor.executeScript("arguments[0].click();",avg);
	  }

WebElement widget=driver.findElement(By.id("data-association-preview-pane-1"));
//WebElement save=driver.findElement(By.xpath("//div[@class='dashboard-action']//button[@tooltip='Save']"));
//
//try {
//	   ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",save);
//
//   save.click();
// 	  } catch (Exception e) {
//JavascriptExecutor executor = (JavascriptExecutor) driver;
//	     executor.executeScript("arguments[0].click();",save);
//		  }

	WebElement chart=driver.findElement(By.id("data-association-preview-pane-1"));
	WebElement pic=chart.findElement(By.tagName("div"));
	String Actual_result=pic.getAttribute("class");
	//System.out.println("actual result="+Actual_result);
	String Expected_Result="no-data";
	Assert.assertNotEquals(Expected_Result, Actual_result);

	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Throwable {
		
		if (result.getStatus() == ITestResult.FAILURE) {

			//logger.log(LogStatus.FAIL, "Test Failed " + result.getThrowable());
			String picturePath = TestUtil.TakeSnapshot(driver, result.getName());
		//	logger.log(LogStatus.FAIL, logger.addScreenCapture(picturePath));
			

		} else if (result.getStatus() == ITestResult.SKIP) {
			//logger.log(LogStatus.SKIP, "Test case Skipped is " + result.getName());

		} else {
			//logger.log(LogStatus.PASS, "Test passed");
			String picturePath = TestUtil.TakeSnapshot(driver, result.getName());
			//logger.log(LogStatus.PASS, logger.addScreenCapture(picturePath));
			
		}

		//extent.endTest(logger);
	}


	

}
