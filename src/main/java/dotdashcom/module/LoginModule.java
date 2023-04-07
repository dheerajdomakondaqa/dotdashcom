package dotdashcom.module;

import dotdashcom.base.DriverFactory;
import dotdashcom.pageobject.LoginPageObject;
import dotdashcom.util.ProjectAction;

public class LoginModule {
	
	public static void login(String username, String password) {
		ProjectAction.sendKeys(LoginPageObject.getTxt_userName(), username);
		ProjectAction.sendKeys(LoginPageObject.getTxt_password(), password);
		ProjectAction.click(LoginPageObject.getBtn_login());		
	}
	
	public static String getMsg() {
		String msg = ProjectAction.getText(LoginPageObject.getMsg_successMsg());
		return msg;
	}
}
