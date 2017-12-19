package com.excers.selenium.phpcollab.pages;
import org.openqa.selenium.By;

public class PHPProjectPage {
    public By projectsLink = By.linkText("Projects");

    public By addProject = By.xpath("//img[@name='saP0']");

    public By projectName = By.xpath("//input[@name='pn']");
    
    public By priority = By.xpath("//select[@name='pr']");
    
    public By owner = By.xpath("//select[@name='pown']");
    
    public By save=By.xpath("//input[@value='Save']");
    public By message=By.xpath("//td");
	
}
