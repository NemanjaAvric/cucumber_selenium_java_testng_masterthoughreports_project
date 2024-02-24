Feature:Products

  Scenario: Verify all products and product detail page
    Given I am on the Home Page
    When I go to the Products Page and verify that list of products is visible
    And I click on the View Product button of the first product and go to the Product Detail Page
    Then I verify that the details of the Product Detail Page are visible

  @P500
  Scenario Outline:Search product
    Given I am on the Home Page
    When I go to the Products Page and verify that list of products is visible
    And I search the name of the product: '<product>'
    Then I verify that the results of the search is visible

    Examples:
      | product |
      | Tshirt  |
      | Dress   |
      | Top     |
      | Shirt   |
      | Dress   |
      | Jeans   |
      | Saree   |
      | Lace    |




