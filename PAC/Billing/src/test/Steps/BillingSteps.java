package test.Steps;

import java.util.List;

import src.Payment;
import src.PaymentDAL;
import src.PaymentDetail;
import src.PaymentHeader;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BillingSteps {
	private String batchId;
	
	@Given("^the following batch of single payments have been received with a batch Id of '(\\d+)'$")
	public void createPayments(int batchId, List<FeaturePayment> payments) throws Throwable {
		if(payments.size() == 0)
			throw new Exception("No payments");
		Payment payment = new Payment(Integer.toString(batchId));
		PaymentHeader hdr = payment.CreateValidBillingPaymentHeader();
		this.batchId = hdr.REQ_ID;
		payment.SaveHeader(hdr);
		
		for(int i=0;i<payments.size();i++){
			PaymentDetail dtl = payment.CreateValidBillingPaymentDetail(payments.get(i).payment_item_number);
			payment.SaveDetail(dtl);
		}
	}
	
	@When("^the billing extract is run$")
	public void the_billing_extract_is_run() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^the billing file will only contain transactions one of the following states \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void the_billing_file_will_only_contain_transactions_one_of_the_following_states(String arg1, String arg2, String arg3, DataTable arg4) throws Throwable {
	  CleanUp();
	  System.out.println("ran cleanup");
	}
	
	private void CleanUp() throws Throwable{
		PaymentDAL paymentDAL = new PaymentDAL();
		paymentDAL.DeletePaymentDetail(this.batchId);
		paymentDAL.DeletePaymentHeader(this.batchId);
	
	}
	
	
	
}
