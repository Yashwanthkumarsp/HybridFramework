package TestClass;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import BaseClass.Generic_Class;
import Utilities.JSExecuterUtils;
import Utilities.Fluentwait;

public class ValidateRedandGreen extends Generic_Class {

	@Test
	public void color() throws IOException, InterruptedException {
		JSExecuterUtils js = new JSExecuterUtils(driver);
		WebElement ele = driver.findElement(By.xpath("//a[@href='//money.rediff.com/gainers/bse/daily/groupa']"));
		js.scrollIntoView(ele);

		Fluentwait.wait(driver, 10, 2, ele);
		String company = "Thangamayil Jeweller";
		WebElement col = driver.findElement(By.xpath("//a[text()='"+company+"']/ancestor::div[@class='row_GL']//img[@class='msprite up' or @class='msprite dn']"));
		String color = col.getAttribute("class");
		String res = (color.contains("up"))?"green":"red";
		//String col=(driver.findElement(By.xpath("//a[text()='" + company + "']/ancestor::div[@class='row_GL']//img[@class='msprite up']")).isDisplayed())?"green":(driver.findElement(By.xpath("//a[text()='" + company + "']/ancestor::div[@class='row_GL']//img[@class='msprite dn']")).isDisplayed())?"red":"no color";
		
			System.out.println(res);
		
	}
}
