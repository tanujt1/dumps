package helpers;

import org.openqa.selenium.WebDriver;


public class SharedDriver {
	private static WebDriver REAL_DRIVER;
	private static boolean initialized = false;
	
    static {
    	  
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				try {
				  	REAL_DRIVER.close();
		            REAL_DRIVER.quit();
					Log.info("Driver is closed");
				} catch (Exception e) {
					System.out.println("Driver is closed in Exception , Driver Instance :" + REAL_DRIVER + "Ex. Message:"
							+ e.getMessage());
				}
			}
		});
    
    }

    public SharedDriver() {
    
    	if(!initialized){
    		System.out.println("Inside shared driver init.....");
    		REAL_DRIVER = WebDriverFactory.create();
    		REAL_DRIVER.manage().deleteAllCookies();
        	REAL_DRIVER.manage().window().maximize();
    		initialized = true;
    	}

    }
    
    public WebDriver getDriver(){
    	return REAL_DRIVER;
    }
    
}