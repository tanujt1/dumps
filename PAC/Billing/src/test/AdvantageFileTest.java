package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.AdvantageFeeFile;
import src.AdvantageFeeHeader;
import src.AdvantageFeePayment;
import src.AdvantageFeeTrailer;

public class AdvantageFileTest {
	@Test
	public void can_Parse_Caption_Field_From_Advantage_Fee_File_Header(){
		AdvantageFeeFile file = new AdvantageFeeFile("PAC_BILLING_SINGLE_PAY_20171005.txt");
		AdvantageFeeHeader hdr = file.getHeader();
		assertEquals("FileTitle=Securities",hdr.getCaption());		
	}
	
	@Test
	public void can_Parse_Version_Field_From_Advantage_Fee_File_Header(){
		AdvantageFeeFile file = new AdvantageFeeFile("PAC_BILLING_SINGLE_PAY_20171005.txt");
		AdvantageFeeHeader hdr = file.getHeader();
		assertEquals("VER5.0", hdr.getVersion());
	}
	
	@Test
	public void can_Parse_Creation_Date_Field_From_Advantage_Fee_File_Header(){
		AdvantageFeeFile file = new AdvantageFeeFile("PAC_BILLING_SINGLE_PAY_20171005.txt");
		AdvantageFeeHeader hdr = file.getHeader();
		assertEquals("10/05/2017", hdr.getCreateDate());
	}
	
	@Test
	public void can_Parse_Source_Channel_Field_From_Advantage_Fee_File_Header(){
		AdvantageFeeFile file = new AdvantageFeeFile("PAC_BILLING_SINGLE_PAY_20171005.txt");
		AdvantageFeeHeader hdr = file.getHeader();
		assertEquals("CHANEL0001", hdr.getSourceChannel());
	}
	@Test
	public void can_Count_Payments_In_Advantage_Fee_File(){
		AdvantageFeeFile file = new AdvantageFeeFile("PAC_BILLING_SINGLE_PAY_20171005.txt");
		assertEquals(16,file.getPayments().size());
	}
	@Test
	public void can_Parse_AccountNumber_Field_From_Advantage_Fee_File(){
		AdvantageFeeFile file = new AdvantageFeeFile("PAC_BILLING_SINGLE_PAY_20171005.txt");
		AdvantageFeePayment payment = file.getPayments().get(0);
		assertEquals("111111_TRNAU",payment.getAccountNumber().trim());
	}
	@Test
	public void can_Parse_BatchDate_Field_From_Advantage_Fee_File(){
		AdvantageFeeFile file = new AdvantageFeeFile("PAC_BILLING_SINGLE_PAY_20171005.txt");
		AdvantageFeePayment payment = file.getPayments().get(0);
		assertEquals("20171005",payment.getBatchDate().trim());
	}
	@Test
	public void can_Parse_PaymentId_Field_FromAdvantage_Fee_File(){
		AdvantageFeeFile file = new AdvantageFeeFile("PAC_BILLING_SINGLE_PAY_20171005.txt");
		AdvantageFeePayment payment = file.getPayments().get(0);
		assertEquals("231131722",payment.getPaymentId().trim());
	}
	@Test
	public void can_Parse_Caption_Field_From_Advantage_Fee_FileTrailer(){
		AdvantageFeeFile file = new AdvantageFeeFile("PAC_BILLING_SINGLE_PAY_20171005.txt");
		AdvantageFeeTrailer trailer = file.getTrailer();
		assertEquals("NumberOfRecords=",trailer.getCaption().trim());
	}

}
