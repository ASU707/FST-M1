@Job_Board_Project
Feature: Job Board Application Test

@UC_01 
Scenario: Create a new User
    Given User is on Admin Page
    When User adds a new User
    Then New User gets added
    And Close the browser
    
@UC_02   
Scenario: Search and Apply for a Job
    Given User is on Job Page
    When User searches for a Full Time Job
    Then User Applies for the Job
    And Close the Job Listing browser

@UC_03 
Scenario: Post a Job without Example Table
    Given User is on Post Job Page
    When User enters details for Job with "BDDJobNew85@Cucumber.in" and "BDDJobNew85Cucumber" and "BDDJobNew85Cucumber Description" and "https://BDDJob85Cucumber/application/webpages/jobs" and "Private BDD Company Ltd" 
    Then User Creates and Verifies the Job with "BDDJob_AACucumber" 
    And Close the Job Listing Verification browser

@UC_04
Scenario Outline: Post a Job with Example Table
    Given With Example User is on Post Job Page
    When With Example User enters details for Job with "<email>" and "<jobTitle>" and "<description>" and "<applicationURL>" and "<companyName>" 
    Then With Example User Creates and Verifies the Job with "<jobTitle>" 
    And With Example Close the Job Listing Verification browser


Examples:
|email                        |jobTitle                 | description                        | applicationURL                                  | companyName             |
|BDDJobExample83@Cucumber.in    | BDDJobExample83_Cucumber  | BDDJobExample83_Cucumber Description | https://bddjobExample83/application/webpages/jobs | Private BDD Company Ltd |
 
 