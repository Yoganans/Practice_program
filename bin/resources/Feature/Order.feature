#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tc
Feature: To Order a T-Shirt and to update persoanl information
  

  @tc1
  Scenario Outline: To order a T-shirt in the given application
    Given User opens the application with valid <UserName> and <Password>
    And orders the Tshirt
    Then validate the ordered item in order history
    
    Examples:
    |UserName						|Password		 | 
    |someone@example.com|Password123 |

  @tc2
  Scenario: To update Personal information
    Given User opens the application with valid <UserName> and <Password>
    And updates the Personal information
    Then new new values should get updated

    
