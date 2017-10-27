package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage{

	@FindBy(how=How.ID, using="j_username")
	public WebElement userName;
	
	@FindBy(how=How.ID, using="j_password")
	public WebElement password;
	
	@FindBy(how=How.ID, using="loginSubmit")
	public WebElement signin_button;
	
	@FindBy(how=How.ID, using="signOut")
	public WebElement signOut_button;
	
		
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
