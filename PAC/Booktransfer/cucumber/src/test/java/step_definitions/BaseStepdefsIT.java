package step_definitions;

import action.OpeeLoginAction;
import util.UserContext;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.GlobalPool;
import helpers.SharedDriver;


public class BaseStepdefsIT {

	   private OpeeLoginAction opeeLoginAction;
	   private final UserContext userContext;
	   private final SharedDriver driver;
	   private final GlobalPool globalPool;

	   	   
	   public BaseStepdefsIT(UserContext context,SharedDriver driver,GlobalPool pool){
		   System.out.println("Initialized ....");
		   this.userContext = context;
		   this.driver = driver;
		   this.globalPool = pool;
	   }
	   
	   @Given("^a valid \"([^\"]*)\" Payment Authorizer$")
	   public void a_valid_Payment_Authrizor(String userModule) throws Throwable {
		    userContext.userModuleAssignment(userModule);
		    opeeLoginAction = new OpeeLoginAction(driver,userContext,globalPool);

	    }
	   
	   @When("^Authorizer key in credentials to login OPEE$")
	   public void authorizer_key_in_credentials_to_login_OPEE() throws Throwable {

	    	opeeLoginAction.SignIn();
	    }
	   
		@Then("^sign out from opee$")
	    public void sign_out() throws Throwable {

			opeeLoginAction.SignOut();
	       
	    }
}
