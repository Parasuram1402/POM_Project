package com.excers.selenium.phpcollab.pages;

import org.openqa.selenium.By;

public class PHPLoginPage {


    public By username = By.xpath("//input[@name='loginForm']");

    public By password = By.xpath("//input[@name='passwordForm']");

    public By login = By.xpath("//input[@name='save']");
    
    public By logout=By.linkText("Log Out");
    

}
