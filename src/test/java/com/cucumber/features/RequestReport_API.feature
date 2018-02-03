Feature: As a user of CME-EDB Reporting we are validating API call of Report Request

  Scenario Outline: I am gethering information of Request Reponce
    Given As a user I am selecting <Type> type of report from Request Report
    Then I verifying <Type> all criteria
    And I verifying <Type> types report operand and its values
    Then All feature of <Type> is working good

    Examples:
    	| 	  Type     |
    	|Active Clercks|
    	|Active Members|
    	|Budget Qualify|
    	|Budget Report |
