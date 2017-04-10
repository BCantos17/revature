# Feature file .feature extension
Feature: Withdraw cash
  As as customer
  I can withdraw chas
  So I can soend too much of it

  Background: COntext for all test
    Given I have these accounts
      | accountNum | name           |
      |        555 | Dan            |
      |        777 | Howard Johnson |
      |        888 | Randolph Scoot |

  Scenario Outline: 
    Given I have an account
    And I have <balance> dollars
    When I withdraw <withdraw> dollars
    Then I have <remaining> dollars left
    
	Examples:
		| balance | withdraw  | remaining |
		| 1000		| 200				| 800				|
		| 5000		| 1000			|	4000			|
		| 3000		| 2000			| 1000			|
