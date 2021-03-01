Feature: Login feature of eComm Application
Scenario: Verify the Homepage
Given Open the Browser "Chrome"
When User enter URL "http://automationpractice.com/index.php"
Then Homepage should be displayed
And Free CRM helps any business large or small 

Scenario: Fill the form by data Entry
Given I am landed on the Account Creation Page
When  fill the form basing on the input from dataGenerator

Scenario: Create Account in eComm Application
Given Homepage is already displayed 
When User enter userName password "kanchansrs15@gmail.com" in "newuser@123"
And Click on Login Button
Then User Logged in Successfully should be displayed 
And User Name displayed on the Top of the Page "Kanchan Kumari"
Scenario: Login to eComm Application
Given Click on Signout and resignIn "kanchansrs5@gmail.com" in "newuser@123"
When  Click on Contacts and Click on New 
Then and fill the first and second Name "Kanchan" in "Kumari"

Scenario: Add a Product to Cart and verify till the payment page
Given Click on Women and Add product
When  Add to cart  
Then Verify till the payment Page


