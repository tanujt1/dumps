package src;
import static src.Utils.*;

public class PaymentHeader {
	public String REQ_ID;
	public String ACCOUNT_ID;
	public String BATCH_ID;
	public String ENTRY_METHOD;
	public String PAYMENT_METHOD;
	public String VALUE_DATE;
	public int TOTAL_TXNS;
	public int TOTAL_DR_AMOUNT;
	public int TOTAL_CR_AMOUNT;
	public String CR_CURRENCY;
	public String DR_CURRENCY;
	public String DEBIT_METHOD;
	public String TRANSACTION_TYPE;
	public String DIVISION_ID;
	public String SENDER_COUNTRY;
	public String SENDER_BIC;
	public String SENDER_BRANCH_NAME;
	public String SENDER_BANK_NAME;
	public String ACCOUNT_NAME;
	public String DEBIT_RESIDENT_STATUS;
	public String ACCOUNT_ADDRESS1;
	public String ACCOUNT_ADDRESS2;
	public String ACCOUNT_ADDRESS3;
	public String ACCOUNT_ADDRESS4;
	public String DEBIT_ADDRESS_COUNTRY;
	public String BATCH_REF,BATCH_NAME;
	public String ACCOUNT_NO;
	public String ACCOUNTING_SYSTEM_CODE;
	public String ACCOUNTING_GROUP;
	public String DR_BATCH_DESCRIPTION;
	public String BATCH_FX_REF;
	public String FILE_ID;
	public String FILE_NAME;
	public String STATUS_CODE;
	public String STATUS_DESC;
	public String ENTL_PROD_FEATURE;
	public String DIVISION_NAME;
	public String ADDNL_STATUS_DESC;
	public String EXT_PAYMENT_BATCH_ID;
	public String CHANNEL;
	public String EXT_FILE_ID;
	public String EXT_FILE_NAME;
	public String ACCOUNT_NAME1_LL;
	public String ACCOUNT_NAME2_LL;
	public String ADDRESS1_LL;
	public String ADDRESS2_LL;
	public String ADDRESS3_LL;
	public String ACCOUNT_BRANCH_CODE;
	public String REMITTER_NAME;
	public String RETURN_ACCOUNT_ID;
	public String RETURN_ACCOUNT_NO;
	public String RETURN_ACCOUNT_NAME;
	public String RETURN_ACCOUNT_DIVISION_ID;
	public String RETURN_ACCOUNT_BRANCH_CODE;
	public String RETURN_ACCOUNT_CURRENCY;
	public String CLEARING_ID;
	public String ACCOUNT_NICK_NAME;
	public String DEBIT_STATEMENT_NARRATIVE;
	public String PURPOSE_CODE;
	public String RETURN_ACCOUNT_NICKNAME;
	public String RETURN_ACCOUNT_GROUP_CODE;
	public String RETURN_ACCOUNT_SYSTEM_CODE;
	public String PRODUCT;
	public String COBRA_PRODUCT_ID;
	
	
	
	public String getInsertSQL(){
		return "Insert into PAY_HDR_REP (REQ_ID,ACCOUNT_ID,BATCH_ID,ENTRY_METHOD,PAYMENT_METHOD,VALUE_DATE,TOTAL_TXNS,TOTAL_DR_AMOUNT,TOTAL_CR_AMOUNT,CR_CURRENCY,DR_CURRENCY" + 
					",DEBIT_METHOD,TRANSACTION_TYPE,DIVISION_ID,SENDER_COUNTRY,SENDER_BIC,SENDER_BRANCH_NAME,SENDER_BANK_NAME,ACCOUNT_NAME,DEBIT_RESIDENT_STATUS" + 
					",ACCOUNT_ADDRESS1,ACCOUNT_ADDRESS2,ACCOUNT_ADDRESS3,ACCOUNT_ADDRESS4,DEBIT_ADDRESS_COUNTRY,BATCH_REF,BATCH_NAME,ACCOUNT_NO,ACCOUNTING_SYSTEM_CODE" + 
					",ACCOUNTING_GROUP,DR_BATCH_DESCRIPTION,BATCH_FX_REF,FILE_ID,FILE_NAME,STATUS_CODE,STATUS_DESC,ENTL_PROD_FEATURE" + 
					",DIVISION_NAME,ADDNL_STATUS_DESC,EXT_PAYMENT_BATCH_ID,CHANNEL,EXT_FILE_ID,EXT_FILE_NAME,ACCOUNT_NAME1_LL,ACCOUNT_NAME2_LL,ADDRESS1_LL,ADDRESS2_LL" + 
					",ADDRESS3_LL,ACCOUNT_BRANCH_CODE,REMITTER_NAME,RETURN_ACCOUNT_ID,RETURN_ACCOUNT_NO,RETURN_ACCOUNT_NAME,RETURN_ACCOUNT_DIVISION_ID,RETURN_ACCOUNT_BRANCH_CODE" + 
					",RETURN_ACCOUNT_CURRENCY,CLEARING_ID,ACCOUNT_NICK_NAME,DEBIT_STATEMENT_NARRATIVE,PURPOSE_CODE,RETURN_ACCOUNT_NICKNAME,RETURN_ACCOUNT_GROUP_CODE" + 
					",RETURN_ACCOUNT_SYSTEM_CODE,PRODUCT,COBRA_PRODUCT_ID) values (" + 
					getDBValue(this.REQ_ID) + "," + getDBValue(this.ACCOUNT_ID) + "," + getDBValue(this.BATCH_ID) + "," + getDBValue(this.ENTRY_METHOD) + "," + getDBValue(this.PAYMENT_METHOD) + ",to_date(" + getDBValue(this.VALUE_DATE) + ",'DD/MON/RR')," + 
					getDBValue(this.TOTAL_TXNS) + "," + getDBValue(this.TOTAL_DR_AMOUNT) + "," + getDBValue(this.TOTAL_CR_AMOUNT) + "," + getDBValue(this.CR_CURRENCY) + "," + getDBValue(this.DR_CURRENCY) + "," + 
					getDBValue(this.DEBIT_METHOD) + "," + getDBValue(this.TRANSACTION_TYPE) + "," + getDBValue(this.DIVISION_ID) + "," + getDBValue(this.SENDER_COUNTRY) + "," + getDBValue(this.SENDER_BIC) + "," +
					getDBValue(this.SENDER_BRANCH_NAME) + "," +	getDBValue(this.SENDER_BANK_NAME) + "," + getDBValue(this.ACCOUNT_NAME) + "," + getDBValue(this.DEBIT_RESIDENT_STATUS) + "," + getDBValue(this.ACCOUNT_ADDRESS1) + "," +
					getDBValue(this.ACCOUNT_ADDRESS2) + "," + getDBValue(this.ACCOUNT_ADDRESS3) + "," + getDBValue(this.ACCOUNT_ADDRESS4) + "," + getDBValue(this.DEBIT_ADDRESS_COUNTRY) + "," + getDBValue(this.BATCH_REF) + "," +
					getDBValue(this.BATCH_NAME) + "," +	getDBValue(this.ACCOUNT_NO) + "," +	getDBValue(this.ACCOUNTING_SYSTEM_CODE) + "," +	getDBValue(this.ACCOUNTING_GROUP) + "," + getDBValue(this.DR_BATCH_DESCRIPTION) + "," +
					getDBValue(this.BATCH_FX_REF) + "," + getDBValue(this.FILE_ID) + "," + getDBValue(this.FILE_NAME) + "," + getDBValue(this.STATUS_CODE) + "," + getDBValue(this.STATUS_DESC) + "," +	getDBValue(this.ENTL_PROD_FEATURE) + "," +
					getDBValue(this.DIVISION_NAME) + "," + getDBValue(this.ADDNL_STATUS_DESC) + "," + getDBValue(this.EXT_PAYMENT_BATCH_ID) + "," + getDBValue(this.CHANNEL) + "," + getDBValue(this.EXT_FILE_ID) + "," + getDBValue(this.EXT_FILE_NAME) + "," + getDBValue(this.ACCOUNT_NAME1_LL) + "," + getDBValue(this.ACCOUNT_NAME2_LL) + "," + getDBValue(this.ADDRESS1_LL) + "," +
					getDBValue(this.ADDRESS2_LL) + "," + getDBValue(this.ADDRESS3_LL) + "," + getDBValue(this.ACCOUNT_BRANCH_CODE) + "," + getDBValue(this.REMITTER_NAME) + "," + getDBValue(this.RETURN_ACCOUNT_ID) + "," + getDBValue(this.RETURN_ACCOUNT_NO) + "," + getDBValue(this.RETURN_ACCOUNT_NAME) + "," +
					getDBValue(this.RETURN_ACCOUNT_DIVISION_ID) + "," + getDBValue(this.RETURN_ACCOUNT_BRANCH_CODE) + "," + getDBValue(this.RETURN_ACCOUNT_CURRENCY) + "," + getDBValue(this.CLEARING_ID) + "," + getDBValue(this.ACCOUNT_NICK_NAME) + "," +
					getDBValue(this.DEBIT_STATEMENT_NARRATIVE) + "," + getDBValue(this.PURPOSE_CODE) + "," + getDBValue(this.RETURN_ACCOUNT_NICKNAME) + "," + getDBValue(this.RETURN_ACCOUNT_GROUP_CODE) + "," + getDBValue(this.RETURN_ACCOUNT_SYSTEM_CODE) + "," +
					getDBValue(this.PRODUCT) + "," + getDBValue(this.COBRA_PRODUCT_ID) + ")";
	}
}
