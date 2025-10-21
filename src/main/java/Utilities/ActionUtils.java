package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtils {
	private WebDriver driver;
	private Actions actions;

	// Constructor
	public ActionUtils(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
	}

	// Mouse hover
	public void hoverOverElement(WebElement element) {
		actions.moveToElement(element).perform();
	}

	// Right click / context click
	public void rightClick(WebElement element) {
		actions.contextClick(element).perform();
	}

	// Double click
	public void doubleClick(WebElement element) {
		actions.doubleClick(element).perform();
	}

	// Drag and drop
	public void dragAndDrop(WebElement source, WebElement target) {
		actions.dragAndDrop(source, target).perform();
	}

	// Click and hold
	public void clickAndHold(WebElement element) {
		actions.clickAndHold(element).perform();
	}

	// Release element
	public void release(WebElement element) {
		actions.release(element).perform();
	}

	// Move by offset
	public void moveByOffset(int x, int y) {
		actions.moveByOffset(x, y).perform();
	}
}
