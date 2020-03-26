Feature: Create a Case as a Business User
  As a Standard User of the Query Manager App
  I should be able to login to Salesforce
  So that I can log a query


  @TagsDemo
  Scenario: Create a Case as a Business User
    Given "System Administrator" logs into salesforce and is in the "Cases" App
   # When Business User creates a new case
    #  | Case Origin | Phone                                       |
     # | Subject     | This is a Test Case Created from Phone Call |
    #Then Business User sees that a case is created


  @TagsDemoNotExecute
  Scenario: Create a Case as a Business User Second Scenario Test
    Given "System Administrator" logs into salesforce and is in the "Cases" App
   # When Business User creates a new case
   #   | Case Origin | Phone                                                       |
    #  | Subject     | This is a Test Case Created from Phone Call Second Scenario |
   # Then Business User sees that a case is created