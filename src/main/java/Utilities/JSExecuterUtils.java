package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSExecuterUtils {
    private WebDriver driver;
    private JavascriptExecutor js;

    public JSExecuterUtils(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    public void scrollIntoView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public void clickElement(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    public void setValue(WebElement element, String value) {
        js.executeScript("arguments[0].value='" + value + "';", element);
    }

    public void scrollBy(int x, int y) {
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    public void scrollToBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void scrollToTop() {
        js.executeScript("window.scrollTo(0, 0);");
    }
    public void newtab()
    {
    	js.executeScript("window.open();");
    }
    public void passdata(String data, WebElement element)
    {
    	js.executeScript("arguments[0].value='"+data+"';", element);
    }
    public void passbyid(String id, String data)
    {
    	js.executeScript("document.getElementById('"+id+"').value='"+data+"';");
    	
    }
    public void getbyid(String id)
    {
    	String data=(String)js.executeScript("return document.getElementById('"+id+"').value;");
    	System.out.println(data);
    }
   
}

