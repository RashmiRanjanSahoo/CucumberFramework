@Registration
Feature: Registration page
Background:
 Given User is already logged in to the application
 |username|password|
 |admin|admin|

@Smoke 
Scenario: Registration page title
Given User is on the registration page
When user gets the title of the page
Then page title should be "Permanent Registration"

@Smoke
Scenario: valid Header content
Given User is on the registration page
When user gets the header of the page
Then Header should be "Mahesh Hospital Management System"

@Smoke @Skip_Scenario
Scenario: validate patient category options
Given User is on the registration page
Then user get all the options of patient category
|Select |
|Pay Patient|
|Self|
|Staff|
|Insurance|
|Staff Dependent|
And patient category count should be 5
