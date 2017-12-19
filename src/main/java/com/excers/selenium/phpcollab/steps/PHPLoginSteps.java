package com.excers.selenium.phpcollab.steps;

import org.openqa.selenium.WebDriver;
import com.excers.selenium.phpcollab.pages.PHPLoginPage;
public class PHPLoginSteps {
	
    WebDriver driver;
    PHPLoginPage PHPLogin = new PHPLoginPage();
    public PHPLoginSteps(WebDriver driver){
        this.driver = driver;
        driver.get("http://localhost/");
    }
    
    public void Login(String username, String password){
    	
    	
    	driver.findElement(PHPLogin.username).sendKeys(username);
    	driver.findElement(PHPLogin.password).sendKeys(password);
    	driver.findElement(PHPLogin.login).click();
    	
    }
    
    public void Logout(){
    	  driver.findElement(PHPLogin.logout).click();
    	  driver.quit();
    }

}
