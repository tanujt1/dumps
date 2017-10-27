package util;

import cucumber.runtime.java.picocontainer.PicoFactory;

import helpers.GlobalPool;
import helpers.SharedDriver;


public class CustomPicoFactory extends PicoFactory{
	
	public CustomPicoFactory() {
		
		addClass(UserContext.class);
		addClass(SharedDriver.class);
		addClass(GlobalPool.class);

	}
	
}
