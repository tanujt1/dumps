/**************************************************************************************************/
/* 
 *  
 * DO NOT ADD PACKAGE DECLARATION
 * PLEASE NOTE: THIS SKELETON FILE MUST BE PLACED UNDER DEFAULT PACKAGE OF SRC FOLDER
 * 
 * ALL THE CODING MUST BE DONE INSIDE THIS SINGLE .JAVA FILE ONLY 
 * DO NOT CREATE DEPENDENT CLASSES
 * DO NOT MODIFY CODE SKELETON 
 * DO NOT MODIFY: 
 * 		ACCESS SPECIFIERS, RETURN TYPES OR DATA TYPES, EXCEPTION CLAUSES, 
 * 	    CLASS OR METHOD NAMES IN THE SKELETON
 *  
 *  
 *  YOU MUST CODE ON THE SAME PROJECT MAPPED IN EBOX VIEW THROUGHOUT THE ASSESSMENT
 *  CLICK ON 'Problem/Project Status' BUTTON TO SEE THE PROJECT MAPPED IN EBOX
 *  
 *  YOU MUST CLICK ON 'SAVE PROJECT' BUTTON EVERY 10 MINUTES TO PERIODICALLY SAVE 
 *  CTRL + S ALONE, WILL NOT BE SUFFICIENT TO SAVE YOUR CODE IN EBOX
 *  CLICKING ON 'SAVE PROJECT' ENSURES NO LOSS OF CODE 
 * 
 *  REACH OUT TO PROCTORS FOR ANY QUERIES
 *  
 * Skeleton Version 2.0
 * Date Modified: 21-June-2016 
 */
/*************************************************************************************************/

// imports goes here

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * This class must be used to write the solution for the given requirement. No
 * additional classes must be created.
 * 
 */
public class TrustLoanSanctioner {

	/**
	 * @param args
	 * @throws TrustLoanException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws TrustLoanException,
			FileNotFoundException {
		// Change this to the absolute path where you have placed the input feed
		String filePath = "D:\\abc\\input.txt";
		// String filePath = "D:\\javaca\\ccjp.txt";
		TrustLoanSanctioner ts = new TrustLoanSanctioner();
		ts.loanProcessor(filePath, "30/06/2017");

		/*
		 * Run the following code snippet to validate your code structure before
		 * uploading the code. Do not edit this code.
		 */

	}

	/**
	 * @param filePath
	 * @param sanctionDate
	 * @return Map<Integer, Map<String, List<PolicyHolderVO>>>
	 * @throws TrustLoanException
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	public Map<Integer, Map<String, List<PolicyHolderVO>>> loanProcessor(
			String filePath, String sanctionDate) throws TrustLoanException,
			FileNotFoundException {

		// TODO Associate to type their code here
		// TODO Associate to modify the return statement according to the
		// requirement
		Map<String, List<PolicyHolderVO>> finalOutputmap = null;
		try {
			finalOutputmap = new HashMap<String, List<PolicyHolderVO>>();
			// List<String> inputDataList = readFromInputFile(filePath);
			BufferedReader br = null;
			String singleLineFromInput = null;
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

			File file = new File(filePath);
		//	System.out.println(file.exists());
			if (file.exists()) {
				br = new BufferedReader(new FileReader(filePath));
				try {
					List<PolicyHolderVO> elg = new ArrayList<PolicyHolderVO>();
					List<PolicyHolderVO> nelg = new ArrayList<PolicyHolderVO>();

					while ((singleLineFromInput = br.readLine()) != null) {
						if (singleLineFromInput != null
								&& singleLineFromInput.length() > 0) {
							String[] values = singleLineFromInput.split(",|;");
							// for (String s : values)
							// System.out.println(s);
							boolean valResult = validateInputs(values);
							if (!valResult) {
								String message = "validation failed";
								throw new TrustLoanException(message);
							} else {
								System.out.println(" inside else");

								float sumAssurred = Float.parseFloat(values[0]
										.substring(9, values[0].length()));
								PolicyHolderVO pH = new PolicyHolderVO();
								pH.setPolicyCode(values[0]);
								pH.setPan(values[1]);
								pH.setPolicyStartDate(format.parse(values[2]));
								pH.setPeriod(Integer.parseInt(values[3]));
								float accumulatedAmt = Float
										.parseFloat(values[4]);
								pH.setAccumulatedPremiumAmount(accumulatedAmt);
								float reqLoanAmt = Float.parseFloat(values[5]);
								pH.setRequestedLoanAmount(reqLoanAmt);
								Calendar cal=Calendar.getInstance();
								cal.setTime(pH.getPolicyStartDate());
								cal.add(Calendar.MONTH, pH.getPeriod());
								pH.setPolicyEndDate(cal.getTime());

								
								if (values[0].startsWith("NRM")) {
									float percentAmt1 = (float) (0.4 * accumulatedAmt);
									if (reqLoanAmt > percentAmt1) {
										nelg.add(pH);
									} else if (reqLoanAmt < percentAmt1) {
										elg.add(pH);
									}
								}

								if (values[0].startsWith("FST")) {
									float percentAmt2 = (float) (0.6 * accumulatedAmt);
									float percentAmt3 = (float) (0.7 * sumAssurred);
									if (reqLoanAmt < percentAmt2) {
										elg.add(pH);
									} else if ((reqLoanAmt > percentAmt2)
											&& (reqLoanAmt < percentAmt3)) {
										elg.add(pH);
									} else if ((reqLoanAmt > percentAmt2)
											&& (reqLoanAmt > percentAmt3)) {
										nelg.add(pH);
									}
								}

								finalOutputmap.put("ELG", elg);
								finalOutputmap.put("NELG", nelg);

							}
						}
					}
				} catch (IOException e) {
					throw new TrustLoanException("File io exception: "
							+ e.getMessage());
				}finally{
					try {
						br.close();
					} catch (IOException e) {
						throw new TrustLoanException("Unable to close the buffered reader.");
					}
				}
			} else {
				throw new FileNotFoundException("FIle Not found exception: ");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new FileNotFoundException("File Not found exception: "
					+ e.getMessage());
		} catch (ParseException e) {
			throw new TrustLoanException("File Parse exception: "
					+ e.getMessage());
		}
		Map<Integer, Map<String, List<PolicyHolderVO>>> map=new HashMap<Integer, Map<String, List<PolicyHolderVO>>>();
	
		
	//	System.out.println(finalOutputmap);
		return null;// TODO Change this return value

	}

	private boolean validateInputs(final String[] str)
			throws TrustLoanException {
		boolean result = true;
		final String POLICY_CODE = "(\\w{3})(-)(\\d{4})(-)([0-9]*$)";
		String sumAssurred = str[0].substring(9, str[0].length());

		// All fields mandatory
		if (str[0].isEmpty() || str[1].isEmpty() || str[2].isEmpty()
				|| str[3].isEmpty() || str[4].isEmpty() || str[5].isEmpty()) {
			System.out.println("All fileds are mandatory validation failed");
			result = false;
		}

		// validation 2
		if (!(Pattern.matches("[FR0-9]{5}", str[1]))) {
			System.out.println("PAN is invalid");
			result = false;
		}

		// validation 3
		Pattern p1 = Pattern.compile(POLICY_CODE);

		if (p1.matcher(str[0]).matches()) {

			String type = str[0].substring(0, 3);
			String policyNo = str[0].substring(4, 8);

			// validation 4
			if (!(type.startsWith("FST") || type.startsWith("NRM"))) {
				System.out.println("Invalid Policy type");
				result = false;
			}

			if (Integer.parseInt(policyNo) < 0) {
				result = false;
				System.out.println("Policy number is a non zero value");
			}
			// validation 6
			for (Character c : sumAssurred.toCharArray()) {
				if (!Character.isDigit(c)) {
					result = false;
					System.out.println("Sum Assured is not a number");
					break;
				}
			}
		} else {
			System.out.println("Invalid Policy Code");
			result = false;
		}

		// validation 7
		if (!isValidDate(str[2])) {
			System.out.println("Date is Invalid Format");
			result = false;
		}
//TODO
		// validation 8
		/*if (!(Integer.parseInt(str[4]) < Integer.parseInt(sumAssurred))) {
			System.out.println("Date is Invalid Format");
			result = false;
		}*/

		return result;

	}

	public static boolean isValidDate(String inDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inDate.trim());
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}

}

/**
 * VO class supplied part of the Skeleton. Do not modify this class
 * 
 */
class PolicyHolderVO {
	private String policyCode;
	private String pan;
	private Date policyStartDate;
	private int period;
	private float accumulatedPremiumAmount;
	private float requestedLoanAmount;
	private Date policyEndDate;
	private float netPremiumAmount;

	/**
	 * @return the policyCode
	 */
	public String getPolicyCode() {
		return policyCode;
	}

	/**
	 * @param policyCode
	 *            the policyCode to set
	 */
	public void setPolicyCode(String policyCode) {
		this.policyCode = policyCode;
	}

	/**
	 * @return the pan
	 */
	public String getPan() {
		return pan;
	}

	/**
	 * @param pan
	 *            the pan to set
	 */
	public void setPan(String pan) {
		this.pan = pan;
	}

	/**
	 * @return the policyStartDate
	 */
	public Date getPolicyStartDate() {
		return policyStartDate;
	}

	/**
	 * @param policyStartDate
	 *            the policyStartDate to set
	 */
	public void setPolicyStartDate(Date policyStartDate) {
		this.policyStartDate = policyStartDate;
	}

	/**
	 * @return the period
	 */
	public int getPeriod() {
		return period;
	}

	/**
	 * @param period
	 *            the period to set
	 */
	public void setPeriod(int period) {
		this.period = period;
	}

	/**
	 * @return the accumulatedPremiumAmount
	 */
	public float getAccumulatedPremiumAmount() {
		return accumulatedPremiumAmount;
	}

	/**
	 * @param accumulatedPremiumAmount
	 *            the accumulatedPremiumAmount to set
	 */
	public void setAccumulatedPremiumAmount(float accumulatedPremiumAmount) {
		this.accumulatedPremiumAmount = accumulatedPremiumAmount;
	}

	/**
	 * @return the requestedLoanAmount
	 */
	public float getRequestedLoanAmount() {
		return requestedLoanAmount;
	}

	/**
	 * @param requestedLoanAmount
	 *            the requestedLoanAmount to set
	 */
	public void setRequestedLoanAmount(float requestedLoanAmount) {
		this.requestedLoanAmount = requestedLoanAmount;
	}

	/**
	 * @return the policyEndDate
	 */
	public Date getPolicyEndDate() {
		return policyEndDate;
	}

	/**
	 * @param policyEndDate
	 *            the policyEndDate to set
	 */
	public void setPolicyEndDate(Date policyEndDate) {
		this.policyEndDate = policyEndDate;
	}

	/**
	 * @return the netPremiumAmount
	 */
	public float getNetPremiumAmount() {
		return netPremiumAmount;
	}

	/**
	 * @param netPremiumAmount
	 *            the netPremiumAmount to set
	 */
	public void setNetPremiumAmount(float netPremiumAmount) {
		this.netPremiumAmount = netPremiumAmount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PolicyHolderVO [policyCode=");
		builder.append(policyCode);
		builder.append(", pan=");
		builder.append(pan);
		builder.append(", policyStartDate=");
		builder.append(policyStartDate);
		builder.append(", period=");
		builder.append(period);
		builder.append(", accumulatedPremiumAmount=");
		builder.append(accumulatedPremiumAmount);
		builder.append(", requestedLoanAmount=");
		builder.append(requestedLoanAmount);
		builder.append(", policyEndDate=");
		builder.append(policyEndDate);
		builder.append(", netPremiumAmount=");
		builder.append(netPremiumAmount);
		builder.append("]");
		return builder.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		boolean isEqual = false;
		PolicyHolderVO other = (PolicyHolderVO) object;
		System.out.println(this.getPolicyEndDate());
		System.out.println(other.getPolicyEndDate());
		if ((this.getPolicyCode().equals(other.getPolicyCode()))
				&& (this.getPolicyStartDate()
						.equals(other.getPolicyStartDate()))
				&& (this.getAccumulatedPremiumAmount() == other
						.getAccumulatedPremiumAmount())) {
			isEqual = true;
		}
		return isEqual;
	}

}

/**
 * 
 * Exception class supplied part of the Skeleton. Do not modify this class
 * 
 */
class TrustLoanException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TrustLoanException(Throwable throwable) {
		super(throwable);
	}

	public TrustLoanException(String message) {
		super(message);

	}

	public TrustLoanException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
