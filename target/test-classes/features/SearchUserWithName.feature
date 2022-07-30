Feature: Searching with First and Last name

Scenario Outline: Verify if user can search with Fisrt and last name

	Given user is on login page
	Then user login with "<email>" and password as "<password>"
	When user click on Customers Menu
	When user click on Customers option
	Then user can see the Customer Page title
	Then user enter the firstname as "Victoria" and last name as "Terces"
	And user click on search button
	Then user verify the user record




Examples:
| email | password |
| admin@yourstore.com | admin |
