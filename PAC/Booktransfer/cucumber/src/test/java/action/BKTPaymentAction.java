package action;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.DataHelper;
import helpers.GlobalPool;
import helpers.SharedDriver;

import pageobjects.CreatePaymentPage;
public class BKTPaymentAction {
	private final WebDriver driver;
	private CreatePaymentPage createPaymentPage;
	private final GlobalPool globalPool;
	private String paymentId;
	private final DataHelper dataHelper;
	
	public BKTPaymentAction(SharedDriver sharedDriver,GlobalPool globalPool,DataHelper dataHelper) {
		this.driver = sharedDriver.getDriver();
		this.globalPool = globalPool;
		this.dataHelper = dataHelper;
	}

	public String createTTPayment(Map<String, String> datamap) throws Exception{
		
		
		WebDriverWait wait = new WebDriverWait(driver, 35);
		createPaymentPage = PageFactory.initElements(driver, CreatePaymentPage.class);
		wait.until(ExpectedConditions.elementToBeClickable(createPaymentPage.initiation));
		createPaymentPage.initiation.click();
		createPaymentPage.initSingle.click();
		wait.until(ExpectedConditions.elementToBeClickable(createPaymentPage.fromAcctId));
		createPaymentPage.fromAcctId.sendKeys(datamap.get("debitAcctId"));
		createPaymentPage.findfromAcctId.click();
		wait.until(ExpectedConditions.elementToBeClickable(createPaymentPage.fromAcctIdSearchSelection));
		createPaymentPage.fromAcctIdSearchSelection.click();
		createPaymentPage.fromAcctselectionOk.click();
		createPaymentPage.toAcctId.sendKeys(datamap.get("creditAcctId"));
		createPaymentPage.findtoAcctId.click();
		WebElement toId = wait.until(ExpectedConditions.visibilityOf(createPaymentPage.toAcctIdSearchSelection));
		Thread.sleep(1000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", toId);
		createPaymentPage.toAcctselectionOk.click();
		wait.until(ExpectedConditions.elementToBeClickable(createPaymentPage.customerRef));
		createPaymentPage.customerRef.sendKeys("TestPay");
		createPaymentPage.remitAmount.sendKeys(dataHelper.generateID().substring(8, 11));
		createPaymentPage.submit.click();
		wait.until(ExpectedConditions.elementToBeClickable(createPaymentPage.cfmBtnYes));
		createPaymentPage.cfmBtnYes.click();
		wait.until(ExpectedConditions.textToBePresentInElement(createPaymentPage.notificationMsg, "Payment with"));
		paymentId=createPaymentPage.notificationMsg.getText();
		paymentId = paymentId.replaceAll("\\D+", "");
		System.out.println("============================================="+paymentId);
		globalPool.setPaymentId(paymentId);
		return paymentId;		
		
		}

	
}
