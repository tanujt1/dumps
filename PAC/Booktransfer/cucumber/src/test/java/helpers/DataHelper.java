package helpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import cucumber.api.DataTable;

public class DataHelper {

	private String paymentref,amount;
	
	public Map<String, String> formatData(DataTable table){
		
		HashMap<String, String> hm = new HashMap<String, String>();
		
		List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (Map<String, String> fs : data) {
			for (Entry<String, String> entry : fs.entrySet()) {
				hm.put(entry.getKey(), entry.getValue());
			}
		
		}
		return hm;		
	}
	
	public String generateID() {

		long number = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
		paymentref = "1" + number;

		return paymentref;
	}

	public String generateAmount() {
		amount = generateID().substring(8, 11);
		return amount;
	}

}
