
Feature: Login
Scenario: Successful of Login
Given user is on the login page
When user enters username as <"Username"> and password as <"Password">  and click login button
Then user click logout
Example:
|Username|Password|
|standard_user|secret_sauce|
|problem_user|secret_sauce|
