package dotdashcom.pageobject;

import org.openqa.selenium.By;

public class CommonPageObject {
// checkbox
	private static By checkbox_check1 = By.xpath("(//form[@id='checkboxes']/input)[1]");
	private static By checkbox_check2 = By.xpath("(//form[@id='checkboxes']/input)[2]");
	
	// context-click
	private static By contextClickBlock = By.id("hot-spot");
	
	// drag and drop
	private static By columnA = By.id("column-a");
	private static By columnAMsg = By.xpath("//div[@id='column-a']/header");
	private static By columnB = By.id("column-b");
	private static By columnBMsg = By.xpath("//div[@id='column-b']/header");
	
	
	// dropdown
	private static By dropdownList = By.id("dropdown");

	//dynamic data
	private static By dynamicContent = By.xpath("//div[@class='row']/div[2]");
	
	//dynamic controls
	
	
	public static By getDynamicContent() {
		return dynamicContent;
	}
	public static By getDropdownList() {
		return dropdownList;
	}
	public static By getColumnA() {
		return columnA;
	}
	public static By getColumnAMsg() {
		return columnAMsg;
	}
	public static By getColumnB() {
		return columnB;
	}
	public static By getColumnBMsg() {
		return columnBMsg;
	}
	public static By getContextClickBlock() {
		return contextClickBlock;
	}
	public static By getCheckbox_check1() {
		return checkbox_check1;
	}
	public static By getCheckbox_check2() {
		return checkbox_check2;
	}
	
	
}
