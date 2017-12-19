package com.excers.selenium.phpcollab.steps;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excers.selenium.phpcollab.pages.PHPUserPage;
public class PHPUserSteps {
    WebDriver driver;	
    public PHPUserSteps(WebDriver driver){
        this.driver = driver;
    }
    
    public void AddUser(String name, String fullname, String password, String permission) throws InterruptedException{
    	PHPUserPage CreateUser=new PHPUserPage();
    	
    	driver.findElement(CreateUser.addUser).click();
		driver.findElement(CreateUser.userName).sendKeys(name);
		driver.findElement(CreateUser.fullName).sendKeys(fullname);
		driver.findElement(CreateUser.password).sendKeys(password);
		driver.findElement(CreateUser.confirmPassword).sendKeys(password);
		List<WebElement> permissions=driver.findElements(CreateUser.permissions);
		  
		if(permission.equals("Project Manager"))
		{
			permissions.get(0).click();
		} else if (permission.equals("Project Administrator")) {
			permissions.get(3).click();
		} else if (permission.equals("User")) {
			permissions.get(1).click();
		}
		driver.findElement(CreateUser.save).click();
		Thread.sleep(1000);    	
    }
    
    public void ModifyUser(String name, String fullname, String password, String permission) throws InterruptedException{
    	
    }
    
}
