package com.excers.selenium.phpcollab.tests;

import com.excers.selenium.phpcollab.pages.*;
import com.excers.selenium.phpcollab.steps.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestUserCreation {
  	XSSFRow row;
    File file ;
    FileInputStream fis;
    String CurrentSheet;
    XSSFWorkbook workbook;
    XSSFSheet spreadsheet;
    Iterator < Row >  rowIterator;
    WebDriver driver;
	ExtentReports extent;
	ExtentTest logger;
	PHPLoginSteps loginObject;
	PHPProjectSteps projectObject;
	PHPProjectPage projectPage;
	PHPUserSteps userObject;
	PHPUserPage userPage;
	
@Test(priority=1)
public void CreateUser() throws IOException, InterruptedException {
	String name, fullname, password, permission,testname;
	logger = extent.startTest("CreateUser for Test " + this.getClass().getSimpleName());
	userObject=new PHPUserSteps(driver);
	userPage=new PHPUserPage();
	row = (XSSFRow) rowIterator.next();
	driver.findElement(userPage.userManagement).click();
	while (rowIterator.hasNext()) {
	    row = (XSSFRow) rowIterator.next();
	    
	    Iterator < Cell >  cellIterator = row.cellIterator();
	    Cell cell = cellIterator.next();
		testname=cell.getStringCellValue();
		if(testname.equals(this.getClass().getSimpleName())){
			cell = cellIterator.next();	    
		    name=cell.getStringCellValue();
			cell = cellIterator.next();
			fullname= cell.getStringCellValue();
			cell = cellIterator.next();
			password=cell.getStringCellValue();
			cell = cellIterator.next();
			permission=cell.getStringCellValue();

			userObject.AddUser(name, fullname, password, permission);

			if(driver.findElement(userPage.message).getText().equalsIgnoreCase("Success : Addition succeeded")){
				Assert.assertTrue(true);
				logger.log(LogStatus.PASS, "Create User for " + fullname + " passed");
			} else {
				Assert.assertTrue(false);
				logger.log(LogStatus.FAIL, "Create User for " + fullname + " failed");
			}
			
		}

	}
	
	
}


@BeforeMethod
public void beforeMethod(Method method) throws IOException {
//System.out.println("Here is the magic "+method.getName());
spreadsheet=workbook.getSheet(method.getName());
rowIterator = spreadsheet.iterator();

}

@AfterMethod
public void getResult(ITestResult result){
	if(result.getStatus() == ITestResult.FAILURE){
		logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
		logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
	}else if(result.getStatus() == ITestResult.SKIP){
		logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
	}
	extent.endTest(logger);
}

@BeforeClass
public void beforeTest() throws IOException {
  file= new File(System.getProperty("user.dir") + "\\data\\PhpCollab.xlsx");
  
  extent = new ExtentReports (System.getProperty("user.dir") +"\\test-output\\PHPCollabExecutionReport.html", false);
  extent
  .addSystemInfo("Host Name", "Excers Training")
  .addSystemInfo("Environment", "Automation Testing")
  .addSystemInfo("User Name", "Parasuram");

  extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
  
  
  fis = new FileInputStream(file);
  workbook = new XSSFWorkbook(fis);		  
  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
  driver=new ChromeDriver();
  driver.manage().window().maximize();
  loginObject=new PHPLoginSteps(driver);
  
  loginObject.Login("admin", "phpcadmin");

  
}

@AfterClass
public void afterTest() throws IOException {
  fis.close();
  loginObject.Logout();
  driver.quit();
  extent.flush();
  extent.close();
}
}
