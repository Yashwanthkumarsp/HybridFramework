package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Class {
WebDriver driver;
private By email=By.id("Email");
private By password=By.id("Password");
private By signin=By.id("login-submit");
private By projectpage=By.xpath("//div[@class='MuiListItemText-root css-qm5qgq']/span[text()='Projects']");
private By createproject=By.xpath("//p[text()='Create New Project']/..");
private By projectname=By.id("fullWidth");
private By savebutton=By.xpath("//button[text()='Save']");	
private By task =By.xpath("//div[text()='Select Task']");
private By selecttask=By.xpath("//li[text()='Instance Segmentation']");
private By domain=By.xpath("//div[text()='Select Domain']");
private By selectdomain=By.xpath("//li[text()='Agriculture']");
private By searchbox=By.id("searchTopBar");


public Login_Class(WebDriver driver)
{
	this.driver=driver;
}

public void loginpage(String Email, String Password)
{
	driver.findElement(email).sendKeys(Email);
	driver.findElement(password).sendKeys(Password);
	driver.findElement(signin).click();
	//driver.findElement(projectpage).click();
}
public void project(String name)
{
	driver.findElement(projectpage).click();
	driver.findElement(createproject).click();
	driver.findElement(projectname).sendKeys(name);
	driver.findElement(task).click();
	driver.findElement(selecttask).click();
	driver.findElement(domain).click();
	driver.findElement(selectdomain).click();
	driver.findElement(savebutton).click();	
}
public void find(String Search)
{
	driver.findElement(searchbox).click();
	driver.findElement(searchbox).sendKeys(Search);
}
}
