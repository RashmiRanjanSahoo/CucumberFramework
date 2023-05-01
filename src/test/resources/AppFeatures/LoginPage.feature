@Login
Feature: Login Page feature

@Smoke
Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "User Login Page"

@Smoke @skip @Skip_Scenario
Scenario: Reset button display
Given user is on login page
Then reset button should be displayed

@Smoke
Scenario: Login with correct credentials
Given user is on login page
When user enters username "admin"
And user enters password "admin"
And user clicks on Login button
Then user gets the title of the page
And page title should be "Master Page"


