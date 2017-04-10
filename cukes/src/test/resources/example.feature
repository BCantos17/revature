#Example of Cucumber execution
Feature: 
  As a trainer
  I can show the flow of execution
  To exaplin thing better

  Background: Setup, like @Before
      Given: I have these objects
      | 	data 	|
      |		Hello	|
      |		World	|


  Scenario: Run scenrio once
    Given I have a precondition
    When I take this action
    Then I get this result

  Scenario Outline: Run for each example
    Given I have an example <precondition>
    When I act on it
    Then this <result> occurs

    Examples: 
      | precondition | result    |
      | "Dan"        | "Pickles" |
      | "Donald"     | "Trump"   |
