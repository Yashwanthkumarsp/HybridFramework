package TestClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseClass.Generic_Class;
import PageClass.Login_Class;
import Utilities.ActionUtils;
import Utilities.ExcelUtils;
import Utilities.JSExecuterUtils;
import Utilities.ScreenshotUtils;

public class Project_Script extends Generic_Class {

	@Test
	public void projectmethod() throws IOException {
		ActionUtils action = new ActionUtils(driver);
		JSExecuterUtils js = new JSExecuterUtils(driver);
		test = extent.createTest("Project Page", "Verify project page is displaying");
		try {
			Login_Class log = new Login_Class(driver);
			String email = ExcelUtils.exceldata1("login", 1, 0);
			String password = ExcelUtils.exceldata1("login", 1, 1);
			test.log(Status.INFO, "Data fecthed successfully");
			log.loginpage(email, password);
			test.log(Status.PASS, "Login Success");
			//log.project();
			js.scrollToBottom();
			WebElement IS = driver.findElement(By.xpath("//abbr[@title='Train_IS']"));
			action.hoverOverElement(IS);
			test.log(Status.PASS, "Project page succesfully displaying");
			String path = ScreenshotUtils.takeScreenshot(driver, "ProjectPage2");
			test.addScreenCaptureFromPath(path, "Project Page");
		} catch (Exception e) {
			String path = ScreenshotUtils.takeScreenshot(driver, "Failed ProjectPage");
			test.addScreenCaptureFromPath(path, "Project page failed");
			test.log(Status.FAIL, "Project page is not displaying" + e.getMessage());
		}

	}

}
