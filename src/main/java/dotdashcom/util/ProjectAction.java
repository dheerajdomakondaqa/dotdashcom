package dotdashcom.util;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import dotdashcom.base.DriverFactory;

public class ProjectAction {

	public static void sendKeys(By by , String txt) {
		DriverFactory.getDriver().findElement(by).sendKeys(txt);
	}
	
	public static void click(By by) {
		DriverFactory.getDriver().findElement(by).click();
	}

	public static String getText(By by) {
		return getElement(by).getText();
	}

	public static void contextClick(By by) {
		Actions action = new Actions(DriverFactory.getDriver());
		action.contextClick(getElement(by)).build().perform();
	}

	public static void selectDropDown(By by, String value) {
		new Select(getElement(by)).selectByVisibleText(value);
	}

	public static String getSelectedDropDownValue(By by) {
		return new Select(getElement(by)).getFirstSelectedOption().getText();
	}

	public static void dragdrop(By by1, By by2) {
		 WebElement a = getElement(by1);
	        WebElement b = getElement(by2);

	        int x = b.getLocation().x;
	        int y = b.getLocation().y;
	        
	        Actions actions = new Actions(DriverFactory.getDriver());
	        actions.moveToElement(a)
	                .pause(Duration.ofSeconds(1))
	                .clickAndHold(a)
	                .pause(Duration.ofSeconds(1))
	                .moveByOffset(x+150, y)
	                .moveByOffset(x+150,y)
	                .pause(Duration.ofSeconds(1))
	                .release().build().perform();
	}
	
	
	public static String getAlertMsgAndAccept() {
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		String ret = alert.getText();
		alert.accept();
		return ret;
	}

	
	public static boolean isChecked(By by) {
		return getElement(by).isSelected();
	}
	
	public static WebElement getElement(By by) {
		try {
			return DriverFactory.getDriver().findElement(by);
		}catch(Exception e) {
			return null;
		}
	}

}
