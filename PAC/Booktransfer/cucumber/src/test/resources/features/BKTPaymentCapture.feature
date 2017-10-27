@OPEE_TT_Payment_Creation @ST
Feature: Telegraphic Transfer scenarios
  
		@PACP2-1878 @Java
    Scenario: Create a BKT payment and verify transaction status
    Given a valid "BKT" Payment Authorizer 
    When Authorizer key in credentials to login OPEE     
    And Authorizer create a BKT payment
    
    |	  debitAcctId			| 	creditAcctId		|	
    | 	600882CNY00001	|		158055CNY00001	|	  
   
    Then verify the transaction status as "Pending Accounting" 
    And  sign out from opee
    
    @PACP2-1879 @Java
    Scenario: Create a BKT payment and verify transaction status
    Given a valid "BKT" Payment Authorizer 
    When Authorizer key in credentials to login OPEE     
    And Authorizer create a BKT payment
    
    |	  debitAcctId			| 	creditAcctId		|	
    | 	600882CNY00001	|		158055CNY00001	|	  
   
    Then verify the transaction status as "Pending Accounting" 
    And  sign out from opee
    