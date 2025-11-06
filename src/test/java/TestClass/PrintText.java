package TestClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BaseClass.Generic_Class;

public class PrintText extends Generic_Class {
	@Test
	public void print() throws InterruptedException {
		driver.navigate().refresh();
		List<WebElement> total = driver.findElements(By.xpath("//marquee[@id='indmarquee']/div/span/a"));
		System.out.println(total.size());
		for (int i = 0; i < total.size(); i++) {
			try {
				String text = total.get(i).getAttribute("textContent").trim();
				System.out.println(i + 1 + ". " + text);
			} catch (Exception e) {
				System.out.println(i+" no element not in frame :"+e.getMessage());
				i--;
			}
		}
	}
}
