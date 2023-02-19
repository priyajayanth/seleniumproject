@Feature1
Feature: To validate the account creation in fb app
@Smoke
Scenario: To create new account
Given To launch the chrome browser and maximise window
When To launch the url of the facebook application
And To click create new account button
And To pass firstname in firstname box
|selenium|python|java|selenium|cucumber|
And To pass secondname in secondname box
|secondname1|sam|
|secondname2|george|
|secondname3|jim|
|secondname4|ian|
|secondname5|stefen|
And to pass email or mobile no in emailbox
|email|email2|email3|
|abcd@gmail.com|efgh@gmail.com|ijkl@gmail.com|
|inmakes@gmail.com|cucumber@gmail.com|junits@gmail.com|
|awed@gmail.com|sddh@gmail.com|uihk@gmail.com|
And to create new password
|password1|password2|password3|
|1232|4561|7891|
|1011|1213|1415|
|1617|1819|2021|
Then to close browser
 