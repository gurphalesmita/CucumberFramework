@regression
Feature: login functionality

Background:
Given user should be on login page

@TC01
Scenario: valid_login_TC01
When user enters valid credentials
And click on login button
Then user should be on home page
And user can see logout option

@sanity @hello
Scenario: valid_login_TC02
When user enters valid credentials user id "<userid>" and password "<password>"
|TCID |userid | password |
|TC03|admin1 | pwd1|
|TC04|admin2 | pwd2 |
And click on login button

@smoke
Scenario Outline: valid_login_<TCID>
When user enters valid credentials user id as "<userid>" and password as "<password>"
And click on login button
Examples:
|TCID |userid | password |
|TC03|admin1 | pwd1|
|TC04|admin2 | pwd2 |


@TC06
Scenario: valid_login_with_Theme_TC06
When user enters valid credentials along with theme
And click on login button
Then user should be on home page
And user can see logout option




