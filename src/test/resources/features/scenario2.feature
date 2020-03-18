Feature: Cucumber Automation Demo - Mecury Site & PageFactory Model

  Background:
    Given Launch Browser Chrome in Local environment.
		Given Navigate to Home Page "http://newtours.demoaut.com/"    
@P2	
  Scenario Outline: Mercury Site - Login Data Validation 
    #Given Navigate to Home Page "http://newtours.demoaut.com/"
    When Validate Login screen
    And Login to Mercury Site using username as "<username>" and password as "<password>"
    Then Login "<status>" 
    Examples: Login Validation Test  
    	| username | password | status |
   	  | test 		 | test     | Pass |
      | mercury  | mercury  | Pass | 
   