package Eventum_Testcases;


import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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


public class Test_Page_One extends TestBase {
	
	//dashboard //add dashboard
	public Test_Page_One() {
		super();
	}
	
	@BeforeMethod
	public void start(Method method) throws InterruptedException, Throwable {
		
		//logger = extent.startTest(method.getName());
		initialization(prop.getProperty("local"));
        driver.manage().window().maximize();

	}
	
	
	@Test(priority = 1)
	public void Test_Case_1() throws InterruptedException {
	
		login();
		//driver.findElement(By.xpath("//button[contains(text(),'+')]")).click();
		driver.navigate().to("http://192.168.45.31:8080/upm-visualization-web/#/reporter/dashboard?id=352");

	  WebDriverWait wait = new WebDriverWait(driver, 1000);
  WebElement webElement=driver.findElement(By.id("addDashboard"));
 wait.until(ExpectedConditions.visibilityOf(webElement)).click();

 WebElement webElement2=driver.findElement(By.xpath("//input[@name='name']"));
 String Name="m;lrer;rltrltmrkytkynktynkltkykyktktlkttlk";
 wait.until(ExpectedConditions.visibilityOf(webElement2)).sendKeys(Name);
 
 WebElement webElement3=driver.findElement(By.xpath("//button[@class='submitForm-btn btn btn-primary']"));
 JavascriptExecutor executor = (JavascriptExecutor)driver;

 executor.executeScript("arguments[0].click()", webElement3);
 //wait.until(ExpectedConditions.visibilityOf(webElement3)).click();
 
 WebElement webElement4=driver.findElement(By.className("navBtnText"));
 String dash_name= wait.until(ExpectedConditions.visibilityOf(webElement4)).getText();
 
System.out.println("azza message : "+dash_name);
Assert.assertEquals(dash_name, Name);


	}
	
	
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Throwable {
		
		if (result.getStatus() == ITestResult.FAILURE) {

			//logger.log(LogStatus.FAIL, "Test Failed " + result.getThrowable());
			String picturePath = TestUtil.TakeSnapshot(driver, result.getName());
			//logger.log(LogStatus.FAIL, logger.addScreenCapture(picturePath));
			

		} else if (result.getStatus() == ITestResult.SKIP) {
		//	logger.log(LogStatus.SKIP, "Test case Skipped is " + result.getName());

		} else {
		//	logger.log(LogStatus.PASS, "Test passed");
			String picturePath = TestUtil.TakeSnapshot(driver, result.getName());
		//	logger.log(LogStatus.PASS, logger.addScreenCapture(picturePath));
			
		}

		//extent.endTest(logger);
		//driver.quit();
	}
	
	
	

}
