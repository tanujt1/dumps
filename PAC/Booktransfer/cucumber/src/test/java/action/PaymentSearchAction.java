package action;
import java.util.Map;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.GlobalPool;
import helpers.Log;
import helpers.SharedDriver;

import pageobjects.PaymentSearchPage;

public class PaymentSearchAction {
	
	private PaymentSearchPage paymentSearchPage;
	private final GlobalPool globalPool;
	private final WebDriver driver;
	
	public PaymentSearchAction(SharedDriver sharedDriver,GlobalPool globalPool) {
		this.driver = sharedDriver.getDriver();
		this.globalPool = globalPool;
	}

	public  String PaymentStatusCheck(Map<String, String> datamap) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver, 35);
		paymentSearchPage = PageFactory.initElements(driver, PaymentSearchPage.class);
		paymentSearchPage.txnsearch.click();
		Log.info("Search Menu Click" );
		paymentSearchPage.ouwTxnSearch.click();
		Log.info("Navigating to Outword Search" );
		WebElement payId = wait.until(ExpectedConditions.visibilityOf(paymentSearchPage.paymentId));
		Thread.sleep(500);
		payId.sendKeys(globalPool.getPaymentId());
		Log.info("Searching with paymentId" );
		wait.until(ExpectedConditions.elementToBeClickable(paymentSearchPage.paymentSearchButton));
		paymentSearchPage.paymentSearchButton.click();
		Thread.sleep(1000);
		WebElement pymtSearch = wait.until(ExpectedConditions.visibilityOf(paymentSearchPage.paymentSearchSelection));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",  pymtSearch);
		wait.until(ExpectedConditions.elementToBeClickable(paymentSearchPage.paymentStatus));
		String paymentStatus=paymentSearchPage.paymentStatus.getText();
		System.out.println("______________________________________"+paymentStatus);
		
		return paymentStatus;
	}
	
}
