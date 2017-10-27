package util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class UserContext {

	private Random generator = new Random();
	
	private String userTTRand,userBKTRand,module;
	
@SuppressWarnings("serial")
Map<String,String> userTT = new HashMap<String, String>()
{
    {
        put("PM_PYMTSO_A", "Password1");
        put("PM_PYMTSO_B", "Password1");
        put("PM_PYMTSO_C", "Password1");
    }
};

@SuppressWarnings("serial")
Map<String,String> userBKT = new HashMap<String, String>()
{
    {
        put("automationuser1", "Password1");
        put("automationuser2", "Password1");
        put("automationuser3", "Password1");
    }
};


public void userModuleAssignment(String userModule) throws Exception{
	
	setModuleAssigment(userModule);
	
	if(userModule.equalsIgnoreCase("TT")){
	
		Object[] userTTKeyArray = userTT.keySet().toArray();
		String randomTTUserKey = (String) userTTKeyArray[generator.nextInt(userTTKeyArray.length)];
		String randomTTUserPwd = userTT.get(randomTTUserKey);
		
		setUserTT(randomTTUserKey+":"+randomTTUserPwd);
		 		
	}else if (userModule.equalsIgnoreCase("BKT")){
		
		Object[] userBKTKeyArray = userBKT.keySet().toArray();
		String randomBKTUserKey = (String) userBKTKeyArray[generator.nextInt(userBKTKeyArray.length)];
		String randomBKTUserPwd = userBKT.get(randomBKTUserKey);
		
		setUserBKT(randomBKTUserKey+":"+randomBKTUserPwd);
	}
	
}


public String getUserTT(){
	return userTTRand;
}

public String getUserBKT(){
	return userBKTRand;
}

public void setUserTT(String userTTdetails){
	userTTRand = userTTdetails;
}

public void setUserBKT(String userBKTdetails) {
	userBKTRand = userBKTdetails;
}

public void setModuleAssigment(String module) {
	this.module = module;
}

public String getModuleAssignment() {
	return module;
}

public void removeUserTT(String key){
	userTT.remove(key);
}

public void removeUserBKT(String key) {
	userBKT.remove(key);
}

public void addUserBKT(String bktuname,String pwd){
	userBKT.put(bktuname, pwd);
}

public void addUserTT(String ttuname,String pwd) {
	userTT.put(ttuname, pwd);
}

}