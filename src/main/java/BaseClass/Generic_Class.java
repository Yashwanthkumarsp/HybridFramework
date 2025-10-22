package BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utilities.ConfigUtils;

public class Generic_Class {
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeSuite
	public void setupReport() throws IOException {
		ConfigUtils.loadconfig();
		String ReportName = ConfigUtils.getProperty("report");
		// Define where the report will be saved
		ExtentSparkReporter reporter = new ExtentSparkReporter(ReportName+".html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@BeforeMethod
	//@Parameters("browsers")
	public void setup() 
	{
		String browser=ConfigUtils.getProperty("browser");
		String url=ConfigUtils.getProperty("url");
		int timeout=Integer.valueOf(ConfigUtils.getProperty("timeout"));
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		driver.get(url);

	}

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@AfterSuite
	public void tearDownReport() {
		extent.flush(); // Generates the report file
	}
}
