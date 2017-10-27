package step_definitions;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import java.util.Map;


import action.PaymentSearchAction;
import action.BKTPaymentAction;
import cucumber.api.DataTable;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.DataHelper;




public class BKTPaymentIT {
	public Map<String,String> datamap;

    private final BKTPaymentAction ttPaymentAction;
    private final PaymentSearchAction paymentSearchAction;
    private final DataHelper dataHelper;
    
    public BKTPaymentIT(BKTPaymentAction ttPaymentAction,
    		PaymentSearchAction paymentSearchAction,DataHelper dataHelper)
    {
    			
    			this.ttPaymentAction = ttPaymentAction;
    			this.paymentSearchAction = paymentSearchAction;
    			this.dataHelper = dataHelper;
    }
   
 
    @When("^Authorizer create a BKT payment$")
    public void create_a_BKT_payment(DataTable table) throws Throwable {
    	
    	datamap=dataHelper.formatData(table);
    	assertNotNull(ttPaymentAction.createTTPayment(datamap));
    }
    
       
    @Then("^verify the transaction status as \"([^\"]*)\"$")
    public void verify_the_transaction_status_as_and_sign_out(String paymentStatus) throws Throwable {
    	
    	assertTrue(paymentSearchAction.PaymentStatusCheck(datamap).equals(paymentStatus));
    }
    

}