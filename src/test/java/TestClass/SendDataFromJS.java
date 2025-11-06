package TestClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BaseClass.Generic_Class;
import Utilities.JSExecuterUtils;

public class SendDataFromJS  extends Generic_Class{
@Test
public void js() throws InterruptedException
{
	JSExecuterUtils j=new JSExecuterUtils(driver);
	WebElement ele = driver.findElement(By.id("name"));
	j.passdata("hello",ele);
	j.getbyid("name");
	Thread.sleep(3000);
}
}
