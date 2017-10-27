package action;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import helpers.GlobalPool;
import helpers.Log;
import helpers.SharedDriver;

import pageobjects.LoginPage;
import util.UserContext;

public class OpeeLoginAction {

	private final WebDriver driver;
	private LoginPage loginPage;
	private final UserContext userContext;
	private final GlobalPool globalPool;
	private String[] userBKT;

	public OpeeLoginAction(SharedDriver sharedDriver, UserContext context, GlobalPool pool) {
		this.driver = sharedDriver.getDriver();
		this.userContext = context;
		this.globalPool = pool;
	}

	public void SignIn() throws Exception {
		driver.get(globalPool.getURL());
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		if ("BKT".equalsIgnoreCase(userContext.getModuleAssignment())) {
			userBKT = userContext.getUserBKT().split(":");
			loginPage.userName.sendKeys(userBKT[0]);
			Log.info(" is entered in UserName text box");
			loginPage.password.sendKeys(userBKT[1]);
			Log.info(" is entered in Password text box");
			userContext.removeUserTT(userBKT[0]);
		}
		loginPage.signin_button.click();
		Log.info("Click action is performed on Submit button");

	}

	public void SignOut() throws Exception {

		loginPage.signOut_button.click();
		if ("BKT".equalsIgnoreCase(userContext.getModuleAssignment())) {
			userContext.addUserTT(userBKT[0], userBKT[1]);
		}
		Log.info("Sign out is performed");
	}

}
