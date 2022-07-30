Feature: Add new customer

Scenario: Adding a new customer

	Given when user on the login page
	When user enters email as "admin@yourstore.com" and password as "admin" 
	Then user click on login button
	Then user can view the Dashboard page title as "Dashboard / nopCommerce administration"
	When user click on Customermenu
	When user click on AddCustomer menu item 
	And user click on Add new button
	When user can view the Add new customer page and can see title "Customers / nopCommerce administration"
	When user enters the customer info
	And click on save button
	Then user can view the confirmation message "The new customer added successfully."
	And close the browser 