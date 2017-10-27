package helpers;

import java.util.Properties;

public class GlobalPool {
	
	private String paymentId,appURL;
	

	public GlobalPool() {
		Properties prop = new Properties();
		try {
			prop.load(GlobalPool.class.getClassLoader().getResourceAsStream("cucumber.properties"));
			setURL(prop.getProperty("ST.URL"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getURL(){
		return appURL;
	}
	public void setURL(String url) {
		this.appURL = url;
	}
	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

}
