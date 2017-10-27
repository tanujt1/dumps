package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaymentSearchPage {

			
	@FindBy(how=How.ID, using="txnsearch")
	public WebElement txnsearch;
	
	@FindBy(how=How.ID, using="ouwTxnSearch")
	public WebElement ouwTxnSearch;
	
	@FindBy(how=How.XPATH, using="//input[@id='paymentId']")
	public WebElement paymentId;
	
	@FindBy(how=How.XPATH, using="//div[@id='gridFilterWithSaveBtn-section']/div/span[1]/a[@class='form-button primary start-search']")
	public WebElement paymentSearchButton;
	
	@FindBy(how=How.CSS, using="#CN-ouwTxnSearch-grid div.grid-canvas div.slick-row div.slick-cell.l0.r0")
	public WebElement paymentSearchSelection;
	
	@FindBy(how=How.XPATH, using="//*[@id='detailHeader-section']/div/div[3]/div")
	public WebElement paymentStatus;
	
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
