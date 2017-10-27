package src;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;


public class Payment {
	public String Status;
	public Date EndStatusDate;
	public String Id;
	public String Type;
	public int Amount;
	public String BatchId;
	public ArrayList<ChargeDetail> chargeDetail = new ArrayList<ChargeDetail>();
	
	public Payment(String status, String paymentType, int amount){
		this.Status = status;
		this.Type = paymentType;
		this.Amount = amount;
	}
	public Payment(String BatchId){
		this.BatchId= BatchId;
		this.Status = "Completed";
	}
	
	public String Create(){
		PaymentHeader hdr = CreateValidBillingPaymentHeader();
		//PaymentDetail dtl = CreateValidBillingPaymentDetail();
		PaymentDAL dal = new PaymentDAL();		
		try {
			dal.CreatePaymentHeader(hdr);
			//dal.CreatePaymentDetail(dtl);			
		} catch (SQLException e) {
			this.Id="";
			e.printStackTrace();		
		}		
		return this.Id;
	}
	
	public String getChargeDetail(){
		Gson g = new Gson();
		
		if(this.chargeDetail.size()==0){
			return null;
		}
		return g.toJson(this.chargeDetail);
	}
	
	
	
	
	public PaymentHeader CreateValidBillingPaymentHeader(){
		PaymentHeader hdr = new PaymentHeader();
		this.Id = java.util.UUID.randomUUID().toString();
		hdr.PAYMENT_METHOD = this.Type;
		hdr.REQ_ID = this.Id;		
		hdr.ACCOUNT_ID = "AU735627688";
		hdr.BATCH_ID = this.BatchId;
		hdr.ENTRY_METHOD = "CLIENT";		
		hdr.VALUE_DATE = "22/SEP/17";
		hdr.TOTAL_TXNS = 2;
		hdr.TOTAL_DR_AMOUNT = 80000;
		hdr.TOTAL_CR_AMOUNT = 80000;
		hdr.CR_CURRENCY = "CNY";
		hdr.DR_CURRENCY = "AUD";
		hdr.DEBIT_METHOD = "MULTI";
		hdr.TRANSACTION_TYPE = "TRF";
		hdr.DIVISION_ID = "ANZ-DIV05";
		hdr.SENDER_COUNTRY = "AU";
		hdr.SENDER_BIC = "ANZBAU3MXXX";
		hdr.SENDER_BRANCH_NAME = "646000";
		hdr.SENDER_BANK_NAME = "INT OPEE ACCOUNT";
		hdr.ACCOUNT_NAME = "INT OPEE ACCOUNT";
		hdr.DEBIT_RESIDENT_STATUS = "RA";
		hdr.ACCOUNT_ADDRESS1 = "ACCT ADDR1";
		hdr.ACCOUNT_ADDRESS2 = "ACCT ADDR2";
		hdr.ACCOUNT_ADDRESS3 = "ACCT ADDR3";
		hdr.ACCOUNT_ADDRESS4 = "ACCT ADDR4";
		hdr.DEBIT_ADDRESS_COUNTRY = "AU";
		hdr.BATCH_REF = "TC001539i81";
		hdr.BATCH_NAME = "BATCH NAME 2";
		hdr.ACCOUNT_NO = "735627688";
		hdr.ACCOUNTING_SYSTEM_CODE = "CAP";
		hdr.ACCOUNTING_GROUP = "AUA";
		hdr.DR_BATCH_DESCRIPTION = "Batch Debit Description";
		hdr.BATCH_FX_REF = "[{\"itemNo\":\"1\",\"fxType\":\"Dynamic\",\"fxOwner\":\"DEAL\",\"dealSys\":\"MDZ\",\"dealGrp\":\"CNR\",\"fxAcctId\":null,\"fxQuoteId\":null,\"fxDealId\":\"1082\",\"exchRate\":10.01,\"tranDate\":\"2016-07-28\",\"fromAmount\":0.01,\"availFromAmount\":9999990000.00,\"toAmount\":20.90,\"availToAmount\":11880000.00,\"baseAmount\":null,\"baseCurCode\":null},{\"itemNo\":\"2\",\"fxType\":\"DEAL\",\"fxOwner\":\"DEAL\",\"dealSys\":\"MDZ\",\"dealGrp\":\"CNR\",\"fxAcctId\":null,\"fxQuoteId\":null,\"fxDealId\":\"1082\",\"exchRate\":10.01,\"tranDate\":\"2016-07-28\",\"fromAmount\":20.91,\"availFromAmount\":9999990000.00,\"toAmount\":100.91,\"availToAmount\":11880000.00,\"baseAmount\":null,\"baseCurCode\":null},{\"itemNo\":\"3\",\"fxType\":\"Dynamic\",\"fxOwner\":\"DEAL\",\"dealSys\":\"MDZ\",\"dealGrp\":\"CNR\",\"fxAcctId\":null,\"fxQuoteId\":null,\"fxDealId\":\"1082\",\"exchRate\":10.01,\"tranDate\":\"2016-07-28\",\"fromAmount\":0.01,\"availFromAmount\":9999990000.00,\"toAmount\":20.90,\"availToAmount\":11880000.00,\"baseAmount\":null,\"baseCurCode\":null},{\"itemNo\":\"4\",\"fxType\":\"DEAL\",\"fxOwner\":\"DEAL\",\"dealSys\":\"MDZ\",\"dealGrp\":\"CNR\",\"fxAcctId\":null,\"fxQuoteId\":null,\"fxDealId\":\"1082\",\"exchRate\":10.01,\"tranDate\":\"2016-07-28\",\"fromAmount\":20.91,\"availFromAmount\":9999990000.00,\"toAmount\":100.91,\"availToAmount\":11880000.00,\"baseAmount\":null,\"baseCurCode\":null}]";
		hdr.FILE_ID = "1234";
		hdr.FILE_NAME = "abc.txt";
		hdr.STATUS_CODE = null;
		hdr.STATUS_DESC = null;
		hdr.ENTL_PROD_FEATURE = "INT";
		hdr.DIVISION_NAME = null;
		hdr.ADDNL_STATUS_DESC = null;
		hdr.EXT_PAYMENT_BATCH_ID = "31408S5330BI007";
		hdr.CHANNEL = null;
		hdr.EXT_FILE_ID = "3456";
		hdr.EXT_FILE_NAME = "Lakshmi.xml";
		hdr.ACCOUNT_NAME1_LL = null;
		hdr.ACCOUNT_NAME2_LL = null;
		hdr.ADDRESS1_LL = null;
		hdr.ADDRESS2_LL = null;
		hdr.ADDRESS3_LL = null;
		hdr.ACCOUNT_BRANCH_CODE = "MELBOURNE";
		hdr.REMITTER_NAME = "REMITDEBIT";
		hdr.RETURN_ACCOUNT_ID = "410792733";
		hdr.RETURN_ACCOUNT_NO = "CAP";
		hdr.RETURN_ACCOUNT_NAME = "CMP-TEST CAP 4";
		hdr.RETURN_ACCOUNT_DIVISION_ID = null;
		hdr.RETURN_ACCOUNT_BRANCH_CODE = "013483";
		hdr.RETURN_ACCOUNT_CURRENCY = null;
		hdr.CLEARING_ID = null;
		hdr.ACCOUNT_NICK_NAME = "INT OPEE ACCOUNT";
		hdr.DEBIT_STATEMENT_NARRATIVE = "NARRDEBIT";
		hdr.PURPOSE_CODE = null;
		hdr.RETURN_ACCOUNT_NICKNAME = null;
		hdr.RETURN_ACCOUNT_GROUP_CODE = "AUA";
		hdr.RETURN_ACCOUNT_SYSTEM_CODE = null;
		hdr.PRODUCT = null;
		hdr.COBRA_PRODUCT_ID = null;			
		
		return hdr;
	}
		
		public void SaveHeader(PaymentHeader hdr){
			PaymentDAL dal = new PaymentDAL();		
			try {
				dal.CreatePaymentHeader(hdr);
			}
			 catch (SQLException e) {
					this.Id="";
					e.printStackTrace();
			 }
		}
		

		
		//TODO: Default Parameters for Sig.  Unit Test?
	
	
	public PaymentDetail CreateValidBillingPaymentDetail(int itemNumber)
	{
		PaymentDetail dtl = new PaymentDetail();
		dtl.DTL_REQ_ID = this.Id;
		dtl.TXN_STATUS_DESC = this.Status;
		dtl.PAYMENT_ID=java.util.UUID.randomUUID().toString();
		dtl.ITEM_NUMBER=itemNumber;
		dtl.CUST_REF_NO = "Test Ref";
		dtl.TXN_STATUS_CODE = "0";		
		dtl.TXN_ADDNL_STATUS_INFO = "[{\"statusCode\":null,\"statusDesc\":\"Payment processed successfully\"}]";		
		dtl.REMIT_TYPE = null;
		dtl.REMIT_MSG_TEXT = null;
		dtl.CUST_DOC_REF = "[{\"name\":\"Doc1.pdf\",\"id\":\"A1198344\"},{\"name\":\"Doc2.pdf\",\"id\":\"A1198345\"},{\"name\":\"Doc3.pdf\",\"id\":\"A1198346\"}]";
		dtl.BENE_BANK_COUNTRY = "CN";
		dtl.BENE_BRANCH = "001148013004";
		dtl.BENE_NCC_TYPE = null;
		dtl.BENE_BANK_NAME = "?????????????";
		dtl.BENE_BRANCH_NAME = "?????????????";
		dtl.BENE_BRANCH_CITY = null;
		dtl.BENE_BANK_ADDR1 = "ADDRESS1";
		dtl.BENE_BANK_ADDR2 = null;
		dtl.BENE_ADDR3 = null;
		dtl.BENE_NAME = "BEPS";
		dtl.BENE_LOCAL_NAME = null;
		dtl.BENE_CITY = "SHANGHAI";
		dtl.BENE_ADDR1 = "Bene Add 1";
		dtl.BENE_ADDR2 = "Bene Add 2";
		dtl.BENE_ADDR3 = "Bene Add 3";
		dtl.BENE_COUNTRY = "CN";
		dtl.DTL_CR_CURRENCY = "CNY";
		dtl.CR_AMOUNT = 2115;
		dtl.SENDER_REC1_VALUE=null;
		dtl.SENDER_REC2_VALUE=null;
		dtl.SENDER_REC3_VALUE=null;
		dtl.SENDER_REC4_VALUE=null;
		dtl.SENDER_REC5_VALUE=null;
		dtl.SENDER_REC6_VALUE=null;
		dtl.CLEARING_PREFERENCE = "DHVPS";
		dtl.CLEARING_DATE = "28/SEP/16";
		dtl.PROCESS_DATE = "28/SEP/16";
		dtl.PURPOSE_CODE = "02103";
		dtl.BENE_RESIDENT_STATUS = "DOM";
		dtl.REMIT_INFO = "Remit 1 Remit 2 Remit 3 Remit 4";
		dtl.REMIT_CONTACT_INFO = "[{\"contactId\":null,\"contactTitle\":null,\"contactType\":null,\"contactName\":null,\"contactAddr\":null}]";
		dtl.BENE_ACCOUNT_NO = "2429479238497234897";
		dtl.BENE_ACCOUNTING_SYSTEM_CODE = null;
		dtl.BENE_ACCOUNTING_GROUP = null;
		dtl.DEBIT_EQUIVALENT = "N";
		dtl.FX_REF = "[{\"itemNo\":\"1\",\"fxType\":\"DEAL\",\"fxOwner\":\"DEAL\",\"dealSys\":\"MDZ\",\"dealGrp\":\"CNR\",\"fxAcctId\":null,\"fxQuoteId\":null,\"fxDealId\":\"1082\",\"exchRate\":1.32,\"tranDate\":null,\"fromAmount\":null,\"availFromAmount\":null,\"toAmount\":2115,\"availToAmount\":null,\"baseAmount\":null,\"baseCurCode\":null}]";
		dtl.CHARGE_DETAIL_REF = this.getChargeDetail();
		dtl.DEBIT_EQUIVALENT_AMOUNT = 2115;
		dtl.DR_DESCRIPTION = "Txn Debit Desc";
		dtl.BOP_INFO=null;
		dtl.BENE_ACCOUNT_ID=null;
		dtl.BENE_ID=null;
		dtl.ADD_INV_DETAIL_ID=null;
		dtl.EXT_PAYMENT_ID=null;
		dtl.RETURN_ACCOUNT_NAME=null;
		dtl.RETURN_ACCOUNT_DIVISION_ID=null;
		dtl.RETURN_ACCOUNT_CURRENCY=null;
		dtl.RETURN_ACCOUNT_BRANCH_CODE=null;
		dtl.RETURN_ACCOUNT_NO=null;
		dtl.RETURN_ACCOUNT_BRANCH_NAME=null;
		dtl.RETURN_DVISION_NAME=null;
		dtl.REMITTER_NAME=null;
		dtl.STATEMENT_NARRATIVE=null;
		dtl.WITHHOLDING_TAX_TYPE=null;
		dtl.WITHHOLDING_TAX_AMT=null;
		dtl.RETURN_ACCOUNT_ID=null;
		dtl.BENE_NICK_NAME=null;
		dtl.RETURN_ACCOUNT_NICKNAME=null;
		dtl.RETURN_ACCOUNT_GROUP_CODE=null;
		dtl.RETURN_ACCOUNT_SYSTEM_CODE=null;
		dtl.COST_CENTRE=null;
		dtl.CLEARING_ID=null;
		dtl.IBAN_FLAG=null;
		dtl.UPDATED_DATE = "20170919";
		
		return dtl;
		
	}
		public void SaveDetail(PaymentDetail dtl){
		
		PaymentDAL dal = new PaymentDAL();		
		try {
			dal.CreatePaymentDetail(dtl);
		}
		 catch (SQLException e) {
				this.Id="";
				e.printStackTrace();
		 }
				
		
		
	}
}
;
