package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import com.github.ffpojo.FFPojoHelper;
import com.github.ffpojo.exception.FFPojoException;


public class AdvantageFeeFile{
	
	private String fileName;
	private AdvantageFeeTrailer trailer;

	public AdvantageFeeFile(String fileName){
		this.fileName = fileName;
		try {
			ReadFile();
		} catch (FFPojoException | IOException e) {			
			e.printStackTrace();
		}
	}
	public AdvantageFeeFile(){}	
	private AdvantageFeeHeader header;
	private ArrayList<AdvantageFeePayment> payments = new ArrayList<AdvantageFeePayment>();
		
	public ArrayList<AdvantageFeePayment> getPayments(){
		return payments;
	}
	
	public void setPayments(ArrayList<AdvantageFeePayment>newPayments){
		payments = newPayments;
	}
	
	
	public AdvantageFeeHeader getHeader(){
		return this.header;
	}
	
	public void setHeader(AdvantageFeeHeader newHeader){
		header = newHeader;
	}
	
	public void setTrailer(AdvantageFeeTrailer newTrailer){
		trailer = newTrailer;
	}
	
	public AdvantageFeeTrailer getTrailer(){
		return trailer;
	}
	
	public void ReadFile() throws FFPojoException, IOException{
		FFPojoHelper ffpojo = FFPojoHelper.getInstance();
		BufferedReader textFileReader = new BufferedReader( new InputStreamReader(getClass().getClassLoader().getResourceAsStream(this.fileName)));
		String line;
		String nextLine;
		boolean headerParsed = false;
		line = textFileReader.readLine();
		while (line!= null) {
			if(!headerParsed)
			{
				this.setHeader(ffpojo.createFromText(AdvantageFeeHeader.class, line));				
				headerParsed = true;
			}
			else{
				line = textFileReader.readLine();
				nextLine = textFileReader.readLine();
				if(nextLine!=null){					
					AdvantageFeePayment payment = ffpojo.createFromText(AdvantageFeePayment.class, line);				
					this.payments.add(payment);
					payment = ffpojo.createFromText(AdvantageFeePayment.class, nextLine);				
					this.payments.add(payment);
				}
				else{
					this.setTrailer(ffpojo.createFromText(AdvantageFeeTrailer.class, line));				
					break;
				}				
			}								
		}
		textFileReader.close();	
	}
	
	
}
