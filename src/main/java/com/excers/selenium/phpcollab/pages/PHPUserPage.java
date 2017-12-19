package com.excers.selenium.phpcollab.pages;

import org.openqa.selenium.By;

public class PHPUserPage {

    public By addUser = By.xpath("//img[@alt='Add']");

    public By userName = By.xpath("//input[@name='un']");

    public By fullName = By.xpath("//input[@name='fn']");
    
    public By password = By.xpath("//input[@name='pw']");
    
    public By confirmPassword = By.xpath("//input[@name='pwa']");
    
    public By permissions=By.xpath("//input[@name='perm']");
    
    public By save=By.xpath("//input[@name='Save']");
    
    public By message=By.xpath("//td");
    public By userManagement= By.linkText("User Management");
}
