@CRM_Project
Feature: CRM Application Test


@cmr1
  Scenario: count dashlet
    Given Log in to crm with "admin" and "pa$$w0rd"
    When count the number of dashlets
    Then print the number of title and dashlets
    And close browser

@crm2
  Scenario: Creation of lead
    Given user logged in to CRM with "admin" and "pa$$w0rd"
    And user naviagte to create lead page
    When Add details with "CRMLead" and "LeadDesc"
    Then verify details are added successfully
    And Close the Browser
    
@crm3
    Scenario Outline: schedule meeting
    Given Login page with "admin" and "pa$$w0rd"
    When meeting is scheduled
    And Members are added with "<firstName>"  "<lastName>"
    Then verify meeting created successfully
    And close The browser   
    
Examples:
|firstName |lastName|
|Paul      | Sammy |     