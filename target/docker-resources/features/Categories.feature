Feature: Categories dropwdown scenarios


  Scenario Outline:Searching Hand Tools by Category
    Given I am on the Home Page
    When I click on the Categories button and pick Hand Tools Category
    And Pick '<category>' Category
    Then only <number> '<items>' should appear on page and nothing else

    Examples:
      | category    | number | items        |
      | Hammer      | 7      | Hammers      |
      | Hand Saw    | 1      | Hand Saws    |
      | Wrench      | 3      | Wrenches     |
      | Screwdriver | 2      | Screwdrivers |
      | Pilers      | 5      | Pilers       |
      | Chisels     | 3      | Chisels      |
      | Measures    | 4      | Measures     |


