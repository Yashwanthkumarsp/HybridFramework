package Utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Fluentwait {
	public static WebElement wait(WebDriver driver, int timeout, int pollingtime, WebElement ele) {
		Wait<WebDriver> fw = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(pollingtime)).
				ignoring(NoSuchElementException.class);
		return fw.until(ExpectedConditions.elementToBeClickable(ele));
	}
}
