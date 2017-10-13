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

// imports here

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * This class must be used to write the solution for the given requirement. No
 * additional classes must be created.
 * 
 */
public class PatientInformationTool {

	/** Logger instance */
	private static final Logger LOG = Logger
			.getLogger(PatientInformationTool.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Change this to the absolute path where you have placed the input feed
		String filePath = "C:\\Users\\203684\\Desktop\\PatientInfo\\inputError.txt";

		/*
		 * Run the following code snippet to validate your code structure before
		 * uploading the code. Do not edit this code.
		 */
		PatientInformationTool patientInformationTool = new PatientInformationTool();
		try {
			Map<Integer, Map> getPatientDetail = patientInformationTool
					.getPatientDetails(filePath);

			System.out.println(getPatientDetail.get(1));
			System.out.println(getPatientDetail.get(2));
		} catch (PatientInformationDetailsException e) {
			LOG.log(Level.SEVERE, "processing failed", e);
		}

	}

	/**
	 * @param filePath
	 * @return Map<Integer, Map>
	 * @throws PatientInformationDetailsException
	 */
	public Map<Integer, Map> getPatientDetails(final String filePath)
			throws PatientInformationDetailsException {

		// TODO Associate to type their code here
		// TODO Associate to modify the return statement according to the
		// requirement

		Map<Integer, Map> patientDetails = new HashMap<Integer, Map>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));

			String info;
			String[] recordDetails;

			Map<String, List<PatientVO>> mapPatient = new HashMap<String, List<PatientVO>>();
			Map<String, Integer> mapPhysicianCat = new HashMap<String, Integer>();
			// Initialize the map.
			initializePhysicianCategoryToPatientMap(mapPhysicianCat);
			while ((info = br.readLine()) != null) {
				recordDetails = info.split(";");

				for (String record : recordDetails) {
					LOG.info(record);
				}
				// Validate the records
				validateInputs(recordDetails);

				// Extract the records and set it in the VO.
				PatientVO patientInformation = new PatientVO();

				String name = recordDetails[0];
				String patientMRN = recordDetails[1];
				String gender = recordDetails[2];
				String physicianId = recordDetails[3];
				Date admissionDate = convertStringToDate(recordDetails[4]);
				Date dischargeDate = convertStringToDate(recordDetails[5]);

				patientInformation.setName(name);

				patientInformation.setMrn(patientMRN);

				patientInformation.setPhysicianId(physicianId);

				patientInformation.setGender(gender);

				patientInformation.setAdmissionDate(admissionDate);

				patientInformation.setDischargeDate(dischargeDate);

				patientInformation.setBill(calculateBill(
						patientInformation.getPhysicianId(),
						patientInformation.getAdmissionDate(),
						patientInformation.getDischargeDate()));

				setNoOfPatientsToPhysicianCategory(mapPhysicianCat,
						getPhysicianCategory(patientInformation
								.getPhysicianId()));
				// Populate the map
				if (mapPatient.get(recordDetails[4]) != null) {
					List<PatientVO> lstPatient = mapPatient
							.get(recordDetails[4]);
					lstPatient.add(patientInformation);
				} else {
					List<PatientVO> patientList = new ArrayList<PatientVO>();
					patientList.add(patientInformation);
					mapPatient.put(recordDetails[4], patientList);
				}
			}
			// key 1
			patientDetails.put(1, mapPatient);
			// key 2
			patientDetails.put(2, mapPhysicianCat);

		} catch (FileNotFoundException e) {
			throw new PatientInformationDetailsException(
					"Patient file not found.", e);
		} catch (IOException e) {
			throw new PatientInformationDetailsException(
					"Patient file processing error.", e);
		} catch (ParseException e) {
			throw new PatientInformationDetailsException("Unparsable date.", e);
		}

		return patientDetails;

	}

	private void validateInputs(final String[] records)
			throws PatientInformationDetailsException {

		String patientMRN = records[1];
		String patientName = records[0];
		String patientGender = records[2];
		String physicianId = records[3];
		String admissionDate = records[4];
		String dischargeDate = records[5];
		// All fields mandatory
		if ((null != patientName && patientName.isEmpty())
				|| (null != patientMRN && patientMRN.isEmpty())
				|| (null != patientGender && patientGender.isEmpty())
				|| (null != physicianId && physicianId.isEmpty())
				|| (null != admissionDate && admissionDate.isEmpty())
				|| (null != dischargeDate && dischargeDate.isEmpty())) {
			throw new PatientInformationDetailsException(
					"All fields are mandatory. Please provide all the fields.");

		}

		if (!(Pattern.matches("[a-zA-Z\\s]+", patientName.trim()))) {
			throw new PatientInformationDetailsException(
					"Invalid name. Name can contain only alphabets and whitespace.");
		}

		if (!(Pattern.matches("[(IN|OUT)0-9]*", patientMRN.trim()))) {
			throw new PatientInformationDetailsException(
					"Invalid MRN. MRN should start with IN/OUT followed by an integer.");
		}

		if (!Pattern.matches("(M|F)", patientGender.trim())) {
			throw new PatientInformationDetailsException("Invalid Gender.");
		}

		if (!Pattern.matches("[0-9]{4}-?(ENT|GEN|NEU)", physicianId.trim())) {
			throw new PatientInformationDetailsException(
					"Invalid physician ID. It should be a 4 digit no followed by - and any 3 categories (GEN/NEU/ENT).");
		}

		if (!isValidDate(admissionDate.trim())) {
			throw new PatientInformationDetailsException(
					"Invalid Admission date.");
		}

		if (!isValidDate(dischargeDate.trim())) {
			throw new PatientInformationDetailsException(
					"Invalid Discahrge date.");
		}

		try {
			if (convertStringToDate(dischargeDate.trim()).before(
					convertStringToDate(admissionDate.trim()))) {
				throw new PatientInformationDetailsException(
						"Discharge date cannot be earlier than admission date.");
			}
		} catch (ParseException e) {
			throw new PatientInformationDetailsException("Invalid dates");
		}
	}

	private boolean isValidDate(String inDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inDate.trim());
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}

	private Date convertStringToDate(String date) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date convDate = df.parse(date);
		return convDate;
	}

	private Integer calculateBill(String physicianId, Date admissionDate,
			Date dischargedate) throws PatientInformationDetailsException {

		Integer bill = null;

		long datediff = dischargedate.getTime() - admissionDate.getTime();
		long days = TimeUnit.DAYS.convert(datediff, TimeUnit.MILLISECONDS);

		String physicianCategory = getPhysicianCategory(physicianId);

		if ("GEN".equals(physicianCategory)) {
			bill = 1250 * (int) days;
		} else if ("ENT".equals(physicianCategory)) {
			bill = 1500 * (int) days;
		} else if ("NEU".equals(physicianCategory)) {
			bill = 1750 * (int) days;
		} else {
			throw new PatientInformationDetailsException(
					"Invalid physician category code. physicianCategory="
							+ physicianCategory);
		}
		return bill;

	}

	private String getPhysicianCategory(String physicianId) {
		return physicianId.substring(physicianId.indexOf("-") + 1,
				physicianId.length());
	}

	private void setNoOfPatientsToPhysicianCategory(
			Map<String, Integer> mapPhysicianCat, String type) {
		Integer noOfPhysicians = mapPhysicianCat.get(type);
		if (noOfPhysicians != null) {
			int totalNo = noOfPhysicians.intValue();
			noOfPhysicians = new Integer(++totalNo);
		} else {
			noOfPhysicians = new Integer(1);
		}
		//Set tjhe value to the map
		mapPhysicianCat.put(type, noOfPhysicians);
	}

	private void initializePhysicianCategoryToPatientMap(
			Map<String, Integer> mapPhysicianCat) {
		mapPhysicianCat.put("GEN", 0);
		mapPhysicianCat.put("ENT", 0);
		mapPhysicianCat.put("NEU", 0);
	}
}

/**
 * VO class supplied part of the Skeleton. Do not modify this class
 * 
 */
class PatientVO {
	private String name;
	private String mrn;
	private String gender;
	private String physicianId;
	private Date admissionDate;
	private Date dischargeDate;
	private int bill;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the mrn
	 */
	public String getMrn() {
		return mrn;
	}

	/**
	 * @param mrn
	 *            the mrn to set
	 */
	public void setMrn(String mrn) {
		this.mrn = mrn;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the physicianId
	 */
	public String getPhysicianId() {
		return physicianId;
	}

	/**
	 * @param physicianId
	 *            the physicianId to set
	 */
	public void setPhysicianId(String physicianId) {
		this.physicianId = physicianId;
	}

	/**
	 * @return the admissionDate
	 */
	public Date getAdmissionDate() {
		return admissionDate;
	}

	/**
	 * @param admissionDate
	 *            the admissionDate to set
	 */
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	/**
	 * @return the dischargeDate
	 */
	public Date getDischargeDate() {
		return dischargeDate;
	}

	/**
	 * @param dischargeDate
	 *            the dischargeDate to set
	 */
	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	/**
	 * @return the bill
	 */
	public int getBill() {
		return bill;
	}

	/**
	 * @param bill
	 *            the bill to set
	 */
	public void setBill(int bill) {
		this.bill = bill;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PatientVO [name=");
		builder.append(name);
		builder.append(", mrn=");
		builder.append(mrn);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", physicianId=");
		builder.append(physicianId);
		builder.append(", admissionDate=");
		builder.append(admissionDate);
		builder.append(", dischargeDate=");
		builder.append(dischargeDate);
		builder.append(", bill=");
		builder.append(bill);
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
		PatientVO other = (PatientVO) object;
		if ((this.getMrn().equals(other.getMrn()))
				&& (this.getPhysicianId().equals(other.getPhysicianId()))
				&& (this.getAdmissionDate().equals(other.getAdmissionDate()))
				&& (this.getBill() == other.getBill())
				&& (this.getDischargeDate().equals(other.getDischargeDate()))) {
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
class PatientInformationDetailsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -217307602928815575L;

	public PatientInformationDetailsException(String message) {
		super(message);
	}

	public PatientInformationDetailsException(Throwable throwable) {
		super(throwable);
	}

	public PatientInformationDetailsException(String message,
			Throwable throwable) {
		super(message, throwable);
	}
}
