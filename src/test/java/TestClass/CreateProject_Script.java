package TestClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseClass.Generic_Class;
import PageClass.Login_Class;
import Utilities.ExcelUtils;
import Utilities.ScreenshotUtils;

public class CreateProject_Script extends Generic_Class{
@Test
public void createproject() throws EncryptedDocumentException, IOException
{
	test=extent.createTest("Create Project", "Verify project creation");
	try {
	Login_Class log=new Login_Class(driver);
	String email = ExcelUtils.exceldata1("login", 1, 0);
	String password = ExcelUtils.exceldata1("login", 1, 1);
	log.loginpage(email, password);
	test.log(Status.PASS, "Login Successfull");
	log.project("Demo Project");
	test.log(Status.PASS, "Project created");
	String path=ScreenshotUtils.takeScreenshot(driver, "Create_Project");
	test.addScreenCaptureFromPath(path,"Project Create Proof");
	}
	catch (Exception e) {
	String path=ScreenshotUtils.takeScreenshot(driver, "Create_project");
	test.addScreenCaptureFromPath(path,"Project create failed");
	test.log(Status.FAIL, "Failed to create project" +e.getMessage());
	}
}
}
