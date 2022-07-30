Feature: Search User

Scenario: Search user with Email
	Given user is on loginpage
	When user login with email as "admin@yourstore.com" and password as "admin"
	Then user can view the dashboardpage
	When user click on Customer menu
	When user click on customer option
	Then User can view Customer page and title as "Customers / nopCommerce administration"
	When user enter the email id as "victoria_victoria@nopCommerce.com"
	Then user click on search button
	And user can see the user record with email "victoria_victoria@nopCommerce.com" 
