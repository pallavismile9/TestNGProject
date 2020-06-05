Feature: Tek Portal Application Feature

Scenario: Tek Login Scenario
Given Browser is launched
Given User is on the Login Page
When User enters username and password
Then User clicks LoginButton
Then User is on homepage