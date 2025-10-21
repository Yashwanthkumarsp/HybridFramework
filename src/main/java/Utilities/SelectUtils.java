package Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtils {

	public static void SelectByVisibletext(WebElement element, String Visibletext) {
		try {

			Select sc = new Select(element);
			sc.selectByVisibleText(Visibletext);
		} catch (Exception e) {
			System.out.println("Unable to select by visibletext " + e.getMessage());
		}
	}

	public static void SelectByValue(WebElement element, String value) {
		try {

			Select sc = new Select(element);
			sc.selectByValue(value);
		} catch (Exception e) {
			System.out.println("Unable to select by visibletext " + e.getMessage());
		}
	}

	public static void SelectByIndex(WebElement element, int index) {
		try {

			Select sc = new Select(element);
			sc.selectByIndex(index);
		} catch (Exception e) {
			System.out.println("Unable to select by visibletext " + e.getMessage());
		}
	}
}
