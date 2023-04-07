package dotdashcom.pageobject;

import org.openqa.selenium.By;

public class LoginPageObject {

	private static By txt_userName = By.name("username");
	private static By txt_password = By.name("password");
	private static By btn_login = By.xpath("//button[@type='submit']");
	private static By msg_successMsg = By.xpath("//div[@id='flash']");
	
	public static By getMsg_successMsg() {
		return msg_successMsg;
	}

	public static By getTxt_userName() {
		return txt_userName;
	}
	
	public static By getTxt_password() {
		return txt_password;
	}
	
	public static By getBtn_login() {
		return btn_login;
	}
	
	
	
	
}
