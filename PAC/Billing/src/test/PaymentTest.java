package test;

import static org.junit.Assert.*;



import org.junit.Test;


import src.ChargeDetail;
import src.ChargeList;
import src.Payment;
import src.PaymentDetail;
import src.PaymentHeader;

public class PaymentTest {

	@Test
	public void can_generate_insert_Payment_Header_SQL() {
		Payment payment = new Payment("Completed", "INT",4000);
		PaymentHeader hdr = payment.CreateValidBillingPaymentHeader();
		String batchId = "15";
		hdr.BATCH_ID = batchId;
		String expected = "Insert into PAY_HDR_REP (REQ_ID,ACCOUNT_ID,BATCH_ID,ENTRY_METHOD,PAYMENT_METHOD,VALUE_DATE,TOTAL_TXNS,TOTAL_DR_AMOUNT,TOTAL_CR_AMOUNT,CR_CURRENCY,DR_CURRENCY,DEBIT_METHOD,TRANSACTION_TYPE,DIVISION_ID,SENDER_COUNTRY,SENDER_BIC,SENDER_BRANCH_NAME,SENDER_BANK_NAME,ACCOUNT_NAME,DEBIT_RESIDENT_STATUS,ACCOUNT_ADDRESS1,ACCOUNT_ADDRESS2,ACCOUNT_ADDRESS3,ACCOUNT_ADDRESS4,DEBIT_ADDRESS_COUNTRY,BATCH_REF,BATCH_NAME,ACCOUNT_NO,ACCOUNTING_SYSTEM_CODE,ACCOUNTING_GROUP,DR_BATCH_DESCRIPTION,BATCH_FX_REF,FILE_ID,FILE_NAME,STATUS_CODE,STATUS_DESC,ENTL_PROD_FEATURE,DIVISION_NAME,ADDNL_STATUS_DESC,EXT_PAYMENT_BATCH_ID,CHANNEL,EXT_FILE_ID,EXT_FILE_NAME,ACCOUNT_NAME1_LL,ACCOUNT_NAME2_LL,ADDRESS1_LL,ADDRESS2_LL,ADDRESS3_LL,ACCOUNT_BRANCH_CODE,REMITTER_NAME,RETURN_ACCOUNT_ID,RETURN_ACCOUNT_NO,RETURN_ACCOUNT_NAME,RETURN_ACCOUNT_DIVISION_ID,RETURN_ACCOUNT_BRANCH_CODE,RETURN_ACCOUNT_CURRENCY,CLEARING_ID,ACCOUNT_NICK_NAME,DEBIT_STATEMENT_NARRATIVE,PURPOSE_CODE,RETURN_ACCOUNT_NICKNAME,RETURN_ACCOUNT_GROUP_CODE,RETURN_ACCOUNT_SYSTEM_CODE,PRODUCT,COBRA_PRODUCT_ID) values ('" + payment.Id + "','AU735627688','" + batchId + "','CLIENT','INT',to_date('22/SEP/17','DD/MON/RR'),2,80000,80000,'CNY','AUD','MULTI','TRF','ANZ-DIV05','AU','ANZBAU3MXXX','646000','INT OPEE ACCOUNT','INT OPEE ACCOUNT','RA','ACCT ADDR1','ACCT ADDR2','ACCT ADDR3','ACCT ADDR4','AU','TC001539i81','BATCH NAME 2','735627688','CAP','AUA','Batch Debit Description','[{\"itemNo\":\"1\",\"fxType\":\"Dynamic\",\"fxOwner\":\"DEAL\",\"dealSys\":\"MDZ\",\"dealGrp\":\"CNR\",\"fxAcctId\":null,\"fxQuoteId\":null,\"fxDealId\":\"1082\",\"exchRate\":10.01,\"tranDate\":\"2016-07-28\",\"fromAmount\":0.01,\"availFromAmount\":9999990000.00,\"toAmount\":20.90,\"availToAmount\":11880000.00,\"baseAmount\":null,\"baseCurCode\":null},{\"itemNo\":\"2\",\"fxType\":\"DEAL\",\"fxOwner\":\"DEAL\",\"dealSys\":\"MDZ\",\"dealGrp\":\"CNR\",\"fxAcctId\":null,\"fxQuoteId\":null,\"fxDealId\":\"1082\",\"exchRate\":10.01,\"tranDate\":\"2016-07-28\",\"fromAmount\":20.91,\"availFromAmount\":9999990000.00,\"toAmount\":100.91,\"availToAmount\":11880000.00,\"baseAmount\":null,\"baseCurCode\":null},{\"itemNo\":\"3\",\"fxType\":\"Dynamic\",\"fxOwner\":\"DEAL\",\"dealSys\":\"MDZ\",\"dealGrp\":\"CNR\",\"fxAcctId\":null,\"fxQuoteId\":null,\"fxDealId\":\"1082\",\"exchRate\":10.01,\"tranDate\":\"2016-07-28\",\"fromAmount\":0.01,\"availFromAmount\":9999990000.00,\"toAmount\":20.90,\"availToAmount\":11880000.00,\"baseAmount\":null,\"baseCurCode\":null},{\"itemNo\":\"4\",\"fxType\":\"DEAL\",\"fxOwner\":\"DEAL\",\"dealSys\":\"MDZ\",\"dealGrp\":\"CNR\",\"fxAcctId\":null,\"fxQuoteId\":null,\"fxDealId\":\"1082\",\"exchRate\":10.01,\"tranDate\":\"2016-07-28\",\"fromAmount\":20.91,\"availFromAmount\":9999990000.00,\"toAmount\":100.91,\"availToAmount\":11880000.00,\"baseAmount\":null,\"baseCurCode\":null}]','1234','abc.txt',null,null,'INT',null,null,'31408S5330BI007',null,'3456','Lakshmi.xml',null,null,null,null,null,'MELBOURNE','REMITDEBIT','410792733','CAP','CMP-TEST CAP 4',null,'013483',null,null,'INT OPEE ACCOUNT','NARRDEBIT',null,null,'AUA',null,null,null)";
		assertEquals(expected, hdr.getInsertSQL());
	}
	
	@Test
	public void can_generate_insert_Payment_Detail_SQL() {
		Payment payment = new Payment("Completed", "INT", 4000);
		String headerId = "1234";
		String paymentId = "4";
		PaymentDetail dtl = payment.CreateValidBillingPaymentDetail(1);
		dtl.DTL_REQ_ID = headerId;
		dtl.PAYMENT_ID = paymentId;
		String expected = "Insert into PAY_DTL_REP (DTL_REQ_ID,PAYMENT_ID,ITEM_NUMBER,CUST_REF_NO,TXN_STATUS_CODE,TXN_STATUS_DESC,TXN_ADDNL_STATUS_INFO,REMIT_TYPE,REMIT_MSG_TEXT,CUST_DOC_REF,BENE_BANK_COUNTRY,BENE_BIC,BENE_BRANCH,BENE_NCC_TYPE,BENE_BANK_NAME,BENE_BRANCH_NAME,BENE_BRANCH_CITY,BENE_BANK_ADDR1,BENE_BANK_ADDR2,BENE_BANK_ADDR3,BENE_NAME,BENE_LOCAL_NAME,BENE_CITY,BENE_ADDR1,BENE_ADDR2,BENE_ADDR3,BENE_COUNTRY,DTL_CR_CURRENCY,CR_AMOUNT,SENDER_REC1_VALUE,SENDER_REC2_VALUE,SENDER_REC3_VALUE,SENDER_REC4_VALUE,SENDER_REC5_VALUE,SENDER_REC6_VALUE,CLEARING_PREFERENCE,CLEARING_DATE,PROCESS_DATE,PURPOSE_CODE,BENE_RESIDENT_STATUS,REMIT_INFO,REMIT_CONTACT_INFO,BENE_ACCOUNT_NO,BENE_ACCOUNTING_SYSTEM_CODE,BENE_ACCOUNTING_GROUP,DEBIT_EQUIVALENT,FX_REF,CHARGE_DETAIL_REF,DEBIT_EQUIVALENT_AMOUNT,DR_DESCRIPTION,BOP_INFO,BENE_ACCOUNT_ID,BENE_ID,ADD_INV_DETAIL_ID,EXT_PAYMENT_ID,RETURN_ACCOUNT_NAME,RETURN_ACCOUNT_DIVISION_ID,RETURN_ACCOUNT_CURRENCY,RETURN_ACCOUNT_BRANCH_CODE,RETURN_ACCOUNT_NO,RETURN_ACCOUNT_BRANCH_NAME,RETURN_DVISION_NAME,REMITTER_NAME,STATEMENT_NARRATIVE,WITHHOLDING_TAX_TYPE,WITHHOLDING_TAX_AMT,RETURN_ACCOUNT_ID,BENE_NICK_NAME,RETURN_ACCOUNT_NICKNAME,RETURN_ACCOUNT_GROUP_CODE,RETURN_ACCOUNT_SYSTEM_CODE,COST_CENTRE,CLEARING_ID,IBAN_FLAG,UPDATED_DATE) values ('" + headerId + "','" + paymentId + "',1,'Test Ref','0','Completed','[{\"statusCode\":null,\"statusDesc\":\"Payment processed successfully\"}]',null,null,'[{\"name\":\"Doc1.pdf\",\"id\":\"A1198344\"},{\"name\":\"Doc2.pdf\",\"id\":\"A1198345\"},{\"name\":\"Doc3.pdf\",\"id\":\"A1198346\"}]','CN',null,'001148013004',null,'?????????????','?????????????',null,'ADDRESS1',null,null,'BEPS',null,'SHANGHAI','Bene Add 1','Bene Add 2','Bene Add 3','CN','CNY',2115,null,null,null,null,null,null,'DHVPS',to_date('28/SEP/16','DD/MON/RR'),to_date('28/SEP/16','DD/MON/RR'),'02103','DOM','Remit 1 Remit 2 Remit 3 Remit 4','[{\"contactId\":null,\"contactTitle\":null,\"contactType\":null,\"contactName\":null,\"contactAddr\":null}]','2429479238497234897',null,null,'N','[{\"itemNo\":\"1\",\"fxType\":\"DEAL\",\"fxOwner\":\"DEAL\",\"dealSys\":\"MDZ\",\"dealGrp\":\"CNR\",\"fxAcctId\":null,\"fxQuoteId\":null,\"fxDealId\":\"1082\",\"exchRate\":1.32,\"tranDate\":null,\"fromAmount\":null,\"availFromAmount\":null,\"toAmount\":2115,\"availToAmount\":null,\"baseAmount\":null,\"baseCurCode\":null}]',null,2115,'Txn Debit Desc',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,TO_DATE('20170919', 'yyyymmdd'))";
		assertEquals(expected, dtl.getInsertSQL());
	}
	
	@Test
	public void can_insert_Payment_with_chargeInfo() {
		Payment payment = new Payment("Completed", "INT", 4000);
		String headerId = "1234";
		String paymentId = "4";
		ChargeDetail detail = new ChargeDetail();
		detail.chargeBearer = "OUR";
		detail.chargeCurrency = "CNY";
		detail.totalChargeAmount = 10;
		ChargeList chargeList = new ChargeList();
		chargeList.type = "OUR";
		chargeList.amount = 10;
		detail.chargeList.add(chargeList);		
		payment.chargeDetail.add(detail);
		
		PaymentDetail dtl = payment.CreateValidBillingPaymentDetail(1);
		
		dtl.DTL_REQ_ID = headerId;
		
		dtl.PAYMENT_ID = paymentId;
		String expected = "Insert into PAY_DTL_REP (DTL_REQ_ID,PAYMENT_ID,ITEM_NUMBER,CUST_REF_NO,TXN_STATUS_CODE,TXN_STATUS_DESC,TXN_ADDNL_STATUS_INFO,REMIT_TYPE,REMIT_MSG_TEXT,CUST_DOC_REF,BENE_BANK_COUNTRY,BENE_BIC,BENE_BRANCH,BENE_NCC_TYPE,BENE_BANK_NAME,BENE_BRANCH_NAME,BENE_BRANCH_CITY,BENE_BANK_ADDR1,BENE_BANK_ADDR2,BENE_BANK_ADDR3,BENE_NAME,BENE_LOCAL_NAME,BENE_CITY,BENE_ADDR1,BENE_ADDR2,BENE_ADDR3,BENE_COUNTRY,DTL_CR_CURRENCY,CR_AMOUNT,SENDER_REC1_VALUE,SENDER_REC2_VALUE,SENDER_REC3_VALUE,SENDER_REC4_VALUE,SENDER_REC5_VALUE,SENDER_REC6_VALUE,CLEARING_PREFERENCE,CLEARING_DATE,PROCESS_DATE,PURPOSE_CODE,BENE_RESIDENT_STATUS,REMIT_INFO,REMIT_CONTACT_INFO,BENE_ACCOUNT_NO,BENE_ACCOUNTING_SYSTEM_CODE,BENE_ACCOUNTING_GROUP,DEBIT_EQUIVALENT,FX_REF,CHARGE_DETAIL_REF,DEBIT_EQUIVALENT_AMOUNT,DR_DESCRIPTION,BOP_INFO,BENE_ACCOUNT_ID,BENE_ID,ADD_INV_DETAIL_ID,EXT_PAYMENT_ID,RETURN_ACCOUNT_NAME,RETURN_ACCOUNT_DIVISION_ID,RETURN_ACCOUNT_CURRENCY,RETURN_ACCOUNT_BRANCH_CODE,RETURN_ACCOUNT_NO,RETURN_ACCOUNT_BRANCH_NAME,RETURN_DVISION_NAME,REMITTER_NAME,STATEMENT_NARRATIVE,WITHHOLDING_TAX_TYPE,WITHHOLDING_TAX_AMT,RETURN_ACCOUNT_ID,BENE_NICK_NAME,RETURN_ACCOUNT_NICKNAME,RETURN_ACCOUNT_GROUP_CODE,RETURN_ACCOUNT_SYSTEM_CODE,COST_CENTRE,CLEARING_ID,IBAN_FLAG,UPDATED_DATE) values ('" + headerId + "','" + paymentId + "',1,'Test Ref','0','Completed','[{\"statusCode\":null,\"statusDesc\":\"Payment processed successfully\"}]',null,null,'[{\"name\":\"Doc1.pdf\",\"id\":\"A1198344\"},{\"name\":\"Doc2.pdf\",\"id\":\"A1198345\"},{\"name\":\"Doc3.pdf\",\"id\":\"A1198346\"}]','CN',null,'001148013004',null,'?????????????','?????????????',null,'ADDRESS1',null,null,'BEPS',null,'SHANGHAI','Bene Add 1','Bene Add 2','Bene Add 3','CN','CNY',2115,null,null,null,null,null,null,'DHVPS',to_date('28/SEP/16','DD/MON/RR'),to_date('28/SEP/16','DD/MON/RR'),'02103','DOM','Remit 1 Remit 2 Remit 3 Remit 4','[{\"contactId\":null,\"contactTitle\":null,\"contactType\":null,\"contactName\":null,\"contactAddr\":null}]','2429479238497234897',null,null,'N','[{\"itemNo\":\"1\",\"fxType\":\"DEAL\",\"fxOwner\":\"DEAL\",\"dealSys\":\"MDZ\",\"dealGrp\":\"CNR\",\"fxAcctId\":null,\"fxQuoteId\":null,\"fxDealId\":\"1082\",\"exchRate\":1.32,\"tranDate\":null,\"fromAmount\":null,\"availFromAmount\":null,\"toAmount\":2115,\"availToAmount\":null,\"baseAmount\":null,\"baseCurCode\":null}]','[{\"chargeBearer\":\"OUR\",\"totalChargeAmount\":10,\"chargeCurrency\":\"CNY\",\"chargeList\":[{\"type\":\"OUR\",\"amount\":10}]}]',2115,'Txn Debit Desc',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,TO_DATE('20170919', 'yyyymmdd'))";
		assertEquals(expected, dtl.getInsertSQL());
	}
	
	
	
	
	//"[{"chargeBearer":"OUR","totalChargeAmount":10,"chargeCurrency":"CNY","chargeList":[{"type":"OUR","amount":10}]}];"
/*	Only use to test the database payments work properly
 	@Test
	public void insertIntoDBIntegrationTest()
	{
		Payment payment = new Payment();
		String paymentId = payment.Create();
		System.out.println(paymentId);
		assertTrue(paymentId!="");
	}
	*/
	
}