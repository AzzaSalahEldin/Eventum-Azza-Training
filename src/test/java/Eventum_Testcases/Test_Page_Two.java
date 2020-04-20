package Eventum_Testcases;

import java.awt.Desktop.Action;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
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

public class Test_Page_Two  extends TestBase{

	
	//manage reports //search in grid
	public Test_Page_Two() {
		super();
	}
	
	@BeforeMethod
	public void start(Method method) throws InterruptedException, Throwable {
		
		//logger = extent.startTest(method.getName());
		initialization(prop.getProperty("local"));
		
	}	
	@Test(priority = 1)
	public void Test_Case_1() throws InterruptedException {
	
		driver.navigate().to("http://192.168.45.31:8080/upm-visualization-web/");
		login();
		WebElement reporter = driver.findElement(By.className("list-group"));

		Actions actions = new Actions(driver);
		actions.moveToElement(reporter);
		actions.click().build().perform();
		
		WebDriverWait wait = new WebDriverWait(driver, 1000);
        List<WebElement> webElement=driver.findElements(By.xpath("//a//span[text()='Report Designer']"));
        
        wait.until(ExpectedConditions.visibilityOf(webElement.get(0))).click();
        
        
		WebElement webElement2=driver.findElement(By.xpath("//button[contains(@class,'manageReports-btn')]"));
        wait.until(ExpectedConditions.visibilityOf(webElement2)).click();
        String search="azza";
        WebElement webElement3=driver.findElement(By.xpath("//input[@class='input-text Reports-search-input form-control']"));
        wait.until(ExpectedConditions.visibilityOf(webElement3)).sendKeys(search);
       // webElement3.sendKeys(Keys.RETURN);
        Actions builder = new Actions(driver);        
        builder.sendKeys(Keys.ENTER).perform();
        int i_RowNum=1;

        List<WebElement> rowCollection = driver.findElements(By.xpath("//table[@class='mainTable fixed']//tbody/tr"));
        System.out.println("Number of rows in this table: "+rowCollection.size());
        List<String> searchresult=new ArrayList<String>();

        for(WebElement rowElement:rowCollection)
        {
            List<WebElement> colCollection=rowElement.findElements(By.xpath("td"));
            System.out.println("Number of columns in this table: "+rowCollection.size());
            int i_ColNum=1;

            for(WebElement colElement:colCollection)
            {
            	//System.out.println("Row "+i_RowNum+" Column "+i_ColNum+" Data "+colElement.getText());
                i_ColNum=i_ColNum+1;
                searchresult.add(colElement.getText()); 
            }
           i_RowNum=i_RowNum+1;
         }
        System.out.println(searchresult);
        String x;
        for(String we:searchresult)  
        { 
            if ( we.equals("") || we.contains(search)){
            	 x="matched";
            //System.out.println("Matched");
            	 Assert.assertEquals("matched", x);

            } 
            else {
            	System.out.println(" test case failed ");
            }
           }

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
		///	logger.log(LogStatus.PASS, logger.addScreenCapture(picturePath));
			
		}

	//	extent.endTest(logger);
		//driver.quit();
	}
	
	
	
}
