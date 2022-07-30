@LoginFeature
Feature: Login Test

@Sanity
Scenario: Verifying Login functionality with valid credential 

	Given I Launch the browser 
	Then enter the url "https://admin-demo.nopcommerce.com/login" 
	Then enter the Email as "admin@yourstore.com" and password as "admin" 
	Then hit the login button 
	Then Dashboard page title should be "Dashboard / nopCommerce administration" 
	Then I logout from the application 
	Then I verify the login page title "Your store. Login" 
	And close the browser 
	
@Regression
Scenario Outline: Login Data Driven 

	Given I Launch the browser 
	Then enter the url "https://admin-demo.nopcommerce.com/login" 
	Then enter the Email as "<email>" and password as "<password>" 
	Then hit the login button 
	Then Dashboard page title should be "Dashboard / nopCommerce administration" 
	Then I logout from the application 
	Then I verify the login page title "Your store. Login" 
	And close the browser 
	
	
Examples:
		|    email            | password |
		| admin@yourstore.com | admin    |
		| admin@yourstore.com | admin123 |
