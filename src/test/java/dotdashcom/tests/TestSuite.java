package dotdashcom.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dotdashcom.base.DriverFactory;
import dotdashcom.module.LoginModule;
import dotdashcom.pageobject.CommonPageObject;
import dotdashcom.util.ProjectAction;
import dotdashcom.util.PropertiesUtils;

public class TestSuite {
	
	
	@Test(description = "Login success")
	public void login_success() {
		DriverFactory.getDriver().get(PropertiesUtils.getEnvProperties("login"));
		LoginModule.login(PropertiesUtils.getEnvProperties("username"), PropertiesUtils.getEnvProperties("password"));
		Assert.assertTrue(LoginModule.getMsg().contains("You logged into a secure area!"), "Login not successful");
	}
	
	
	
	@DataProvider(name="invalid_login_credentials")
	public static Object[][] getLoginFailureTestData(){
		Object[][] on = new Object[2][4];
		on[0][0] ="tomsmith";on[0][1] ="dsfadsfas";on[0][2] ="Your password is invalid!";on[0][3] ="Wrong Password Scenario";
		on[1][0] ="adfadsf";on[1][1] ="sdfsdf";on[1][2] ="Your username is invalid!";on[1][3] ="Wrong Username Scenario";
		return on;
	}
	@Test(description = "Login Failure", dataProvider ="invalid_login_credentials")
	public void login_failure(String username, String password, String msg, String scenario) {
		DriverFactory.getDriver().get(PropertiesUtils.getEnvProperties("login"));
		LoginModule.login(username,password);
		Assert.assertTrue(LoginModule.getMsg().contains(msg),scenario +" failed");
	}

	@Test(description = "checkbox_Validation")
	public void checkbox_validation() {
		DriverFactory.getDriver().get(PropertiesUtils.getEnvProperties("checkbox"));
		Assert.assertFalse(ProjectAction.isChecked(CommonPageObject.getCheckbox_check1()), "First CheckBox is checked");
		Assert.assertTrue(ProjectAction.isChecked(CommonPageObject.getCheckbox_check2()), "Second CheckBox is not checked");
		ProjectAction.click(CommonPageObject.getCheckbox_check1());
		Assert.assertTrue(ProjectAction.isChecked(CommonPageObject.getCheckbox_check1()), "First CheckBox is not checked");
		ProjectAction.click(CommonPageObject.getCheckbox_check2());
		Assert.assertFalse(ProjectAction.isChecked(CommonPageObject.getCheckbox_check2()), "Second CheckBox is checked");
	}
	
	
	@Test(description = "contextclick_Validation")
	public void contextClick_validation() {
		DriverFactory.getDriver().get(PropertiesUtils.getEnvProperties("contextmenu"));
		ProjectAction.contextClick(CommonPageObject.getContextClickBlock());
		String msg = ProjectAction.getAlertMsgAndAccept();
		Assert.assertEquals(msg, "You selected a context menu", "Context Click not working");
	}
	
	@Test(description = "drag_drop_Validation")
	public void dragDrop_validation() {
		DriverFactory.getDriver().get(PropertiesUtils.getEnvProperties("drag_drop"));
		ProjectAction.dragdrop(CommonPageObject.getColumnA(), CommonPageObject.getColumnB());
		assertEquals(ProjectAction.getText(CommonPageObject.getColumnAMsg()), "B");
		assertEquals(ProjectAction.getText(CommonPageObject.getColumnBMsg()), "A");
	}
	
	@Test(description = "drop_down_Validation")
	public void dropDown_validation() {
		DriverFactory.getDriver().get(PropertiesUtils.getEnvProperties("dropdown"));
		ProjectAction.selectDropDown(CommonPageObject.getDropdownList(), "Option 1");
		assertEquals(ProjectAction.getSelectedDropDownValue(CommonPageObject.getDropdownList()),"Option 1");
		ProjectAction.selectDropDown(CommonPageObject.getDropdownList(), "Option 2");
		assertEquals(ProjectAction.getSelectedDropDownValue(CommonPageObject.getDropdownList()),"Option 2");
	}
	
	
	@Test(description = "dynamic_contant_Validation")
	public void dynamic_contant_validation() {
		DriverFactory.getDriver().get(PropertiesUtils.getEnvProperties("dynamic_contant"));
		String firstScreenText = ProjectAction.getText(CommonPageObject.getDynamicContent());
		DriverFactory.getDriver().navigate().refresh();
		String secondScreenText = ProjectAction.getText(CommonPageObject.getDynamicContent());
		Assert.assertNotEquals(firstScreenText, secondScreenText, "After Refresh Text looks same");
	}
	
	
	@AfterMethod
	public void teardown() {
		DriverFactory.closeDriver();
	}

	
}
