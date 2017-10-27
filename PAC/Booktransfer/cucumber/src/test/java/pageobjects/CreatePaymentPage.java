package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreatePaymentPage {

	
	@FindBy(how=How.ID, using="initiation")
	public WebElement initiation;
	
	@FindBy(how=How.ID, using="initSingle")
	public WebElement initSingle;
	
	@FindBy(how=How.ID, using="findfromAcctId")
	public WebElement findfromAcctId;
	
	@FindBy(how=How.ID, using="fromAcctId")
	public WebElement fromAcctId;
	
	@FindBy(how=How.ID, using="findtoAcctId")
	public WebElement findtoAcctId;
	
	@FindBy(how=How.ID, using="toAcctId")
	public WebElement toAcctId;
	
	@FindBy(how=How.XPATH, using="//*[@id='0ee4f6da-643a-319f-ac2f-4fe2f6488c38']/div[5]/div/div[1]/div[1]")
	public WebElement fromAcctIdSearchSelection;
	
	@FindBy(how=How.XPATH, using="//*[@id='search-debit-account-controllist-section']/button[2]")
	public WebElement fromAcctselectionOk;
	
	@FindBy(how=How.CSS, using="#search-credit-anzaccount-section div.grid-canvas div.slick-row div.slick-cell.l0.r0")
	public WebElement toAcctIdSearchSelection;
	
	@FindBy(how=How.XPATH, using="//*[@id='search-credit-anzaccount-controllist-section']/button[2]")
	public WebElement toAcctselectionOk;
	
	@FindBy(how=How.ID, using="customerRef")
	public WebElement customerRef;
	
	@FindBy(how=How.ID, using="remitAmount")
	public WebElement remitAmount;
	
	@FindBy(how=How.ID, using="submit")
	public WebElement submit;
	
	@FindBy(how=How.ID, using="cfmBtnYes")
	public WebElement cfmBtnYes;
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Payment with')]")
	public WebElement notificationMsg;
	
			
	}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
