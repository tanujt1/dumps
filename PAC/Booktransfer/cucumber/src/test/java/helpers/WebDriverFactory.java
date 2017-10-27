package helpers;

import static java.lang.String.format;
import static java.lang.System.getProperty;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {
	
	
    public WebDriverFactory() {

    }

    static WebDriver create() {
        String webDriverProperty = getProperty("browserType");
        
        System.out.println("Inside webdriver factory create.....");

        if (webDriverProperty == null || webDriverProperty.isEmpty()) {
            throw new IllegalStateException("The webdriver system property must be set");
        }

        try {
        	System.setProperty("webdriver.chrome.driver","C:\\NotBackedUp\\selenium-2.53.0\\chrome\\chromedriver.exe");
            return Drivers.valueOf(webDriverProperty.toUpperCase()).newDriver();
        } catch (IllegalArgumentException e) {
            String msg = format("The webdriver system property '%s' did not match any " +
                    "existing browser or the browser was not supported on your operating system. " +
                    "Valid values are %s",
                webDriverProperty, stream(Drivers
                    .values())
                    .collect(toList()));

            throw new IllegalStateException(msg, e);
        }
    }

    private enum Drivers {
        FIREFOX {
            @Override
            public WebDriver newDriver() {
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                return new FirefoxDriver(capabilities);
            }
        }, CHROME {
            @Override
            public WebDriver newDriver() {
            	/*System.setProperty("webdriver.chrome.driver", "C:\\NotBackedUp\\selenium-2.53.0\\chrome\\chromedriver.exe");
        		ChromeOptions chromeOptions = new ChromeOptions();
        		chromeOptions.setBinary("d:\\OPEE_Automation\\Google\\Chrome\\Application\\chrome.exe");
        		chromeOptions.addArguments("--start-maximized");
        		DesiredCapabilities chromeCapability = new DesiredCapabilities().chrome();
        		chromeCapability.setJavascriptEnabled(true);
        		chromeCapability.setBrowserName("chrome");
        		chromeCapability.setPlatform(Platform.WINDOWS);
        		chromeCapability.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        		chromeCapability.setCapability("profile.default_content_settings.popups", 0);
        		
        		try {
        			driver = new RemoteWebDriver(new URL("http://appau601mel5042.globaltest.anz.com:4444/wd/hub"), chromeCapability);
        		} catch (MalformedURLException e) {
        			e.printStackTrace();
        		}*/
            	
            	System.setProperty("webdriver.chrome.driver",getProperty("driverLocation"));
            	ChromeOptions chromeOptions = new ChromeOptions();
        		chromeOptions.addArguments("--start-maximized");
        		DesiredCapabilities chromeCapability = new DesiredCapabilities().chrome();
        		chromeCapability.setJavascriptEnabled(true);
        		chromeCapability.setBrowserName("chrome");
        		chromeCapability.setPlatform(Platform.WINDOWS);
        		chromeCapability.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        		chromeCapability.setCapability("profile.default_content_settings.popups", 0);
                 return new ChromeDriver(chromeCapability);
            }
        },IE {
            @Override
            public WebDriver newDriver() {
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                return new InternetExplorerDriver(capabilities);
            }
        }; 

       public abstract org.openqa.selenium.WebDriver newDriver();

    }
}