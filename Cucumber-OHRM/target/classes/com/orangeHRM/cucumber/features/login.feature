Feature: OrangeHRM - Login

Background:
Given Open the browser and launch OrangeHRM application using 'https://opensource-demo.orangehrmlive.com'

@Regression @Smoke
Scenario Outline: Verify the login to OrangeHRM application with valid credentials
Given Enter username as <username>
And Enter password as <password>
When Click on Submit button
Then Verify the Dashboard page is Loaded.

Examples:
|username|password|
|'Admin'|'admin123'|


@Smoke
Scenario: Verify the login to OrangeHRM application with valid username and no password
And Enter username as 'Admin'
When Click on Submit button
But Verify the "required" message in the login page.

@Regression
Scenario: Verify the login to OrangeHRM application with invalid username and invalid password
And Enter username as 'Admin1'
And Enter password as 'dummy'
When Click on Submit button
But Verify the error message in the login page.
