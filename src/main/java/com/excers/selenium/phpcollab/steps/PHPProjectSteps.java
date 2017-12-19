package com.excers.selenium.phpcollab.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.excers.selenium.phpcollab.pages.PHPProjectPage;

public class PHPProjectSteps {

    WebDriver driver;	
    public PHPProjectSteps(WebDriver driver){
        this.driver = driver;
    }
	
	public void AddProject(String projectName, String priority, String owner) throws InterruptedException{
		PHPProjectPage CreateProject = new PHPProjectPage();
		
		driver.findElement(CreateProject.projectsLink).click();
		driver.findElement(CreateProject.addProject).click();
		driver.findElement(CreateProject.projectName).sendKeys(projectName);
		Select priorityList=new Select(driver.findElement(CreateProject.priority));
		priorityList.selectByVisibleText(priority);
		Select ownerList=new Select(driver.findElement(CreateProject.owner));
		ownerList.selectByVisibleText(owner);
		driver.findElement(CreateProject.save).click();
		Thread.sleep(2000);
		
	}
	
	public void ModifyProject(String projectName, String priority, String owner) throws InterruptedException{
		
	}
	
}
