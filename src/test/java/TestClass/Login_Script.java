//package TestClass;
//
//import java.io.IOException;
//
//import org.apache.poi.EncryptedDocumentException;
//import org.testng.annotations.Test;
//import PageClass.Login_Class;
//import Utilities.ExcelUtils;
//import BaseClass.Generic_Class;
//
//public class Login_Script extends Generic_Class {
//@Test
//public void logintest() throws EncryptedDocumentException, IOException
//{
//	Login_Class log=new Login_Class(driver);
//	String emaildata=ExcelUtils.exceldata("login",1,0);
//	String passworddata=ExcelUtils.exceldata("login",1,1);
//	log.loginpage(emaildata, passworddata);
//}
//}
package TestClass;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import BaseClass.Generic_Class;
import PageClass.Login_Class;
import Utilities.ExcelUtils;
import Utilities.ScreenshotUtils;

public class Login_Script extends Generic_Class {

	@Test(dataProvider = "login")
	public void logintest(String Email, String Password) throws EncryptedDocumentException, IOException {
		// Create a test in the report
		test = extent.createTest("Login Test", "Verify login functionality with Excel data");
		try {
			// Initialize page object
			Login_Class log = new Login_Class(driver);

			// Fetch credentials from Excel
//            String emaildata = ExcelUtils.exceldata("login", 1, 0);
//            String passworddata = ExcelUtils.exceldata("login", 1, 1);
			test.log(Status.INFO, "Fetched login credentials from Excel");

			// Perform login
			log.loginpage(Email, Password);
			test.log(Status.PASS, "Login performed successfully"+Email);

			// Take screenshot after login
			String path = ScreenshotUtils.takeScreenshot(driver, "Login_Success_"+Email);
			test.addScreenCaptureFromPath(path, "Login Screenshot"+Email);

		} catch (Exception e) {
			// Capture screenshot on failure
			String path = ScreenshotUtils.takeScreenshot(driver, "Login_Failure_"+Email);
			test.addScreenCaptureFromPath(path, "Failure Screenshot"+Email);

			// Log failure with exception
			test.log(Status.FAIL, "Login Test Failed: "+Email + e.getMessage());
		}
	}

	@DataProvider(name = "login")
	public Object[][] getdata() throws EncryptedDocumentException, IOException {
		return ExcelUtils.exceldata2("login");
	}
}
