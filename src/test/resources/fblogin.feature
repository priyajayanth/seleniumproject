@Feature1
Feature: to validate the login functionality of facebook app
@Sanity
Scenario: to validate the login functionality of facebook app
Given to launch the chrome browser and maximise
When to launch fb url
And to pass username in email field
And to pass invalid password in password field
And to click the login button
And ckeck whether navigate to homepage or not
Then to close the browser


