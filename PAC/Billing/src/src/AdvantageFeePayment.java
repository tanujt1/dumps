package src;

import com.github.ffpojo.metadata.positional.annotation.PositionalField;
import com.github.ffpojo.metadata.positional.annotation.PositionalRecord;

@PositionalRecord
public class AdvantageFeePayment {
	private String batchDate;
	private String accountNumber;
	private String paymentId;
	
	@PositionalField(initialPosition=1, finalPosition=29)
	public String getAccountNumber(){
		return accountNumber;
	}
	
	public void setAccountNumber(String newAccountNumber){
		accountNumber = newAccountNumber;
	}
	@PositionalField(initialPosition=30, finalPosition=38)
	public String getBatchDate(){
		return batchDate;
	}
	
	public void setBatchDate(String newBatchDate){
		batchDate = newBatchDate;
	}

	@PositionalField(initialPosition=410, finalPosition=430)
	public String getPaymentId() {		
		return paymentId;
	}
	
	public void setPaymentId(String newPaymentId) {		
		paymentId = newPaymentId;
	}
	
}
