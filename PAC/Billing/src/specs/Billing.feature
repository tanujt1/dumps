#-------------------------------------------------------------------------
#Epic : Billing implementation in OPEE
#Description : https://confluence.service.anz/pages/viewpage.action?pageId=197689438
#Description : https://confluence.service.anz/display/CONTBOS/Billing-+Payments
#=========================================================================
Feature: Only bill eligible transactions

  #Business rule : Only bill eligible transactions
  #=========================================================================
  @PACP2-2209 @OPEE
  Scenario: Valid transaction states are selected for billing
    Given the following batch of single payments have been received with a batch Id of '10'
      | payment_item_number | payment_status       | payment_amount | payment_type |end_status_date
      |                   1 | Paid                 |           5000 | Transfer     |
      |                   2 | Approver Rejected    |           6000 | IMT          |
      |                   3 | Returned             |           2000 | RTGS         |
      |                   4 | Rejected             |          80000 | Bill Payment |
      |                   5 | Pending CBS Response |          40000 | Transfer     |
      |                   6 | Pending Date         |           2000 | IMT          |
      |                   7 | Stopped              |             10 | Bill Payment |
      |                   8 | Pending Clearing     |          30000 | RTGS         |
      |                   9 | Pending Accounting   |          20000 | IMT          |
      |                  10 | Insufficient Funds   |           5000 | Bill Payment |
    When the billing extract is run
    Then the billing file will only contain transactions one of the following states "Paid" "Returned" "Rejected"
      | Payment Id 	|
      | "10.0001"   |
      | "10.0003"   |
      | "10.0004"   |

  @PACP2-2209 @OPEE
  Scenario: Valid payment types are selected for billing
    Given the following single payments have been received
      | Payment Id | Payment Type |
      |          1 | Transfer     |
      |          2 | IMT          |
      |          3 | RTGS         |
      |          4 | Bill Payment |
      |          5 | DE           |
    When the billing extract is run
    Then the billing file will only contain transactions one of the following Payment Types "Transfer" "IMT" "RTGS","Bill Payment"
      | Payment Id |
      |          1 |
      |          2 |
      |          3 |
      |          4 |

  #-------------------------------------------------------------------------
  @PACP2-2210 @OPEE
  Scenario: Valid debit account country payments are selected for billing
    Given the following single payments have been received
      | Payment Id | Jurisdiction | Amount | Payment Type |
      |          1 | NZ           |   5000 | Transfer     |
      |          2 | AU           |   6000 | IMT          |
      |          3 | AU           |   2000 | RTGS         |
      |          4 | China        |  80000 | Bill Payment |
      |          5 | China        |  40000 | Transfer     |
    When the billing extract is run
    Then the billing file will only contain transactions from the "AU" jurisdiction
      | Payment Id |
      |          2 |
      |          3 |

  #-------------------------------------------------------------------------
  @PACP2-2210 @OPEE
  Scenario: Valid transaction amount should be greater than zero
    Given the following single payments have been received
      | Payment Id |       | Amount       | Payment Type |
      |          1 |  5000 | Transfer     |              |
      |          2 |     0 | IMT          |              |
      |          3 |  -500 | RTGS         |              |
      |          4 |     0 | Bill Payment |              |
      |          5 | 40000 | Transfer     |              |
    When the billing extract is run
    Then the billing file will only contain transactions with an amount greater than zero
      | Payment Id |
      |          1 |
      |          5 |

  #-------------------------------------------------------------------------
  @PACP2-2210 @OPEE
  Scenario: Eligible transactions are selected for billing based on the system date
    Given the following single payments have been received
      | Payment Id | Payment Status | End Status Date |
      |          1 | Paid           | 13/10/2998      |
      |          2 | Returned       | 12/10/2998      |
      |          3 | Rejected       | 10/10/2998      |
      |          4 | Paid           | 12/10/2998      |
    And the last successful extract run was on date '11/10/2998'
    When the billing extract is run on date "14/10/2998"
    Then the billing file will only contain the following transactions
      | Payment Id |
      |     1	|
      |		2 	|
      |     4 	|

  #-------------------------------------------------------------------------
  @PACP2-2210 @OPEE
  Scenario: Eligible transactions are selected for billing based on the provided date
    Given the following single payments have been received
      | Payment Id | Payment Status | End Status Date |
      |          1 | Paid           | 13/10/2998      |
      |          2 | Returned       | 12/10/2998      |
      |          3 | Rejected       | 10/10/2998      |
      |          4 | Paid           | 12/10/2998      |
    When the billing extract is run for "13/10/2998"
    Then the billing file will only contain transactions for the provided date
      | Payment Id |
      |          1 |

  #-------------------------------------------------------------------------
  @PACP2-2210 @OPEE
  Scenario: Generate single payment extract with no transactions
    Given the following single payments have been received
      | Payment Id | Payment Status       | Amount | Payment Type |
      |          2 | Approver Rejected    |   6000 | IMT          |
      |          5 | Pending CBS Response |  40000 | Transfer     |
      |          6 | Pending Date         |   2000 | IMT          |
      |          7 | Stopped              |     10 | Bill Payment |
      |          8 | Pending Clearing     |  30000 | RTGS         |
      |          9 | Pending Accounting   |  20000 | IMT          |
      |         10 | Insufficient Funds   |   5000 | Bill Payment |
    When the billing extract is run
    Then the "single" payment extract generated will not contain any transactions
    And will contain headers and trailers

  @PACP2-2210 @OPEE
  Scenario: Generate single payment extract every calendar day
    Given the following single payments have been received
      | Payment Id | Payment Status | Amount | end_status_date |
      |          1 | Paid           |   6000 | 05/05/2013      |
      |          2 | Returned       |  40000 | 05/05/2013      |
      |          3 | Rejected       |   2000 | 05/05/2013      |
    When the billing extract is run
    Then the "single" payment extract will be generated
    
    
#=========================================================================
#Business rule : Billing data enrichment
#=========================================================================
@PACP2-2263 @OPEE
Scenario: Generate Billing Event Codes for INTL Payments
	Given the following batch of single payments have been received with batchId of 5
      | payment_Id | payment_type	| beneficiary_bank 	| amount	|charge_bearer	|end_status_date	|
      |          1 | INTL           |  	CATHAY_BANK		|6000	 	|	OUR			|05/05/2013			|   
      |          2 | INTL           |  	ANZ				|6000	 	|	OUR			|05/05/2013			|    
      |          3 | INTL   	    |  	CATHAY_BANK		|40000 		| 	BEN			|05/05/2013			|    
    When the billing extract is run on '06/05/2013'
    Then the "single" payment extract will contain the following data
        |payment_id	|source_system_activity_type	|
        |	5.0000001	|	00010125				|
        |	5.0000001	| 	00010112				|
        |	5.0000002	|	00010112				|      
        |	5.0000003	| 	00010112				|
    
   @PACP2-2263 @OPEE
Scenario: Generate Billing Event Codes for Transfer Payments
	Given the following batch of single payments have been received with batchId of 5
      | payment_Id | payment_type	| debit_currency 	| credit_currency	|	amount	|end_status_date	|
      |          1 | Transfer       |  	AUD						AUD			|6000	 	|	OUR			|05/05/2013			|   
      |          2 | Transfer           |  	NZD				|6000	 	|	OUR			|05/05/2013			|    
      |          3 | Transfer   	    |  	USD	|40000 		| 	BEN			|05/05/2013			|    
    When the billing extract is run on '06/05/2013'
    Then the "single" payment extract will contain the following data
        |payment_id	|source_system_activity_type	|
        |	5.0000001	|	00010125				|
        |	5.0000001	| 	00010112				|
        |	5.0000002	|	00010112				|      
        |	5.0000003	| 	00010112				|
    
    BBC
    
    
@TBOS    
#=========================================================================
#Business rule : Billing data enrichment
#=========================================================================
    
    
    
