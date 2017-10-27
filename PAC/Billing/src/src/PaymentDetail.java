package src;
import static src.Utils.*;
public class PaymentDetail
{
	
	public String DTL_REQ_ID;
	public String PAYMENT_ID;
	public int ITEM_NUMBER;
	public String CUST_REF_NO;
	public String TXN_STATUS_CODE;
	public String TXN_STATUS_DESC;
	public String TXN_ADDNL_STATUS_INFO;
	public String REMIT_TYPE;
	public String REMIT_MSG_TEXT;
	public String CUST_DOC_REF;
	public String BENE_BANK_COUNTRY;
	public String BENE_BIC;
	public String BENE_BRANCH;
	public String BENE_NCC_TYPE;
	public String BENE_BANK_NAME;
	public String BENE_BRANCH_NAME;
	public String BENE_BRANCH_CITY;
	public String BENE_BANK_ADDR1;
	public String BENE_BANK_ADDR2;
	public String BENE_BANK_ADDR3;
	public String BENE_NAME;
	public String BENE_LOCAL_NAME;
	public String BENE_CITY;
	public String BENE_ADDR1;
	public String BENE_ADDR2;
	public String BENE_ADDR3;
	public String BENE_COUNTRY;
	public String DTL_CR_CURRENCY;
	public int CR_AMOUNT;
	public String SENDER_REC1_VALUE;
	public String SENDER_REC2_VALUE;
	public String SENDER_REC3_VALUE;
	public String SENDER_REC4_VALUE;
	public String SENDER_REC5_VALUE;
	public String SENDER_REC6_VALUE;
	public String CLEARING_PREFERENCE;
	public String CLEARING_DATE;
	public String PROCESS_DATE;
	public String PURPOSE_CODE;
	public String BENE_RESIDENT_STATUS;
	public String REMIT_INFO;
	public String REMIT_CONTACT_INFO;
	public String BENE_ACCOUNT_NO;
	public String BENE_ACCOUNTING_SYSTEM_CODE;
	public String BENE_ACCOUNTING_GROUP;
	public String DEBIT_EQUIVALENT;
	public String FX_REF;
	public String CHARGE_DETAIL_REF;
	public int DEBIT_EQUIVALENT_AMOUNT;
	public String DR_DESCRIPTION;
	public String BOP_INFO;
	public String BENE_ACCOUNT_ID;
	public String BENE_ID;
	public String ADD_INV_DETAIL_ID;
	public String EXT_PAYMENT_ID;
	public String RETURN_ACCOUNT_NAME;
	public String RETURN_ACCOUNT_DIVISION_ID;
	public String RETURN_ACCOUNT_CURRENCY;
	public String RETURN_ACCOUNT_BRANCH_CODE;
	public String RETURN_ACCOUNT_NO;
	public String RETURN_ACCOUNT_BRANCH_NAME;
	public String RETURN_DVISION_NAME;
	public String REMITTER_NAME;
	public String STATEMENT_NARRATIVE;
	public String WITHHOLDING_TAX_TYPE;
	public String WITHHOLDING_TAX_AMT;
	public String RETURN_ACCOUNT_ID;
	public String BENE_NICK_NAME;
	public String RETURN_ACCOUNT_NICKNAME;
	public String RETURN_ACCOUNT_GROUP_CODE;
	public String RETURN_ACCOUNT_SYSTEM_CODE;
	public String COST_CENTRE;
	public String CLEARING_ID;
	public String IBAN_FLAG;
	public String UPDATED_DATE;
	
	public String getInsertSQL(){
		return "Insert into PAY_DTL_REP (DTL_REQ_ID,PAYMENT_ID,ITEM_NUMBER,CUST_REF_NO,TXN_STATUS_CODE,TXN_STATUS_DESC," + 
                "TXN_ADDNL_STATUS_INFO,REMIT_TYPE,REMIT_MSG_TEXT,CUST_DOC_REF,BENE_BANK_COUNTRY,BENE_BIC,BENE_BRANCH," +
                "BENE_NCC_TYPE,BENE_BANK_NAME,BENE_BRANCH_NAME,BENE_BRANCH_CITY,BENE_BANK_ADDR1,BENE_BANK_ADDR2,BENE_BANK_ADDR3," +
                "BENE_NAME,BENE_LOCAL_NAME,BENE_CITY,BENE_ADDR1,BENE_ADDR2,BENE_ADDR3,BENE_COUNTRY,DTL_CR_CURRENCY,CR_AMOUNT," +
                "SENDER_REC1_VALUE,SENDER_REC2_VALUE,SENDER_REC3_VALUE,SENDER_REC4_VALUE,SENDER_REC5_VALUE,SENDER_REC6_VALUE," +
                "CLEARING_PREFERENCE,CLEARING_DATE,PROCESS_DATE,PURPOSE_CODE,BENE_RESIDENT_STATUS,REMIT_INFO,REMIT_CONTACT_INFO," +
                "BENE_ACCOUNT_NO,BENE_ACCOUNTING_SYSTEM_CODE,BENE_ACCOUNTING_GROUP,DEBIT_EQUIVALENT,FX_REF,CHARGE_DETAIL_REF," +
                "DEBIT_EQUIVALENT_AMOUNT,DR_DESCRIPTION,BOP_INFO,BENE_ACCOUNT_ID,BENE_ID,ADD_INV_DETAIL_ID,EXT_PAYMENT_ID," +
                "RETURN_ACCOUNT_NAME,RETURN_ACCOUNT_DIVISION_ID,RETURN_ACCOUNT_CURRENCY,RETURN_ACCOUNT_BRANCH_CODE,RETURN_ACCOUNT_NO," +
                "RETURN_ACCOUNT_BRANCH_NAME,RETURN_DVISION_NAME,REMITTER_NAME,STATEMENT_NARRATIVE,WITHHOLDING_TAX_TYPE,WITHHOLDING_TAX_AMT," +
                "RETURN_ACCOUNT_ID,BENE_NICK_NAME,RETURN_ACCOUNT_NICKNAME,RETURN_ACCOUNT_GROUP_CODE,RETURN_ACCOUNT_SYSTEM_CODE,COST_CENTRE," +
                "CLEARING_ID,IBAN_FLAG,UPDATED_DATE) values (" + 
                getDBValue(this.DTL_REQ_ID) + "," + getDBValue(this.PAYMENT_ID)  + "," + getDBValue(this.ITEM_NUMBER) + "," + getDBValue(this.CUST_REF_NO) + "," + 
                getDBValue(this.TXN_STATUS_CODE) + "," + getDBValue(this.TXN_STATUS_DESC) + "," + getDBValue(this.TXN_ADDNL_STATUS_INFO) + "," + 
                getDBValue(this.REMIT_TYPE) + "," + getDBValue(this.REMIT_MSG_TEXT) + "," + getDBValue(this.CUST_DOC_REF) + "," + getDBValue(this.BENE_BANK_COUNTRY) + "," + 
                getDBValue(this.BENE_BIC) + "," + getDBValue(this.BENE_BRANCH) + "," + getDBValue(this.BENE_NCC_TYPE) + "," + getDBValue(this.BENE_BANK_NAME) + "," + getDBValue(this.BENE_BRANCH_NAME) + 
                "," + getDBValue(this.BENE_BRANCH_CITY) + "," + getDBValue(this.BENE_BANK_ADDR1) + "," + getDBValue(this.BENE_BANK_ADDR2) + "," + getDBValue(this.BENE_BANK_ADDR3) + 
                "," + getDBValue(this.BENE_NAME) + "," + getDBValue(this.BENE_LOCAL_NAME) + "," + getDBValue(this.BENE_CITY) + "," + getDBValue(this.BENE_ADDR1) + "," +
                getDBValue(this.BENE_ADDR2) + "," + getDBValue(this.BENE_ADDR3) + "," + getDBValue(this.BENE_COUNTRY) + "," + getDBValue(this.DTL_CR_CURRENCY) + "," + getDBValue(this.CR_AMOUNT) + "," + 
                getDBValue(this.SENDER_REC1_VALUE) + "," + getDBValue(this.SENDER_REC2_VALUE) + "," + getDBValue(this.SENDER_REC3_VALUE) + "," + getDBValue(this.SENDER_REC4_VALUE) + "," + 
                getDBValue(this.SENDER_REC5_VALUE) + "," + getDBValue(this.SENDER_REC6_VALUE) + "," + getDBValue(this.CLEARING_PREFERENCE) + ",to_date(" + getDBValue(this.CLEARING_DATE) + ",'DD/MON/RR')" + 
                ",to_date(" + getDBValue(this.PROCESS_DATE) + ",'DD/MON/RR')" + "," + getDBValue(this.PURPOSE_CODE) + "," + getDBValue(this.BENE_RESIDENT_STATUS) + "," + 
                getDBValue(this.REMIT_INFO) + "," + getDBValue(this.REMIT_CONTACT_INFO) + "," + getDBValue(this.BENE_ACCOUNT_NO) + "," + getDBValue(this.BENE_ACCOUNTING_SYSTEM_CODE) +
                "," + getDBValue(this.BENE_ACCOUNTING_GROUP) + "," + getDBValue(this.DEBIT_EQUIVALENT) + "," + getDBValue(this.FX_REF) + "," + getDBValue(this.CHARGE_DETAIL_REF) + 
                "," + getDBValue(this.DEBIT_EQUIVALENT_AMOUNT) + "," + getDBValue(this.DR_DESCRIPTION) + "," + getDBValue(this.BOP_INFO) + "," + getDBValue(this.BENE_ACCOUNT_ID) + 
        		"," + getDBValue(this.BENE_ID) + "," + getDBValue(this.ADD_INV_DETAIL_ID) + "," + getDBValue(this.EXT_PAYMENT_ID) + "," + getDBValue(this.RETURN_ACCOUNT_NAME) +
        		"," + getDBValue(this.RETURN_ACCOUNT_DIVISION_ID) + "," + getDBValue(this.RETURN_ACCOUNT_CURRENCY) + "," + getDBValue(this.RETURN_ACCOUNT_BRANCH_CODE) +
        		"," + getDBValue(this.RETURN_ACCOUNT_NO) + "," + getDBValue(this.RETURN_ACCOUNT_BRANCH_NAME) + "," + getDBValue(this.RETURN_DVISION_NAME) +
        		"," + getDBValue(this.REMITTER_NAME) + "," + getDBValue(this.STATEMENT_NARRATIVE) + "," + getDBValue(this.WITHHOLDING_TAX_TYPE) + "," + getDBValue(this.WITHHOLDING_TAX_AMT) +
        		"," + getDBValue(this.RETURN_ACCOUNT_ID) + "," + getDBValue(this.BENE_NICK_NAME) + "," + getDBValue(this.RETURN_ACCOUNT_NICKNAME) + "," + getDBValue(this.RETURN_ACCOUNT_GROUP_CODE) +
        		"," + getDBValue(this.RETURN_ACCOUNT_SYSTEM_CODE) + "," + getDBValue(this.COST_CENTRE) + "," + getDBValue(this.CLEARING_ID) + "," + getDBValue(this.IBAN_FLAG) + 
        		",TO_DATE(" + getDBValue(this.UPDATED_DATE) + ", 'yyyymmdd'))";
	}

}
 