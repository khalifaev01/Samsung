Feature: Search and filter functionalities test

  @smoke
Scenario: Filter review page with descending order
  Given user navigates to homepage
  And user searches for an "Item"
  And user selects mobile accessories from left filter tab
  And user scrolls down to the page and selects one of the last three items
  And user navigates to the review page by selecting the review button
  And user filters the review rates by descending order
  Then user should be able to see highest review rate in the first order

